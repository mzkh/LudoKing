package com.applovin.impl.sdk.utils;

import android.content.pm.PackageManager;

/* renamed from: com.applovin.impl.sdk.utils.j */
public class C1275j {
    /* renamed from: a */
    public static int m3020a(String str, String str2, PackageManager packageManager) {
        try {
            return packageManager.checkPermission(str, str2);
        } catch (Throwable unused) {
            return -1;
        }
    }
}
