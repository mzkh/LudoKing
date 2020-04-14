package com.applovin.impl.mediation.p006a.p009c.p010a;

import android.content.Context;
import com.applovin.impl.mediation.p006a.p007a.C0911b;
import com.applovin.impl.mediation.p006a.p007a.C0913c;
import com.applovin.impl.mediation.p006a.p007a.C0913c.C0914a;
import com.applovin.impl.mediation.p006a.p007a.C0917f;
import com.applovin.impl.mediation.p006a.p009c.C0920a;
import com.applovin.impl.mediation.p006a.p009c.p010a.p011a.C0925a;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.mediation.a.c.a.b */
public class C0926b extends C0920a {

    /* renamed from: c */
    private final AtomicBoolean f1743c = new AtomicBoolean();

    /* renamed from: d */
    private final C0911b f1744d = new C0917f("INCOMPLETE INTEGRATIONS");

    /* renamed from: e */
    private final C0911b f1745e = new C0917f("COMPLETED INTEGRATIONS");

    /* renamed from: f */
    private final C0911b f1746f = new C0917f("MISSING INTEGRATIONS");

    /* renamed from: g */
    private final C0911b f1747g = new C0917f("");

    /* renamed from: h */
    private C0928a f1748h;

    /* renamed from: com.applovin.impl.mediation.a.c.a.b$a */
    public interface C0928a {
        /* renamed from: a */
        void mo9358a(C0913c cVar);
    }

    public C0926b(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9343a(C0911b bVar) {
        if (this.f1748h != null && (bVar instanceof C0925a)) {
            this.f1748h.mo9358a(((C0925a) bVar).mo9359i());
        }
    }

    /* renamed from: a */
    public void mo9361a(C0928a aVar) {
        this.f1748h = aVar;
    }

    /* renamed from: a */
    public void mo9362a(List<C0913c> list) {
        if (list != null && this.f1743c.compareAndSet(false, true)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (C0913c cVar : list) {
                C0925a aVar = new C0925a(cVar, this.f1728a);
                if (cVar.mo9321a() == C0914a.INCOMPLETE_INTEGRATION || cVar.mo9321a() == C0914a.INVALID_INTEGRATION) {
                    arrayList.add(aVar);
                } else if (cVar.mo9321a() == C0914a.COMPLETE) {
                    arrayList2.add(aVar);
                } else if (cVar.mo9321a() == C0914a.MISSING) {
                    arrayList3.add(aVar);
                }
            }
            if (arrayList.size() > 0) {
                this.f1729b.add(this.f1744d);
                this.f1729b.addAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.f1729b.add(this.f1745e);
                this.f1729b.addAll(arrayList2);
            }
            if (arrayList3.size() > 0) {
                this.f1729b.add(this.f1746f);
                this.f1729b.addAll(arrayList3);
            }
            this.f1729b.add(this.f1747g);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                C0926b.this.notifyDataSetChanged();
            }
        });
    }

    /* renamed from: a */
    public boolean mo9363a() {
        return this.f1743c.get();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediationDebuggerListAdapter{networksInitialized=");
        sb.append(this.f1743c.get());
        sb.append(", listItems=");
        sb.append(this.f1729b);
        sb.append("}");
        return sb.toString();
    }
}
