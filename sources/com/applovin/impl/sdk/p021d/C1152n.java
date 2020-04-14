package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.n */
public class C1152n extends C1150m {

    /* renamed from: a */
    private final int f2793a;

    /* renamed from: c */
    private final AppLovinNativeAdLoadListener f2794c;

    public C1152n(String str, int i, C1192i iVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super(C1082d.m2002b(str, iVar), null, "TaskFetchNextNativeAd", iVar);
        this.f2793a = i;
        this.f2794c = appLovinNativeAdLoadListener;
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2706o;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1122a mo10118a(JSONObject jSONObject) {
        return new C1171v(jSONObject, this.f2745b, this.f2794c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10119a(int i) {
        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = this.f2794c;
        if (appLovinNativeAdLoadListener != null) {
            appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Map<String, String> mo10116b() {
        Map<String, String> b = super.mo10116b();
        b.put("slot_count", Integer.toString(this.f2793a));
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo10121d() {
        StringBuilder sb = new StringBuilder();
        sb.append((String) this.f2745b.mo10202a(C1096c.f2294aI));
        sb.append("4.0/nad");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public String mo10122i() {
        StringBuilder sb = new StringBuilder();
        sb.append((String) this.f2745b.mo10202a(C1096c.f2295aJ));
        sb.append("4.0/nad");
        return sb.toString();
    }
}
