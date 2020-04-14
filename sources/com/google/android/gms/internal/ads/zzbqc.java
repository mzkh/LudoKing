package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbqc implements zzdwb<Set<zzbqs<AppEventListener>>> {
    private final zzbpn zzfhv;

    private zzbqc(zzbpn zzbpn) {
        this.zzfhv = zzbpn;
    }

    public static zzbqc zzs(zzbpn zzbpn) {
        return new zzbqc(zzbpn);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdwh.zza(this.zzfhv.zzagi(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
