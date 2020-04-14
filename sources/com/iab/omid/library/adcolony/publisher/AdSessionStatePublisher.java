package com.iab.omid.library.adcolony.publisher;

import android.webkit.WebView;
import com.iab.omid.library.adcolony.adsession.AdEvents;
import com.iab.omid.library.adcolony.adsession.AdSessionConfiguration;
import com.iab.omid.library.adcolony.adsession.AdSessionContext;
import com.iab.omid.library.adcolony.adsession.C2029a;
import com.iab.omid.library.adcolony.adsession.ErrorType;
import com.iab.omid.library.adcolony.adsession.VerificationScriptResource;
import com.iab.omid.library.adcolony.adsession.video.VideoEvents;
import com.iab.omid.library.adcolony.p026b.C2035c;
import com.iab.omid.library.adcolony.p026b.C2036d;
import com.iab.omid.library.adcolony.p028d.C2044a;
import com.iab.omid.library.adcolony.p028d.C2045b;
import com.iab.omid.library.adcolony.p028d.C2048d;
import com.iab.omid.library.adcolony.p029e.C2052b;
import com.tapjoy.TapjoyConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher {

    /* renamed from: a */
    private C2052b f4052a = new C2052b(null);

    /* renamed from: b */
    private AdEvents f4053b;

    /* renamed from: c */
    private VideoEvents f4054c;

    /* renamed from: d */
    private C2053a f4055d;

    /* renamed from: e */
    private long f4056e;

    /* renamed from: com.iab.omid.library.adcolony.publisher.AdSessionStatePublisher$a */
    enum C2053a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_HIDDEN
    }

    public AdSessionStatePublisher() {
        mo27450h();
    }

    /* renamed from: a */
    public void mo27430a() {
    }

    /* renamed from: a */
    public void mo27431a(float f) {
        C2036d.m3782a().mo27407a(getWebView(), f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27432a(WebView webView) {
        this.f4052a = new C2052b(webView);
    }

    /* renamed from: a */
    public void mo27433a(AdEvents adEvents) {
        this.f4053b = adEvents;
    }

    /* renamed from: a */
    public void mo27434a(AdSessionConfiguration adSessionConfiguration) {
        C2036d.m3782a().mo27413a(getWebView(), adSessionConfiguration.toJsonObject());
    }

    /* renamed from: a */
    public void mo27435a(ErrorType errorType, String str) {
        C2036d.m3782a().mo27408a(getWebView(), errorType, str);
    }

    /* renamed from: a */
    public void mo27436a(C2029a aVar, AdSessionContext adSessionContext) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject = new JSONObject();
        String str = TapjoyConstants.TJC_APP_PLACEMENT;
        C2045b.m3825a(jSONObject, "environment", str);
        C2045b.m3825a(jSONObject, "adSessionType", adSessionContext.getAdSessionContextType());
        C2045b.m3825a(jSONObject, "deviceInfo", C2044a.m3819d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        C2045b.m3825a(jSONObject, "supports", jSONArray);
        JSONObject jSONObject2 = new JSONObject();
        C2045b.m3825a(jSONObject2, "partnerName", adSessionContext.getPartner().getName());
        C2045b.m3825a(jSONObject2, "partnerVersion", adSessionContext.getPartner().getVersion());
        C2045b.m3825a(jSONObject, "omidNativeInfo", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        C2045b.m3825a(jSONObject3, "libraryVersion", "1.2.17-Adcolony");
        C2045b.m3825a(jSONObject3, "appId", C2035c.m3779a().mo27405b().getApplicationContext().getPackageName());
        C2045b.m3825a(jSONObject, str, jSONObject3);
        if (adSessionContext.getCustomReferenceData() != null) {
            C2045b.m3825a(jSONObject, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        JSONObject jSONObject4 = new JSONObject();
        for (VerificationScriptResource verificationScriptResource : adSessionContext.getVerificationScriptResources()) {
            C2045b.m3825a(jSONObject4, verificationScriptResource.getVendorKey(), verificationScriptResource.getVerificationParameters());
        }
        C2036d.m3782a().mo27410a(getWebView(), adSessionId, jSONObject, jSONObject4);
    }

    /* renamed from: a */
    public void mo27437a(VideoEvents videoEvents) {
        this.f4054c = videoEvents;
    }

    /* renamed from: a */
    public void mo27438a(String str) {
        C2036d.m3782a().mo27409a(getWebView(), str, (JSONObject) null);
    }

    /* renamed from: a */
    public void mo27439a(String str, long j) {
        if (j >= this.f4056e) {
            this.f4055d = C2053a.AD_STATE_VISIBLE;
            C2036d.m3782a().mo27418c(getWebView(), str);
        }
    }

    /* renamed from: a */
    public void mo27440a(String str, JSONObject jSONObject) {
        C2036d.m3782a().mo27409a(getWebView(), str, jSONObject);
    }

    /* renamed from: a */
    public void mo27441a(boolean z) {
        if (mo27446e()) {
            C2036d.m3782a().mo27419d(getWebView(), z ? "foregrounded" : "backgrounded");
        }
    }

    /* renamed from: b */
    public void mo27442b() {
        this.f4052a.clear();
    }

    /* renamed from: b */
    public void mo27443b(String str, long j) {
        if (j >= this.f4056e && this.f4055d != C2053a.AD_STATE_HIDDEN) {
            this.f4055d = C2053a.AD_STATE_HIDDEN;
            C2036d.m3782a().mo27418c(getWebView(), str);
        }
    }

    /* renamed from: c */
    public AdEvents mo27444c() {
        return this.f4053b;
    }

    /* renamed from: d */
    public VideoEvents mo27445d() {
        return this.f4054c;
    }

    /* renamed from: e */
    public boolean mo27446e() {
        return this.f4052a.get() != null;
    }

    /* renamed from: f */
    public void mo27447f() {
        C2036d.m3782a().mo27406a(getWebView());
    }

    /* renamed from: g */
    public void mo27448g() {
        C2036d.m3782a().mo27416b(getWebView());
    }

    public WebView getWebView() {
        return (WebView) this.f4052a.get();
    }

    /* renamed from: h */
    public void mo27450h() {
        this.f4056e = C2048d.m3837a();
        this.f4055d = C2053a.AD_STATE_IDLE;
    }
}
