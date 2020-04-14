package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzboh implements zzdwb<zzbof> {
    private final zzdwo<Set<zzbqs<AdMetadataListener>>> zzfed;

    private zzboh(zzdwo<Set<zzbqs<AdMetadataListener>>> zzdwo) {
        this.zzfed = zzdwo;
    }

    public static zzboh zzl(zzdwo<Set<zzbqs<AdMetadataListener>>> zzdwo) {
        return new zzboh(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzbof((Set) this.zzfed.get());
    }
}
