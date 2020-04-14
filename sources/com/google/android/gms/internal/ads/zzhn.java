package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzhn implements Runnable {
    private final /* synthetic */ zzhj zzahd;
    private final /* synthetic */ int zzahk;
    private final /* synthetic */ long zzahl;
    private final /* synthetic */ long zzahm;

    zzhn(zzhj zzhj, int i, long j, long j2) {
        this.zzahd = zzhj;
        this.zzahk = i;
        this.zzahl = j;
        this.zzahm = j2;
    }

    public final void run() {
        this.zzahd.zzahe.zza(this.zzahk, this.zzahl, this.zzahm);
    }
}
