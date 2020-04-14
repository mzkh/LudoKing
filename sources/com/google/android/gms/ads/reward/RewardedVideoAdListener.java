package com.google.android.gms.ads.reward;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface RewardedVideoAdListener {
    void onRewarded(RewardItem rewardItem);

    void onRewardedVideoAdClosed();

    void onRewardedVideoAdFailedToLoad(int i);

    void onRewardedVideoAdLeftApplication();

    void onRewardedVideoAdLoaded();

    void onRewardedVideoAdOpened();

    void onRewardedVideoCompleted();

    void onRewardedVideoStarted();
}
