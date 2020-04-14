package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzagr implements Runnable {
    private final zzagm zzcyy;
    private final String zzcyz;

    zzagr(zzagm zzagm, String str) {
        this.zzcyy = zzagm;
        this.zzcyz = str;
    }

    public final void run() {
        this.zzcyy.zzcu(this.zzcyz);
    }
}
