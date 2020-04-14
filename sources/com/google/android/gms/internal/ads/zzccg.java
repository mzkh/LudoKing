package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzccg implements zzdwb<zzcch> {
    private final zzdwo<zzbei> zzejx;
    private final zzdwo<zzcbv> zzfrj;

    private zzccg(zzdwo<zzcbv> zzdwo, zzdwo<zzbei> zzdwo2) {
        this.zzfrj = zzdwo;
        this.zzejx = zzdwo2;
    }

    public static zzccg zzz(zzdwo<zzcbv> zzdwo, zzdwo<zzbei> zzdwo2) {
        return new zzccg(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcch((zzcbv) this.zzfrj.get(), (zzbei) this.zzejx.get());
    }
}
