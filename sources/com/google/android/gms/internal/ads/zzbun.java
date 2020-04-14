package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbun implements Runnable {
    private final boolean zzdyt;
    private final zzbuj zzfko;

    zzbun(zzbuj zzbuj, boolean z) {
        this.zzfko = zzbuj;
        this.zzdyt = z;
    }

    public final void run() {
        this.zzfko.zzaz(this.zzdyt);
    }
}
