package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzahf implements Runnable {
    private final String zzcyz;
    private final zzahc zzczk;

    zzahf(zzahc zzahc, String str) {
        this.zzczk = zzahc;
        this.zzcyz = str;
    }

    public final void run() {
        this.zzczk.zzcy(this.zzcyz);
    }
}
