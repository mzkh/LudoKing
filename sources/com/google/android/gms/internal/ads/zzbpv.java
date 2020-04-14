package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbpv implements zzdwb<Set<zzbqs<zzbpg>>> {
    private final zzbpn zzfhv;

    private zzbpv(zzbpn zzbpn) {
        this.zzfhv = zzbpn;
    }

    public static zzbpv zzl(zzbpn zzbpn) {
        return new zzbpv(zzbpn);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
