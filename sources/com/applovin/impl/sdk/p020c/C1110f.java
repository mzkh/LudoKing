package com.applovin.impl.sdk.p020c;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1098e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.c.f */
public class C1110f {

    /* renamed from: a */
    private final List<C1112a> f2648a;

    /* renamed from: b */
    private final Object f2649b = new Object();

    /* renamed from: c */
    private final C1192i f2650c;

    /* renamed from: d */
    private final C1227o f2651d;

    /* renamed from: com.applovin.impl.sdk.c.f$a */
    private static class C1112a {

        /* renamed from: a */
        private final Long f2652a;

        /* renamed from: b */
        private final String f2653b;

        /* renamed from: c */
        private final String f2654c;

        /* renamed from: d */
        private final String f2655d;

        private C1112a(String str, Throwable th) {
            this.f2653b = str;
            this.f2652a = Long.valueOf(System.currentTimeMillis());
            String str2 = null;
            this.f2654c = th != null ? th.getClass().getName() : null;
            if (th != null) {
                str2 = th.getMessage();
            }
            this.f2655d = str2;
        }

        private C1112a(JSONObject jSONObject) throws JSONException {
            this.f2653b = jSONObject.getString("ms");
            this.f2652a = Long.valueOf(jSONObject.getLong("ts"));
            JSONObject optJSONObject = jSONObject.optJSONObject("ex");
            String str = null;
            this.f2654c = optJSONObject != null ? optJSONObject.getString("nm") : null;
            if (optJSONObject != null) {
                str = optJSONObject.getString("rn");
            }
            this.f2655d = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public JSONObject m2244a() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ms", this.f2653b);
            jSONObject.put("ts", this.f2652a);
            if (!TextUtils.isEmpty(this.f2654c)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("nm", this.f2654c);
                if (!TextUtils.isEmpty(this.f2655d)) {
                    jSONObject2.put("rn", this.f2655d);
                }
                jSONObject.put("ex", jSONObject2);
            }
            return jSONObject;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ErrorLog{timestampMillis=");
            sb.append(this.f2652a);
            sb.append(",message='");
            sb.append(this.f2653b);
            sb.append('\'');
            sb.append(",throwableName='");
            sb.append(this.f2654c);
            sb.append('\'');
            sb.append(",throwableReason='");
            sb.append(this.f2655d);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public C1110f(C1192i iVar) {
        this.f2650c = iVar;
        this.f2651d = iVar.mo10249v();
        this.f2648a = new ArrayList();
    }

    /* renamed from: d */
    private void m2239d() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.f2649b) {
            for (C1112a aVar : this.f2648a) {
                try {
                    jSONArray.put(aVar.m2244a());
                } catch (JSONException e) {
                    this.f2651d.mo10375a("ErrorManager", Boolean.valueOf(false), "Failed to convert error log into json.", e);
                    this.f2648a.remove(aVar);
                }
            }
        }
        this.f2650c.mo10209a(C1098e.f2567m, jSONArray.toString());
    }

    /* renamed from: a */
    public JSONArray mo10030a() {
        JSONArray jSONArray;
        synchronized (this.f2649b) {
            jSONArray = new JSONArray();
            for (C1112a a : this.f2648a) {
                try {
                    jSONArray.put(a.m2244a());
                } catch (JSONException e) {
                    this.f2651d.mo10375a("ErrorManager", Boolean.valueOf(false), "Failed to convert error log into json.", e);
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    public void mo10031a(String str, Throwable th) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f2649b) {
                if (this.f2648a.size() < ((Integer) this.f2650c.mo10202a(C1096c.f2495eA)).intValue()) {
                    this.f2648a.add(new C1112a(str, th));
                    m2239d();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo10032b() {
        String str = (String) this.f2650c.mo10222b(C1098e.f2567m, null);
        if (str != null) {
            synchronized (this.f2649b) {
                try {
                    this.f2648a.clear();
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            this.f2648a.add(new C1112a(jSONArray.getJSONObject(i)));
                        } catch (JSONException e) {
                            this.f2651d.mo10375a("ErrorManager", Boolean.valueOf(false), "Failed to convert error json into a log.", e);
                        }
                    }
                } catch (JSONException e2) {
                    this.f2651d.mo10379b("ErrorManager", "Unable to convert String to json.", e2);
                }
            }
        }
    }

    /* renamed from: c */
    public void mo10033c() {
        synchronized (this.f2649b) {
            this.f2648a.clear();
            this.f2650c.mo10226b(C1098e.f2567m);
        }
    }
}
