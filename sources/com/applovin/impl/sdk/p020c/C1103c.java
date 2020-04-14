package com.applovin.impl.sdk.p020c;

import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.network.C1215b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.p021d.C1173x;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.c.c */
public class C1103c {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1192i f2622a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1227o f2623b;

    /* renamed from: c */
    private final Object f2624c = new Object();

    /* renamed from: d */
    private final C1107c f2625d = new C1107c();

    /* renamed from: com.applovin.impl.sdk.c.c$a */
    private static class C1105a {

        /* renamed from: a */
        private final C1192i f2627a;

        /* renamed from: b */
        private final JSONObject f2628b;

        private C1105a(String str, String str2, String str3, C1192i iVar) {
            this.f2628b = new JSONObject();
            this.f2627a = iVar;
            C1247h.m2979a(this.f2628b, "pk", str, iVar);
            C1247h.m2990b(this.f2628b, "ts", System.currentTimeMillis(), iVar);
            if (C1277l.m3042b(str2)) {
                C1247h.m2979a(this.f2628b, "sk1", str2, iVar);
            }
            if (C1277l.m3042b(str3)) {
                C1247h.m2979a(this.f2628b, "sk2", str3, iVar);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String m2202a() throws OutOfMemoryError {
            return this.f2628b.toString();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo9996a(String str, long j) {
            mo9998b(str, C1247h.m2962a(this.f2628b, str, 0, this.f2627a) + j);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo9997a(String str, String str2) {
            JSONArray b = C1247h.m2988b(this.f2628b, str, new JSONArray(), this.f2627a);
            b.put(str2);
            C1247h.m2980a(this.f2628b, str, b, this.f2627a);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo9998b(String str, long j) {
            C1247h.m2990b(this.f2628b, str, j, this.f2627a);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AdEventStats{stats='");
            sb.append(this.f2628b);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    /* renamed from: com.applovin.impl.sdk.c.c$b */
    public class C1106b {

        /* renamed from: b */
        private final AppLovinAdBase f2630b;

        /* renamed from: c */
        private final C1103c f2631c;

        public C1106b(AppLovinAdBase appLovinAdBase, C1103c cVar) {
            this.f2630b = appLovinAdBase;
            this.f2631c = cVar;
        }

        /* renamed from: a */
        public C1106b mo10000a(C1102b bVar) {
            this.f2631c.m2184a(bVar, 1, this.f2630b);
            return this;
        }

        /* renamed from: a */
        public C1106b mo10001a(C1102b bVar, long j) {
            this.f2631c.m2190b(bVar, j, this.f2630b);
            return this;
        }

        /* renamed from: a */
        public C1106b mo10002a(C1102b bVar, String str) {
            this.f2631c.m2185a(bVar, str, this.f2630b);
            return this;
        }

        /* renamed from: a */
        public void mo10003a() {
            this.f2631c.m2196e();
        }
    }

    /* renamed from: com.applovin.impl.sdk.c.c$c */
    private class C1107c extends LinkedHashMap<String, C1105a> {
        private C1107c() {
        }

        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Entry<String, C1105a> entry) {
            return size() > ((Integer) C1103c.this.f2622a.mo10202a(C1096c.f2543ew)).intValue();
        }
    }

    public C1103c(C1192i iVar) {
        if (iVar != null) {
            this.f2622a = iVar;
            this.f2623b = iVar.mo10249v();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2184a(C1102b bVar, long j, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (bVar == null) {
            throw new IllegalArgumentException("No key specified");
        } else if (((Boolean) this.f2622a.mo10202a(C1096c.f2540et)).booleanValue()) {
            synchronized (this.f2624c) {
                m2189b(appLovinAdBase).mo9996a(((Boolean) this.f2622a.mo10202a(C1096c.f2544ex)).booleanValue() ? bVar.mo9992b() : bVar.mo9991a(), j);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2185a(C1102b bVar, String str, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (bVar == null) {
            throw new IllegalArgumentException("No key specified");
        } else if (((Boolean) this.f2622a.mo10202a(C1096c.f2540et)).booleanValue()) {
            synchronized (this.f2625d) {
                m2189b(appLovinAdBase).mo9997a(((Boolean) this.f2622a.mo10202a(C1096c.f2544ex)).booleanValue() ? bVar.mo9992b() : bVar.mo9991a(), str);
            }
        }
    }

    /* renamed from: a */
    private void m2188a(JSONObject jSONObject) {
        C11041 r0 = new C1173x<Object>(C1215b.m2733a(this.f2622a).mo10324a(m2194c()).mo10333c(m2195d()).mo10325a(C1246g.m2953e(this.f2622a)).mo10330b("POST").mo10326a(jSONObject).mo10329b(((Integer) this.f2622a.mo10202a(C1096c.f2541eu)).intValue()).mo10322a(((Integer) this.f2622a.mo10202a(C1096c.f2542ev)).intValue()).mo10328a(), this.f2622a) {
            /* renamed from: a */
            public void mo9301a(int i) {
                C1227o a = C1103c.this.f2623b;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to submitted ad stats: ");
                sb.append(i);
                a.mo10382e("AdEventStatsManager", sb.toString());
            }

            /* renamed from: a */
            public void mo9302a(Object obj, int i) {
                C1227o a = C1103c.this.f2623b;
                StringBuilder sb = new StringBuilder();
                sb.append("Ad stats submitted: ");
                sb.append(i);
                a.mo10378b("AdEventStatsManager", sb.toString());
            }
        };
        r0.mo10153a(C1096c.f2296aK);
        r0.mo10155b(C1096c.f2297aL);
        this.f2622a.mo10185K().mo10131a((C1122a) r0, C1161a.BACKGROUND);
    }

    /* renamed from: b */
    private C1105a m2189b(AppLovinAdBase appLovinAdBase) {
        C1105a aVar;
        synchronized (this.f2624c) {
            String primaryKey = appLovinAdBase.getPrimaryKey();
            aVar = (C1105a) this.f2625d.get(primaryKey);
            if (aVar == null) {
                C1105a aVar2 = new C1105a(primaryKey, appLovinAdBase.getSecondaryKey1(), appLovinAdBase.getSecondaryKey2(), this.f2622a);
                this.f2625d.put(primaryKey, aVar2);
                aVar = aVar2;
            }
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2190b(C1102b bVar, long j, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (bVar == null) {
            throw new IllegalArgumentException("No key specified");
        } else if (((Boolean) this.f2622a.mo10202a(C1096c.f2540et)).booleanValue()) {
            synchronized (this.f2624c) {
                m2189b(appLovinAdBase).mo9998b(((Boolean) this.f2622a.mo10202a(C1096c.f2544ex)).booleanValue() ? bVar.mo9992b() : bVar.mo9991a(), j);
            }
        }
    }

    /* renamed from: c */
    private String m2194c() {
        return C1246g.m2940a("2.0/s", this.f2622a);
    }

    /* renamed from: d */
    private String m2195d() {
        return C1246g.m2950b("2.0/s", this.f2622a);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2196e() {
        HashSet hashSet;
        if (((Boolean) this.f2622a.mo10202a(C1096c.f2540et)).booleanValue()) {
            synchronized (this.f2624c) {
                hashSet = new HashSet(this.f2625d.size());
                for (C1105a aVar : this.f2625d.values()) {
                    try {
                        hashSet.add(aVar.m2202a());
                    } catch (OutOfMemoryError e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to serialize ");
                        sb.append(aVar);
                        sb.append(" due to OOM error");
                        this.f2623b.mo10379b("AdEventStatsManager", sb.toString(), e);
                        mo9995b();
                    }
                }
            }
            this.f2622a.mo10209a(C1098e.f2573s, hashSet);
        }
    }

    /* renamed from: a */
    public C1106b mo9993a(AppLovinAdBase appLovinAdBase) {
        return new C1106b(appLovinAdBase, this);
    }

    /* renamed from: a */
    public void mo9994a() {
        if (((Boolean) this.f2622a.mo10202a(C1096c.f2540et)).booleanValue()) {
            Set<String> set = (Set) this.f2622a.mo10222b(C1098e.f2573s, new HashSet(0));
            this.f2622a.mo10226b(C1098e.f2573s);
            String str = "AdEventStatsManager";
            if (set == null || set.isEmpty()) {
                this.f2623b.mo10378b(str, "No serialized ad events found");
                return;
            }
            C1227o oVar = this.f2623b;
            StringBuilder sb = new StringBuilder();
            sb.append("De-serializing ");
            sb.append(set.size());
            sb.append(" stat ad events");
            oVar.mo10378b(str, sb.toString());
            JSONArray jSONArray = new JSONArray();
            for (String str2 : set) {
                try {
                    jSONArray.put(new JSONObject(str2));
                } catch (JSONException e) {
                    C1227o oVar2 = this.f2623b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to parse: ");
                    sb2.append(str2);
                    oVar2.mo10379b(str, sb2.toString(), e);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("stats", jSONArray);
                m2188a(jSONObject);
            } catch (JSONException e2) {
                this.f2623b.mo10379b(str, "Failed to create stats to submit", e2);
            }
        }
    }

    /* renamed from: b */
    public void mo9995b() {
        synchronized (this.f2624c) {
            this.f2623b.mo10378b("AdEventStatsManager", "Clearing ad stats...");
            this.f2625d.clear();
        }
    }
}
