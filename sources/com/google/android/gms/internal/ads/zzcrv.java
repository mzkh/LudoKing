package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcrv implements Callable {
    private final Object zzdbp;
    private final List zzgfv;

    zzcrv(List list, Object obj) {
        this.zzgfv = list;
        this.zzdbp = obj;
    }

    public final Object call() {
        return zzcrt.zza(this.zzgfv, this.zzdbp);
    }
}
