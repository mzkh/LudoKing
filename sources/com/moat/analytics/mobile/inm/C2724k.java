package com.moat.analytics.mobile.inm;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.inm.k */
class C2724k extends MoatAnalytics implements C2756b {

    /* renamed from: a */
    boolean f6100a = false;

    /* renamed from: b */
    boolean f6101b = false;

    /* renamed from: c */
    boolean f6102c = false;
    @Nullable

    /* renamed from: d */
    C2707g f6103d;

    /* renamed from: e */
    WeakReference<Context> f6104e;

    /* renamed from: f */
    private boolean f6105f = false;

    /* renamed from: g */
    private String f6106g;

    /* renamed from: h */
    private MoatOptions f6107h;

    C2724k() {
    }

    /* renamed from: a */
    private void m6257a(MoatOptions moatOptions, Application application) {
        if (this.f6105f) {
            C2735p.m6310a(3, "Analytics", (Object) this, "Moat SDK has already been started.");
            return;
        }
        this.f6107h = moatOptions;
        C2750w.m6348a().mo29088b();
        this.f6102c = moatOptions.disableLocationServices;
        if (application != null) {
            if (moatOptions.loggingEnabled && C2738s.m6322b(application.getApplicationContext())) {
                this.f6100a = true;
            }
            this.f6104e = new WeakReference<>(application.getApplicationContext());
            this.f6105f = true;
            this.f6101b = moatOptions.autoTrackGMAInterstitials;
            C2695a.m6142a(application);
            C2750w.m6348a().mo29087a((C2756b) this);
            if (!moatOptions.disableAdIdCollection) {
                C2738s.m6320a((Context) application);
            }
            C2735p.m6313a("[SUCCESS] ", "Moat Analytics SDK Version 2.5.0 started");
            return;
        }
        throw new C2726m("Moat Analytics SDK didn't start, application was null");
    }

    @UiThread
    /* renamed from: e */
    private void m6258e() {
        if (this.f6103d == null) {
            this.f6103d = new C2707g(C2695a.m6141a(), C2712a.DISPLAY);
            this.f6103d.mo29030a(this.f6106g);
            StringBuilder sb = new StringBuilder("Preparing native display tracking with partner code ");
            sb.append(this.f6106g);
            C2735p.m6310a(3, "Analytics", (Object) this, sb.toString());
            StringBuilder sb2 = new StringBuilder("Prepared for native display tracking with partner code ");
            sb2.append(this.f6106g);
            C2735p.m6313a("[SUCCESS] ", sb2.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo29064a() {
        return this.f6105f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo29065b() {
        MoatOptions moatOptions = this.f6107h;
        return moatOptions != null && moatOptions.disableLocationServices;
    }

    /* renamed from: c */
    public void mo29066c() {
        C2726m.m6273a();
        C2732o.m6286a();
        if (this.f6106g != null) {
            try {
                m6258e();
            } catch (Exception e) {
                C2726m.m6274a(e);
            }
        }
    }

    /* renamed from: d */
    public void mo29067d() {
    }

    @UiThread
    public void prepareNativeDisplayTracking(String str) {
        this.f6106g = str;
        if (C2750w.m6348a().f6155a != C2758d.OFF) {
            try {
                m6258e();
            } catch (Exception e) {
                C2726m.m6274a(e);
            }
        }
    }

    public void start(Application application) {
        start(new MoatOptions(), application);
    }

    public void start(MoatOptions moatOptions, Application application) {
        try {
            m6257a(moatOptions, application);
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
    }
}
