package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbcq implements Runnable {
    private final int zzdtk;
    private final int zzdtl;
    private final boolean zzefh;
    private final boolean zzefi;
    private final zzbco zzehk;

    zzbcq(zzbco zzbco, int i, int i2, boolean z, boolean z2) {
        this.zzehk = zzbco;
        this.zzdtk = i;
        this.zzdtl = i2;
        this.zzefh = z;
        this.zzefi = z2;
    }

    public final void run() {
        this.zzehk.zzb(this.zzdtk, this.zzdtl, this.zzefh, this.zzefi);
    }
}
