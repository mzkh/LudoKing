package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbiy implements zzdwb<zzcvu> {
    private final zzbiv zzfec;

    public zzbiy(zzbiv zzbiv) {
        this.zzfec = zzbiv;
    }

    public static zzcvu zza(zzbiv zzbiv) {
        return (zzcvu) zzdwh.zza(zzbiv.zzafd(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfec);
    }
}
