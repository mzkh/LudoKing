package com.applovin.impl.sdk.utils;

import com.applovin.impl.sdk.C1192i;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.applovin.impl.sdk.utils.m */
public class C1278m {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1192i f3210a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Timer f3211b;

    /* renamed from: c */
    private long f3212c;

    /* renamed from: d */
    private long f3213d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Runnable f3214e;

    /* renamed from: f */
    private long f3215f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Object f3216g = new Object();

    private C1278m(C1192i iVar, Runnable runnable) {
        this.f3210a = iVar;
        this.f3214e = runnable;
    }

    /* renamed from: a */
    public static C1278m m3045a(long j, C1192i iVar, Runnable runnable) {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot create a scheduled timer. Invalid fire time passed in: ");
            sb.append(j);
            sb.append(".");
            throw new IllegalArgumentException(sb.toString());
        } else if (runnable != null) {
            C1278m mVar = new C1278m(iVar, runnable);
            mVar.f3212c = System.currentTimeMillis();
            mVar.f3213d = j;
            try {
                mVar.f3211b = new Timer();
                mVar.f3211b.schedule(mVar.m3050e(), j);
            } catch (OutOfMemoryError e) {
                iVar.mo10249v().mo10379b("Timer", "Failed to create timer due to OOM error", e);
            }
            return mVar;
        } else {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
        }
    }

    /* renamed from: e */
    private TimerTask m3050e() {
        return new TimerTask() {
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r5 = this;
                    r0 = 0
                    com.applovin.impl.sdk.utils.m r1 = com.applovin.impl.sdk.utils.C1278m.this     // Catch:{ Throwable -> 0x001d }
                    java.lang.Runnable r1 = r1.f3214e     // Catch:{ Throwable -> 0x001d }
                    r1.run()     // Catch:{ Throwable -> 0x001d }
                    com.applovin.impl.sdk.utils.m r1 = com.applovin.impl.sdk.utils.C1278m.this
                    java.lang.Object r1 = r1.f3216g
                    monitor-enter(r1)
                    com.applovin.impl.sdk.utils.m r2 = com.applovin.impl.sdk.utils.C1278m.this     // Catch:{ all -> 0x0018 }
                    r2.f3211b = r0     // Catch:{ all -> 0x0018 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                    goto L_0x0044
                L_0x0018:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                    throw r0
                L_0x001b:
                    r1 = move-exception
                    goto L_0x0048
                L_0x001d:
                    r1 = move-exception
                    com.applovin.impl.sdk.utils.m r2 = com.applovin.impl.sdk.utils.C1278m.this     // Catch:{ all -> 0x001b }
                    com.applovin.impl.sdk.i r2 = r2.f3210a     // Catch:{ all -> 0x001b }
                    if (r2 == 0) goto L_0x0037
                    com.applovin.impl.sdk.utils.m r2 = com.applovin.impl.sdk.utils.C1278m.this     // Catch:{ all -> 0x001b }
                    com.applovin.impl.sdk.i r2 = r2.f3210a     // Catch:{ all -> 0x001b }
                    com.applovin.impl.sdk.o r2 = r2.mo10249v()     // Catch:{ all -> 0x001b }
                    java.lang.String r3 = "Timer"
                    java.lang.String r4 = "Encountered error while executing timed task"
                    r2.mo10379b(r3, r4, r1)     // Catch:{ all -> 0x001b }
                L_0x0037:
                    com.applovin.impl.sdk.utils.m r1 = com.applovin.impl.sdk.utils.C1278m.this
                    java.lang.Object r1 = r1.f3216g
                    monitor-enter(r1)
                    com.applovin.impl.sdk.utils.m r2 = com.applovin.impl.sdk.utils.C1278m.this     // Catch:{ all -> 0x0045 }
                    r2.f3211b = r0     // Catch:{ all -> 0x0045 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0045 }
                L_0x0044:
                    return
                L_0x0045:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0045 }
                    throw r0
                L_0x0048:
                    com.applovin.impl.sdk.utils.m r2 = com.applovin.impl.sdk.utils.C1278m.this
                    java.lang.Object r2 = r2.f3216g
                    monitor-enter(r2)
                    com.applovin.impl.sdk.utils.m r3 = com.applovin.impl.sdk.utils.C1278m.this     // Catch:{ all -> 0x0056 }
                    r3.f3211b = r0     // Catch:{ all -> 0x0056 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0056 }
                    throw r1
                L_0x0056:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0056 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.C1278m.C12791.run():void");
            }
        };
    }

    /* renamed from: a */
    public long mo10438a() {
        if (this.f3211b == null) {
            return this.f3213d - this.f3215f;
        }
        return this.f3213d - (System.currentTimeMillis() - this.f3212c);
    }

    /* renamed from: b */
    public void mo10439b() {
        synchronized (this.f3216g) {
            if (this.f3211b != null) {
                try {
                    this.f3211b.cancel();
                    this.f3215f = System.currentTimeMillis() - this.f3212c;
                } catch (Throwable th) {
                    try {
                        if (this.f3210a != null) {
                            this.f3210a.mo10249v().mo10379b("Timer", "Encountered error while pausing timer", th);
                        }
                    } catch (Throwable th2) {
                        this.f3211b = null;
                        throw th2;
                    }
                }
                this.f3211b = null;
            }
        }
    }

    /* renamed from: c */
    public void mo10440c() {
        synchronized (this.f3216g) {
            if (this.f3215f > 0) {
                try {
                    this.f3213d -= this.f3215f;
                    if (this.f3213d < 0) {
                        this.f3213d = 0;
                    }
                    this.f3211b = new Timer();
                    this.f3211b.schedule(m3050e(), this.f3213d);
                    this.f3212c = System.currentTimeMillis();
                } catch (Throwable th) {
                    try {
                        if (this.f3210a != null) {
                            this.f3210a.mo10249v().mo10379b("Timer", "Encountered error while resuming timer", th);
                        }
                    } catch (Throwable th2) {
                        this.f3215f = 0;
                        throw th2;
                    }
                }
                this.f3215f = 0;
            }
        }
    }

    /* renamed from: d */
    public void mo10441d() {
        synchronized (this.f3216g) {
            if (this.f3211b != null) {
                try {
                    this.f3211b.cancel();
                    this.f3211b = null;
                } catch (Throwable th) {
                    try {
                        if (this.f3210a != null) {
                            this.f3210a.mo10249v().mo10379b("Timer", "Encountered error while cancelling timer", th);
                        }
                        this.f3211b = null;
                    } catch (Throwable th2) {
                        this.f3211b = null;
                        this.f3215f = 0;
                        throw th2;
                    }
                }
                this.f3215f = 0;
            }
        }
    }
}
