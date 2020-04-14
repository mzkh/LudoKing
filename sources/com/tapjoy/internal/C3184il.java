package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyConstants;
import java.util.Map;

/* renamed from: com.tapjoy.internal.il */
public final class C3184il extends C1850ii {

    /* renamed from: c */
    private final C3041fa f7583c;

    /* renamed from: d */
    private final C3023eu f7584d;

    /* renamed from: e */
    private final C3062fh f7585e;

    /* renamed from: f */
    private final String f7586f;

    /* renamed from: c */
    public final String mo18084c() {
        return "api/v1/tokens";
    }

    private C3184il(C3041fa faVar, C3023eu euVar, C3062fh fhVar, String str) {
        this.f7583c = faVar;
        this.f7584d = euVar;
        this.f7585e = fhVar;
        this.f7586f = str;
    }

    public C3184il(C3044fb fbVar, String str) {
        this(fbVar.f7101d, fbVar.f7102e, fbVar.f7103f, str);
    }

    /* renamed from: e */
    public final Map mo18086e() {
        Map e = super.mo18086e();
        e.put(String.VIDEO_INFO, new C2902bm(C3149hp.m7286a(this.f7583c)));
        e.put(TapjoyConstants.TJC_APP_PLACEMENT, new C2902bm(C3149hp.m7282a(this.f7584d)));
        e.put("user", new C2902bm(C3149hp.m7287a(this.f7585e)));
        if (!C2874al.m6573a(this.f7586f)) {
            e.put("push_token", this.f7586f);
        }
        return e;
    }
}
