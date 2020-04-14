package com.facebook.ads.internal.api;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView.Type;

@Keep
public interface NativeBannerAdViewApi {
    View render(Context context, NativeBannerAd nativeBannerAd, Type type);

    View render(Context context, NativeBannerAd nativeBannerAd, Type type, @Nullable NativeAdViewAttributes nativeAdViewAttributes);
}
