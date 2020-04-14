package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p017a.C1075c;
import com.applovin.impl.sdk.p018ad.C1084f;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.y */
public class C1175y extends C1176z {

    /* renamed from: a */
    private final C1084f f2878a;

    public C1175y(C1084f fVar, C1192i iVar) {
        super("TaskReportAppLovinReward", iVar);
        this.f2878a = fVar;
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2715x;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9521a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to report reward for ad: ");
        sb.append(this.f2878a);
        sb.append(" - error code: ");
        sb.append(i);
        mo10072d(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9522a(JSONObject jSONObject) {
        C1247h.m2979a(jSONObject, AdColonyAdapterUtils.KEY_ZONE_ID, this.f2878a.getAdZone().mo9846a(), this.f2745b);
        C1247h.m2978a(jSONObject, "fire_percent", this.f2878a.mo9903ah(), this.f2745b);
        String clCode = this.f2878a.getClCode();
        if (!C1277l.m3042b(clCode)) {
            clCode = "NO_CLCODE";
        }
        C1247h.m2979a(jSONObject, "clcode", clCode, this.f2745b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo9523b() {
        return "2.0/cr";
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9524b(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("Reported reward successfully for ad: ");
        sb.append(this.f2878a);
        mo10068a(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C1075c mo9525c() {
        return this.f2878a.mo9895aC();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9526d() {
        StringBuilder sb = new StringBuilder();
        sb.append("No reward result was found for ad: ");
        sb.append(this.f2878a);
        mo10072d(sb.toString());
    }
}
