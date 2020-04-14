package com.moat.analytics.mobile.inm;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.moat.analytics.mobile.inm.i */
class C2716i {

    /* renamed from: a */
    private static final C2716i f6067a = new C2716i();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<C2719j, String> f6068b = new WeakHashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Map<C2701b, String> f6069c = new WeakHashMap();

    /* renamed from: d */
    private final ScheduledExecutorService f6070d = Executors.newScheduledThreadPool(1);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ScheduledFuture<?> f6071e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ScheduledFuture<?> f6072f;

    private C2716i() {
    }

    /* renamed from: a */
    static C2716i m6212a() {
        return f6067a;
    }

    /* renamed from: a */
    private void m6214a(final Context context) {
        ScheduledFuture<?> scheduledFuture = this.f6072f;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            C2735p.m6310a(3, "JSUpdateLooper", (Object) this, "Starting metadata reporting loop");
            this.f6072f = this.f6070d.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    try {
                        LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(new Intent("UPDATE_METADATA"));
                        if (C2716i.this.f6068b.isEmpty()) {
                            C2716i.this.f6072f.cancel(true);
                        }
                    } catch (Exception e) {
                        C2726m.m6274a(e);
                    }
                }
            }, 0, 50, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: b */
    private void m6216b(final Context context) {
        ScheduledFuture<?> scheduledFuture = this.f6071e;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            C2735p.m6310a(3, "JSUpdateLooper", (Object) this, "Starting view update loop");
            this.f6071e = this.f6070d.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    try {
                        LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(new Intent("UPDATE_VIEW_INFO"));
                        if (C2716i.this.f6069c.isEmpty()) {
                            C2735p.m6310a(3, "JSUpdateLooper", (Object) C2716i.this, "No more active trackers");
                            C2716i.this.f6071e.cancel(true);
                        }
                    } catch (Exception e) {
                        C2726m.m6274a(e);
                    }
                }
            }, 0, (long) C2750w.m6348a().f6158d, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29044a(Context context, C2701b bVar) {
        if (bVar != null) {
            StringBuilder sb = new StringBuilder("addActiveTracker");
            sb.append(bVar.hashCode());
            C2735p.m6310a(3, "JSUpdateLooper", (Object) this, sb.toString());
            Map<C2701b, String> map = this.f6069c;
            if (map != null && !map.containsKey(bVar)) {
                this.f6069c.put(bVar, "");
                m6216b(context);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29045a(Context context, C2719j jVar) {
        Map<C2719j, String> map = this.f6068b;
        if (map != null && jVar != null) {
            map.put(jVar, "");
            m6214a(context);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29046a(C2701b bVar) {
        if (bVar != null) {
            StringBuilder sb = new StringBuilder("removeActiveTracker");
            sb.append(bVar.hashCode());
            C2735p.m6310a(3, "JSUpdateLooper", (Object) this, sb.toString());
            Map<C2701b, String> map = this.f6069c;
            if (map != null) {
                map.remove(bVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29047a(C2719j jVar) {
        if (jVar != null) {
            StringBuilder sb = new StringBuilder("removeSetupNeededBridge");
            sb.append(jVar.hashCode());
            C2735p.m6310a(3, "JSUpdateLooper", (Object) this, sb.toString());
            Map<C2719j, String> map = this.f6068b;
            if (map != null) {
                map.remove(jVar);
            }
        }
    }
}
