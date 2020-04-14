package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbxw implements zzdwb<zzbxx> {
    private final zzdwo<String> zzfgk;
    private final zzdwo<zzbur> zzfkg;
    private final zzdwo<zzbuj> zzfpj;

    private zzbxw(zzdwo<String> zzdwo, zzdwo<zzbuj> zzdwo2, zzdwo<zzbur> zzdwo3) {
        this.zzfgk = zzdwo;
        this.zzfpj = zzdwo2;
        this.zzfkg = zzdwo3;
    }

    public static zzbxw zzj(zzdwo<String> zzdwo, zzdwo<zzbuj> zzdwo2, zzdwo<zzbur> zzdwo3) {
        return new zzbxw(zzdwo, zzdwo2, zzdwo3);
    }

    public final /* synthetic */ Object get() {
        return new zzbxx((String) this.zzfgk.get(), (zzbuj) this.zzfpj.get(), (zzbur) this.zzfkg.get());
    }
}
