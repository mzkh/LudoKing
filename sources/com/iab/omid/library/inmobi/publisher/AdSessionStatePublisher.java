package com.iab.omid.library.inmobi.publisher;

import android.webkit.WebView;
import com.iab.omid.library.inmobi.adsession.AdEvents;
import com.iab.omid.library.inmobi.adsession.AdSessionConfiguration;
import com.iab.omid.library.inmobi.adsession.AdSessionContext;
import com.iab.omid.library.inmobi.adsession.C2077a;
import com.iab.omid.library.inmobi.adsession.ErrorType;
import com.iab.omid.library.inmobi.adsession.VerificationScriptResource;
import com.iab.omid.library.inmobi.adsession.video.VideoEvents;
import com.iab.omid.library.inmobi.p032b.C2083c;
import com.iab.omid.library.inmobi.p032b.C2084d;
import com.iab.omid.library.inmobi.p034d.C2092a;
import com.iab.omid.library.inmobi.p034d.C2093b;
import com.iab.omid.library.inmobi.p034d.C2096d;
import com.iab.omid.library.inmobi.p035e.C2100b;
import com.tapjoy.TapjoyConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher {

    /* renamed from: a */
    private C2100b f4152a = new C2100b(null);

    /* renamed from: b */
    private AdEvents f4153b;

    /* renamed from: c */
    private VideoEvents f4154c;

    /* renamed from: d */
    private C2101a f4155d;

    /* renamed from: e */
    private long f4156e;

    /* renamed from: com.iab.omid.library.inmobi.publisher.AdSessionStatePublisher$a */
    enum C2101a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        mo27614h();
    }

    /* renamed from: a */
    public void mo27594a() {
    }

    /* renamed from: a */
    public void mo27595a(float f) {
        C2084d.m3986a().mo27570a(getWebView(), f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27596a(WebView webView) {
        this.f4152a = new C2100b(webView);
    }

    /* renamed from: a */
    public void mo27597a(AdEvents adEvents) {
        this.f4153b = adEvents;
    }

    /* renamed from: a */
    public void mo27598a(AdSessionConfiguration adSessionConfiguration) {
        C2084d.m3986a().mo27576a(getWebView(), adSessionConfiguration.toJsonObject());
    }

    /* renamed from: a */
    public void mo27599a(ErrorType errorType, String str) {
        C2084d.m3986a().mo27571a(getWebView(), errorType, str);
    }

    /* renamed from: a */
    public void mo27600a(C2077a aVar, AdSessionContext adSessionContext) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject = new JSONObject();
        String str = TapjoyConstants.TJC_APP_PLACEMENT;
        C2093b.m4030a(jSONObject, "environment", str);
        C2093b.m4030a(jSONObject, "adSessionType", adSessionContext.getAdSessionContextType());
        C2093b.m4030a(jSONObject, "deviceInfo", C2092a.m4024d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        C2093b.m4030a(jSONObject, "supports", jSONArray);
        JSONObject jSONObject2 = new JSONObject();
        C2093b.m4030a(jSONObject2, "partnerName", adSessionContext.getPartner().getName());
        C2093b.m4030a(jSONObject2, "partnerVersion", adSessionContext.getPartner().getVersion());
        C2093b.m4030a(jSONObject, "omidNativeInfo", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        C2093b.m4030a(jSONObject3, "libraryVersion", "1.2.19-Inmobi");
        C2093b.m4030a(jSONObject3, "appId", C2083c.m3983a().mo27568b().getApplicationContext().getPackageName());
        C2093b.m4030a(jSONObject, str, jSONObject3);
        if (adSessionContext.getCustomReferenceData() != null) {
            C2093b.m4030a(jSONObject, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        JSONObject jSONObject4 = new JSONObject();
        for (VerificationScriptResource verificationScriptResource : adSessionContext.getVerificationScriptResources()) {
            C2093b.m4030a(jSONObject4, verificationScriptResource.getVendorKey(), verificationScriptResource.getVerificationParameters());
        }
        C2084d.m3986a().mo27573a(getWebView(), adSessionId, jSONObject, jSONObject4);
    }

    /* renamed from: a */
    public void mo27601a(VideoEvents videoEvents) {
        this.f4154c = videoEvents;
    }

    /* renamed from: a */
    public void mo27602a(String str) {
        C2084d.m3986a().mo27572a(getWebView(), str, (JSONObject) null);
    }

    /* renamed from: a */
    public void mo27603a(String str, long j) {
        if (j >= this.f4156e) {
            this.f4155d = C2101a.AD_STATE_VISIBLE;
            C2084d.m3986a().mo27581c(getWebView(), str);
        }
    }

    /* renamed from: a */
    public void mo27604a(String str, JSONObject jSONObject) {
        C2084d.m3986a().mo27572a(getWebView(), str, jSONObject);
    }

    /* renamed from: a */
    public void mo27605a(boolean z) {
        if (mo27610e()) {
            C2084d.m3986a().mo27582d(getWebView(), z ? "foregrounded" : "backgrounded");
        }
    }

    /* renamed from: b */
    public void mo27606b() {
        this.f4152a.clear();
    }

    /* renamed from: b */
    public void mo27607b(String str, long j) {
        if (j >= this.f4156e && this.f4155d != C2101a.AD_STATE_NOTVISIBLE) {
            this.f4155d = C2101a.AD_STATE_NOTVISIBLE;
            C2084d.m3986a().mo27581c(getWebView(), str);
        }
    }

    /* renamed from: c */
    public AdEvents mo27608c() {
        return this.f4153b;
    }

    /* renamed from: d */
    public VideoEvents mo27609d() {
        return this.f4154c;
    }

    /* renamed from: e */
    public boolean mo27610e() {
        return this.f4152a.get() != null;
    }

    /* renamed from: f */
    public void mo27611f() {
        C2084d.m3986a().mo27569a(getWebView());
    }

    /* renamed from: g */
    public void mo27612g() {
        C2084d.m3986a().mo27579b(getWebView());
    }

    public WebView getWebView() {
        return (WebView) this.f4152a.get();
    }

    /* renamed from: h */
    public void mo27614h() {
        this.f4156e = C2096d.m4043a();
        this.f4155d = C2101a.AD_STATE_IDLE;
    }
}
