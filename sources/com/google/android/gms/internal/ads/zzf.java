package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzf implements Runnable {
    private final /* synthetic */ zzq zzp;
    private final /* synthetic */ zzc zzq;

    zzf(zzc zzc, zzq zzq2) {
        this.zzq = zzc;
        this.zzp = zzq2;
    }

    public final void run() {
        try {
            this.zzq.zzb.put(this.zzp);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
