package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcgw implements zzcgh<zzbio, zzamd, zzchk> {
    /* access modifiers changed from: private */
    public View view;
    private final zzbjn zzfxm;
    private final Context zzlk;

    public zzcgw(Context context, zzbjn zzbjn) {
        this.zzlk = context;
        this.zzfxm = zzbjn;
    }

    public final void zza(zzcvz zzcvz, zzcvr zzcvr, zzcgf<zzamd, zzchk> zzcgf) throws zzcwh {
        try {
            ((zzamd) zzcgf.zzddv).zzdh(zzcvr.zzdeu);
            ((zzamd) zzcgf.zzddv).zza(zzcvr.zzeij, zzcvr.zzgjh.toString(), zzcvz.zzgka.zzfga.zzgkg, ObjectWrapper.wrap(this.zzlk), new zzchb(this, zzcgf), (zzakd) zzcgf.zzfxg, zzcvz.zzgka.zzfga.zzbll);
        } catch (RemoteException e) {
            throw new zzcwh(e);
        }
    }

    public final /* synthetic */ Object zzb(zzcvz zzcvz, zzcvr zzcvr, zzcgf zzcgf) throws zzcwh, zzcjh {
        zzbir zza = this.zzfxm.zza(new zzbla(zzcvz, zzcvr, zzcgf.zzffi), new zzbiv(this.view, null, new zzcgz(zzcgf), (zzcvu) zzcvr.zzgjg.get(0)));
        zza.zzadd().zzq(this.view);
        ((zzchk) zzcgf.zzfxg).zza((zzakd) zza.zzack());
        return zza.zzadc();
    }

    static final /* synthetic */ zzwr zza(zzcgf zzcgf) throws zzcwh {
        try {
            return ((zzamd) zzcgf.zzddv).getVideoController();
        } catch (RemoteException e) {
            throw new zzcwh(e);
        }
    }
}
