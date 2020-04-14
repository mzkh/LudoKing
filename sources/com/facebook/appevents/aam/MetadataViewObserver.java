package com.facebook.appevents.aam;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.view.Window;
import android.widget.EditText;
import androidx.annotation.Nullable;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

final class MetadataViewObserver implements OnGlobalFocusChangeListener {
    private static final int MAX_TEXT_LENGTH = 100;
    private static final String TAG = "com.facebook.appevents.aam.MetadataViewObserver";
    private static final Map<Integer, MetadataViewObserver> observers = new HashMap();
    private WeakReference<Activity> activityWeakReference;
    private AtomicBoolean isTracking;
    private final Set<String> processedText = new HashSet();
    private final Handler uiThreadHandler;

    private MetadataViewObserver(Activity activity) {
        this.activityWeakReference = new WeakReference<>(activity);
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        this.isTracking = new AtomicBoolean(false);
    }

    static void startTrackingActivity(Activity activity) {
        MetadataViewObserver metadataViewObserver;
        int hashCode = activity.hashCode();
        if (!observers.containsKey(Integer.valueOf(hashCode))) {
            metadataViewObserver = new MetadataViewObserver(activity);
            observers.put(Integer.valueOf(activity.hashCode()), metadataViewObserver);
        } else {
            metadataViewObserver = (MetadataViewObserver) observers.get(Integer.valueOf(hashCode));
        }
        metadataViewObserver.startTracking();
    }

    static void stopTrackingActivity(Activity activity) {
        int hashCode = activity.hashCode();
        if (observers.containsKey(Integer.valueOf(hashCode))) {
            MetadataViewObserver metadataViewObserver = (MetadataViewObserver) observers.get(Integer.valueOf(activity.hashCode()));
            observers.remove(Integer.valueOf(hashCode));
            metadataViewObserver.stopTracking();
        }
    }

    private void startTracking() {
        if (!this.isTracking.getAndSet(true)) {
            View rootView = getRootView();
            if (rootView != null) {
                ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnGlobalFocusChangeListener(this);
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
                    viewTreeObserver.removeOnGlobalFocusChangeListener(this);
                }
            }
        }
    }

    public void onGlobalFocusChanged(@Nullable View view, @Nullable View view2) {
        if (view != null) {
            process(view);
        }
        if (view2 != null) {
            process(view2);
        }
    }

    private void process(final View view) {
        runOnUIThread(new Runnable() {
            public void run() {
                View view = view;
                if (view instanceof EditText) {
                    MetadataViewObserver.this.processEditText(view);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void processEditText(View view) {
        String trim = ((EditText) view).getText().toString().trim();
        if (!trim.isEmpty() && !this.processedText.contains(trim) && trim.length() <= 100) {
            this.processedText.add(trim);
            HashMap hashMap = new HashMap();
            List list = null;
            ArrayList arrayList = null;
            for (MetadataRule metadataRule : MetadataRule.getRules()) {
                if (MetadataMatcher.matchValue(trim, metadataRule.getValRule())) {
                    if (list == null) {
                        list = MetadataMatcher.getCurrentViewIndicators(view);
                    }
                    if (MetadataMatcher.matchIndicator(list, metadataRule.getKeyRules())) {
                        hashMap.put(metadataRule.getName(), trim);
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            ViewGroup parentOfView = ViewHierarchy.getParentOfView(view);
                            if (parentOfView != null) {
                                for (View view2 : ViewHierarchy.getChildrenOfView(parentOfView)) {
                                    if (view != view2) {
                                        arrayList.addAll(MetadataMatcher.getTextIndicators(view2));
                                    }
                                }
                            }
                        }
                        if (MetadataMatcher.matchIndicator((List<String>) arrayList, metadataRule.getKeyRules())) {
                            hashMap.put(metadataRule.getName(), trim);
                        }
                    }
                }
            }
            InternalAppEventsLogger.setInternalUserData(hashMap);
        }
    }

    private void runOnUIThread(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.uiThreadHandler.post(runnable);
        }
    }

    @Nullable
    private View getRootView() {
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
