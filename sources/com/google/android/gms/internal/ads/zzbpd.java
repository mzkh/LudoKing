package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbpd implements zzdwb<zzbpb> {
    private final zzdwo<Set<zzbqs<zzbpg>>> zzfed;

    private zzbpd(zzdwo<Set<zzbqs<zzbpg>>> zzdwo) {
        this.zzfed = zzdwo;
    }

    public static zzbpd zzo(zzdwo<Set<zzbqs<zzbpg>>> zzdwo) {
        return new zzbpd(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzbpb((Set) this.zzfed.get());
    }
}
