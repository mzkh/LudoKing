package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbvf implements zzdwb<zzbur> {
    private final zzbvd zzfmg;

    private zzbvf(zzbvd zzbvd) {
        this.zzfmg = zzbvd;
    }

    public static zzbvf zza(zzbvd zzbvd) {
        return new zzbvf(zzbvd);
    }

    public static zzbur zzb(zzbvd zzbvd) {
        return (zzbur) zzdwh.zza(zzbvd.zzaim(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzfmg);
    }
}
