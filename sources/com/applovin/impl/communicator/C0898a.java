package com.applovin.impl.communicator;

import android.content.Context;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.C1277l;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.communicator.a */
public class C0898a {

    /* renamed from: a */
    private final Context f1637a;

    /* renamed from: b */
    private final Set<C0899b> f1638b = new HashSet(32);

    /* renamed from: c */
    private final Object f1639c = new Object();

    public C0898a(Context context) {
        this.f1637a = context;
    }

    /* renamed from: a */
    private C0899b m1391a(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        for (C0899b bVar : this.f1638b) {
            if (str.equals(bVar.mo9254a()) && appLovinCommunicatorSubscriber.equals(bVar.mo9256b())) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004e, code lost:
        return true;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo9252a(com.applovin.communicator.AppLovinCommunicatorSubscriber r7, java.lang.String r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x006c
            boolean r0 = com.applovin.impl.sdk.utils.C1277l.m3042b(r8)
            if (r0 != 0) goto L_0x0009
            goto L_0x006c
        L_0x0009:
            java.lang.Object r0 = r6.f1639c
            monitor-enter(r0)
            com.applovin.impl.communicator.b r1 = r6.m1391a(r8, r7)     // Catch:{ all -> 0x0069 }
            r2 = 1
            if (r1 == 0) goto L_0x004f
            java.lang.String r3 = "AppLovinCommunicator"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r4.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r5 = "Attempting to re-subscribe subscriber ("
            r4.append(r5)     // Catch:{ all -> 0x0069 }
            r4.append(r7)     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = ") to topic ("
            r4.append(r7)     // Catch:{ all -> 0x0069 }
            r4.append(r8)     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = ")"
            r4.append(r7)     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0069 }
            com.applovin.impl.sdk.C1227o.m2838f(r3, r7)     // Catch:{ all -> 0x0069 }
            boolean r7 = r1.mo9257c()     // Catch:{ all -> 0x0069 }
            if (r7 != 0) goto L_0x004d
            r1.mo9255a(r2)     // Catch:{ all -> 0x0069 }
            android.content.Context r7 = r6.f1637a     // Catch:{ all -> 0x0069 }
            com.applovin.impl.sdk.AppLovinBroadcastManager r7 = com.applovin.impl.sdk.AppLovinBroadcastManager.getInstance(r7)     // Catch:{ all -> 0x0069 }
            android.content.IntentFilter r3 = new android.content.IntentFilter     // Catch:{ all -> 0x0069 }
            r3.<init>(r8)     // Catch:{ all -> 0x0069 }
            r7.registerReceiver(r1, r3)     // Catch:{ all -> 0x0069 }
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            return r2
        L_0x004f:
            com.applovin.impl.communicator.b r1 = new com.applovin.impl.communicator.b     // Catch:{ all -> 0x0069 }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x0069 }
            java.util.Set<com.applovin.impl.communicator.b> r7 = r6.f1638b     // Catch:{ all -> 0x0069 }
            r7.add(r1)     // Catch:{ all -> 0x0069 }
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            android.content.Context r7 = r6.f1637a
            com.applovin.impl.sdk.AppLovinBroadcastManager r7 = com.applovin.impl.sdk.AppLovinBroadcastManager.getInstance(r7)
            android.content.IntentFilter r0 = new android.content.IntentFilter
            r0.<init>(r8)
            r7.registerReceiver(r1, r0)
            return r2
        L_0x0069:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            throw r7
        L_0x006c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unable to subscribe - invalid subscriber ("
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = ") or topic ("
            r0.append(r7)
            r0.append(r8)
            java.lang.String r7 = ")"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.String r8 = "AppLovinCommunicator"
            com.applovin.impl.sdk.C1227o.m2841i(r8, r7)
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.communicator.C0898a.mo9252a(com.applovin.communicator.AppLovinCommunicatorSubscriber, java.lang.String):boolean");
    }

    /* renamed from: b */
    public void mo9253b(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        C0899b a;
        if (C1277l.m3042b(str)) {
            synchronized (this.f1639c) {
                a = m1391a(str, appLovinCommunicatorSubscriber);
            }
            if (a != null) {
                a.mo9255a(false);
                AppLovinBroadcastManager.getInstance(this.f1637a).unregisterReceiver(a);
            }
        }
    }
}
