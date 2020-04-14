package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcir implements zzcgh<zzbuj, zzamd, zzchk> {
    private final zzbtl zzfyt;
    /* access modifiers changed from: private */
    public zzakm zzfyy;
    private final Context zzlk;

    public zzcir(Context context, zzbtl zzbtl) {
        this.zzlk = context;
        this.zzfyt = zzbtl;
    }

    public final void zza(zzcvz zzcvz, zzcvr zzcvr, zzcgf<zzamd, zzchk> zzcgf) throws zzcwh {
        try {
            ((zzamd) zzcgf.zzddv).zzdh(zzcvr.zzdeu);
            ((zzamd) zzcgf.zzddv).zza(zzcvr.zzeij, zzcvr.zzgjh.toString(), zzcvz.zzgka.zzfga.zzgkg, ObjectWrapper.wrap(this.zzlk), (zzalx) new zzcit(this, zzcgf), (zzakd) zzcgf.zzfxg);
        } catch (RemoteException e) {
            throw new zzcwh(e);
        }
    }

    public final /* synthetic */ Object zzb(zzcvz zzcvz, zzcvr zzcvr, zzcgf zzcgf) throws zzcwh, zzcjh {
        if (zzcvz.zzgka.zzfga.zzgki.contains(Integer.toString(6))) {
            zzbur zzb = zzbur.zzb(this.zzfyy);
            if (zzcvz.zzgka.zzfga.zzgki.contains(Integer.toString(zzb.zzahp()))) {
                zzbus zza = this.zzfyt.zza(new zzbla(zzcvz, zzcvr, zzcgf.zzffi), new zzbvd(zzb), new zzbwc(null, null, this.zzfyy));
                ((zzchk) zzcgf.zzfxg).zza((zzakd) zza.zzack());
                return zza.zzacl();
            }
            throw new zzcjh("No corresponding native ad listener", 0);
        }
        throw new zzcjh("Unified must be used for RTB.", 1);
    }
}
