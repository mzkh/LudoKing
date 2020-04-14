package com.tapjoy.internal;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tapjoy.internal.gh */
public final class C3105gh extends C1826gg {

    /* renamed from: b */
    private final ThreadPoolExecutor f7330b;

    /* renamed from: com.tapjoy.internal.gh$a */
    class C3106a implements Runnable {

        /* renamed from: b */
        private int f7332b;

        /* renamed from: c */
        private long f7333c;

        /* renamed from: d */
        private String f7334d;

        /* renamed from: e */
        private String f7335e;

        /* renamed from: f */
        private Map f7336f;

        C3106a(int i, long j, String str, String str2, Map map) {
            this.f7332b = i;
            this.f7333c = j;
            this.f7334d = str;
            this.f7335e = str2;
            this.f7336f = map;
        }

        public final void run() {
            try {
                int i = this.f7332b;
                if (i == 1) {
                    C3105gh.super.mo18093a(this.f7333c);
                } else if (i != 2) {
                    if (i == 3) {
                        C3105gh.super.mo18094a(this.f7333c, this.f7334d, this.f7335e, this.f7336f);
                    }
                } else {
                    C3105gh.super.mo18092a();
                }
            } catch (Throwable unused) {
                C3105gh.super.mo18092a();
            }
        }
    }

    public C3105gh(File file, C1830gy gyVar) {
        super(file, gyVar);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f7330b = threadPoolExecutor;
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        try {
            this.f7330b.shutdown();
            this.f7330b.awaitTermination(1, TimeUnit.SECONDS);
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18093a(long j) {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.f7330b;
            C3106a aVar = new C3106a(1, j, null, null, null);
            threadPoolExecutor.execute(aVar);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18092a() {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.f7330b;
            C3106a aVar = new C3106a(2, 0, null, null, null);
            threadPoolExecutor.execute(aVar);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18094a(long j, String str, String str2, Map map) {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.f7330b;
            C3106a aVar = new C3106a(3, j, str, str2, map != null ? new HashMap(map) : null);
            threadPoolExecutor.execute(aVar);
        } catch (Throwable unused) {
        }
    }
}
