package org.telegram.messenger;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.ServiceCompat;

import org.telegram.messenger.web.R;
import org.telegram.tgnet.TL_smsjobs;
import org.telegram.ui.LaunchActivity;

import java.util.concurrent.ConcurrentHashMap;

public class SMSJobsNotification extends Service {

    private static final ConcurrentHashMap<Integer, SMSJobsNotification> instance = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Integer, Intent> service = new ConcurrentHashMap<>();

    public int currentAccount;
    public boolean shown;

    public SMSJobsNotification() {
        super();
    }

    public static boolean check() {
        if (true) return false;
        boolean shown = false;
        for (int i : SharedConfig.activeAccounts) {
            shown = check(i) || shown;
        }
        return shown;
    }

    public static boolean check(int currentAccount) {
        boolean showNotification = ApplicationLoader.mainInterfacePaused;
        if (showNotification) {
            showNotification = MessagesController.getInstance(currentAccount).smsjobsStickyNotificationEnabled;
        }
        if (showNotification) {
            SMSJobController c = SMSJobController.getInstance(currentAccount);
            showNotification = c.getState() == SMSJobController.STATE_JOINED && c.currentStatus != null;
        }

        SMSJobsNotification running = instance.get(currentAccount);
        final boolean shownNow = running != null && running.shown;
        if (shownNow != showNotification) {
            if (showNotification) {
                Intent intent = new Intent(ApplicationLoader.applicationContext, SMSJobsNotification.class);
                intent.putExtra("account", currentAccount);
                service.put(currentAccount, intent);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    ApplicationLoader.applicationContext.startForegroundService(intent);
                } else {
                    ApplicationLoader.applicationContext.startService(intent);
                }
            } else {
                Intent intent = service.remove(currentAccount);
                if (intent != null) {
                    ApplicationLoader.applicationContext.stopService(intent);
                }
            }
        } else if (shownNow) {
            running.update();
        }
        return showNotification;
    }

    @Override
    public void onDestroy() {
        shown = false;
        instance.remove(currentAccount, this);
        service.remove(currentAccount);
        super.onDestroy();
        try {
            stopForeground(true);
        } catch (Throwable ignore) {}
        try {
            NotificationManagerCompat.from(ApplicationLoader.applicationContext).cancel(38);
        } catch (Throwable ignore) {}
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private NotificationCompat.Builder builder;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        currentAccount = intent.getIntExtra("account", UserConfig.selectedAccount);

        SMSJobsNotification prev = instance.put(currentAccount, this);
        if (prev != null && prev != this) {
            prev.stopSelf();
        }
        shown = true;

        if (builder == null) {
            NotificationsController.checkOtherNotificationsChannel();
            builder = new NotificationCompat.Builder(ApplicationLoader.applicationContext, NotificationsController.OTHER_NOTIFICATIONS_CHANNEL);
            builder.setSmallIcon(R.drawable.left_sms);
            builder.setWhen(System.currentTimeMillis());
            builder.setChannelId(NotificationsController.OTHER_NOTIFICATIONS_CHANNEL);

            Intent openIntent = new Intent(ApplicationLoader.applicationContext, LaunchActivity.class);
            openIntent.setData(Uri.parse("tg://settings/premium_sms"));
            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, openIntent, PendingIntent.FLAG_IMMUTABLE);
            builder.setContentIntent(pendingIntent);
        }
        builder.setContentTitle(LocaleController.getString(R.string.SmsNotificationTitle));
        TL_smsjobs.TL_smsjobs_status status = SMSJobController.getInstance(currentAccount).currentStatus;
        final int sent = status != null ? status.recent_sent : 0;
        final int all = status != null ? status.recent_sent + status.recent_remains : 100;
        builder.setContentText(LocaleController.formatString(R.string.SmsNotificationSubtitle, sent, all));
        builder.setProgress(all, sent, false);
        try {
            startForeground(38, builder.build());
        } catch (Throwable e) {
            FileLog.e(e);
        }
        AndroidUtilities.runOnUIThread(this::updateNotify);
        return Service.START_NOT_STICKY;
    }

    public void update() {
        if (builder != null) {
            builder.setContentTitle(LocaleController.getString(R.string.SmsNotificationTitle));
            TL_smsjobs.TL_smsjobs_status status = SMSJobController.getInstance(currentAccount).currentStatus;
            final int sent = status != null ? status.recent_sent : 0;
            final int all = status != null ? status.recent_sent + status.recent_remains : 100;
            builder.setContentText(LocaleController.formatString(R.string.SmsNotificationSubtitle, sent, all));
            builder.setProgress(all, sent, false);
        }
        updateNotify();
    }

    private void updateNotify() {
        if (builder == null) return;
        try {
            NotificationManagerCompat.from(ApplicationLoader.applicationContext).notify(38, builder.build());
        } catch (Throwable e) {
            FileLog.e(e);
        }
    }
}
