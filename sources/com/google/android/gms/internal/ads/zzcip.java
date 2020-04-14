package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcip implements zzcgh<zzbuj, zzcwm, zzchk> {
    private final Executor zzfbx;
    private final zzbtl zzfyt;
    private final Context zzlk;

    public zzcip(Context context, zzbtl zzbtl, Executor executor) {
        this.zzlk = context;
        this.zzfyt = zzbtl;
        this.zzfbx = executor;
    }

    public final void zza(zzcvz zzcvz, zzcvr zzcvr, zzcgf<zzcwm, zzchk> zzcgf) throws zzcwh {
        ((zzcwm) zzcgf.zzddv).zza(this.zzlk, zzcvz.zzgka.zzfga.zzgkg, zzcvr.zzgjh.toString(), zzawg.zza((zzawh) zzcvr.zzgje), (zzakd) zzcgf.zzfxg, zzcvz.zzgka.zzfga.zzdeh, zzcvz.zzgka.zzfga.zzgki);
    }

    private static boolean zza(zzcvz zzcvz, int i) {
        return zzcvz.zzgka.zzfga.zzgki.contains(Integer.toString(i));
    }

    public final /* synthetic */ Object zzb(zzcvz zzcvz, zzcvr zzcvr, zzcgf zzcgf) throws zzcwh, zzcjh {
        zzbur zzbur;
        zzakg zzrp = ((zzcwm) zzcgf.zzddv).zzrp();
        zzakl zzrq = ((zzcwm) zzcgf.zzddv).zzrq();
        zzakm zzrv = ((zzcwm) zzcgf.zzddv).zzrv();
        if (zzrv != null && zza(zzcvz, 6)) {
            zzbur = zzbur.zzb(zzrv);
        } else if (zzrp != null && zza(zzcvz, 6)) {
            zzbur = zzbur.zzb(zzrp);
        } else if (zzrp != null && zza(zzcvz, 2)) {
            zzbur = zzbur.zza(zzrp);
        } else if (zzrq != null && zza(zzcvz, 6)) {
            zzbur = zzbur.zzb(zzrq);
        } else if (zzrq == null || !zza(zzcvz, 1)) {
            throw new zzcjh("No native ad mappers", 0);
        } else {
            zzbur = zzbur.zza(zzrq);
        }
        if (zzcvz.zzgka.zzfga.zzgki.contains(Integer.toString(zzbur.zzahp()))) {
            zzbus zza = this.zzfyt.zza(new zzbla(zzcvz, zzcvr, zzcgf.zzffi), new zzbvd(zzbur), new zzbwc(zzrq, zzrp, zzrv));
            ((zzchk) zzcgf.zzfxg).zza((zzakd) zza.zzack());
            zza.zzacf().zza(new zzbhb((zzcwm) zzcgf.zzddv), this.zzfbx);
            return zza.zzacl();
        }
        throw new zzcjh("No corresponding native ad listener", 0);
    }
}
