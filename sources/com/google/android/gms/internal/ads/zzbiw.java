package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbiw implements zzdwb<zzbob> {
    private final zzbiv zzfec;
    private final zzdwo<Set<zzbqs<zzbog>>> zzfed;

    public zzbiw(zzbiv zzbiv, zzdwo<Set<zzbqs<zzbog>>> zzdwo) {
        this.zzfec = zzbiv;
        this.zzfed = zzdwo;
    }

    public static zzbob zza(zzbiv zzbiv, Set<zzbqs<zzbog>> set) {
        return (zzbob) zzdwh.zza(zzbiv.zza(set), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfec, (Set) this.zzfed.get());
    }
}
