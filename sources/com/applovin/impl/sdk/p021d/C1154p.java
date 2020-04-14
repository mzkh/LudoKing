package com.applovin.impl.sdk.p021d;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1196j;
import com.applovin.impl.sdk.C1196j.C1199a;
import com.applovin.impl.sdk.C1196j.C1200b;
import com.applovin.impl.sdk.C1196j.C1201c;
import com.applovin.impl.sdk.C1196j.C1202d;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.network.C1215b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.appevents.AppEventsConstants;
import com.google.ads.mediation.inmobi.InMobiNetworkValues;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.p */
public class C1154p extends C1122a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1156a f2796a;

    /* renamed from: com.applovin.impl.sdk.d.p$a */
    public interface C1156a {
        /* renamed from: a */
        void mo9733a();
    }

    public C1154p(C1192i iVar, C1156a aVar) {
        super("TaskFetchVariables", iVar);
        this.f2796a = aVar;
    }

    /* renamed from: a */
    private void m2440a(Map<String, String> map) {
        try {
            C1199a d = this.f2745b.mo10189O().mo10262d();
            String str = d.f2977b;
            if (C1277l.m3042b(str)) {
                map.put("idfa", str);
            }
            map.put("dnt", Boolean.toString(d.f2976a));
        } catch (Throwable th) {
            mo10069a("Failed to populate advertising info", th);
        }
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2708q;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Map<String, String> mo10125b() {
        C1196j O = this.f2745b.mo10189O();
        C1202d b = O.mo10260b();
        C1200b c = O.mo10261c();
        HashMap hashMap = new HashMap();
        hashMap.put(TapjoyConstants.TJC_PLATFORM, C1277l.m3044d(b.f2998c));
        hashMap.put("model", C1277l.m3044d(b.f2996a));
        hashMap.put(InMobiNetworkValues.PACKAGE_NAME, C1277l.m3044d(c.f2980c));
        hashMap.put("installer_name", C1277l.m3044d(c.f2981d));
        hashMap.put("ia", Long.toString(c.f2984g));
        hashMap.put("api_did", this.f2745b.mo10202a(C1096c.f2277S));
        hashMap.put("brand", C1277l.m3044d(b.f2999d));
        hashMap.put("brand_name", C1277l.m3044d(b.f3000e));
        hashMap.put("hardware", C1277l.m3044d(b.f3001f));
        hashMap.put("revision", C1277l.m3044d(b.f3002g));
        hashMap.put("sdk_version", AppLovinSdk.VERSION);
        hashMap.put("os", C1277l.m3044d(b.f2997b));
        hashMap.put("orientation_lock", b.f3007l);
        hashMap.put(TapjoyConstants.TJC_APP_VERSION_NAME, C1277l.m3044d(c.f2979b));
        hashMap.put(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, C1277l.m3044d(b.f3004i));
        hashMap.put("carrier", C1277l.m3044d(b.f3005j));
        hashMap.put("tz_offset", String.valueOf(b.f3013r));
        hashMap.put("aida", String.valueOf(b.f2995I));
        boolean z = b.f3015t;
        String str = "1";
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        hashMap.put("adr", z ? str : str2);
        hashMap.put("volume", String.valueOf(b.f3017v));
        if (!b.f3019x) {
            str = str2;
        }
        hashMap.put("sim", str);
        hashMap.put("gy", String.valueOf(b.f3020y));
        hashMap.put("is_tablet", String.valueOf(b.f3021z));
        hashMap.put("tv", String.valueOf(b.f2987A));
        hashMap.put("vs", String.valueOf(b.f2988B));
        hashMap.put("lpm", String.valueOf(b.f2989C));
        hashMap.put("tg", c.f2982e);
        hashMap.put("fs", String.valueOf(b.f2991E));
        hashMap.put("fm", String.valueOf(b.f2992F.f3023b));
        hashMap.put("tm", String.valueOf(b.f2992F.f3022a));
        hashMap.put("lmt", String.valueOf(b.f2992F.f3024c));
        hashMap.put("lm", String.valueOf(b.f2992F.f3025d));
        hashMap.put("adns", String.valueOf(b.f3008m));
        hashMap.put("adnsd", String.valueOf(b.f3009n));
        hashMap.put("xdpi", String.valueOf(b.f3010o));
        hashMap.put("ydpi", String.valueOf(b.f3011p));
        hashMap.put("screen_size_in", String.valueOf(b.f3012q));
        hashMap.put("debug", Boolean.toString(C1281o.m3107c(this.f2745b)));
        if (!((Boolean) this.f2745b.mo10202a(C1096c.f2507eM)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2745b.mo10246t());
        }
        m2440a((Map<String, String>) hashMap);
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2462dT)).booleanValue()) {
            C1281o.m3085a("cuid", this.f2745b.mo10235i(), (Map<String, String>) hashMap);
        }
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2465dW)).booleanValue()) {
            hashMap.put("compass_random_token", this.f2745b.mo10236j());
        }
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2467dY)).booleanValue()) {
            hashMap.put("applovin_random_token", this.f2745b.mo10237k());
        }
        Boolean bool = b.f2993G;
        if (bool != null) {
            hashMap.put("huc", bool.toString());
        }
        Boolean bool2 = b.f2994H;
        if (bool2 != null) {
            hashMap.put("aru", bool2.toString());
        }
        C1201c cVar = b.f3016u;
        if (cVar != null) {
            hashMap.put("act", String.valueOf(cVar.f2985a));
            hashMap.put("acm", String.valueOf(cVar.f2986b));
        }
        String str3 = b.f3018w;
        if (C1277l.m3042b(str3)) {
            hashMap.put("ua", C1277l.m3044d(str3));
        }
        String str4 = b.f2990D;
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("so", C1277l.m3044d(str4));
        }
        hashMap.put("sc", C1277l.m3044d((String) this.f2745b.mo10202a(C1096c.f2280V)));
        hashMap.put("sc2", C1277l.m3044d((String) this.f2745b.mo10202a(C1096c.f2281W)));
        hashMap.put("server_installed_at", C1277l.m3044d((String) this.f2745b.mo10202a(C1096c.f2282X)));
        C1281o.m3085a("persisted_data", C1277l.m3044d((String) this.f2745b.mo10203a(C1098e.f2578x)), (Map<String, String>) hashMap);
        return hashMap;
    }

    public void run() {
        C11551 r1 = new C1173x<JSONObject>(C1215b.m2733a(this.f2745b).mo10324a(C1246g.m2959i(this.f2745b)).mo10333c(C1246g.m2960j(this.f2745b)).mo10325a(mo10125b()).mo10330b("GET").mo10323a(new JSONObject()).mo10329b(((Integer) this.f2745b.mo10202a(C1096c.f2452dJ)).intValue()).mo10328a(), this.f2745b) {
            /* renamed from: a */
            public void mo9301a(int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to fetch variables: server returned ");
                sb.append(i);
                mo10072d(sb.toString());
                C1227o.m2841i("AppLovinVariableService", "Failed to load variables.");
                C1154p.this.f2796a.mo9733a();
            }

            /* renamed from: a */
            public void mo9302a(JSONObject jSONObject, int i) {
                C1246g.m2952d(jSONObject, this.f2745b);
                C1246g.m2951c(jSONObject, this.f2745b);
                C1246g.m2956f(jSONObject, this.f2745b);
                C1154p.this.f2796a.mo9733a();
            }
        };
        r1.mo10153a(C1096c.f2300aO);
        r1.mo10155b(C1096c.f2301aP);
        this.f2745b.mo10185K().mo10130a((C1122a) r1);
    }
}
