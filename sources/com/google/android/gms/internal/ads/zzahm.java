package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzahm implements Runnable {
    private final zzahn zzczq;
    private final zzdf zzczr;
    private final zzaie zzczs;

    zzahm(zzahn zzahn, zzdf zzdf, zzaie zzaie) {
        this.zzczq = zzahn;
        this.zzczr = zzdf;
        this.zzczs = zzaie;
    }

    public final void run() {
        this.zzczq.zza(this.zzczr, this.zzczs);
    }
}
