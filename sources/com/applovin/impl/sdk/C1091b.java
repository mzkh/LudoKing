package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.p019b.C1095b;
import com.applovin.impl.sdk.utils.C1278m;

/* renamed from: com.applovin.impl.sdk.b */
public class C1091b extends BroadcastReceiver {

    /* renamed from: a */
    private final C1192i f2226a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1093a f2227b;

    /* renamed from: c */
    private C1278m f2228c;

    /* renamed from: d */
    private final Object f2229d = new Object();

    /* renamed from: e */
    private long f2230e;

    /* renamed from: com.applovin.impl.sdk.b$a */
    public interface C1093a {
        void onAdExpired();
    }

    public C1091b(C1192i iVar, C1093a aVar) {
        this.f2226a = iVar;
        this.f2227b = aVar;
    }

    /* renamed from: b */
    private void m2122b() {
        C1278m mVar = this.f2228c;
        if (mVar != null) {
            mVar.mo10441d();
            this.f2228c = null;
        }
    }

    /* renamed from: c */
    private void m2123c() {
        synchronized (this.f2229d) {
            m2122b();
        }
    }

    /* renamed from: d */
    private void m2124d() {
        boolean z;
        synchronized (this.f2229d) {
            long currentTimeMillis = this.f2230e - System.currentTimeMillis();
            if (currentTimeMillis <= 0) {
                mo9942a();
                z = true;
            } else {
                mo9943a(currentTimeMillis);
                z = false;
            }
        }
        if (z) {
            this.f2227b.onAdExpired();
        }
    }

    /* renamed from: a */
    public void mo9942a() {
        synchronized (this.f2229d) {
            m2122b();
            this.f2226a.mo10220ad().unregisterReceiver(this);
        }
    }

    /* renamed from: a */
    public void mo9943a(long j) {
        synchronized (this.f2229d) {
            mo9942a();
            this.f2230e = System.currentTimeMillis() + j;
            this.f2226a.mo10220ad().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
            this.f2226a.mo10220ad().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
            if (((Boolean) this.f2226a.mo10202a(C1095b.f2240H)).booleanValue() || !this.f2226a.mo10199Y().mo10396a()) {
                this.f2228c = C1278m.m3045a(j, this.f2226a, new Runnable() {
                    public void run() {
                        C1091b.this.mo9942a();
                        C1091b.this.f2227b.onAdExpired();
                    }
                });
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            m2123c();
        } else if ("com.applovin.application_resumed".equals(action)) {
            m2124d();
        }
    }
}
