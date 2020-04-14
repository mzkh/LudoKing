package com.inmobi.media;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.moat.analytics.mobile.inm.WebAdTracker;
import com.tapjoy.TJAdUnitConstants.String;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.inmobi.media.dh */
/* compiled from: MoatTrackedHtmlAd */
public class C2331dh extends C2299ct {

    /* renamed from: d */
    private static final String f4930d = "dh";
    @NonNull

    /* renamed from: e */
    private final WeakReference<Context> f4931e;
    @NonNull

    /* renamed from: f */
    private final C2300cu f4932f;
    @NonNull

    /* renamed from: g */
    private final Map<String, Object> f4933g;

    /* renamed from: h */
    private WebAdTracker f4934h;

    public C2331dh(@NonNull C2452f fVar, @NonNull Context context, @NonNull C2300cu cuVar, @NonNull Map<String, Object> map) {
        super(fVar);
        this.f4931e = new WeakReference<>(context);
        this.f4932f = cuVar;
        this.f4933g = map;
    }

    @Nullable
    /* renamed from: c */
    public final View mo28151c() {
        return this.f4932f.mo28151c();
    }

    @Nullable
    /* renamed from: a */
    public final View mo28144a(View view, ViewGroup viewGroup, boolean z) {
        return this.f4932f.mo28144a(view, viewGroup, z);
    }

    @Nullable
    /* renamed from: b */
    public final View mo28150b() {
        return this.f4932f.mo28150b();
    }

    /* renamed from: a */
    public final void mo28149a(@Nullable View... viewArr) {
        m4800f();
        this.f4932f.mo28149a(viewArr);
    }

    /* renamed from: f */
    private void m4800f() {
        try {
            Application d = C2505gd.m5301d();
            if (this.f4855c.f5182i.f5241k && d != null && ((Boolean) this.f4933g.get(String.ENABLED)).booleanValue()) {
                if (this.f4934h == null) {
                    if (this.f4853a instanceof C2542h) {
                        C2542h hVar = (C2542h) this.f4853a;
                        if (hVar.mo28518v() != null) {
                            this.f4934h = C2330dg.m4798a(d, (WebView) hVar.mo28518v());
                        }
                    } else {
                        View b = this.f4932f.mo28150b();
                        if (b != null) {
                            this.f4934h = C2330dg.m4798a(d, (WebView) b);
                        }
                    }
                }
                if (this.f4934h != null) {
                    this.f4934h.startTracking();
                }
            }
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
    }

    /* renamed from: d */
    public final void mo28152d() {
        try {
            m4801g();
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        } catch (Throwable th) {
            this.f4932f.mo28152d();
            throw th;
        }
        this.f4932f.mo28152d();
    }

    /* renamed from: g */
    private void m4801g() {
        WebAdTracker webAdTracker = this.f4934h;
        if (webAdTracker != null) {
            webAdTracker.stopTracking();
        }
    }

    /* renamed from: a */
    public final void mo28146a(int i) {
        this.f4932f.mo28146a(i);
    }

    /* renamed from: a */
    public final void mo28147a(Context context, int i) {
        if (i == 0) {
            m4800f();
        } else if (i == 1) {
            m4801g();
        }
        this.f4932f.mo28147a(context, i);
    }

    /* renamed from: e */
    public final void mo28153e() {
        this.f4934h = null;
        this.f4931e.clear();
        super.mo28153e();
        this.f4932f.mo28153e();
    }
}
