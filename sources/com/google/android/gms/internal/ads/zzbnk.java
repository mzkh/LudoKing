package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbnk implements zzdwb<zzbni> {
    private final zzdwo<Set<zzbqs<zzbnj>>> zzfed;

    private zzbnk(zzdwo<Set<zzbqs<zzbnj>>> zzdwo) {
        this.zzfed = zzdwo;
    }

    public static zzbnk zzh(zzdwo<Set<zzbqs<zzbnj>>> zzdwo) {
        return new zzbnk(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzbni((Set) this.zzfed.get());
    }
}
