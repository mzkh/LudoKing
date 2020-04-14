package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzpm implements ActivityLifecycleCallbacks {
    private final Application zzxh;
    private final WeakReference<ActivityLifecycleCallbacks> zzxi;
    private boolean zzxj = false;

    public zzpm(Application application, ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzxi = new WeakReference<>(activityLifecycleCallbacks);
        this.zzxh = application;
    }

    private final void zza(zzpu zzpu) {
        try {
            ActivityLifecycleCallbacks activityLifecycleCallbacks = (ActivityLifecycleCallbacks) this.zzxi.get();
            if (activityLifecycleCallbacks != null) {
                zzpu.zza(activityLifecycleCallbacks);
                return;
            }
            if (!this.zzxj) {
                this.zzxh.unregisterActivityLifecycleCallbacks(this);
                this.zzxj = true;
            }
        } catch (Exception e) {
            zzaug.zzc("Error while dispatching lifecycle callback.", e);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzpl(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzpo(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzpn(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzpq(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzpp(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzps(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzpr(this, activity));
    }
}
