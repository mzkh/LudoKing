package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbmx implements zzdwb<zzbmv> {
    private final zzdwo<Set<zzbqs<zztp>>> zzfed;

    private zzbmx(zzdwo<Set<zzbqs<zztp>>> zzdwo) {
        this.zzfed = zzdwo;
    }

    public static zzbmx zzg(zzdwo<Set<zzbqs<zztp>>> zzdwo) {
        return new zzbmx(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzbmv((Set) this.zzfed.get());
    }
}
