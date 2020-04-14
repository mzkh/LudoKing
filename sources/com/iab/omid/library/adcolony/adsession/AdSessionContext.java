package com.iab.omid.library.adcolony.adsession;

import android.webkit.WebView;
import com.iab.omid.library.adcolony.p028d.C2049e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AdSessionContext {

    /* renamed from: a */
    private final Partner f3977a;

    /* renamed from: b */
    private final WebView f3978b;

    /* renamed from: c */
    private final List<VerificationScriptResource> f3979c = new ArrayList();

    /* renamed from: d */
    private final String f3980d;

    /* renamed from: e */
    private final String f3981e;

    /* renamed from: f */
    private final AdSessionContextType f3982f;

    private AdSessionContext(Partner partner, WebView webView, String str, List<VerificationScriptResource> list, String str2) {
        AdSessionContextType adSessionContextType;
        this.f3977a = partner;
        this.f3978b = webView;
        this.f3980d = str;
        if (list != null) {
            this.f3979c.addAll(list);
            adSessionContextType = AdSessionContextType.NATIVE;
        } else {
            adSessionContextType = AdSessionContextType.HTML;
        }
        this.f3982f = adSessionContextType;
        this.f3981e = str2;
    }

    public static AdSessionContext createHtmlAdSessionContext(Partner partner, WebView webView, String str) {
        C2049e.m3841a((Object) partner, "Partner is null");
        C2049e.m3841a((Object) webView, "WebView is null");
        if (str != null) {
            C2049e.m3842a(str, 256, "CustomReferenceData is greater than 256 characters");
        }
        AdSessionContext adSessionContext = new AdSessionContext(partner, webView, null, null, str);
        return adSessionContext;
    }

    public static AdSessionContext createNativeAdSessionContext(Partner partner, String str, List<VerificationScriptResource> list, String str2) {
        C2049e.m3841a((Object) partner, "Partner is null");
        C2049e.m3841a((Object) str, "OM SDK JS script content is null");
        C2049e.m3841a((Object) list, "VerificationScriptResources is null");
        if (str2 != null) {
            C2049e.m3842a(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        AdSessionContext adSessionContext = new AdSessionContext(partner, null, str, list, str2);
        return adSessionContext;
    }

    public AdSessionContextType getAdSessionContextType() {
        return this.f3982f;
    }

    public String getCustomReferenceData() {
        return this.f3981e;
    }

    public String getOmidJsScriptContent() {
        return this.f3980d;
    }

    public Partner getPartner() {
        return this.f3977a;
    }

    public List<VerificationScriptResource> getVerificationScriptResources() {
        return Collections.unmodifiableList(this.f3979c);
    }

    public WebView getWebView() {
        return this.f3978b;
    }
}
