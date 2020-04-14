package com.applovin.mediation;

import android.content.Context;
import android.util.Log;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import java.lang.ref.WeakReference;
import java.util.List;

class AppLovinNativeAdListener implements AppLovinNativeAdLoadListener, AppLovinNativeAdPrecacheListener {
    /* access modifiers changed from: private */
    public final AppLovinNativeAdapter mAdapter;
    private final WeakReference<Context> mContextWeakReference;
    /* access modifiers changed from: private */
    public final MediationNativeListener mNativeListener;
    private final AppLovinSdk mSdk;

    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
    }

    public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
    }

    AppLovinNativeAdListener(AppLovinNativeAdapter appLovinNativeAdapter, MediationNativeListener mediationNativeListener, AppLovinSdk appLovinSdk, Context context) {
        this.mAdapter = appLovinNativeAdapter;
        this.mNativeListener = mediationNativeListener;
        this.mSdk = appLovinSdk;
        this.mContextWeakReference = new WeakReference<>(context);
    }

    public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
        if (list.size() <= 0 || !isValidNativeAd((AppLovinNativeAd) list.get(0))) {
            Log.e(AppLovinNativeAdapter.TAG, "Ad from AppLovin doesn't have all assets required for the app install ad format");
            notifyAdFailure(3);
            return;
        }
        this.mSdk.getNativeAdService().precacheResources((AppLovinNativeAd) list.get(0), this);
    }

    public void onNativeAdsFailedToLoad(int i) {
        String str = AppLovinNativeAdapter.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Native ad failed to load ");
        sb.append(i);
        Log.e(str, sb.toString());
        notifyAdFailure(AppLovinUtils.toAdMobErrorCode(i));
    }

    public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
        Context context = (Context) this.mContextWeakReference.get();
        if (context == null) {
            Log.e(AppLovinNativeAdapter.TAG, "Failed to create mapper. Context is null.");
            notifyAdFailure(0);
            return;
        }
        final AppLovinNativeAdMapper appLovinNativeAdMapper = new AppLovinNativeAdMapper(appLovinNativeAd, context);
        Log.d(AppLovinNativeAdapter.TAG, "Native ad loaded.");
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                AppLovinNativeAdListener.this.mNativeListener.onAdLoaded((MediationNativeAdapter) AppLovinNativeAdListener.this.mAdapter, (NativeAdMapper) appLovinNativeAdMapper);
            }
        });
    }

    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        String str = AppLovinNativeAdapter.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Native ad failed to pre cache images ");
        sb.append(i);
        Log.e(str, sb.toString());
        notifyAdFailure(AppLovinUtils.toAdMobErrorCode(i));
    }

    private void notifyAdFailure(final int i) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                AppLovinNativeAdListener.this.mNativeListener.onAdFailedToLoad(AppLovinNativeAdListener.this.mAdapter, i);
            }
        });
    }

    private static boolean isValidNativeAd(AppLovinNativeAd appLovinNativeAd) {
        return (appLovinNativeAd.getImageUrl() == null || appLovinNativeAd.getIconUrl() == null || appLovinNativeAd.getTitle() == null || appLovinNativeAd.getDescriptionText() == null || appLovinNativeAd.getCtaText() == null) ? false : true;
    }
}
