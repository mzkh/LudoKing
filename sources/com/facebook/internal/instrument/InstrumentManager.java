package com.facebook.internal.instrument;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FeatureManager.Callback;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;

@RestrictTo({Scope.LIBRARY_GROUP})
public class InstrumentManager {
    public static void start() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            FeatureManager.checkFeature(Feature.CrashReport, new Callback() {
                public void onCompleted(boolean z) {
                    if (z) {
                        CrashHandler.enable();
                    }
                }
            });
            FeatureManager.checkFeature(Feature.ErrorReport, new Callback() {
                public void onCompleted(boolean z) {
                    if (z) {
                        ErrorReportHandler.enable();
                    }
                }
            });
        }
    }
}
