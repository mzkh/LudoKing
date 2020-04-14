package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzajj<I, O> implements zzdcj<I, O> {
    /* access modifiers changed from: private */
    public final zzair<O> zzdbe;
    private final zzaiq<I> zzdbf;
    private final String zzdbg;
    private final zzddi<zzail> zzdbl;

    zzajj(zzddi<zzail> zzddi, String str, zzaiq<I> zzaiq, zzair<O> zzair) {
        this.zzdbl = zzddi;
        this.zzdbg = str;
        this.zzdbf = zzaiq;
        this.zzdbe = zzair;
    }

    public final zzddi<O> zzf(I i) throws Exception {
        return zzdcy.zzb(this.zzdbl, (zzdcj<? super I, ? extends O>) new zzaji<Object,Object>(this, i), (Executor) zzaxn.zzdwn);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zza(Object obj, zzail zzail) throws Exception {
        zzaxv zzaxv = new zzaxv();
        zzq.zzkj();
        String zzvm = zzaul.zzvm();
        zzaea.zzcxs.zza(zzvm, (zzaez) new zzajl(this, zzaxv));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", zzvm);
        jSONObject.put("args", this.zzdbf.zzj(obj));
        zzail.zza(this.zzdbg, jSONObject);
        return zzaxv;
    }
}
