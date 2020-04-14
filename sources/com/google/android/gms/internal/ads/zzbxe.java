package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbxe {
    private final Executor zzfbx;
    private final zzcwe zzfga;
    private final zzbzl zzfnm;
    private final Context zzlk;

    public zzbxe(Context context, zzcwe zzcwe, Executor executor, zzbzl zzbzl) {
        this.zzlk = context;
        this.zzfga = zzcwe;
        this.zzfbx = executor;
        this.zzfnm = zzbzl;
    }

    public final zzddi<zzbbw> zzm(JSONObject jSONObject) {
        return zzdcy.zzb(zzdcy.zzb(zzdcy.zzah(null), (zzdcj<? super I, ? extends O>) new zzbxj<Object,Object>(this), this.zzfbx), (zzdcj<? super I, ? extends O>) new zzbxh<Object,Object>(this, jSONObject), this.zzfbx);
    }

    public final zzddi<zzbbw> zzp(String str, String str2) {
        return zzdcy.zzb(zzdcy.zzah(null), (zzdcj<? super I, ? extends O>) new zzbxg<Object,Object>(this, str, str2), this.zzfbx);
    }

    private final void zzk(zzbbw zzbbw) {
        zzbbw.zza("/video", zzaea.zzcxp);
        zzbbw.zza("/videoMeta", zzaea.zzcxq);
        zzbbw.zza("/precache", (zzaer<? super zzbbw>) new zzbbg<Object>());
        zzbbw.zza("/delayPageLoaded", zzaea.zzcxt);
        zzbbw.zza("/instrument", zzaea.zzcxr);
        zzbbw.zza("/log", zzaea.zzcxk);
        zzbbw.zza("/videoClicked", zzaea.zzcxl);
        zzbbw.zzzp().zzar(true);
        zzbbw.zza("/click", zzaea.zzcxg);
        if (this.zzfga.zzdkl != null) {
            zzbbw.zza("/open", (zzaer<? super zzbbw>) new zzaev<Object>(null, null));
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zzq(Object obj) throws Exception {
        zzbbw zza = this.zzfnm.zza(zzua.zzg(this.zzlk), false);
        zzaxw zzl = zzaxw.zzl(zza);
        zzk(zza);
        zza.zzzp().zza((zzbdi) new zzbxi(zzl));
        zza.loadUrl((String) zzuv.zzon().zzd(zzza.zzcod));
        return zzl;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zza(String str, String str2, Object obj) throws Exception {
        zzbbw zza = this.zzfnm.zza(zzua.zzg(this.zzlk), false);
        zzaxw zzl = zzaxw.zzl(zza);
        zzk(zza);
        if (this.zzfga.zzdkl != null) {
            zza.zza(zzbdj.zzaat());
        } else {
            zza.zza(zzbdj.zzaas());
        }
        zza.zzzp().zza((zzbdf) new zzbxl(this, zza, zzl));
        zza.zzb(str, str2, null);
        return zzl;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(zzbbw zzbbw, zzaxw zzaxw, boolean z) {
        if (!(this.zzfga.zzgkf == null || zzbbw.zzxl() == null)) {
            zzbbw.zzxl().zzb(this.zzfga.zzgkf);
        }
        zzaxw.zzwp();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zza(JSONObject jSONObject, zzbbw zzbbw) throws Exception {
        zzaxw zzl = zzaxw.zzl(zzbbw);
        if (this.zzfga.zzdkl != null) {
            zzbbw.zza(zzbdj.zzaat());
        } else {
            zzbbw.zza(zzbdj.zzaas());
        }
        zzbbw.zzzp().zza((zzbdf) new zzbxk(this, zzbbw, zzl));
        zzbbw.zza("google.afma.nativeAds.renderVideo", jSONObject);
        return zzl;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzb(zzbbw zzbbw, zzaxw zzaxw, boolean z) {
        if (!(this.zzfga.zzgkf == null || zzbbw.zzxl() == null)) {
            zzbbw.zzxl().zzb(this.zzfga.zzgkf);
        }
        zzaxw.zzwp();
    }
}
