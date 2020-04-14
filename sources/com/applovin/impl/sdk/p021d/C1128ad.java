package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p017a.C1075c;
import com.applovin.impl.sdk.p018ad.C1084f;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.ad */
public class C1128ad extends C1129ae {

    /* renamed from: a */
    private final C1084f f2755a;

    /* renamed from: c */
    private final AppLovinAdRewardListener f2756c;

    public C1128ad(C1084f fVar, AppLovinAdRewardListener appLovinAdRewardListener, C1192i iVar) {
        super("TaskValidateAppLovinReward", iVar);
        this.f2755a = fVar;
        this.f2756c = appLovinAdRewardListener;
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2717z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9527a(int i) {
        String str;
        if (!mo9529c()) {
            if (i < 400 || i >= 500) {
                this.f2756c.validationRequestFailed(this.f2755a, i);
                str = "network_timeout";
            } else {
                this.f2756c.userRewardRejected(this.f2755a, Collections.emptyMap());
                str = "rejected";
            }
            this.f2755a.mo9891a(C1075c.m1948a(str));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9528a(C1075c cVar) {
        if (!mo9529c()) {
            this.f2755a.mo9891a(cVar);
            String b = cVar.mo9771b();
            Map a = cVar.mo9770a();
            if (b.equals("accepted")) {
                this.f2756c.userRewardVerified(this.f2755a, a);
            } else if (b.equals("quota_exceeded")) {
                this.f2756c.userOverQuota(this.f2755a, a);
            } else if (b.equals("rejected")) {
                this.f2756c.userRewardRejected(this.f2755a, a);
            } else {
                this.f2756c.validationRequestFailed(this.f2755a, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9522a(JSONObject jSONObject) {
        C1247h.m2979a(jSONObject, AdColonyAdapterUtils.KEY_ZONE_ID, this.f2755a.getAdZone().mo9846a(), this.f2745b);
        String clCode = this.f2755a.getClCode();
        if (!C1277l.m3042b(clCode)) {
            clCode = "NO_CLCODE";
        }
        C1247h.m2979a(jSONObject, "clcode", clCode, this.f2745b);
    }

    /* renamed from: b */
    public String mo9523b() {
        return "2.0/vr";
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo9529c() {
        return this.f2755a.mo9893aA();
    }
}
