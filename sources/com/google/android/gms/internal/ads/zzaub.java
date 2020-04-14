package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaub implements Runnable {
    private final /* synthetic */ zzauc zzdrx;

    zzaub(zzauc zzauc) {
        this.zzdrx = zzauc;
    }

    public final void run() {
        this.zzdrx.thread = Thread.currentThread();
        this.zzdrx.zzsx();
    }
}
