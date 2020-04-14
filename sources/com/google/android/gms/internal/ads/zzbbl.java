package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbbl implements Runnable {
    private final boolean zzdyt;
    private final long zzebv;
    private final zzazj zzeec;

    zzbbl(zzazj zzazj, boolean z, long j) {
        this.zzeec = zzazj;
        this.zzdyt = z;
        this.zzebv = j;
    }

    public final void run() {
        this.zzeec.zza(this.zzdyt, this.zzebv);
    }
}
