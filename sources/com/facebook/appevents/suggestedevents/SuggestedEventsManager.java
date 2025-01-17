package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.p022ml.ModelManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

@RestrictTo({Scope.LIBRARY_GROUP})
public final class SuggestedEventsManager {
    private static final String ELIGIBLE_EVENTS_KEY = "eligible_for_prediction_events";
    private static final String PRODUCTION_EVENTS_KEY = "production_events";
    private static final Set<String> eligibleEvents = new HashSet();
    private static final AtomicBoolean enabled = new AtomicBoolean(false);
    private static final Set<String> productionEvents = new HashSet();

    public static synchronized void enable() {
        synchronized (SuggestedEventsManager.class) {
            if (!enabled.get()) {
                enabled.set(true);
                initialize();
            }
        }
    }

    private static void initialize() {
        String str = ELIGIBLE_EVENTS_KEY;
        String str2 = PRODUCTION_EVENTS_KEY;
        try {
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings != null) {
                String suggestedEventsSetting = queryAppSettings.getSuggestedEventsSetting();
                if (suggestedEventsSetting != null) {
                    JSONObject jSONObject = new JSONObject(suggestedEventsSetting);
                    if (jSONObject.has(str2)) {
                        JSONArray jSONArray = jSONObject.getJSONArray(str2);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            productionEvents.add(jSONArray.getString(i));
                        }
                    }
                    if (jSONObject.has(str)) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray(str);
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            eligibleEvents.add(jSONArray2.getString(i2));
                        }
                    }
                    if (!productionEvents.isEmpty() || !eligibleEvents.isEmpty()) {
                        File ruleFile = ModelManager.getRuleFile(ModelManager.MODEL_SUGGESTED_EVENTS);
                        if (ruleFile != null) {
                            FeatureExtractor.initialize(ruleFile);
                            Activity currentActivity = ActivityLifecycleTracker.getCurrentActivity();
                            if (currentActivity != null) {
                                trackActivity(currentActivity);
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void trackActivity(Activity activity) {
        try {
            if (!enabled.get() || !FeatureExtractor.isInitialized() || (productionEvents.isEmpty() && eligibleEvents.isEmpty())) {
                ViewObserver.stopTrackingActivity(activity);
            } else {
                ViewObserver.startTrackingActivity(activity);
            }
        } catch (Exception unused) {
        }
    }

    public static boolean isEnabled() {
        return enabled.get();
    }

    static boolean isProductionEvents(String str) {
        return productionEvents.contains(str);
    }

    static boolean isEligibleEvents(String str) {
        return eligibleEvents.contains(str);
    }
}
