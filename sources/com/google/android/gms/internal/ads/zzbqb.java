package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbqb implements zzdwb<Set<zzbqs<zzbog>>> {
    private final zzbpn zzfhv;

    private zzbqb(zzbpn zzbpn) {
        this.zzfhv = zzbpn;
    }

    public static zzbqb zzq(zzbpn zzbpn) {
        return new zzbqb(zzbpn);
    }

    public static Set<zzbqs<zzbog>> zzr(zzbpn zzbpn) {
        return (Set) zzdwh.zza(zzbpn.zzage(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzr(this.zzfhv);
    }
}
