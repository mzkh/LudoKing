package com.applovin.impl.sdk.p021d;

import com.applovin.impl.p005a.C0775c;
import com.applovin.impl.p005a.C0776d;
import com.applovin.impl.p005a.C0782i;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p018ad.C1079b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1283q;
import com.applovin.impl.sdk.utils.C1284r;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.t */
abstract class C1166t extends C1122a {

    /* renamed from: a */
    private final AppLovinAdLoadListener f2858a;

    /* renamed from: c */
    private final C1167a f2859c;

    /* renamed from: com.applovin.impl.sdk.d.t$a */
    private static final class C1167a extends C0775c {
        C1167a(JSONObject jSONObject, JSONObject jSONObject2, C1079b bVar, C1192i iVar) {
            super(jSONObject, jSONObject2, bVar, iVar);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo10146a(C1283q qVar) {
            if (qVar != null) {
                this.f1256a.add(qVar);
                return;
            }
            throw new IllegalArgumentException("No aggregated vast response specified");
        }
    }

    /* renamed from: com.applovin.impl.sdk.d.t$b */
    private static final class C1168b extends C1166t {

        /* renamed from: a */
        private final JSONObject f2860a;

        C1168b(C0775c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1192i iVar) {
            super(cVar, appLovinAdLoadListener, iVar);
            if (appLovinAdLoadListener != null) {
                this.f2860a = cVar.mo8922c();
                return;
            }
            throw new IllegalArgumentException("No callback specified.");
        }

        /* renamed from: a */
        public C1115i mo9338a() {
            return C1115i.f2710s;
        }

        public void run() {
            C0776d dVar;
            mo10068a("Processing SDK JSON response...");
            String b = C1247h.m2985b(this.f2860a, "xml", (String) null, this.f2745b);
            if (!C1277l.m3042b(b)) {
                mo10072d("No VAST response received.");
                dVar = C0776d.NO_WRAPPER_RESPONSE;
            } else if (b.length() < ((Integer) this.f2745b.mo10202a(C1096c.f2498eD)).intValue()) {
                try {
                    mo10145a(C1284r.m3130a(b, this.f2745b));
                    return;
                } catch (Throwable th) {
                    mo10069a("Unable to parse VAST response", th);
                    mo10144a(C0776d.XML_PARSING);
                    this.f2745b.mo10187M().mo10047a(mo9338a());
                    return;
                }
            } else {
                mo10072d("VAST response is over max length");
                dVar = C0776d.XML_PARSING;
            }
            mo10144a(dVar);
        }
    }

    /* renamed from: com.applovin.impl.sdk.d.t$c */
    private static final class C1169c extends C1166t {

        /* renamed from: a */
        private final C1283q f2861a;

        C1169c(C1283q qVar, C0775c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1192i iVar) {
            super(cVar, appLovinAdLoadListener, iVar);
            if (qVar == null) {
                throw new IllegalArgumentException("No response specified.");
            } else if (cVar == null) {
                throw new IllegalArgumentException("No context specified.");
            } else if (appLovinAdLoadListener != null) {
                this.f2861a = qVar;
            } else {
                throw new IllegalArgumentException("No callback specified.");
            }
        }

        /* renamed from: a */
        public C1115i mo9338a() {
            return C1115i.f2711t;
        }

        public void run() {
            mo10068a("Processing VAST Wrapper response...");
            mo10145a(this.f2861a);
        }
    }

    C1166t(C0775c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1192i iVar) {
        super("TaskProcessVastResponse", iVar);
        if (cVar != null) {
            this.f2858a = appLovinAdLoadListener;
            this.f2859c = (C1167a) cVar;
            return;
        }
        throw new IllegalArgumentException("No context specified.");
    }

    /* renamed from: a */
    public static C1166t m2480a(C1283q qVar, C0775c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1192i iVar) {
        return new C1169c(qVar, cVar, appLovinAdLoadListener, iVar);
    }

    /* renamed from: a */
    public static C1166t m2481a(JSONObject jSONObject, JSONObject jSONObject2, C1079b bVar, AppLovinAdLoadListener appLovinAdLoadListener, C1192i iVar) {
        return new C1168b(new C1167a(jSONObject, jSONObject2, bVar, iVar), appLovinAdLoadListener, iVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo10144a(C0776d dVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to process VAST response due to VAST error code ");
        sb.append(dVar);
        mo10072d(sb.toString());
        C0782i.m1080a((C0775c) this.f2859c, this.f2858a, dVar, -6, this.f2745b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo10145a(C1283q qVar) {
        C0776d dVar;
        C1122a aVar;
        int a = this.f2859c.mo8920a();
        StringBuilder sb = new StringBuilder();
        sb.append("Finished parsing XML at depth ");
        sb.append(a);
        mo10068a(sb.toString());
        this.f2859c.mo10146a(qVar);
        if (C0782i.m1086a(qVar)) {
            int intValue = ((Integer) this.f2745b.mo10202a(C1096c.f2499eE)).intValue();
            if (a < intValue) {
                mo10068a("VAST response is wrapper. Resolving...");
                aVar = new C1123aa(this.f2859c, this.f2858a, this.f2745b);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Reached beyond max wrapper depth of ");
                sb2.append(intValue);
                mo10072d(sb2.toString());
                dVar = C0776d.WRAPPER_LIMIT_REACHED;
                mo10144a(dVar);
                return;
            }
        } else if (C0782i.m1089b(qVar)) {
            mo10068a("VAST response is inline. Rendering ad...");
            aVar = new C1172w(this.f2859c, this.f2858a, this.f2745b);
        } else {
            mo10072d("VAST response is an error");
            dVar = C0776d.NO_WRAPPER_RESPONSE;
            mo10144a(dVar);
            return;
        }
        this.f2745b.mo10185K().mo10130a(aVar);
    }
}
