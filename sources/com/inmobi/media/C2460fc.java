package com.inmobi.media;

import androidx.annotation.Nullable;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyConstants;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.fc */
/* compiled from: TelemetryConfig */
public class C2460fc extends C2436er {

    /* renamed from: p */
    private static final String f5336p = "fc";

    /* renamed from: q */
    private static final List<String> f5337q = new LinkedList();

    /* renamed from: a */
    public String f5338a = "https://telemetry.sdk.inmobi.com/metrics";

    /* renamed from: b */
    public long f5339b = 30;

    /* renamed from: c */
    public int f5340c = 1;

    /* renamed from: d */
    public int f5341d = 1000;

    /* renamed from: e */
    public long f5342e = 604800;

    /* renamed from: f */
    public boolean f5343f = false;

    /* renamed from: g */
    public long f5344g = 86400;

    /* renamed from: h */
    public double f5345h = 0.0d;

    /* renamed from: i */
    public List<String> f5346i = f5337q;

    /* renamed from: j */
    public boolean f5347j = true;

    /* renamed from: k */
    public C2462b f5348k;

    /* renamed from: l */
    public C2462b f5349l;

    /* renamed from: o */
    public C2461a f5350o;

    /* renamed from: com.inmobi.media.fc$a */
    /* compiled from: TelemetryConfig */
    public static final class C2461a {

        /* renamed from: a */
        public boolean f5351a;

        /* renamed from: b */
        public boolean f5352b;

        /* renamed from: c */
        public boolean f5353c;
    }

    /* renamed from: com.inmobi.media.fc$b */
    /* compiled from: TelemetryConfig */
    public final class C2462b {

        /* renamed from: a */
        public long f5354a;

        /* renamed from: b */
        public int f5355b;

        /* renamed from: c */
        public int f5356c;

        public C2462b() {
        }

