package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbqe implements zzdwb<Set<zzbqs<zzpj>>> {
    private final zzbpn zzfhv;

    private zzbqe(zzbpn zzbpn) {
        this.zzfhv = zzbpn;
    }

    public static zzbqe zzu(zzbpn zzbpn) {
        return new zzbqe(zzbpn);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
