package com.moat.analytics.mobile.inm;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.moat.analytics.mobile.inm.p037a.p039b.C2698a;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.inm.n */
class C2727n extends MoatFactory {
    C2727n() {
        if (!m6281a()) {
            String str = "Failed to initialize MoatFactory";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(", SDK was not started");
            C2735p.m6311a("[ERROR] ", 3, "Factory", this, sb.toString());
            throw new C2726m(str);
        }
    }

    /* renamed from: a */
    private NativeDisplayTracker m6276a(View view, final Map<String, String> map) {
        final WeakReference weakReference = new WeakReference(view);
        return (NativeDisplayTracker) C2760x.m6369a((C2762a<T>) new C2762a<NativeDisplayTracker>() {
            /* renamed from: a */
            public C2698a<NativeDisplayTracker> mo28975a() {
                View view = (View) weakReference.get();
                StringBuilder sb = new StringBuilder("Attempting to create NativeDisplayTracker for ");
                sb.append(C2735p.m6308a(view));
                C2735p.m6311a("[INFO] ", 3, "Factory", this, sb.toString());
                return C2698a.m6151a(new C2742t(view, map));
            }
        }, NativeDisplayTracker.class);
    }

    /* renamed from: a */
    private NativeVideoTracker m6277a(final String str) {
        return (NativeVideoTracker) C2760x.m6369a((C2762a<T>) new C2762a<NativeVideoTracker>() {
            /* renamed from: a */
            public C2698a<NativeVideoTracker> mo28975a() {
                C2735p.m6311a("[INFO] ", 3, "Factory", this, "Attempting to create NativeVideoTracker");
                return C2698a.m6151a(new C2743u(str));
            }
        }, NativeVideoTracker.class);
    }

    /* renamed from: a */
    private WebAdTracker m6278a(ViewGroup viewGroup) {
        final WeakReference weakReference = new WeakReference(viewGroup);
        return (WebAdTracker) C2760x.m6369a((C2762a<T>) new C2762a<WebAdTracker>() {
            /* renamed from: a */
            public C2698a<WebAdTracker> mo28975a() {
                ViewGroup viewGroup = (ViewGroup) weakReference.get();
                StringBuilder sb = new StringBuilder("Attempting to create WebAdTracker for adContainer ");
                sb.append(C2735p.m6308a((View) viewGroup));
                C2735p.m6311a("[INFO] ", 3, "Factory", this, sb.toString());
                return C2698a.m6151a(new C2699aa(viewGroup));
            }
        }, WebAdTracker.class);
    }

    /* renamed from: a */
    private WebAdTracker m6279a(WebView webView) {
        final WeakReference weakReference = new WeakReference(webView);
        return (WebAdTracker) C2760x.m6369a((C2762a<T>) new C2762a<WebAdTracker>() {
            /* renamed from: a */
            public C2698a<WebAdTracker> mo28975a() {
                WebView webView = (WebView) weakReference.get();
                StringBuilder sb = new StringBuilder("Attempting to create WebAdTracker for ");
                sb.append(C2735p.m6308a((View) webView));
                C2735p.m6311a("[INFO] ", 3, "Factory", this, sb.toString());
                return C2698a.m6151a(new C2699aa(webView));
            }
        }, WebAdTracker.class);
    }

    /* renamed from: a */
    private <T> T m6280a(MoatPlugin<T> moatPlugin) {
        return moatPlugin.mo28945a();
    }

    /* renamed from: a */
    private boolean m6281a() {
        return ((C2724k) C2724k.getInstance()).mo29064a();
    }

    public <T> T createCustomTracker(MoatPlugin<T> moatPlugin) {
        try {
            return m6280a(moatPlugin);
        } catch (Exception e) {
            C2726m.m6274a(e);
            return moatPlugin.mo28946b();
        }
    }

    public NativeDisplayTracker createNativeDisplayTracker(@NonNull View view, @NonNull Map<String, String> map) {
        try {
            return m6276a(view, map);
        } catch (Exception e) {
            C2726m.m6274a(e);
            return new C2747c();
        }
    }

    public NativeVideoTracker createNativeVideoTracker(String str) {
        try {
            return m6277a(str);
        } catch (Exception e) {
            C2726m.m6274a(e);
            return new C2748d();
        }
    }

    public WebAdTracker createWebAdTracker(@NonNull ViewGroup viewGroup) {
        try {
            return m6278a(viewGroup);
        } catch (Exception e) {
            C2726m.m6274a(e);
            return new C2749e();
        }
    }

    public WebAdTracker createWebAdTracker(@NonNull WebView webView) {
        try {
            return m6279a(webView);
        } catch (Exception e) {
            C2726m.m6274a(e);
            return new C2749e();
        }
    }
}
