package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbrd implements zzdwb<zzbra> {
    private final zzdwo<zzcyp> zzepi;
    private final zzdwo<zzcvr> zzfbh;

    private zzbrd(zzdwo<zzcvr> zzdwo, zzdwo<zzcyp> zzdwo2) {
        this.zzfbh = zzdwo;
        this.zzepi = zzdwo2;
    }

    public static zzbrd zzh(zzdwo<zzcvr> zzdwo, zzdwo<zzcyp> zzdwo2) {
        return new zzbrd(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzbra((zzcvr) this.zzfbh.get(), (zzcyp) this.zzepi.get());
    }
}
