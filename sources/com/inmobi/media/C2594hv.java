package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.inmobi.media.hv */
/* compiled from: Task */
public final class C2594hv {

    /* renamed from: a */
    private static final Object f5744a = new Object();

    /* renamed from: b */
    private final Handler f5745b;

    /* renamed from: com.inmobi.media.hv$a */
    /* compiled from: Task */
    static class C2595a {

        /* renamed from: a */
        static final C2594hv f5746a = new C2594hv(0);
    }

    /* synthetic */ C2594hv(byte b) {
        this();
    }

    private C2594hv() {
        this.f5745b = new Handler(Looper.getMainLooper());
    }

    /* renamed from: a */
    public static C2594hv m5662a() {
        return C2595a.f5746a;
    }

    /* renamed from: a */
    public final void mo28611a(Runnable runnable) {
        this.f5745b.post(runnable);
    }
}
