package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbme implements zzdwb<zzbqs<zzbpc>> {
    private final zzdwo<zzbmd> zzfcs;
    private final zzbmf zzfgp;

    private zzbme(zzbmf zzbmf, zzdwo<zzbmd> zzdwo) {
        this.zzfgp = zzbmf;
        this.zzfcs = zzdwo;
    }

    public static zzbme zza(zzbmf zzbmf, zzdwo<zzbmd> zzdwo) {
        return new zzbme(zzbmf, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzbmd) this.zzfcs.get(), zzaxn.zzdwn), "Cannot return null from a non-@Nullable @Provides method");
    }
}
