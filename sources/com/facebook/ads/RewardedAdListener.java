package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
public interface RewardedAdListener {
    void onRewardedAdCompleted();

    void onRewardedAdServerFailed();

    void onRewardedAdServerSucceeded();
}
