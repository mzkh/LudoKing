package com.applovin.impl.mediation;

import com.applovin.impl.mediation.p014b.C0958a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.k */
public class C1041k {

    /* renamed from: a */
    private final List<C1042a> f2026a = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.applovin.impl.mediation.k$a */
    public interface C1042a {
        /* renamed from: a */
        void mo9631a(C0958a aVar);
    }

    /* renamed from: a */
    public void mo9628a(C0958a aVar) {
        Iterator it = new ArrayList(this.f2026a).iterator();
        while (it.hasNext()) {
            ((C1042a) it.next()).mo9631a(aVar);
        }
    }

    /* renamed from: a */
    public void mo9629a(C1042a aVar) {
        this.f2026a.add(aVar);
    }

    /* renamed from: b */
    public void mo9630b(C1042a aVar) {
        this.f2026a.remove(aVar);
    }
}
