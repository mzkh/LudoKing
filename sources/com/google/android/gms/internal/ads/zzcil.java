package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcil implements zzdcj {
    static final zzdcj zzbkv = new zzcil();

    private zzcil() {
    }

    public final zzddi zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("success")) {
            return zzdcy.zzah(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzaim("process json failed");
    }
}
