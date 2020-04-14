package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p020c.C1102b;
import com.applovin.sdk.AppLovinAd;

@TargetApi(29)
/* renamed from: com.applovin.impl.adview.e */
class C0822e extends WebViewRenderProcessClient {

    /* renamed from: a */
    private final C1192i f1428a;

    C0822e(C1192i iVar) {
        this.f1428a = iVar;
    }

    public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
    }

    public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        if (webView instanceof C0801c) {
            AppLovinAd a = ((C0801c) webView).mo9002a();
            if (a instanceof AppLovinAdBase) {
                this.f1428a.mo10198X().mo9993a((AppLovinAdBase) a).mo10000a(C1102b.f2592F).mo10003a();
            }
            C1227o v = this.f1428a.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("WebView render process unresponsive for ad: ");
            sb.append(a);
            v.mo10382e("AdWebViewRenderProcessClient", sb.toString());
        }
    }
}
