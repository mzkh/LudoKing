package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzhl implements Runnable {
    private final /* synthetic */ zzhj zzahd;
    private final /* synthetic */ String zzahg;
    private final /* synthetic */ long zzahh;
    private final /* synthetic */ long zzahi;

    zzhl(zzhj zzhj, String str, long j, long j2) {
        this.zzahd = zzhj;
        this.zzahg = str;
        this.zzahh = j;
        this.zzahi = j2;
    }

    public final void run() {
        this.zzahd.zzahe.zza(this.zzahg, this.zzahh, this.zzahi);
    }
}
