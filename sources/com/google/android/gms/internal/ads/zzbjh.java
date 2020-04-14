package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbjh implements zzdwb<Set<zzbqs<zzpj>>> {
    private final zzdwo<zzbkf> zzfdd;
    private final zzbiv zzfec;

    public zzbjh(zzbiv zzbiv, zzdwo<zzbkf> zzdwo) {
        this.zzfec = zzbiv;
        this.zzfdd = zzdwo;
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(Collections.singleton(new zzbqs((zzbkf) this.zzfdd.get(), zzaxn.zzdwn)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
