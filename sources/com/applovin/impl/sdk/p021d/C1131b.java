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
import com.applovin.impl.sdk.network.C1219d;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.NativeProtocol;
import com.google.ads.mediation.inmobi.InMobiNetworkValues;
import com.tapjoy.TapjoyConstants;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.b */
class C1131b extends C1122a {
    C1131b(C1192i iVar) {
        super("TaskApiSubmitData", iVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2330a(JSONObject jSONObject) {
        String str = "sdk_update_message";
        try {
            this.f2745b.mo10190P().mo10033c();
            JSONObject a = C1246g.m2942a(jSONObject);
            this.f2745b.mo10178C().mo9953a(C1096c.f2277S, (Object) a.getString("device_id"));
            this.f2745b.mo10178C().mo9953a(C1096c.f2278T, (Object) a.getString("device_token"));
            this.f2745b.mo10178C().mo9952a();
            C1246g.m2952d(a, this.f2745b);
            C1246g.m2954e(a, this.f2745b);
            String b = C1247h.m2985b(a, "latest_version", "", this.f2745b);
            if (m2335e(b)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Current SDK version (");
                sb.append(AppLovinSdk.VERSION);
                sb.append(") is outdated. Please integrate the latest version of the AppLovin SDK (");
                sb.append(b);
                sb.append("). Doing so will improve your CPMs and ensure you have access to the latest revenue earning features.");
                String sb2 = sb.toString();
                if (C1247h.m2983a(a, str)) {
                    sb2 = C1247h.m2985b(a, str, sb2, this.f2745b);
                }
                C1227o.m2840h("AppLovinSdk", sb2);
            }
            this.f2745b.mo10186L().mo10040b();
            this.f2745b.mo10187M().mo10050b();
        } catch (Throwable th) {
            mo10069a("Unable to parse API response", th);
        }
    }

    /* renamed from: b */
    private void m2331b(JSONObject jSONObject) throws JSONException {
        C1196j O = this.f2745b.mo10189O();
        C1200b c = O.mo10261c();
        C1202d b = O.mo10260b();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("model", b.f2996a);
        jSONObject2.put("os", b.f2997b);
        jSONObject2.put("brand", b.f2999d);
        jSONObject2.put("brand_name", b.f3000e);
        jSONObject2.put("hardware", b.f3001f);
        jSONObject2.put("sdk_version", b.f3003h);
        jSONObject2.put("revision", b.f3002g);
        jSONObject2.put("adns", (double) b.f3008m);
        jSONObject2.put("adnsd", b.f3009n);
        jSONObject2.put("xdpi", String.valueOf(b.f3010o));
        jSONObject2.put("ydpi", String.valueOf(b.f3011p));
        jSONObject2.put("screen_size_in", String.valueOf(b.f3012q));
        jSONObject2.put("gy", C1277l.m3038a(b.f3020y));
        jSONObject2.put(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, b.f3004i);
        jSONObject2.put("carrier", b.f3005j);
        jSONObject2.put("orientation_lock", b.f3007l);
        jSONObject2.put("tz_offset", b.f3013r);
        jSONObject2.put("aida", String.valueOf(b.f2995I));
        jSONObject2.put("adr", C1277l.m3038a(b.f3015t));
        jSONObject2.put("wvvc", b.f3014s);
        jSONObject2.put("volume", b.f3017v);
        jSONObject2.put("type", "android");
        jSONObject2.put("sim", C1277l.m3038a(b.f3019x));
        jSONObject2.put("is_tablet", C1277l.m3038a(b.f3021z));
        jSONObject2.put("lpm", b.f2989C);
        jSONObject2.put("tv", C1277l.m3038a(b.f2987A));
        jSONObject2.put("vs", C1277l.m3038a(b.f2988B));
        jSONObject2.put("fs", b.f2991E);
        jSONObject2.put("fm", String.valueOf(b.f2992F.f3023b));
        jSONObject2.put("tm", String.valueOf(b.f2992F.f3022a));
        jSONObject2.put("lmt", String.valueOf(b.f2992F.f3024c));
        jSONObject2.put("lm", String.valueOf(b.f2992F.f3025d));
        m2337g(jSONObject2);
        Boolean bool = b.f2993G;
        if (bool != null) {
            jSONObject2.put("huc", bool.toString());
        }
        Boolean bool2 = b.f2994H;
        if (bool2 != null) {
            jSONObject2.put("aru", bool2.toString());
        }
        C1201c cVar = b.f3016u;
        if (cVar != null) {
            jSONObject2.put("act", cVar.f2985a);
            jSONObject2.put("acm", cVar.f2986b);
        }
        String str = b.f3018w;
        if (C1277l.m3042b(str)) {
            jSONObject2.put("ua", C1277l.m3044d(str));
        }
        String str2 = b.f2990D;
        if (!TextUtils.isEmpty(str2)) {
            jSONObject2.put("so", C1277l.m3044d(str2));
        }
        Locale locale = b.f3006k;
        if (locale != null) {
            jSONObject2.put("locale", C1277l.m3044d(locale.toString()));
        }
        jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(InMobiNetworkValues.PACKAGE_NAME, c.f2980c);
        jSONObject3.put("installer_name", c.f2981d);
        jSONObject3.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, c.f2978a);
        jSONObject3.put(TapjoyConstants.TJC_APP_VERSION_NAME, c.f2979b);
        jSONObject3.put("installed_at", c.f2984g);
        jSONObject3.put("tg", c.f2982e);
        jSONObject3.put("applovin_sdk_version", AppLovinSdk.VERSION);
        jSONObject3.put("first_install", String.valueOf(this.f2745b.mo10182H()));
        jSONObject3.put("first_install_v2", String.valueOf(!this.f2745b.mo10183I()));
        jSONObject3.put("debug", Boolean.toString(C1281o.m3107c(this.f2745b)));
        String str3 = (String) this.f2745b.mo10202a(C1096c.f2522eb);
        if (C1277l.m3042b(str3)) {
            jSONObject3.put("plugin_version", str3);
        }
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2462dT)).booleanValue() && C1277l.m3042b(this.f2745b.mo10235i())) {
            jSONObject3.put("cuid", this.f2745b.mo10235i());
        }
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2465dW)).booleanValue()) {
            jSONObject3.put("compass_random_token", this.f2745b.mo10236j());
        }
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2467dY)).booleanValue()) {
            jSONObject3.put("applovin_random_token", this.f2745b.mo10237k());
        }
        jSONObject.put("app_info", jSONObject3);
    }

    /* renamed from: c */
    private void m2332c(JSONObject jSONObject) throws JSONException {
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2539es)).booleanValue()) {
            jSONObject.put("stats", this.f2745b.mo10186L().mo10042c());
        }
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2315ad)).booleanValue()) {
            JSONObject b = C1219d.m2772b(mo10075g());
            if (b.length() > 0) {
                jSONObject.put("network_response_codes", b);
            }
            if (((Boolean) this.f2745b.mo10202a(C1096c.f2316ae)).booleanValue()) {
                C1219d.m2770a(mo10075g());
            }
        }
    }

    /* renamed from: d */
    private void m2333d(JSONObject jSONObject) throws JSONException {
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2546ez)).booleanValue()) {
            JSONArray a = this.f2745b.mo10190P().mo10030a();
            if (a != null && a.length() > 0) {
                jSONObject.put("errors", a);
            }
        }
    }

    /* renamed from: e */
    private void m2334e(JSONObject jSONObject) throws JSONException {
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2545ey)).booleanValue()) {
            JSONArray a = this.f2745b.mo10187M().mo10046a();
            if (a != null && a.length() > 0) {
                jSONObject.put("tasks", a);
            }
        }
    }

    /* renamed from: e */
    private boolean m2335e(String str) {
        return C1277l.m3042b(str) && !AppLovinSdk.VERSION.equals(str) && C1281o.m3116g(str) > AppLovinSdk.VERSION_CODE;
    }

    /* renamed from: f */
    private void m2336f(JSONObject jSONObject) {
        String str = "2.0/device";
        C11321 r0 = new C1173x<JSONObject>(C1215b.m2733a(this.f2745b).mo10324a(C1246g.m2940a(str, this.f2745b)).mo10333c(C1246g.m2950b(str, this.f2745b)).mo10325a(C1246g.m2953e(this.f2745b)).mo10330b("POST").mo10326a(jSONObject).mo10323a(new JSONObject()).mo10322a(((Integer) this.f2745b.mo10202a(C1096c.f2445dC)).intValue()).mo10328a(), this.f2745b) {
            /* renamed from: a */
            public void mo9301a(int i) {
                C1246g.m2943a(i, this.f2745b);
            }

            /* renamed from: a */
            public void mo9302a(JSONObject jSONObject, int i) {
                C1131b.this.m2330a(jSONObject);
            }
        };
        r0.mo10153a(C1096c.f2296aK);
        r0.mo10155b(C1096c.f2297aL);
        this.f2745b.mo10185K().mo10130a((C1122a) r0);
    }

    /* renamed from: g */
    private void m2337g(JSONObject jSONObject) {
        try {
            C1199a d = this.f2745b.mo10189O().mo10262d();
            String str = d.f2977b;
            if (C1277l.m3042b(str)) {
                jSONObject.put("idfa", str);
            }
            jSONObject.put("dnt", Boolean.toString(d.f2976a));
        } catch (Throwable th) {
            mo10069a("Failed to populate advertising info", th);
        }
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2699h;
    }

    public void run() {
        try {
            mo10070b("Submitting user data...");
            JSONObject jSONObject = new JSONObject();
            m2331b(jSONObject);
            m2332c(jSONObject);
            m2333d(jSONObject);
            m2334e(jSONObject);
            m2336f(jSONObject);
        } catch (JSONException e) {
            mo10069a("Unable to build JSON message with collected data", e);
            this.f2745b.mo10187M().mo10047a(mo9338a());
        }
    }
}
