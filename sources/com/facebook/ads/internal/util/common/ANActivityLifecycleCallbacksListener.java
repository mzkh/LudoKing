package com.facebook.ads.internal.util.common;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

@Keep
public class ANActivityLifecycleCallbacksListener implements ActivityLifecycleCallbacks {
    public static final int ACTIVITY_CREATED = 1;
    public static final int ACTIVITY_DESTROYED = 6;
    public static final int ACTIVITY_PAUSED = 4;
    public static final int ACTIVITY_RESUMED = 3;
    public static final int ACTIVITY_STARTED = 2;
    public static final int ACTIVITY_STOPPED = 5;
    @Nullable
    private static ANActivityLifecycleCallbacksListener sANActivityLifecycleCallbacksListener;
    private static final Map<Activity, Integer> sActivityStateMap = Collections.synchronizedMap(new WeakHashMap());

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        sActivityStateMap.put(activity, Integer.valueOf(1));
    }

    public void onActivityStarted(Activity activity) {
        sActivityStateMap.put(activity, Integer.valueOf(2));
    }

    public void onActivityResumed(Activity activity) {
        sActivityStateMap.put(activity, Integer.valueOf(3));
    }

    public void onActivityPaused(Activity activity) {
        sActivityStateMap.put(activity, Integer.valueOf(4));
    }

    public void onActivityStopped(Activity activity) {
        sActivityStateMap.put(activity, Integer.valueOf(5));
    }

    public void onActivityDestroyed(Activity activity) {
        sActivityStateMap.put(activity, Integer.valueOf(6));
    }

    public Map<Activity, Integer> getActivityStateMap() {
        return sActivityStateMap;
    }

    public static void registerActivityCallbacks(Context context) {
        Context applicationContext = context.getApplicationContext();
        synchronized (ANActivityLifecycleCallbacksListener.class) {
            if ((applicationContext instanceof Application) && sANActivityLifecycleCallbacksListener == null) {
                sANActivityLifecycleCallbacksListener = new ANActivityLifecycleCallbacksListener();
                ((Application) applicationContext).registerActivityLifecycleCallbacks(sANActivityLifecycleCallbacksListener);
            }
        }
    }

    @Nullable
    public static synchronized ANActivityLifecycleCallbacksListener getANActivityLifecycleCallbacksListener() {
        ANActivityLifecycleCallbacksListener aNActivityLifecycleCallbacksListener;
        synchronized (ANActivityLifecycleCallbacksListener.class) {
            aNActivityLifecycleCallbacksListener = sANActivityLifecycleCallbacksListener;
        }
        return aNActivityLifecycleCallbacksListener;
    }

    public static void unregisterActivityCallbacks(Context context) {
        Context applicationContext = context.getApplicationContext();
        synchronized (ANActivityLifecycleCallbacksListener.class) {
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(sANActivityLifecycleCallbacksListener);
                sANActivityLifecycleCallbacksListener = null;
            }
        }
    }
}
