package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyConstants;

/* renamed from: com.tapjoy.internal.ga */
public final class C3091ga {

    /* renamed from: b */
    private static final C3091ga f7287b;

    /* renamed from: c */
    private static C3091ga f7288c;

    /* renamed from: a */
    public final C1822fy f7289a = new C1822fy();

    /* renamed from: d */
    private Context f7290d;

    static {
        C3091ga gaVar = new C3091ga();
        f7287b = gaVar;
        f7288c = gaVar;
    }

    /* renamed from: a */
    public static C3091ga m7137a() {
        return f7288c;
    }

    /* renamed from: b */
    public static C1822fy m7138b() {
        return f7288c.f7289a;
    }

    C3091ga() {
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0030 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo30164a(android.content.Context r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 == 0) goto L_0x0050
            android.content.Context r0 = r3.f7290d     // Catch:{ all -> 0x004d }
            if (r0 != 0) goto L_0x0050
            r3.f7290d = r4     // Catch:{ all -> 0x004d }
            android.content.SharedPreferences r4 = r3.mo30165c()     // Catch:{ all -> 0x004d }
            android.content.SharedPreferences r0 = r3.mo30165c()     // Catch:{ all -> 0x004d }
            java.lang.String r1 = "configurations"
            r2 = 0
            java.lang.String r0 = r0.getString(r1, r2)     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x003d
            com.tapjoy.internal.bn r0 = com.tapjoy.internal.C1812bn.m3464b(r0)     // Catch:{ Exception -> 0x0030 }
            java.util.Map r1 = r0.mo18059d()     // Catch:{ all -> 0x002b }
            r0.close()     // Catch:{ Exception -> 0x0030 }
            com.tapjoy.internal.fy r0 = r3.f7289a     // Catch:{ Exception -> 0x0030 }
            r0.mo18091a(r1)     // Catch:{ Exception -> 0x0030 }
            goto L_0x003d
        L_0x002b:
            r1 = move-exception
            r0.close()     // Catch:{ Exception -> 0x0030 }
            throw r1     // Catch:{ Exception -> 0x0030 }
        L_0x0030:
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ all -> 0x004d }
            java.lang.String r0 = "configurations"
            android.content.SharedPreferences$Editor r4 = r4.remove(r0)     // Catch:{ all -> 0x004d }
            r4.apply()     // Catch:{ all -> 0x004d }
        L_0x003d:
            com.tapjoy.internal.ga$1 r4 = new com.tapjoy.internal.ga$1     // Catch:{ all -> 0x004d }
            r4.<init>()     // Catch:{ all -> 0x004d }
            com.tapjoy.internal.fy r0 = r3.f7289a     // Catch:{ all -> 0x004d }
            r0.addObserver(r4)     // Catch:{ all -> 0x004d }
            com.tapjoy.internal.fy r0 = r3.f7289a     // Catch:{ all -> 0x004d }
            r4.update(r0, r2)     // Catch:{ all -> 0x004d }
            goto L_0x0050
        L_0x004d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x0050:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3091ga.mo30164a(android.content.Context):void");
    }

    /* renamed from: c */
    public final SharedPreferences mo30165c() {
        return this.f7290d.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
    }
}
