package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdn implements zzdu {
    private final /* synthetic */ Activity val$activity;

    zzdn(zzdm zzdm, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.val$activity);
    }
}
