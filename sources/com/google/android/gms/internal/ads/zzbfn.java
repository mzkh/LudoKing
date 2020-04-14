package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbfn implements zzbsr {
    private zzbmk zzelq;
    private final /* synthetic */ zzbfa zzerq;
    private zzbpn zzerr;
    private zzcle zzewq;

    private zzbfn(zzbfa zzbfa) {
        this.zzerq = zzbfa;
    }

    /* renamed from: zzadf */
    public final zzbso zzace() {
        zzdwh.zza(this.zzerr, zzbpn.class);
        zzdwh.zza(this.zzelq, zzbmk.class);
        zzdwh.zza(this.zzewq, zzcle.class);
        zzbfq zzbfq = new zzbfq(this.zzerq, new zzbli(), new zzcws(), new zzbmf(), new zzcbx(), this.zzerr, this.zzelq, new zzcxa(), this.zzewq, null, null, null);
        return zzbfq;
    }

    public final /* synthetic */ zzbsr zzb(zzcle zzcle) {
        this.zzewq = (zzcle) zzdwh.checkNotNull(zzcle);
        return this;
    }

    public final /* synthetic */ zzbsr zzd(zzbmk zzbmk) {
        this.zzelq = (zzbmk) zzdwh.checkNotNull(zzbmk);
        return this;
    }

    public final /* synthetic */ zzbsr zzd(zzbpn zzbpn) {
        this.zzerr = (zzbpn) zzdwh.checkNotNull(zzbpn);
        return this;
    }
}
