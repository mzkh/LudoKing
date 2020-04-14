package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbqy implements zzdwb<zzbqw> {
    private final zzdwo<Set<zzbqs<zzbrb>>> zzfed;

    private zzbqy(zzdwo<Set<zzbqs<zzbrb>>> zzdwo) {
        this.zzfed = zzdwo;
    }

    public static zzbqy zzs(zzdwo<Set<zzbqs<zzbrb>>> zzdwo) {
        return new zzbqy(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzbqw((Set) this.zzfed.get());
    }
}
