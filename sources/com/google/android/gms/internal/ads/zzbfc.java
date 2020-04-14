package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbfc implements zzbtk {
    private zzbmk zzelq;
    private zzbth zzelt;
    private final /* synthetic */ zzbfa zzerq;
    private zzbpn zzerr;

    private zzbfc(zzbfa zzbfa) {
        this.zzerq = zzbfa;
    }

    /* renamed from: zzacd */
    public final zzbtl zzace() {
        zzdwh.zza(this.zzerr, zzbpn.class);
        zzdwh.zza(this.zzelq, zzbmk.class);
        zzdwh.zza(this.zzelt, zzbth.class);
        zzbfb zzbfb = new zzbfb(this.zzerq, this.zzelt, new zzbli(), new zzcws(), new zzbmf(), new zzcbx(), this.zzerr, this.zzelq, new zzcxa(), null, null, null);
        return zzbfb;
    }

    public final /* synthetic */ zzbtk zza(zzbth zzbth) {
        this.zzelt = (zzbth) zzdwh.checkNotNull(zzbth);
        return this;
    }

    public final /* synthetic */ zzbtk zza(zzbmk zzbmk) {
        this.zzelq = (zzbmk) zzdwh.checkNotNull(zzbmk);
        return this;
    }

    public final /* synthetic */ zzbtk zza(zzbpn zzbpn) {
        this.zzerr = (zzbpn) zzdwh.checkNotNull(zzbpn);
        return this;
    }
}
