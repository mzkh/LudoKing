package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdm implements ActivityLifecycleCallbacks {
    private final Application zzxh;
    private final WeakReference<ActivityLifecycleCallbacks> zzxi;
    private boolean zzxj = false;

    public zzdm(Application application, ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzxi = new WeakReference<>(activityLifecycleCallbacks);
        this.zzxh = application;
    }

    private final void zza(zzdu zzdu) {
        try {
            ActivityLifecycleCallbacks activityLifecycleCallbacks = (ActivityLifecycleCallbacks) this.zzxi.get();
            if (activityLifecycleCallbacks != null) {
                zzdu.zza(activityLifecycleCallbacks);
                return;
            }
            if (!this.zzxj) {
                this.zzxh.unregisterActivityLifecycleCallbacks(this);
                this.zzxj = true;
            }
        } catch (Exception unused) {
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzdl(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzdo(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzdn(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzdq(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzdp(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzds(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzdr(this, activity));
    }
}
