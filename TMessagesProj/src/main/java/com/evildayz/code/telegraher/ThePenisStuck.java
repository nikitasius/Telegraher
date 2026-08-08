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

import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
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
        return configPath;
    }

    public static String modConfigPatch2(String configPath) {
        return configPath.replaceAll(BuildVars.BUILD_GRAHER + ".\\w+", BuildVars.BUILD_DUROV_TG);
    }
}
