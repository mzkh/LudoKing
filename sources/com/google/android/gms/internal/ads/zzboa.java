package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzboa implements zzdwb<zzbnr> {
    private final zzdwo<Set<zzbqs<zzbna>>> zzfed;

    private zzboa(zzdwo<Set<zzbqs<zzbna>>> zzdwo) {
        this.zzfed = zzdwo;
    }

    public static zzboa zzj(zzdwo<Set<zzbqs<zzbna>>> zzdwo) {
        return new zzboa(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzbnr((Set) this.zzfed.get());
    }
}
