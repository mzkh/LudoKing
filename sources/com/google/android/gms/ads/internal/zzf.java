package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdcj;
import com.google.android.gms.internal.ads.zzdcy;
import com.google.android.gms.internal.ads.zzddi;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzf implements zzdcj {
    static final zzdcj zzbkv = new zzf();

    private zzf() {
    }

    public final zzddi zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            zzq.zzkn().zzuh().zzeb(jSONObject.getString("appSettingsJson"));
        }
        return zzdcy.zzah(null);
    }
}
