package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcxw {
    private final E zzgll;
    private final /* synthetic */ zzcxs zzglr;

    private zzcxw(zzcxs zzcxs, E e) {
        this.zzglr = zzcxs;
        this.zzgll = e;
    }

    public final <O> zzcxy<O> zzb(zzddi<O> zzddi) {
        zzcxy zzcxy = new zzcxy(this.zzglr, this.zzgll, null, zzcxs.zzglo, Collections.emptyList(), zzddi, null);
        return zzcxy;
    }

    public final <O> zzcxy<O> zzc(Callable<O> callable) {
        return zza(callable, this.zzglr.zzfoa);
    }

    private final <O> zzcxy<O> zza(Callable<O> callable, zzddl zzddl) {
        zzcxy zzcxy = new zzcxy(this.zzglr, this.zzgll, null, zzcxs.zzglo, Collections.emptyList(), zzddl.zzd(callable), null);
        return zzcxy;
    }

    public final zzcxy<?> zza(zzcxq zzcxq, zzddl zzddl) {
        return zza((Callable<O>) new zzcxv<O>(zzcxq), zzddl);
    }
}
