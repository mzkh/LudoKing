package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.b */
public final class C1809b {

    /* renamed from: a */
    private static Application f3769a;

    /* renamed from: b */
    private static int f3770b;

    /* renamed from: c */
    private static final C2915by f3771c = new C2915by();

    /* renamed from: d */
    private static final Set f3772d = Collections.synchronizedSet(new C2887ay());

    /* renamed from: e */
    private static final C2915by f3773e = new C2915by();

    /* renamed from: b */
    public static boolean m3454b() {
        return f3770b > 0;
    }

    @Nullable
    /* renamed from: c */
    public static Activity m3455c() {
        Activity activity;
        Activity activity2 = (Activity) f3771c.mo29904a();
        if (activity2 != null) {
            return activity2;
        }
        synchronized (f3772d) {
            activity = (Activity) C3228jt.m7502a(f3772d.iterator());
        }
        return activity;
    }

    /* renamed from: a */
    public static void m3451a(Activity activity) {
        f3771c.mo29905a(activity);
    }

    /* renamed from: a */
    public static synchronized void m3452a(Application application) {
        synchronized (C1809b.class) {
            if (f3769a != application) {
                f3769a = application;
            }
        }
    }

    /* renamed from: b */
    public static void m3453b(Activity activity) {
        f3770b++;
        f3771c.mo29905a(activity);
        f3772d.add(activity);
    }

    /* renamed from: c */
    public static void m3456c(Activity activity) {
        f3770b--;
        f3771c.f6741a = null;
        f3772d.remove(activity);
        if (f3770b < 0) {
            f3770b = 0;
        }
    }

    @Nullable
    /* renamed from: a */
    public static Activity m3450a() {
        Activity activity = (Activity) f3773e.mo29904a();
        return activity == null ? m3455c() : activity;
    }
}
