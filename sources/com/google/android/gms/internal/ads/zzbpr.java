package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbpr implements zzdwb<zzbmz> {
    private final zzbpn zzfhv;
    private final zzdwo<Set<zzbqs<zzbnb>>> zzfhw;

    private zzbpr(zzbpn zzbpn, zzdwo<Set<zzbqs<zzbnb>>> zzdwo) {
        this.zzfhv = zzbpn;
        this.zzfhw = zzdwo;
    }

    public static zzbpr zza(zzbpn zzbpn, zzdwo<Set<zzbqs<zzbnb>>> zzdwo) {
        return new zzbpr(zzbpn, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzbmz) zzdwh.zza(this.zzfhv.zzc((Set) this.zzfhw.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
