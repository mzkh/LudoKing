package com.facebook.ads.internal.api;

import androidx.annotation.Keep;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase.MediaCacheFlag;
import com.facebook.ads.NativeAdsManager.Listener;

@Keep
public interface NativeAdsManagerApi {
    void disableAutoRefresh();

    int getUniqueNativeAdCount();

    boolean isLoaded();

    void loadAds();

    void loadAds(MediaCacheFlag mediaCacheFlag);

    NativeAd nextNativeAd();

    void setExtraHints(String str);

    void setListener(Listener listener);
}
