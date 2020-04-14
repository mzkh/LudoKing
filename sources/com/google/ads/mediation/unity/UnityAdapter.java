package com.google.ads.mediation.unity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.Keep;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.unity3d.ads.UnityAds.FinishState;
import com.unity3d.ads.UnityAds.PlacementState;
import com.unity3d.ads.UnityAds.UnityAdsError;
import com.unity3d.services.banners.BannerErrorCode;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.BannerView.IListener;
import com.unity3d.services.banners.UnityBannerSize;
import java.lang.ref.WeakReference;

@Keep
public class UnityAdapter extends UnityMediationAdapter implements MediationInterstitialAdapter, MediationBannerAdapter, IListener {
    private MediationBannerListener bannerListener;
    private String bannerPlacementId;
    private WeakReference<Activity> mActivityWeakReference;
    private BannerView mBannerView;
    /* access modifiers changed from: private */
    public MediationInterstitialListener mMediationInterstitialListener;
    /* access modifiers changed from: private */
    public String mPlacementId;
    private final UnityAdapterDelegate mUnityAdapterDelegate = new UnityAdapterDelegate() {
        public void onUnityAdsPlacementStateChanged(String str, PlacementState placementState, PlacementState placementState2) {
        }

        public void onUnityAdsStart(String str) {
        }

        public String getPlacementId() {
            return UnityAdapter.this.mPlacementId;
        }

        public void onUnityAdsReady(String str) {
            if (str.equals(getPlacementId()) && UnityAdapter.this.mMediationInterstitialListener != null) {
                UnityAdapter.this.mMediationInterstitialListener.onAdLoaded(UnityAdapter.this);
            }
        }

        public void onUnityAdsClick(String str) {
            if (UnityAdapter.this.mMediationInterstitialListener != null) {
                UnityAdapter.this.mMediationInterstitialListener.onAdClicked(UnityAdapter.this);
                UnityAdapter.this.mMediationInterstitialListener.onAdLeftApplication(UnityAdapter.this);
            }
        }

        public void onUnityAdsFinish(String str, FinishState finishState) {
            if (UnityAdapter.this.mMediationInterstitialListener != null) {
                UnityAdapter.this.mMediationInterstitialListener.onAdClosed(UnityAdapter.this);
            }
        }

        public void onUnityAdsError(UnityAdsError unityAdsError, String str) {
            if (str.equals(getPlacementId()) && UnityAdapter.this.mMediationInterstitialListener != null) {
                String str2 = UnityMediationAdapter.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to load Interstitial ad from Unity Ads: ");
                sb.append(unityAdsError.toString());
                Log.e(str2, sb.toString());
                UnityAdapter.this.mMediationInterstitialListener.onAdFailedToLoad(UnityAdapter.this, 3);
            }
        }
    };

    public void onPause() {
    }

    public void onResume() {
    }

    private static boolean isValidIds(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        String str3 = TextUtils.isEmpty(str) ? TextUtils.isEmpty(str2) ? "Game ID and Placement ID" : "Game ID" : "Placement ID";
        String str4 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        sb.append(" cannot be empty.");
        Log.w(str4, sb.toString());
        return false;
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.mMediationInterstitialListener = mediationInterstitialListener;
        String string = bundle.getString("gameId");
        this.mPlacementId = bundle.getString("zoneId");
        if (!isValidIds(string, this.mPlacementId)) {
            MediationInterstitialListener mediationInterstitialListener2 = this.mMediationInterstitialListener;
            if (mediationInterstitialListener2 != null) {
                mediationInterstitialListener2.onAdFailedToLoad(this, 1);
            }
        } else if (context == null || !(context instanceof Activity)) {
            Log.e(TAG, "Context is not an Activity. Unity Ads requires an Activity context to load ads.");
            MediationInterstitialListener mediationInterstitialListener3 = this.mMediationInterstitialListener;
            if (mediationInterstitialListener3 != null) {
                mediationInterstitialListener3.onAdFailedToLoad(this, 1);
            }
        } else {
            Activity activity = (Activity) context;
            this.mActivityWeakReference = new WeakReference<>(activity);
            UnitySingleton.getInstance().initializeUnityAds(activity, string);
            UnitySingleton.getInstance().loadAd(this.mUnityAdapterDelegate);
        }
    }

    public void showInterstitial() {
        this.mMediationInterstitialListener.onAdOpened(this);
        WeakReference<Activity> weakReference = this.mActivityWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            Log.w(TAG, "Failed to show Unity Ads Interstitial.");
            this.mMediationInterstitialListener.onAdClosed(this);
            return;
        }
        UnitySingleton.getInstance().showAd(this.mUnityAdapterDelegate, (Activity) this.mActivityWeakReference.get());
    }

    public void onDestroy() {
        BannerView bannerView = this.mBannerView;
        if (bannerView != null) {
            bannerView.destroy();
        }
        this.mBannerView = null;
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        Log.v(TAG, "Requesting Unity Ads Banner");
        this.bannerListener = mediationBannerListener;
        String string = bundle.getString("gameId");
        this.bannerPlacementId = bundle.getString("zoneId");
        if (!isValidIds(string, this.bannerPlacementId)) {
            MediationBannerListener mediationBannerListener2 = this.bannerListener;
            if (mediationBannerListener2 != null) {
                mediationBannerListener2.onAdFailedToLoad(this, 1);
            }
        } else if (context == null || !(context instanceof Activity)) {
            Log.e(TAG, "Context is not an Activity. Unity Ads requires an Activity context to load ads.");
            MediationBannerListener mediationBannerListener3 = this.bannerListener;
            if (mediationBannerListener3 != null) {
                mediationBannerListener3.onAdFailedToLoad(this, 1);
            }
        } else {
            Activity activity = (Activity) context;
            UnitySingleton.getInstance().initializeUnityAds(activity, string);
            float f = context.getResources().getDisplayMetrics().density;
            UnityBannerSize unityBannerSize = new UnityBannerSize(Math.round(((float) adSize.getWidthInPixels(context)) / f), Math.round(((float) adSize.getHeightInPixels(context)) / f));
            if (this.mBannerView == null) {
                this.mBannerView = new BannerView(activity, this.bannerPlacementId, unityBannerSize);
            }
            this.mBannerView.setListener(this);
            this.mBannerView.load();
        }
    }

    public View getBannerView() {
        return this.mBannerView;
    }

    public void onBannerLoaded(BannerView bannerView) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Unity Ads Banner finished loading banner for placement: ");
        sb.append(this.mBannerView.getPlacementId());
        Log.v(str, sb.toString());
        this.bannerListener.onAdLoaded(this);
    }

    public void onBannerClick(BannerView bannerView) {
        this.bannerListener.onAdClicked(this);
    }

    public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Unity Ads Banner encountered an error: ");
        sb.append(bannerErrorInfo.errorMessage);
        Log.w(str, sb.toString());
        if (bannerErrorInfo.errorCode == BannerErrorCode.NO_FILL) {
            this.bannerListener.onAdFailedToLoad(this, 3);
        } else {
            this.bannerListener.onAdFailedToLoad(this, 0);
        }
    }

    public void onBannerLeftApplication(BannerView bannerView) {
        this.bannerListener.onAdLeftApplication(this);
    }
}
