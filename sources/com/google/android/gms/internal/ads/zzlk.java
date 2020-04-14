package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzlk implements Runnable {
    private final /* synthetic */ zzli zzazs;

    zzlk(zzli zzli) {
        this.zzazs = zzli;
    }

    public final void run() {
        if (!this.zzazs.zzaei) {
            this.zzazs.zzbaf.zza(this.zzazs);
        }
    }
}
