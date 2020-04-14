package com.tapjoy.internal;

import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tapjoy.internal.C3026ev.C3027a;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.hm */
public final class C1840hm {

    /* renamed from: a */
    final C1830gy f3857a;

    /* renamed from: b */
    final AtomicBoolean f3858b = new AtomicBoolean();
    @Nullable

    /* renamed from: c */
    ScheduledFuture f3859c;

    /* renamed from: d */
    private final Runnable f3860d = new Runnable() {
        public final void run() {
            if (C1840hm.this.f3858b.compareAndSet(true, false)) {
                C3124gw.m7216a("The session ended");
                C1830gy gyVar = C1840hm.this.f3857a;
                long elapsedRealtime = SystemClock.elapsedRealtime() - gyVar.f3810c;
                C1835hc hcVar = gyVar.f3808a;
                synchronized (hcVar) {
                    long a = hcVar.f3843c.f7436i.mo30362a() + elapsedRealtime;
                    hcVar.f3843c.f7436i.mo30365a(a);
                    hcVar.f3842b.f7212i = Long.valueOf(a);
                }
                C3027a a2 = gyVar.mo18113a(C3035ey.APP, "session");
                a2.f7016i = Long.valueOf(elapsedRealtime);
                gyVar.mo18114a(a2);
                gyVar.f3810c = 0;
                C1835hc hcVar2 = gyVar.f3808a;
                long longValue = a2.f7012e.longValue();
                synchronized (hcVar2) {
                    Editor a3 = hcVar2.f3843c.mo30217a();
                    hcVar2.f3843c.f7437j.mo30364a(a3, longValue);
                    hcVar2.f3843c.f7438k.mo30364a(a3, elapsedRealtime);
                    a3.apply();
                    hcVar2.f3842b.f7213j = Long.valueOf(longValue);
                    hcVar2.f3842b.f7214k = Long.valueOf(elapsedRealtime);
                }
                C3125gx gxVar = gyVar.f3809b;
                if (gxVar.f7372b != null) {
                    gxVar.mo30199a();
                    new C3185im() {
                        /* access modifiers changed from: protected */
                        /* renamed from: a */
                        public final boolean mo30202a() {
                            return !C3125gx.this.f7371a.mo18180c();
                        }
                    }.run();
                }
                gxVar.f7371a.flush();
                C3081fs.f7267d.notifyObservers();
            }
        }
    };

    /* renamed from: e */
    private final Runnable f3861e = new Runnable() {
        public final void run() {
        }
    };

    C1840hm(C1830gy gyVar) {
        this.f3857a = gyVar;
    }

    /* renamed from: a */
    public final void mo18184a() {
        if (this.f3858b.get()) {
            if (Boolean.FALSE.booleanValue()) {
                ScheduledFuture scheduledFuture = this.f3859c;
                if (scheduledFuture == null || scheduledFuture.cancel(false)) {
                    this.f3859c = C3147hn.f7460a.schedule(this.f3860d, 3000, TimeUnit.MILLISECONDS);
                }
                return;
            }
            this.f3860d.run();
        }
    }
}
