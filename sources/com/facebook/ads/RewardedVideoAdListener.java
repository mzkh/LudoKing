package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
public interface RewardedVideoAdListener extends AdListener {
    void onLoggingImpression(C1431Ad ad);

    void onRewardedVideoClosed();

    void onRewardedVideoCompleted();
}
