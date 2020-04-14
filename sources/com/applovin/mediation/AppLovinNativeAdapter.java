package com.applovin.mediation;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

public class AppLovinNativeAdapter implements MediationNativeAdapter {
    public static final String KEY_EXTRA_AD_ID = "ad_id";
    public static final String KEY_EXTRA_CAPTION_TEXT = "caption_text";
    static final String TAG = "AppLovinNativeAdapter";

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        if (!nativeMediationAdRequest.isContentAdRequested() || nativeMediationAdRequest.isAppInstallAdRequested()) {
            AppLovinSdk retrieveSdk = AppLovinUtils.retrieveSdk(bundle, context);
            retrieveSdk.getNativeAdService().loadNativeAds(1, new AppLovinNativeAdListener(this, mediationNativeListener, retrieveSdk, context));
            return;
        }
        Log.e(TAG, "Failed to request native ad. App install format needs to be requested");
        mediationNativeListener.onAdFailedToLoad(this, 1);
    }
}
