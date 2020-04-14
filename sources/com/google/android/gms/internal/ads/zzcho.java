package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcho implements zzcga<zzbrs> {
    private final zzaxl zzblh;
    private final Executor zzfbx;
    private final zzcwe zzfga;
    private final zzbzl zzfnm;
    private final zzbso zzfxy;
    private final Context zzlk;

    public zzcho(Context context, zzaxl zzaxl, zzcwe zzcwe, Executor executor, zzbso zzbso, zzbzl zzbzl) {
        this.zzlk = context;
        this.zzfga = zzcwe;
        this.zzfxy = zzbso;
        this.zzfbx = executor;
        this.zzblh = zzaxl;
        this.zzfnm = zzbzl;
    }

    public final boolean zza(zzcvz zzcvz, zzcvr zzcvr) {
        return (zzcvr.zzgje == null || zzcvr.zzgje.zzdib == null) ? false : true;
    }

    public final zzddi<zzbrs> zzb(zzcvz zzcvz, zzcvr zzcvr) {
        zzcab zzcab = new zzcab();
        zzddi<zzbrs> zzb = zzdcy.zzb(zzdcy.zzah(null), (zzdcj<? super I, ? extends O>) new zzchr<Object,Object>(this, zzcvr, zzcab, zzcvz), this.zzfbx);
        zzcab.getClass();
        zzb.addListener(zzchq.zza(zzcab), this.zzfbx);
        return zzb;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zza(zzcvr zzcvr, zzcab zzcab, zzcvz zzcvz, Object obj) throws Exception {
        zzddi zzddi;
        zzbbw zza = this.zzfnm.zza(this.zzfga.zzbll, zzcvr.zzegg);
        zza.zzaq(zzcvr.zzdlr);
        zzcab.zza(this.zzlk, zza.getView());
        zzaxv zzaxv = new zzaxv();
        zzbso zzbso = this.zzfxy;
        zzbla zzbla = new zzbla(zzcvz, zzcvr, null);
        zzchu zzchu = new zzchu(this.zzlk, this.zzblh, zzaxv, zzcvr, zza);
        zzbru zza2 = zzbso.zza(zzbla, new zzbrx(zzchu, zza));
        zzaxv.set(zza2);
        zza2.zzaci().zza(new zzcht(zza), zzaxn.zzdwn);
        zza2.zzacw().zzb(zza, true);
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcth)).booleanValue() || !zzcvr.zzegg) {
            zza2.zzacw();
            zzddi = zzbzn.zza(zza, zzcvr.zzgje.zzdhz, zzcvr.zzgje.zzdib);
        } else {
            zzddi = zzdcy.zzah(null);
        }
        return zzdcy.zzb(zzddi, (zzdal<? super I, ? extends O>) new zzchs<Object,Object>(this, zza, zzcvr, zza2), this.zzfbx);
    }
}
