package com.adcolony.sdk;

import android.content.Context;
import com.facebook.login.widget.ToolTipPopup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.al */
class C0498al implements Runnable {

    /* renamed from: a */
    private final long f279a = 30000;

    /* renamed from: b */
    private final int f280b = 17;

    /* renamed from: c */
    private final int f281c = 15000;

    /* renamed from: d */
    private final int f282d = 1000;

    /* renamed from: e */
    private long f283e;

    /* renamed from: f */
    private long f284f;

    /* renamed from: g */
    private long f285g;

    /* renamed from: h */
    private long f286h;

    /* renamed from: i */
    private long f287i;

    /* renamed from: j */
    private long f288j;

    /* renamed from: k */
    private long f289k;

    /* renamed from: l */
    private long f290l;

    /* renamed from: m */
    private boolean f291m = true;

    /* renamed from: n */
    private boolean f292n = true;

    /* renamed from: o */
    private boolean f293o;

    /* renamed from: p */
    private boolean f294p;

    /* renamed from: q */
    private boolean f295q;

    /* renamed from: r */
    private boolean f296r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f297s;

    /* renamed from: t */
    private boolean f298t;

    C0498al() {
    }

    /* renamed from: a */
    public void mo8291a() {
        C0476a.m81a("SessionInfo.stopped", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0498al.this.f297s = true;
            }
        });
    }

    public void run() {
        long j;
        while (!this.f296r) {
            this.f286h = System.currentTimeMillis();
            C0476a.m88f();
            if (this.f284f >= 30000) {
                break;
            }
            if (!this.f291m) {
                if (this.f293o && !this.f292n) {
                    this.f293o = false;
                    m185f();
                }
                long j2 = this.f284f;
                if (this.f290l == 0) {
                    j = 0;
                } else {
                    j = System.currentTimeMillis() - this.f290l;
                }
                this.f284f = j2 + j;
                this.f290l = System.currentTimeMillis();
            } else {
                if (this.f293o && this.f292n) {
                    this.f293o = false;
                    m186g();
                }
                this.f284f = 0;
                this.f290l = 0;
            }
            this.f285g = 17;
            m183a(this.f285g);
            this.f287i = System.currentTimeMillis() - this.f286h;
            long j3 = this.f287i;
            if (j3 > 0 && j3 < ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
                this.f283e += j3;
            }
            C0666j a = C0476a.m77a();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f289k > 15000) {
                this.f289k = currentTimeMillis;
            }
            if (C0476a.m86d() && currentTimeMillis - this.f288j > 1000) {
                this.f288j = currentTimeMillis;
                String c = a.f957d.mo8243c();
                if (!c.equals(a.mo8589w())) {
                    a.mo8555a(c);
                    JSONObject a2 = C0746u.m892a();
                    C0746u.m902a(a2, "network_type", a.mo8589w());
                    new C0480ab("Network.on_status_change", 1, a2).mo8217b();
                }
            }
        }
        new C0749a().mo8726a("AdColony session ending, releasing Context.").mo8728a(C0748w.f1167c);
        C0476a.m77a().mo8563b(true);
        C0476a.m78a((Context) null);
        this.f295q = true;
        this.f298t = true;
        mo8293b();
        C0545a aVar = new C0545a(10.0d);
        while (!this.f297s && !aVar.mo8374b() && this.f298t) {
            C0476a.m88f();
            m183a(100);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8292a(boolean z) {
        if (!this.f294p) {
            if (this.f295q) {
                C0476a.m77a().mo8563b(false);
                this.f295q = false;
            }
            this.f283e = 0;
            this.f284f = 0;
            this.f294p = true;
            this.f291m = true;
            this.f297s = false;
            new Thread(this).start();
            if (z) {
                JSONObject a = C0746u.m892a();
                C0746u.m902a(a, "id", C0543at.m326e());
                new C0480ab("SessionInfo.on_start", 1, a).mo8217b();
                C0557av avVar = (C0557av) C0476a.m77a().mo8583q().mo8232e().get(Integer.valueOf(1));
                if (avVar != null) {
                    avVar.mo8414j();
                }
            }
            if (AdColony.f41a.isShutdown()) {
                AdColony.f41a = Executors.newSingleThreadExecutor();
            }
            C0752y.m951a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8293b() {
        this.f294p = false;
        this.f291m = false;
        if (C0752y.f1195l != null) {
            C0752y.f1195l.mo8256a();
        }
        JSONObject a = C0746u.m892a();
        double d = (double) this.f283e;
        Double.isNaN(d);
        C0746u.m900a(a, "session_length", d / 1000.0d);
        new C0480ab("SessionInfo.on_stop", 1, a).mo8217b();
        C0476a.m88f();
        AdColony.f41a.shutdown();
    }

    /* renamed from: f */
    private void m185f() {
        mo8294b(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8294b(boolean z) {
        ArrayList c = C0476a.m77a().mo8583q().mo8230c();
        synchronized (c) {
            Iterator it = c.iterator();
            while (it.hasNext()) {
                C0485ae aeVar = (C0485ae) it.next();
                JSONObject a = C0746u.m892a();
                C0746u.m913b(a, "from_window_focus", z);
                new C0480ab("SessionInfo.on_pause", aeVar.mo8236a(), a).mo8217b();
            }
        }
        this.f292n = true;
        C0476a.m88f();
    }

    /* renamed from: g */
    private void m186g() {
        mo8295c(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8295c(boolean z) {
        ArrayList c = C0476a.m77a().mo8583q().mo8230c();
        synchronized (c) {
            Iterator it = c.iterator();
            while (it.hasNext()) {
                C0485ae aeVar = (C0485ae) it.next();
                JSONObject a = C0746u.m892a();
                C0746u.m913b(a, "from_window_focus", z);
                new C0480ab("SessionInfo.on_resume", aeVar.mo8236a(), a).mo8217b();
            }
        }
        C0752y.m951a();
        this.f292n = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo8297d(boolean z) {
        this.f291m = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo8299e(boolean z) {
        this.f293o = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo8301f(boolean z) {
        this.f298t = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo8296c() {
        return this.f291m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo8298d() {
        return this.f293o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo8300e() {
        return this.f294p;
    }

    /* renamed from: a */
    private void m183a(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }
}
