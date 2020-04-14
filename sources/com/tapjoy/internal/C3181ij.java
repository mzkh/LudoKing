package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyConstants;
import java.util.List;
import java.util.Map;

/* renamed from: com.tapjoy.internal.ij */
public final class C3181ij extends C1850ii {

    /* renamed from: c */
    public final String f7572c;

    /* renamed from: d */
    public boolean f7573d = false;

    /* renamed from: e */
    private final C1831gz f7574e;

    /* renamed from: f */
    private final C3041fa f7575f;

    /* renamed from: g */
    private final C3023eu f7576g;

    /* renamed from: h */
    private final C3062fh f7577h;

    /* renamed from: i */
    private Context f7578i;

    /* renamed from: com.tapjoy.internal.ij$a */
    public static class C3182a {

        /* renamed from: a */
        public C1837hg f7579a;

        /* renamed from: b */
        public final List f7580b;

        public C3182a(C1837hg hgVar, List list) {
            this.f7579a = hgVar;
            this.f7580b = list;
        }
    }

    /* renamed from: c */
    public final String mo18084c() {
        return "placement";
    }

    public C3181ij(C1831gz gzVar, C3041fa faVar, C3023eu euVar, C3062fh fhVar, String str, Context context) {
        this.f7574e = gzVar;
        this.f7575f = faVar;
        this.f7576g = euVar;
        this.f7577h = fhVar;
        this.f7572c = str;
        this.f7578i = context;
    }

    /* renamed from: e */
    public final Map mo18086e() {
        Map e = super.mo18086e();
        e.put(String.VIDEO_INFO, new C2902bm(C3149hp.m7286a(this.f7575f)));
        e.put(TapjoyConstants.TJC_APP_PLACEMENT, new C2902bm(C3149hp.m7282a(this.f7576g)));
        e.put("user", new C2902bm(C3149hp.m7287a(this.f7577h)));
        e.put("placement", this.f7572c);
        return e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ Object mo18079a(C1812bn bnVar) {
        bnVar.mo18067h();
        C1845hu huVar = null;
        C3151hr hrVar = null;
        List list = null;
        while (bnVar.mo18069j()) {
            String l = bnVar.mo18071l();
            if ("interstitial".equals(l)) {
                huVar = (C1845hu) bnVar.mo18052a(C1845hu.f3865n);
            } else if ("contextual_button".equals(l)) {
                hrVar = (C3151hr) bnVar.mo18052a(C3151hr.f7467d);
            } else if ("enabled_placements".equals(l)) {
                list = bnVar.mo18058c();
            } else {
                bnVar.mo18078s();
            }
        }
        bnVar.mo18068i();
        if (huVar != null && (huVar.mo18187a() || huVar.mo18188b())) {
            return new C3182a(new C3136he(this.f7574e, this.f7572c, huVar, this.f7578i), list);
        }
        if (hrVar != null) {
            return new C3182a(new C3120gv(this.f7574e, this.f7572c, hrVar, this.f7578i), list);
        }
        return new C3182a(new C3141hf(), list);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final /* synthetic */ Object mo18087f() {
        C3182a aVar = (C3182a) super.mo18087f();
        if (!(aVar.f7579a instanceof C3141hf)) {
            aVar.f7579a.mo18174b();
            if (!aVar.f7579a.mo18175c()) {
                new Object[1][0] = this.f7572c;
                aVar.f7579a = new C3141hf();
            }
        }
        return aVar;
    }
}
