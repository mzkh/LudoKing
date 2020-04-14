package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbyf implements zzdwb<zzbyc> {
    private final zzdwo<String> zzfgk;
    private final zzdwo<zzbur> zzfkg;
    private final zzdwo<zzbuj> zzfpj;

    private zzbyf(zzdwo<String> zzdwo, zzdwo<zzbuj> zzdwo2, zzdwo<zzbur> zzdwo3) {
        this.zzfgk = zzdwo;
        this.zzfpj = zzdwo2;
        this.zzfkg = zzdwo3;
    }

    public static zzbyf zzl(zzdwo<String> zzdwo, zzdwo<zzbuj> zzdwo2, zzdwo<zzbur> zzdwo3) {
        return new zzbyf(zzdwo, zzdwo2, zzdwo3);
    }

    public final /* synthetic */ Object get() {
        return new zzbyc((String) this.zzfgk.get(), (zzbuj) this.zzfpj.get(), (zzbur) this.zzfkg.get());
    }
}
