package com.applovin.impl.mediation;

import com.applovin.impl.mediation.p014b.C0960c;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.utils.C1241c;

/* renamed from: com.applovin.impl.mediation.c */
public class C0966c {

    /* renamed from: a */
    private final C1192i f1851a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1227o f1852b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C0968a f1853c;

    /* renamed from: d */
    private C1241c f1854d;

    /* renamed from: com.applovin.impl.mediation.c$a */
    public interface C0968a {
        /* renamed from: c */
        void mo9423c(C0960c cVar);
    }

    C0966c(C1192i iVar, C0968a aVar) {
        this.f1851a = iVar;
        this.f1852b = iVar.mo10249v();
        this.f1853c = aVar;
    }

    /* renamed from: a */
    public void mo9504a() {
        this.f1852b.mo10378b("AdHiddenCallbackTimeoutManager", "Cancelling timeout");
        C1241c cVar = this.f1854d;
        if (cVar != null) {
            cVar.mo10409a();
            this.f1854d = null;
        }
    }

    /* renamed from: a */
    public void mo9505a(final C0960c cVar, long j) {
        C1227o oVar = this.f1852b;
        StringBuilder sb = new StringBuilder();
        sb.append("Scheduling in ");
        sb.append(j);
        sb.append("ms...");
        oVar.mo10378b("AdHiddenCallbackTimeoutManager", sb.toString());
        this.f1854d = C1241c.m2918a(j, this.f1851a, new Runnable() {
            public void run() {
                C0966c.this.f1852b.mo10378b("AdHiddenCallbackTimeoutManager", "Timing out...");
                C0966c.this.f1853c.mo9423c(cVar);
            }
        });
    }
}
