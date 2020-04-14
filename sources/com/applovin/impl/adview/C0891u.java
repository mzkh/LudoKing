package com.applovin.impl.adview;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.appsflyer.share.Constants;

/* renamed from: com.applovin.impl.adview.u */
public class C0891u extends C0825g {
    public C0891u(C0892v vVar, Context context) {
        super(context);
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        setWebViewClient(vVar);
        setWebChromeClient(new WebChromeClient());
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
    }

    /* renamed from: a */
    public void mo9222a(String str) {
        loadDataWithBaseURL(Constants.URL_PATH_DELIMITER, str, "text/html", null, "");
    }
}
