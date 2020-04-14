package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbje implements zzdwb<zzbqs<zzbog>> {
    private final zzdwo<zzbkd> zzfdd;
    private final zzbiv zzfec;

    public zzbje(zzbiv zzbiv, zzdwo<zzbkd> zzdwo) {
        this.zzfec = zzbiv;
        this.zzfdd = zzdwo;
    }

    public static zzbqs<zzbog> zza(zzbiv zzbiv, zzbkd zzbkd) {
        return (zzbqs) zzdwh.zza(new zzbqs(zzbkd, zzaxn.zzdwm), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfec, (zzbkd) this.zzfdd.get());
    }
}
