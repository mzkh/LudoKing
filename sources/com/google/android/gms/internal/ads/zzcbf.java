package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcbf implements zzdwb<zzcbc> {
    private final zzdwo<zzcbo> zzekq;
    private final zzdwo<zzcbl> zzemk;

    private zzcbf(zzdwo<zzcbl> zzdwo, zzdwo<zzcbo> zzdwo2) {
        this.zzemk = zzdwo;
        this.zzekq = zzdwo2;
    }

    public static zzcbf zzv(zzdwo<zzcbl> zzdwo, zzdwo<zzcbo> zzdwo2) {
        return new zzcbf(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcbc((zzcbl) this.zzemk.get(), (zzcbo) this.zzekq.get());
    }
}
