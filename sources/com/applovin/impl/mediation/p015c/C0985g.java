package com.applovin.impl.mediation.p015c;

import com.applovin.impl.mediation.p014b.C0960c;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p017a.C1075c;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1176z;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.g */
public class C0985g extends C1176z {

    /* renamed from: a */
    private final C0960c f1904a;

    public C0985g(C0960c cVar, C1192i iVar) {
        super("TaskReportMaxReward", iVar);
        this.f1904a = cVar;
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2690L;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9521a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to report reward for mediated ad: ");
        sb.append(this.f1904a);
        sb.append(" - error code: ");
        sb.append(i);
        mo10068a(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9522a(JSONObject jSONObject) {
        C1247h.m2979a(jSONObject, "ad_unit_id", this.f1904a.getAdUnitId(), this.f2745b);
        C1247h.m2979a(jSONObject, "placement", this.f1904a.mo9473J(), this.f2745b);
        String s = this.f1904a.mo9459s();
        if (!C1277l.m3042b(s)) {
            s = "NO_MCODE";
        }
        C1247h.m2979a(jSONObject, "mcode", s, this.f2745b);
        String r = this.f1904a.mo9458r();
        if (!C1277l.m3042b(r)) {
            r = "NO_BCODE";
        }
        C1247h.m2979a(jSONObject, "bcode", r, this.f2745b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo9523b() {
        return "2.0/mcr";
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9524b(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("Reported reward successfully for mediated ad: ");
        sb.append(this.f1904a);
        mo10068a(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C1075c mo9525c() {
        return this.f1904a.mo9463v();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9526d() {
        StringBuilder sb = new StringBuilder();
        sb.append("No reward result was found for mediated ad: ");
        sb.append(this.f1904a);
        mo10072d(sb.toString());
    }
}
