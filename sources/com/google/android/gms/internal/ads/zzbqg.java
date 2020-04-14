package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbqg implements zzdwb<zzcjf> {
    private final zzdwo<Clock> zzfco;
    private final zzbpn zzfhv;

    private zzbqg(zzbpn zzbpn, zzdwo<Clock> zzdwo) {
        this.zzfhv = zzbpn;
        this.zzfco = zzdwo;
    }

    public static zzbqg zzb(zzbpn zzbpn, zzdwo<Clock> zzdwo) {
        return new zzbqg(zzbpn, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzcjf) zzdwh.zza(this.zzfhv.zza((Clock) this.zzfco.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
