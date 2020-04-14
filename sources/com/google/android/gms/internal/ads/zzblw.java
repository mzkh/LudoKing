package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzblw implements zzdwb<zzbkn> {
    private final zzdwo<zzbnl> zzeru;
    private final zzdwo<zzbob> zzesn;
    private final zzdwo<zzcvz> zzfbg;
    private final zzdwo<zzcvr> zzfes;
    private final zzdwo<String> zzfgk;

    private zzblw(zzdwo<zzcvz> zzdwo, zzdwo<zzcvr> zzdwo2, zzdwo<zzbnl> zzdwo3, zzdwo<zzbob> zzdwo4, zzdwo<String> zzdwo5) {
        this.zzfbg = zzdwo;
        this.zzfes = zzdwo2;
        this.zzeru = zzdwo3;
        this.zzesn = zzdwo4;
        this.zzfgk = zzdwo5;
    }

    public static zzblw zzb(zzdwo<zzcvz> zzdwo, zzdwo<zzcvr> zzdwo2, zzdwo<zzbnl> zzdwo3, zzdwo<zzbob> zzdwo4, zzdwo<String> zzdwo5) {
        zzblw zzblw = new zzblw(zzdwo, zzdwo2, zzdwo3, zzdwo4, zzdwo5);
        return zzblw;
    }

    public final /* synthetic */ Object get() {
        zzbkn zzbkn = new zzbkn((zzcvz) this.zzfbg.get(), (zzcvr) this.zzfes.get(), (zzbnl) this.zzeru.get(), (zzbob) this.zzesn.get(), (String) this.zzfgk.get());
        return zzbkn;
    }
}
