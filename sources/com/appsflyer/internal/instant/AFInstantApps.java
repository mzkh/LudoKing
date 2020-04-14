package com.appsflyer.internal.instant;

import android.content.Context;
import android.os.Build.VERSION;

public class AFInstantApps {
    public static boolean isInstantApp(Context context) {
        if (VERSION.SDK_INT >= 26) {
            return context.getPackageManager().isInstantApp();
        }
        try {
            context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
