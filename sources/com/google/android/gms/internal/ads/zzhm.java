package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzhm implements Runnable {
    private final /* synthetic */ zzhj zzahd;
    private final /* synthetic */ zzil zzahj;

    zzhm(zzhj zzhj, zzil zzil) {
        this.zzahd = zzhj;
        this.zzahj = zzil;
    }

    public final void run() {
        this.zzahj.zzfy();
        this.zzahd.zzahe.zzb(this.zzahj);
    }
}
