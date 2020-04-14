package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbja implements zzdwb<zzbio> {
    private final zzdwo<zzbiq> zzexl;
    private final zzbiv zzfec;

    public zzbja(zzbiv zzbiv, zzdwo<zzbiq> zzdwo) {
        this.zzfec = zzbiv;
        this.zzexl = zzdwo;
    }

    public static zzbio zza(zzbiv zzbiv, Object obj) {
        return (zzbio) zzdwh.zza((zzbiq) obj, "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfec, this.zzexl.get());
    }
}
