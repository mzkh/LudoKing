package com.iab.omid.library.adcolony.publisher;

import android.annotation.SuppressLint;
import android.webkit.WebView;

/* renamed from: com.iab.omid.library.adcolony.publisher.a */
public class C2054a extends AdSessionStatePublisher {
    @SuppressLint({"SetJavaScriptEnabled"})
    public C2054a(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        mo27432a(webView);
    }
}
