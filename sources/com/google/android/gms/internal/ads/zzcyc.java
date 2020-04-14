package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcyc implements Runnable {
    private final zzcxy zzgly;
    private final zzcxp zzglz;

    zzcyc(zzcxy zzcxy, zzcxp zzcxp) {
        this.zzgly = zzcxy;
        this.zzglz = zzcxp;
    }

    public final void run() {
        zzcxy zzcxy = this.zzgly;
        zzcxy.zzglr.zzglp.zzb(this.zzglz);
    }
}
