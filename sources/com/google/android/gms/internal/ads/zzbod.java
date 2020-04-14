package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbod implements zzdwb<zzbob> {
    private final zzdwo<Set<zzbqs<zzbog>>> zzfed;

    private zzbod(zzdwo<Set<zzbqs<zzbog>>> zzdwo) {
        this.zzfed = zzdwo;
    }

    public static zzbod zzk(zzdwo<Set<zzbqs<zzbog>>> zzdwo) {
        return new zzbod(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzbob((Set) this.zzfed.get());
    }
}
