package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.n */
public class C1207n {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1192i f3034a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AtomicBoolean f3035b = new AtomicBoolean();

    /* renamed from: c */
    private final List<C1210a> f3036c = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f3037d;

    /* renamed from: e */
    private final Object f3038e = new Object();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final AtomicBoolean f3039f = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f3040g;

    /* renamed from: com.applovin.impl.sdk.n$a */
    interface C1210a {
        /* renamed from: h */
        void mo10064h();

        /* renamed from: i */
        void mo10065i();
    }

    C1207n(C1192i iVar) {
        this.f3034a = iVar;
    }

    /* renamed from: a */
    public void mo10280a(C1210a aVar) {
        this.f3036c.add(aVar);
    }

    /* renamed from: a */
    public void mo10281a(boolean z) {
        synchronized (this.f3038e) {
            this.f3039f.set(z);
            if (z) {
                this.f3040g = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append("Setting fullscreen ad pending display: ");
                sb.append(this.f3040g);
                this.f3034a.mo10249v().mo10378b("FullScreenAdTracker", sb.toString());
                final long longValue = ((Long) this.f3034a.mo10202a(C1096c.f2392cB)).longValue();
                if (longValue >= 0) {
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                        public void run() {
                            if (C1207n.this.mo10282a() && System.currentTimeMillis() - C1207n.this.f3040g >= longValue) {
                                C1207n.this.f3034a.mo10249v().mo10378b("FullScreenAdTracker", "Resetting \"pending display\" state...");
                                C1207n.this.f3039f.set(false);
                            }
                        }
                    }, longValue);
                }
            } else {
                this.f3040g = 0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Setting fullscreen ad not pending display: ");
                sb2.append(System.currentTimeMillis());
                this.f3034a.mo10249v().mo10378b("FullScreenAdTracker", sb2.toString());
            }
        }
    }

    /* renamed from: a */
    public boolean mo10282a() {
        return this.f3039f.get();
    }

    /* renamed from: b */
    public void mo10283b(C1210a aVar) {
        this.f3036c.remove(aVar);
    }

    /* renamed from: b */
    public boolean mo10284b() {
        return this.f3035b.get();
    }

    /* renamed from: c */
    public void mo10285c() {
        if (this.f3035b.compareAndSet(false, true)) {
            this.f3037d = System.currentTimeMillis();
            C1227o v = this.f3034a.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Setting fullscreen ad displayed: ");
            sb.append(this.f3037d);
            v.mo10378b("FullScreenAdTracker", sb.toString());
            Iterator it = new ArrayList(this.f3036c).iterator();
            while (it.hasNext()) {
                ((C1210a) it.next()).mo10064h();
            }
            final long longValue = ((Long) this.f3034a.mo10202a(C1096c.f2393cC)).longValue();
            if (longValue >= 0) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                    public void run() {
                        if (C1207n.this.f3035b.get() && System.currentTimeMillis() - C1207n.this.f3037d >= longValue) {
                            C1207n.this.f3034a.mo10249v().mo10378b("FullScreenAdTracker", "Resetting \"display\" state...");
                            C1207n.this.mo10286d();
                        }
                    }
                }, longValue);
            }
        }
    }

    /* renamed from: d */
    public void mo10286d() {
        if (this.f3035b.compareAndSet(true, false)) {
            C1227o v = this.f3034a.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Setting fullscreen ad hidden: ");
            sb.append(System.currentTimeMillis());
            v.mo10378b("FullScreenAdTracker", sb.toString());
            Iterator it = new ArrayList(this.f3036c).iterator();
            while (it.hasNext()) {
                ((C1210a) it.next()).mo10065i();
            }
        }
    }
}
