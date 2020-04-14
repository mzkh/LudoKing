package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbqh implements zzdwb<Set<zzbqs<zzbrb>>> {
    private final zzbpn zzfhv;

    private zzbqh(zzbpn zzbpn) {
        this.zzfhv = zzbpn;
    }

    public static zzbqh zzw(zzbpn zzbpn) {
        return new zzbqh(zzbpn);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
