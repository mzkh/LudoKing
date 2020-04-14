package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbsy implements zzdwb<zzbsz> {
    private final zzdwo<zzbni> zzfit;
    private final zzdwo<zzcvr> zzfiu;

    private zzbsy(zzdwo<zzbni> zzdwo, zzdwo<zzcvr> zzdwo2) {
        this.zzfit = zzdwo;
        this.zzfiu = zzdwo2;
    }

    public static zzbsy zzj(zzdwo<zzbni> zzdwo, zzdwo<zzcvr> zzdwo2) {
        return new zzbsy(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzbsz((zzbni) this.zzfit.get(), (zzcvr) this.zzfiu.get());
    }
}
