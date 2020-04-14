package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcjw implements Runnable {
    private final zzcab zzfyk;

    private zzcjw(zzcab zzcab) {
        this.zzfyk = zzcab;
    }

    static Runnable zza(zzcab zzcab) {
        return new zzcjw(zzcab);
    }

    public final void run() {
        this.zzfyk.zzajm();
    }
}
