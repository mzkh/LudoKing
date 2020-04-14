package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbju implements Runnable {
    private final AtomicReference zzfen;

    zzbju(AtomicReference atomicReference) {
        this.zzfen = atomicReference;
    }

    public final void run() {
        Runnable runnable = (Runnable) this.zzfen.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
    }
}
