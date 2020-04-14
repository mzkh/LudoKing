package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzckj implements Runnable {
    private final zzcvr zzfea;
    private final zzcvz zzfom;
    private final zzckg zzgac;
    private final zzcgf zzgad;

    zzckj(zzckg zzckg, zzcvz zzcvz, zzcvr zzcvr, zzcgf zzcgf) {
        this.zzgac = zzckg;
        this.zzfom = zzcvz;
        this.zzfea = zzcvr;
        this.zzgad = zzcgf;
    }

    public final void run() {
        zzckg zzckg = this.zzgac;
        zzcke.zzc(this.zzfom, this.zzfea, this.zzgad);
    }
}
