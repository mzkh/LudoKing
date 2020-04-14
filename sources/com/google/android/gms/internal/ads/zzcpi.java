package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcpi implements zzdwb<zzcpd<zzcrx>> {
    private final zzdwo<zzcsa> zzelb;
    private final zzdwo<Clock> zzfco;

    public zzcpi(zzdwo<zzcsa> zzdwo, zzdwo<Clock> zzdwo2) {
        this.zzelb = zzdwo;
        this.zzfco = zzdwo2;
    }

    public final /* synthetic */ Object get() {
        return (zzcpd) zzdwh.zza(new zzcpd((zzcsa) this.zzelb.get(), ((Long) zzuv.zzon().zzd(zzza.zzcmb)).longValue(), (Clock) this.zzfco.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
