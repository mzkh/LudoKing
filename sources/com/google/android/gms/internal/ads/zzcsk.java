package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcsk implements Runnable {
    private final zzddi zzfov;

    zzcsk(zzddi zzddi) {
        this.zzfov = zzddi;
    }

    public final void run() {
        this.zzfov.cancel(true);
    }
}
