package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcct implements Runnable {
    private final String zzcyz;
    private final zzccq zzftm;

    zzcct(zzccq zzccq, String str) {
        this.zzftm = zzccq;
        this.zzcyz = str;
    }

    public final void run() {
        zzccq zzccq = this.zzftm;
        zzccq.zzfth.zzga(this.zzcyz);
    }
}
