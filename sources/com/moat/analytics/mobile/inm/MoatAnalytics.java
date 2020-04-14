package com.moat.analytics.mobile.inm;

import android.app.Application;
import androidx.annotation.UiThread;
import com.moat.analytics.mobile.inm.C2744v.C2745a;

public abstract class MoatAnalytics {

    /* renamed from: a */
    private static MoatAnalytics f6004a;

    public static synchronized MoatAnalytics getInstance() {
        MoatAnalytics moatAnalytics;
        synchronized (MoatAnalytics.class) {
            if (f6004a == null) {
                try {
                    f6004a = new C2724k();
                } catch (Exception e) {
                    C2726m.m6274a(e);
                    f6004a = new C2745a();
                }
            }
            moatAnalytics = f6004a;
        }
        return moatAnalytics;
    }

    @UiThread
    public abstract void prepareNativeDisplayTracking(String str);

    public abstract void start(Application application);

    public abstract void start(MoatOptions moatOptions, Application application);
}
