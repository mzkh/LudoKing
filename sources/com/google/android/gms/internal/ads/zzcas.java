package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcas implements zzdwb<zzcaq> {
    private final zzdwo<zzcuf> zzeme;
    private final zzdwo<zzsd> zzfrj;

    private zzcas(zzdwo<zzsd> zzdwo, zzdwo<zzcuf> zzdwo2) {
        this.zzfrj = zzdwo;
        this.zzeme = zzdwo2;
    }

    public static zzcas zzs(zzdwo<zzsd> zzdwo, zzdwo<zzcuf> zzdwo2) {
        return new zzcas(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcaq((zzsd) this.zzfrj.get(), (zzcuf) this.zzeme.get());
    }
}
