package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbom implements zzdwb<zzbok> {
    private final zzdwo<Set<zzbqs<zzbol>>> zzfed;

    private zzbom(zzdwo<Set<zzbqs<zzbol>>> zzdwo) {
        this.zzfed = zzdwo;
    }

    public static zzbom zzm(zzdwo<Set<zzbqs<zzbol>>> zzdwo) {
        return new zzbom(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzbok((Set) this.zzfed.get());
    }
}
