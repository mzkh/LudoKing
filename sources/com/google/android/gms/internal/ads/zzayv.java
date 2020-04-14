package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzayv implements Runnable {
    private final zzayu zzdxz;

    private zzayv(zzayu zzayu) {
        this.zzdxz = zzayu;
    }

    static Runnable zza(zzayu zzayu) {
        return new zzayv(zzayu);
    }

    public final void run() {
        this.zzdxz.stop();
    }
}
