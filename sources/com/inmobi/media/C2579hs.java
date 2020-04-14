package com.inmobi.media;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.inmobi.media.C2507gf.C2512c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* renamed from: com.inmobi.media.hs */
/* compiled from: UnifiedSdk */
public final class C2579hs {
    @VisibleForTesting

    /* renamed from: a */
    public static boolean f5694a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f5695b = "hs";

    /* renamed from: b */
    public static void m5622b(@NonNull Context context) {
        if (!f5694a) {
            C2438es.m5089a();
            C2497ga.m5260a().mo28448c();
            if (C2506ge.m5321b(context) && C2541gz.m5445b(context).isEmpty()) {
                C2506ge.m5319a(context, false);
            }
            C2534gu.m5409a();
            m5625e();
            C2505gd.m5290a((Runnable) new Runnable() {
                public final void run() {
                    try {
                        C2172ao.m4371a().mo27897b();
                        C2172ao.m4371a().mo27899d();
                    } catch (Exception unused) {
                        C2579hs.f5695b;
                    }
                }
            });
            C2507gf a = C2507gf.m5325a();
            if (a != null) {
                C2507gf.f5503a.add(new C2512c() {
                    /* renamed from: a */
                    public final void mo28465a(boolean z) {
                        C2505gd.m5296b(z);
                        if (z) {
                            try {
                                C2579hs.m5625e();
                            } catch (Exception unused) {
                                C2579hs.f5695b;
                                C2514gh.m5342a(2, C2579hs.f5695b, "SDK encountered an unexpected error; some components may not work as advertised");
                            }
                        } else {
                            C2579hs.m5618a();
                        }
                    }
                });
                if (C2507gf.f5503a.size() == 1 && C2505gd.m5292a()) {
                    HandlerThread handlerThread = new HandlerThread("ApplicationFocusChangeObserverHandler");
                    C2507gf.f5504b = handlerThread;
                    handlerThread.start();
                    Application application = (Application) C2505gd.m5298c();
                    if (application != null) {
                        try {
                            application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {

                                /* renamed from: b */
                                private final Handler f5508b = new C2510a(C2507gf.f5504b.getLooper());

                                /* renamed from: c */
                                private WeakReference<Activity> f5509c;

                                public final void onActivityCreated(Activity activity, Bundle bundle) {
                                }

                                public final void onActivityDestroyed(Activity activity) {
                                }

                                public final void onActivityPaused(Activity activity) {
                                }

                                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                                }

                                /* renamed from: a */
                                private void m5333a(Activity activity) {
                                    WeakReference<Activity> weakReference = this.f5509c;
                                    if (weakReference == null || weakReference.get() != activity) {
                                        this.f5509c = new WeakReference<>(activity);
                                    }
                                    this.f5508b.removeMessages(1001);
                                    this.f5508b.sendEmptyMessage(1002);
                                }

                                public final void onActivityStarted(Activity activity) {
                                    m5333a(activity);
                                }

                                public final void onActivityResumed(Activity activity) {
                                    m5333a(activity);
                                }

                                public final void onActivityStopped(Activity activity) {
                                    WeakReference<Activity> weakReference = this.f5509c;
                                    if (weakReference == null || weakReference.get() == activity) {
                                        this.f5508b.sendEmptyMessageDelayed(1001, 3000);
                                    }
                                }
                            });
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            f5694a = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static void m5625e() {
        try {
            C2505gd.m5290a((Runnable) new Runnable() {
                public final void run() {
                    try {
                        C2538gx.m5429a().mo28479b();
                        C2438es.m5089a();
                        C2185as.m4434a().mo27910b();
                        C2463fd a = C2463fd.m5161a();
                        C2463fd.f5358b.set(false);
                        a.f5361c = (C2449ey) C2438es.m5087a("crashReporting", C2505gd.m5306f(), a);
                        a.f5362d = a.f5361c.f5280a;
                        a.f5362d = a.f5361c.f5280a;
                        a.f5360a.execute(new Runnable() {
                            public final void run() {
                                C2463fd.this.f5360a.execute(new Runnable() {
                                    public final void run() {
                                        if (C2463fd.this.f5363f.mo28387a() > 0) {
                                            C2463fd.m5163a(C2463fd.this);
                                        }
                                    }
                                });
                            }
                        });
                        C2497ga.m5260a().mo28448c();
                        C2568hj.m5581a().mo28567b();
                        C2172ao.m4371a().mo27897b();
                        C2497ga.m5260a().mo28447a("SessionStarted", new HashMap());
                    } catch (Exception unused) {
                        C2579hs.f5695b;
                        C2514gh.m5342a(2, C2579hs.f5695b, "SDK encountered unexpected error while starting internal components");
                    }
                }
            });
        } catch (Exception unused) {
            C2514gh.m5342a(2, f5695b, "SDK encountered unexpected error while starting internal components");
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    public static void m5618a() {
        try {
            C2505gd.m5290a((Runnable) new Runnable() {
                public final void run() {
                    try {
                        C2438es.m5093b();
                        C2497ga a = C2497ga.m5260a();
                        C2497ga.f5475b.set(true);
                        a.f5479a.execute(new Runnable() {
                            public final void run() {
                                if (C2497ga.this.f5483i != null) {
                                    C2474fk b = C2497ga.this.f5483i;
                                    if (b.f5400e != null) {
                                        b.f5400e.shutdownNow();
                                        b.f5400e = null;
                                    }
                                    b.f5396a.set(false);
                                    b.f5397b.set(true);
                                    b.f5399d.clear();
                                    b.f5398c.clear();
                                    C2497ga.this.f5483i = null;
                                }
                            }
                        });
                        C2568hj.m5581a().mo28568c();
                        C2172ao.m4371a().mo27898c();
                    } catch (Exception unused) {
                        C2579hs.f5695b;
                        C2514gh.m5342a(1, C2579hs.f5695b, "SDK encountered unexpected error while stopping internal components");
                    }
                }
            });
        } catch (Exception unused) {
            C2514gh.m5342a(1, f5695b, "SDK encountered unexpected error while stopping internal components");
        }
    }

    /* renamed from: a */
    public static void m5620a(C2578hq hqVar) {
        try {
            C2505gd.m5313k();
            Context c = C2505gd.m5298c();
            if (c != null) {
                File file = new File(C2505gd.m5299c(c), "asConfigs");
                if (file.exists()) {
                    file.delete();
                }
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                objectOutputStream.writeObject(hqVar);
                objectOutputStream.close();
            }
        } catch (IOException unused) {
        }
    }

    @Nullable
    /* renamed from: b */
    public static C2578hq m5621b() {
        try {
            if (C2505gd.m5298c() == null) {
                return null;
            }
            File file = new File(C2505gd.m5299c(C2505gd.m5298c()), "asConfigs");
            if (!file.exists()) {
                return null;
            }
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            C2578hq hqVar = (C2578hq) objectInputStream.readObject();
            try {
                objectInputStream.close();
            } catch (IOException | ClassNotFoundException unused) {
            }
            return hqVar;
        } catch (IOException | ClassNotFoundException unused2) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m5619a(@NonNull Context context) {
        if (C2506ge.m5317a(context) == null || !C2506ge.m5317a(context).equals(C2506ge.m5320b())) {
            C2506ge.m5319a(context, C2541gz.m5443a(context));
            C2506ge.m5318a(context, C2506ge.m5320b());
            final Context applicationContext = context.getApplicationContext();
            final File b = C2505gd.m5293b(applicationContext);
            final File c = C2505gd.m5299c(applicationContext);
            C2505gd.m5290a((Runnable) new Runnable() {
                public final void run() {
                    C2505gd.m5289a(b, (String) null);
                    C2505gd.m5289a(c, (String) null);
                    C2505gd.m5302d(applicationContext);
                }
            });
            if (!b.mkdir()) {
                b.isDirectory();
            }
            if (!c.mkdir()) {
                c.isDirectory();
            }
        }
    }
}
