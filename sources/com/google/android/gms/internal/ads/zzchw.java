package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzchw implements zzcgh<zzbrs, zzcwm, zzchk> {
    private final zzaxl zzblh;
    private final Executor zzfbx;
    private final zzbso zzfxy;
    private final Context zzlk;

    public zzchw(Context context, zzaxl zzaxl, zzbso zzbso, Executor executor) {
        this.zzlk = context;
        this.zzblh = zzaxl;
        this.zzfxy = zzbso;
        this.zzfbx = executor;
    }

    public final void zza(zzcvz zzcvz, zzcvr zzcvr, zzcgf<zzcwm, zzchk> zzcgf) throws zzcwh {
        if (this.zzblh.zzdwf < 4100000) {
            ((zzcwm) zzcgf.zzddv).zza(this.zzlk, zzcvz.zzgka.zzfga.zzgkg, zzcvr.zzgjh.toString(), (zzakd) zzcgf.zzfxg);
        } else {
            ((zzcwm) zzcgf.zzddv).zza(this.zzlk, zzcvz.zzgka.zzfga.zzgkg, zzcvr.zzgjh.toString(), zzawg.zza((zzawh) zzcvr.zzgje), (zzakd) zzcgf.zzfxg);
        }
    }

    public final /* synthetic */ Object zzb(zzcvz zzcvz, zzcvr zzcvr, zzcgf zzcgf) throws zzcwh, zzcjh {
        zzbru zza = this.zzfxy.zza(new zzbla(zzcvz, zzcvr, zzcgf.zzffi), new zzbrx(new zzchz(zzcgf)));
        zza.zzacf().zza(new zzbhb((zzcwm) zzcgf.zzddv), this.zzfbx);
        ((zzchk) zzcgf.zzfxg).zza((zzakd) zza.zzack());
        return zza.zzadh();
    }
}
