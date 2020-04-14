package com.tapjoy.internal;

import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* renamed from: com.tapjoy.internal.ca */
public abstract class C1817ca {

    /* renamed from: a */
    public static ExecutorService f3777a;

    /* renamed from: b */
    public static C2918cd f3778b;

    /* renamed from: c */
    private Future f3779c;

    /* renamed from: a */
    public abstract Object mo18080a(URI uri, InputStream inputStream);

    /* renamed from: b */
    public abstract String mo18083b();

    /* renamed from: c */
    public abstract String mo18084c();

    /* renamed from: d */
    public String mo18085d() {
        return null;
    }

    /* renamed from: a */
    public Map mo18081a() {
        return Collections.emptyMap();
    }

    /* renamed from: e */
    public Map mo18086e() {
        return new LinkedHashMap();
    }

    /* renamed from: f */
    public Object mo18087f() {
        return f3778b.mo29908a(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0022 A[SYNTHETIC, Splitter:B:14:0x0022] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo18082a(@javax.annotation.Nullable com.tapjoy.internal.C2920cf r3, java.util.concurrent.ExecutorService r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.concurrent.Future r0 = r2.f3779c     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0010
            java.util.concurrent.Future r0 = r2.f3779c     // Catch:{ all -> 0x0028 }
            boolean r0 = r0.isDone()     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r0 = 0
            goto L_0x0011
        L_0x0010:
            r0 = 1
        L_0x0011:
            java.lang.String r1 = "Call has not completed"
            if (r0 == 0) goto L_0x0022
            com.tapjoy.internal.cc r0 = new com.tapjoy.internal.cc     // Catch:{ all -> 0x0028 }
            r0.<init>(r2, r3)     // Catch:{ all -> 0x0028 }
            java.util.concurrent.Future r3 = r4.submit(r0)     // Catch:{ all -> 0x0028 }
            r2.f3779c = r3     // Catch:{ all -> 0x0028 }
            monitor-exit(r2)
            return
        L_0x0022:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0028 }
            r3.<init>(r1)     // Catch:{ all -> 0x0028 }
            throw r3     // Catch:{ all -> 0x0028 }
        L_0x0028:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C1817ca.mo18082a(com.tapjoy.internal.cf, java.util.concurrent.ExecutorService):void");
    }
}
