package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzayz implements Runnable {
    private final /* synthetic */ zzayw zzdyr;
    private final /* synthetic */ boolean zzdyu;

    zzayz(zzayw zzayw, boolean z) {
        this.zzdyr = zzayw;
        this.zzdyu = z;
    }

    public final void run() {
        this.zzdyr.zzd("windowVisibilityChanged", "isVisible", String.valueOf(this.zzdyu));
    }
}
