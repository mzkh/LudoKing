package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcju implements zzcga<zzbyz> {
    private final zzaxl zzblh;
    private final Executor zzfbx;
    private final zzcwe zzfga;
    private final zzbzl zzfnm;
    private final zzbzc zzfzm;
    private final Context zzlk;

    public zzcju(Context context, zzaxl zzaxl, zzcwe zzcwe, Executor executor, zzbzc zzbzc, zzbzl zzbzl) {
        this.zzlk = context;
        this.zzfga = zzcwe;
        this.zzfzm = zzbzc;
        this.zzfbx = executor;
        this.zzblh = zzaxl;
        this.zzfnm = zzbzl;
    }

    public final boolean zza(zzcvz zzcvz, zzcvr zzcvr) {
        return (zzcvr.zzgje == null || zzcvr.zzgje.zzdib == null) ? false : true;
    }

    public final zzddi<zzbyz> zzb(zzcvz zzcvz, zzcvr zzcvr) {
        zzcab zzcab = new zzcab();
        zzddi<zzbyz> zzb = zzdcy.zzb(zzdcy.zzah(null), (zzdcj<? super I, ? extends O>) new zzcjx<Object,Object>(this, zzcvr, zzcab, zzcvz), this.zzfbx);
        zzcab.getClass();
        zzb.addListener(zzcjw.zza(zzcab), this.zzfbx);
        return zzb;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zzb(zzcvr zzcvr, zzcab zzcab, zzcvz zzcvz, Object obj) throws Exception {
        zzddi zzddi;
        zzcvr zzcvr2 = zzcvr;
        zzbbw zza = this.zzfnm.zza(this.zzfga.zzbll, zzcvr2.zzegg);
        zza.zzaq(zzcvr2.zzdlr);
        zzcab.zza(this.zzlk, zza.getView());
        zzaxv zzaxv = new zzaxv();
        zzbzc zzbzc = this.zzfzm;
        zzbla zzbla = new zzbla(zzcvz, zzcvr2, null);
        zzcka zzcka = r1;
        zzcka zzcka2 = new zzcka(this.zzlk, this.zzfnm, this.zzfga, this.zzblh, zzcvr, zzaxv, zza);
        zzbza zzbza = new zzbza(zzcka, zza);
        zzbzb zza2 = zzbzc.zza(zzbla, zzbza);
        zzaxv.set(zza2);
        zzaey.zza(zza, (zzafb) zza2.zzadq());
        zza2.zzaci().zza(new zzcjz(zza), zzaxn.zzdwn);
        zza2.zzacw().zzb(zza, true);
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcth)).booleanValue() || !zzcvr2.zzegg) {
            zza2.zzacw();
            zzddi = zzbzn.zza(zza, zzcvr2.zzgje.zzdhz, zzcvr2.zzgje.zzdib);
        } else {
            zzddi = zzdcy.zzah(null);
        }
        return zzdcy.zzb(zzddi, (zzdal<? super I, ? extends O>) new zzcjy<Object,Object>(this, zza, zzcvr2, zza2), this.zzfbx);
    }
}
