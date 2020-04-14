package com.applovin.impl.mediation.p015c;

import com.applovin.impl.mediation.p014b.C0960c;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p017a.C1075c;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1129ae;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.h */
public class C0986h extends C1129ae {

    /* renamed from: a */
    private final C0960c f1905a;

    public C0986h(C0960c cVar, C1192i iVar) {
        super("TaskValidateMaxReward", iVar);
        this.f1905a = cVar;
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2689K;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9527a(int i) {
        if (!mo9529c()) {
            this.f1905a.mo9449a(C1075c.m1948a((i < 400 || i >= 500) ? "network_timeout" : "rejected"));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9528a(C1075c cVar) {
        if (!mo9529c()) {
            this.f1905a.mo9449a(cVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9522a(JSONObject jSONObject) {
        C1247h.m2979a(jSONObject, "ad_unit_id", this.f1905a.getAdUnitId(), this.f2745b);
        C1247h.m2979a(jSONObject, "placement", this.f1905a.mo9473J(), this.f2745b);
        String s = this.f1905a.mo9459s();
        if (!C1277l.m3042b(s)) {
            s = "NO_MCODE";
        }
        C1247h.m2979a(jSONObject, "mcode", s, this.f2745b);
        String r = this.f1905a.mo9458r();
        if (!C1277l.m3042b(r)) {
            r = "NO_BCODE";
        }
        C1247h.m2979a(jSONObject, "bcode", r, this.f2745b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo9523b() {
        return "2.0/mvr";
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo9529c() {
        return this.f1905a.mo9460t();
    }
}
