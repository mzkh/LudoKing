package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbsf implements zzdwb<zzbqs<zzo>> {
    private final zzdwo<zzbsx> zzfdd;
    private final zzbrx zzfin;

    private zzbsf(zzbrx zzbrx, zzdwo<zzbsx> zzdwo) {
        this.zzfin = zzbrx;
        this.zzfdd = zzdwo;
    }

    public static zzbsf zzc(zzbrx zzbrx, zzdwo<zzbsx> zzdwo) {
        return new zzbsf(zzbrx, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzbsx) this.zzfdd.get(), zzaxn.zzdwn), "Cannot return null from a non-@Nullable @Provides method");
    }
}
