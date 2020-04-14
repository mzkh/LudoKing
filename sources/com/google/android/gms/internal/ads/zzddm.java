package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzddm implements Runnable {
    private final /* synthetic */ Runnable zzgrt;
    private final /* synthetic */ zzddn zzgru;

    zzddm(zzddn zzddn, Runnable runnable) {
        this.zzgru = zzddn;
        this.zzgrt = runnable;
    }

    public final void run() {
        this.zzgru.zzgrv = false;
        this.zzgrt.run();
    }
}
