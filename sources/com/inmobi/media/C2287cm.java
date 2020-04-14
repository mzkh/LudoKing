package com.inmobi.media;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.inmobi.media.cm */
/* compiled from: VastNetworkClient */
final class C2287cm {

    /* renamed from: d */
    public static final Executor f4810d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final String f4811e = "cm";

    /* renamed from: g */
    private static final int f4812g = Runtime.getRuntime().availableProcessors();

    /* renamed from: h */
    private static final int f4813h = Math.max(2, Math.min(f4812g - 1, 4));

    /* renamed from: i */
    private static final int f4814i = ((f4812g * 2) + 1);

    /* renamed from: j */
    private static final ThreadFactory f4815j = new ThreadFactory() {

        /* renamed from: a */
        private final AtomicInteger f4821a = new AtomicInteger(1);

        public final Thread newThread(@NonNull Runnable runnable) {
            StringBuilder sb = new StringBuilder("VastNetworkTask #");
            sb.append(this.f4821a.getAndIncrement());
            return new Thread(runnable, sb.toString());
        }
    };

    /* renamed from: k */
    private static final BlockingQueue<Runnable> f4816k = new LinkedBlockingQueue(128);
    /* access modifiers changed from: 0000 */

    /* renamed from: a */
    public C2486fr f4817a;

    /* renamed from: b */
    WeakReference<C2286cl> f4818b;

    /* renamed from: c */
    long f4819c = 0;

    /* renamed from: f */
    private final CountDownLatch f4820f;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f4813h, f4814i, 30, TimeUnit.SECONDS, f4816k, f4815j);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f4810d = threadPoolExecutor;
    }

    public C2287cm(C2286cl clVar, int i, CountDownLatch countDownLatch) {
        this.f4817a = new C2486fr("GET", clVar.f4805a);
        C2486fr frVar = this.f4817a;
        frVar.f5444p = false;
        frVar.f5450v = false;
        frVar.f5441m = i;
        this.f4818b = new WeakReference<>(clVar);
        this.f4820f = countDownLatch;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28127a() {
        CountDownLatch countDownLatch = this.f4820f;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* renamed from: a */
    public final void mo28128a(C2487fs fsVar) {
        try {
            C2566hi.m5571a().mo28564a(this.f4817a.mo28416i());
            C2566hi.m5571a().mo28565b(fsVar.mo28421d());
        } catch (Exception unused) {
        } finally {
            mo28127a();
        }
    }
}
