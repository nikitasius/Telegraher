package org.telegram.ui.Business;

import org.telegram.messenger.*;
import org.telegram.tgnet.ConnectionsManager;
import org.telegram.tgnet.tl.TL_account;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class BusinessChatbotController {

    private static final ConcurrentHashMap<Integer, BusinessChatbotController> Instance = new ConcurrentHashMap<>();

    public static BusinessChatbotController getInstance(int num) {
        return Instance.computeIfAbsent(num, BusinessChatbotController::new);
    }

    private final int currentAccount;
    private BusinessChatbotController(int account) {
        this.currentAccount = account;
    }

    private long lastTime;
    private TL_account.connectedBots value;
    private ArrayList<Utilities.Callback<TL_account.connectedBots>> callbacks = new ArrayList<>();
    private boolean loading, loaded;

    public TL_account.connectedBots getValue() {
        return value;
    }

    public void load(Utilities.Callback<TL_account.connectedBots> callback) {
        if (callback != null) callbacks.add(callback);
        if (loading) return;
        if (System.currentTimeMillis() - lastTime > 1000 * 60 || !loaded) {
            loading = true;
            ConnectionsManager.getInstance(currentAccount).sendRequest(new TL_account.getConnectedBots(), (res, err) -> AndroidUtilities.runOnUIThread(() -> {
                loading = false;
                value = res instanceof TL_account.connectedBots ? (TL_account.connectedBots) res : null;
                if (value != null) {
                    MessagesController.getInstance(currentAccount).putUsers(value.users, false);
                }
                lastTime = System.currentTimeMillis();
                loaded = true;

                notifyUpdate();
            }));
        } else if (loaded) {
            notifyUpdate();
        }
    }

    public void notifyUpdate() {
        for (int i = 0; i < callbacks.size(); ++i) {
            if (callbacks.get(i) != null) {
                callbacks.get(i).run(value);
            }
        }
        callbacks.clear();

        NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.updatedChatbot);
    }

    public void invalidate(boolean reload) {
        loaded = false;
        if (reload) {
            load(null);
        }
    }
}
