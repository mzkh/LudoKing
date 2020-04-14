package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcgg implements zzcga<zzbii> {
    private final Executor zzfbx;
    private final zzcwe zzfga;
    private final zzbzl zzfnm;
    private final zzbie zzfxh;
    private final Context zzlk;

    public zzcgg(zzbie zzbie, Context context, Executor executor, zzbzl zzbzl, zzcwe zzcwe) {
        this.zzlk = context;
        this.zzfxh = zzbie;
        this.zzfbx = executor;
        this.zzfnm = zzbzl;
        this.zzfga = zzcwe;
    }

    public final boolean zza(zzcvz zzcvz, zzcvr zzcvr) {
        return (zzcvr.zzgje == null || zzcvr.zzgje.zzdib == null) ? false : true;
    }

    public final zzddi<zzbii> zzb(zzcvz zzcvz, zzcvr zzcvr) {
        return zzdcy.zzb(zzdcy.zzah(null), (zzdcj<? super I, ? extends O>) new zzcgj<Object,Object>(this, zzcvz, zzcvr), this.zzfbx);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zza(zzcvz zzcvz, zzcvr zzcvr, Object obj) throws Exception {
        zzua zza = zzcwi.zza(this.zzlk, zzcvr.zzgjg);
        zzbbw zzc = this.zzfnm.zzc(zza);
        zzbia zza2 = this.zzfxh.zza(new zzbla(zzcvz, zzcvr, null), new zzbid(zzc.getView(), zzc, zzcwi.zze(zza), zzcvr.zzfdf));
        zza2.zzacw().zzb(zzc, false);
        zza2.zzaci().zza(new zzcgi(zzc), zzaxn.zzdwn);
        zza2.zzacw();
        return zzdcy.zzb(zzbzn.zza(zzc, zzcvr.zzgje.zzdhz, zzcvr.zzgje.zzdib), (zzdal<? super I, ? extends O>) new zzcgl<Object,Object>(zza2), (Executor) zzaxn.zzdwn);
    }
}
