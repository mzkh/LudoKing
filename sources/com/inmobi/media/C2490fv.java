package com.inmobi.media;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.inmobi.media.fv */
/* compiled from: WebViewNetworkTask */
public class C2490fv {

    /* renamed from: d */
    private static final String f5458d = "fv";

    /* renamed from: a */
    public C2486fr f5459a;

    /* renamed from: b */
    public WebViewClient f5460b;

    /* renamed from: c */
    public C2491a f5461c;

    /* renamed from: com.inmobi.media.fv$a */
    /* compiled from: WebViewNetworkTask */
    public class C2491a extends WebView {

        /* renamed from: a */
        public boolean f5462a;

        public C2491a(Context context) {
            super(context);
        }

        public final void destroy() {
            this.f5462a = true;
            super.destroy();
        }
    }

    public C2490fv(C2486fr frVar, WebViewClient webViewClient) {
        this.f5460b = webViewClient;
        this.f5459a = frVar;
    }
}
