package com.applovin.impl.sdk.p020c;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1098e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.c.j */
public class C1116j {

    /* renamed from: a */
    private final C1192i f2719a;

    /* renamed from: b */
    private final C1227o f2720b;

    /* renamed from: c */
    private final Object f2721c = new Object();

    /* renamed from: d */
    private final Map<String, C1118b> f2722d = new HashMap();

    /* renamed from: com.applovin.impl.sdk.c.j$a */
    private static class C1117a {

        /* renamed from: a */
        static final String f2723a = m2270a("tk");

        /* renamed from: b */
        static final String f2724b = m2270a("tc");

        /* renamed from: c */
        static final String f2725c = m2270a("ec");

        /* renamed from: d */
        static final String f2726d = m2270a("dm");

        /* renamed from: e */
        static final String f2727e = m2270a("dv");

        /* renamed from: f */
        static final String f2728f = m2270a("dh");

        /* renamed from: g */
        static final String f2729g = m2270a("dl");

        /* renamed from: h */
        private static final Set<String> f2730h = new HashSet(7);

        /* renamed from: a */
        private static String m2270a(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("No key name specified");
            } else if (!f2730h.contains(str)) {
                f2730h.add(str);
                return str;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Key has already been used: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    /* renamed from: com.applovin.impl.sdk.c.j$b */
    private static class C1118b {

        /* renamed from: a */
        private final String f2731a;

        /* renamed from: b */
        private int f2732b = 0;

        /* renamed from: c */
        private int f2733c = 0;

        /* renamed from: d */
        private double f2734d = 0.0d;

        /* renamed from: e */
        private double f2735e = 0.0d;

        /* renamed from: f */
        private Long f2736f = null;

        /* renamed from: g */
        private Long f2737g = null;

        C1118b(String str) {
            this.f2731a = str;
        }

        C1118b(JSONObject jSONObject) throws JSONException {
            this.f2731a = jSONObject.getString(C1117a.f2723a);
            this.f2732b = jSONObject.getInt(C1117a.f2724b);
            this.f2733c = jSONObject.getInt(C1117a.f2725c);
            this.f2734d = jSONObject.getDouble(C1117a.f2726d);
            this.f2735e = jSONObject.getDouble(C1117a.f2727e);
            this.f2736f = Long.valueOf(jSONObject.optLong(C1117a.f2728f));
            this.f2737g = Long.valueOf(jSONObject.optLong(C1117a.f2729g));
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public String mo10051a() {
            return this.f2731a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo10052a(long j) {
            int i = this.f2732b;
            double d = this.f2734d;
            double d2 = this.f2735e;
            this.f2732b = i + 1;
            double d3 = (double) i;
            Double.isNaN(d3);
            double d4 = d * d3;
            double d5 = (double) j;
            Double.isNaN(d5);
            double d6 = d4 + d5;
            int i2 = this.f2732b;
            double d7 = (double) i2;
            Double.isNaN(d7);
            this.f2734d = d6 / d7;
            double d8 = (double) i2;
            Double.isNaN(d3);
            Double.isNaN(d8);
            double d9 = d3 / d8;
            Double.isNaN(d5);
            double pow = Math.pow(d - d5, 2.0d);
            double d10 = (double) this.f2732b;
            Double.isNaN(d10);
            this.f2735e = d9 * (d2 + (pow / d10));
            Long l = this.f2736f;
            if (l == null || j > l.longValue()) {
                this.f2736f = Long.valueOf(j);
            }
            Long l2 = this.f2737g;
            if (l2 == null || j < l2.longValue()) {
                this.f2737g = Long.valueOf(j);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo10053b() {
            this.f2733c++;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public JSONObject mo10054c() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C1117a.f2723a, this.f2731a);
            jSONObject.put(C1117a.f2724b, this.f2732b);
            jSONObject.put(C1117a.f2725c, this.f2733c);
            jSONObject.put(C1117a.f2726d, this.f2734d);
            jSONObject.put(C1117a.f2727e, this.f2735e);
            jSONObject.put(C1117a.f2728f, this.f2736f);
            jSONObject.put(C1117a.f2729g, this.f2737g);
            return jSONObject;
        }

        public String toString() {
            String str = "TaskStats{n='";
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(this.f2731a);
                sb.append('\'');
                sb.append(", stats=");
                sb.append(mo10054c().toString());
                sb.append('}');
                return sb.toString();
            } catch (JSONException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(this.f2731a);
                sb2.append('\'');
                sb2.append(", count=");
                sb2.append(this.f2732b);
                sb2.append('}');
                return sb2.toString();
            }
        }
    }

    public C1116j(C1192i iVar) {
        this.f2719a = iVar;
        this.f2720b = iVar.mo10249v();
        m2263c();
    }

    /* renamed from: b */
    private C1118b m2262b(C1115i iVar) {
        C1118b bVar;
        synchronized (this.f2721c) {
            String a = iVar.mo10045a();
            bVar = (C1118b) this.f2722d.get(a);
            if (bVar == null) {
                bVar = new C1118b(a);
                this.f2722d.put(a, bVar);
            }
        }
        return bVar;
    }

    /* renamed from: c */
    private void m2263c() {
        Set<String> set = (Set) this.f2719a.mo10203a(C1098e.f2568n);
        if (set != null) {
            synchronized (this.f2721c) {
                try {
                    for (String jSONObject : set) {
                        C1118b bVar = new C1118b(new JSONObject(jSONObject));
                        this.f2722d.put(bVar.mo10051a(), bVar);
                    }
                } catch (JSONException e) {
                    this.f2720b.mo10379b("TaskStatsManager", "Failed to convert stats json.", e);
                }
            }
        }
    }

    /* renamed from: d */
    private void m2264d() {
        HashSet hashSet;
        synchronized (this.f2721c) {
            hashSet = new HashSet(this.f2722d.size());
            for (C1118b bVar : this.f2722d.values()) {
                try {
                    hashSet.add(bVar.mo10054c().toString());
                } catch (JSONException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to serialize ");
                    sb.append(bVar);
                    this.f2720b.mo10379b("TaskStatsManager", sb.toString(), e);
                }
            }
        }
        this.f2719a.mo10209a(C1098e.f2568n, hashSet);
    }

    /* renamed from: a */
    public JSONArray mo10046a() {
        JSONArray jSONArray;
        synchronized (this.f2721c) {
            jSONArray = new JSONArray();
            for (C1118b bVar : this.f2722d.values()) {
                try {
                    jSONArray.put(bVar.mo10054c());
                } catch (JSONException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to serialize ");
                    sb.append(bVar);
                    this.f2720b.mo10379b("TaskStatsManager", sb.toString(), e);
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    public void mo10047a(C1115i iVar) {
        mo10049a(iVar, false, 0);
    }

    /* renamed from: a */
    public void mo10048a(C1115i iVar, long j) {
        if (iVar == null) {
            throw new IllegalArgumentException("No key specified");
        } else if (((Boolean) this.f2719a.mo10202a(C1096c.f2545ey)).booleanValue()) {
            synchronized (this.f2721c) {
                m2262b(iVar).mo10052a(j);
                m2264d();
            }
        }
    }

    /* renamed from: a */
    public void mo10049a(C1115i iVar, boolean z, long j) {
        if (iVar == null) {
            throw new IllegalArgumentException("No key specified");
        } else if (((Boolean) this.f2719a.mo10202a(C1096c.f2545ey)).booleanValue()) {
            synchronized (this.f2721c) {
                C1118b b = m2262b(iVar);
                b.mo10053b();
                if (z) {
                    b.mo10052a(j);
                }
                m2264d();
            }
        }
    }

    /* renamed from: b */
    public void mo10050b() {
        synchronized (this.f2721c) {
            this.f2722d.clear();
            this.f2719a.mo10226b(C1098e.f2568n);
        }
    }
}
