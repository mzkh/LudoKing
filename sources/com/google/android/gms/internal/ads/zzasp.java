package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzasp implements Runnable {
    private final String zzdbt;
    private final zzasl zzdpv;
    private final zzatb zzdpw;

    zzasp(zzasl zzasl, zzatb zzatb, String str) {
        this.zzdpv = zzasl;
        this.zzdpw = zzatb;
        this.zzdbt = str;
    }

    public final void run() {
        this.zzdpv.zza(this.zzdpw, this.zzdbt);
    }
}