        /* renamed from: a */
        public final boolean mo28380a() {
            if (this.f5356c <= C2460fc.this.f5341d && this.f5354a > 0) {
                int i = this.f5356c;
                if (i > 0) {
                    int i2 = this.f5355b;
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
        return "telemetry";
    }

    C2460fc(@Nullable String str) {
        String str2 = "base";
        String str3 = String.ENABLED;
        String str4 = "maxBatchSize";
        String str5 = "minBatchSize";
        String str6 = "retryInterval";
        super(str);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str6, 60);
            jSONObject2.put(str5, 5);
            jSONObject2.put(str4, 20);
            jSONObject.put(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(str6, 60);
            jSONObject3.put(str5, 5);
            jSONObject3.put(str4, 20);
            jSONObject.put("others", jSONObject3);
            m5154b(jSONObject);
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(str3, this.f5347j);
            jSONObject4.put(str2, jSONObject5);
            this.f5347j = jSONObject4.getJSONObject(str2).getBoolean(str3);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("video", true);
            jSONObject6.put(MessengerShareContentUtility.MEDIA_IMAGE, false);
            jSONObject6.put("gif", false);
            m5155c(jSONObject6);
            f5337q.clear();
            f5337q.add("SessionStarted");
            f5337q.add("ServerFill");
            f5337q.add("ServerNoFill");
            f5337q.add("ServerError");
            f5337q.add("AdLoadFailed");
            f5337q.add("AdLoadSuccessful");
            f5337q.add("BlockAutoRedirection");
            f5337q.add("AssetDownloaded");
            f5337q.add("CrashEventOccurred");
            f5337q.add("InvalidConfig");
            f5337q.add("ConfigFetched");
        } catch (JSONException unused) {
        }
    }

    /* renamed from: c */
    public final boolean mo28343c() {
        if (this.f5338a.trim().length() != 0 && (this.f5338a.startsWith("http://") || this.f5338a.startsWith("https://"))) {
            long j = this.f5344g;
            long j2 = this.f5339b;
            if (j >= j2) {
                long j3 = this.f5342e;
                if (j <= j3 && j3 >= j2 && this.f5348k.mo28380a() && this.f5349l.mo28380a() && this.f5339b > 0 && this.f5340c >= 0 && this.f5344g > 0 && this.f5342e > 0 && this.f5341d > 0 && this.f5345h >= 0.0d) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m5154b(JSONObject jSONObject) throws JSONException {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            C2462b bVar = new C2462b();
            bVar.f5354a = jSONObject2.getLong("retryInterval");
            bVar.f5355b = jSONObject2.getInt("minBatchSize");
            bVar.f5356c = jSONObject2.getInt("maxBatchSize");
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
                this.f5348k = bVar;
            } else {
                this.f5349l = bVar;
            }
        }
    }

    /* renamed from: c */
    private void m5155c(JSONObject jSONObject) {
        C2461a aVar = new C2461a();
        if (jSONObject != null) {
            aVar.f5353c = jSONObject.optBoolean("gif");
            aVar.f5351a = jSONObject.optBoolean("video", true);
            aVar.f5352b = jSONObject.optBoolean(MessengerShareContentUtility.MEDIA_IMAGE);
            this.f5350o = aVar;
        }
    }

    /* renamed from: a */
    public final void mo28341a(JSONObject jSONObject) throws JSONException {
        super.mo28341a(jSONObject);
        this.f5347j = jSONObject.getJSONObject("base").getBoolean(String.ENABLED);
        this.f5338a = jSONObject.getString("telemetryUrl");
        this.f5339b = jSONObject.getLong("processingInterval");
        this.f5340c = jSONObject.getInt("maxRetryCount");
        this.f5341d = jSONObject.getInt("maxEventsToPersist");
        this.f5342e = jSONObject.getLong("eventTTL");
        int i = 0;
        this.f5343f = jSONObject.optBoolean("disableAllGeneralEvents", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("priorityEvents");
        if (optJSONArray != null) {
            this.f5346i = new LinkedList();
            while (i < optJSONArray.length()) {
                try {
                    this.f5346i.add(optJSONArray.getString(i));
                    i++;
                } catch (JSONException unused) {
                }
            }
        }
        this.f5344g = jSONObject.getLong("txLatency");
        this.f5345h = jSONObject.optDouble("samplingFactor", 0.0d);
        m5154b(jSONObject.getJSONObject("networkType"));
        m5155c(jSONObject.optJSONObject("assetReporting"));
    }

    /* renamed from: b */
    public final JSONObject mo28342b() throws JSONException {
        JSONObject b = super.mo28342b();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(String.ENABLED, this.f5347j);
        b.put("base", jSONObject);
        b.put("telemetryUrl", this.f5338a);
        b.put("processingInterval", this.f5339b);
        b.put("maxRetryCount", this.f5340c);
        b.put("maxEventsToPersist", this.f5341d);
        b.put("eventTTL", this.f5342e);
        b.put("disableAllGeneralEvents", this.f5343f);
        b.put("priorityEvents", new JSONArray(this.f5346i));
        b.put("txLatency", this.f5344g);
        b.put("samplingFactor", this.f5345h);
        JSONObject jSONObject2 = new JSONObject();
        C2462b bVar = this.f5349l;
        JSONObject jSONObject3 = new JSONObject();
        String str = "retryInterval";
        jSONObject3.put(str, bVar.f5354a);
        String str2 = "minBatchSize";
        jSONObject3.put(str2, bVar.f5355b);
        String str3 = "maxBatchSize";
        jSONObject3.put(str3, bVar.f5356c);
        jSONObject2.put(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI, jSONObject3);
        C2462b bVar2 = this.f5348k;
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put(str, bVar2.f5354a);
        jSONObject4.put(str2, bVar2.f5355b);
        jSONObject4.put(str3, bVar2.f5356c);
        jSONObject2.put("others", jSONObject4);
        b.put("networkType", jSONObject2);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("video", this.f5350o.f5351a);
        jSONObject5.put(MessengerShareContentUtility.MEDIA_IMAGE, this.f5350o.f5352b);
        jSONObject5.put("gif", this.f5350o.f5353c);
        b.put("assetReporting", jSONObject5);
        return b;
    }
}
