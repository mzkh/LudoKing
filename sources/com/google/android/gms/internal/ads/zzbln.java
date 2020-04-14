package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbln implements zzdwb<zzbqs<zzbnj>> {
    private final zzbli zzfgg;
    private final zzdwo<zzblr> zzfgh;

    private zzbln(zzbli zzbli, zzdwo<zzblr> zzdwo) {
        this.zzfgg = zzbli;
        this.zzfgh = zzdwo;
    }

    public static zzbln zzd(zzbli zzbli, zzdwo<zzblr> zzdwo) {
        return new zzbln(zzbli, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzblr) this.zzfgh.get(), zzaxn.zzdwn), "Cannot return null from a non-@Nullable @Provides method");
    }
}
