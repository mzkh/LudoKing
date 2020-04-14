package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzagp implements Runnable {
    private final zzagm zzcyy;
    private final String zzcyz;

    zzagp(zzagm zzagm, String str) {
        this.zzcyy = zzagm;
        this.zzcyz = str;
    }

    public final void run() {
        this.zzcyy.zzcw(this.zzcyz);
    }
}
