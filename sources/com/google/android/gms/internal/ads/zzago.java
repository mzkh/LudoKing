package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzago implements Runnable {
    private final zzagm zzcyy;
    private final String zzcyz;

    zzago(zzagm zzagm, String str) {
        this.zzcyy = zzagm;
        this.zzcyz = str;
    }

    public final void run() {
        this.zzcyy.zzcv(this.zzcyz);
    }
}
