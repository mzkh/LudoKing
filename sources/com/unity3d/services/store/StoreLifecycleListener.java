package com.unity3d.services.store;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.util.ArrayList;

@TargetApi(14)
public class StoreLifecycleListener implements ActivityLifecycleCallbacks {
    private ArrayList<String> _exceptions;
    private ArrayList<String> _purchaseTypes;
    private boolean _trackAllActivities;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public StoreLifecycleListener(boolean z, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this._trackAllActivities = z;
        this._exceptions = arrayList;
        this._purchaseTypes = arrayList2;
    }

    public void onActivityResumed(Activity activity) {
        ArrayList<String> arrayList = this._exceptions;
        boolean z = arrayList != null && arrayList.contains(activity.getLocalClassName());
        if (((this._trackAllActivities && !z) || (!this._trackAllActivities && z)) && this._purchaseTypes != null) {
            StoreMonitor.sendPurchaseStatusOnResume(activity.getLocalClassName(), this._purchaseTypes);
        }
    }

    public void onActivityStopped(Activity activity) {
        ArrayList<String> arrayList = this._exceptions;
        boolean z = arrayList != null && arrayList.contains(activity.getLocalClassName());
        if (((this._trackAllActivities && !z) || (!this._trackAllActivities && z)) && this._purchaseTypes != null) {
            StoreMonitor.sendPurchaseStatusOnStop(activity.getLocalClassName(), this._purchaseTypes);
        }
    }
}
