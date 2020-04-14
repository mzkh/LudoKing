package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
public interface InterstitialAdExtendedListener extends InterstitialAdListener, RewardedAdListener {
    void onInterstitialActivityDestroyed();
}
