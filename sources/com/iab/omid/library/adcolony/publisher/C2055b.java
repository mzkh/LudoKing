package com.iab.omid.library.adcolony.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.adcolony.adsession.VerificationScriptResource;
import com.iab.omid.library.adcolony.p026b.C2035c;
import com.iab.omid.library.adcolony.p026b.C2036d;
import java.util.List;

/* renamed from: com.iab.omid.library.adcolony.publisher.b */
public class C2055b extends AdSessionStatePublisher {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WebView f4061a;

    /* renamed from: b */
    private List<VerificationScriptResource> f4062b;

    /* renamed from: c */
    private final String f4063c;

    public C2055b(List<VerificationScriptResource> list, String str) {
        this.f4062b = list;
        this.f4063c = str;
    }

    /* renamed from: a */
    public void mo27430a() {
        super.mo27430a();
        mo27451i();
    }

    /* renamed from: b */
    public void mo27442b() {
        super.mo27442b();
        new Handler().postDelayed(new Runnable() {

            /* renamed from: b */
            private WebView f4065b = C2055b.this.f4061a;

            public void run() {
                this.f4065b.destroy();
            }
        }, 2000);
        this.f4061a = null;
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: i */
    public void mo27451i() {
        this.f4061a = new WebView(C2035c.m3779a().mo27405b());
        this.f4061a.getSettings().setJavaScriptEnabled(true);
        mo27432a(this.f4061a);
        C2036d.m3782a().mo27415a(this.f4061a, this.f4063c);
        for (VerificationScriptResource resourceUrl : this.f4062b) {
            C2036d.m3782a().mo27417b(this.f4061a, resourceUrl.getResourceUrl().toExternalForm());
        }
    }
}
