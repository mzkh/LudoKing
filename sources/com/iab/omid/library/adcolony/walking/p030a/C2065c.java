package com.iab.omid.library.adcolony.walking.p030a;

import com.iab.omid.library.adcolony.walking.p030a.C2062b.C2063a;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.iab.omid.library.adcolony.walking.a.c */
public class C2065c implements C2063a {

    /* renamed from: a */
    private final BlockingQueue<Runnable> f4089a = new LinkedBlockingQueue();

    /* renamed from: b */
    private final ThreadPoolExecutor f4090b;

    /* renamed from: c */
    private final ArrayDeque<C2062b> f4091c = new ArrayDeque<>();

    /* renamed from: d */
    private C2062b f4092d = null;

    public C2065c() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.f4089a);
        this.f4090b = threadPoolExecutor;
    }

    /* renamed from: a */
    private void m3915a() {
        this.f4092d = (C2062b) this.f4091c.poll();
        C2062b bVar = this.f4092d;
        if (bVar != null) {
            bVar.mo27474a(this.f4090b);
        }
    }

    /* renamed from: a */
    public void mo27476a(C2062b bVar) {
        this.f4092d = null;
        m3915a();
    }

    /* renamed from: b */
    public void mo27479b(C2062b bVar) {
        bVar.mo27472a((C2063a) this);
        this.f4091c.add(bVar);
        if (this.f4092d == null) {
            m3915a();
        }
    }
}
