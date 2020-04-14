package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.sdk.utils.C1239a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.a */
public class C1061a implements ActivityLifecycleCallbacks {

    /* renamed from: a */
    private final List<C1239a> f2099a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b */
    private WeakReference<Activity> f2100b = new WeakReference<>(null);

    public C1061a(Context context) {
        if (context instanceof Activity) {
            this.f2100b = new WeakReference<>((Activity) context);
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
    }

    /* renamed from: a */
    public Activity mo9735a() {
        return (Activity) this.f2100b.get();
    }

    /* renamed from: a */
    public void mo9736a(C1239a aVar) {
        this.f2099a.add(aVar);
    }

    /* renamed from: b */
    public void mo9737b(C1239a aVar) {
        this.f2099a.remove(aVar);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        for (C1239a onActivityCreated : new ArrayList(this.f2099a)) {
            onActivityCreated.onActivityCreated(activity, bundle);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        for (C1239a onActivityDestroyed : new ArrayList(this.f2099a)) {
            onActivityDestroyed.onActivityDestroyed(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        for (C1239a onActivityPaused : new ArrayList(this.f2099a)) {
            onActivityPaused.onActivityPaused(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        this.f2100b = new WeakReference<>(activity);
        for (C1239a onActivityResumed : new ArrayList(this.f2099a)) {
            onActivityResumed.onActivityResumed(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        for (C1239a onActivitySaveInstanceState : new ArrayList(this.f2099a)) {
            onActivitySaveInstanceState.onActivitySaveInstanceState(activity, bundle);
        }
    }

    public void onActivityStarted(Activity activity) {
        for (C1239a onActivityStarted : new ArrayList(this.f2099a)) {
            onActivityStarted.onActivityStarted(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        for (C1239a onActivityStopped : new ArrayList(this.f2099a)) {
            onActivityStopped.onActivityStopped(activity);
        }
    }
}
