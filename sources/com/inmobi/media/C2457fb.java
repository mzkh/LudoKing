package com.inmobi.media;

import androidx.annotation.Nullable;
import com.appsflyer.share.Constants;
import com.google.android.gms.nearby.messages.Strategy;
import com.tapjoy.TJAdUnitConstants.String;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.fb */
/* compiled from: SignalsConfig */
public final class C2457fb extends C2436er {

    /* renamed from: d */
    private static final String f5313d = C2436er.class.getSimpleName();

    /* renamed from: a */
    public C2459b f5314a = new C2459b();

    /* renamed from: b */
    public C2458a f5315b = new C2458a();
    @Nullable

    /* renamed from: c */
    public JSONObject f5316c;

    /* renamed from: com.inmobi.media.fb$a */
    /* compiled from: SignalsConfig */
    public static class C2458a {

        /* renamed from: a */
        public boolean f5317a = false;

        /* renamed from: b */
        public String f5318b = "https://dock.inmobi.com/carb/v1/i";

        /* renamed from: c */
        public String f5319c = "https://dock.inmobi.com/carb/v1/o";

        /* renamed from: d */
        public int f5320d = Strategy.TTL_SECONDS_MAX;

        /* renamed from: e */
        public int f5321e = 3;

        /* renamed from: f */
        public int f5322f = 60;

        /* renamed from: g */
        public int f5323g = 60;

        /* renamed from: h */
        public long f5324h = 307200;
    }

    /* renamed from: com.inmobi.media.fb$b */
    /* compiled from: SignalsConfig */
    public static class C2459b {

        /* renamed from: a */
        public int f5325a = Strategy.TTL_SECONDS_DEFAULT;

        /* renamed from: b */
        public int f5326b = 3;

        /* renamed from: c */
        public boolean f5327c = false;

        /* renamed from: d */
        public boolean f5328d = false;

        /* renamed from: e */
        public int f5329e = 0;

        /* renamed from: f */
        public boolean f5330f = false;

        /* renamed from: g */
        public boolean f5331g = false;

        /* renamed from: h */
        public int f5332h = 0;

        /* renamed from: i */
        public boolean f5333i = false;

        /* renamed from: j */
        public boolean f5334j = false;

        /* renamed from: k */
        public boolean f5335k = false;
    }

    /* renamed from: a */
    public final String mo28340a() {
        return "signals";
    }

    C2457fb(@Nullable String str) {
        super(str);
    }

    /* renamed from: a */
    public final void mo28341a(JSONObject jSONObject) throws JSONException {
        super.mo28341a(jSONObject);
        JSONObject jSONObject2 = jSONObject.getJSONObject("ice");
        this.f5314a.f5325a = jSONObject2.getInt("sampleInterval");
        this.f5314a.f5326b = jSONObject2.getInt("stopRequestTimeout");
        this.f5314a.f5327c = jSONObject2.getBoolean("locationEnabled");
        this.f5314a.f5328d = jSONObject2.getBoolean("sessionEnabled");
        JSONObject jSONObject3 = jSONObject2.getJSONObject("w");
        this.f5314a.f5329e = jSONObject3.getInt("wf");
        this.f5314a.f5331g = jSONObject3.getBoolean("cwe");
        this.f5314a.f5330f = jSONObject3.getBoolean("vwe");
        JSONObject jSONObject4 = jSONObject2.getJSONObject(Constants.URL_CAMPAIGN);
        this.f5314a.f5333i = jSONObject4.getBoolean("oe");
        this.f5314a.f5335k = jSONObject4.getBoolean("cce");
        this.f5314a.f5334j = jSONObject4.getBoolean("vce");
        this.f5314a.f5332h = jSONObject4.getInt("cof");
        JSONObject jSONObject5 = jSONObject.getJSONObject("carb");
        this.f5315b.f5317a = jSONObject5.getBoolean(String.ENABLED);
        this.f5315b.f5318b = jSONObject5.getString("getEndPoint");
        this.f5315b.f5319c = jSONObject5.getString("postEndPoint");
        this.f5315b.f5320d = jSONObject5.getInt("retrieveFrequency");
        this.f5315b.f5321e = jSONObject5.getInt("maxRetries");
        this.f5315b.f5322f = jSONObject5.getInt("retryInterval");
        this.f5315b.f5323g = jSONObject5.getInt("timeoutInterval");
        this.f5315b.f5324h = jSONObject5.getLong("maxGetResponseSize");
        this.f5316c = jSONObject.optJSONObject("ext");
    }

    /* renamed from: b */
    public final JSONObject mo28342b() throws JSONException {
        JSONObject b = super.mo28342b();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sampleInterval", this.f5314a.f5325a);
        jSONObject.put("stopRequestTimeout", this.f5314a.f5326b);
        jSONObject.put("locationEnabled", this.f5314a.f5327c);
        jSONObject.put("sessionEnabled", this.f5314a.f5328d);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("wf", this.f5314a.f5329e);
        jSONObject2.put("vwe", this.f5314a.f5330f);
        jSONObject2.put("cwe", this.f5314a.f5331g);
        jSONObject.put("w", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("cof", this.f5314a.f5332h);
        jSONObject3.put("vce", this.f5314a.f5334j);
        jSONObject3.put("cce", this.f5314a.f5335k);
        jSONObject3.put("oe", this.f5314a.f5333i);
        jSONObject.put(Constants.URL_CAMPAIGN, jSONObject3);
        b.put("ice", jSONObject);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put(String.ENABLED, this.f5315b.f5317a);
        jSONObject4.put("getEndPoint", this.f5315b.f5318b);
        jSONObject4.put("postEndPoint", this.f5315b.f5319c);
        jSONObject4.put("retrieveFrequency", this.f5315b.f5320d);
        jSONObject4.put("maxRetries", this.f5315b.f5321e);
        jSONObject4.put("retryInterval", this.f5315b.f5322f);
        jSONObject4.put("timeoutInterval", this.f5315b.f5323g);
        jSONObject4.put("maxGetResponseSize", this.f5315b.f5324h);
        b.put("carb", jSONObject4);
        b.put("ext", this.f5316c);
        return b;
    }

    /* renamed from: c */
    public final boolean mo28343c() {
        if (this.f5314a.f5325a >= 0 && this.f5314a.f5326b >= 0 && this.f5314a.f5329e >= 0 && this.f5314a.f5332h >= 0 && this.f5315b.f5318b.trim().length() != 0 && this.f5315b.f5319c.trim().length() != 0) {
            String str = "http://";
            String str2 = "https://";
            if ((this.f5315b.f5318b.startsWith(str) || this.f5315b.f5318b.startsWith(str2)) && ((this.f5315b.f5319c.startsWith(str) || this.f5315b.f5319c.startsWith(str2)) && this.f5315b.f5320d >= 0 && this.f5315b.f5321e >= 0 && this.f5315b.f5322f >= 0 && this.f5315b.f5323g >= 0 && this.f5315b.f5324h >= 0)) {
                return true;
            }
        }
        return false;
    }
}
