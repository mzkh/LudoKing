package com.tapjoy.internal;

import android.os.SystemClock;

/* renamed from: com.tapjoy.internal.hk */
public abstract class C3145hk {

    /* renamed from: a */
    protected static C3146a f7454a;

    /* renamed from: b */
    private static C3145hk f7455b;

    /* renamed from: com.tapjoy.internal.hk$a */
    public static class C3146a {

        /* renamed from: a */
        public final String f7456a;

        /* renamed from: b */
        public final String f7457b;

        /* renamed from: c */
        public final long f7458c = SystemClock.elapsedRealtime();

        /* renamed from: d */
        public final C3065fi f7459d = new C3065fi(60000);

        public C3146a(String str, String str2) {
            this.f7456a = str;
            this.f7457b = str2;
        }
    }

    /* renamed from: a */
    public abstract void mo30150a(C3146a aVar);

    /* renamed from: b */
    public abstract boolean mo30151b();

    /* renamed from: a */
    protected static void m7273a(C3145hk hkVar) {
        synchronized (C3145hk.class) {
            f7455b = hkVar;
            C3146a aVar = f7454a;
            if (aVar != null) {
                f7454a = null;
                hkVar.mo30150a(aVar);
            }
        }
    }

    /* renamed from: a */
    public static void m7274a(String str, String str2) {
        synchronized (C3145hk.class) {
            C3146a aVar = new C3146a(str, str2);
            if (f7455b != null) {
                f7454a = null;
                f7455b.mo30150a(aVar);
            } else {
                f7454a = aVar;
            }
        }
    }

    /* renamed from: c */
    public static boolean m7275c() {
        C3145hk hkVar = f7455b;
        if (hkVar != null && hkVar.mo30151b()) {
            return true;
        }
        C3146a aVar = f7454a;
        if (aVar == null || aVar.f7459d.mo30120a()) {
            return false;
        }
        return true;
    }
}
