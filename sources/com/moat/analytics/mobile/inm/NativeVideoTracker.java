package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import androidx.annotation.UiThread;
import java.util.Map;

@UiThread
public interface NativeVideoTracker {
    void changeTargetView(View view);

    void dispatchEvent(MoatAdEvent moatAdEvent);

    void removeListener();

    void removeVideoListener();

    @Deprecated
    void setActivity(Activity activity);

    void setListener(TrackerListener trackerListener);

    void setPlayerVolume(Double d);

    void setVideoListener(VideoTrackerListener videoTrackerListener);

    void stopTracking();

    boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view);
}
