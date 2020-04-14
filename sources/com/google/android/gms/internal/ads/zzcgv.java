package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcgv implements zzcgh<zzbio, zzcwm, zzchk> {
    private final zzaxl zzblh;
    private final Executor zzfbx;
    private final zzbjn zzfxm;
    private final Context zzlk;

    public zzcgv(Context context, zzaxl zzaxl, zzbjn zzbjn, Executor executor) {
        this.zzlk = context;
        this.zzblh = zzaxl;
        this.zzfxm = zzbjn;
        this.zzfbx = executor;
    }

    public final void zza(zzcvz zzcvz, zzcvr zzcvr, zzcgf<zzcwm, zzchk> zzcgf) throws zzcwh {
        zzua zza = zzcwi.zza(this.zzlk, zzcvr.zzgjg);
        if (this.zzblh.zzdwf < 4100000) {
            ((zzcwm) zzcgf.zzddv).zza(this.zzlk, zza, zzcvz.zzgka.zzfga.zzgkg, zzcvr.zzgjh.toString(), (zzakd) zzcgf.zzfxg);
        } else {
            ((zzcwm) zzcgf.zzddv).zza(this.zzlk, zza, zzcvz.zzgka.zzfga.zzgkg, zzcvr.zzgjh.toString(), zzawg.zza((zzawh) zzcvr.zzgje), (zzakd) zzcgf.zzfxg);
        }
    }

    public final /* synthetic */ Object zzb(zzcvz zzcvz, zzcvr zzcvr, zzcgf zzcgf) throws zzcwh, zzcjh {
        zzbjn zzbjn = this.zzfxm;
        zzbla zzbla = new zzbla(zzcvz, zzcvr, zzcgf.zzffi);
        View view = ((zzcwm) zzcgf.zzddv).getView();
        zzcwm zzcwm = (zzcwm) zzcgf.zzddv;
        zzcwm.getClass();
        zzbir zza = zzbjn.zza(zzbla, new zzbiv(view, null, zzcgu.zza(zzcwm), (zzcvu) zzcvr.zzgjg.get(0)));
        zza.zzadd().zzq(((zzcwm) zzcgf.zzddv).getView());
        zza.zzacf().zza(new zzbhb((zzcwm) zzcgf.zzddv), this.zzfbx);
        ((zzchk) zzcgf.zzfxg).zza((zzakd) zza.zzack());
        return zza.zzadc();
    }
}
