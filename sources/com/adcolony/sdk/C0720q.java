package com.adcolony.sdk;

import java.util.Date;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.q */
class C0720q extends C0750x {

    /* renamed from: a */
    static final C0745t f1103a = new C0745t("adcolony_fatal_reports", "4.1.0", "Production");

    /* renamed from: b */
    static final String f1104b = "sourceFile";

    /* renamed from: c */
    static final String f1105c = "lineNumber";

    /* renamed from: d */
    static final String f1106d = "methodName";

    /* renamed from: e */
    static final String f1107e = "stackTrace";

    /* renamed from: f */
    static final String f1108f = "isAdActive";

    /* renamed from: g */
    static final String f1109g = "activeAdId";

    /* renamed from: h */
    static final String f1110h = "active_creative_ad_id";

    /* renamed from: i */
    static final String f1111i = "listOfCachedAds";

    /* renamed from: j */
    static final String f1112j = "listOfCreativeAdIds";

    /* renamed from: k */
    static final String f1113k = "adCacheSize";
    /* access modifiers changed from: private */

    /* renamed from: p */
    public JSONObject f1114p;

    /* renamed from: com.adcolony.sdk.q$a */
    private class C0721a extends C0751a {
        C0721a() {
            this.f1183b = new C0720q();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0721a mo8689a(JSONObject jSONObject) {
            ((C0720q) this.f1183b).f1114p = jSONObject;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0751a mo8690a(Date date) {
            C0746u.m902a(((C0720q) this.f1183b).f1114p, "timestamp", C0750x.f1176l.format(date));
            return super.mo8690a(date);
        }
    }

    C0720q() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0720q mo8687a(JSONObject jSONObject) {
        C0721a aVar = new C0721a();
        aVar.mo8689a(jSONObject);
        aVar.mo8739a(C0746u.m908b(jSONObject, "message"));
        try {
            aVar.mo8690a(new Date(Long.parseLong(C0746u.m908b(jSONObject, "timestamp"))));
        } catch (NumberFormatException unused) {
        }
        aVar.mo8738a(f1103a);
        aVar.mo8737a(-1);
        return (C0720q) aVar.mo8740a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo8688a() {
        return this.f1114p;
    }
}
