package com.applovin.impl.mediation.p014b;

import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p019b.C1095b;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.sdk.AppLovinPrivacySettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.e */
public class C0962e {

    /* renamed from: a */
    private final JSONObject f1840a;

    /* renamed from: b */
    protected final C1192i f1841b;

    /* renamed from: c */
    private final JSONObject f1842c;

    /* renamed from: d */
    private final Object f1843d = new Object();

    /* renamed from: e */
    private final Object f1844e = new Object();

    /* renamed from: f */
    private volatile String f1845f;

    public C0962e(JSONObject jSONObject, JSONObject jSONObject2, C1192i iVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (jSONObject2 == null) {
            throw new IllegalArgumentException("No full response specified");
        } else if (jSONObject != null) {
            this.f1841b = iVar;
            this.f1840a = jSONObject2;
            this.f1842c = jSONObject;
        } else {
            throw new IllegalArgumentException("No spec object specified");
        }
    }

    /* renamed from: a */
    private List<String> mo9450a(String str) {
        try {
            return C1247h.m2986b(mo9479a(str, new JSONArray()));
        } catch (JSONException unused) {
            return Collections.EMPTY_LIST;
        }
    }

    /* renamed from: a */
    private List<String> m1626a(List<String> list, Map<String, String> map) {
        Map a = mo9426a();
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            for (String str2 : a.keySet()) {
                str = str.replace(str2, m1629f((String) a.get(str2)));
            }
            for (String str3 : map.keySet()) {
                str = str.replace(str3, (CharSequence) map.get(str3));
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    /* renamed from: a */
    private Map<String, String> mo9426a() {
        try {
            return C1247h.m2973a(new JSONObject((String) this.f1841b.mo10202a(C1095b.f2258i)));
        } catch (JSONException unused) {
            return Collections.EMPTY_MAP;
        }
    }

    /* renamed from: e */
    private List<String> m1628e(String str) {
        try {
            return C1247h.m2986b(mo9485b(str, new JSONArray()));
        } catch (JSONException unused) {
            return Collections.EMPTY_LIST;
        }
    }

    /* renamed from: f */
    private String m1629f(String str) {
        String str2 = "";
        String b = mo9484b(str, str2);
        return C1277l.m3042b(b) ? b : mo9477a(str, str2);
    }

    /* renamed from: A */
    public boolean mo9464A() {
        return mo9488b("is_testing", Boolean.valueOf(false));
    }

    /* renamed from: B */
    public boolean mo9465B() {
        return mo9488b("run_on_ui_thread", Boolean.valueOf(true));
    }

    /* renamed from: C */
    public Bundle mo9466C() {
        String str = "server_parameters";
        if (mo9489c(str) instanceof JSONObject) {
            JSONObject a = mo9480a(str, (JSONObject) null);
            if (a != null) {
                return C1247h.m2991c(a);
            }
        }
        return Bundle.EMPTY;
    }

    /* renamed from: D */
    public long mo9467D() {
        return mo9483b("adapter_timeout_ms", ((Long) this.f1841b.mo10202a(C1095b.f2264o)).longValue());
    }

    /* renamed from: E */
    public boolean mo9468E() {
        return mo9469F() >= 0;
    }

    /* renamed from: F */
    public long mo9469F() {
        String str = "ad_refresh_ms";
        long b = mo9483b(str, -1);
        return b >= 0 ? b : mo9476a(str, ((Long) this.f1841b.mo10202a(C1095b.f2267r)).longValue());
    }

    /* renamed from: G */
    public long mo9470G() {
        long b = mo9483b("fullscreen_display_delay_ms", -1);
        return b >= 0 ? b : ((Long) this.f1841b.mo10202a(C1095b.f2233A)).longValue();
    }

    /* renamed from: H */
    public long mo9471H() {
        return mo9483b("init_completion_delay_ms", -1);
    }

    /* renamed from: I */
    public long mo9472I() {
        return mo9483b("ahdm", ((Long) this.f1841b.mo10202a(C1095b.f2234B)).longValue());
    }

    /* renamed from: J */
    public String mo9473J() {
        return this.f1845f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo9474a(String str, float f) {
        float a;
        synchronized (this.f1843d) {
            a = C1247h.m2961a(this.f1842c, str, f, this.f1841b);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo9475a(String str, int i) {
        int b;
        synchronized (this.f1843d) {
            b = C1247h.m2984b(this.f1842c, str, i, this.f1841b);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo9476a(String str, long j) {
        long a;
        synchronized (this.f1844e) {
            a = C1247h.m2962a(this.f1840a, str, j, this.f1841b);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo9477a(String str, String str2) {
        String b;
        synchronized (this.f1844e) {
            b = C1247h.m2985b(this.f1840a, str, str2, this.f1841b);
        }
        return b;
    }

    /* renamed from: a */
    public List<String> mo9478a(String str, Map<String, String> map) {
        if (str != null) {
            List a = mo9450a(str);
            List e = m1628e(str);
            ArrayList arrayList = new ArrayList(a.size() + e.size());
            arrayList.addAll(a);
            arrayList.addAll(e);
            return m1626a((List<String>) arrayList, map);
        }
        throw new IllegalArgumentException("No key specified");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONArray mo9479a(String str, JSONArray jSONArray) {
        JSONArray b;
        synchronized (this.f1844e) {
            b = C1247h.m2988b(this.f1840a, str, jSONArray, this.f1841b);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo9480a(String str, JSONObject jSONObject) {
        JSONObject b;
        synchronized (this.f1843d) {
            b = C1247h.m2989b(this.f1842c, str, jSONObject, this.f1841b);
        }
        return b;
    }

    /* renamed from: a */
    public boolean mo9481a(Context context) {
        String str = "huc";
        return mo9487b(str) ? mo9488b(str, Boolean.valueOf(false)) : mo9482a(str, Boolean.valueOf(AppLovinPrivacySettings.hasUserConsent(context)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo9482a(String str, Boolean bool) {
        boolean booleanValue;
        synchronized (this.f1844e) {
            booleanValue = C1247h.m2963a(this.f1840a, str, bool, this.f1841b).booleanValue();
        }
        return booleanValue;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public long mo9483b(String str, long j) {
        long a;
        synchronized (this.f1843d) {
            a = C1247h.m2962a(this.f1842c, str, j, this.f1841b);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo9484b(String str, String str2) {
        String b;
        synchronized (this.f1843d) {
            b = C1247h.m2985b(this.f1842c, str, str2, this.f1841b);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public JSONArray mo9485b(String str, JSONArray jSONArray) {
        JSONArray b;
        synchronized (this.f1843d) {
            b = C1247h.m2988b(this.f1842c, str, jSONArray, this.f1841b);
        }
        return b;
    }

    /* renamed from: b */
    public boolean mo9486b(Context context) {
        String str = "aru";
        return mo9487b(str) ? mo9488b(str, Boolean.valueOf(false)) : mo9482a(str, Boolean.valueOf(AppLovinPrivacySettings.isAgeRestrictedUser(context)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo9487b(String str) {
        boolean has;
        synchronized (this.f1843d) {
            has = this.f1842c.has(str);
        }
        return has;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo9488b(String str, Boolean bool) {
        boolean booleanValue;
        synchronized (this.f1843d) {
            booleanValue = C1247h.m2963a(this.f1842c, str, bool, this.f1841b).booleanValue();
        }
        return booleanValue;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Object mo9489c(String str) {
        Object opt;
        synchronized (this.f1843d) {
            opt = this.f1842c.opt(str);
        }
        return opt;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9490c(String str, long j) {
        synchronized (this.f1843d) {
            C1247h.m2990b(this.f1842c, str, j, this.f1841b);
        }
    }

    /* renamed from: d */
    public void mo9491d(String str) {
        this.f1845f = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediationAdapterSpec{adapterClass='");
        sb.append(mo9494y());
        sb.append("', adapterName='");
        sb.append(mo9495z());
        sb.append("', isTesting=");
        sb.append(mo9464A());
        sb.append(", isRefreshEnabled=");
        sb.append(mo9468E());
        sb.append(", getAdRefreshMillis=");
        sb.append(mo9469F());
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public JSONObject mo9492w() {
        JSONObject jSONObject;
        synchronized (this.f1844e) {
            jSONObject = this.f1840a;
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public JSONObject mo9493x() {
        JSONObject jSONObject;
        synchronized (this.f1843d) {
            jSONObject = this.f1842c;
        }
        return jSONObject;
    }

    /* renamed from: y */
    public String mo9494y() {
        return mo9484b("class", (String) null);
    }

    /* renamed from: z */
    public String mo9495z() {
        return mo9484b("name", (String) null);
    }
}
