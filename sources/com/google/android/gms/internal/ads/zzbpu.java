package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbpu implements zzdwb<Set<zzbqs<zztp>>> {
    private final zzbpn zzfhv;

    private zzbpu(zzbpn zzbpn) {
        this.zzfhv = zzbpn;
    }

    public static zzbpu zzk(zzbpn zzbpn) {
        return new zzbpu(zzbpn);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(this.zzfhv.zzagj(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
