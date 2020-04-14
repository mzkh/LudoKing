package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcdw {
    private final Executor executor;
    private final zzcwe zzfga;
    private final zzaxl zzfut;
    private final Context zzlk;

    public zzcdw(Context context, zzaxl zzaxl, zzcwe zzcwe, Executor executor2) {
        this.zzlk = context;
        this.zzfut = zzaxl;
        this.zzfga = zzcwe;
        this.executor = executor2;
    }

    public final zzddi<zzcvz> zzaki() {
        zzaip zza = zzq.zzkw().zzb(this.zzlk, this.zzfut).zza("google.afma.response.normalize", zzais.zzday, zzais.zzday);
        return zzdcy.zzb(zzdcy.zzb(zzdcy.zzb(zzdcy.zzah(""), (zzdcj<? super I, ? extends O>) new zzcdz<Object,Object>(this, this.zzfga.zzgkg.zzcck), this.executor), (zzdcj<? super I, ? extends O>) new zzcdy<Object,Object>(zza), this.executor), (zzdcj<? super I, ? extends O>) new zzceb<Object,Object>(this), this.executor);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zzn(JSONObject jSONObject) throws Exception {
        return zzdcy.zzah(new zzcvz(new zzcvy(this.zzfga), zzcvx.zza(new StringReader(jSONObject.toString()))));
    }
}
