package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbpt implements zzdwb<Set<zzbqs<zzbog>>> {
    private final zzbpn zzfhv;

    private zzbpt(zzbpn zzbpn) {
        this.zzfhv = zzbpn;
    }

    public static zzbpt zzi(zzbpn zzbpn) {
        return new zzbpt(zzbpn);
    }

    public static Set<zzbqs<zzbog>> zzj(zzbpn zzbpn) {
        return (Set) zzdwh.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzj(this.zzfhv);
    }
}
