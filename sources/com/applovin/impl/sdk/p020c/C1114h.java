package com.applovin.impl.sdk.p020c;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p019b.C1098e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.c.h */
public class C1114h {

    /* renamed from: a */
    private final C1192i f2677a;

    /* renamed from: b */
    private final Map<String, Long> f2678b = new HashMap();

    public C1114h(C1192i iVar) {
        if (iVar != null) {
            this.f2677a = iVar;
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: e */
    private void m2250e() {
        try {
            this.f2677a.mo10209a(C1098e.f2566l, mo10042c().toString());
        } catch (Throwable th) {
            this.f2677a.mo10249v().mo10379b("GlobalStatsManager", "Unable to save stats", th);
        }
    }

    /* renamed from: a */
    public long mo10036a(C1113g gVar) {
        return mo10037a(gVar, 1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public long mo10037a(C1113g gVar, long j) {
        long longValue;
        synchronized (this.f2678b) {
            Long l = (Long) this.f2678b.get(gVar.mo10035a());
            if (l == null) {
                l = Long.valueOf(0);
            }
            longValue = l.longValue() + j;
            this.f2678b.put(gVar.mo10035a(), Long.valueOf(longValue));
        }
        m2250e();
        return longValue;
    }

    /* renamed from: a */
    public void mo10038a() {
        synchronized (this.f2678b) {
            this.f2678b.clear();
        }
        m2250e();
    }

    /* renamed from: b */
    public long mo10039b(C1113g gVar) {
        long longValue;
        synchronized (this.f2678b) {
            Long l = (Long) this.f2678b.get(gVar.mo10035a());
            if (l == null) {
                l = Long.valueOf(0);
            }
            longValue = l.longValue();
        }
        return longValue;
    }

    /* renamed from: b */
    public void mo10040b() {
        synchronized (this.f2678b) {
            for (C1113g a : C1113g.m2248b()) {
                this.f2678b.remove(a.mo10035a());
            }
            m2250e();
        }
    }

    /* renamed from: b */
    public void mo10041b(C1113g gVar, long j) {
        synchronized (this.f2678b) {
            this.f2678b.put(gVar.mo10035a(), Long.valueOf(j));
        }
        m2250e();
    }

    /* renamed from: c */
    public JSONObject mo10042c() throws JSONException {
        JSONObject jSONObject;
        synchronized (this.f2678b) {
            jSONObject = new JSONObject();
            for (Entry entry : this.f2678b.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    /* renamed from: c */
    public void mo10043c(C1113g gVar) {
        synchronized (this.f2678b) {
            this.f2678b.remove(gVar.mo10035a());
        }
        m2250e();
    }

    /* renamed from: d */
    public void mo10044d() {
        try {
            JSONObject jSONObject = new JSONObject((String) this.f2677a.mo10222b(C1098e.f2566l, "{}"));
            synchronized (this.f2678b) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String str = (String) keys.next();
                        this.f2678b.put(str, Long.valueOf(jSONObject.getLong(str)));
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            this.f2677a.mo10249v().mo10379b("GlobalStatsManager", "Unable to load stats", th);
        }
    }
}
