package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbqa implements zzdwb<Set<zzbqs<AdMetadataListener>>> {
    private final zzbpn zzfhv;

    private zzbqa(zzbpn zzbpn) {
        this.zzfhv = zzbpn;
    }

    public static zzbqa zzp(zzbpn zzbpn) {
        return new zzbqa(zzbpn);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(this.zzfhv.zzagh(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
