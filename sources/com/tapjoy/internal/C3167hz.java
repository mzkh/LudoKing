package com.tapjoy.internal;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyConstants;

/* renamed from: com.tapjoy.internal.hz */
public final class C3167hz {

    /* renamed from: n */
    public static final C2896bi f7509n = new C2896bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18189a(C1812bn bnVar) {
            return new C3167hz(bnVar);
        }
    };

    /* renamed from: a */
    public C3172ib f7510a;

    /* renamed from: b */
    public C3172ib f7511b;

    /* renamed from: c */
    public C3172ib f7512c;

    /* renamed from: d */
    public C3172ib f7513d;

    /* renamed from: e */
    public int f7514e = 9;

    /* renamed from: f */
    public int f7515f = 10;

    /* renamed from: g */
    public String f7516g;

    /* renamed from: h */
    public String f7517h;

    /* renamed from: i */
    public String f7518i;

    /* renamed from: j */
    public boolean f7519j = false;

    /* renamed from: k */
    public String f7520k;

    /* renamed from: l */
    public C3163hx f7521l;

    /* renamed from: m */
    public C3163hx f7522m;

    public C3167hz(C1812bn bnVar) {
        bnVar.mo18067h();
        while (bnVar.mo18069j()) {
            String l = bnVar.mo18071l();
            if ("x".equals(l)) {
                this.f7510a = C3172ib.m7320a(bnVar.mo18072m());
            } else if ("y".equals(l)) {
                this.f7511b = C3172ib.m7320a(bnVar.mo18072m());
            } else if ("width".equals(l)) {
                this.f7512c = C3172ib.m7320a(bnVar.mo18072m());
            } else if ("height".equals(l)) {
                this.f7513d = C3172ib.m7320a(bnVar.mo18072m());
            } else if ("url".equals(l)) {
                this.f7516g = bnVar.mo18072m();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l)) {
                this.f7517h = bnVar.mo18072m();
            } else if ("ad_content".equals(l)) {
                this.f7518i = bnVar.mo18072m();
            } else if (TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL.equals(l)) {
                this.f7519j = bnVar.mo18073n();
            } else if ("value".equals(l)) {
                this.f7520k = bnVar.mo18072m();
            } else if (MessengerShareContentUtility.MEDIA_IMAGE.equals(l)) {
                this.f7521l = (C3163hx) C3163hx.f7498e.mo18189a(bnVar);
            } else if ("image_clicked".equals(l)) {
                this.f7522m = (C3163hx) C3163hx.f7498e.mo18189a(bnVar);
            } else if ("align".equals(l)) {
                String m = bnVar.mo18072m();
                if ("left".equals(m)) {
                    this.f7514e = 9;
                } else if (String.RIGHT.equals(m)) {
                    this.f7514e = 11;
                } else if ("center".equals(m)) {
                    this.f7514e = 14;
                } else {
                    bnVar.mo18078s();
                }
            } else if ("valign".equals(l)) {
                String m2 = bnVar.mo18072m();
                if ("top".equals(m2)) {
                    this.f7515f = 10;
                } else if ("middle".equals(m2)) {
                    this.f7515f = 15;
                } else if (String.BOTTOM.equals(m2)) {
                    this.f7515f = 12;
                } else {
                    bnVar.mo18078s();
                }
            } else {
                bnVar.mo18078s();
            }
        }
        bnVar.mo18068i();
    }
}
