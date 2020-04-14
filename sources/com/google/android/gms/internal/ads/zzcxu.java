package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcxu {
    private final E zzgll;
    private final List<zzddi<?>> zzglq;
    private final /* synthetic */ zzcxs zzglr;

    private zzcxu(zzcxs zzcxs, E e, List<zzddi<?>> list) {
        this.zzglr = zzcxs;
        this.zzgll = e;
        this.zzglq = list;
    }

    public final <O> zzcxy<O> zzb(Callable<O> callable) {
        zzddd zzh = zzdcy.zzh(this.zzglq);
        zzddi zza = zzh.zza(zzcxt.zzgfh, zzaxn.zzdwn);
        zzcxs zzcxs = this.zzglr;
        zzcxy zzcxy = new zzcxy(zzcxs, this.zzgll, null, zza, this.zzglq, zzh.zza(callable, zzcxs.zzfoa), null);
        return zzcxy;
    }
}
