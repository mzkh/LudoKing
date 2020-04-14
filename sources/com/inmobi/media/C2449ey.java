package com.inmobi.media;

import androidx.annotation.Nullable;
import com.tapjoy.TapjoyConstants;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ey */
/* compiled from: CrashConfig */
public class C2449ey extends C2436er {

    /* renamed from: k */
    private static final String f5279k = "ey";

    /* renamed from: a */
    public String f5280a = "https://crash-metrics.sdk.inmobi.com/trace";

    /* renamed from: b */
    public long f5281b = 60;

    /* renamed from: c */
    public int f5282c = 3;

    /* renamed from: d */
    public int f5283d = 50;

    /* renamed from: e */
    public long f5284e = 259200;

    /* renamed from: f */
    public long f5285f = 86400;

    /* renamed from: g */
    public boolean f5286g = false;

    /* renamed from: h */
    public boolean f5287h = false;

    /* renamed from: i */
    public C2450a f5288i;

    /* renamed from: j */
    public C2450a f5289j;

    /* renamed from: com.inmobi.media.ey$a */
    /* compiled from: CrashConfig */
    public final class C2450a {

        /* renamed from: a */
        public long f5290a;

        /* renamed from: b */
        public int f5291b;

        /* renamed from: c */
        public int f5292c;

        public C2450a() {
        }

        /* renamed from: a */
        public final boolean mo28356a() {
            if (this.f5292c <= C2449ey.this.f5283d && this.f5290a > 0) {
                int i = this.f5292c;
                if (i > 0) {
                    int i2 = this.f5291b;
                    if (i2 > 0 && i2 <= i) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    public final String mo28340a() {
        return "crashReporting";
    }

    C2449ey(@Nullable String str) {
        String str2 = "maxBatchSize";
        String str3 = "minBatchSize";
        String str4 = "retryInterval";
        super(str);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str4, 10);
            jSONObject2.put(str3, 1);
            jSONObject2.put(str2, 2);
            jSONObject.put(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(str4, 10);
            jSONObject3.put(str3, 1);
            jSONObject3.put(str2, 2);
            jSONObject.put("others", jSONObject3);
            m5121b(jSONObject);
        } catch (JSONException unused) {
        }
    }

    /* renamed from: c */
    public final boolean mo28343c() {
        if (this.f5280a.trim().length() != 0 && (this.f5280a.startsWith("http://") || this.f5280a.startsWith("https://"))) {
            long j = this.f5285f;
            long j2 = this.f5281b;
            if (j >= j2) {
                long j3 = this.f5284e;
                if (j <= j3 && j3 >= j2 && this.f5288i.mo28356a() && this.f5289j.mo28356a() && this.f5281b > 0 && this.f5282c >= 0 && this.f5285f > 0 && this.f5284e > 0 && this.f5283d > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m5121b(JSONObject jSONObject) throws JSONException {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            C2450a aVar = new C2450a();
            aVar.f5290a = jSONObject2.getLong("retryInterval");
            aVar.f5291b = jSONObject2.getInt("minBatchSize");
            aVar.f5292c = jSONObject2.getInt("maxBatchSize");
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1068855134) {
                if (hashCode != -1006804125) {
                    if (hashCode == 3649301 && str.equals(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI)) {
                        c = 0;
                    }
                } else if (str.equals("others")) {
                    c = 2;
                }
            } else if (str.equals(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE)) {
                c = 1;
            }
            if (c != 0) {
                this.f5288i = aVar;
            } else {
                this.f5289j = aVar;
            }
        }
    }

    /* renamed from: a */
    public final void mo28341a(JSONObject jSONObject) throws JSONException {
        super.mo28341a(jSONObject);
        this.f5280a = jSONObject.getString("url");
        this.f5281b = jSONObject.getLong("processingInterval");
        this.f5282c = jSONObject.getInt("maxRetryCount");
        this.f5283d = jSONObject.getInt("maxEventsToPersist");
        this.f5284e = jSONObject.getLong("eventTTL");
        this.f5285f = jSONObject.getLong("txLatency");
        this.f5286g = jSONObject.getBoolean("crashEnabled");
        this.f5287h = jSONObject.getBoolean("catchEnabled");
        m5121b(jSONObject.getJSONObject("networkType"));
    }

    /* renamed from: b */
    public final JSONObject mo28342b() throws JSONException {
        JSONObject b = super.mo28342b();
        b.put("url", this.f5280a);
        b.put("processingInterval", this.f5281b);
        b.put("maxRetryCount", this.f5282c);
        b.put("maxEventsToPersist", this.f5283d);
        b.put("eventTTL", this.f5284e);
        b.put("txLatency", this.f5285f);
        b.put("crashEnabled", this.f5286g);
        b.put("catchEnabled", this.f5287h);
        JSONObject jSONObject = new JSONObject();
        C2450a aVar = this.f5289j;
        JSONObject jSONObject2 = new JSONObject();
        String str = "retryInterval";
        jSONObject2.put(str, aVar.f5290a);
        String str2 = "minBatchSize";
        jSONObject2.put(str2, aVar.f5291b);
        String str3 = "maxBatchSize";
        jSONObject2.put(str3, aVar.f5292c);
        jSONObject.put(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI, jSONObject2);
        C2450a aVar2 = this.f5288i;
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(str, aVar2.f5290a);
        jSONObject3.put(str2, aVar2.f5291b);
        jSONObject3.put(str3, aVar2.f5292c);
        jSONObject.put("others", jSONObject3);
        b.put("networkType", jSONObject);
        return b;
    }
}
