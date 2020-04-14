package com.tapjoy.internal;

import android.os.Looper;

/* renamed from: com.tapjoy.internal.gw */
public final class C3124gw {

    /* renamed from: a */
    public static boolean f7370a;

    /* renamed from: a */
    public static void m7216a(String str) {
        if (f7370a) {
            C1861x.m3697a(4, "Tapjoy", str, (Throwable) null);
        }
    }

    /* renamed from: a */
    public static void m7218a(String str, Object... objArr) {
        if (f7370a) {
            C1861x.m3698a(4, "Tapjoy", str, objArr);
        }
    }

    /* renamed from: b */
    public static void m7221b(String str) {
        if (f7370a) {
            C1861x.m3697a(6, "Tapjoy", str, (Throwable) null);
        }
    }

    /* renamed from: b */
    public static void m7222b(String str, Object... objArr) {
        if (f7370a) {
            C1861x.m3699a("Tapjoy", str, objArr);
        }
    }

    /* renamed from: a */
    public static void m7217a(String str, String str2, String str3) {
        if (f7370a) {
            C1861x.m3699a("Tapjoy", "{}: {} {}", str, str2, str3);
        }
    }

    /* renamed from: a */
    public static boolean m7219a(Object obj, String str) {
        if (obj != null) {
            return true;
        }
        if (f7370a) {
            m7221b(str);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m7220a(boolean z, String str) {
        if (!f7370a || z) {
            return z;
        }
        m7221b(str);
        throw new IllegalStateException(str);
    }

    /* renamed from: c */
    public static boolean m7223c(String str) {
        boolean z = Looper.myLooper() == Looper.getMainLooper();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(": Must be called on the main/ui thread");
        return m7220a(z, sb.toString());
    }
}
