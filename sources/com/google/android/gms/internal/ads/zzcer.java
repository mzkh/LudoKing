package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import java.io.InputStream;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcer implements zzcxn {
    static final zzcxn zzftu = new zzcer();

    private zzcer() {
    }

    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        String str = NativeProtocol.BRIDGE_ARG_ERROR_CODE;
        if (jSONObject.optInt(str) == 6) {
            return (InputStream) zzais.zzdaz.zzd(jSONObject.getJSONObject("response"));
        }
        throw new zzcek(jSONObject.getString("error_reason"), jSONObject.optInt(str, 0));
    }
}
