package com.tapjoy.internal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tapjoy.internal.hn */
public final class C3147hn {

    /* renamed from: a */
    public static final ScheduledExecutorService f7460a = Executors.newScheduledThreadPool(1);

    /* renamed from: b */
    public static final CountDownLatch f7461b = new CountDownLatch(1);

    /* renamed from: c */
    public static final CountDownLatch f7462c = new CountDownLatch(1);

    /* renamed from: d */
    private static final Runnable f7463d = new Runnable() {
        public final void run() {
            if (C3256v.m7570c()) {
                C3147hn.f7461b.countDown();
            } else if (C3256v.m7568a()) {
                C3147hn.f7461b.countDown();
            } else {
                C3147hn.f7460a.schedule(this, 300, TimeUnit.SECONDS);
            }
        }
    };

    /* renamed from: e */
    private static String f7464e;

    /* renamed from: f */
    private static boolean f7465f;

    /* renamed from: a */
    public static void m7278a() {
        f7460a.execute(f7463d);
    }

    /* renamed from: a */
    public static void m7279a(String str, boolean z) {
        f7464e = str;
        f7465f = z;
        f7462c.countDown();
    }

    /* renamed from: b */
    public static String m7280b() {
        return f7464e;
    }

    /* renamed from: c */
    public static boolean m7281c() {
        return f7465f;
    }
}
