package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbgc implements Runnable {
    private final zzbga zzfal;
    private final Runnable zzfam;

    zzbgc(zzbga zzbga, Runnable runnable) {
        this.zzfal = zzbga;
        this.zzfam = runnable;
    }

    public final void run() {
        this.zzfal.zzd(this.zzfam);
    }
}
