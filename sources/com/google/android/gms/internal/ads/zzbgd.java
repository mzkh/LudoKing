package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbgd implements Runnable {
    private final zzbga zzfal;
    private final Runnable zzfam;

    zzbgd(zzbga zzbga, Runnable runnable) {
        this.zzfal = zzbga;
        this.zzfam = runnable;
    }

    public final void run() {
        zzaxn.zzdwm.execute(new zzbgc(this.zzfal, this.zzfam));
    }
}
