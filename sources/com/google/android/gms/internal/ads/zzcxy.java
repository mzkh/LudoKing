package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcxy<O> {
    private final E zzgll;
    @Nullable
    private final String zzglm;
    private final List<zzddi<?>> zzglq;
    final /* synthetic */ zzcxs zzglr;
    private final zzddi<?> zzglu;
    private final zzddi<O> zzglv;

    private zzcxy(zzcxs zzcxs, E e, String str, zzddi<?> zzddi, List<zzddi<?>> list, zzddi<O> zzddi2) {
        this.zzglr = zzcxs;
        this.zzgll = e;
        this.zzglm = str;
        this.zzglu = zzddi;
        this.zzglq = list;
        this.zzglv = zzddi2;
    }

    public final zzcxy<O> zzgi(String str) {
        zzcxy zzcxy = new zzcxy(this.zzglr, this.zzgll, str, this.zzglu, this.zzglq, this.zzglv);
        return zzcxy;
    }

    public final <O2> zzcxy<O2> zzb(zzcxn<O, O2> zzcxn) {
        return zza(new zzcxx(zzcxn));
    }

    public final <O2> zzcxy<O2> zza(zzdcj<O, O2> zzdcj) {
        return zza(zzdcj, (Executor) this.zzglr.zzfoa);
    }

    private final <O2> zzcxy<O2> zza(zzdcj<O, O2> zzdcj, Executor executor) {
        zzcxy zzcxy = new zzcxy(this.zzglr, this.zzgll, this.zzglm, this.zzglu, this.zzglq, zzdcy.zzb(this.zzglv, zzdcj, executor));
        return zzcxy;
    }

    public final <O2> zzcxy<O2> zzb(zzddi<O2> zzddi) {
        return zza((zzdcj<O, O2>) new zzcya<O,O2>(zzddi), (Executor) zzaxn.zzdwn);
    }

    public final <T extends Throwable> zzcxy<O> zza(Class<T> cls, zzcxn<T, O> zzcxn) {
        return zza(cls, (zzdcj<T, O>) new zzcxz<T,O>(zzcxn));
    }

    public final <T extends Throwable> zzcxy<O> zza(Class<T> cls, zzdcj<T, O> zzdcj) {
        zzcxs zzcxs = this.zzglr;
        zzcxy zzcxy = new zzcxy(zzcxs, this.zzgll, this.zzglm, this.zzglu, this.zzglq, zzdcy.zzb(this.zzglv, cls, zzdcj, zzcxs.zzfoa));
        return zzcxy;
    }

    public final zzcxy<O> zza(long j, TimeUnit timeUnit) {
        zzcxs zzcxs = this.zzglr;
        zzcxy zzcxy = new zzcxy(zzcxs, this.zzgll, this.zzglm, this.zzglu, this.zzglq, zzdcy.zza(this.zzglv, j, timeUnit, zzcxs.zzfcx));
        return zzcxy;
    }

    public final zzcxp<E, O> zzant() {
        E e = this.zzgll;
        String str = this.zzglm;
        if (str == null) {
            str = this.zzglr.zzv(e);
        }
        zzcxp<E, O> zzcxp = new zzcxp<>(e, str, this.zzglv);
        this.zzglr.zzglp.zza(zzcxp);
        this.zzglu.addListener(new zzcyc(this, zzcxp), zzaxn.zzdwn);
        zzdcy.zza(zzcxp, new zzcyb(this, zzcxp), zzaxn.zzdwn);
        return zzcxp;
    }

    public final zzcxy<O> zzw(E e) {
        return this.zzglr.zza(e, (zzddi<I>) zzant());
    }

    /* synthetic */ zzcxy(zzcxs zzcxs, Object obj, String str, zzddi zzddi, List list, zzddi zzddi2, zzcxr zzcxr) {
        this(zzcxs, obj, null, zzddi, list, zzddi2);
    }
}
