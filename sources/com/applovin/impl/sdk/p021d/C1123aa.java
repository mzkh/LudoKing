package com.applovin.impl.sdk.p021d;

import com.applovin.impl.p005a.C0775c;
import com.applovin.impl.p005a.C0776d;
import com.applovin.impl.p005a.C0782i;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.network.C1215b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.impl.sdk.utils.C1283q;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.sdk.d.aa */
class C1123aa extends C1122a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0775c f2749a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AppLovinAdLoadListener f2750c;

    C1123aa(C0775c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1192i iVar) {
        super("TaskResolveVastWrapper", iVar);
        this.f2750c = appLovinAdLoadListener;
        this.f2749a = cVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2299a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to resolve VAST wrapper due to error code ");
        sb.append(i);
        mo10072d(sb.toString());
        if (i == -103) {
            C1281o.m3082a(this.f2750c, this.f2749a.mo8926g(), i, this.f2745b);
        } else {
            C0782i.m1080a(this.f2749a, this.f2750c, i == -102 ? C0776d.TIMED_OUT : C0776d.GENERAL_WRAPPER_ERROR, i, this.f2745b);
        }
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2716y;
    }

    public void run() {
        String a = C0782i.m1076a(this.f2749a);
        if (C1277l.m3042b(a)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Resolving VAST ad with depth ");
            sb.append(this.f2749a.mo8920a());
            sb.append(" at ");
            sb.append(a);
            mo10068a(sb.toString());
            try {
                this.f2745b.mo10185K().mo10130a((C1122a) new C1173x<C1283q>(C1215b.m2733a(this.f2745b).mo10324a(a).mo10330b("GET").mo10323a(C1283q.f3224a).mo10322a(((Integer) this.f2745b.mo10202a(C1096c.f2505eK)).intValue()).mo10329b(((Integer) this.f2745b.mo10202a(C1096c.f2506eL)).intValue()).mo10327a(false).mo10328a(), this.f2745b) {
                    /* renamed from: a */
                    public void mo9301a(int i) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unable to resolve VAST wrapper. Server returned ");
                        sb.append(i);
                        mo10072d(sb.toString());
                        C1123aa.this.m2299a(i);
                    }

                    /* renamed from: a */
                    public void mo9302a(C1283q qVar, int i) {
                        this.f2745b.mo10185K().mo10130a((C1122a) C1166t.m2480a(qVar, C1123aa.this.f2749a, C1123aa.this.f2750c, C1123aa.this.f2745b));
                    }
                });
            } catch (Throwable th) {
                mo10069a("Unable to resolve VAST wrapper", th);
                m2299a(-1);
                this.f2745b.mo10187M().mo10047a(mo9338a());
            }
        } else {
            mo10072d("Resolving VAST failed. Could not find resolution URL");
            m2299a(-1);
        }
    }
}
