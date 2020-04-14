package com.inmobi.media;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.Builder;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.inmobi.media.cg */
/* compiled from: PicassoWrapper */
public class C2277cg {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f4783a = "cg";
    /* access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b */
    public static volatile Picasso f4784b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Object f4785c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static List<WeakReference<Context>> f4786d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static ActivityLifecycleCallbacks f4787e = new ActivityLifecycleCallbacks() {
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivityDestroyed(Activity activity) {
            synchronized (C2277cg.f4785c) {
                if (C2277cg.f4784b != null && C2277cg.m4622c(activity)) {
                    activity.getApplication().unregisterActivityLifecycleCallbacks(C2277cg.f4787e);
                    C2277cg.f4786d.remove(activity);
                    if (C2277cg.f4786d.isEmpty()) {
                        C2277cg.f4783a;
                        C2277cg.f4784b;
                        C2277cg.f4784b.shutdown();
                        C2277cg.f4784b = null;
                    }
                }
            }
        }
    };

    /* renamed from: a */
    public static Picasso m4616a(Context context) {
        synchronized (f4785c) {
            if (!m4622c(context)) {
                f4786d.add(new WeakReference(context));
            }
            if (f4784b == null) {
                f4784b = new Builder(context).build();
                C2505gd.m5286a(context, f4787e);
            }
        }
        return f4784b;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m4622c(Context context) {
        for (int i = 0; i < f4786d.size(); i++) {
            Context context2 = (Context) ((WeakReference) f4786d.get(i)).get();
            if (context2 != null && context2.equals(context)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static Object m4618a(InvocationHandler invocationHandler) {
        try {
            Class cls = Class.forName("com.squareup.picasso.Callback");
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler);
        } catch (Exception unused) {
            return null;
        }
    }
}
