package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcib implements zzcgh<zzbrs, zzamd, zzchk> {
    private final zzbso zzfxy;
    private final Context zzlk;

    public zzcib(Context context, zzbso zzbso) {
        this.zzlk = context;
        this.zzfxy = zzbso;
    }

    public final void zza(zzcvz zzcvz, zzcvr zzcvr, zzcgf<zzamd, zzchk> zzcgf) throws zzcwh {
        try {
            ((zzamd) zzcgf.zzddv).zzdh(zzcvr.zzdeu);
            ((zzamd) zzcgf.zzddv).zza(zzcvr.zzeij, zzcvr.zzgjh.toString(), zzcvz.zzgka.zzfga.zzgkg, ObjectWrapper.wrap(this.zzlk), (zzals) new zzcic(this, zzcgf), (zzakd) zzcgf.zzfxg);
        } catch (RemoteException e) {
            throw new zzcwh(e);
        }
    }

    public final /* synthetic */ Object zzb(zzcvz zzcvz, zzcvr zzcvr, zzcgf zzcgf) throws zzcwh, zzcjh {
        zzcgc zzcgc = new zzcgc(zzcvr);
        zzbru zza = this.zzfxy.zza(new zzbla(zzcvz, zzcvr, zzcgf.zzffi), new zzbrx(new zzcia(zzcgf, zzcgc)));
        zzcgc.zza(zza.zzaci());
        ((zzchk) zzcgf.zzfxg).zza((zzakd) zza.zzack());
        return zza.zzadh();
    }
}
