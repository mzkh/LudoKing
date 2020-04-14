package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzayy implements Runnable {
    private final zzayw zzdys;
    private final boolean zzdyt;

    zzayy(zzayw zzayw, boolean z) {
        this.zzdys = zzayw;
        this.zzdyt = z;
    }

    public final void run() {
        this.zzdys.zzan(this.zzdyt);
    }
}
