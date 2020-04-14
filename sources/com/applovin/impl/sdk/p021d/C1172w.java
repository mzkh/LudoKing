package com.applovin.impl.sdk.p021d;

import com.applovin.impl.p005a.C0769a;
import com.applovin.impl.p005a.C0774b;
import com.applovin.impl.p005a.C0775c;
import com.applovin.impl.p005a.C0776d;
import com.applovin.impl.p005a.C0779f;
import com.applovin.impl.p005a.C0780g;
import com.applovin.impl.p005a.C0782i;
import com.applovin.impl.p005a.C0783j;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.utils.C1283q;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.d.w */
class C1172w extends C1122a {

    /* renamed from: a */
    private C0775c f2868a;

    /* renamed from: c */
    private final AppLovinAdLoadListener f2869c;

    C1172w(C0775c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1192i iVar) {
        super("TaskRenderVastAd", iVar);
        this.f2869c = appLovinAdLoadListener;
        this.f2868a = cVar;
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2714w;
    }

    public void run() {
        mo10068a("Rendering VAST ad...");
        int size = this.f2868a.mo8921b().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String str = "";
        C0779f fVar = null;
        C0783j jVar = null;
        C0774b bVar = null;
        String str2 = str;
        for (C1283q qVar : this.f2868a.mo8921b()) {
            C1283q c = qVar.mo10451c(C0782i.m1086a(qVar) ? "Wrapper" : "InLine");
            if (c != null) {
                C1283q c2 = c.mo10451c("AdSystem");
                if (c2 != null) {
                    fVar = C0779f.m1066a(c2, fVar, this.f2745b);
                }
                str = C0782i.m1077a(c, "AdTitle", str);
                str2 = C0782i.m1077a(c, "Description", str2);
                C0782i.m1082a(c.mo10448a("Impression"), (Set<C0780g>) hashSet, this.f2868a, this.f2745b);
                C0782i.m1082a(c.mo10448a("Error"), (Set<C0780g>) hashSet2, this.f2868a, this.f2745b);
                C1283q b = c.mo10449b("Creatives");
                if (b != null) {
                    for (C1283q qVar2 : b.mo10453d()) {
                        C1283q b2 = qVar2.mo10449b("Linear");
                        if (b2 != null) {
                            jVar = C0783j.m1092a(b2, jVar, this.f2868a, this.f2745b);
                        } else {
                            C1283q c3 = qVar2.mo10451c("CompanionAds");
                            if (c3 != null) {
                                C1283q c4 = c3.mo10451c("Companion");
                                if (c4 != null) {
                                    bVar = C0774b.m1044a(c4, bVar, this.f2868a, this.f2745b);
                                }
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Received and will skip rendering for an unidentified creative: ");
                                sb.append(qVar2);
                                mo10072d(sb.toString());
                            }
                        }
                    }
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Did not find wrapper or inline response for node: ");
                sb2.append(qVar);
                mo10072d(sb2.toString());
            }
        }
        C0769a a = C0769a.m994aH().mo8905a(this.f2745b).mo8908a(this.f2868a.mo8922c()).mo8912b(this.f2868a.mo8923d()).mo8904a(this.f2868a.mo8924e()).mo8900a(this.f2868a.mo8925f()).mo8906a(str).mo8910b(str2).mo8902a(fVar).mo8903a(jVar).mo8901a(bVar).mo8907a((Set<C0780g>) hashSet).mo8911b((Set<C0780g>) hashSet2).mo8909a();
        C0776d a2 = C0782i.m1073a(a);
        if (a2 == null) {
            C1140h hVar = new C1140h(a, this.f2745b, this.f2869c);
            C1161a aVar = C1161a.CACHING_OTHER;
            if (((Boolean) this.f2745b.mo10202a(C1096c.f2375bk)).booleanValue()) {
                if (a.getType() == AppLovinAdType.REGULAR) {
                    aVar = C1161a.CACHING_INTERSTITIAL;
                } else if (a.getType() == AppLovinAdType.INCENTIVIZED) {
                    aVar = C1161a.CACHING_INCENTIVIZED;
                }
            }
            this.f2745b.mo10185K().mo10131a((C1122a) hVar, aVar);
            return;
        }
        C0782i.m1080a(this.f2868a, this.f2869c, a2, -6, this.f2745b);
    }
}
