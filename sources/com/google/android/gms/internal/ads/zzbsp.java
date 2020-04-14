package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbsp implements zzdwb<zzbsm> {
    private final zzdwo<zzboo> zzesr;
    private final zzdwo<zzbqo> zzeyg;

    private zzbsp(zzdwo<zzboo> zzdwo, zzdwo<zzbqo> zzdwo2) {
        this.zzesr = zzdwo;
        this.zzeyg = zzdwo2;
    }

    public static zzbsp zzi(zzdwo<zzboo> zzdwo, zzdwo<zzbqo> zzdwo2) {
        return new zzbsp(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzbsm((zzboo) this.zzesr.get(), (zzbqo) this.zzeyg.get());
    }
}
