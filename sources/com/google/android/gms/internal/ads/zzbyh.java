package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzc;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbyh {
    private final zzbcb zzbmi;
    private final zzaxl zzdio;
    private final zzdf zzegb;
    private final Executor zzfbx;
    private final zza zzfop;
    /* access modifiers changed from: private */
    public final zzbym zzfpp = new zzbym(null);
    private final zzaex zzfpq;
    private zzddi<zzbbw> zzfpr;
    private final Context zzlk;

    zzbyh(zzbyr zzbyr) {
        this.zzlk = zzbyr.zzlk;
        this.zzfbx = zzbyr.zzfbx;
        this.zzegb = zzbyr.zzegb;
        this.zzdio = zzbyr.zzdio;
        this.zzfop = zzbyr.zzfop;
        this.zzbmi = zzbyr.zzbmi;
        this.zzfpq = new zzaex();
    }

    public final synchronized void zzajg() {
        this.zzfpr = zzdcy.zzb(zzbcb.zza(this.zzlk, this.zzdio, (String) zzuv.zzon().zzd(zzza.zzcoa), this.zzegb, this.zzfop), (zzdal<? super I, ? extends O>) new zzbyg<Object,Object>(this), this.zzfbx);
        zzaxr.zza(this.zzfpr, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void destroy() {
        if (this.zzfpr != null) {
            zzdcy.zza(this.zzfpr, new zzbyi(this), this.zzfbx);
            this.zzfpr = null;
        }
    }

    public final synchronized zzddi<JSONObject> zzc(String str, JSONObject jSONObject) {
        if (this.zzfpr == null) {
            return zzdcy.zzah(null);
        }
        return zzdcy.zzb(this.zzfpr, (zzdcj<? super I, ? extends O>) new zzbyj<Object,Object>(this, str, jSONObject), this.zzfbx);
    }

    public final synchronized void zza(String str, zzaer<Object> zzaer) {
        if (this.zzfpr != null) {
            zzdcy.zza(this.zzfpr, new zzbyl(this, str, zzaer), this.zzfbx);
        }
    }

    public final synchronized void zzb(String str, zzaer<Object> zzaer) {
        if (this.zzfpr != null) {
            zzdcy.zza(this.zzfpr, new zzbyk(this, str, zzaer), this.zzfbx);
        }
    }

    public final synchronized void zza(String str, Map<String, ?> map) {
        if (this.zzfpr != null) {
            zzdcy.zza(this.zzfpr, new zzbyn(this, str, map), this.zzfbx);
        }
    }

    public final <T> void zza(WeakReference<T> weakReference, String str, zzaer<T> zzaer) {
        zzbyq zzbyq = new zzbyq(this, weakReference, str, zzaer, null);
        zza(str, (zzaer<Object>) zzbyq);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zza(String str, JSONObject jSONObject, zzbbw zzbbw) throws Exception {
        return this.zzfpq.zza(zzbbw, str, jSONObject);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzbbw zzm(zzbbw zzbbw) {
        zzbbw.zza("/result", (zzaer<? super zzbbw>) this.zzfpq);
        zzbdg zzzp = zzbbw.zzzp();
        zzbym zzbym = this.zzfpp;
        zzzp.zza(null, zzbym, zzbym, zzbym, zzbym, false, null, new zzc(this.zzlk, null, null), null, null);
        return zzbbw;
    }
}
