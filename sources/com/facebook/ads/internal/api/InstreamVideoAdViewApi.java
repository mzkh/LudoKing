package com.facebook.ads.internal.api;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.C1431Ad;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.InstreamVideoAdListener;
import com.facebook.ads.InstreamVideoAdView.InstreamVideoLoadAdConfig;
import com.facebook.ads.InstreamVideoAdView.InstreamVideoLoadConfigBuilder;

@Keep
public interface InstreamVideoAdViewApi extends C1431Ad {
    InstreamVideoLoadConfigBuilder buildLoadAdConfig();

    void destroy();

    String getPlacementId();

    @Nullable
    Bundle getSaveInstanceState();

    boolean isAdInvalidated();

    boolean isAdLoaded();

    void loadAd();

    void loadAd(InstreamVideoLoadAdConfig instreamVideoLoadAdConfig);

    void loadAdFromBid(String str);

    void setAdListener(@Nullable InstreamVideoAdListener instreamVideoAdListener);

    void setExtraHints(ExtraHints extraHints);

    void setIsAdLoaded(boolean z);

    boolean show();
}
