package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzaii implements Runnable {
    private final zzaij zzdap;
    private final zzaha zzdaq;

    zzaii(zzaij zzaij, zzaha zzaha) {
        this.zzdap = zzaij;
        this.zzdaq = zzaha;
    }

    public final void run() {
        zzaij zzaij = this.zzdap;
        zzaha zzaha = this.zzdaq;
        zzaij.zzdar.zzczv.zzh(zzaha);
        zzaha.destroy();
    }
}
