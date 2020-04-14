package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbsa implements zzdwb<Set<zzbqs<zzbna>>> {
    private final zzdwo<zzbsz> zzfdd;
    private final zzbrx zzfin;

    private zzbsa(zzbrx zzbrx, zzdwo<zzbsz> zzdwo) {
        this.zzfin = zzbrx;
        this.zzfdd = zzdwo;
    }

    public static zzbsa zza(zzbrx zzbrx, zzdwo<zzbsz> zzdwo) {
        return new zzbsa(zzbrx, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(this.zzfin.zza((zzbsz) this.zzfdd.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
