package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzpa implements Runnable {
    private final /* synthetic */ zzgo zzahf;
    private final /* synthetic */ zzov zzbjg;

    zzpa(zzov zzov, zzgo zzgo) {
        this.zzbjg = zzov;
        this.zzahf = zzgo;
    }

    public final void run() {
        this.zzbjg.zzbjf.zzk(this.zzahf);
    }
}
