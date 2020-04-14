package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbff implements zzbih {
    private zzbmk zzelq;
    private final /* synthetic */ zzbfa zzerq;
    private zzbpn zzerr;

    private zzbff(zzbfa zzbfa) {
        this.zzerq = zzbfa;
    }

    /* renamed from: zzacp */
    public final zzbie zzace() {
        zzdwh.zza(this.zzerr, zzbpn.class);
        zzdwh.zza(this.zzelq, zzbmk.class);
        zzbfi zzbfi = new zzbfi(this.zzerq, new zzbli(), new zzcws(), new zzbmf(), new zzcbx(), this.zzerr, this.zzelq, new zzcxa(), null, null, null);
        return zzbfi;
    }

    @Deprecated
    public final /* synthetic */ zzbih zza(zzbin zzbin) {
        zzdwh.checkNotNull(zzbin);
        return this;
    }

    public final /* synthetic */ zzbih zzb(zzbmk zzbmk) {
        this.zzelq = (zzbmk) zzdwh.checkNotNull(zzbmk);
        return this;
    }

    public final /* synthetic */ zzbih zzb(zzbpn zzbpn) {
        this.zzerr = (zzbpn) zzdwh.checkNotNull(zzbpn);
        return this;
    }
}
