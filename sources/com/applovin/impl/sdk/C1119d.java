package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.p019b.C1095b;
import com.applovin.impl.sdk.utils.C1278m;

/* renamed from: com.applovin.impl.sdk.d */
public class C1119d extends BroadcastReceiver implements C1210a {

    /* renamed from: a */
    private C1278m f2738a;

    /* renamed from: b */
    private final Object f2739b = new Object();

    /* renamed from: c */
    private final C1192i f2740c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1121a f2741d;

    /* renamed from: e */
    private long f2742e;

    /* renamed from: com.applovin.impl.sdk.d$a */
    public interface C1121a {
        void onAdRefresh();
    }

    public C1119d(C1192i iVar, C1121a aVar) {
        this.f2741d = aVar;
        this.f2740c = iVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m2277j() {
        synchronized (this.f2739b) {
            this.f2738a = null;
            if (!((Boolean) this.f2740c.mo10202a(C1095b.f2273x)).booleanValue()) {
                this.f2740c.mo10220ad().unregisterReceiver(this);
                this.f2740c.mo10200Z().mo10283b((C1210a) this);
            }
        }
    }

    /* renamed from: a */
    public void mo10056a(long j) {
        synchronized (this.f2739b) {
            mo10059c();
            this.f2742e = j;
            this.f2738a = C1278m.m3045a(j, this.f2740c, new Runnable() {
                public void run() {
                    C1119d.this.m2277j();
                    C1119d.this.f2741d.onAdRefresh();
                }
            });
            if (!((Boolean) this.f2740c.mo10202a(C1095b.f2273x)).booleanValue()) {
                this.f2740c.mo10220ad().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
                this.f2740c.mo10220ad().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
                this.f2740c.mo10200Z().mo10280a((C1210a) this);
            }
            if (((Boolean) this.f2740c.mo10202a(C1095b.f2272w)).booleanValue() && (this.f2740c.mo10200Z().mo10284b() || this.f2740c.mo10199Y().mo10396a())) {
                this.f2738a.mo10439b();
            }
        }
    }

    /* renamed from: a */
    public boolean mo10057a() {
        boolean z;
        synchronized (this.f2739b) {
            z = this.f2738a != null;
        }
        return z;
    }

    /* renamed from: b */
    public long mo10058b() {
        long a;
        synchronized (this.f2739b) {
            a = this.f2738a != null ? this.f2738a.mo10438a() : -1;
        }
        return a;
    }

    /* renamed from: c */
    public void mo10059c() {
        synchronized (this.f2739b) {
            if (this.f2738a != null) {
                this.f2738a.mo10441d();
                m2277j();
            }
        }
    }

    /* renamed from: d */
    public void mo10060d() {
        synchronized (this.f2739b) {
            if (this.f2738a != null) {
                this.f2738a.mo10439b();
            }
        }
    }

    /* renamed from: e */
    public void mo10061e() {
        synchronized (this.f2739b) {
            if (this.f2738a != null) {
                this.f2738a.mo10440c();
            }
        }
    }

    /* renamed from: f */
    public void mo10062f() {
        if (((Boolean) this.f2740c.mo10202a(C1095b.f2271v)).booleanValue()) {
            mo10060d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        if (r2 == false) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
        r9.f2741d.onAdRefresh();
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo10063g() {
        /*
            r9 = this;
            com.applovin.impl.sdk.i r0 = r9.f2740c
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r1 = com.applovin.impl.sdk.p019b.C1095b.f2271v
            java.lang.Object r0 = r0.mo10202a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0069
            java.lang.Object r0 = r9.f2739b
            monitor-enter(r0)
            com.applovin.impl.sdk.i r1 = r9.f2740c     // Catch:{ all -> 0x0066 }
            com.applovin.impl.sdk.n r1 = r1.mo10200Z()     // Catch:{ all -> 0x0066 }
            boolean r1 = r1.mo10284b()     // Catch:{ all -> 0x0066 }
            if (r1 == 0) goto L_0x002e
            com.applovin.impl.sdk.i r1 = r9.f2740c     // Catch:{ all -> 0x0066 }
            com.applovin.impl.sdk.o r1 = r1.mo10249v()     // Catch:{ all -> 0x0066 }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Waiting for the full screen ad to be dismissed to resume the timer."
            r1.mo10378b(r2, r3)     // Catch:{ all -> 0x0066 }
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            return
        L_0x002e:
            com.applovin.impl.sdk.utils.m r1 = r9.f2738a     // Catch:{ all -> 0x0066 }
            r2 = 0
            if (r1 == 0) goto L_0x005d
            long r3 = r9.f2742e     // Catch:{ all -> 0x0066 }
            long r5 = r9.mo10058b()     // Catch:{ all -> 0x0066 }
            long r3 = r3 - r5
            com.applovin.impl.sdk.i r1 = r9.f2740c     // Catch:{ all -> 0x0066 }
            com.applovin.impl.sdk.b.c<java.lang.Long> r5 = com.applovin.impl.sdk.p019b.C1095b.f2270u     // Catch:{ all -> 0x0066 }
            java.lang.Object r1 = r1.mo10202a(r5)     // Catch:{ all -> 0x0066 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0066 }
            long r5 = r1.longValue()     // Catch:{ all -> 0x0066 }
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 < 0) goto L_0x0058
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0058
            r9.mo10059c()     // Catch:{ all -> 0x0066 }
            r1 = 1
            r2 = 1
            goto L_0x005d
        L_0x0058:
            com.applovin.impl.sdk.utils.m r1 = r9.f2738a     // Catch:{ all -> 0x0066 }
            r1.mo10440c()     // Catch:{ all -> 0x0066 }
        L_0x005d:
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            if (r2 == 0) goto L_0x0069
            com.applovin.impl.sdk.d$a r0 = r9.f2741d
            r0.onAdRefresh()
            goto L_0x0069
        L_0x0066:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            throw r1
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1119d.mo10063g():void");
    }

    /* renamed from: h */
    public void mo10064h() {
        if (((Boolean) this.f2740c.mo10202a(C1095b.f2272w)).booleanValue()) {
            mo10060d();
        }
    }

    /* renamed from: i */
    public void mo10065i() {
        if (((Boolean) this.f2740c.mo10202a(C1095b.f2272w)).booleanValue()) {
            synchronized (this.f2739b) {
                if (this.f2740c.mo10199Y().mo10396a()) {
                    this.f2740c.mo10249v().mo10378b("AdRefreshManager", "Waiting for the application to enter foreground to resume the timer.");
                } else if (this.f2738a != null) {
                    this.f2738a.mo10440c();
                }
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            mo10062f();
        } else if ("com.applovin.application_resumed".equals(action)) {
            mo10063g();
        }
    }
}
