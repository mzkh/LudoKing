package com.iab.omid.library.inmobi.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.inmobi.adsession.VerificationScriptResource;
import com.iab.omid.library.inmobi.p032b.C2083c;
import com.iab.omid.library.inmobi.p032b.C2084d;
import java.util.List;

/* renamed from: com.iab.omid.library.inmobi.publisher.b */
public class C2103b extends AdSessionStatePublisher {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WebView f4161a;

    /* renamed from: b */
    private List<VerificationScriptResource> f4162b;

    /* renamed from: c */
    private final String f4163c;

    public C2103b(List<VerificationScriptResource> list, String str) {
        this.f4162b = list;
        this.f4163c = str;
    }

    /* renamed from: a */
    public void mo27594a() {
        super.mo27594a();
        mo27615i();
    }

    /* renamed from: b */
    public void mo27606b() {
        super.mo27606b();
        new Handler().postDelayed(new Runnable() {

            /* renamed from: b */
            private WebView f4165b = C2103b.this.f4161a;

            public void run() {
                this.f4165b.destroy();
            }
        }, 2000);
        this.f4161a = null;
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: i */
    public void mo27615i() {
        this.f4161a = new WebView(C2083c.m3983a().mo27568b());
        this.f4161a.getSettings().setJavaScriptEnabled(true);
        mo27596a(this.f4161a);
        C2084d.m3986a().mo27578a(this.f4161a, this.f4163c);
        for (VerificationScriptResource resourceUrl : this.f4162b) {
            C2084d.m3986a().mo27580b(this.f4161a, resourceUrl.getResourceUrl().toExternalForm());
        }
    }
}
