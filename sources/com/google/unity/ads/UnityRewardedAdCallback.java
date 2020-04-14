package com.google.unity.ads;

public interface UnityRewardedAdCallback {
    void onRewardedAdClosed();

    void onRewardedAdFailedToLoad(String str);

    void onRewardedAdFailedToShow(String str);

    void onRewardedAdLoaded();

    void onRewardedAdOpened();

    void onUserEarnedReward(String str, float f);
}
