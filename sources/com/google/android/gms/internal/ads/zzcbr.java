package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcbr implements Runnable {
    private final String zzcyz;
    private final zzcbo zzfsh;

    zzcbr(zzcbo zzcbo, String str) {
        this.zzfsh = zzcbo;
        this.zzcyz = str;
    }

    public final void run() {
        this.zzfsh.zzfx(this.zzcyz);
    }
}
