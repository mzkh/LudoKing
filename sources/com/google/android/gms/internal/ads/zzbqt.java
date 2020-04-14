package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbqt implements zzdwb<zzbqo> {
    private final zzdwo<Set<zzbqs<zzbqp>>> zzfed;

    private zzbqt(zzdwo<Set<zzbqs<zzbqp>>> zzdwo) {
        this.zzfed = zzdwo;
    }

    public static zzbqt zzr(zzdwo<Set<zzbqs<zzbqp>>> zzdwo) {
        return new zzbqt(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzbqo((Set) this.zzfed.get());
    }
}
