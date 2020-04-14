package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcjl implements zzcgh<zzbyz, zzcwm, zzchk> {
    private final Executor zzfbx;
    private final zzbzc zzfzm;
    private final Context zzlk;

    public zzcjl(Context context, Executor executor, zzbzc zzbzc) {
        this.zzlk = context;
        this.zzfbx = executor;
        this.zzfzm = zzbzc;
    }

    public final void zza(zzcvz zzcvz, zzcvr zzcvr, zzcgf<zzcwm, zzchk> zzcgf) throws zzcwh {
        try {
            ((zzcwm) zzcgf.zzddv).zzb(this.zzlk, zzcvz.zzgka.zzfga.zzgkg, zzcvr.zzgjh.toString(), (zzakd) zzcgf.zzfxg);
        } catch (Exception e) {
            String str = "Fail to load ad from adapter ";
            String valueOf = String.valueOf(zzcgf.zzffi);
            zzaug.zzd(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
        }
    }

    public final /* synthetic */ Object zzb(zzcvz zzcvz, zzcvr zzcvr, zzcgf zzcgf) throws zzcwh, zzcjh {
        zzbzb zza = this.zzfzm.zza(new zzbla(zzcvz, zzcvr, zzcgf.zzffi), new zzbza(new zzcjk(zzcgf)));
        zza.zzacf().zza(new zzbhb((zzcwm) zzcgf.zzddv), this.zzfbx);
        ((zzchk) zzcgf.zzfxg).zza((zzakd) zza.zzadr());
        return zza.zzadp();
    }
}
