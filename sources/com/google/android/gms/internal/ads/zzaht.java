package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzaht implements Runnable {
    private final zzaha zzdad;

    private zzaht(zzaha zzaha) {
        this.zzdad = zzaha;
    }

    static Runnable zzb(zzaha zzaha) {
        return new zzaht(zzaha);
    }

    public final void run() {
        this.zzdad.destroy();
    }
}
