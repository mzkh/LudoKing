package com.tapjoy.internal;

import java.io.File;

/* renamed from: com.tapjoy.internal.gx */
public final class C3125gx implements Runnable {

    /* renamed from: a */
    final C1838hl f7371a;

    /* renamed from: b */
    C2918cd f7372b;

    /* renamed from: c */
    private final Object f7373c;

    /* renamed from: d */
    private final Thread f7374d = new Thread(this, "5Rocks");

    /* renamed from: e */
    private boolean f7375e;

    public C3125gx(File file) {
        this.f7371a = new C1838hl(file);
        C1838hl hlVar = this.f7371a;
        this.f7373c = hlVar;
        new Object[1][0] = Integer.valueOf(hlVar.mo18178b());
        this.f7374d.start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0092 A[Catch:{ Exception | InterruptedException -> 0x0149 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0109 A[Catch:{ Exception | InterruptedException -> 0x0149 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r14 = this;
            r0 = 1
            r1 = 1
        L_0x0002:
            r2 = 0
            r4 = 0
            r5 = r2
        L_0x0006:
            com.tapjoy.internal.cd r7 = r14.f7372b     // Catch:{ Exception | InterruptedException -> 0x0149 }
            if (r7 == 0) goto L_0x010c
            com.tapjoy.internal.hl r7 = r14.f7371a     // Catch:{ Exception | InterruptedException -> 0x0149 }
            int r7 = r7.mo18178b()     // Catch:{ Exception | InterruptedException -> 0x0149 }
            if (r7 <= 0) goto L_0x010c
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 > 0) goto L_0x010c
            com.tapjoy.internal.hl r7 = r14.f7371a     // Catch:{ Exception | InterruptedException -> 0x0149 }
            int r7 = r7.mo18178b()     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r8 = 10000(0x2710, float:1.4013E-41)
            if (r7 <= r8) goto L_0x002c
            com.tapjoy.internal.hl r7 = r14.f7371a     // Catch:{ Exception | InterruptedException -> 0x0149 }
            com.tapjoy.internal.hl r9 = r14.f7371a     // Catch:{ Exception | InterruptedException -> 0x0149 }
            int r9 = r9.mo18178b()     // Catch:{ Exception | InterruptedException -> 0x0149 }
            int r9 = r9 - r8
            r7.mo18177a(r9)     // Catch:{ Exception | InterruptedException -> 0x0149 }
        L_0x002c:
            com.tapjoy.internal.hl r7 = r14.f7371a     // Catch:{ Exception | InterruptedException -> 0x0149 }
            com.tapjoy.internal.ev r7 = r7.mo18179b(r4)     // Catch:{ Exception | InterruptedException -> 0x0149 }
            if (r7 == 0) goto L_0x010c
            com.tapjoy.internal.fh r5 = r7.f7005w     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r8 = 3
            if (r5 == 0) goto L_0x0045
            java.lang.String r5 = r5.f7184G     // Catch:{ Exception | InterruptedException -> 0x0149 }
            if (r5 != 0) goto L_0x0045
            java.util.concurrent.CountDownLatch r5 = com.tapjoy.internal.C3147hn.f7462c     // Catch:{ Exception | InterruptedException -> 0x0149 }
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r5.await(r8, r6)     // Catch:{ Exception | InterruptedException -> 0x0149 }
        L_0x0045:
            boolean r5 = com.tapjoy.internal.C3256v.m7570c()     // Catch:{ Exception | InterruptedException -> 0x0149 }
            if (r5 != 0) goto L_0x0052
            java.util.concurrent.CountDownLatch r5 = com.tapjoy.internal.C3147hn.f7461b     // Catch:{ Exception | InterruptedException -> 0x0149 }
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r5.await(r8, r6)     // Catch:{ Exception | InterruptedException -> 0x0149 }
        L_0x0052:
            boolean r5 = r14.f7375e     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r6 = 100
            if (r5 != 0) goto L_0x008d
            com.tapjoy.internal.ey r5 = r7.f6996n     // Catch:{ Exception | InterruptedException -> 0x0149 }
            com.tapjoy.internal.ey r8 = com.tapjoy.internal.C3035ey.APP     // Catch:{ Exception | InterruptedException -> 0x0149 }
            if (r5 == r8) goto L_0x008d
            com.tapjoy.internal.hl r5 = r14.f7371a     // Catch:{ Exception | InterruptedException -> 0x0149 }
            int r5 = r5.mo18178b()     // Catch:{ Exception | InterruptedException -> 0x0149 }
            if (r5 >= r6) goto L_0x008d
            java.lang.Long r5 = r7.f6998p     // Catch:{ Exception | InterruptedException -> 0x0149 }
            long r8 = r5.longValue()     // Catch:{ Exception | InterruptedException -> 0x0149 }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | InterruptedException -> 0x0149 }
            int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x0075
            goto L_0x008d
        L_0x0075:
            java.lang.Long r5 = r7.f6998p     // Catch:{ Exception | InterruptedException -> 0x0149 }
            long r8 = r5.longValue()     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r10 = 60000(0xea60, double:2.9644E-319)
            long r8 = r8 + r10
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | InterruptedException -> 0x0149 }
            long r8 = r8 - r12
            long r8 = java.lang.Math.max(r8, r2)     // Catch:{ Exception | InterruptedException -> 0x0149 }
            long r8 = java.lang.Math.min(r8, r10)     // Catch:{ Exception | InterruptedException -> 0x0149 }
            goto L_0x008e
        L_0x008d:
            r8 = r2
        L_0x008e:
            int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r5 > 0) goto L_0x0109
            com.tapjoy.internal.ik r5 = new com.tapjoy.internal.ik     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r5.<init>()     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r5.mo30255a(r7)     // Catch:{ Exception | InterruptedException -> 0x0149 }
            java.lang.Object[] r10 = new java.lang.Object[r0]     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r10[r4] = r7     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r7 = 1
        L_0x009f:
            if (r7 >= r6) goto L_0x00be
            com.tapjoy.internal.hl r10 = r14.f7371a     // Catch:{ Exception | InterruptedException -> 0x0149 }
            int r10 = r10.mo18178b()     // Catch:{ Exception | InterruptedException -> 0x0149 }
            if (r7 >= r10) goto L_0x00be
            com.tapjoy.internal.hl r10 = r14.f7371a     // Catch:{ Exception | InterruptedException -> 0x0149 }
            com.tapjoy.internal.ev r10 = r10.mo18179b(r7)     // Catch:{ Exception | InterruptedException -> 0x0149 }
            if (r10 == 0) goto L_0x00be
            boolean r11 = r5.mo30255a(r10)     // Catch:{ Exception | InterruptedException -> 0x0149 }
            if (r11 == 0) goto L_0x00be
            java.lang.Object[] r11 = new java.lang.Object[r0]     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r11[r4] = r10     // Catch:{ Exception | InterruptedException -> 0x0149 }
            int r7 = r7 + 1
            goto L_0x009f
        L_0x00be:
            int r1 = r1 + 1
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00f5 }
            int r10 = r5.mo30256g()     // Catch:{ Exception -> 0x00f5 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x00f5 }
            r7[r4] = r10     // Catch:{ Exception -> 0x00f5 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x00f5 }
            r7[r0] = r10     // Catch:{ Exception -> 0x00f5 }
            com.tapjoy.internal.cd r7 = r14.f7372b     // Catch:{ Exception -> 0x00f5 }
            r7.mo29908a(r5)     // Catch:{ Exception -> 0x00f5 }
            com.tapjoy.internal.hl r7 = r14.f7371a     // Catch:{ Exception -> 0x00f5 }
            int r10 = r5.mo30256g()     // Catch:{ Exception -> 0x00f5 }
            r7.mo18177a(r10)     // Catch:{ Exception -> 0x00f5 }
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x00f1 }
            int r7 = r5.mo30256g()     // Catch:{ Exception -> 0x00f1 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00f1 }
            r1[r4] = r7     // Catch:{ Exception -> 0x00f1 }
            r5 = r8
            r1 = 0
            goto L_0x0006
        L_0x00f1:
            r1 = move-exception
            r7 = r1
            r1 = 0
            goto L_0x00f6
        L_0x00f5:
            r7 = move-exception
        L_0x00f6:
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception | InterruptedException -> 0x0149 }
            int r5 = r5.mo30256g()     // Catch:{ Exception | InterruptedException -> 0x0149 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r6[r4] = r5     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r6[r0] = r7     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r5 = 300000(0x493e0, double:1.482197E-318)
            goto L_0x0006
        L_0x0109:
            r5 = r8
            goto L_0x0006
        L_0x010c:
            com.tapjoy.internal.hl r7 = r14.f7371a     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r7.flush()     // Catch:{ Exception | InterruptedException -> 0x0149 }
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x012d
            java.lang.Object r2 = r14.f7373c     // Catch:{ Exception | InterruptedException -> 0x0149 }
            monitor-enter(r2)     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r14.f7375e = r4     // Catch:{ all -> 0x012a }
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ all -> 0x012a }
            java.lang.Long r7 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x012a }
            r3[r4] = r7     // Catch:{ all -> 0x012a }
            java.lang.Object r3 = r14.f7373c     // Catch:{ all -> 0x012a }
            r3.wait(r5)     // Catch:{ all -> 0x012a }
            monitor-exit(r2)     // Catch:{ all -> 0x012a }
            goto L_0x0002
        L_0x012a:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x012a }
            throw r0     // Catch:{ Exception | InterruptedException -> 0x0149 }
        L_0x012d:
            java.lang.Object r2 = r14.f7373c     // Catch:{ Exception | InterruptedException -> 0x0149 }
            monitor-enter(r2)     // Catch:{ Exception | InterruptedException -> 0x0149 }
            r14.f7375e = r4     // Catch:{ all -> 0x0146 }
            com.tapjoy.internal.cd r3 = r14.f7372b     // Catch:{ all -> 0x0146 }
            if (r3 == 0) goto L_0x013e
            com.tapjoy.internal.hl r3 = r14.f7371a     // Catch:{ all -> 0x0146 }
            boolean r3 = r3.mo18180c()     // Catch:{ all -> 0x0146 }
            if (r3 == 0) goto L_0x0143
        L_0x013e:
            java.lang.Object r3 = r14.f7373c     // Catch:{ all -> 0x0146 }
            r3.wait()     // Catch:{ all -> 0x0146 }
        L_0x0143:
            monitor-exit(r2)     // Catch:{ all -> 0x0146 }
            goto L_0x0002
        L_0x0146:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0146 }
            throw r0     // Catch:{ Exception | InterruptedException -> 0x0149 }
        L_0x0149:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3125gx.run():void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo30200a(boolean z) {
        synchronized (this.f7373c) {
            this.f7375e = z;
            this.f7373c.notify();
        }
    }

    /* renamed from: a */
    public final void mo30199a() {
        if (this.f7372b != null && !this.f7371a.mo18180c()) {
            mo30200a(true);
        }
    }
}
