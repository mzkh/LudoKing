package com.tapjoy.internal;

import android.graphics.Rect;
import com.tapjoy.TapjoyConstants;

/* renamed from: com.tapjoy.internal.hs */
public final class C3153hs {

    /* renamed from: h */
    public static final C2896bi f7471h = new C2896bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18189a(C1812bn bnVar) {
            bnVar.mo18067h();
            Rect rect = null;
            String str = null;
            String str2 = null;
            String str3 = null;
            C1829gl glVar = null;
            String str4 = "";
            boolean z = false;
            while (bnVar.mo18069j()) {
                String l = bnVar.mo18071l();
                if ("region".equals(l)) {
                    rect = (Rect) C2897bj.f6694b.mo18189a(bnVar);
                } else if ("value".equals(l)) {
                    str = bnVar.mo18072m();
                } else if (TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL.equals(l)) {
                    z = bnVar.mo18073n();
                } else if ("url".equals(l)) {
                    str4 = bnVar.mo18072m();
                } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l)) {
                    str2 = bnVar.mo18056b();
                } else if ("ad_content".equals(l)) {
                    str3 = bnVar.mo18056b();
                } else if (C1843ho.m3639a(l)) {
                    glVar = C1843ho.m3638a(l, bnVar);
                } else {
                    bnVar.mo18078s();
                }
            }
            bnVar.mo18068i();
            C3153hs hsVar = new C3153hs(rect, str, z, str4, str2, str3, glVar);
            return hsVar;
        }
    };

    /* renamed from: a */
    public final Rect f7472a;

    /* renamed from: b */
    public final String f7473b;

    /* renamed from: c */
    public final boolean f7474c;

    /* renamed from: d */
    public final String f7475d;

    /* renamed from: e */
    public String f7476e;

    /* renamed from: f */
    public String f7477f;

    /* renamed from: g */
    public final C1829gl f7478g;

    C3153hs(Rect rect, String str, boolean z, String str2, String str3, String str4, C1829gl glVar) {
        this.f7472a = rect;
        this.f7473b = str;
        this.f7474c = z;
        this.f7475d = str2;
        this.f7476e = str3;
        this.f7477f = str4;
        this.f7478g = glVar;
    }
}
