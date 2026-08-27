/**
 * Copyright 2026  Nikita S. <nikita@saraeff.net>
 * <p>
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

package com.evildayz.code.telegraher;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;
import org.telegram.messenger.ApplicationLoader;
import org.telegram.messenger.BuildVars;

public class ThePenisStuck {
    public static String getVendor() {
        if (true) return BuildVars.BUILD_VENDOR;
        return getVendor(ApplicationLoader.applicationContext.getPackageName());
    }

    public static String getVendor(String packageName) {
        String vendor;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            try {
                vendor = ApplicationLoader.applicationContext.getPackageManager().getInstallSourceInfo(packageName).getInstallingPackageName();
            } catch (PackageManager.NameNotFoundException e) {
                vendor = BuildVars.BUILD_VENDOR;
            }
        } else {
            vendor = ApplicationLoader.applicationContext.getPackageManager().getInstallerPackageName(packageName);
        }
        return TextUtils.isEmpty(vendor) ? BuildVars.BUILD_VENDOR : vendor;
    }

    public static String getConfigPatch(long userId) {
        return String.format("/data/user/%d/%s/files", userId, BuildVars.BUILD_DUROV_TG);
    }

    public static String modConfigPatch(String configPath) {
        return configPath.replace(BuildVars.BUILD_GRAHER, BuildVars.BUILD_DUROV);
    }


    public static String mrHangman(int tries) {
        if (tries >= BuildVars.KABOOM_PIN_FAILS) return "\uD83D\uDCA3";
        if (tries < BuildVars.KABOOM_PIN_FAILS - 6) return "\uD83D\uDC37\uD83D\uDC6E\u200D♂️";
        String[] hangman = new String[]{
                """
 +--+
 |  |
    |
    |
    |
    |
=====""",
                """
 +--+
 |  |
 O  |
    |
    |
    |
=====""",
                """
 +--+
 |  |
 O  |
 |  |
    |
    |
=====""",
                """
 +--+
 |  |
 O  |
/|  |
    |
    |
====="""
                , """
 +--+
 |  |
 O  |
/|\\ |
    |
    |
====="""
                ,
                """
 +--+
 |  |
 O  |
/|\\ |
/   |
    |
====="""
                , """
 +--+
 |  |
 O  |
/|\\ |
/ \\ |
    |
====="""
        };
        return hangman[tries - BuildVars.KABOOM_PIN_FAILS + 6];
    }

    public static void gimmeRopeAndFindATree(Context context, int tries) {
        TextView tv = new TextView(context);
        tv.setText(mrHangman(tries));
        tv.setTypeface(Typeface.MONOSPACE);
        tv.setGravity(Gravity.START);
        tv.setTextColor(Color.WHITE);
        tv.setBackgroundColor(Color.parseColor("#CC000000"));
        tv.setPadding(24, 16, 24, 16);

        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(tv);
        toast.show();
    }

    public static void kaboomPIG(Context context, int fails) {
        gimmeRopeAndFindATree(context, fails);
        if (fails >= BuildVars.KABOOM_PIN_FAILS)
            ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).clearApplicationUserData();
    }
}
