package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzc;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbfh extends zzbia {
    private final zzbmb zzers;
    private zzdwo<Set<zzbqs<zzbnm>>> zzert;
    private zzdwo<zzbnl> zzeru;
    private zzdwo<zzcvz> zzerv;
    private zzdwo<zzcvr> zzerw;
    private zzdwo<zzbhd> zzerx;
    private zzdwo<zzbqs<zzbna>> zzery;
    private zzdwo<Set<zzbqs<zzbna>>> zzerz;
    private zzdwo<zzbnr> zzesa;
    private zzdwo<zzbqs<zztp>> zzesb;
    private zzdwo<Set<zzbqs<zztp>>> zzesc;
    private zzdwo<zzbmv> zzesd;
    private zzdwo<zzbqs<zzbnj>> zzese;
    private zzdwo<Set<zzbqs<zzbnj>>> zzesf;
    private zzdwo<zzbni> zzesg;
    private zzdwo<zzbra> zzesh;
    private zzdwo<zzbqs<zzbrb>> zzesi;
    private zzdwo<Set<zzbqs<zzbrb>>> zzesj;
    private zzdwo<zzbqw> zzesk;
    private zzdwo<zzbqs<zzbog>> zzesl;
    private zzdwo<Set<zzbqs<zzbog>>> zzesm;
    private zzdwo<zzbob> zzesn;
    private zzdwo<zzble> zzeso;
    private zzdwo<zzbqs<zzo>> zzesp;
    private zzdwo<Set<zzbqs<zzo>>> zzesq;
    private zzdwo<zzboo> zzesr;
    private zzdwo<Set<zzbqs<VideoLifecycleCallbacks>>> zzesv;
    private zzdwo<zzbrl> zzesw;
    private zzdwo<zzajc> zzett;
    private zzdwo<zzpe> zzetx;
    private zzdwo<zzbhi> zzety;
    private zzdwo<zzbhf> zzetz;
    private zzdwo<zzbhk> zzeua;
    private zzdwo<Set<zzbqs<zzbnm>>> zzeub;
    private zzdwo<Set<zzbqs<zzbnj>>> zzeuc;
    private zzdwo<Set<zzbqs<zzpj>>> zzeuh;
    private zzdwo<Set<zzbqs<zzpj>>> zzeui;
    private zzdwo<zzbqv> zzeuj;
    private zzdwo<zzbzn> zzeun;
    private final zzbla zzevd;
    private final zzbid zzeve;
    private final zzblz zzevf;
    private final zzbmt zzevg;
    private zzdwo<JSONObject> zzevh;
    private zzdwo<Set<zzbqs<zzbol>>> zzevi;
    private zzdwo<zzbok> zzevj;
    private zzdwo<zzbkf> zzevk;
    private zzdwo<Set<zzbqs<zzbog>>> zzevl;
    private zzdwo<Set<zzbqs<zzpj>>> zzevm;
    private zzdwo<zzasi> zzevn;
    private zzdwo<zzc> zzevo;
    private zzdwo<Set<zzbqs<zzbpg>>> zzevp;
    private zzdwo<zzbpb> zzevq;
    private final /* synthetic */ zzbfi zzevr;

    private zzbfh(zzbfi zzbfi, zzbla zzbla, zzbid zzbid) {
        zzbid zzbid2 = zzbid;
        this.zzevr = zzbfi;
        this.zzers = new zzbmb();
        this.zzevd = zzbla;
        this.zzeve = zzbid2;
        this.zzevf = new zzblz();
        this.zzevg = new zzbmt();
        this.zzett = zzdwc.zzan(zzbht.zzb(this.zzevr.zzerq.zzelk));
        this.zzerw = zzbld.zzc(zzbla);
        this.zzevh = zzdwc.zzan(zzbhy.zzc(this.zzerw));
        this.zzetx = zzdwc.zzan(zzbhq.zza(this.zzerw, this.zzevr.zzerq.zzekj, this.zzevh, zzbij.zzaex()));
        this.zzety = zzdwc.zzan(zzbhl.zza(this.zzevr.zzema, this.zzetx));
        this.zzetz = zzdwc.zzan(zzbho.zzb(this.zzetx, this.zzett, zzcxh.zzanj()));
        this.zzeua = zzdwc.zzan(zzbhp.zza(this.zzett, this.zzety, this.zzevr.zzerq.zzekc, this.zzetz, this.zzevr.zzerq.zzekg));
        this.zzeub = zzdwc.zzan(zzbhs.zzd(this.zzeua, zzcxk.zzanm(), this.zzevh));
        this.zzert = zzdwk.zzaq(0, 3).zzaq(this.zzevr.zzeql).zzaq(this.zzevr.zzeqm).zzaq(this.zzeub).zzbdg();
        this.zzeru = zzdwc.zzan(zzbns.zzi(this.zzert));
        this.zzerv = zzblf.zze(zzbla);
        this.zzerx = zzdwc.zzan(zzbhc.zza(this.zzerv, this.zzerw, this.zzevr.zzepi));
        this.zzery = zzblv.zzf(this.zzerx, zzcxk.zzanm());
        this.zzerz = zzdwk.zzaq(2, 2).zzap(this.zzevr.zzeqn).zzaq(this.zzevr.zzeqo).zzaq(this.zzevr.zzeqp).zzap(this.zzery).zzbdg();
        this.zzesa = zzdwc.zzan(zzboa.zzj(this.zzerz));
        this.zzesb = zzbls.zzc(this.zzerx, zzcxk.zzanm());
        this.zzesc = zzdwk.zzaq(3, 2).zzap(this.zzevr.zzeqq).zzap(this.zzevr.zzeqr).zzaq(this.zzevr.zzeqs).zzaq(this.zzevr.zzeqt).zzap(this.zzesb).zzbdg();
        this.zzesd = zzdwc.zzan(zzbmx.zzg(this.zzesc));
        this.zzese = zzblu.zze(this.zzerx, zzcxk.zzanm());
        this.zzeuc = zzdwc.zzan(zzbhr.zzc(this.zzeua, zzcxk.zzanm(), this.zzevh));
        this.zzesf = zzdwk.zzaq(3, 3).zzap(this.zzevr.zzequ).zzap(this.zzevr.zzeqv).zzaq(this.zzevr.zzeqw).zzaq(this.zzevr.zzeqx).zzap(this.zzese).zzaq(this.zzeuc).zzbdg();
        this.zzesg = zzdwc.zzan(zzbnk.zzh(this.zzesf));
        this.zzesh = zzdwc.zzan(zzbrd.zzh(this.zzerw, this.zzevr.zzepi));
        this.zzesi = zzblt.zzd(this.zzesh, zzcxk.zzanm());
        this.zzesj = zzdwk.zzaq(1, 1).zzaq(this.zzevr.zzeqy).zzap(this.zzesi).zzbdg();
        this.zzesk = zzdwc.zzan(zzbqy.zzs(this.zzesj));
        this.zzevi = zzdwk.zzaq(0, 1).zzaq(this.zzevr.zzevw).zzbdg();
        this.zzevj = zzdwc.zzan(zzbom.zzm(this.zzevi));
        this.zzevk = zzdwc.zzan(zzbke.zzg(this.zzerw, this.zzesg, this.zzevj));
        this.zzevl = new zzbic(zzbid2, this.zzevk);
        this.zzesl = zzblx.zzg(this.zzerx, zzcxk.zzanm());
        this.zzesm = zzdwk.zzaq(5, 4).zzap(this.zzevr.zzeqz).zzap(this.zzevr.zzera).zzap(this.zzevr.zzerb).zzaq(this.zzevr.zzerc).zzaq(this.zzevr.zzerd).zzaq(this.zzevr.zzere).zzap(this.zzevr.zzerf).zzaq(this.zzevl).zzap(this.zzesl).zzbdg();
        this.zzesn = zzdwc.zzan(zzbod.zzk(this.zzesm));
        this.zzeso = zzdwc.zzan(zzblh.zze(this.zzesa));
        this.zzesp = zzbma.zza(this.zzers, this.zzeso);
        this.zzesq = zzdwk.zzaq(1, 1).zzaq(this.zzevr.zzerk).zzap(this.zzesp).zzbdg();
        this.zzesr = zzdwc.zzan(zzbor.zzn(this.zzesq));
        this.zzesv = zzdwk.zzaq(0, 1).zzaq(this.zzevr.zzerl).zzbdg();
        this.zzesw = zzdwc.zzan(zzbrr.zzt(this.zzesv));
        this.zzevm = new zzbif(zzbid2, this.zzevk);
        this.zzeuh = zzdwc.zzan(zzbhv.zzf(this.zzeua, zzcxk.zzanm(), this.zzevh));
        this.zzeui = zzdwk.zzaq(0, 3).zzaq(this.zzevr.zzerm).zzaq(this.zzevm).zzaq(this.zzeuh).zzbdg();
        this.zzeuj = zzdwc.zzan(zzbqx.zzi(this.zzevr.zzeki, this.zzeui, this.zzerw));
        this.zzevn = zzdwc.zzan(zzbmw.zza(this.zzevg, this.zzevr.zzeki, this.zzevr.zzerq.zzekj, this.zzerw, this.zzevr.zzerq.zzell));
        this.zzevo = zzdwc.zzan(zzbly.zza(this.zzevf, this.zzevr.zzeki, this.zzevn));
        this.zzevp = zzdwk.zzaq(0, 1).zzaq(this.zzevr.zzevx).zzbdg();
        this.zzevq = zzdwc.zzan(zzbpd.zzo(this.zzevp));
        this.zzeun = zzdwc.zzan(zzbzw.zza(this.zzesd, this.zzesa, this.zzevr.zzerp, this.zzesr, this.zzevr.zzerj, this.zzevr.zzerq.zzekc, this.zzeuj, this.zzeua, this.zzevo, this.zzeru, this.zzevn, this.zzevr.zzeob, this.zzevq));
    }

    public final zzbnl zzacf() {
        return (zzbnl) this.zzeru.get();
    }

    public final zzbnr zzacg() {
        return (zzbnr) this.zzesa.get();
    }

    public final zzbmv zzach() {
        return (zzbmv) this.zzesd.get();
    }

    public final zzbni zzaci() {
        return (zzbni) this.zzesg.get();
    }

    public final zzbqw zzacj() {
        return (zzbqw) this.zzesk.get();
    }

    public final zzckt zzack() {
        zzckt zzckt = new zzckt((zzbmv) this.zzesd.get(), (zzbni) this.zzesg.get(), (zzbnr) this.zzesa.get(), (zzbob) this.zzesn.get(), (zzbpf) this.zzevr.zzerj.get(), (zzboo) this.zzesr.get(), (zzbrl) this.zzesw.get());
        return zzckt;
    }

    public final zzbii zzacv() {
        zzbkn zzbkn = new zzbkn(zzblf.zzf(this.zzevd), zzbld.zzd(this.zzevd), (zzbnl) this.zzeru.get(), (zzbob) this.zzesn.get(), zzblc.zzb(this.zzevd));
        String str = "Cannot return null from a non-@Nullable @Provides method";
        return zzbil.zza(zzbkn, (View) zzdwh.zza(this.zzeve.zzaep(), str), this.zzeve.zzaeo(), (zzcvu) zzdwh.zza(this.zzeve.zzaeq(), str), this.zzeve.zzaer());
    }

    public final zzbzn zzacw() {
        return (zzbzn) this.zzeun.get();
    }
}
