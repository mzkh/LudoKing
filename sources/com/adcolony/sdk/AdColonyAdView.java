package com.adcolony.sdk;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import java.io.File;
import org.json.JSONObject;

public class AdColonyAdView extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0580c f70a = ((C0580c) C0476a.m77a().mo8578l().mo8507b().get(this.f73d));

    /* renamed from: b */
    private AdColonyAdViewListener f71b;

    /* renamed from: c */
    private AdColonyAdSize f72c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f73d;

    /* renamed from: e */
    private String f74e;

    /* renamed from: f */
    private String f75f;

    /* renamed from: g */
    private ImageView f76g;

    /* renamed from: h */
    private C0487ag f77h;

    /* renamed from: i */
    private C0480ab f78i;

    /* renamed from: j */
    private boolean f79j;

    /* renamed from: k */
    private boolean f80k;

    /* renamed from: l */
    private boolean f81l;

    /* renamed from: m */
    private boolean f82m;

    /* renamed from: n */
    private boolean f83n;

    /* renamed from: o */
    private int f84o;

    /* renamed from: p */
    private int f85p;

    /* renamed from: q */
    private int f86q;

    /* renamed from: r */
    private int f87r;

    /* renamed from: s */
    private int f88s;

    /* renamed from: t */
    private JSONObject f89t;

    AdColonyAdView(Context context, C0480ab abVar, AdColonyAdViewListener adColonyAdViewListener) {
        super(context);
        this.f71b = adColonyAdViewListener;
        this.f74e = adColonyAdViewListener.mo8069a();
        JSONObject c = abVar.mo8220c();
        this.f89t = c;
        this.f73d = C0746u.m908b(c, "id");
        this.f75f = C0746u.m908b(c, "close_button_filepath");
        this.f79j = C0746u.m918d(c, "trusted_demand_source");
        this.f83n = C0746u.m918d(c, "close_button_snap_to_webview");
        this.f87r = C0746u.m914c(c, "close_button_width");
        this.f88s = C0746u.m914c(c, "close_button_height");
        this.f72c = adColonyAdViewListener.mo8073b();
        setLayoutParams(new LayoutParams(this.f70a.mo8493p(), this.f70a.mo8490o()));
        setBackgroundColor(0);
        addView(this.f70a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8035a() {
        if (this.f77h != null) {
            getWebView().mo8415k();
        }
    }

    public boolean destroy() {
        if (this.f80k) {
            new C0749a().mo8726a("Ignoring duplicate call to destroy().").mo8728a(C0748w.f1169e);
            return false;
        }
        this.f80k = true;
        C0487ag agVar = this.f77h;
        if (!(agVar == null || agVar.mo8252e() == null)) {
            this.f77h.mo8244a();
        }
        C0543at.m309a((Runnable) new Runnable() {
            public void run() {
                Context c = C0476a.m85c();
                if (c instanceof AdColonyAdViewActivity) {
                    ((AdColonyAdViewActivity) c).mo8060b();
                }
                C0595d l = C0476a.m77a().mo8578l();
                l.mo8512e().remove(AdColonyAdView.this.f73d);
                l.mo8502a(AdColonyAdView.this.f70a);
                JSONObject a = C0746u.m892a();
                C0746u.m902a(a, "id", AdColonyAdView.this.f73d);
                new C0480ab("AdSession.on_ad_view_destroyed", 1, a).mo8217b();
            }
        });
        return true;
    }

    public String getZoneId() {
        return this.f74e;
    }

    public void setListener(AdColonyAdViewListener adColonyAdViewListener) {
        this.f71b = adColonyAdViewListener;
    }

    public AdColonyAdViewListener getListener() {
        return this.f71b;
    }

    public AdColonyAdSize getAdSize() {
        return this.f72c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo8036b() {
        String str = "success";
        if (this.f79j || this.f82m) {
            C0691l m = C0476a.m77a().mo8579m();
            int q = m.mo8641q();
            int r = m.mo8642r();
            int i = this.f85p;
            if (i <= 0) {
                i = q;
            }
            int i2 = this.f86q;
            if (i2 <= 0) {
                i2 = r;
            }
            int i3 = (q - i) / 2;
            int i4 = (r - i2) / 2;
            this.f70a.setLayoutParams(new LayoutParams(q, r));
            C0557av webView = getWebView();
            if (webView != null) {
                C0480ab abVar = new C0480ab("WebView.set_bounds", 0);
                JSONObject a = C0746u.m892a();
                String str2 = "x";
                C0746u.m912b(a, str2, i3);
                String str3 = "y";
                C0746u.m912b(a, str3, i4);
                String str4 = "width";
                C0746u.m912b(a, str4, i);
                String str5 = "height";
                C0746u.m912b(a, str5, i2);
                abVar.mo8219b(a);
                webView.mo8407b(abVar);
                float p = m.mo8640p();
                JSONObject a2 = C0746u.m892a();
                C0746u.m912b(a2, "app_orientation", C0543at.m335j(C0543at.m332h()));
                C0746u.m912b(a2, str4, (int) (((float) i) / p));
                C0746u.m912b(a2, str5, (int) (((float) i2) / p));
                C0746u.m912b(a2, str2, C0543at.m297a((View) webView));
                C0746u.m912b(a2, str3, C0543at.m315b((View) webView));
                C0746u.m902a(a2, "ad_session_id", this.f73d);
                new C0480ab("MRAID.on_size_change", this.f70a.mo8467c(), a2).mo8217b();
            }
            ImageView imageView = this.f76g;
            if (imageView != null) {
                this.f70a.removeView(imageView);
            }
            final Context c = C0476a.m85c();
            if (!(c == null || this.f81l || webView == null)) {
                float p2 = C0476a.m77a().mo8579m().mo8640p();
                int i5 = (int) (((float) this.f87r) * p2);
                int i6 = (int) (((float) this.f88s) * p2);
                if (this.f83n) {
                    q = webView.mo8426u() + webView.mo8424s();
                }
                int v = this.f83n ? webView.mo8427v() : 0;
                this.f76g = new ImageView(c.getApplicationContext());
                this.f76g.setImageURI(Uri.fromFile(new File(this.f75f)));
                LayoutParams layoutParams = new LayoutParams(i5, i6);
                layoutParams.setMargins(q - i5, v, 0, 0);
                this.f76g.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        Context context = c;
                        if (context instanceof AdColonyAdViewActivity) {
                            ((AdColonyAdViewActivity) context).mo8060b();
                        }
                    }
                });
                this.f70a.addView(this.f76g, layoutParams);
            }
            if (this.f78i != null) {
                JSONObject a3 = C0746u.m892a();
                C0746u.m913b(a3, str, true);
                this.f78i.mo8216a(a3).mo8217b();
                this.f78i = null;
            }
            return true;
        }
        if (this.f78i != null) {
            JSONObject a4 = C0746u.m892a();
            C0746u.m913b(a4, str, false);
            this.f78i.mo8216a(a4).mo8217b();
            this.f78i = null;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8037c() {
        if (this.f79j || this.f82m) {
            float p = C0476a.m77a().mo8579m().mo8640p();
            this.f70a.setLayoutParams(new LayoutParams((int) (((float) this.f72c.getWidth()) * p), (int) (((float) this.f72c.getHeight()) * p)));
            C0557av webView = getWebView();
            if (webView != null) {
                C0480ab abVar = new C0480ab("WebView.set_bounds", 0);
                JSONObject a = C0746u.m892a();
                C0746u.m912b(a, "x", webView.mo8419o());
                C0746u.m912b(a, "y", webView.mo8421p());
                C0746u.m912b(a, "width", webView.mo8422q());
                C0746u.m912b(a, "height", webView.mo8423r());
                abVar.mo8219b(a);
                webView.mo8407b(abVar);
                JSONObject a2 = C0746u.m892a();
                C0746u.m902a(a2, "ad_session_id", this.f73d);
                new C0480ab("MRAID.on_close", this.f70a.mo8467c(), a2).mo8217b();
            }
            ImageView imageView = this.f76g;
            if (imageView != null) {
                this.f70a.removeView(imageView);
            }
            addView(this.f70a);
            AdColonyAdViewListener adColonyAdViewListener = this.f71b;
            if (adColonyAdViewListener != null) {
                adColonyAdViewListener.onClosed(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public C0487ag getOmidManager() {
        return this.f77h;
    }

    /* access modifiers changed from: 0000 */
    public void setOmidManager(C0487ag agVar) {
        this.f77h = agVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo8038d() {
        return this.f80k;
    }

    /* access modifiers changed from: 0000 */
    public String getAdSessionId() {
        return this.f73d;
    }

    /* access modifiers changed from: 0000 */
    public C0580c getContainer() {
        return this.f70a;
    }

    /* access modifiers changed from: 0000 */
    public void setNoCloseButton(boolean z) {
        this.f81l = this.f79j && z;
    }

    /* access modifiers changed from: 0000 */
    public void setUserInteraction(boolean z) {
        this.f82m = z;
    }

    /* access modifiers changed from: 0000 */
    public boolean getUserInteraction() {
        return this.f82m;
    }

    /* access modifiers changed from: 0000 */
    public boolean getTrustedDemandSource() {
        return this.f79j;
    }

    /* access modifiers changed from: 0000 */
    public void setExpandedWidth(int i) {
        this.f85p = (int) (((float) i) * C0476a.m77a().mo8579m().mo8640p());
    }

    /* access modifiers changed from: 0000 */
    public void setExpandedHeight(int i) {
        this.f86q = (int) (((float) i) * C0476a.m77a().mo8579m().mo8640p());
    }

    /* access modifiers changed from: 0000 */
    public int getOrientation() {
        return this.f84o;
    }

    /* access modifiers changed from: 0000 */
    public void setOrientation(int i) {
        this.f84o = i;
    }

    /* access modifiers changed from: 0000 */
    public C0557av getWebView() {
        C0580c cVar = this.f70a;
        if (cVar == null) {
            return null;
        }
        return (C0557av) cVar.mo8477g().get(Integer.valueOf(2));
    }

    /* access modifiers changed from: 0000 */
    public void setExpandMessage(C0480ab abVar) {
        this.f78i = abVar;
    }
}
