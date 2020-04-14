package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbpq implements zzdwb<Set<zzbqs<zzbnm>>> {
    private final zzbpn zzfhv;

    private zzbpq(zzbpn zzbpn) {
        this.zzfhv = zzbpn;
    }

    public static zzbpq zzg(zzbpn zzbpn) {
        return new zzbpq(zzbpn);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
