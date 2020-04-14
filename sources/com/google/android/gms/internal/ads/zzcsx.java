package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcsx implements zzcru<zzcrr<JSONObject>> {
    private final JSONObject zzghe;

    zzcsx(Context context) {
        this.zzghe = zzapq.zzy(context);
    }

    public final zzddi<zzcrr<JSONObject>> zzalv() {
        return zzdcy.zzah(new zzcta(this));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzo(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zzghe);
        } catch (JSONException unused) {
            zzaug.zzdy("Failed putting version constants.");
        }
    }
}
