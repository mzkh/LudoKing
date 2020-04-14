package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbjx implements Runnable {
    private final Runnable zzfam;
    private final zzbjv zzfeq;

    zzbjx(zzbjv zzbjv, Runnable runnable) {
        this.zzfeq = zzbjv;
        this.zzfam = runnable;
    }

    public final void run() {
        this.zzfeq.zze(this.zzfam);
    }
}
