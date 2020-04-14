package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.p018ad.NativeAdImpl;
import com.applovin.impl.sdk.p018ad.NativeAdImpl.C1077a;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.utils.C1243d;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.mediation.AppLovinNativeAdapter;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.google.ads.mediation.inmobi.InMobiNetworkValues;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.v */
class C1171v extends C1122a {

    /* renamed from: a */
    private final AppLovinNativeAdLoadListener f2866a;

    /* renamed from: c */
    private final JSONObject f2867c;

    C1171v(JSONObject jSONObject, C1192i iVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskRenderNativeAd", iVar);
        this.f2866a = appLovinNativeAdLoadListener;
        this.f2867c = jSONObject;
    }

    /* renamed from: a */
    private String m2488a(String str, Map<String, String> map, String str2) {
        String str3 = (String) map.get(str);
        if (str3 != null) {
            return str3.replace("{CLCODE}", str2);
        }
        return null;
    }

    /* renamed from: a */
    private String m2489a(Map<String, String> map, String str, String str2) {
        String str3 = (String) map.get(TapjoyConstants.TJC_CLICK_URL);
        if (str2 == null) {
            str2 = "";
        }
        return str3.replace("{CLCODE}", str).replace("{EVENT_ID}", str2);
    }

    /* renamed from: a */
    private void m2490a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject;
        JSONArray optJSONArray = jSONObject2.optJSONArray("native_ads");
        JSONObject optJSONObject = jSONObject2.optJSONObject("native_settings");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            mo10071c("No ads were returned from the server");
            this.f2866a.onNativeAdsFailedToLoad(204);
            return;
        }
        List b = C1247h.m2986b(optJSONArray);
        ArrayList arrayList = new ArrayList(b.size());
        Map a = optJSONObject != null ? C1247h.m2973a(optJSONObject) : new HashMap(0);
        Iterator it = b.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            String str = (String) map.get("clcode");
            String b2 = C1247h.m2985b(jSONObject2, AdColonyAdapterUtils.KEY_ZONE_ID, (String) null, this.f2745b);
            String str2 = (String) map.get("event_id");
            C1082d b3 = C1082d.m2002b(b2, this.f2745b);
            String a2 = m2488a("simp_url", a, str);
            String a3 = m2489a(a, str, str2);
            List a4 = C1281o.m3078a("simp_urls", optJSONObject, str, a2, this.f2745b);
            Iterator it2 = it;
            String str3 = a3;
            String str4 = C1247h.m2963a(optJSONObject, "should_post_click_url", Boolean.valueOf(true), this.f2745b).booleanValue() ? a3 : null;
            JSONObject jSONObject3 = optJSONObject;
            String str5 = a2;
            List a5 = C1281o.m3079a("click_tracking_urls", optJSONObject, str, str2, str4, this.f2745b);
            if (a4.size() == 0) {
                throw new IllegalArgumentException("No impression URL available");
            } else if (a5.size() != 0) {
                String str6 = (String) map.get("resource_cache_prefix");
                List a6 = str6 != null ? C1243d.m2924a(str6) : this.f2745b.mo10224b((C1096c) C1096c.f2350bL);
                String str7 = "icon_url";
                C1077a a7 = new C1077a().mo9807a(b3).mo9817e(b2).mo9818f((String) map.get("title")).mo9819g((String) map.get("description")).mo9820h((String) map.get(ShareConstants.FEED_CAPTION_PARAM)).mo9829q((String) map.get(InMobiNetworkValues.CTA)).mo9809a((String) map.get(str7));
                String str8 = MessengerShareContentUtility.IMAGE_URL;
                C1077a b4 = a7.mo9812b((String) map.get(str8));
                String str9 = TapjoyConstants.TJC_VIDEO_URL;
                NativeAdImpl a8 = b4.mo9816d((String) map.get(str9)).mo9814c((String) map.get("star_rating_url")).mo9821i((String) map.get(str7)).mo9822j((String) map.get(str8)).mo9823k((String) map.get(str9)).mo9805a(Float.parseFloat((String) map.get("star_rating"))).mo9828p(str).mo9824l(str3).mo9825m(str5).mo9826n(m2488a("video_start_url", a, str)).mo9827o(m2488a("video_end_url", a, str)).mo9810a(a4).mo9813b(a5).mo9806a(Long.parseLong((String) map.get(AppLovinNativeAdapter.KEY_EXTRA_AD_ID))).mo9815c(a6).mo9808a(this.f2745b).mo9811a();
                arrayList.add(a8);
                StringBuilder sb = new StringBuilder();
                sb.append("Prepared native ad: ");
                sb.append(a8.getAdId());
                mo10068a(sb.toString());
                jSONObject2 = jSONObject;
                optJSONObject = jSONObject3;
                it = it2;
            } else {
                throw new IllegalArgumentException("No click tracking URL available");
            }
        }
        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = this.f2866a;
        if (appLovinNativeAdLoadListener != null) {
            appLovinNativeAdLoadListener.onNativeAdsLoaded(arrayList);
        }
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2713v;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo10150a(int i) {
        try {
            if (this.f2866a != null) {
                this.f2866a.onNativeAdsFailedToLoad(i);
            }
        } catch (Exception e) {
            mo10069a("Unable to notify listener about failure.", e);
        }
    }

    public void run() {
        try {
            if (this.f2867c != null) {
                if (this.f2867c.length() != 0) {
                    m2490a(this.f2867c);
                    return;
                }
            }
            mo10150a((int) AppLovinErrorCodes.UNABLE_TO_PREPARE_NATIVE_AD);
        } catch (Exception e) {
            mo10069a("Unable to render native ad.", e);
            mo10150a((int) AppLovinErrorCodes.UNABLE_TO_PREPARE_NATIVE_AD);
            this.f2745b.mo10187M().mo10047a(mo9338a());
        }
    }
}
