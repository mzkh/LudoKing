package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbor implements zzdwb<zzboo> {
    private final zzdwo<Set<zzbqs<zzo>>> zzfed;

    private zzbor(zzdwo<Set<zzbqs<zzo>>> zzdwo) {
        this.zzfed = zzdwo;
    }

    public static zzbor zzn(zzdwo<Set<zzbqs<zzo>>> zzdwo) {
        return new zzbor(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzboo((Set) this.zzfed.get());
    }
}
