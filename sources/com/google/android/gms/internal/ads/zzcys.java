package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcys implements Runnable {
    private final String zzcyz;
    private final zzcyp zzgna;

    zzcys(zzcyp zzcyp, String str) {
        this.zzgna = zzcyp;
        this.zzcyz = str;
    }

    public final void run() {
        this.zzgna.zzgk(this.zzcyz);
    }
}
