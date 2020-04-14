package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbns implements zzdwb<zzbnl> {
    private final zzdwo<Set<zzbqs<zzbnm>>> zzfed;

    private zzbns(zzdwo<Set<zzbqs<zzbnm>>> zzdwo) {
        this.zzfed = zzdwo;
    }

    public static zzbns zzi(zzdwo<Set<zzbqs<zzbnm>>> zzdwo) {
        return new zzbns(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzbnl((Set) this.zzfed.get());
    }
}
