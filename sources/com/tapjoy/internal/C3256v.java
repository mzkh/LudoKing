package com.tapjoy.internal;

import android.os.SystemClock;

/* renamed from: com.tapjoy.internal.v */
public final class C3256v {

    /* renamed from: a */
    private static String f7778a = "pool.ntp.org";

    /* renamed from: b */
    private static long f7779b = 20000;

    /* renamed from: c */
    private static volatile boolean f7780c = false;

    /* renamed from: d */
    private static volatile String f7781d;

    /* renamed from: e */
    private static volatile long f7782e;

    /* renamed from: f */
    private static volatile long f7783f;

    /* renamed from: g */
    private static volatile long f7784g;

    /* renamed from: h */
    private static volatile long f7785h;

    /* renamed from: i */
    private static volatile long f7786i;

    static {
        String str = "System";
        m7567a(false, str, System.currentTimeMillis(), SystemClock.elapsedRealtime(), Long.MAX_VALUE);
    }

    /* renamed from: a */
    private static synchronized void m7567a(boolean z, String str, long j, long j2, long j3) {
        synchronized (C3256v.class) {
            f7780c = z;
            f7781d = str;
            f7782e = j;
            f7783f = j2;
            f7784g = j3;
            f7785h = f7782e - f7783f;
            f7786i = (SystemClock.elapsedRealtime() + f7785h) - System.currentTimeMillis();
        }
    }

    /* renamed from: a */
    public static boolean m7568a() {
        String str = f7778a;
        long j = f7779b;
        C3108gk gkVar = new C3108gk();
        if (!gkVar.mo30187a(str, (int) j)) {
            return false;
        }
        m7567a(true, "SNTP", gkVar.f7343a, gkVar.f7344b, gkVar.f7345c / 2);
        return true;
    }

    /* renamed from: b */
    public static long m7569b() {
        return SystemClock.elapsedRealtime() + f7785h;
    }

    /* renamed from: a */
    public static long m7566a(long j) {
        return j + f7785h;
    }

    /* renamed from: c */
    public static boolean m7570c() {
        return f7780c;
    }
}
