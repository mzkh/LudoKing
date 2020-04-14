package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1196j.C1199a;
import com.applovin.impl.sdk.p020c.C1115i;

/* renamed from: com.applovin.impl.sdk.d.i */
public class C1142i extends C1122a {

    /* renamed from: a */
    private final C1143a f2778a;

    /* renamed from: com.applovin.impl.sdk.d.i$a */
    public interface C1143a {
        /* renamed from: a */
        void mo9706a(C1199a aVar);
    }

    public C1142i(C1192i iVar, C1143a aVar) {
        super("TaskCollectAdvertisingId", iVar);
        this.f2778a = aVar;
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2693b;
    }

    public void run() {
        this.f2778a.mo9706a(this.f2745b.mo10189O().mo10262d());
    }
}
