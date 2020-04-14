package com.facebook.ads.internal.api;

import android.content.res.Configuration;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdView.AdViewLoadConfig;
import com.facebook.ads.AdView.AdViewLoadConfigBuilder;
import com.facebook.ads.C1431Ad;
import com.facebook.ads.ExtraHints;

@UiThread
@Keep
public interface AdViewApi extends AdViewParentApi, C1431Ad {
    AdViewLoadConfigBuilder buildLoadAdConfig();

    void loadAd(AdViewLoadConfig adViewLoadConfig);

    void onConfigurationChanged(Configuration configuration);

    void setAdListener(AdListener adListener);

    void setExtraHints(ExtraHints extraHints);
}
