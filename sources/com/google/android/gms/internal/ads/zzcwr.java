package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcwr implements zzdwb<zzbqs<zzbnb>> {
    private final zzdwo<zzcwu> zzfgh;
    private final zzcws zzgkv;

    private zzcwr(zzcws zzcws, zzdwo<zzcwu> zzdwo) {
        this.zzgkv = zzcws;
        this.zzfgh = zzdwo;
    }

    public static zzcwr zza(zzcws zzcws, zzdwo<zzcwu> zzdwo) {
        return new zzcwr(zzcws, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzcwu) this.zzfgh.get(), zzaxn.zzdwn), "Cannot return null from a non-@Nullable @Provides method");
    }
}
