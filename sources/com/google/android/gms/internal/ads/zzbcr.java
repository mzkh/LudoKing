package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbcr implements Runnable {
    private final String zzcyz;
    private final zzbcp zzehu;

    zzbcr(zzbcp zzbcp, String str) {
        this.zzehu = zzbcp;
        this.zzcyz = str;
    }

    public final void run() {
        this.zzehu.zzfl(this.zzcyz);
    }
}
