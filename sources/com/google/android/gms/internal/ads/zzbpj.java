package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbpj implements zzdwb<zzbpk> {
    private final zzdwo<Set<zzbqs<Object>>> zzfed;

    private zzbpj(zzdwo<Set<zzbqs<Object>>> zzdwo) {
        this.zzfed = zzdwo;
    }

    public static zzbpj zzq(zzdwo<Set<zzbqs<Object>>> zzdwo) {
        return new zzbpj(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzbpk((Set) this.zzfed.get());
    }
}
