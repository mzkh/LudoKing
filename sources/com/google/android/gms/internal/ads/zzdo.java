package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdo implements zzdu {
    private final /* synthetic */ Activity val$activity;

    zzdo(zzdm zzdm, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.val$activity);
    }
}
