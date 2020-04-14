package com.applovin.impl.mediation.p006a.p008b;

import android.os.Build.VERSION;
import com.applovin.impl.mediation.p016d.C0989b;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1196j.C1200b;
import com.applovin.impl.sdk.network.C1211a.C1214c;
import com.applovin.impl.sdk.network.C1215b;
import com.applovin.impl.sdk.p019b.C1095b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1173x;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.ads.mediation.inmobi.InMobiNetworkValues;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.b.a */
public class C0918a extends C1122a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1214c<JSONObject> f1726a;

    public C0918a(C1214c<JSONObject> cVar, C1192i iVar) {
        super("TaskFetchMediationDebuggerInfo", iVar, true);
        this.f1726a = cVar;
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2688J;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Map<String, String> mo9339b() {
        HashMap hashMap = new HashMap();
        hashMap.put("sdk_version", AppLovinSdk.VERSION);
        hashMap.put("build", String.valueOf(131));
        if (!((Boolean) this.f2745b.mo10202a(C1096c.f2507eM)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2745b.mo10246t());
        }
        C1200b c = this.f2745b.mo10189O().mo10261c();
        hashMap.put(InMobiNetworkValues.PACKAGE_NAME, C1277l.m3044d(c.f2980c));
        hashMap.put(TapjoyConstants.TJC_APP_VERSION_NAME, C1277l.m3044d(c.f2979b));
        hashMap.put(TapjoyConstants.TJC_PLATFORM, "android");
        hashMap.put("os", C1277l.m3044d(VERSION.RELEASE));
        return hashMap;
    }

    public void run() {
        C09191 r1 = new C1173x<JSONObject>(C1215b.m2733a(this.f2745b).mo10324a(C0989b.m1766c(this.f2745b)).mo10333c(C0989b.m1767d(this.f2745b)).mo10325a(mo9339b()).mo10330b("GET").mo10323a(new JSONObject()).mo10329b(((Long) this.f2745b.mo10202a(C1095b.f2256g)).intValue()).mo10328a(), this.f2745b, mo10076h()) {
            /* renamed from: a */
            public void mo9301a(int i) {
                C0918a.this.f1726a.mo9301a(i);
            }

            /* renamed from: a */
            public void mo9302a(JSONObject jSONObject, int i) {
                C0918a.this.f1726a.mo9302a(jSONObject, i);
            }
        };
        r1.mo10153a(C1095b.f2252c);
        r1.mo10155b(C1095b.f2253d);
        this.f2745b.mo10185K().mo10130a((C1122a) r1);
    }
}
