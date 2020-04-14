package com.google.android.gms.internal.ads;

import com.facebook.share.internal.ShareConstants;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcdz implements zzdcj {
    private final zzcdw zzfuv;
    private final zztr zzfuw;

    zzcdz(zzcdw zzcdw, zztr zztr) {
        this.zzfuv = zzcdw;
        this.zzfuw = zztr;
    }

    public final zzddi zzf(Object obj) {
        zztr zztr = this.zzfuw;
        String str = (String) obj;
        String str2 = zztr.zzcbt;
        String str3 = zztr.zzcbu;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("headers", new JSONObject());
        jSONObject3.put("body", str2);
        jSONObject2.put("base_url", "");
        jSONObject2.put("signals", new JSONObject(str3));
        jSONObject.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", new JSONObject());
        return zzdcy.zzah(jSONObject);
    }
}
