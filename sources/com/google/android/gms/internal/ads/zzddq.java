package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzddq extends zzj<Void> implements Runnable {
    private final Runnable zzgsa;

    public zzddq(Runnable runnable) {
        this.zzgsa = (Runnable) zzdaq.checkNotNull(runnable);
    }

    public final void run() {
        try {
            this.zzgsa.run();
        } catch (Throwable th) {
            setException(th);
            throw zzdav.zzg(th);
        }
    }
}
