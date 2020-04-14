package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbwv implements zzdal {
    private final JSONObject zzfch;
    private final zzbwq zzfou;

    zzbwv(zzbwq zzbwq, JSONObject jSONObject) {
        this.zzfou = zzbwq;
        this.zzfch = jSONObject;
    }

    public final Object apply(Object obj) {
        return this.zzfou.zza(this.zzfch, (List) obj);
    }
}
