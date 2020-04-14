package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcsv implements Callable {
    private final zzcsw zzghc;

    zzcsv(zzcsw zzcsw) {
        this.zzghc = zzcsw;
    }

    public final Object call() {
        zzcsw zzcsw = this.zzghc;
        return new zzcst(zzcsw.zzghd.zzf(zzcsw.zzlk));
    }
}
