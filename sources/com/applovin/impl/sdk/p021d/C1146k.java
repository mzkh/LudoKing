package com.applovin.impl.sdk.p021d;

import android.os.Build.VERSION;
import com.applovin.impl.mediation.p016d.C0989b;
import com.applovin.impl.mediation.p016d.C0990c;
import com.applovin.impl.mediation.p016d.C0990c.C0992a;
import com.applovin.impl.sdk.C1179f;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1196j.C1200b;
import com.applovin.impl.sdk.network.C1215b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.ads.mediation.inmobi.InMobiNetworkValues;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.k */
public class C1146k extends C1122a {

    /* renamed from: a */
    private static int f2784a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AtomicBoolean f2785c = new AtomicBoolean();

    /* renamed from: com.applovin.impl.sdk.d.k$a */
    private class C1148a extends C1122a {
        public C1148a(C1192i iVar) {
            super("TaskTimeoutFetchBasicSettings", iVar, true);
        }

        /* renamed from: a */
        public C1115i mo9338a() {
            return C1115i.f2698g;
        }

        public void run() {
            if (!C1146k.this.f2785c.get()) {
                mo10072d("Timing out fetch basic settings...");
                C1146k.this.m2400a(new JSONObject());
            }
        }
    }

    public C1146k(C1192i iVar) {
        super("TaskFetchBasicSettings", iVar, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2400a(JSONObject jSONObject) {
        boolean z = true;
        if (this.f2785c.compareAndSet(false, true)) {
            C1246g.m2952d(jSONObject, this.f2745b);
            C1246g.m2951c(jSONObject, this.f2745b);
            if (jSONObject.length() != 0) {
                z = false;
            }
            C1246g.m2944a(jSONObject, z, this.f2745b);
            C0989b.m1763a(jSONObject, this.f2745b);
            C0989b.m1765b(jSONObject, this.f2745b);
            mo10070b("Executing initialize SDK...");
            this.f2745b.mo10253z().mo9304a(C1247h.m2963a(jSONObject, "smd", Boolean.valueOf(false), this.f2745b).booleanValue());
            C1246g.m2956f(jSONObject, this.f2745b);
            this.f2745b.mo10185K().mo10130a((C1122a) new C1157q(this.f2745b));
            C1246g.m2954e(jSONObject, this.f2745b);
            mo10070b("Finished executing initialize SDK");
        }
    }

    /* renamed from: d */
    private String m2401d() {
        return C1246g.m2941a((String) this.f2745b.mo10202a(C1096c.f2292aG), "5.0/i", mo10073e());
    }

    /* renamed from: i */
    private String m2402i() {
        return C1246g.m2941a((String) this.f2745b.mo10202a(C1096c.f2293aH), "5.0/i", mo10073e());
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2695d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Map<String, String> mo10111b() {
        HashMap hashMap = new HashMap();
        hashMap.put("rid", UUID.randomUUID().toString());
        if (!((Boolean) this.f2745b.mo10202a(C1096c.f2507eM)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2745b.mo10246t());
        }
        Boolean a = C1179f.m2526a(mo10075g());
        if (a != null) {
            hashMap.put("huc", a.toString());
        }
        Boolean b = C1179f.m2530b(mo10075g());
        if (b != null) {
            hashMap.put("aru", b.toString());
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public JSONObject mo10112c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_version", AppLovinSdk.VERSION);
            jSONObject.put("build", String.valueOf(131));
            int i = f2784a + 1;
            f2784a = i;
            jSONObject.put("init_count", String.valueOf(i));
            jSONObject.put("server_installed_at", C1277l.m3044d((String) this.f2745b.mo10202a(C1096c.f2282X)));
            if (this.f2745b.mo10182H()) {
                jSONObject.put("first_install", true);
            }
            if (!this.f2745b.mo10183I()) {
                jSONObject.put("first_install_v2", true);
            }
            String str = (String) this.f2745b.mo10202a(C1096c.f2522eb);
            if (C1277l.m3042b(str)) {
                jSONObject.put("plugin_version", C1277l.m3044d(str));
            }
            String n = this.f2745b.mo10240n();
            if (C1277l.m3042b(n)) {
                jSONObject.put("mediation_provider", C1277l.m3044d(n));
            }
            C0992a a = C0990c.m1768a(this.f2745b);
            jSONObject.put("installed_mediation_adapters", a.mo9530a());
            jSONObject.put("uninstalled_mediation_adapter_classnames", a.mo9531b());
            C1200b c = this.f2745b.mo10189O().mo10261c();
            jSONObject.put(InMobiNetworkValues.PACKAGE_NAME, C1277l.m3044d(c.f2980c));
            jSONObject.put(TapjoyConstants.TJC_APP_VERSION_NAME, C1277l.m3044d(c.f2979b));
            jSONObject.put("debug", C1277l.m3044d(c.f2983f));
            jSONObject.put(TapjoyConstants.TJC_PLATFORM, "android");
            jSONObject.put("os", C1277l.m3044d(VERSION.RELEASE));
            jSONObject.put("tg", this.f2745b.mo10203a(C1098e.f2561g));
            if (((Boolean) this.f2745b.mo10202a(C1096c.f2464dV)).booleanValue()) {
                jSONObject.put("compass_random_token", this.f2745b.mo10236j());
            }
            if (((Boolean) this.f2745b.mo10202a(C1096c.f2466dX)).booleanValue()) {
                jSONObject.put("applovin_random_token", this.f2745b.mo10237k());
            }
        } catch (JSONException e) {
            mo10069a("Failed to construct JSON body", e);
        }
        return jSONObject;
    }

    public void run() {
        Map b = mo10111b();
        C1215b a = C1215b.m2733a(this.f2745b).mo10324a(m2401d()).mo10333c(m2402i()).mo10325a(b).mo10326a(mo10112c()).mo10330b("POST").mo10323a(new JSONObject()).mo10322a(((Integer) this.f2745b.mo10202a(C1096c.f2448dF)).intValue()).mo10332c(((Integer) this.f2745b.mo10202a(C1096c.f2451dI)).intValue()).mo10329b(((Integer) this.f2745b.mo10202a(C1096c.f2447dE)).intValue()).mo10331b(true).mo10328a();
        this.f2745b.mo10185K().mo10132a(new C1148a(this.f2745b), C1161a.TIMEOUT, ((long) ((Integer) this.f2745b.mo10202a(C1096c.f2447dE)).intValue()) + 250);
        C11471 r1 = new C1173x<JSONObject>(a, this.f2745b, mo10076h()) {
            /* renamed from: a */
            public void mo9301a(int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to fetch basic SDK settings: server returned ");
                sb.append(i);
                mo10072d(sb.toString());
                C1146k.this.m2400a(new JSONObject());
            }

            /* renamed from: a */
            public void mo9302a(JSONObject jSONObject, int i) {
                C1146k.this.m2400a(jSONObject);
            }
        };
        r1.mo10153a(C1096c.f2294aI);
        r1.mo10155b(C1096c.f2295aJ);
        this.f2745b.mo10185K().mo10130a((C1122a) r1);
    }
}
