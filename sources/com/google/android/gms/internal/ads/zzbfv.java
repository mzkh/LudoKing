package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbfv implements zzcmy {
    private zzbmk zzelq;
    private final /* synthetic */ zzbfa zzerq;
    private zzcnc zzezp;

    private zzbfv(zzbfa zzbfa) {
        this.zzerq = zzbfa;
    }

    public final zzcmz zzado() {
        zzdwh.zza(this.zzelq, zzbmk.class);
        zzdwh.zza(this.zzezp, zzcnc.class);
        zzbfy zzbfy = new zzbfy(this.zzerq, this.zzezp, new zzbli(), new zzcbx(), this.zzelq, new zzcxa(), null, null);
        return zzbfy;
    }

    @Deprecated
    public final /* synthetic */ zzcmy zzf(zzbpn zzbpn) {
        zzdwh.checkNotNull(zzbpn);
        return this;
    }

    public final /* synthetic */ zzcmy zza(zzcnc zzcnc) {
        this.zzezp = (zzcnc) zzdwh.checkNotNull(zzcnc);
        return this;
    }

    public final /* synthetic */ zzcmy zzf(zzbmk zzbmk) {
        this.zzelq = (zzbmk) zzdwh.checkNotNull(zzbmk);
        return this;
    }
}
