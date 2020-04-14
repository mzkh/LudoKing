package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzox implements Runnable {
    private final /* synthetic */ String zzahg;
    private final /* synthetic */ long zzahh;
    private final /* synthetic */ long zzahi;
    private final /* synthetic */ zzov zzbjg;

    zzox(zzov zzov, String str, long j, long j2) {
        this.zzbjg = zzov;
        this.zzahg = str;
        this.zzahh = j;
        this.zzahi = j2;
    }

    public final void run() {
        this.zzbjg.zzbjf.zzd(this.zzahg, this.zzahh, this.zzahi);
    }
}
