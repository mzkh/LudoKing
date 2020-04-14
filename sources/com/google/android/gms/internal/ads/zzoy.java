package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzoy implements Runnable {
    private final /* synthetic */ zzil zzahc;
    private final /* synthetic */ zzov zzbjg;

    zzoy(zzov zzov, zzil zzil) {
        this.zzbjg = zzov;
        this.zzahc = zzil;
    }

    public final void run() {
        this.zzbjg.zzbjf.zze(this.zzahc);
    }
}
