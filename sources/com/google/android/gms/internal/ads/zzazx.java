package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzazx implements Runnable {
    private final int zzdtk;
    private final zzazq zzebj;

    zzazx(zzazq zzazq, int i) {
        this.zzebj = zzazq;
        this.zzdtk = i;
    }

    public final void run() {
        this.zzebj.zzcy(this.zzdtk);
    }
}
