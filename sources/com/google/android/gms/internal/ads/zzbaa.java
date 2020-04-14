package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbaa implements Runnable {
    private final boolean zzdyt;
    private final zzazq zzebj;
    private final long zzebv;

    zzbaa(zzazq zzazq, boolean z, long j) {
        this.zzebj = zzazq;
        this.zzdyt = z;
        this.zzebv = j;
    }

    public final void run() {
        this.zzebj.zzc(this.zzdyt, this.zzebv);
    }
}
