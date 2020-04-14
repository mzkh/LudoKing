package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.inm.a */
class C2695a {

    /* renamed from: a */
    static WeakReference<Activity> f6007a = null;

    /* renamed from: b */
    private static boolean f6008b = false;

    /* renamed from: c */
    private static Application f6009c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static int f6010d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static boolean f6011e = false;

    /* renamed from: com.moat.analytics.mobile.inm.a$a */
    static class C2696a implements ActivityLifecycleCallbacks {
        C2696a() {
        }

        /* renamed from: a */
        private static void m6148a(boolean z) {
            String str = "ActivityState";
            if (z) {
                C2735p.m6310a(3, str, (Object) null, "App became visible");
                if (C2750w.m6348a().f6155a == C2758d.ON && !((C2724k) MoatAnalytics.getInstance()).f6102c) {
                    C2732o.m6286a().mo29074c();
                }
            } else {
                C2735p.m6310a(3, str, (Object) null, "App became invisible");
                if (C2750w.m6348a().f6155a == C2758d.ON && !((C2724k) MoatAnalytics.getInstance()).f6102c) {
                    C2732o.m6286a().mo29075d();
                }
            }
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            C2695a.f6010d = 1;
        }

        public void onActivityDestroyed(Activity activity) {
            try {
                if (!(C2695a.f6010d == 3 || C2695a.f6010d == 5)) {
                    if (C2695a.f6011e) {
                        m6148a(false);
                    }
                    C2695a.f6011e = false;
                }
                C2695a.f6010d = 6;
                StringBuilder sb = new StringBuilder("Activity destroyed: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C2735p.m6310a(3, "ActivityState", (Object) this, sb.toString());
                if (C2695a.m6146b(activity)) {
                    C2695a.f6007a = new WeakReference<>(null);
                }
            } catch (Exception e) {
                C2726m.m6274a(e);
            }
        }

        public void onActivityPaused(Activity activity) {
            try {
                C2695a.f6010d = 4;
                if (C2695a.m6146b(activity)) {
                    C2695a.f6007a = new WeakReference<>(null);
                }
                StringBuilder sb = new StringBuilder("Activity paused: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C2735p.m6310a(3, "ActivityState", (Object) this, sb.toString());
            } catch (Exception e) {
                C2726m.m6274a(e);
            }
        }

        public void onActivityResumed(Activity activity) {
            try {
                C2695a.f6007a = new WeakReference<>(activity);
                C2695a.f6010d = 3;
                C2750w.m6348a().mo29088b();
                StringBuilder sb = new StringBuilder("Activity resumed: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C2735p.m6310a(3, "ActivityState", (Object) this, sb.toString());
                if (((C2724k) MoatAnalytics.getInstance()).f6101b) {
                    C2706f.m6190a(activity);
                }
            } catch (Exception e) {
                C2726m.m6274a(e);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            try {
                C2695a.f6007a = new WeakReference<>(activity);
                C2695a.f6010d = 2;
                if (!C2695a.f6011e) {
                    m6148a(true);
                }
                C2695a.f6011e = true;
                StringBuilder sb = new StringBuilder("Activity started: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C2735p.m6310a(3, "ActivityState", (Object) this, sb.toString());
            } catch (Exception e) {
                C2726m.m6274a(e);
            }
        }

        public void onActivityStopped(Activity activity) {
            try {
                if (C2695a.f6010d != 3) {
                    C2695a.f6011e = false;
                    m6148a(false);
                }
                C2695a.f6010d = 5;
                if (C2695a.m6146b(activity)) {
                    C2695a.f6007a = new WeakReference<>(null);
                }
                StringBuilder sb = new StringBuilder("Activity stopped: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C2735p.m6310a(3, "ActivityState", (Object) this, sb.toString());
            } catch (Exception e) {
                C2726m.m6274a(e);
            }
        }
    }

    C2695a() {
    }

    /* renamed from: a */
    static Application m6141a() {
        return f6009c;
    }

    /* renamed from: a */
    static void m6142a(Application application) {
        f6009c = application;
        if (!f6008b) {
            f6008b = true;
            f6009c.registerActivityLifecycleCallbacks(new C2696a());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m6146b(Activity activity) {
        WeakReference<Activity> weakReference = f6007a;
        return weakReference != null && weakReference.get() == activity;
    }
}
