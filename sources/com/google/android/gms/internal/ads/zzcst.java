package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcst implements zzcrr<JSONObject> {
    private JSONObject zzghb;

    public zzcst(JSONObject jSONObject) {
        this.zzghb = jSONObject;
    }

    public final /* synthetic */ void zzr(Object obj) {
        try {
            ((JSONObject) obj).put("cache_state", this.zzghb);
        } catch (JSONException unused) {
            zzaug.zzdy("Unable to get cache_state");
        }
    }
}
