package com.moat.analytics.mobile.inm;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.tapjoy.TapjoyConstants;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.moat.analytics.mobile.inm.w */
class C2750w {

    /* renamed from: h */
    private static C2750w f6153h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final Queue<C2757c> f6154i = new ConcurrentLinkedQueue();

    /* renamed from: a */
    volatile C2758d f6155a = C2758d.OFF;

    /* renamed from: b */
    volatile boolean f6156b = false;

    /* renamed from: c */
    volatile boolean f6157c = false;

    /* renamed from: d */
    volatile int f6158d = Callback.DEFAULT_DRAG_ANIMATION_DURATION;

    /* renamed from: e */
    volatile int f6159e = 10;

    /* renamed from: f */
    private long f6160f = TapjoyConstants.SESSION_ID_INACTIVITY_TIME;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f6161g = 60000;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Handler f6162j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final AtomicBoolean f6163k = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: l */
    public volatile long f6164l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final AtomicInteger f6165m = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final AtomicBoolean f6166n = new AtomicBoolean(false);

    /* renamed from: com.moat.analytics.mobile.inm.w$a */
    class C2754a implements Runnable {

        /* renamed from: b */
        private final Handler f6172b;

        /* renamed from: c */
        private final String f6173c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final C2759e f6174d;

        private C2754a(String str, Handler handler, C2759e eVar) {
            this.f6174d = eVar;
            this.f6172b = handler;
            StringBuilder sb = new StringBuilder("https://z.moatads.com/");
            sb.append(str);
            sb.append("/android/");
            sb.append("c334ae83accfebb8da23104450c896463c9cfab7".substring(0, 7));
            sb.append("/status.json");
            this.f6173c = sb.toString();
        }

        /* renamed from: a */
        private void m6364a() {
            String b = m6365b();
            final C2725l lVar = new C2725l(b);
            C2750w.this.f6156b = lVar.mo29068a();
            C2750w.this.f6157c = lVar.mo29069b();
            C2750w.this.f6158d = lVar.mo29070c();
            C2750w.this.f6159e = lVar.mo29071d();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    try {
                        C2754a.this.f6174d.mo29090a(lVar);
                    } catch (Exception e) {
                        C2726m.m6274a(e);
                    }
                }
            });
            C2750w.this.f6164l = System.currentTimeMillis();
            C2750w.this.f6166n.compareAndSet(true, false);
            if (b != null) {
                C2750w.this.f6165m.set(0);
            } else if (C2750w.this.f6165m.incrementAndGet() < 10) {
                C2750w wVar = C2750w.this;
                wVar.m6349a(wVar.f6161g);
            }
        }

        /* renamed from: b */
        private String m6365b() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6173c);
            sb.append("?ts=");
            sb.append(System.currentTimeMillis());
            sb.append("&v=2.5.0");
            try {
                return (String) C2736q.m6315a(sb.toString()).mo28992b();
            } catch (Exception unused) {
                return null;
            }
        }

        public void run() {
            try {
                m6364a();
            } catch (Exception e) {
                C2726m.m6274a(e);
            }
            this.f6172b.removeCallbacks(this);
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                myLooper.quit();
            }
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.w$b */
    interface C2756b {
        /* renamed from: c */
        void mo29066c();

        /* renamed from: d */
        void mo29067d();
    }

    /* renamed from: com.moat.analytics.mobile.inm.w$c */
    class C2757c {

        /* renamed from: a */
        final Long f6177a;

        /* renamed from: b */
        final C2756b f6178b;

        C2757c(Long l, C2756b bVar) {
            this.f6177a = l;
            this.f6178b = bVar;
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.w$d */
    enum C2758d {
        OFF,
        ON
    }

    /* renamed from: com.moat.analytics.mobile.inm.w$e */
    interface C2759e {
        /* renamed from: a */
        void mo29090a(C2725l lVar);
    }

    private C2750w() {
        try {
            this.f6162j = new Handler(Looper.getMainLooper());
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
    }

    /* renamed from: a */
    static synchronized C2750w m6348a() {
        C2750w wVar;
        synchronized (C2750w.class) {
            if (f6153h == null) {
                f6153h = new C2750w();
            }
            wVar = f6153h;
        }
        return wVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6349a(final long j) {
        if (this.f6166n.compareAndSet(false, true)) {
            C2735p.m6310a(3, "OnOff", (Object) this, "Performing status check.");
            new Thread() {
                public void run() {
                    Looper.prepare();
                    Handler handler = new Handler();
                    C2754a aVar = new C2754a("INM", handler, new C2759e() {
                        /* renamed from: a */
                        public void mo29090a(C2725l lVar) {
                            synchronized (C2750w.f6154i) {
                                boolean z = ((C2724k) MoatAnalytics.getInstance()).f6100a;
                                if (C2750w.this.f6155a != lVar.mo29072e() || (C2750w.this.f6155a == C2758d.OFF && z)) {
                                    C2750w.this.f6155a = lVar.mo29072e();
                                    if (C2750w.this.f6155a == C2758d.OFF && z) {
                                        C2750w.this.f6155a = C2758d.ON;
                                    }
                                    if (C2750w.this.f6155a == C2758d.ON) {
                                        C2735p.m6310a(3, "OnOff", (Object) this, "Moat enabled - Version 2.5.0");
                                    }
                                    for (C2757c cVar : C2750w.f6154i) {
                                        if (C2750w.this.f6155a == C2758d.ON) {
                                            cVar.f6178b.mo29066c();
                                        } else {
                                            cVar.f6178b.mo29067d();
                                        }
                                    }
                                }
                                while (!C2750w.f6154i.isEmpty()) {
                                    C2750w.f6154i.remove();
                                }
                            }
                        }
                    });
                    handler.postDelayed(aVar, j);
                    Looper.loop();
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6356d() {
        synchronized (f6154i) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = f6154i.iterator();
            while (it.hasNext()) {
                if (currentTimeMillis - ((C2757c) it.next()).f6177a.longValue() >= 60000) {
                    it.remove();
                }
            }
            if (f6154i.size() >= 15) {
                for (int i = 0; i < 5; i++) {
                    f6154i.remove();
                }
            }
        }
    }

    /* renamed from: e */
    private void m6358e() {
        if (this.f6163k.compareAndSet(false, true)) {
            this.f6162j.postDelayed(new Runnable() {
                public void run() {
                    try {
                        if (C2750w.f6154i.size() > 0) {
                            C2750w.this.m6356d();
                            C2750w.this.f6162j.postDelayed(this, 60000);
                            return;
                        }
                        C2750w.this.f6163k.compareAndSet(true, false);
                        C2750w.this.f6162j.removeCallbacks(this);
                    } catch (Exception e) {
                        C2726m.m6274a(e);
                    }
                }
            }, 60000);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29087a(C2756b bVar) {
        if (this.f6155a == C2758d.ON) {
            bVar.mo29066c();
            return;
        }
        m6356d();
        f6154i.add(new C2757c(Long.valueOf(System.currentTimeMillis()), bVar));
        m6358e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo29088b() {
        if (System.currentTimeMillis() - this.f6164l > this.f6160f) {
            m6349a(0);
        }
    }
}
