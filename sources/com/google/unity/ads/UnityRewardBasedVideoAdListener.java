package com.google.unity.ads;

public interface UnityRewardBasedVideoAdListener {
    void onAdClosed();

    void onAdCompleted();

    void onAdFailedToLoad(String str);

    void onAdLeftApplication();

    void onAdLoaded();

    void onAdOpened();

    void onAdRewarded(String str, float f);

    void onAdStarted();
}
