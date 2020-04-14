package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbke implements zzdwb<zzbkf> {
    private final zzdwo<zzcvr> zzfbh;
    private final zzdwo<zzbni> zzfew;
    private final zzdwo<zzbok> zzfex;

    private zzbke(zzdwo<zzcvr> zzdwo, zzdwo<zzbni> zzdwo2, zzdwo<zzbok> zzdwo3) {
        this.zzfbh = zzdwo;
        this.zzfew = zzdwo2;
        this.zzfex = zzdwo3;
    }

    public static zzbke zzg(zzdwo<zzcvr> zzdwo, zzdwo<zzbni> zzdwo2, zzdwo<zzbok> zzdwo3) {
        return new zzbke(zzdwo, zzdwo2, zzdwo3);
    }

    public final /* synthetic */ Object get() {
        return new zzbkf((zzcvr) this.zzfbh.get(), (zzbni) this.zzfew.get(), (zzbok) this.zzfex.get());
    }
}
