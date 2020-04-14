package com.iab.omid.library.inmobi.publisher;

import android.annotation.SuppressLint;
import android.webkit.WebView;

/* renamed from: com.iab.omid.library.inmobi.publisher.a */
public class C2102a extends AdSessionStatePublisher {
    @SuppressLint({"SetJavaScriptEnabled"})
    public C2102a(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        mo27596a(webView);
    }
}
