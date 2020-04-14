package com.applovin.impl.mediation.p015c;

import android.app.Activity;
import android.graphics.Point;
import com.applovin.impl.mediation.C0994f;
import com.applovin.impl.mediation.p016d.C0989b;
import com.applovin.impl.mediation.p016d.C0990c;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1196j;
import com.applovin.impl.sdk.C1196j.C1199a;
import com.applovin.impl.sdk.C1196j.C1200b;
import com.applovin.impl.sdk.C1196j.C1201c;
import com.applovin.impl.sdk.C1196j.C1202d;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.network.C1211a.C1213b;
import com.applovin.impl.sdk.network.C1215b;
import com.applovin.impl.sdk.p019b.C1095b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.p020c.C1113g;
import com.applovin.impl.sdk.p020c.C1114h;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1173x;
import com.applovin.impl.sdk.utils.C1245f;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1248i;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.NativeProtocol;
import com.google.ads.mediation.inmobi.InMobiNetworkValues;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.c */
public class C0976c extends C1122a {

    /* renamed from: a */
    private final String f1874a;

    /* renamed from: c */
    private final MaxAdFormat f1875c;

    /* renamed from: d */
    private final C0994f f1876d;

    /* renamed from: e */
    private final JSONArray f1877e;

    /* renamed from: f */
    private final Activity f1878f;

    /* renamed from: g */
    private final MaxAdListener f1879g;

