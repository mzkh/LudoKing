package com.facebook.ads.internal.api;

import androidx.annotation.Keep;
import androidx.annotation.UiThread;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.InterstitialAd.InterstitialAdLoadConfigBuilder;
import com.facebook.ads.InterstitialAd.InterstitialAdShowConfigBuilder;
import com.facebook.ads.InterstitialAd.InterstitialLoadAdConfig;
import com.facebook.ads.InterstitialAd.InterstitialShowAdConfig;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.RewardedAdListener;
import java.util.EnumSet;

@UiThread
@Keep
public interface InterstitialAdApi extends FullScreenAd {
    InterstitialAdLoadConfigBuilder buildLoadAdConfig();

    InterstitialAdShowConfigBuilder buildShowAdConfig();

    boolean isAdLoaded();

    void loadAd(InterstitialLoadAdConfig interstitialLoadAdConfig);

    @Deprecated
    void loadAd(EnumSet<CacheFlag> enumSet);

    @Deprecated
    void loadAdFromBid(EnumSet<CacheFlag> enumSet, String str);

    @Deprecated
    void setAdListener(InterstitialAdListener interstitialAdListener);

    void setExtraHints(ExtraHints extraHints);

    @Deprecated
    void setRewardedAdListener(RewardedAdListener rewardedAdListener);

    boolean show();

    boolean show(InterstitialShowAdConfig interstitialShowAdConfig);
}
