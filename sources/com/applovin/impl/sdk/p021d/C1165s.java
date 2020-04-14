package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p018ad.C1079b;
import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.s */
public class C1165s extends C1122a implements AppLovinAdLoadListener {

    /* renamed from: a */
    private final JSONObject f2854a;

    /* renamed from: c */
    private final C1082d f2855c;

    /* renamed from: d */
    private final C1079b f2856d;

    /* renamed from: e */
    private final AppLovinAdLoadListener f2857e;

    public C1165s(JSONObject jSONObject, C1082d dVar, C1079b bVar, AppLovinAdLoadListener appLovinAdLoadListener, C1192i iVar) {
        super("TaskProcessAdResponse", iVar);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (dVar != null) {
            this.f2854a = jSONObject;
            this.f2855c = dVar;
            this.f2856d = bVar;
            this.f2857e = appLovinAdLoadListener;
        } else {
            throw new IllegalArgumentException("No zone specified");
        }
    }

    /* renamed from: a */
    private void m2476a(int i) {
        C1281o.m3082a(this.f2857e, this.f2855c, i, this.f2745b);
    }

    /* renamed from: a */
    private void m2477a(AppLovinAd appLovinAd) {
        try {
            if (this.f2857e != null) {
                this.f2857e.adReceived(appLovinAd);
            }
        } catch (Throwable th) {
            mo10069a("Unable process a ad received notification", th);
        }
    }

    /* renamed from: a */
    private void m2478a(JSONObject jSONObject) {
        String b = C1247h.m2985b(jSONObject, "type", "undefined", this.f2745b);
        if ("applovin".equalsIgnoreCase(b)) {
            mo10068a("Starting task for AppLovin ad...");
            C1159r K = this.f2745b.mo10185K();
            C1170u uVar = new C1170u(jSONObject, this.f2854a, this.f2856d, this, this.f2745b);
            K.mo10130a((C1122a) uVar);
        } else if ("vast".equalsIgnoreCase(b)) {
            mo10068a("Starting task for VAST ad...");
            this.f2745b.mo10185K().mo10130a((C1122a) C1166t.m2481a(jSONObject, this.f2854a, this.f2856d, this, this.f2745b));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to process ad of unknown type: ");
            sb.append(b);
            mo10071c(sb.toString());
            failedToReceiveAd(-800);
        }
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2709r;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        m2477a(appLovinAd);
    }

    public void failedToReceiveAd(int i) {
        m2476a(i);
    }

    public void run() {
        JSONArray b = C1247h.m2988b(this.f2854a, "ads", new JSONArray(), this.f2745b);
        if (b.length() > 0) {
            mo10068a("Processing ad...");
            m2478a(C1247h.m2977a(b, 0, new JSONObject(), this.f2745b));
            return;
        }
        mo10071c("No ads were returned from the server");
        C1281o.m3086a(this.f2855c.mo9846a(), this.f2854a, this.f2745b);
        m2476a(204);
    }
}
