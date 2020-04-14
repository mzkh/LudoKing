package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzds implements zzdu {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzxg;

    zzds(zzdm zzdm, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzxg = bundle;
    }

    public final void zza(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.val$activity, this.zzxg);
    }
}
