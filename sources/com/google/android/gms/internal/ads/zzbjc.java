package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbjc implements zzdwb<Set<zzbqs<zzbog>>> {
    private final zzdwo<zzbkf> zzfdd;
    private final zzbiv zzfec;

    public zzbjc(zzbiv zzbiv, zzdwo<zzbkf> zzdwo) {
        this.zzfec = zzbiv;
        this.zzfdd = zzdwo;
    }

    public static Set<zzbqs<zzbog>> zza(zzbiv zzbiv, zzbkf zzbkf) {
        return (Set) zzdwh.zza(Collections.singleton(new zzbqs(zzbkf, zzaxn.zzdwn)), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfec, (zzbkf) this.zzfdd.get());
    }
}
