package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzblm implements zzdwb<zzbqs<zzbog>> {
    private final zzbli zzfgg;
    private final zzdwo<zzblr> zzfgh;

    private zzblm(zzbli zzbli, zzdwo<zzblr> zzdwo) {
        this.zzfgg = zzbli;
        this.zzfgh = zzdwo;
    }

    public static zzblm zzc(zzbli zzbli, zzdwo<zzblr> zzdwo) {
        return new zzblm(zzbli, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzblr) this.zzfgh.get(), zzaxn.zzdwn), "Cannot return null from a non-@Nullable @Provides method");
    }
}
