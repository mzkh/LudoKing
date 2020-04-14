package com.google.android.gms.internal.ads;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.zzq;
import com.unity.purchasing.googleplay.Consts;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcez implements zzaiq<zzcew> {
    zzcez() {
    }

    public final /* synthetic */ JSONObject zzj(Object obj) throws JSONException {
        zzcew zzcew = (zzcew) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzcew.zzfvm.zzte());
        jSONObject2.put("signals", zzcew.zzfvl);
        jSONObject3.put("body", zzcew.zzfvk.zzdko);
        jSONObject3.put("headers", zzq.zzkj().zzi(zzcew.zzfvk.zzab));
        jSONObject3.put(Consts.INAPP_RESPONSE_CODE, zzcew.zzfvk.zzfvt);
        jSONObject3.put("latency", zzcew.zzfvk.zzfvu);
        jSONObject.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzcew.zzfvm.zzth());
        return jSONObject;
    }
}
