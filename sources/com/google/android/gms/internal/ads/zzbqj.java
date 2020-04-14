package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbqj implements zzdwb<Set<zzbqs<VideoLifecycleCallbacks>>> {
    private final zzbpn zzfhv;

    private zzbqj(zzbpn zzbpn) {
        this.zzfhv = zzbpn;
    }

    public static zzbqj zzx(zzbpn zzbpn) {
        return new zzbqj(zzbpn);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
