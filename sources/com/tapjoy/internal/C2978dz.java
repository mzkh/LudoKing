package com.tapjoy.internal;

import com.tapjoy.internal.C2975dy.C2976a;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tapjoy.internal.dz */
public final class C2978dz implements C2976a {

    /* renamed from: a */
    private final BlockingQueue f6869a = new LinkedBlockingQueue();

    /* renamed from: b */
    private final ThreadPoolExecutor f6870b;

    /* renamed from: c */
    private final ArrayDeque f6871c = new ArrayDeque();

    /* renamed from: d */
    private C2975dy f6872d = null;

    public C2978dz() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.f6869a);
        this.f6870b = threadPoolExecutor;
    }

    /* renamed from: a */
    public final void mo29970a() {
        this.f6872d = null;
        m6787b();
    }

    /* renamed from: a */
    public final void mo29973a(C2975dy dyVar) {
        dyVar.f6867d = this;
        this.f6871c.add(dyVar);
        if (this.f6872d == null) {
            m6787b();
        }
    }

    /* renamed from: b */
    private void m6787b() {
        this.f6872d = (C2975dy) this.f6871c.poll();
        C2975dy dyVar = this.f6872d;
        if (dyVar != null) {
            dyVar.executeOnExecutor(this.f6870b, new Object[0]);
        }
    }
}
