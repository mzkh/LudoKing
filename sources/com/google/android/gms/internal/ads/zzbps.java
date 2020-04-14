package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbps implements zzdwb<Set<zzbqs<zzo>>> {
    private final zzbpn zzfhv;

    private zzbps(zzbpn zzbpn) {
        this.zzfhv = zzbpn;
    }

    public static zzbps zzh(zzbpn zzbpn) {
        return new zzbps(zzbpn);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
