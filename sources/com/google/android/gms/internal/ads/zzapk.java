package com.google.android.gms.internal.ads;

import com.unity.purchasing.googleplay.Consts;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzapk {
    private final int errorCode;
    private final String type;
    private String url;
    private final String zzdje;
    private final String zzdlq;
    private final boolean zzdlr;
    private final List<String> zzdne;
    private final String zzdnf;
    private final String zzdng;
    private final boolean zzdnh;
    private final String zzdni;
    private final boolean zzdnj;
    private final JSONObject zzdnk;

    public zzapk(JSONObject jSONObject) {
        List<String> list;
        this.url = jSONObject.optString("url");
        this.zzdnf = jSONObject.optString("base_uri");
        this.zzdng = jSONObject.optString("post_parameters");
        String optString = jSONObject.optString("drt_include");
        int i = 1;
        this.zzdnh = optString != null && (optString.equals("1") || optString.equals("true"));
        this.zzdje = jSONObject.optString(Consts.INAPP_REQUEST_ID);
        this.type = jSONObject.optString("type");
        String optString2 = jSONObject.optString("errors");
        if (optString2 == null) {
            list = null;
        } else {
            list = Arrays.asList(optString2.split(","));
        }
        this.zzdne = list;
        if (jSONObject.optInt("valid", 0) == 1) {
            i = -2;
        }
        this.errorCode = i;
        this.zzdni = jSONObject.optString("fetched_ad");
        this.zzdnj = jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        this.zzdnk = optJSONObject;
        this.zzdlq = jSONObject.optString("analytics_query_ad_event_id");
        this.zzdlr = jSONObject.optBoolean("is_analytics_logging_enabled");
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final List<String> zztd() {
        return this.zzdne;
    }

    public final String zzte() {
        return this.zzdnf;
    }

    public final String zztf() {
        return this.zzdng;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean zztg() {
        return this.zzdnh;
    }

    public final JSONObject zzth() {
        return this.zzdnk;
    }
}
