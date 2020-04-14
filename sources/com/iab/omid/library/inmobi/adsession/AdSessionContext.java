package com.iab.omid.library.inmobi.adsession;

import android.webkit.WebView;
import com.iab.omid.library.inmobi.p034d.C2097e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AdSessionContext {
    private final AdSessionContextType adSessionContextType;
    private final String customReferenceData;
    private final String omidJsScriptContent;
    private final Partner partner;
    private final List<VerificationScriptResource> verificationScriptResources = new ArrayList();
    private final WebView webView;

    private AdSessionContext(Partner partner2, WebView webView2, String str, List<VerificationScriptResource> list, String str2) {
        AdSessionContextType adSessionContextType2;
        this.partner = partner2;
        this.webView = webView2;
        this.omidJsScriptContent = str;
        if (list != null) {
            this.verificationScriptResources.addAll(list);
            adSessionContextType2 = AdSessionContextType.NATIVE;
        } else {
            adSessionContextType2 = AdSessionContextType.HTML;
        }
        this.adSessionContextType = adSessionContextType2;
        this.customReferenceData = str2;
    }

    public static AdSessionContext createHtmlAdSessionContext(Partner partner2, WebView webView2, String str) {
        C2097e.m4047a((Object) partner2, "Partner is null");
        C2097e.m4047a((Object) webView2, "WebView is null");
        if (str != null) {
            C2097e.m4048a(str, 256, "CustomReferenceData is greater than 256 characters");
        }
        AdSessionContext adSessionContext = new AdSessionContext(partner2, webView2, null, null, str);
        return adSessionContext;
    }

    public static AdSessionContext createNativeAdSessionContext(Partner partner2, String str, List<VerificationScriptResource> list, String str2) {
        C2097e.m4047a((Object) partner2, "Partner is null");
        C2097e.m4047a((Object) str, "OM SDK JS script content is null");
        C2097e.m4047a((Object) list, "VerificationScriptResources is null");
        if (str2 != null) {
            C2097e.m4048a(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        AdSessionContext adSessionContext = new AdSessionContext(partner2, null, str, list, str2);
        return adSessionContext;
    }

    public final AdSessionContextType getAdSessionContextType() {
        return this.adSessionContextType;
    }

    public final String getCustomReferenceData() {
        return this.customReferenceData;
    }

    public final String getOmidJsScriptContent() {
        return this.omidJsScriptContent;
    }

    public final Partner getPartner() {
        return this.partner;
    }

    public final List<VerificationScriptResource> getVerificationScriptResources() {
        return Collections.unmodifiableList(this.verificationScriptResources);
    }

    public final WebView getWebView() {
        return this.webView;
    }
}
