package com.tapjoy.internal;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* renamed from: com.tapjoy.internal.gr */
public final class C3114gr {

    /* renamed from: a */
    public static final C2889ba f7346a = new C2889ba() {
        /* renamed from: a */
        public final boolean mo29867a(Runnable runnable) {
            GLSurfaceView gLSurfaceView = (GLSurfaceView) C3114gr.f7348c.mo29904a();
            if (gLSurfaceView == null) {
                return false;
            }
            gLSurfaceView.queueEvent(runnable);
            return true;
        }
    };

    /* renamed from: b */
    private static Activity f7347b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final C2915by f7348c = new C2915by();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final C2915by f7349d = new C2915by();

    /* renamed from: a */
    static void m7196a(GLSurfaceView gLSurfaceView) {
        new Object[1][0] = gLSurfaceView;
        f7348c.mo29905a(gLSurfaceView);
        gLSurfaceView.queueEvent(new Runnable() {
            public final void run() {
                Thread currentThread = Thread.currentThread();
                new Object[1][0] = currentThread;
                C3114gr.f7349d.mo29905a(currentThread);
            }
        });
    }

    /* renamed from: a */
    public static Activity m7195a() {
        Activity activity = f7347b;
        return activity == null ? C1809b.m3450a() : activity;
    }

    /* renamed from: b */
    public static Thread m7197b() {
        return (Thread) f7349d.mo29904a();
    }
}
