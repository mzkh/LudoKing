package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbsc implements zzdwb<zzbqs<zzbog>> {
    private final zzdwo<zzbsx> zzfdd;
    private final zzbrx zzfin;

    private zzbsc(zzbrx zzbrx, zzdwo<zzbsx> zzdwo) {
        this.zzfin = zzbrx;
        this.zzfdd = zzdwo;
    }

    public static zzbsc zzb(zzbrx zzbrx, zzdwo<zzbsx> zzdwo) {
        return new zzbsc(zzbrx, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzbsx) this.zzfdd.get(), zzaxn.zzdwn), "Cannot return null from a non-@Nullable @Provides method");
    }
}
