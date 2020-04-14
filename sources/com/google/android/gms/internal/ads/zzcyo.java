package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcyo implements zzdwb<zzcyf> {
    private final zzdwo<Set<zzbqs<zzcym>>> zzfed;

    private zzcyo(zzdwo<Set<zzbqs<zzcym>>> zzdwo) {
        this.zzfed = zzdwo;
    }

    public static zzcyo zzam(zzdwo<Set<zzbqs<zzcym>>> zzdwo) {
        return new zzcyo(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzcyf((Set) this.zzfed.get());
    }
}
