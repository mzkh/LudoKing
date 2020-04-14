package com.iab.omid.library.inmobi.walking.p036a;

import com.iab.omid.library.inmobi.walking.p036a.C2110b.C2111a;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.iab.omid.library.inmobi.walking.a.c */
public class C2113c implements C2111a {

    /* renamed from: a */
    private final BlockingQueue<Runnable> f4191a = new LinkedBlockingQueue();

    /* renamed from: b */
    private final ThreadPoolExecutor f4192b;

    /* renamed from: c */
    private final ArrayDeque<C2110b> f4193c = new ArrayDeque<>();

    /* renamed from: d */
    private C2110b f4194d = null;

    public C2113c() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.f4191a);
        this.f4192b = threadPoolExecutor;
    }

    /* renamed from: a */
    private void m4125a() {
        this.f4194d = (C2110b) this.f4193c.poll();
        C2110b bVar = this.f4194d;
        if (bVar != null) {
            bVar.mo27640a(this.f4192b);
        }
    }

    /* renamed from: a */
    public void mo27642a(C2110b bVar) {
        this.f4194d = null;
        m4125a();
    }

    /* renamed from: b */
    public void mo27645b(C2110b bVar) {
        bVar.mo27638a((C2111a) this);
        this.f4193c.add(bVar);
        if (this.f4194d == null) {
            m4125a();
        }
    }
}
