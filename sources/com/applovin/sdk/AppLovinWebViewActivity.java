package com.applovin.sdk;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.utils.C1277l;
import java.util.Set;

public class AppLovinWebViewActivity extends Activity {
    public static final String EVENT_DISMISSED_VIA_BACK_BUTTON = "dismissed_via_back_button";
    public static final String INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON = "immersive_mode_on";
    public static final String INTENT_EXTRA_KEY_SDK_KEY = "sdk_key";

    /* renamed from: a */
    private WebView f3283a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EventListener f3284b;

    public interface EventListener {
        void onReceivedEvent(String str);
    }

    public void loadUrl(String str, EventListener eventListener) {
        this.f3284b = eventListener;
        this.f3283a.loadUrl(str);
    }

    public void onBackPressed() {
        EventListener eventListener = this.f3284b;
        if (eventListener != null) {
            eventListener.onReceivedEvent(EVENT_DISMISSED_VIA_BACK_BUTTON);
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(INTENT_EXTRA_KEY_SDK_KEY);
        if (!TextUtils.isEmpty(stringExtra)) {
            final AppLovinSdk instance = AppLovinSdk.getInstance(stringExtra, new AppLovinSdkSettings(), getApplicationContext());
            this.f3283a = new WebView(this);
            setContentView(this.f3283a);
            WebSettings settings = this.f3283a.getSettings();
            settings.setSupportMultipleWindows(false);
            settings.setJavaScriptEnabled(true);
            this.f3283a.setVerticalScrollBarEnabled(true);
            this.f3283a.setHorizontalScrollBarEnabled(true);
            this.f3283a.setScrollBarStyle(33554432);
            this.f3283a.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    Uri parse = Uri.parse(str);
                    String scheme = parse.getScheme();
                    String host = parse.getHost();
                    String path = parse.getPath();
                    C1227o logger = instance.getLogger();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Handling url load: ");
                    sb.append(str);
                    String str2 = "AppLovinWebViewActivity";
                    logger.mo10378b(str2, sb.toString());
                    if (!"applovin".equalsIgnoreCase(scheme) || !"com.applovin.sdk".equalsIgnoreCase(host) || AppLovinWebViewActivity.this.f3284b == null) {
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                    if (path.endsWith("webview_event")) {
                        Set queryParameterNames = parse.getQueryParameterNames();
                        String str3 = queryParameterNames.isEmpty() ? "" : (String) queryParameterNames.toArray()[0];
                        if (C1277l.m3042b(str3)) {
                            String queryParameter = parse.getQueryParameter(str3);
                            C1227o logger2 = instance.getLogger();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Parsed WebView event parameter name: ");
                            sb2.append(str3);
                            sb2.append(" and value: ");
                            sb2.append(queryParameter);
                            logger2.mo10378b(str2, sb2.toString());
                            AppLovinWebViewActivity.this.f3284b.onReceivedEvent(queryParameter);
                        } else {
                            instance.getLogger().mo10382e(str2, "Failed to parse WebView event parameter");
                        }
                    }
                    return true;
                }
            });
            if (getIntent().getBooleanExtra(INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, false)) {
                getWindow().getDecorView().setSystemUiVisibility(5894);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("No SDK key specified");
    }
}