    public C0976c(String str, MaxAdFormat maxAdFormat, C0994f fVar, JSONArray jSONArray, Activity activity, C1192i iVar, MaxAdListener maxAdListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("TaskFetchMediatedAd ");
        sb.append(str);
        super(sb.toString(), iVar);
        this.f1874a = str;
        this.f1875c = maxAdFormat;
        this.f1876d = fVar;
        this.f1877e = jSONArray;
        this.f1878f = activity;
        this.f1879g = maxAdListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1697a(int i) {
        boolean z = i != 204;
        C1227o v = this.f2745b.mo10249v();
        String f = mo10074f();
        Boolean valueOf = Boolean.valueOf(z);
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to fetch ");
        sb.append(this.f1874a);
        sb.append(" ad: server returned ");
        sb.append(i);
        v.mo10374a(f, valueOf, sb.toString());
        if (i == -800) {
            this.f2745b.mo10186L().mo10036a(C1113g.f2669n);
        }
        m1704b(i);
    }

    /* renamed from: a */
    private void m1700a(C1114h hVar) {
        long b = hVar.mo10039b(C1113g.f2658c);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b > TimeUnit.MINUTES.toMillis((long) ((Integer) this.f2745b.mo10202a(C1096c.f2455dM)).intValue())) {
            hVar.mo10041b(C1113g.f2658c, currentTimeMillis);
            hVar.mo10043c(C1113g.f2659d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1701a(JSONObject jSONObject) {
        try {
            C1246g.m2952d(jSONObject, this.f2745b);
            C1246g.m2951c(jSONObject, this.f2745b);
            C1246g.m2956f(jSONObject, this.f2745b);
            C0989b.m1763a(jSONObject, this.f2745b);
            C0989b.m1765b(jSONObject, this.f2745b);
            this.f2745b.mo10185K().mo10130a((C1122a) m1702b(jSONObject));
        } catch (Throwable th) {
            mo10069a("Unable to process mediated ad response", th);
            m1704b(-800);
        }
    }

    /* renamed from: b */
    private C0981f m1702b(JSONObject jSONObject) {
        C0981f fVar = new C0981f(this.f1874a, this.f1875c, jSONObject, this.f1878f, this.f2745b, this.f1879g);
        return fVar;
    }

    /* renamed from: b */
    private String m1703b() {
        return C0989b.m1762a(this.f2745b);
    }

    /* renamed from: b */
    private void m1704b(int i) {
        C1248i.m2997a(this.f1879g, this.f1874a, i);
    }

    /* renamed from: c */
    private String m1705c() {
        return C0989b.m1764b(this.f2745b);
    }

    /* renamed from: c */
    private void m1706c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("loaded", new JSONArray(this.f2745b.mo10250w().mo9548a()));
            jSONObject2.put("failed", new JSONArray(this.f2745b.mo10250w().mo9549b()));
            jSONObject.put("classname_info", jSONObject2);
            jSONObject.put("initialized_adapters", this.f2745b.mo10251x().mo9546c());
            jSONObject.put("initialized_adapter_classnames", new JSONArray(this.f2745b.mo10251x().mo9545b()));
            jSONObject.put("installed_mediation_adapters", C0990c.m1768a(this.f2745b).mo9530a());
        } catch (Exception e) {
            mo10069a("Failed to populate adapter classnames", e);
        }
    }

    /* renamed from: d */
    private JSONObject m1707d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        m1709e(jSONObject);
        m1710f(jSONObject);
        m1708d(jSONObject);
        m1706c(jSONObject);
        jSONObject.put("sc", C1277l.m3044d((String) this.f2745b.mo10202a(C1096c.f2280V)));
        jSONObject.put("sc2", C1277l.m3044d((String) this.f2745b.mo10202a(C1096c.f2281W)));
        jSONObject.put("server_installed_at", C1277l.m3044d((String) this.f2745b.mo10202a(C1096c.f2282X)));
        String str = (String) this.f2745b.mo10203a(C1098e.f2578x);
        if (C1277l.m3042b(str)) {
            jSONObject.put("persisted_data", C1277l.m3044d(str));
        }
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2539es)).booleanValue()) {
            m1712h(jSONObject);
        }
        jSONObject.put("pnr", Boolean.toString(this.f2745b.mo10234h()));
        jSONObject.put("mediation_provider", this.f2745b.mo10240n());
        return jSONObject;
    }

    /* renamed from: d */
    private void m1708d(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.f1877e;
        if (jSONArray != null) {
            jSONObject.put("signal_data", jSONArray);
        }
    }

    /* renamed from: e */
    private void m1709e(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ad_unit_id", this.f1874a);
        jSONObject2.put("ad_format", C0990c.m1771b(this.f1875c));
        if (this.f1876d != null && ((Boolean) this.f2745b.mo10202a(C1095b.f2257h)).booleanValue()) {
            jSONObject2.put("extra_parameters", C1247h.m2976a(C1247h.m2971a(this.f1876d.mo9535a())));
        }
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2312aa)).booleanValue()) {
            jSONObject2.put("n", String.valueOf(this.f2745b.mo10218ab().mo10395a(this.f1874a)));
        }
        jSONObject.put("ad_info", jSONObject2);
    }

    /* renamed from: f */
    private void m1710f(JSONObject jSONObject) throws JSONException {
        C1196j O = this.f2745b.mo10189O();
        C1202d b = O.mo10260b();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("brand", b.f2999d);
        jSONObject2.put("brand_name", b.f3000e);
        jSONObject2.put("hardware", b.f3001f);
        jSONObject2.put("api_level", b.f3003h);
        jSONObject2.put("carrier", b.f3005j);
        jSONObject2.put(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, b.f3004i);
        jSONObject2.put("locale", b.f3006k);
        jSONObject2.put("model", b.f2996a);
        jSONObject2.put("os", b.f2997b);
        jSONObject2.put(TapjoyConstants.TJC_PLATFORM, b.f2998c);
        jSONObject2.put("revision", b.f3002g);
        jSONObject2.put("orientation_lock", b.f3007l);
        jSONObject2.put("tz_offset", b.f3013r);
        jSONObject2.put("aida", C1277l.m3038a(b.f2995I));
        jSONObject2.put("wvvc", b.f3014s);
        jSONObject2.put("adns", (double) b.f3008m);
        jSONObject2.put("adnsd", b.f3009n);
        jSONObject2.put("xdpi", (double) b.f3010o);
        jSONObject2.put("ydpi", (double) b.f3011p);
        jSONObject2.put("screen_size_in", b.f3012q);
        jSONObject2.put("sim", C1277l.m3038a(b.f3019x));
        jSONObject2.put("gy", C1277l.m3038a(b.f3020y));
        jSONObject2.put("is_tablet", C1277l.m3038a(b.f3021z));
        jSONObject2.put("tv", C1277l.m3038a(b.f2987A));
        jSONObject2.put("vs", C1277l.m3038a(b.f2988B));
        jSONObject2.put("lpm", b.f2989C);
        jSONObject2.put("fs", b.f2991E);
        jSONObject2.put("fm", b.f2992F.f3023b);
        jSONObject2.put("tm", b.f2992F.f3022a);
        jSONObject2.put("lmt", b.f2992F.f3024c);
        jSONObject2.put("lm", b.f2992F.f3025d);
        jSONObject2.put("adr", C1277l.m3038a(b.f3015t));
        jSONObject2.put("volume", b.f3017v);
        jSONObject2.put("network", C1246g.m2955f(this.f2745b));
        if (C1277l.m3042b(b.f3018w)) {
            jSONObject2.put("ua", b.f3018w);
        }
        if (C1277l.m3042b(b.f2990D)) {
            jSONObject2.put("so", b.f2990D);
        }
        C1201c cVar = b.f3016u;
        if (cVar != null) {
            jSONObject2.put("act", cVar.f2985a);
            jSONObject2.put("acm", cVar.f2986b);
        }
        Boolean bool = b.f2993G;
        if (bool != null) {
            jSONObject2.put("huc", bool.toString());
        }
        Boolean bool2 = b.f2994H;
        if (bool2 != null) {
            jSONObject2.put("aru", bool2.toString());
        }
        Point a = C1245f.m2928a(mo10075g());
        jSONObject2.put("dx", Integer.toString(a.x));
        jSONObject2.put("dy", Integer.toString(a.y));
        m1711g(jSONObject2);
        jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, jSONObject2);
        C1200b c = O.mo10261c();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(InMobiNetworkValues.PACKAGE_NAME, c.f2980c);
        jSONObject3.put("installer_name", c.f2981d);
        jSONObject3.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, c.f2978a);
        jSONObject3.put(TapjoyConstants.TJC_APP_VERSION_NAME, c.f2979b);
        jSONObject3.put("installed_at", c.f2984g);
        jSONObject3.put("tg", c.f2982e);
        jSONObject3.put("api_did", this.f2745b.mo10202a(C1096c.f2277S));
        jSONObject3.put("sdk_version", AppLovinSdk.VERSION);
        jSONObject3.put("build", 131);
        jSONObject3.put("test_ads", this.f2745b.mo10238l().isTestAdsEnabled());
        jSONObject3.put("first_install", String.valueOf(this.f2745b.mo10182H()));
        jSONObject3.put("first_install_v2", String.valueOf(!this.f2745b.mo10183I()));
        jSONObject3.put("debug", Boolean.toString(C1281o.m3107c(this.f2745b)));
        String i = this.f2745b.mo10235i();
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2462dT)).booleanValue() && C1277l.m3042b(i)) {
            jSONObject3.put("cuid", i);
        }
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2465dW)).booleanValue()) {
            jSONObject3.put("compass_random_token", this.f2745b.mo10236j());
        }
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2467dY)).booleanValue()) {
            jSONObject3.put("applovin_random_token", this.f2745b.mo10237k());
        }
        String str = (String) this.f2745b.mo10202a(C1096c.f2522eb);
        if (C1277l.m3042b(str)) {
            jSONObject3.put("plugin_version", str);
        }
        jSONObject.put("app_info", jSONObject3);
        C1213b a2 = this.f2745b.mo10184J().mo10293a();
        if (a2 != null) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("lrm_ts_ms", String.valueOf(a2.mo10297a()));
            jSONObject4.put("lrm_url", a2.mo10298b());
            jSONObject4.put("lrm_ct_ms", String.valueOf(a2.mo10300d()));
            jSONObject4.put("lrm_rs", String.valueOf(a2.mo10299c()));
            jSONObject.put("connection_info", jSONObject4);
        }
    }

    /* renamed from: g */
    private void m1711g(JSONObject jSONObject) {
        try {
            C1199a d = this.f2745b.mo10189O().mo10262d();
            String str = d.f2977b;
            if (C1277l.m3042b(str)) {
                jSONObject.put("idfa", str);
            }
            jSONObject.put("dnt", d.f2976a);
        } catch (Throwable th) {
            mo10069a("Failed to populate advertising info", th);
        }
    }

    /* renamed from: h */
    private void m1712h(JSONObject jSONObject) {
        try {
            C1114h L = this.f2745b.mo10186L();
            jSONObject.put("li", String.valueOf(L.mo10039b(C1113g.f2657b)));
            jSONObject.put("si", String.valueOf(L.mo10039b(C1113g.f2659d)));
            jSONObject.put("pf", String.valueOf(L.mo10039b(C1113g.f2663h)));
            jSONObject.put("mpf", String.valueOf(L.mo10039b(C1113g.f2669n)));
            jSONObject.put("gpf", String.valueOf(L.mo10039b(C1113g.f2664i)));
        } catch (Throwable th) {
            mo10069a("Failed to populate ad serving info", th);
        }
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2681C;
    }

    public void run() {
        String str = "aru";
        String str2 = "huc";
        StringBuilder sb = new StringBuilder();
        sb.append("Fetching next ad for ad unit id: ");
        sb.append(this.f1874a);
        sb.append(" and format: ");
        sb.append(this.f1875c);
        mo10068a(sb.toString());
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2529ei)).booleanValue() && C1281o.m3110d()) {
            mo10068a("User is connected to a VPN");
        }
        C1114h L = this.f2745b.mo10186L();
        L.mo10036a(C1113g.f2668m);
        if (L.mo10039b(C1113g.f2658c) == 0) {
            L.mo10041b(C1113g.f2658c, System.currentTimeMillis());
        }
        try {
            JSONObject d = m1707d();
            HashMap hashMap = new HashMap();
            hashMap.put("rid", UUID.randomUUID().toString());
            if (d.has(str2)) {
                hashMap.put(str2, String.valueOf(C1247h.m2963a(d, str2, Boolean.valueOf(false), this.f2745b)));
            }
            if (d.has(str)) {
                hashMap.put(str, String.valueOf(C1247h.m2963a(d, str, Boolean.valueOf(false), this.f2745b)));
            }
            if (!((Boolean) this.f2745b.mo10202a(C1096c.f2507eM)).booleanValue()) {
                hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2745b.mo10246t());
            }
            m1700a(L);
            C09771 r1 = new C1173x<JSONObject>(C1215b.m2733a(this.f2745b).mo10330b("POST").mo10324a(m1703b()).mo10333c(m1705c()).mo10325a((Map<String, String>) hashMap).mo10326a(d).mo10323a(new JSONObject()).mo10329b(((Long) this.f2745b.mo10202a(C1095b.f2255f)).intValue()).mo10322a(((Integer) this.f2745b.mo10202a(C1096c.f2444dB)).intValue()).mo10332c(((Long) this.f2745b.mo10202a(C1095b.f2254e)).intValue()).mo10331b(true).mo10328a(), this.f2745b) {
                /* renamed from: a */
                public void mo9301a(int i) {
                    C0976c.this.m1697a(i);
                }

                /* renamed from: a */
                public void mo9302a(JSONObject jSONObject, int i) {
                    if (i == 200) {
                        C1247h.m2990b(jSONObject, "ad_fetch_latency_millis", this.f2872d.mo10295a(), this.f2745b);
                        C1247h.m2990b(jSONObject, "ad_fetch_response_size", this.f2872d.mo10296b(), this.f2745b);
                        C0976c.this.m1701a(jSONObject);
                        return;
                    }
                    C0976c.this.m1697a(i);
                }
            };
            r1.mo10153a(C1095b.f2252c);
            r1.mo10155b(C1095b.f2253d);
            this.f2745b.mo10185K().mo10130a((C1122a) r1);
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to fetch ad ");
            sb2.append(this.f1874a);
            mo10069a(sb2.toString(), th);
            m1697a(0);
            this.f2745b.mo10187M().mo10047a(mo9338a());
        }
    }
}
