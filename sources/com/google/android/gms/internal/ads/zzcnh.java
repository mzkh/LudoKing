package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcnh implements zzdwb<zzddi<zzcnl>> {
    private final zzdwo<zzcyg> zzfek;
    private final zzdwo<zzddi<zzape>> zzffz;
    private final zzdwo<zzcnk> zzgdp;

    public zzcnh(zzdwo<zzcyg> zzdwo, zzdwo<zzcnk> zzdwo2, zzdwo<zzddi<zzape>> zzdwo3) {
        this.zzfek = zzdwo;
        this.zzgdp = zzdwo2;
        this.zzffz = zzdwo3;
    }

    public final /* synthetic */ Object get() {
        zzcnk zzcnk = (zzcnk) this.zzgdp.get();
        return (zzddi) zzdwh.zza(((zzcyg) this.zzfek.get()).zza(zzcyd.GENERATE_SIGNALS, (zzddi) this.zzffz.get()).zza(zzcnk).zza((long) ((Integer) zzuv.zzon().zzd(zzza.zzcrq)).intValue(), TimeUnit.SECONDS).zzant(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
