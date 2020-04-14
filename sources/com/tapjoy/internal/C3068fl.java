package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.tapjoy.internal.fl */
public final class C3068fl {

    /* renamed from: a */
    private static final C3068fl f7234a = new C3068fl();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Application f7235b;

    /* renamed from: c */
    private ActivityLifecycleCallbacks f7236c;

    /* renamed from: d */
    private final HashSet f7237d = new HashSet();

    /* renamed from: a */
    public static void m7092a(Context context) {
        if (VERSION.SDK_INT >= 14 && context != null) {
            C3068fl flVar = f7234a;
            Context applicationContext = context.getApplicationContext();
            if (flVar.f7235b == null) {
                try {
                    if (applicationContext instanceof Application) {
                        flVar.f7235b = (Application) applicationContext;
                    } else {
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        TapjoyUtil.runOnMainThread(new Runnable() {
                            public final void run() {
                                try {
                                    C3068fl.this.f7235b = C3068fl.m7093b();
                                } catch (Exception e) {
                                    TapjoyLog.m6555w("Tapjoy.ActivityTracker", Log.getStackTraceString(e));
                                } catch (Throwable th) {
                                    countDownLatch.countDown();
                                    throw th;
                                }
                                countDownLatch.countDown();
                            }
                        });
                        countDownLatch.await();
                    }
                } catch (Exception e) {
                    TapjoyLog.m6555w("Tapjoy.ActivityTracker", Log.getStackTraceString(e));
                }
                if (flVar.f7235b == null) {
                    return;
                }
            }
            synchronized (flVar) {
                if (flVar.f7236c == null) {
                    Activity c = C1809b.m3455c();
                    if (c != null) {
                        flVar.f7237d.add(m7094b(c));
                    }
                    final HashSet hashSet = flVar.f7237d;
                    flVar.f7236c = new ActivityLifecycleCallbacks() {
                        public final void onActivityCreated(Activity activity, Bundle bundle) {
                        }

                        public final void onActivityDestroyed(Activity activity) {
                        }

                        public final void onActivityPaused(Activity activity) {
                        }

                        public final void onActivityResumed(Activity activity) {
                        }

                        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        }

                        public final void onActivityStarted(Activity activity) {
                            hashSet.add(C3068fl.m7094b(activity));
                            if (hashSet.size() == 1) {
                                C3110gn.m7176a();
                            }
                            C1809b.m3451a(activity);
                        }

                        public final void onActivityStopped(Activity activity) {
                            hashSet.remove(C3068fl.m7094b(activity));
                            if (hashSet.size() <= 0) {
                                C3110gn.m7181b();
                            }
                        }
                    };
                    flVar.f7235b.registerActivityLifecycleCallbacks(flVar.f7236c);
                    C3110gn.m7176a();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m7091a() {
        if (VERSION.SDK_INT >= 14) {
            C3068fl flVar = f7234a;
            if (flVar.f7235b != null) {
                synchronized (flVar) {
                    if (flVar.f7236c != null) {
                        flVar.f7235b.unregisterActivityLifecycleCallbacks(flVar.f7236c);
                        flVar.f7236c = null;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m7094b(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append(activity.getClass().getName());
        sb.append("@");
        sb.append(System.identityHashCode(activity));
        return sb.toString();
    }

    /* renamed from: b */
    static /* synthetic */ Application m7093b() {
        return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
    }
}
