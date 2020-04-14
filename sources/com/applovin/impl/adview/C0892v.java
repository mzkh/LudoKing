package com.applovin.impl.adview;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.adview.v */
public class C0892v extends WebViewClient {

    /* renamed from: a */
    private final C1227o f1621a;

    /* renamed from: b */
    private WeakReference<C0893a> f1622b;

    /* renamed from: com.applovin.impl.adview.v$a */
    public interface C0893a {
        /* renamed from: a */
        void mo9136a(C0891u uVar);

        /* renamed from: b */
        void mo9137b(C0891u uVar);

        /* renamed from: c */
        void mo9138c(C0891u uVar);
    }

    public C0892v(C1192i iVar) {
        this.f1621a = iVar.mo10249v();
    }

    /* renamed from: a */
    private void m1366a(WebView webView, String str) {
        C1227o oVar = this.f1621a;
        StringBuilder sb = new StringBuilder();
        sb.append("Processing click on ad URL \"");
        sb.append(str);
        sb.append("\"");
        String str2 = "WebViewButtonClient";
        oVar.mo10380c(str2, sb.toString());
        if (str != null && (webView instanceof C0891u)) {
            C0891u uVar = (C0891u) webView;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            C0893a aVar = (C0893a) this.f1622b.get();
            if ("applovin".equalsIgnoreCase(scheme) && "com.applovin.sdk".equalsIgnoreCase(host) && aVar != null) {
                if ("/track_click".equals(path)) {
                    aVar.mo9136a(uVar);
                } else if ("/close_ad".equals(path)) {
                    aVar.mo9137b(uVar);
                } else if ("/skip_ad".equals(path)) {
                    aVar.mo9138c(uVar);
                } else {
                    C1227o oVar2 = this.f1621a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unknown URL: ");
                    sb2.append(str);
                    oVar2.mo10381d(str2, sb2.toString());
                    C1227o oVar3 = this.f1621a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Path: ");
                    sb3.append(path);
                    oVar3.mo10381d(str2, sb3.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public void mo9223a(WeakReference<C0893a> weakReference) {
        this.f1622b = weakReference;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        m1366a(webView, str);
        return true;
    }
}
