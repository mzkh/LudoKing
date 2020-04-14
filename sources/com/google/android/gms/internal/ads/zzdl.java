package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdl implements zzdu {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzxg;

    zzdl(zzdm zzdm, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzxg = bundle;
    }

    public final void zza(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.val$activity, this.zzxg);
    }
}
