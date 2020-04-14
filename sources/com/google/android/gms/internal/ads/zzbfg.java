package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbfg extends zzcsm {
    private zzdwo<String> zzemc;
    private zzdwo<zzcba> zzems;
    private zzdwo<Map<zzcyd, zzcba>> zzemu;
    private zzdwo<Set<zzbqs<zzcym>>> zzemw;
    private zzdwo<Set<zzbqs<zzcym>>> zzend;
    private zzdwo zzene;
    private zzdwo<zzcyg> zzenf;
    private zzdwo<ApplicationInfo> zzeng;
    private final /* synthetic */ zzbfa zzerq;
    private final zzctp zzeuq;
    private zzdwo<zzcsi> zzeur;
    private zzdwo<String> zzeus;
    private zzdwo<zzcss> zzeut;
    private zzdwo<zzcsw> zzeuu;
    private zzdwo<zzctb> zzeuv;
    private zzdwo<Boolean> zzeuw;
    private zzdwo<zzctk> zzeux;
    private zzdwo<zzcto> zzeuy;
    private zzdwo<zzctz> zzeuz;
    private zzdwo<zzcba> zzeva;
    private zzdwo<zzcba> zzevb;
    private zzdwo<zzcba> zzevc;

    private zzbfg(zzbfa zzbfa, zzctp zzctp) {
        this.zzerq = zzbfa;
        this.zzeuq = zzctp;
        this.zzeur = new zzcsj(zzbgo.zzaed(), this.zzerq.zzeki, this.zzerq.zzeke, zzcxk.zzanm());
        this.zzeus = new zzcts(zzctp);
        this.zzeut = new zzcsu(zzbew.zzabt(), this.zzerq.zzeki, this.zzeus, zzcxk.zzanm());
        this.zzeuu = new zzcsy(zzbgk.zzadw(), zzcxk.zzanm(), this.zzerq.zzeki);
        this.zzeuv = new zzctd(zzbgn.zzaeb(), zzcxk.zzanm(), this.zzeus);
        this.zzeuw = new zzctu(zzctp);
        this.zzeng = new zzctr(zzctp);
        this.zzeux = new zzctm(zzbgm.zzadz(), this.zzerq.zzeke, this.zzeuw, this.zzeng);
        this.zzeuy = new zzctq(zzbgp.zzaef(), this.zzerq.zzeke, this.zzerq.zzeki);
        this.zzeuz = new zzcub(zzcxk.zzanm());
        this.zzemc = new zzctt(zzctp);
        this.zzems = zzdwc.zzan(zzcau.zzajq());
        this.zzeva = zzdwc.zzan(zzcav.zzajr());
        this.zzevb = zzdwc.zzan(zzcax.zzajt());
        this.zzevc = zzdwc.zzan(zzcaw.zzajs());
        this.zzemu = ((zzdwf) ((zzdwf) ((zzdwf) ((zzdwf) zzdwd.zzho(4).zza(zzcyd.GMS_SIGNALS, this.zzems)).zza(zzcyd.BUILD_URL, this.zzeva)).zza(zzcyd.HTTP, this.zzevb)).zza(zzcyd.PRE_PROCESS, this.zzevc)).zzbdf();
        this.zzemw = zzdwc.zzan(new zzcaz(this.zzemc, this.zzerq.zzeki, zzcxk.zzanm(), this.zzemu));
        this.zzend = zzdwk.zzaq(0, 1).zzaq(this.zzemw).zzbdg();
        this.zzene = zzcyo.zzam(this.zzend);
        this.zzenf = zzdwc.zzan(zzcyl.zzs(zzcxk.zzanm(), this.zzerq.zzeke, this.zzene));
    }

    private final zzctf zzacq() {
        return new zzctf(zzbgl.zzady(), zzcxk.zzann(), (List) zzdwh.zza(this.zzeuq.zzamp(), "Cannot return null from a non-@Nullable @Provides method"));
    }

    private final zzcso zzacr() {
        return new zzcso(zzbgo.zzaee(), zzcxk.zzann(), (String) zzdwh.zza(this.zzeuq.zzamm(), "Cannot return null from a non-@Nullable @Provides method"), this.zzeuq.zzamn());
    }

    public final zzcrt<JSONObject> zzacs() {
        zzddl zzann = zzcxk.zzann();
        zzcqq zzcqq = new zzcqq(new zzctb(zzbgn.zzaec(), zzcxk.zzann(), zzcts.zzc(this.zzeuq)), 0, (ScheduledExecutorService) this.zzerq.zzeke.get());
        String str = "Cannot return null from a non-@Nullable @Provides method";
        return new zzcrt<>(zzann, zzdbg.zza((zzcru) zzdwh.zza(zzcqq, str), (zzcru) zzdwh.zza(new zzcqq(new zzctk(zzbgm.zzaea(), (ScheduledExecutorService) this.zzerq.zzeke.get(), this.zzeuq.zzamo(), zzctr.zzb(this.zzeuq)), ((Long) zzuv.zzon().zzd(zzza.zzcor)).longValue(), (ScheduledExecutorService) this.zzerq.zzeke.get()), str), (zzcru) zzdwh.zza(new zzcqq(new zzcto(zzbgp.zzaeg(), (ScheduledExecutorService) this.zzerq.zzeke.get(), zzbeo.zza(this.zzerq.zzekb)), ((Long) zzuv.zzon().zzd(zzza.zzcpg)).longValue(), (ScheduledExecutorService) this.zzerq.zzeke.get()), str), (zzcru) zzdwh.zza(new zzcqq(new zzcsi(zzbgo.zzaee(), zzbeo.zza(this.zzerq.zzekb), (ScheduledExecutorService) this.zzerq.zzeke.get(), zzcxk.zzann()), 0, (ScheduledExecutorService) this.zzerq.zzeke.get()), str), (zzcru) zzdwh.zza(new zzcqq(new zzctz(zzcxk.zzann()), 0, (ScheduledExecutorService) this.zzerq.zzeke.get()), str), zzcty.zzams(), new zzcss(null, zzbeo.zza(this.zzerq.zzekb), zzcts.zzc(this.zzeuq), zzcxk.zzann()), new zzcsw(zzbgk.zzadx(), zzcxk.zzann(), zzbeo.zza(this.zzerq.zzekb)), zzacq(), zzacr(), (zzcru) this.zzerq.zzekw.get()));
    }

    public final zzcrt<JSONObject> zzact() {
        return zzctx.zza(this.zzerq.zzekw.get(), zzacr(), zzacq(), zzdwc.zzao(this.zzeur), zzdwc.zzao(this.zzeut), zzdwc.zzao(this.zzeuu), zzdwc.zzao(this.zzeuv), zzdwc.zzao(this.zzeux), zzdwc.zzao(this.zzeuy), zzdwc.zzao(this.zzeuz), zzcxk.zzann());
    }

    public final zzcyg zzacu() {
        return (zzcyg) this.zzenf.get();
    }
}
