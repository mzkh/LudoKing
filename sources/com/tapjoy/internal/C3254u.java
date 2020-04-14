package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.tapjoy.internal.u */
public final class C3254u {

    /* renamed from: a */
    private static Handler f7776a;

    /* renamed from: a */
    public static synchronized Handler m7563a() {
        Handler handler;
        synchronized (C3254u.class) {
            if (f7776a == null) {
                f7776a = new Handler(Looper.getMainLooper());
            }
            handler = f7776a;
        }
        return handler;
    }

    /* renamed from: a */
    public static C2889ba m7564a(final Handler handler) {
        return new C2889ba() {
            /* renamed from: a */
            public final boolean mo29867a(Runnable runnable) {
                return handler.post(runnable);
            }
        };
    }
}
