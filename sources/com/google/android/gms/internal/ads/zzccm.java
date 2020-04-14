package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzccm implements Runnable {
    private final Object zzdbp;
    private final String zzfqz;
    private final zzccj zzfsr;
    private final zzaxv zzftc;
    private final long zzftd;

    zzccm(zzccj zzccj, Object obj, zzaxv zzaxv, String str, long j) {
        this.zzfsr = zzccj;
        this.zzdbp = obj;
        this.zzftc = zzaxv;
        this.zzfqz = str;
        this.zzftd = j;
    }

    public final void run() {
        this.zzfsr.zza(this.zzdbp, this.zzftc, this.zzfqz, this.zzftd);
    }
}
