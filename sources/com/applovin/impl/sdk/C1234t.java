package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1113g;
import com.applovin.impl.sdk.utils.C1239a;
import com.applovin.impl.sdk.utils.C1281o;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.t */
public class C1234t {

    /* renamed from: a */
    final C1192i f3124a;

    /* renamed from: b */
    private final AtomicBoolean f3125b = new AtomicBoolean();

    /* renamed from: c */
    private final AtomicBoolean f3126c = new AtomicBoolean();

    /* renamed from: d */
    private final AtomicBoolean f3127d = new AtomicBoolean();

    /* renamed from: e */
    private Date f3128e;

    /* renamed from: f */
    private Date f3129f;

    C1234t(C1192i iVar) {
        this.f3124a = iVar;
        Application application = (Application) iVar.mo10179D();
        application.registerActivityLifecycleCallbacks(new C1239a() {
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                C1234t.this.m2906e();
            }
        });
        application.registerComponentCallbacks(new ComponentCallbacks2() {
            public void onConfigurationChanged(Configuration configuration) {
            }

            public void onLowMemory() {
            }

            public void onTrimMemory(int i) {
                if (i == 20) {
                    C1234t.this.m2907f();
                }
            }
        });
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        application.registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (C1281o.m3105c()) {
                        C1234t.this.m2906e();
                    }
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    C1234t.this.m2907f();
                }
            }
        }, intentFilter);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2906e() {
        if (this.f3127d.compareAndSet(true, false)) {
            m2909h();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m2907f() {
        if (this.f3127d.compareAndSet(false, true)) {
            m2908g();
        }
    }

    /* renamed from: g */
    private void m2908g() {
        this.f3124a.mo10249v().mo10378b("SessionTracker", "Application Paused");
        this.f3124a.mo10220ad().sendBroadcastSync(new Intent("com.applovin.application_paused"));
        if (!this.f3126c.get() && ((Boolean) this.f3124a.mo10202a(C1096c.f2459dQ)).booleanValue()) {
            boolean booleanValue = ((Boolean) this.f3124a.mo10202a(C1096c.f2456dN)).booleanValue();
            long millis = TimeUnit.MINUTES.toMillis(((Long) this.f3124a.mo10202a(C1096c.f2458dP)).longValue());
            if (this.f3128e == null || System.currentTimeMillis() - this.f3128e.getTime() >= millis) {
                ((EventServiceImpl) this.f3124a.mo10243q()).mo9696a(String.VIDEO_PAUSED, false);
                if (booleanValue) {
                    this.f3128e = new Date();
                }
            }
            if (!booleanValue) {
                this.f3128e = new Date();
            }
        }
    }

    /* renamed from: h */
    private void m2909h() {
        this.f3124a.mo10249v().mo10378b("SessionTracker", "Application Resumed");
        boolean booleanValue = ((Boolean) this.f3124a.mo10202a(C1096c.f2456dN)).booleanValue();
        long longValue = ((Long) this.f3124a.mo10202a(C1096c.f2457dO)).longValue();
        this.f3124a.mo10220ad().sendBroadcastSync(new Intent("com.applovin.application_resumed"));
        if (!this.f3126c.getAndSet(false)) {
            long millis = TimeUnit.MINUTES.toMillis(longValue);
            if (this.f3129f == null || System.currentTimeMillis() - this.f3129f.getTime() >= millis) {
                ((EventServiceImpl) this.f3124a.mo10243q()).mo9696a("resumed", false);
                if (booleanValue) {
                    this.f3129f = new Date();
                }
            }
            if (!booleanValue) {
                this.f3129f = new Date();
            }
            this.f3124a.mo10186L().mo10036a(C1113g.f2666k);
            this.f3125b.set(true);
        }
    }

    /* renamed from: a */
    public boolean mo10396a() {
        return this.f3127d.get();
    }

    /* renamed from: b */
    public void mo10397b() {
        this.f3126c.set(true);
    }

    /* renamed from: c */
    public void mo10398c() {
        this.f3126c.set(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo10399d() {
        return this.f3125b.getAndSet(false);
    }
}
