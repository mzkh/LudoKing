package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzccw implements Callable {
    private final zzccx zzftp;
    private final zzape zzftq;

    zzccw(zzccx zzccx, zzape zzape) {
        this.zzftp = zzccx;
        this.zzftq = zzape;
    }

    public final Object call() {
        return this.zzftp.zzd(this.zzftq);
    }
}
