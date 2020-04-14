package com.tapjoy.internal;

import android.annotation.SuppressLint;
import android.webkit.WebView;

/* renamed from: com.tapjoy.internal.dt */
public final class C2966dt extends C2964ds {
    @SuppressLint({"SetJavaScriptEnabled"})
    public C2966dt(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        mo29956a(webView);
    }
}
