package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzddd<V> {
    private final boolean zzgqs;
    private final zzdbd<zzddi<? extends V>> zzgro;

    private zzddd(boolean z, zzdbd<zzddi<? extends V>> zzdbd) {
        this.zzgqs = false;
        this.zzgro = zzdbd;
    }

    public final <C> zzddi<C> zza(Callable<C> callable, Executor executor) {
        return new zzdcm(this.zzgro, this.zzgqs, executor, callable);
    }

    /* synthetic */ zzddd(boolean z, zzdbd zzdbd, zzddb zzddb) {
        this(false, zzdbd);
    }
}
