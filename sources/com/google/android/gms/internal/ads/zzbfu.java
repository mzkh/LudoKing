package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbfu implements zzbzf {
    private zzbmk zzelq;
    private final /* synthetic */ zzbfa zzerq;
    private zzbpn zzerr;

    private zzbfu(zzbfa zzbfa) {
        this.zzerq = zzbfa;
    }

    /* renamed from: zzadn */
    public final zzbzc zzace() {
        zzdwh.zza(this.zzerr, zzbpn.class);
        zzdwh.zza(this.zzelq, zzbmk.class);
        zzbft zzbft = new zzbft(this.zzerq, new zzbli(), new zzcws(), new zzbmf(), new zzcbx(), this.zzerr, this.zzelq, new zzcxa(), null, null, null);
        return zzbft;
    }

    public final /* synthetic */ zzbzf zze(zzbmk zzbmk) {
        this.zzelq = (zzbmk) zzdwh.checkNotNull(zzbmk);
        return this;
    }

    public final /* synthetic */ zzbzf zze(zzbpn zzbpn) {
        this.zzerr = (zzbpn) zzdwh.checkNotNull(zzbpn);
        return this;
    }
}
