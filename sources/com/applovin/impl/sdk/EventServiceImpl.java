package com.applovin.impl.sdk;

import android.content.Intent;
import android.text.TextUtils;
import com.applovin.impl.sdk.C1196j.C1199a;
import com.applovin.impl.sdk.C1196j.C1200b;
import com.applovin.impl.sdk.C1196j.C1201c;
import com.applovin.impl.sdk.C1196j.C1202d;
import com.applovin.impl.sdk.network.C1222f;
import com.applovin.impl.sdk.network.C1225g;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1142i;
import com.applovin.impl.sdk.p021d.C1142i.C1143a;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.appevents.AppEventsConstants;
import com.google.ads.mediation.inmobi.InMobiNetworkValues;
import com.tapjoy.TapjoyConstants;
import com.unity.purchasing.googleplay.IabHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class EventServiceImpl implements AppLovinEventService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1192i f2063a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<String, Object> f2064b;

    /* renamed from: c */
    private final AtomicBoolean f2065c = new AtomicBoolean();

    public EventServiceImpl(C1192i iVar) {
        this.f2063a = iVar;
        String str = "{}";
        if (((Boolean) iVar.mo10202a(C1096c.f2308aW)).booleanValue()) {
            this.f2064b = C1247h.m2972a((String) this.f2063a.mo10222b(C1098e.f2570p, str), (Map<String, Object>) new HashMap<String,Object>(), this.f2063a);
            return;
        }
        this.f2064b = new HashMap();
        iVar.mo10209a(C1098e.f2570p, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m1880a() {
        StringBuilder sb = new StringBuilder();
        sb.append((String) this.f2063a.mo10202a(C1096c.f2298aM));
        sb.append("4.0/pix");
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public HashMap<String, String> m1882a(C1204k kVar, C1199a aVar) {
        C1196j O = this.f2063a.mo10189O();
        C1202d b = O.mo10260b();
        C1200b c = O.mo10261c();
        boolean contains = this.f2063a.mo10224b((C1096c) C1096c.f2305aT).contains(kVar.mo10265a());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("event", contains ? C1277l.m3044d(kVar.mo10265a()) : "postinstall");
        hashMap.put("ts", Long.toString(kVar.mo10267c()));
        hashMap.put(TapjoyConstants.TJC_PLATFORM, C1277l.m3044d(b.f2998c));
        hashMap.put("model", C1277l.m3044d(b.f2996a));
        hashMap.put(InMobiNetworkValues.PACKAGE_NAME, C1277l.m3044d(c.f2980c));
        hashMap.put("installer_name", C1277l.m3044d(c.f2981d));
        hashMap.put("ia", Long.toString(c.f2984g));
        hashMap.put("api_did", this.f2063a.mo10202a(C1096c.f2277S));
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
        hashMap.put("debug", Boolean.toString(C1281o.m3107c(this.f2063a)));
        if (!((Boolean) this.f2063a.mo10202a(C1096c.f2507eM)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2063a.mo10246t());
        }
        m1885a(aVar, (Map<String, String>) hashMap);
        if (((Boolean) this.f2063a.mo10202a(C1096c.f2462dT)).booleanValue()) {
            C1281o.m3085a("cuid", this.f2063a.mo10235i(), (Map<String, String>) hashMap);
        }
        if (((Boolean) this.f2063a.mo10202a(C1096c.f2465dW)).booleanValue()) {
            hashMap.put("compass_random_token", this.f2063a.mo10236j());
        }
        if (((Boolean) this.f2063a.mo10202a(C1096c.f2467dY)).booleanValue()) {
            hashMap.put("applovin_random_token", this.f2063a.mo10237k());
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
        if (!contains) {
            hashMap.put("sub_event", C1277l.m3044d(kVar.mo10265a()));
        }
        hashMap.put("sc", C1277l.m3044d((String) this.f2063a.mo10202a(C1096c.f2280V)));
        hashMap.put("sc2", C1277l.m3044d((String) this.f2063a.mo10202a(C1096c.f2281W)));
        hashMap.put("server_installed_at", C1277l.m3044d((String) this.f2063a.mo10202a(C1096c.f2282X)));
        C1281o.m3085a("persisted_data", C1277l.m3044d((String) this.f2063a.mo10203a(C1098e.f2578x)), (Map<String, String>) hashMap);
        C1281o.m3085a("plugin_version", C1277l.m3044d((String) this.f2063a.mo10202a(C1096c.f2522eb)), (Map<String, String>) hashMap);
        C1281o.m3085a("mediation_provider", C1277l.m3044d(this.f2063a.mo10240n()), (Map<String, String>) hashMap);
        return hashMap;
    }

    /* renamed from: a */
    private void m1884a(C1143a aVar) {
        this.f2063a.mo10185K().mo10131a((C1122a) new C1142i(this.f2063a, aVar), C1281o.m3096b(this.f2063a));
    }

    /* renamed from: a */
    private void m1885a(C1199a aVar, Map<String, String> map) {
        String str = aVar.f2977b;
        if (C1277l.m3042b(str)) {
            map.put("idfa", str);
        }
        map.put("dnt", Boolean.toString(aVar.f2976a));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m1887b() {
        StringBuilder sb = new StringBuilder();
        sb.append((String) this.f2063a.mo10202a(C1096c.f2299aN));
        sb.append("4.0/pix");
        return sb.toString();
    }

    /* renamed from: c */
    private void m1889c() {
        if (((Boolean) this.f2063a.mo10202a(C1096c.f2308aW)).booleanValue()) {
            this.f2063a.mo10209a(C1098e.f2570p, C1247h.m2967a(this.f2064b, "{}", this.f2063a));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9696a(String str, boolean z) {
        trackEvent(str, new HashMap(), null, z);
    }

    public Map<String, Object> getSuperProperties() {
        return new HashMap(this.f2064b);
    }

    public void maybeTrackAppOpenEvent() {
        if (this.f2065c.compareAndSet(false, true)) {
            this.f2063a.mo10243q().trackEvent("landing");
        }
    }

    public void setSuperProperty(Object obj, String str) {
        String str2 = "AppLovinEventService";
        if (TextUtils.isEmpty(str)) {
            C1227o.m2841i(str2, "Super property key cannot be null or empty");
        } else if (obj == null) {
            this.f2064b.remove(str);
            m1889c();
        } else {
            List b = this.f2063a.mo10224b((C1096c) C1096c.f2307aV);
            if (!C1281o.m3093a(obj, b, this.f2063a)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to set super property '");
                sb.append(obj);
                sb.append("' for key '");
                sb.append(str);
                sb.append("' - valid super property types include: ");
                sb.append(b);
                C1227o.m2841i(str2, sb.toString());
                return;
            }
            this.f2064b.put(str, C1281o.m3073a(obj, this.f2063a));
            m1889c();
        }
    }

    public String toString() {
        return "EventService{}";
    }

    public void trackCheckout(String str, Map<String, String> map) {
        HashMap hashMap = map != null ? new HashMap(map) : new HashMap(1);
        hashMap.put("transaction_id", str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, hashMap);
    }

    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    public void trackEvent(String str, Map<String, String> map) {
        trackEvent(str, map, null, true);
    }

    public void trackEvent(String str, Map<String, String> map, Map<String, String> map2, boolean z) {
        if (((Boolean) this.f2063a.mo10202a(C1096c.f2306aU)).booleanValue()) {
            C1227o v = this.f2063a.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Tracking event: \"");
            sb.append(str);
            sb.append("\" with parameters: ");
            sb.append(map);
            v.mo10378b("AppLovinEventService", sb.toString());
            final String str2 = str;
            final Map<String, String> map3 = map;
            final boolean z2 = z;
            final Map<String, String> map4 = map2;
            C10511 r3 = new C1143a() {
                /* renamed from: a */
                public void mo9706a(C1199a aVar) {
                    C1204k kVar = new C1204k(str2, map3, EventServiceImpl.this.f2064b);
                    try {
                        if (z2) {
                            EventServiceImpl.this.f2063a.mo10188N().mo10338a(C1222f.m2788k().mo10355a(EventServiceImpl.this.m1880a()).mo10359b(EventServiceImpl.this.m1887b()).mo10356a((Map<String, String>) EventServiceImpl.this.m1882a(kVar, aVar)).mo10360b(map4).mo10361c(kVar.mo10266b()).mo10357a(((Boolean) EventServiceImpl.this.f2063a.mo10202a(C1096c.f2507eM)).booleanValue()).mo10358a());
                            return;
                        }
                        EventServiceImpl.this.f2063a.mo10192R().dispatchPostbackRequest(C1225g.m2812b(EventServiceImpl.this.f2063a).mo10324a(EventServiceImpl.this.m1880a()).mo10333c(EventServiceImpl.this.m1887b()).mo10325a((Map<String, String>) EventServiceImpl.this.m1882a(kVar, aVar)).mo10366c(map4).mo10326a(C1247h.m2976a(kVar.mo10266b())).mo10327a(((Boolean) EventServiceImpl.this.f2063a.mo10202a(C1096c.f2507eM)).booleanValue()).mo10328a(), null);
                    } catch (Throwable th) {
                        C1227o v = EventServiceImpl.this.f2063a.mo10249v();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unable to track event: ");
                        sb.append(kVar);
                        v.mo10379b("AppLovinEventService", sb.toString(), th);
                    }
                }
            };
            m1884a((C1143a) r3);
        }
    }

    public void trackInAppPurchase(Intent intent, Map<String, String> map) {
        HashMap hashMap = map != null ? new HashMap(map) : new HashMap();
        try {
            hashMap.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra(IabHelper.RESPONSE_INAPP_PURCHASE_DATA));
            hashMap.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra(IabHelper.RESPONSE_INAPP_SIGNATURE));
        } catch (Throwable th) {
            C1227o.m2837c("AppLovinEventService", "Unable to track in app purchase - invalid purchase intent", th);
        }
        trackEvent("iap", hashMap);
    }
}
