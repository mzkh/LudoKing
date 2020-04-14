package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbmr implements zzdwb<zzcwe> {
    private final zzbmk zzfgv;

    private zzbmr(zzbmk zzbmk) {
        this.zzfgv = zzbmk;
    }

    public static zzbmr zzi(zzbmk zzbmk) {
        return new zzbmr(zzbmk);
    }

    public static zzcwe zzj(zzbmk zzbmk) {
        return (zzcwe) zzdwh.zza(zzbmk.zzafu(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzj(this.zzfgv);
    }
}
