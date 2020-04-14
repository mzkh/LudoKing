package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcjm implements zzcgh<zzbyz, zzamd, zzchk> {
    private final zzbzc zzfzm;
    private final Context zzlk;

    public zzcjm(Context context, zzbzc zzbzc) {
        this.zzlk = context;
        this.zzfzm = zzbzc;
    }

    public final void zza(zzcvz zzcvz, zzcvr zzcvr, zzcgf<zzamd, zzchk> zzcgf) throws zzcwh {
        try {
            ((zzamd) zzcgf.zzddv).zzdh(zzcvr.zzdeu);
            ((zzamd) zzcgf.zzddv).zza(zzcvr.zzeij, zzcvr.zzgjh.toString(), zzcvz.zzgka.zzfga.zzgkg, ObjectWrapper.wrap(this.zzlk), (zzaly) new zzcjr(this, zzcgf), (zzakd) zzcgf.zzfxg);
        } catch (RemoteException e) {
            zzdoy.zzj(e);
        }
    }

    public final /* synthetic */ Object zzb(zzcvz zzcvz, zzcvr zzcvr, zzcgf zzcgf) throws zzcwh, zzcjh {
        zzcgc zzcgc = new zzcgc(zzcvr);
        zzbzb zza = this.zzfzm.zza(new zzbla(zzcvz, zzcvr, zzcgf.zzffi), new zzbza(new zzcjp(zzcgf, zzcgc)));
        zzcgc.zza(zza.zzaci());
        ((zzchk) zzcgf.zzfxg).zza((zzakd) zza.zzadr());
        return zza.zzadp();
    }
}
