package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbma implements zzdwb<zzbqs<zzo>> {
    private final zzdwo<zzble> zzfdd;
    private final zzbmb zzfgn;

    private zzbma(zzbmb zzbmb, zzdwo<zzble> zzdwo) {
        this.zzfgn = zzbmb;
        this.zzfdd = zzdwo;
    }

    public static zzbma zza(zzbmb zzbmb, zzdwo<zzble> zzdwo) {
        return new zzbma(zzbmb, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzble) this.zzfdd.get(), zzaxn.zzdwn), "Cannot return null from a non-@Nullable @Provides method");
    }
}
