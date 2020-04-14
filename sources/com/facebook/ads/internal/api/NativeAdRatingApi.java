package com.facebook.ads.internal.api;

import androidx.annotation.Keep;

@Keep
public interface NativeAdRatingApi {
    double getScale();

    double getValue();
}
