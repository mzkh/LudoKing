package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p020c.C1115i;

/* renamed from: com.applovin.impl.sdk.d.ac */
public class C1127ac extends C1122a {

    /* renamed from: a */
    private final Runnable f2754a;

    public C1127ac(C1192i iVar, Runnable runnable) {
        this(iVar, false, runnable);
    }

    public C1127ac(C1192i iVar, boolean z, Runnable runnable) {
        super("TaskRunnable", iVar, z);
        this.f2754a = runnable;
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2697f;
    }

    public void run() {
        this.f2754a.run();
    }
}
