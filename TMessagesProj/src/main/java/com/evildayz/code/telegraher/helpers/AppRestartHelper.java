/**
 * This file is part of Telegraher.
 * <p>
 * Telegraher is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * Telegraher is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with Telegraher.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.evildayz.code.telegraher.helpers;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;

import org.telegram.messenger.LocaleController;
import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.BaseFragment;
import org.telegram.ui.Components.Bulletin;
import org.telegram.ui.Components.BulletinFactory;
import org.telegram.ui.LaunchActivity;

import java.util.ArrayList;
import java.util.Arrays;

public final class AppRestartHelper extends Activity {
    private static final String KEY_RESTART_INTENTS = "th_restart_intents";
    private static final String KEY_MAIN_PROCESS_PID = "th_main_process_pid";

    public static void triggerRebirth() {
        triggerRebirth(getContext(), new Intent(getContext(), LaunchActivity.class));
    }

    public static void triggerRebirth(Context context) {
        triggerRebirth(context, new Intent(context, LaunchActivity.class));
    }

    public static void triggerRebirth(Context context, Intent... nextIntents) {
        nextIntents[0].addFlags(FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK);
        Intent intent = new Intent(context, AppRestartHelper.class);
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
        intent.putParcelableArrayListExtra(KEY_RESTART_INTENTS, new ArrayList<>(Arrays.asList(nextIntents)));
        intent.putExtra(KEY_MAIN_PROCESS_PID, Process.myPid());
        context.startActivity(intent);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Process.killProcess(getIntent().getIntExtra(KEY_MAIN_PROCESS_PID, -1));
        ArrayList<Intent> intents = getIntent().getParcelableArrayListExtra(KEY_RESTART_INTENTS);
        startActivities(intents.toArray(new Intent[0]));
        finish();
        Runtime.getRuntime().exit(0);
    }

    public static void createRestartBulletin(BaseFragment fragment) {
        BulletinFactory.of(fragment).createSimpleBulletin(
                //R.raw.camera_flip,
                R.raw.info,
                LocaleController.getString("THAppRestartBulletin", R.string.THAppRestartBulletin),
                LocaleController.getString("BotUnblock", R.string.BotUnblock),
                Bulletin.DURATION_LONG,
                () -> {
                    triggerRebirth();
                }).show();
    }
}
