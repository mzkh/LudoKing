package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdActivity;
import com.moat.analytics.mobile.inm.p037a.p039b.C2698a;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.inm.f */
class C2706f {
    @Nullable

    /* renamed from: a */
    private static WebAdTracker f6038a;

    /* renamed from: b */
    private static WeakReference<Activity> f6039b = new WeakReference<>(null);

    C2706f() {
    }

    /* renamed from: a */
    private static void m6189a() {
        if (f6038a != null) {
            C2735p.m6310a(3, "GMAInterstitialHelper", f6039b.get(), "Stopping to track GMA interstitial");
            f6038a.stopTracking();
            f6038a = null;
        }
    }

    /* renamed from: a */
    static void m6190a(Activity activity) {
        try {
            if (C2750w.m6348a().f6155a != C2758d.OFF) {
                if (!m6192b(activity)) {
                    m6189a();
                    f6039b = new WeakReference<>(null);
                } else if (f6039b.get() == null || f6039b.get() != activity) {
                    View decorView = activity.getWindow().getDecorView();
                    if (decorView instanceof ViewGroup) {
                        C2698a a = C2700ab.m6157a((ViewGroup) decorView, true);
                        if (a.mo28994c()) {
                            f6039b = new WeakReference<>(activity);
                            m6191a((WebView) a.mo28992b());
                            return;
                        }
                        C2735p.m6310a(3, "GMAInterstitialHelper", (Object) activity, "Sorry, no WebView in this activity");
                    }
                }
            }
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
    }

    /* renamed from: a */
    private static void m6191a(WebView webView) {
        C2735p.m6310a(3, "GMAInterstitialHelper", f6039b.get(), "Starting to track GMA interstitial");
        WebAdTracker createWebAdTracker = MoatFactory.create().createWebAdTracker(webView);
        f6038a = createWebAdTracker;
        createWebAdTracker.startTracking();
    }

    /* renamed from: b */
    private static boolean m6192b(Activity activity) {
        String name = activity.getClass().getName();
        String str = "GMAInterstitialHelper";
        C2735p.m6310a(3, str, (Object) activity, "Activity name: ".concat(String.valueOf(name)));
        return name.contains(AdActivity.CLASS_NAME);
    }
}
