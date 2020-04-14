package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzpd implements Runnable {
    private final /* synthetic */ zzil zzahj;
    private final /* synthetic */ zzov zzbjg;

    zzpd(zzov zzov, zzil zzil) {
        this.zzbjg = zzov;
        this.zzahj = zzil;
    }

    public final void run() {
        this.zzahj.zzfy();
        this.zzbjg.zzbjf.zzf(this.zzahj);
    }
}
