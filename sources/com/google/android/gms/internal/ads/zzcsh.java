package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcsh implements Runnable {
    private final zzddi zzfoe;
    private final zzaxv zzftc;
    private final zzcsi zzggt;

    zzcsh(zzcsi zzcsi, zzddi zzddi, zzaxv zzaxv) {
        this.zzggt = zzcsi;
        this.zzfoe = zzddi;
        this.zzftc = zzaxv;
    }

    public final void run() {
        this.zzggt.zza(this.zzfoe, this.zzftc);
    }
}
