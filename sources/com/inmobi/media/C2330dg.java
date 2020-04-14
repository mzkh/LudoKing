package com.inmobi.media;

import android.app.Application;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.inm.MoatAnalytics;
import com.moat.analytics.mobile.inm.MoatFactory;
import com.moat.analytics.mobile.inm.MoatOptions;
import com.moat.analytics.mobile.inm.NativeDisplayTracker;
import com.moat.analytics.mobile.inm.ReactiveVideoTracker;
import com.moat.analytics.mobile.inm.ReactiveVideoTrackerPlugin;
import com.moat.analytics.mobile.inm.WebAdTracker;
import java.util.Map;

/* renamed from: com.inmobi.media.dg */
/* compiled from: InMobiMoatFactory */
public class C2330dg {

    /* renamed from: a */
    private static final String f4928a = "dg";

    /* renamed from: b */
    private static boolean f4929b = false;

    /* renamed from: a */
    public static void m4799a(Application application) {
        if (!f4929b) {
            try {
                MoatOptions moatOptions = new MoatOptions();
                boolean z = false;
                moatOptions.loggingEnabled = false;
                C2568hj.m5581a();
                if (!C2568hj.m5583e().f5327c) {
                    z = true;
                }
                moatOptions.disableLocationServices = z;
                Boolean f = C2538gx.m5429a().mo28482f();
                if (f == null || f.booleanValue()) {
                    moatOptions.disableAdIdCollection = true;
                }
                MoatAnalytics.getInstance().start(moatOptions, application);
                f4929b = true;
            } catch (Exception e) {
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            }
        }
    }

    /* renamed from: a */
    static WebAdTracker m4798a(Application application, WebView webView) {
        if (!f4929b) {
            m4799a(application);
        }
        return MoatFactory.create().createWebAdTracker(webView);
    }

    /* renamed from: a */
    static NativeDisplayTracker m4796a(Application application, String str, View view, Map<String, String> map) {
        if (!f4929b) {
            m4799a(application);
        }
        MoatAnalytics.getInstance().prepareNativeDisplayTracking(str);
        return MoatFactory.create().createNativeDisplayTracker(view, map);
    }

    /* renamed from: a */
    static ReactiveVideoTracker m4797a(Application application, String str) {
        if (!f4929b) {
            m4799a(application);
        }
        return (ReactiveVideoTracker) MoatFactory.create().createCustomTracker(new ReactiveVideoTrackerPlugin(str));
    }
}
