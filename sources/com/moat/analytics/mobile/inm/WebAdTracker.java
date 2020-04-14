package com.moat.analytics.mobile.inm;

import android.app.Activity;
import androidx.annotation.UiThread;

@UiThread
public interface WebAdTracker {
    void removeListener();

    @Deprecated
    void setActivity(Activity activity);

    void setListener(TrackerListener trackerListener);

    void startTracking();

    void stopTracking();
}
