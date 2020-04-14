package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzoz implements Runnable {
    private final /* synthetic */ zzov zzbjg;
    private final /* synthetic */ int zzbjh;
    private final /* synthetic */ long zzbji;

    zzoz(zzov zzov, int i, long j) {
        this.zzbjg = zzov;
        this.zzbjh = i;
        this.zzbji = j;
    }

    public final void run() {
        this.zzbjg.zzbjf.zzf(this.zzbjh, this.zzbji);
    }
}
