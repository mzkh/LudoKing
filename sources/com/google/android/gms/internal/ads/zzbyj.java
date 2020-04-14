package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbyj implements zzdcj {
    private final String zzcyz;
    private final zzbyh zzfpo;
    private final JSONObject zzfps;

    zzbyj(zzbyh zzbyh, String str, JSONObject jSONObject) {
        this.zzfpo = zzbyh;
        this.zzcyz = str;
        this.zzfps = jSONObject;
    }

    public final zzddi zzf(Object obj) {
        return this.zzfpo.zza(this.zzcyz, this.zzfps, (zzbbw) obj);
    }
}
