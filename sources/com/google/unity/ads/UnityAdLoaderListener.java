package com.google.unity.ads;

public interface UnityAdLoaderListener {
    void onAdFailedToLoad(String str);

    void onCustomClick(CustomNativeAd customNativeAd, String str);

    void onCustomTemplateAdLoaded(CustomNativeAd customNativeAd);
}
