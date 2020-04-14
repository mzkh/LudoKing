package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbxu implements zzdwb<zzbxs> {
    private final zzdwo<zzbur> zzfkg;
    private final zzdwo<zzbuj> zzfpj;

    private zzbxu(zzdwo<zzbuj> zzdwo, zzdwo<zzbur> zzdwo2) {
        this.zzfpj = zzdwo;
        this.zzfkg = zzdwo2;
    }

    public static zzbxu zzk(zzdwo<zzbuj> zzdwo, zzdwo<zzbur> zzdwo2) {
        return new zzbxu(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzbxs((zzbuj) this.zzfpj.get(), (zzbur) this.zzfkg.get());
    }
}
