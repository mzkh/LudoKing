package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager.BadTokenException;
import android.widget.FrameLayout.LayoutParams;
import com.tapjoy.TJContentActivity;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.C3187io.C3190a;
import java.util.Iterator;

/* renamed from: com.tapjoy.internal.gv */
public class C3120gv extends C1837hg {

    /* renamed from: h */
    private static final String f7351h = "gv";

    /* renamed from: i */
    private static C3120gv f7352i;

    /* renamed from: a */
    final String f7353a;

    /* renamed from: b */
    final C3151hr f7354b;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C1831gz f7355j;

    /* renamed from: k */
    private boolean f7356k;

    /* renamed from: l */
    private boolean f7357l;

    /* renamed from: m */
    private long f7358m;

    /* renamed from: n */
    private Context f7359n;

    /* renamed from: o */
    private C3187io f7360o;

    /* renamed from: p */
    private Activity f7361p;

    /* renamed from: q */
    private C3128ha f7362q;

    /* renamed from: r */
    private Handler f7363r;

    /* renamed from: s */
    private Runnable f7364s;

    /* renamed from: a */
    public static void m7207a() {
        C3120gv gvVar = f7352i;
        if (gvVar != null) {
            C31211 r1 = new Runnable(gvVar) {

                /* renamed from: a */
                final /* synthetic */ C3120gv f7365a;

                {
                    this.f7365a = r1;
                }

                public final void run() {
                    C3120gv.m7209a(this.f7365a);
                }
            };
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null && mainLooper.getThread() == Thread.currentThread()) {
                r1.run();
                return;
            }
            C3254u.m7563a().post(r1);
        }
    }

    public C3120gv(C1831gz gzVar, String str, C3151hr hrVar, Context context) {
        this.f7355j = gzVar;
        this.f7353a = str;
        this.f7354b = hrVar;
        this.f7359n = context;
    }

    /* renamed from: b */
    public final void mo18174b() {
        Iterator it = this.f7354b.f7468a.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((C3170ia) it.next()).f7527c.iterator();
            while (it2.hasNext()) {
                C3167hz hzVar = (C3167hz) it2.next();
                if (hzVar.f7521l != null) {
                    hzVar.f7521l.mo30230b();
                }
                if (hzVar.f7522m != null) {
                    hzVar.f7522m.mo30230b();
                }
            }
        }
    }

    /* renamed from: c */
    public final boolean mo18175c() {
        Iterator it = this.f7354b.f7468a.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Iterator it2 = ((C3170ia) it.next()).f7527c.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    continue;
                    break;
                }
                C3167hz hzVar = (C3167hz) it2.next();
                if ((hzVar.f7521l == null || hzVar.f7521l.mo30229a()) && (hzVar.f7522m == null || hzVar.f7522m.mo30229a())) {
                }
            }
            z = false;
            continue;
            if (!z) {
                return false;
            }
        }
        return z;
    }

    /* renamed from: a */
    public final void mo18173a(C3128ha haVar, C3085fw fwVar) {
        this.f7362q = haVar;
        this.f7361p = C3114gr.m7195a();
        Activity activity = this.f7361p;
        if (activity != null && !activity.isFinishing()) {
            try {
                m7208a(this.f7361p, haVar, fwVar);
                new Object[1][0] = this.f7353a;
                return;
            } catch (BadTokenException unused) {
            }
        }
        this.f7361p = C1806a.m3444a(this.f7359n);
        Activity activity2 = this.f7361p;
        if (activity2 != null && !activity2.isFinishing()) {
            try {
                m7208a(this.f7361p, haVar, fwVar);
                new Object[1][0] = this.f7353a;
                return;
            } catch (BadTokenException unused2) {
            }
        }
        C3124gw.m7222b("Failed to show the content for \"{}\". No usable activity found.", this.f7353a);
        haVar.mo29405a(this.f7353a, this.f3851f, null);
    }

    /* renamed from: a */
    private void m7208a(final Activity activity, final C3128ha haVar, C3085fw fwVar) {
        if (this.f7356k) {
            TapjoyLog.m6551e(f7351h, new TapjoyErrorMessage(ErrorType.INTEGRATION_ERROR, "Content is already displayed"));
            return;
        }
        this.f7356k = true;
        this.f7357l = true;
        f7352i = this;
        this.f3852g = fwVar.f7271a;
        this.f7360o = new C3187io(activity, this.f7354b, new C3190a() {
            /* renamed from: a */
            public final void mo30197a(C3167hz hzVar) {
                if (C3120gv.this.f3852g instanceof C3084fv) {
                    C3084fv fvVar = (C3084fv) C3120gv.this.f3852g;
                    if (!(fvVar == null || fvVar.f7270c == null)) {
                        fvVar.f7270c.mo30141a();
                    }
                }
                C3120gv.this.f7355j.mo18123a(C3120gv.this.f7354b.f7469b, hzVar.f7520k);
                if (!C1852jq.m3669c(hzVar.f7517h)) {
                    C3120gv.this.f3850e.mo29561a(activity, hzVar.f7517h, C1852jq.m3668b(hzVar.f7518i));
                    C3120gv.this.f3849d = true;
                } else if (!C1852jq.m3669c(hzVar.f7516g)) {
                    C1837hg.m3626a((Context) activity, hzVar.f7516g);
                }
                haVar.mo29404a(C3120gv.this.f7353a, null);
                if (hzVar.f7519j) {
                    C3120gv.m7209a(C3120gv.this);
                }
            }

            /* renamed from: a */
            public final void mo30196a() {
                C3120gv.m7209a(C3120gv.this);
            }
        });
        Window window = activity.getWindow();
        C3187io ioVar = this.f7360o;
        LayoutParams layoutParams = new LayoutParams(-1, -1, 17);
        Callback callback = window.getCallback();
        window.setCallback(null);
        window.addContentView(ioVar, layoutParams);
        window.setCallback(callback);
        this.f7358m = SystemClock.elapsedRealtime();
        this.f7355j.mo18121a(this.f7354b.f7469b);
        fwVar.mo30148a();
        C3078fq fqVar = this.f3852g;
        if (fqVar != null) {
            fqVar.mo30144b();
        }
        haVar.mo29407c(this.f7353a);
        if (this.f7354b.f7470c > 0.0f) {
            this.f7363r = new Handler(Looper.getMainLooper());
            this.f7364s = new Runnable() {
                public final void run() {
                    C3120gv.m7209a(C3120gv.this);
                }
            };
            this.f7363r.postDelayed(this.f7364s, (long) (this.f7354b.f7470c * 1000.0f));
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m7209a(C3120gv gvVar) {
        if (gvVar.f7357l) {
            gvVar.f7357l = false;
            Handler handler = gvVar.f7363r;
            if (handler != null) {
                handler.removeCallbacks(gvVar.f7364s);
                gvVar.f7364s = null;
                gvVar.f7363r = null;
            }
            if (f7352i == gvVar) {
                f7352i = null;
            }
            gvVar.f7355j.mo18122a(gvVar.f7354b.f7469b, SystemClock.elapsedRealtime() - gvVar.f7358m);
            if (!gvVar.f3849d) {
                C3128ha haVar = gvVar.f7362q;
                if (haVar != null) {
                    haVar.mo29405a(gvVar.f7353a, gvVar.f3851f, null);
                    gvVar.f7362q = null;
                }
            }
            ViewGroup viewGroup = (ViewGroup) gvVar.f7360o.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(gvVar.f7360o);
            }
            gvVar.f7360o = null;
            Activity activity = gvVar.f7361p;
            if (activity instanceof TJContentActivity) {
                activity.finish();
            }
            gvVar.f7361p = null;
        }
    }
}
