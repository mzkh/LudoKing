package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import androidx.annotation.Nullable;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

final class ViewObserver implements OnGlobalLayoutListener {
    private static final int MAX_TEXT_LENGTH = 300;
    private static final String TAG = "com.facebook.appevents.suggestedevents.ViewObserver";
    private static final Map<Integer, ViewObserver> observers = new HashMap();
    /* access modifiers changed from: private */
    public WeakReference<Activity> activityWeakReference;
    private AtomicBoolean isTracking = new AtomicBoolean(false);
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    static void startTrackingActivity(Activity activity) {
        int hashCode = activity.hashCode();
        if (!observers.containsKey(Integer.valueOf(hashCode))) {
            ViewObserver viewObserver = new ViewObserver(activity);
            observers.put(Integer.valueOf(hashCode), viewObserver);
            viewObserver.startTracking();
        }
    }

    static void stopTrackingActivity(Activity activity) {
        int hashCode = activity.hashCode();
        if (observers.containsKey(Integer.valueOf(hashCode))) {
            ViewObserver viewObserver = (ViewObserver) observers.get(Integer.valueOf(hashCode));
            observers.remove(Integer.valueOf(hashCode));
            viewObserver.stopTracking();
        }
    }

    private ViewObserver(Activity activity) {
        this.activityWeakReference = new WeakReference<>(activity);
    }

    private void startTracking() {
        if (!this.isTracking.getAndSet(true)) {
            View rootView = getRootView();
            if (rootView != null) {
                ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnGlobalLayoutListener(this);
                    process();
                }
            }
        }
    }

    private void stopTracking() {
        if (this.isTracking.getAndSet(false)) {
            View rootView = getRootView();
            if (rootView != null) {
                ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    if (VERSION.SDK_INT < 16) {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    } else {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                }
            }
        }
    }

    public void onGlobalLayout() {
        process();
    }

    private void process() {
        C15001 r0 = new Runnable() {
            public void run() {
                try {
                    View access$000 = ViewObserver.this.getRootView();
                    Activity activity = (Activity) ViewObserver.this.activityWeakReference.get();
                    if (access$000 == null) {
                        return;
                    }
                    if (activity != null) {
                        for (View view : SuggestedEventViewHierarchy.getAllClickableViews(access$000)) {
                            if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                                String textOfView = ViewHierarchy.getTextOfView(view);
                                if (!textOfView.isEmpty() && textOfView.length() <= 300) {
                                    ViewOnClickListener.attachListener(view, access$000, activity.getLocalClassName());
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r0.run();
        } else {
            this.uiThreadHandler.post(r0);
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    public View getRootView() {
        Activity activity = (Activity) this.activityWeakReference.get();
        if (activity == null) {
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            return null;
        }
        return window.getDecorView().getRootView();
    }
}
