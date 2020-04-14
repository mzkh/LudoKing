package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final /* synthetic */ class zzyz implements Callable {
    private final zzyw zzcgb;
    private final zzyp zzcgc;

    zzyz(zzyw zzyw, zzyp zzyp) {
        this.zzcgb = zzyw;
        this.zzcgc = zzyp;
    }

    public final Object call() {
        return this.zzcgb.zze(this.zzcgc);
    }
}
