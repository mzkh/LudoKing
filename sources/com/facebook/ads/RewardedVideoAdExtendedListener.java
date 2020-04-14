package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
public interface RewardedVideoAdExtendedListener extends RewardedVideoAdListener {
    void onRewardedVideoActivityDestroyed();
}
