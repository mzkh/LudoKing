package com.facebook.ads.internal.api;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.NativeAdLayout;

@Keep
public interface AdChoicesViewApi {
    void initialize(boolean z, @Nullable NativeAdLayout nativeAdLayout);
}
