package com.unity3d.player;

import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.unity3d.player.l */
final class C3354l implements UncaughtExceptionHandler {

    /* renamed from: a */
    private volatile UncaughtExceptionHandler f8028a;

    C3354l() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final synchronized boolean mo30739a() {
        boolean z;
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == this) {
            z = false;
        } else {
            this.f8028a = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
            z = true;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r7.f8028a.uncaughtException(r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006b, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0065 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void uncaughtException(java.lang.Thread r8, java.lang.Throwable r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.Error r0 = new java.lang.Error     // Catch:{ Throwable -> 0x0065 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0065 }
            r1.<init>()     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r2 = "FATAL EXCEPTION [%s]\n"
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r5 = r8.getName()     // Catch:{ Throwable -> 0x0065 }
            r6 = 0
            r4[r6] = r5     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ Throwable -> 0x0065 }
            r1.append(r2)     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r2 = "Unity version     : %s\n"
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r5 = "2019.2.17f1"
            r4[r6] = r5     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ Throwable -> 0x0065 }
            r1.append(r2)     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r2 = "Device model      : %s %s\n"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r5 = android.os.Build.MANUFACTURER     // Catch:{ Throwable -> 0x0065 }
            r4[r6] = r5     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ Throwable -> 0x0065 }
            r4[r3] = r5     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ Throwable -> 0x0065 }
            r1.append(r2)     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r2 = "Device fingerprint: %s\n"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r4 = android.os.Build.FINGERPRINT     // Catch:{ Throwable -> 0x0065 }
            r3[r6] = r4     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r2 = java.lang.String.format(r2, r3)     // Catch:{ Throwable -> 0x0065 }
            r1.append(r2)     // Catch:{ Throwable -> 0x0065 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0065 }
            r0.<init>(r1)     // Catch:{ Throwable -> 0x0065 }
            java.lang.StackTraceElement[] r1 = new java.lang.StackTraceElement[r6]     // Catch:{ Throwable -> 0x0065 }
            r0.setStackTrace(r1)     // Catch:{ Throwable -> 0x0065 }
            r0.initCause(r9)     // Catch:{ Throwable -> 0x0065 }
            java.lang.Thread$UncaughtExceptionHandler r1 = r7.f8028a     // Catch:{ Throwable -> 0x0065 }
            r1.uncaughtException(r8, r0)     // Catch:{ Throwable -> 0x0065 }
            monitor-exit(r7)
            return
        L_0x0063:
            r8 = move-exception
            goto L_0x006c
        L_0x0065:
            java.lang.Thread$UncaughtExceptionHandler r0 = r7.f8028a     // Catch:{ all -> 0x0063 }
            r0.uncaughtException(r8, r9)     // Catch:{ all -> 0x0063 }
            monitor-exit(r7)
            return
        L_0x006c:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.C3354l.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
