/*
 * This is the source code of Telegram for Android v. 7.x.x.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Nikolai Kudashov, 2013-2020.
 */

package org.telegram.messenger;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

public class BuildVars {

    public static boolean DEBUG_VERSION = false;
    public static boolean LOGS_ENABLED = false;
    public static boolean DEBUG_PRIVATE_VERSION = false;
    public static boolean USE_CLOUD_STRINGS = true;
    public static boolean CHECK_UPDATES = true;
    public static boolean BUILD_HOST_IS_WINDOWS = false;
    public static boolean NO_SCOPED_STORAGE = Build.VERSION.SDK_INT <= 29;
    public static int BUILD_VERSION = 6991;
    public static int BUILD_VERSION_FULL = 69919;
//    public static String BUILD_VENDOR = "com.android.vending";
//    public static String BUILD_GRAHER = "com.evildayz.code.telegraher3";
    public static String BUILD_VENDOR = "com.google.android.packageinstaller";
    public static String BUILD_DUROV = "org.telegram.messenger.web";
    public static String BUILD_DUROV_TG = "org.telegram.messenger";
    public static String BUILD_GRAHER = BUILD_DUROV_TG;
    public static String BUILD_VERSION_STRING = "12.9.2";
    public static final List<String> fuLabel=new ArrayList<>(){{
        add("Slava Ukraini");
        add("Free Palestine");
    }};

    public static int APP_ID = 4;
    public static String APP_HASH = "014b35b6184100b085b0d0572f9b5103";

    public static String PLAYSTORE_APP_URL = "https://github.com/nikitasius/Telegraher/releases";
    public static String GOOGLE_AUTH_CLIENT_ID = "760348033671-2hh8ebmuflsnjoc0kldkfells9rhtfni.apps.googleusercontent.com";

    public static String HUAWEI_APP_ID = "101184875";

    // You can use this flag to disable Google Play Billing (If you're making fork and want it to be in Google Play)
    public static boolean IS_BILLING_UNAVAILABLE = false;

    // works only on official app ids, disable on your forks
    public static boolean SUPPORTS_PASSKEYS = true;

    static {
        if (ApplicationLoader.applicationContext != null) {
            SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("systemConfig", Context.MODE_PRIVATE);
            LOGS_ENABLED = DEBUG_VERSION || sharedPreferences.getBoolean("logsEnabled", DEBUG_VERSION);
            if (LOGS_ENABLED) {
                final Thread.UncaughtExceptionHandler pastHandler = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
                    FileLog.fatal(exception, false);
                    if (pastHandler != null) {
                        pastHandler.uncaughtException(thread, exception);
                    }
                });
            }
        }
    }

    public static String gimmeFuLabel(){
        return fuLabel.get(new java.util.Random().nextInt(fuLabel.size()));
    }

    public static boolean useInvoiceBilling() {
        return false;
    }

    private static boolean hasDirectCurrency() {
        return false;
    }

    private static Boolean betaApp;
    public static boolean isBetaApp() {
        if (betaApp == null) {
            betaApp = ApplicationLoader.applicationContext != null && "org.telegram.messenger.beta".equals(ApplicationLoader.applicationContext.getPackageName());
        }
        return betaApp;
    }


    public static boolean isHuaweiStoreApp() {
        return ApplicationLoader.isHuaweiStoreBuild();
    }

    public static String getSmsHash() {
        return ApplicationLoader.isStandaloneBuild() ? "w0lkcmTZkKh" : (DEBUG_VERSION ? "O2P2z+/jBpJ" : "oLeq9AcOZkT");
    }
}
