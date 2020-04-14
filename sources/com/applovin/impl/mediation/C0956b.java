package com.applovin.impl.mediation;

import com.applovin.impl.mediation.C0906a.C0907a;
import com.applovin.impl.mediation.C0966c.C0968a;
import com.applovin.impl.mediation.p014b.C0960c;
import com.applovin.impl.sdk.C1192i;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.mediation.b */
public class C0956b implements C0907a, C0968a {

    /* renamed from: a */
    private final C0906a f1828a;

    /* renamed from: b */
    private final C0966c f1829b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final MaxAdListener f1830c;

    public C0956b(C1192i iVar, MaxAdListener maxAdListener) {
        this.f1830c = maxAdListener;
        this.f1828a = new C0906a(iVar);
        this.f1829b = new C0966c(iVar, this);
    }

    /* renamed from: a */
    public void mo9300a(final C0960c cVar) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
            public void run() {
                C0956b.this.f1830c.onAdHidden(cVar);
            }
        }, cVar.mo9457q());
    }

    /* renamed from: a */
    public void mo9421a(MaxAd maxAd) {
        this.f1829b.mo9504a();
        this.f1828a.mo9297a();
    }

    /* renamed from: b */
    public void mo9422b(C0960c cVar) {
        long o = cVar.mo9455o();
        if (o >= 0) {
            this.f1829b.mo9505a(cVar, o);
        }
        if (cVar.mo9456p()) {
            this.f1828a.mo9298a(cVar, this);
        }
    }

    /* renamed from: c */
    public void mo9423c(C0960c cVar) {
        this.f1830c.onAdHidden(cVar);
    }
}
