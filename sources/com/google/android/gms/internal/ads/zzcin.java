package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcin implements Callable {
    private final zzddi zzffr;
    private final zzddi zzfoe;
    private final zzcvz zzfyo;
    private final zzcig zzfyv;
    private final zzcvr zzfyw;
    private final JSONObject zzfyx;

    zzcin(zzcig zzcig, zzddi zzddi, zzddi zzddi2, zzcvz zzcvz, zzcvr zzcvr, JSONObject jSONObject) {
        this.zzfyv = zzcig;
        this.zzfoe = zzddi;
        this.zzffr = zzddi2;
        this.zzfyo = zzcvz;
        this.zzfyw = zzcvr;
        this.zzfyx = jSONObject;
    }

    public final Object call() {
        return this.zzfyv.zza(this.zzfoe, this.zzffr, this.zzfyo, this.zzfyw, this.zzfyx);
    }
}
