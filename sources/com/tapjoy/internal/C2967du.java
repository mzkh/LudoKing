package com.tapjoy.internal;

import android.os.Handler;
import android.webkit.WebView;
import java.util.List;

/* renamed from: com.tapjoy.internal.du */
public final class C2967du extends C2964ds {

    /* renamed from: f */
    WebView f6839f;

    /* renamed from: g */
    private List f6840g;

    /* renamed from: h */
    private final String f6841h;

    public C2967du(List list, String str) {
        this.f6840g = list;
        this.f6841h = str;
    }

    /* renamed from: b */
    public final void mo29960b() {
        super.mo29960b();
        new Handler().postDelayed(new Runnable() {

            /* renamed from: b */
            private WebView f6843b = C2967du.this.f6839f;

            public final void run() {
                this.f6843b.destroy();
            }
        }, 2000);
        this.f6839f = null;
    }

    /* renamed from: a */
    public final void mo29954a() {
        super.mo29954a();
        this.f6839f = new WebView(C2948df.m6725a().f6810a);
        this.f6839f.getSettings().setJavaScriptEnabled(true);
        mo29956a(this.f6839f);
        C2949dg.m6726a();
        C2949dg.m6728a(this.f6839f, this.f6841h);
        for (C2939cy cyVar : this.f6840g) {
            String externalForm = cyVar.f6777b.toExternalForm();
            C2949dg.m6726a();
            WebView webView = this.f6839f;
            if (externalForm != null) {
                C2949dg.m6728a(webView, "var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);".replace("%SCRIPT_SRC%", externalForm));
            }
        }
    }
}
