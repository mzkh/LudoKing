package com.facebook.appevents;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import com.facebook.FacebookSdk;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.p022ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FeatureManager.Callback;
import com.facebook.internal.FeatureManager.Feature;

@RestrictTo({Scope.LIBRARY_GROUP})
public class AppEventsManager {
    public static void start() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            FeatureManager.checkFeature(Feature.AAM, new Callback() {
                public void onCompleted(boolean z) {
                    if (z) {
                        MetadataIndexer.enable();
                    }
                }
            });
            FeatureManager.checkFeature(Feature.RestrictiveDataFiltering, new Callback() {
                public void onCompleted(boolean z) {
                    if (z) {
                        RestrictiveDataManager.enable();
                    }
                }
            });
            FeatureManager.checkFeature(Feature.PrivacyProtection, new Callback() {
                public void onCompleted(boolean z) {
                    if (z) {
                        ModelManager.enable();
                    }
                }
            });
            FeatureManager.checkFeature(Feature.EventDeactivation, new Callback() {
                public void onCompleted(boolean z) {
                    if (z) {
                        EventDeactivationManager.enable();
                    }
                }
            });
        }
    }
}
