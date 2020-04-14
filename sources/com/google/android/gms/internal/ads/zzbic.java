package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbic implements zzdwb<Set<zzbqs<zzbog>>> {
    private final zzbid zzfdc;
    private final zzdwo<zzbkf> zzfdd;

    public zzbic(zzbid zzbid, zzdwo<zzbkf> zzdwo) {
        this.zzfdc = zzbid;
        this.zzfdd = zzdwo;
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(Collections.singleton(new zzbqs((zzbkf) this.zzfdd.get(), zzaxn.zzdwn)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
