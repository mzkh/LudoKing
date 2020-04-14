package com.facebook.ads.internal.api;

import androidx.annotation.Keep;
import androidx.annotation.UiThread;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd.RewardedVideoAdLoadConfigBuilder;
import com.facebook.ads.RewardedVideoAd.RewardedVideoAdShowConfigBuilder;
import com.facebook.ads.RewardedVideoAd.RewardedVideoLoadAdConfig;
import com.facebook.ads.RewardedVideoAd.RewardedVideoShowAdConfig;
import com.facebook.ads.RewardedVideoAdListener;

@UiThread
@Keep
public interface RewardedVideoAdApi extends FullScreenAd {
    RewardedVideoAdLoadConfigBuilder buildLoadAdConfig();

    RewardedVideoAdShowConfigBuilder buildShowAdConfig();

    void destroy();

    @Deprecated
    void enableRVChain(boolean z);

    String getPlacementId();

    int getVideoDuration();

    boolean isAdInvalidated();

    boolean isAdLoaded();

    void loadAd();

    void loadAd(RewardedVideoLoadAdConfig rewardedVideoLoadAdConfig);

    @Deprecated
    void loadAd(boolean z);

    @Deprecated
    void loadAdFromBid(String str);

    @Deprecated
    void loadAdFromBid(String str, boolean z);

    @Deprecated
    void setAdListener(RewardedVideoAdListener rewardedVideoAdListener);

    void setExtraHints(ExtraHints extraHints);

    @Deprecated
    void setRewardData(RewardData rewardData);

    boolean show();

    @Deprecated
    boolean show(int i);

    boolean show(RewardedVideoShowAdConfig rewardedVideoShowAdConfig);
}
