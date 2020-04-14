package com.gametion.cleardatalib;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Build.VERSION;

public class ClearDataNative {
    public static void ClearAll(Activity activity) {
        if (VERSION.SDK_INT >= 19) {
            ((ActivityManager) activity.getApplicationContext().getSystemService("activity")).clearApplicationUserData();
        }
    }
}
