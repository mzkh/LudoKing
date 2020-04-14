package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcke implements zzcgh<zzbyz, zzcwm, zzchn> {
    /* access modifiers changed from: private */
    public final Executor zzfbx;
    private final zzbzc zzfzm;
    private final Context zzlk;

    public zzcke(Context context, Executor executor, zzbzc zzbzc) {
        this.zzlk = context;
        this.zzfbx = executor;
        this.zzfzm = zzbzc;
    }

    public final void zza(zzcvz zzcvz, zzcvr zzcvr, zzcgf<zzcwm, zzchn> zzcgf) throws zzcwh {
        if (!((zzcwm) zzcgf.zzddv).isInitialized()) {
            ((zzchn) zzcgf.zzfxg).zza((zzbrj) new zzckg(this, zzcvz, zzcvr, zzcgf));
            ((zzcwm) zzcgf.zzddv).zza(this.zzlk, zzcvz.zzgka.zzfga.zzgkg, (String) null, (zzaqp) zzcgf.zzfxg, zzcvr.zzgjh.toString());
            return;
        }
        zzc(zzcvz, zzcvr, zzcgf);
    }

    /* access modifiers changed from: private */
    public static void zzc(zzcvz zzcvz, zzcvr zzcvr, zzcgf<zzcwm, zzchn> zzcgf) {
        try {
            ((zzcwm) zzcgf.zzddv).zza(zzcvz.zzgka.zzfga.zzgkg, zzcvr.zzgjh.toString());
        } catch (Exception e) {
            String str = "Fail to load ad from adapter ";
            String valueOf = String.valueOf(zzcgf.zzffi);
            zzaug.zzd(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
        }
    }

    public final /* synthetic */ Object zzb(zzcvz zzcvz, zzcvr zzcvr, zzcgf zzcgf) throws zzcwh, zzcjh {
        zzbzb zza = this.zzfzm.zza(new zzbla(zzcvz, zzcvr, zzcgf.zzffi), new zzbza(new zzckh(zzcgf)));
        zza.zzacf().zza(new zzbhb((zzcwm) zzcgf.zzddv), this.zzfbx);
        zzbnr zzacg = zza.zzacg();
        zzbmv zzach = zza.zzach();
        zzchn zzchn = (zzchn) zzcgf.zzfxg;
        zzcki zzcki = new zzcki(this, zza.zzadi(), zzach, zzacg, zza.zzadq());
        zzchn.zza((zzaqp) zzcki);
        return zza.zzadp();
    }
}
