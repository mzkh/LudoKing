package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzhk implements Runnable {
    private final /* synthetic */ zzhj zzahd;
    private final /* synthetic */ zzgo zzahf;

    zzhk(zzhj zzhj, zzgo zzgo) {
        this.zzahd = zzhj;
        this.zzahf = zzgo;
    }

    public final void run() {
        this.zzahd.zzahe.zzb(this.zzahf);
    }
}
