package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1205l;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.network.C1215b;
import com.applovin.impl.sdk.p018ad.C1079b;
import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1113g;
import com.applovin.impl.sdk.p020c.C1114h;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.m */
public class C1150m extends C1122a {

    /* renamed from: a */
    private final C1082d f2789a;

    /* renamed from: c */
    private final AppLovinAdLoadListener f2790c;

    /* renamed from: d */
    private boolean f2791d;

    public C1150m(C1082d dVar, AppLovinAdLoadListener appLovinAdLoadListener, C1192i iVar) {
        this(dVar, appLovinAdLoadListener, "TaskFetchNextAd", iVar);
    }

    C1150m(C1082d dVar, AppLovinAdLoadListener appLovinAdLoadListener, String str, C1192i iVar) {
        super(str, iVar);
        this.f2791d = false;
        this.f2789a = dVar;
        this.f2790c = appLovinAdLoadListener;
    }

    /* renamed from: a */
    private void m2414a(C1114h hVar) {
        long b = hVar.mo10039b(C1113g.f2658c);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b > TimeUnit.MINUTES.toMillis((long) ((Integer) this.f2745b.mo10202a(C1096c.f2455dM)).intValue())) {
            hVar.mo10041b(C1113g.f2658c, currentTimeMillis);
            hVar.mo10043c(C1113g.f2659d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2417b(int i) {
        boolean z = i != 204;
        C1227o v = mo10073e().mo10249v();
        String f = mo10074f();
        Boolean valueOf = Boolean.valueOf(z);
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to fetch ");
        sb.append(this.f2789a);
        sb.append(" ad: server returned ");
        sb.append(i);
        v.mo10374a(f, valueOf, sb.toString());
        if (i == -800) {
            this.f2745b.mo10186L().mo10036a(C1113g.f2663h);
        }
        try {
            mo10119a(i);
        } catch (Throwable th) {
            C1227o.m2837c(mo10074f(), "Unable process a failure to recieve an ad", th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2418b(JSONObject jSONObject) {
        C1246g.m2952d(jSONObject, this.f2745b);
        C1246g.m2951c(jSONObject, this.f2745b);
        C1246g.m2954e(jSONObject, this.f2745b);
        C1122a a = mo10118a(jSONObject);
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2511eQ)).booleanValue()) {
            this.f2745b.mo10185K().mo10130a(a);
        } else {
            this.f2745b.mo10185K().mo10131a(a, C1161a.MAIN);
        }
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2705n;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1122a mo10118a(JSONObject jSONObject) {
        C1165s sVar = new C1165s(jSONObject, this.f2789a, mo10117c(), this.f2790c, this.f2745b);
        return sVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10119a(int i) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f2790c;
        if (appLovinAdLoadListener == null) {
            return;
        }
        if (appLovinAdLoadListener instanceof C1205l) {
            ((C1205l) appLovinAdLoadListener).mo9974a(this.f2789a, i);
        } else {
            appLovinAdLoadListener.failedToReceiveAd(i);
        }
    }

    /* renamed from: a */
    public void mo10120a(boolean z) {
        this.f2791d = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Map<String, String> mo10116b() {
        HashMap hashMap = new HashMap(4);
        hashMap.put(AdColonyAdapterUtils.KEY_ZONE_ID, C1277l.m3044d(this.f2789a.mo9846a()));
        if (this.f2789a.mo9848b() != null) {
            hashMap.put("size", this.f2789a.mo9848b().getLabel());
        }
        if (this.f2789a.mo9849c() != null) {
            hashMap.put("require", this.f2789a.mo9849c().getLabel());
        }
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2312aa)).booleanValue()) {
            hashMap.put("n", String.valueOf(this.f2745b.mo10218ab().mo10395a(this.f2789a.mo9846a())));
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C1079b mo10117c() {
        return this.f2789a.mo9858j() ? C1079b.APPLOVIN_PRIMARY_ZONE : C1079b.APPLOVIN_CUSTOM_ZONE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo10121d() {
        return C1246g.m2957g(this.f2745b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public String mo10122i() {
        return C1246g.m2958h(this.f2745b);
    }

    public void run() {
        String str;
        StringBuilder sb;
        if (this.f2791d) {
            sb = new StringBuilder();
            str = "Preloading next ad of zone: ";
        } else {
            sb = new StringBuilder();
            str = "Fetching next ad of zone: ";
        }
        sb.append(str);
        sb.append(this.f2789a);
        mo10068a(sb.toString());
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2529ei)).booleanValue() && C1281o.m3110d()) {
            mo10068a("User is connected to a VPN");
        }
        C1114h L = this.f2745b.mo10186L();
        L.mo10036a(C1113g.f2656a);
        if (L.mo10039b(C1113g.f2658c) == 0) {
            L.mo10041b(C1113g.f2658c, System.currentTimeMillis());
        }
        try {
            Map a = this.f2745b.mo10189O().mo10259a(mo10116b(), this.f2791d, false);
            m2414a(L);
            C11511 r2 = new C1173x<JSONObject>(C1215b.m2733a(this.f2745b).mo10324a(mo10121d()).mo10325a(a).mo10333c(mo10122i()).mo10330b("GET").mo10323a(new JSONObject()).mo10322a(((Integer) this.f2745b.mo10202a(C1096c.f2444dB)).intValue()).mo10329b(((Integer) this.f2745b.mo10202a(C1096c.f2443dA)).intValue()).mo10331b(true).mo10328a(), this.f2745b) {
                /* renamed from: a */
                public void mo9301a(int i) {
                    C1150m.this.m2417b(i);
                }

                /* renamed from: a */
                public void mo9302a(JSONObject jSONObject, int i) {
                    if (i == 200) {
                        C1247h.m2990b(jSONObject, "ad_fetch_latency_millis", this.f2872d.mo10295a(), this.f2745b);
                        C1247h.m2990b(jSONObject, "ad_fetch_response_size", this.f2872d.mo10296b(), this.f2745b);
                        C1150m.this.m2418b(jSONObject);
                        return;
                    }
                    C1150m.this.m2417b(i);
                }
            };
            r2.mo10153a(C1096c.f2294aI);
            r2.mo10155b(C1096c.f2295aJ);
            this.f2745b.mo10185K().mo10130a((C1122a) r2);
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to fetch ad ");
            sb2.append(this.f2789a);
            mo10069a(sb2.toString(), th);
            m2417b(0);
            this.f2745b.mo10187M().mo10047a(mo9338a());
        }
    }
}
