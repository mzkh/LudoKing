package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcxv implements Callable {
    private final zzcxq zzgls;

    zzcxv(zzcxq zzcxq) {
        this.zzgls = zzcxq;
    }

    public final Object call() {
        this.zzgls.run();
        return null;
    }
}
