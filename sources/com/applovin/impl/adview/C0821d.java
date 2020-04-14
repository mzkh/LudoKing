package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.PointF;
import android.net.Uri;
import android.net.http.SslError;
import android.view.ViewParent;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.p005a.C0769a;
import com.applovin.impl.p005a.C0774b;
import com.applovin.impl.p005a.C0782i;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1102b;
import com.applovin.impl.sdk.p020c.C1108d;
import com.applovin.impl.sdk.utils.C1248i;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinAd;
import com.tapjoy.TapjoyConstants;

/* renamed from: com.applovin.impl.adview.d */
class C0821d extends WebViewClient {

    /* renamed from: a */
    private final C1192i f1425a;

    /* renamed from: b */
    private final C1227o f1426b;

    /* renamed from: c */
    private final AdViewControllerImpl f1427c;

    public C0821d(AdViewControllerImpl adViewControllerImpl, C1192i iVar) {
        this.f1425a = iVar;
        this.f1426b = iVar.mo10249v();
        this.f1427c = adViewControllerImpl;
    }

    /* renamed from: a */
    private void m1157a() {
        this.f1427c.mo8967a();
    }

    /* renamed from: a */
    private void m1158a(PointF pointF) {
        this.f1427c.expandAd(pointF);
    }

    /* renamed from: a */
    private void m1159a(Uri uri, C0801c cVar) {
        C1227o oVar;
        String str;
        String str2 = "AdWebView";
        try {
            String queryParameter = uri.getQueryParameter("n");
            if (C1277l.m3042b(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("load_type");
                if ("external".equalsIgnoreCase(queryParameter2)) {
                    C1227o oVar2 = this.f1426b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Loading new page externally: ");
                    sb.append(queryParameter);
                    oVar2.mo10378b(str2, sb.toString());
                    C1281o.m3090a(cVar.getContext(), Uri.parse(queryParameter), this.f1425a);
                    C1248i.m3012c(this.f1427c.getAdViewEventListener(), this.f1427c.getCurrentAd(), this.f1427c.getParentView());
                    return;
                } else if (TapjoyConstants.LOG_LEVEL_INTERNAL.equalsIgnoreCase(queryParameter2)) {
                    C1227o oVar3 = this.f1426b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Loading new page in WebView: ");
                    sb2.append(queryParameter);
                    oVar3.mo10378b(str2, sb2.toString());
                    cVar.loadUrl(queryParameter);
                    String queryParameter3 = uri.getQueryParameter("bg_color");
                    if (C1277l.m3042b(queryParameter3)) {
                        cVar.setBackgroundColor(Color.parseColor(queryParameter3));
                        return;
                    }
                    return;
                } else {
                    oVar = this.f1426b;
                    str = "Could not find load type in original uri";
                }
            } else {
                oVar = this.f1426b;
                str = "Could not find url to load from query in original uri";
            }
            oVar.mo10382e(str2, str);
        } catch (Throwable unused) {
            this.f1426b.mo10382e(str2, "Failed to load new page from query in original uri");
        }
    }

    /* renamed from: a */
    private void m1160a(C0769a aVar, C0801c cVar) {
        C0774b j = aVar.mo8896j();
        if (j != null) {
            C0782i.m1085a(j.mo8915c(), this.f1427c.getSdk());
            m1162a(cVar, j.mo8913a());
        }
    }

    /* renamed from: a */
    private void m1161a(C0801c cVar) {
        ViewParent parent = cVar.getParent();
        if (parent instanceof AppLovinAdView) {
            ((AppLovinAdView) parent).loadNextAd();
        }
    }

    /* renamed from: a */
    private void m1162a(C0801c cVar, Uri uri) {
        AppLovinAd a = cVar.mo9002a();
        AppLovinAdView parentView = this.f1427c.getParentView();
        if (parentView == null || a == null) {
            C1227o oVar = this.f1426b;
            StringBuilder sb = new StringBuilder();
            sb.append("Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = ");
            sb.append(uri);
            oVar.mo10382e("AdWebView", sb.toString());
            return;
        }
        C1108d b = cVar.mo9007b();
        if (b != null) {
            b.mo10007b();
        }
        this.f1427c.mo8970a(a, parentView, uri, cVar.getAndClearLastClickLocation());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x016e, code lost:
        if (r7.mo8897k() != false) goto L_0x00a9;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m1163a(android.webkit.WebView r10, java.lang.String r11, boolean r12) {
        /*
            r9 = this;
            com.applovin.impl.sdk.o r0 = r9.f1426b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Processing click on ad URL \""
            r1.append(r2)
            r1.append(r11)
            java.lang.String r2 = "\""
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "AdWebView"
            r0.mo10380c(r2, r1)
            r0 = 1
            if (r11 == 0) goto L_0x0180
            boolean r1 = r10 instanceof com.applovin.impl.adview.C0801c
            if (r1 == 0) goto L_0x0180
            android.net.Uri r1 = android.net.Uri.parse(r11)
            r3 = r10
            com.applovin.impl.adview.c r3 = (com.applovin.impl.adview.C0801c) r3
            java.lang.String r4 = r1.getScheme()
            java.lang.String r5 = r1.getHost()
            java.lang.String r6 = r1.getPath()
            com.applovin.impl.adview.AdViewControllerImpl r7 = r9.f1427c
            com.applovin.sdk.AppLovinAd r7 = r7.getCurrentAd()
            java.lang.String r8 = "applovin"
            boolean r8 = r8.equals(r4)
            if (r8 == 0) goto L_0x0135
            java.lang.String r8 = "com.applovin.sdk"
            boolean r8 = r8.equals(r5)
            if (r8 == 0) goto L_0x0135
            java.lang.String r12 = "/adservice/next_ad"
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x005a
            r9.m1161a(r3)
            goto L_0x0180
        L_0x005a:
            java.lang.String r12 = "/adservice/close_ad"
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x0067
            r9.m1157a()
            goto L_0x0180
        L_0x0067:
            java.lang.String r12 = "/adservice/expand_ad"
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x0078
            android.graphics.PointF r10 = r3.getAndClearLastClickLocation()
            r9.m1158a(r10)
            goto L_0x0180
        L_0x0078:
            java.lang.String r12 = "/adservice/contract_ad"
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x0085
            r9.m1164b()
            goto L_0x0180
        L_0x0085:
            java.lang.String r12 = com.applovin.impl.sdk.AppLovinAdServiceImpl.URI_NO_OP
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x008e
            return r0
        L_0x008e:
            java.lang.String r12 = com.applovin.impl.sdk.AppLovinAdServiceImpl.URI_LOAD_URL
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x009b
            r9.m1159a(r1, r3)
            goto L_0x0180
        L_0x009b:
            java.lang.String r12 = com.applovin.impl.sdk.AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x00b9
            boolean r10 = r7 instanceof com.applovin.impl.p005a.C0769a
            if (r10 == 0) goto L_0x00ae
            com.applovin.impl.a.a r7 = (com.applovin.impl.p005a.C0769a) r7
        L_0x00a9:
            r9.m1160a(r7, r3)
            goto L_0x0180
        L_0x00ae:
            java.lang.String r10 = com.applovin.impl.sdk.AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY
            android.net.Uri r10 = android.net.Uri.parse(r10)
            r9.m1162a(r3, r10)
            goto L_0x0180
        L_0x00b9:
            if (r6 == 0) goto L_0x0108
            java.lang.String r12 = "/launch/"
            boolean r12 = r6.startsWith(r12)
            if (r12 == 0) goto L_0x0108
            java.util.List r11 = r1.getPathSegments()
            if (r11 == 0) goto L_0x0180
            int r12 = r11.size()
            if (r12 <= r0) goto L_0x0180
            int r12 = r11.size()
            int r12 = r12 - r0
            java.lang.Object r11 = r11.get(r12)
            java.lang.String r11 = (java.lang.String) r11
            android.content.Context r10 = r10.getContext()     // Catch:{ Throwable -> 0x00ef }
            android.content.pm.PackageManager r12 = r10.getPackageManager()     // Catch:{ Throwable -> 0x00ef }
            android.content.Intent r12 = r12.getLaunchIntentForPackage(r11)     // Catch:{ Throwable -> 0x00ef }
            r10.startActivity(r12)     // Catch:{ Throwable -> 0x00ef }
            r10 = 0
            r9.m1162a(r3, r10)     // Catch:{ Throwable -> 0x00ef }
            goto L_0x0180
        L_0x00ef:
            r10 = move-exception
            com.applovin.impl.sdk.o r12 = r9.f1426b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Threw Exception Trying to Launch App for Package: "
            r1.append(r3)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r12.mo10379b(r2, r11, r10)
            goto L_0x0180
        L_0x0108:
            com.applovin.impl.sdk.o r10 = r9.f1426b
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "Unknown URL: "
            r12.append(r1)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            r10.mo10381d(r2, r11)
            com.applovin.impl.sdk.o r10 = r9.f1426b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Path: "
            r11.append(r12)
            r11.append(r6)
            java.lang.String r11 = r11.toString()
            r10.mo10381d(r2, r11)
            goto L_0x0180
        L_0x0135:
            if (r12 == 0) goto L_0x017e
            boolean r10 = r7 instanceof com.applovin.impl.sdk.p018ad.C1084f
            if (r10 == 0) goto L_0x0176
            r10 = r7
            com.applovin.impl.sdk.ad.f r10 = (com.applovin.impl.sdk.p018ad.C1084f) r10
            java.util.List r11 = r10.mo9914at()
            java.util.List r10 = r10.mo9915au()
            boolean r12 = r11.isEmpty()
            if (r12 != 0) goto L_0x0152
            boolean r11 = r11.contains(r4)
            if (r11 == 0) goto L_0x015f
        L_0x0152:
            boolean r11 = r10.isEmpty()
            if (r11 != 0) goto L_0x0164
            boolean r10 = r10.contains(r5)
            if (r10 == 0) goto L_0x015f
            goto L_0x0164
        L_0x015f:
            com.applovin.impl.sdk.o r10 = r9.f1426b
            java.lang.String r11 = "URL is not whitelisted - bypassing click"
            goto L_0x017a
        L_0x0164:
            boolean r10 = r7 instanceof com.applovin.impl.p005a.C0769a
            if (r10 == 0) goto L_0x0172
            com.applovin.impl.a.a r7 = (com.applovin.impl.p005a.C0769a) r7
            boolean r10 = r7.mo8897k()
            if (r10 == 0) goto L_0x0172
            goto L_0x00a9
        L_0x0172:
            r9.m1162a(r3, r1)
            goto L_0x0180
        L_0x0176:
            com.applovin.impl.sdk.o r10 = r9.f1426b
            java.lang.String r11 = "Bypassing click for ad of invalid type"
        L_0x017a:
            r10.mo10382e(r2, r11)
            goto L_0x0180
        L_0x017e:
            r10 = 0
            return r10
        L_0x0180:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C0821d.m1163a(android.webkit.WebView, java.lang.String, boolean):boolean");
    }

    /* renamed from: b */
    private void m1164b() {
        this.f1427c.contractAd();
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        C1227o oVar = this.f1426b;
        StringBuilder sb = new StringBuilder();
        sb.append("Loaded resource: ");
        sb.append(str);
        oVar.mo10380c("AdWebView", sb.toString());
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f1427c.onAdHtmlLoaded(webView);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        AppLovinAd currentAd = this.f1427c.getCurrentAd();
        StringBuilder sb = new StringBuilder();
        sb.append("Received error with error code: ");
        sb.append(i);
        sb.append(" with description \\'");
        sb.append(str);
        sb.append("\\' for URL: ");
        sb.append(str2);
        String sb2 = sb.toString();
        if (currentAd instanceof AppLovinAdBase) {
            this.f1425a.mo10198X().mo9993a((AppLovinAdBase) currentAd).mo10002a(C1102b.f2589C, sb2).mo10003a();
        }
        C1227o oVar = this.f1426b;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(" for ad: ");
        sb3.append(currentAd);
        oVar.mo10382e("AdWebView", sb3.toString());
    }

    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        AppLovinAd currentAd = this.f1427c.getCurrentAd();
        if (currentAd instanceof AppLovinAdBase) {
            this.f1425a.mo10198X().mo9993a((AppLovinAdBase) currentAd).mo10000a(C1102b.f2590D).mo10003a();
        }
        C1227o oVar = this.f1426b;
        StringBuilder sb = new StringBuilder();
        sb.append("Received HTTP error: ");
        sb.append(webResourceResponse);
        sb.append("for request: ");
        sb.append(webResourceRequest);
        sb.append(" and ad: ");
        sb.append(currentAd);
        oVar.mo10382e("AdWebView", sb.toString());
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        AppLovinAd currentAd = this.f1427c.getCurrentAd();
        StringBuilder sb = new StringBuilder();
        sb.append("Received SSL error: ");
        sb.append(sslError);
        String sb2 = sb.toString();
        if (currentAd instanceof AppLovinAdBase) {
            this.f1425a.mo10198X().mo9993a((AppLovinAdBase) currentAd).mo10002a(C1102b.f2591E, sb2).mo10003a();
        }
        C1227o oVar = this.f1426b;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(" for ad: ");
        sb3.append(currentAd);
        oVar.mo10382e("AdWebView", sb3.toString());
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean hasGesture = ((Boolean) this.f1425a.mo10202a(C1096c.f2420cd)).booleanValue() ? webResourceRequest.hasGesture() : true;
        Uri url = webResourceRequest.getUrl();
        if (url != null) {
            return m1163a(webView, url.toString(), hasGesture);
        }
        this.f1426b.mo10382e("AdWebView", "No url found for request");
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return m1163a(webView, str, true);
    }
}
