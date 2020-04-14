package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzctg implements zzcrr<JSONObject> {
    private List<String> zzdjf;

    public zzctg(List<String> list) {
        this.zzdjf = list;
    }

    public final /* synthetic */ void zzr(Object obj) {
        try {
            ((JSONObject) obj).put("eid", TextUtils.join(",", this.zzdjf));
        } catch (JSONException unused) {
            zzaug.zzdy("Failed putting experiment ids.");
        }
    }
}
