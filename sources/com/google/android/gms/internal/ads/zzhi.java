package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzhi implements Runnable {
    private final /* synthetic */ zzil zzahc;
    private final /* synthetic */ zzhj zzahd;

    zzhi(zzhj zzhj, zzil zzil) {
        this.zzahd = zzhj;
        this.zzahc = zzil;
    }

    public final void run() {
        this.zzahd.zzahe.zza(this.zzahc);
    }
}
