package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzrz implements Runnable {
    private final zzaxv zzbrt;
    private final Future zzbru;

    zzrz(zzaxv zzaxv, Future future) {
        this.zzbrt = zzaxv;
        this.zzbru = future;
    }

    public final void run() {
        zzaxv zzaxv = this.zzbrt;
        Future future = this.zzbru;
        if (zzaxv.isCancelled()) {
            future.cancel(true);
        }
    }
}
