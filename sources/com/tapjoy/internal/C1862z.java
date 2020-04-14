package com.tapjoy.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.z */
public final class C1862z {
    @Nullable
    /* renamed from: a */
    public static String m3701a(PackageManager packageManager, String str) {
        try {
            return packageManager.getPackageInfo(str, 0).versionName;
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static int m3700a(Context context) {
        return m3702b(context.getPackageManager(), context.getPackageName());
    }

    /* renamed from: b */
    public static int m3702b(PackageManager packageManager, String str) {
        try {
            return packageManager.getPackageInfo(str, 0).versionCode;
        } catch (NameNotFoundException unused) {
            return 0;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    public static long m3703c(PackageManager packageManager, String str) {
        if (VERSION.SDK_INT >= 9) {
            try {
                long j = packageManager.getPackageInfo(str, 0).firstInstallTime;
                if (j > 0) {
                    return j;
                }
            } catch (NameNotFoundException unused) {
            }
        }
        return 0;
    }

    /* renamed from: d */
    public static String m3704d(PackageManager packageManager, String str) {
        try {
            return C1852jq.m3668b(packageManager.getApplicationInfo(str, 0).sourceDir);
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    @Nullable
    /* renamed from: e */
    public static Signature[] m3705e(PackageManager packageManager, String str) {
        try {
            return packageManager.getPackageInfo(str, 64).signatures;
        } catch (NameNotFoundException unused) {
            return null;
        }
    }
}
