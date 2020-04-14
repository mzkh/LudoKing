package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbhc implements zzdwb<zzbhd> {
    private final zzdwo<zzcyp> zzepi;
    private final zzdwo<zzcvz> zzfbg;
    private final zzdwo<zzcvr> zzfbh;

    private zzbhc(zzdwo<zzcvz> zzdwo, zzdwo<zzcvr> zzdwo2, zzdwo<zzcyp> zzdwo3) {
        this.zzfbg = zzdwo;
        this.zzfbh = zzdwo2;
        this.zzepi = zzdwo3;
    }

    public static zzbhc zza(zzdwo<zzcvz> zzdwo, zzdwo<zzcvr> zzdwo2, zzdwo<zzcyp> zzdwo3) {
        return new zzbhc(zzdwo, zzdwo2, zzdwo3);
    }

    public final /* synthetic */ Object get() {
        return new zzbhd((zzcvz) this.zzfbg.get(), (zzcvr) this.zzfbh.get(), (zzcyp) this.zzepi.get());
    }
}
