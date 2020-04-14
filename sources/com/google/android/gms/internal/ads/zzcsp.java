package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcsp implements zzcrr<JSONObject> {
    private final JSONObject zzggx;

    public zzcsp(JSONObject jSONObject) {
        this.zzggx = jSONObject;
    }

    public final /* synthetic */ void zzr(Object obj) {
        try {
            JSONObject zzb = zzawg.zzb((JSONObject) obj, "content_info");
            JSONObject jSONObject = this.zzggx;
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                zzb.put(str, jSONObject.get(str));
            }
        } catch (JSONException unused) {
            zzaug.zzdy("Failed putting app indexing json.");
        }
    }
}
