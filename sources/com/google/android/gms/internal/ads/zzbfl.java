package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbfl implements zzbjw {
    private zzdwo<Set<zzbqs<zzbnm>>> zzert;
    private zzdwo<zzbnl> zzeru;
    private zzdwo<zzcvz> zzerv;
    private zzdwo<zzcvr> zzerw;
    private zzdwo<Set<zzbqs<zzbog>>> zzesm;
    private zzdwo<zzbob> zzesn;
    private zzdwo<String> zzesx;
    private zzdwo<zzbkn> zzesy;
    private final zzbjz zzewt;
    private zzdwo<zzada> zzewu;
    private zzdwo<Runnable> zzewv;
    private zzdwo<zzbjv> zzeww;
    private final /* synthetic */ zzbfj zzewx;

    private zzbfl(zzbfj zzbfj, zzbla zzbla, zzbjz zzbjz) {
        this.zzewx = zzbfj;
        this.zzewt = zzbjz;
        this.zzerv = zzblf.zze(zzbla);
        this.zzerw = zzbld.zzc(zzbla);
        this.zzert = zzdwk.zzaq(0, 2).zzaq(this.zzewx.zzeql).zzaq(this.zzewx.zzeqm).zzbdg();
        this.zzeru = zzdwc.zzan(zzbns.zzi(this.zzert));
        this.zzesm = zzdwk.zzaq(4, 3).zzap(this.zzewx.zzeqz).zzap(this.zzewx.zzera).zzap(this.zzewx.zzerb).zzaq(this.zzewx.zzerc).zzaq(this.zzewx.zzerd).zzaq(this.zzewx.zzere).zzap(this.zzewx.zzerf).zzbdg();
        this.zzesn = zzdwc.zzan(zzbod.zzk(this.zzesm));
        this.zzesx = zzblc.zza(zzbla);
        this.zzesy = zzblw.zzb(this.zzerv, this.zzerw, this.zzeru, this.zzesn, this.zzesx);
        this.zzewu = new zzbkb(zzbjz);
        this.zzewv = new zzbjy(zzbjz);
        this.zzeww = zzdwc.zzan(new zzbka(this.zzesy, this.zzewu, this.zzewv, this.zzewx.zzerq.zzekc));
    }

    public final zzbio zzada() {
        return (zzbio) zzdwh.zza((zzbjv) this.zzeww.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
