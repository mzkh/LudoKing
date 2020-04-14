package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.facebook.internal.AnalyticsEvents;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.moat.analytics.mobile.inm.b */
abstract class C2701b {

    /* renamed from: a */
    C2726m f6015a = null;

    /* renamed from: b */
    WeakReference<WebView> f6016b;

    /* renamed from: c */
    C2719j f6017c;

    /* renamed from: d */
    TrackerListener f6018d;

    /* renamed from: e */
    final String f6019e;

    /* renamed from: f */
    final boolean f6020f;

    /* renamed from: g */
    private WeakReference<View> f6021g;

    /* renamed from: h */
    private final C2765z f6022h;

    /* renamed from: i */
    private final boolean f6023i;

    /* renamed from: j */
    private boolean f6024j;

    /* renamed from: k */
    private boolean f6025k;

    C2701b(@Nullable View view, boolean z, boolean z2) {
        String str;
        C2735p.m6310a(3, "BaseTracker", (Object) this, "Initializing.");
        if (z) {
            StringBuilder sb = new StringBuilder("m");
            sb.append(hashCode());
            str = sb.toString();
        } else {
            str = "";
        }
        this.f6019e = str;
        this.f6021g = new WeakReference<>(view);
        this.f6023i = z;
        this.f6020f = z2;
        this.f6024j = false;
        this.f6025k = false;
        this.f6022h = new C2765z();
    }

    /* renamed from: i */
    private void mo29020i() {
        String str;
        String str2 = "BaseTracker";
        C2735p.m6310a(3, str2, (Object) this, "Attempting bridge installation.");
        if (this.f6016b.get() != null) {
            this.f6017c = new C2719j((WebView) this.f6016b.get(), C2723a.WEBVIEW);
            str = "Bridge installed.";
        } else {
            this.f6017c = null;
            str = "Bridge not installed, WebView is null.";
        }
        C2735p.m6310a(3, str2, (Object) this, str);
    }

    /* renamed from: j */
    private void mo29021j() {
        if (this.f6024j) {
            throw new C2726m("Tracker already started");
        }
    }

    /* renamed from: k */
    private void mo29022k() {
        if (this.f6025k) {
            throw new C2726m("Tracker already stopped");
        }
    }

    /* renamed from: l */
    private boolean mo29023l() {
        return this.f6023i || this.f6020f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract String mo28998a();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28999a(WebView webView) {
        if (webView != null) {
            this.f6016b = new WeakReference<>(webView);
            if (this.f6017c == null && !mo29023l()) {
                mo29020i();
            }
            C2719j jVar = this.f6017c;
            if (jVar != null) {
                jVar.mo29051a(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29000a(C2719j jVar) {
        this.f6017c = jVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29001a(String str, Exception exc) {
        try {
            C2726m.m6274a(exc);
            String a = C2726m.m6272a(str, exc);
            if (this.f6018d != null) {
                this.f6018d.onTrackingFailedToStart(a);
            }
            C2735p.m6310a(3, "BaseTracker", (Object) this, a);
            StringBuilder sb = new StringBuilder();
            sb.append(mo28998a());
            sb.append(" ");
            sb.append(a);
            C2735p.m6313a("[ERROR] ", sb.toString());
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    @CallSuper
    /* renamed from: a */
    public void mo29002a(List<String> list) {
        if (mo29008f() == null && !this.f6020f) {
            list.add("Tracker's target view is null");
        }
        if (!list.isEmpty()) {
            throw new C2726m(TextUtils.join(" and ", list));
        }
    }

    /* access modifiers changed from: 0000 */
    @CallSuper
    /* renamed from: b */
    public void mo29003b() {
        String str = "BaseTracker";
        C2735p.m6310a(3, str, (Object) this, "Attempting to start impression.");
        mo29004c();
        mo29006d();
        mo29002a((List<String>) new ArrayList<String>());
        C2719j jVar = this.f6017c;
        if (jVar != null) {
            jVar.mo29055b(this);
            this.f6024j = true;
            C2735p.m6310a(3, str, (Object) this, "Impression started.");
            return;
        }
        C2735p.m6310a(3, str, (Object) this, "Bridge is null, won't start tracking");
        throw new C2726m("Bridge is null");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo29004c() {
        if (this.f6015a != null) {
            StringBuilder sb = new StringBuilder("Tracker initialization failed: ");
            sb.append(this.f6015a.getMessage());
            throw new C2726m(sb.toString());
        }
    }

    @CallSuper
    public void changeTargetView(View view) {
        StringBuilder sb = new StringBuilder("changing view to ");
        sb.append(C2735p.m6308a(view));
        C2735p.m6310a(3, "BaseTracker", (Object) this, sb.toString());
        this.f6021g = new WeakReference<>(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo29006d() {
        mo29021j();
        mo29022k();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo29007e() {
        return this.f6024j && !this.f6025k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public View mo29008f() {
        return (View) this.f6021g.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public String mo29009g() {
        return C2735p.m6308a(mo29008f());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public String mo29010h() {
        this.f6022h.mo29095a(this.f6019e, mo29008f());
        return this.f6022h.f6195a;
    }

    public void removeListener() {
        this.f6018d = null;
    }

    @Deprecated
    public void setActivity(Activity activity) {
    }

    public void setListener(TrackerListener trackerListener) {
        this.f6018d = trackerListener;
    }

    public void startTracking() {
        String str = "BaseTracker";
        try {
            C2735p.m6310a(3, str, (Object) this, "In startTracking method.");
            mo29003b();
            if (this.f6018d != null) {
                TrackerListener trackerListener = this.f6018d;
                StringBuilder sb = new StringBuilder("Tracking started on ");
                sb.append(mo29009g());
                trackerListener.onTrackingStarted(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder("startTracking succeeded for ");
            sb2.append(mo29009g());
            String sb3 = sb2.toString();
            C2735p.m6310a(3, str, (Object) this, sb3);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(mo28998a());
            sb4.append(" ");
            sb4.append(sb3);
            C2735p.m6313a("[SUCCESS] ", sb4.toString());
        } catch (Exception e) {
            mo29001a("startTracking", e);
        }
    }

    @CallSuper
    public void stopTracking() {
        String str = "BaseTracker";
        boolean z = false;
        try {
            C2735p.m6310a(3, str, (Object) this, "In stopTracking method.");
            this.f6025k = true;
            if (this.f6017c != null) {
                this.f6017c.mo29057c(this);
                z = true;
            }
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
        StringBuilder sb = new StringBuilder("Attempt to stop tracking ad impression was ");
        String str2 = "";
        sb.append(z ? str2 : "un");
        sb.append("successful.");
        C2735p.m6310a(3, str, (Object) this, sb.toString());
        String str3 = z ? "[SUCCESS] " : "[ERROR] ";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo28998a());
        sb2.append(" stopTracking ");
        sb2.append(z ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
        sb2.append(" for ");
        sb2.append(mo29009g());
        C2735p.m6313a(str3, sb2.toString());
        TrackerListener trackerListener = this.f6018d;
        if (trackerListener != null) {
            trackerListener.onTrackingStopped(str2);
            this.f6018d = null;
        }
    }
}
