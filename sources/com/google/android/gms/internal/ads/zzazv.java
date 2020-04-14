package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzazv implements Runnable {
    private final int zzdtk;
    private final int zzdtl;
    private final zzazq zzebj;

    zzazv(zzazq zzazq, int i, int i2) {
        this.zzebj = zzazq;
        this.zzdtk = i;
        this.zzdtl = i2;
    }

    public final void run() {
        this.zzebj.zzo(this.zzdtk, this.zzdtl);
    }
}
