package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzchq implements Runnable {
    private final zzcab zzfyk;

    private zzchq(zzcab zzcab) {
        this.zzfyk = zzcab;
    }

    static Runnable zza(zzcab zzcab) {
        return new zzchq(zzcab);
    }

    public final void run() {
        this.zzfyk.zzajm();
    }
}
