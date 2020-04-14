package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbpz implements zzdwb<Set<zzbqs<zzbnj>>> {
    private final zzbpn zzfhv;

    private zzbpz(zzbpn zzbpn) {
        this.zzfhv = zzbpn;
    }

    public static zzbpz zzo(zzbpn zzbpn) {
        return new zzbpz(zzbpn);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(this.zzfhv.zzagk(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
