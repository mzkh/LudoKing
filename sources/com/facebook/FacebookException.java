package com.facebook;

import com.facebook.internal.FeatureManager;
import com.facebook.internal.FeatureManager.Callback;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.util.Random;

public class FacebookException extends RuntimeException {
    static final long serialVersionUID = 1;

    public FacebookException() {
    }

    public FacebookException(final String str) {
        super(str);
        Random random = new Random();
        if (str != null && FacebookSdk.isInitialized() && random.nextInt(100) > 50) {
            FeatureManager.checkFeature(Feature.ErrorReport, new Callback() {
                public void onCompleted(boolean z) {
                    if (z) {
                        try {
                            ErrorReportHandler.save(str);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    public FacebookException(String str, Object... objArr) {
        this(String.format(str, objArr));
    }

    public FacebookException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookException(Throwable th) {
        super(th);
    }

    public String toString() {
        return getMessage();
    }
}
