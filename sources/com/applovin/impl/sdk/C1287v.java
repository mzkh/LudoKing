package com.applovin.impl.sdk;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.applovin.impl.mediation.p014b.C0959b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.sdk.v */
public class C1287v {

    /* renamed from: a */
    private final C1192i f3236a;

    /* renamed from: b */
    private final Object f3237b = new Object();

    /* renamed from: c */
    private final Rect f3238c = new Rect();

    /* renamed from: d */
    private final Handler f3239d;

    /* renamed from: e */
    private final Runnable f3240e;

    /* renamed from: f */
    private final OnPreDrawListener f3241f;

    /* renamed from: g */
    private WeakReference<ViewTreeObserver> f3242g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View f3243h;

    /* renamed from: i */
    private int f3244i;

    /* renamed from: j */
    private long f3245j;

    /* renamed from: k */
    private long f3246k = Long.MIN_VALUE;

    /* renamed from: com.applovin.impl.sdk.v$a */
    public interface C1290a {
        void onLogVisibilityImpression();
    }

    public C1287v(final MaxAdView maxAdView, C1192i iVar, final C1290a aVar) {
        this.f3236a = iVar;
        this.f3239d = new Handler(Looper.getMainLooper());
        this.f3240e = new Runnable() {
            public void run() {
                if (C1287v.this.f3243h != null) {
                    C1287v vVar = C1287v.this;
                    if (vVar.m3147b(maxAdView, vVar.f3243h)) {
                        C1287v.this.mo10469a();
                        aVar.onLogVisibilityImpression();
                    } else {
                        C1287v.this.m3145b();
                    }
                }
            }
        };
        this.f3241f = new OnPreDrawListener() {
            public boolean onPreDraw() {
                C1287v.this.m3145b();
                return true;
            }
        };
    }

    /* renamed from: a */
    private void m3142a(Context context, View view) {
        View a = C1281o.m3068a(context, view);
        String str = "VisibilityTracker";
        if (a == null) {
            this.f3236a.mo10249v().mo10378b(str, "Unable to set view tree observer due to no root view.");
            return;
        }
        ViewTreeObserver viewTreeObserver = a.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            this.f3236a.mo10249v().mo10381d(str, "Unable to set view tree observer since the view tree observer is not alive.");
            return;
        }
        this.f3242g = new WeakReference<>(viewTreeObserver);
        viewTreeObserver.addOnPreDrawListener(this.f3241f);
    }

    /* renamed from: a */
    private boolean m3143a(View view, View view2) {
        boolean z = false;
        if (view2 != null && view2.getVisibility() == 0 && view.getParent() != null && view2.getWidth() > 0 && view2.getHeight() > 0) {
            if (!view2.getGlobalVisibleRect(this.f3238c)) {
                return false;
            }
            if (((long) (AppLovinSdkUtils.pxToDp(view2.getContext(), this.f3238c.width()) * AppLovinSdkUtils.pxToDp(view2.getContext(), this.f3238c.height()))) >= ((long) this.f3244i)) {
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m3145b() {
        this.f3239d.postDelayed(this.f3240e, ((Long) this.f3236a.mo10202a(C1096c.f2431co)).longValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m3147b(View view, View view2) {
        if (!m3143a(view, view2)) {
            return false;
        }
        if (this.f3246k == Long.MIN_VALUE) {
            this.f3246k = SystemClock.uptimeMillis();
        }
        return SystemClock.uptimeMillis() - this.f3246k >= this.f3245j;
    }

    /* renamed from: a */
    public void mo10469a() {
        synchronized (this.f3237b) {
            this.f3239d.removeMessages(0);
            if (this.f3242g != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f3242g.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.f3241f);
                }
                this.f3242g.clear();
            }
            this.f3246k = Long.MIN_VALUE;
            this.f3243h = null;
        }
    }

    /* renamed from: a */
    public void mo10470a(Context context, C0959b bVar) {
        synchronized (this.f3237b) {
            mo10469a();
            this.f3243h = bVar.mo9439l();
            this.f3244i = bVar.mo9444q();
            this.f3245j = bVar.mo9446s();
            m3142a(context, this.f3243h);
        }
    }
}
