package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaza implements Runnable {
    private final /* synthetic */ zzayw zzdyr;

    zzaza(zzayw zzayw) {
        this.zzdyr = zzayw;
    }

    public final void run() {
        this.zzdyr.zzd("surfaceDestroyed", new String[0]);
    }
}
