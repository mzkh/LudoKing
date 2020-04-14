package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcgn implements zzcga<zzbio> {
    private final Executor zzfbx;
    private final zzcwe zzfga;
    private final zzbzl zzfnm;
    private final zzbjn zzfxm;
    private final zzdal<zzcvr, zzavd> zzfxn;
    private final Context zzlk;

    public zzcgn(zzbjn zzbjn, Context context, Executor executor, zzbzl zzbzl, zzcwe zzcwe, zzdal<zzcvr, zzavd> zzdal) {
        this.zzlk = context;
        this.zzfxm = zzbjn;
        this.zzfbx = executor;
        this.zzfnm = zzbzl;
        this.zzfga = zzcwe;
        this.zzfxn = zzdal;
    }

    public final boolean zza(zzcvz zzcvz, zzcvr zzcvr) {
        return (zzcvr.zzgje == null || zzcvr.zzgje.zzdib == null) ? false : true;
    }

    public final zzddi<zzbio> zzb(zzcvz zzcvz, zzcvr zzcvr) {
        return zzdcy.zzb(zzdcy.zzah(null), (zzdcj<? super I, ? extends O>) new zzcgm<Object,Object>(this, zzcvz, zzcvr), this.zzfbx);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzo(zzbbw zzbbw) {
        zzbbw.zzzj();
        zzbco zzxl = zzbbw.zzxl();
        if (this.zzfga.zzgkf != null && zzxl != null) {
            zzxl.zzb(this.zzfga.zzgkf);
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zzb(zzcvz zzcvz, zzcvr zzcvr, Object obj) throws Exception {
        zzua zza = zzcwi.zza(this.zzlk, zzcvr.zzgjg);
        zzbbw zzc = this.zzfnm.zzc(zza);
        zzc.zzaq(zzcvr.zzdlr);
        zzbjn zzbjn = this.zzfxm;
        zzbla zzbla = new zzbla(zzcvz, zzcvr, null);
        zzbzy zzbzy = new zzbzy(this.zzlk, zzc.getView(), (zzavd) this.zzfxn.apply(zzcvr));
        zzc.getClass();
        zzbir zza2 = zzbjn.zza(zzbla, new zzbiv(zzbzy, zzc, zzcgp.zzp(zzc), zzcwi.zze(zza)));
        zza2.zzacw().zzb(zzc, false);
        zza2.zzaci().zza(new zzcgo(zzc), zzaxn.zzdwn);
        zza2.zzacw();
        zzddi zza3 = zzbzn.zza(zzc, zzcvr.zzgje.zzdhz, zzcvr.zzgje.zzdib);
        if (zzcvr.zzdnj) {
            zzc.getClass();
            zza3.addListener(zzcgr.zzh(zzc), this.zzfbx);
        }
        zza3.addListener(new zzcgq(this, zzc), this.zzfbx);
        return zzdcy.zzb(zza3, (zzdal<? super I, ? extends O>) new zzcgt<Object,Object>(zza2), (Executor) zzaxn.zzdwn);
    }
}
