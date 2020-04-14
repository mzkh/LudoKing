package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcaf implements zzdwb<zzbqs<zzbnm>> {
    private final zzdwo<zzcaa> zzfdd;
    private final zzcac zzfra;

    private zzcaf(zzcac zzcac, zzdwo<zzcaa> zzdwo) {
        this.zzfra = zzcac;
        this.zzfdd = zzdwo;
    }

    public static zzcaf zza(zzcac zzcac, zzdwo<zzcaa> zzdwo) {
        return new zzcaf(zzcac, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (zzbqs) zzdwh.zza(new zzbqs((zzcaa) this.zzfdd.get(), zzaxn.zzdwm), "Cannot return null from a non-@Nullable @Provides method");
    }
}
