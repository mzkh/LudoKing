package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p018ad.C1078a;
import com.applovin.impl.sdk.p018ad.C1079b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.u */
class C1170u extends C1122a {

    /* renamed from: a */
    private final JSONObject f2862a;

    /* renamed from: c */
    private final JSONObject f2863c;

    /* renamed from: d */
    private final AppLovinAdLoadListener f2864d;

    /* renamed from: e */
    private final C1079b f2865e;

    C1170u(JSONObject jSONObject, JSONObject jSONObject2, C1079b bVar, AppLovinAdLoadListener appLovinAdLoadListener, C1192i iVar) {
        super("TaskRenderAppLovinAd", iVar);
        this.f2862a = jSONObject;
        this.f2863c = jSONObject2;
        this.f2865e = bVar;
        this.f2864d = appLovinAdLoadListener;
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2712u;
    }

    public void run() {
        mo10068a("Rendering ad...");
        C1078a aVar = new C1078a(this.f2862a, this.f2863c, this.f2865e, this.f2745b);
        boolean booleanValue = C1247h.m2963a(this.f2862a, "gs_load_immediately", Boolean.valueOf(false), this.f2745b).booleanValue();
        boolean booleanValue2 = C1247h.m2963a(this.f2862a, "vs_load_immediately", Boolean.valueOf(true), this.f2745b).booleanValue();
        C1135d dVar = new C1135d(aVar, this.f2745b, this.f2864d);
        dVar.mo10100a(booleanValue2);
        dVar.mo10101b(booleanValue);
        C1161a aVar2 = C1161a.CACHING_OTHER;
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2375bk)).booleanValue()) {
            if (aVar.getSize() == AppLovinAdSize.INTERSTITIAL && aVar.getType() == AppLovinAdType.REGULAR) {
                aVar2 = C1161a.CACHING_INTERSTITIAL;
            } else if (aVar.getSize() == AppLovinAdSize.INTERSTITIAL && aVar.getType() == AppLovinAdType.INCENTIVIZED) {
                aVar2 = C1161a.CACHING_INCENTIVIZED;
            }
        }
        this.f2745b.mo10185K().mo10131a((C1122a) dVar, aVar2);
    }
}
