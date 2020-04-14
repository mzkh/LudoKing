package com.applovin.mediation;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ApplovinAdapter extends AppLovinMediationAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, OnContextChangedListener, MediationRewardedAd {
    /* access modifiers changed from: private */
    public static final HashMap<String, Queue<AppLovinAd>> INTERSTITIAL_AD_QUEUES = new HashMap<>();
    /* access modifiers changed from: private */
    public static final Object INTERSTITIAL_AD_QUEUES_LOCK = new Object();
    private static final boolean LOGGING_ENABLED = true;
    private AppLovinAdView mAdView;
    private Context mContext;
    /* access modifiers changed from: private */
    public MediationInterstitialListener mMediationInterstitialListener;
    private Bundle mNetworkExtras;
    /* access modifiers changed from: private */
    public String mPlacement;
    private AppLovinSdk mSdk;
    /* access modifiers changed from: private */
    public String mZoneId;

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.mSdk = AppLovinUtils.retrieveSdk(bundle, context);
        this.mContext = context;
        this.mNetworkExtras = bundle2;
        this.mMediationInterstitialListener = mediationInterstitialListener;
        this.mPlacement = AppLovinUtils.retrievePlacement(bundle);
        this.mZoneId = AppLovinUtils.retrieveZoneId(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append("Requesting interstitial for zone: ");
        sb.append(this.mZoneId);
        sb.append(" and placement: ");
        sb.append(this.mPlacement);
        log(3, sb.toString());
        C12951 r1 = new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd appLovinAd) {
                StringBuilder sb = new StringBuilder();
                sb.append("Interstitial did load ad: ");
                sb.append(appLovinAd.getAdIdNumber());
                sb.append(" for zone: ");
                sb.append(ApplovinAdapter.this.mZoneId);
                sb.append(" and placement: ");
                sb.append(ApplovinAdapter.this.mPlacement);
                ApplovinAdapter.log(3, sb.toString());
                synchronized (ApplovinAdapter.INTERSTITIAL_AD_QUEUES_LOCK) {
                    Queue queue = (Queue) ApplovinAdapter.INTERSTITIAL_AD_QUEUES.get(ApplovinAdapter.this.mZoneId);
                    if (queue == null) {
                        queue = new LinkedList();
                        ApplovinAdapter.INTERSTITIAL_AD_QUEUES.put(ApplovinAdapter.this.mZoneId, queue);
                    }
                    queue.offer(appLovinAd);
                    AppLovinSdkUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            ApplovinAdapter.this.mMediationInterstitialListener.onAdLoaded(ApplovinAdapter.this);
                        }
                    });
                }
            }

            public void failedToReceiveAd(final int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("Interstitial failed to load with error: ");
                sb.append(i);
                ApplovinAdapter.log(6, sb.toString());
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        ApplovinAdapter.this.mMediationInterstitialListener.onAdFailedToLoad(ApplovinAdapter.this, AppLovinUtils.toAdMobErrorCode(i));
                    }
                });
            }
        };
        synchronized (INTERSTITIAL_AD_QUEUES_LOCK) {
            Queue queue = (Queue) INTERSTITIAL_AD_QUEUES.get(this.mZoneId);
            if (queue != null) {
                if (queue == null || !queue.isEmpty()) {
                    log(3, "Enqueued interstitial found. Finishing load...");
                    AppLovinSdkUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            ApplovinAdapter.this.mMediationInterstitialListener.onAdLoaded(ApplovinAdapter.this);
                        }
                    });
                }
            }
            if (!TextUtils.isEmpty(this.mZoneId)) {
                this.mSdk.getAdService().loadNextAdForZoneId(this.mZoneId, r1);
            } else {
                this.mSdk.getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, r1);
            }
        }
    }

    public void showInterstitial() {
        synchronized (INTERSTITIAL_AD_QUEUES_LOCK) {
            this.mSdk.getSettings().setMuted(AppLovinUtils.shouldMuteAudio(this.mNetworkExtras));
            Queue queue = (Queue) INTERSTITIAL_AD_QUEUES.get(this.mZoneId);
            AppLovinAd appLovinAd = queue != null ? (AppLovinAd) queue.poll() : null;
            AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.mSdk, this.mContext);
            AppLovinInterstitialAdListener appLovinInterstitialAdListener = new AppLovinInterstitialAdListener(this, this.mMediationInterstitialListener);
            create.setAdDisplayListener(appLovinInterstitialAdListener);
            create.setAdClickListener(appLovinInterstitialAdListener);
            create.setAdVideoPlaybackListener(appLovinInterstitialAdListener);
            if (appLovinAd != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Showing interstitial for zone: ");
                sb.append(this.mZoneId);
                sb.append(" placement: ");
                sb.append(this.mPlacement);
                log(3, sb.toString());
                create.showAndRender(appLovinAd, this.mPlacement);
            } else {
                log(3, "Attempting to show interstitial before one was loaded");
                if (!TextUtils.isEmpty(this.mZoneId) || !create.isAdReadyToDisplay()) {
                    this.mMediationInterstitialListener.onAdOpened(this);
                    this.mMediationInterstitialListener.onAdClosed(this);
                } else {
                    log(3, "Showing interstitial preloaded by SDK");
                    create.show(this.mPlacement);
                }
            }
        }
    }

    public void requestBannerAd(Context context, final MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.mSdk = AppLovinUtils.retrieveSdk(bundle, context);
        this.mPlacement = AppLovinUtils.retrievePlacement(bundle);
        this.mZoneId = AppLovinUtils.retrieveZoneId(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append("Requesting banner of size ");
        sb.append(adSize);
        sb.append(" for zone: ");
        sb.append(this.mZoneId);
        sb.append(" and placement: ");
        sb.append(this.mPlacement);
        log(3, sb.toString());
        AppLovinAdSize appLovinAdSizeFromAdMobAdSize = AppLovinUtils.appLovinAdSizeFromAdMobAdSize(context, adSize);
        if (appLovinAdSizeFromAdMobAdSize != null) {
            this.mAdView = new AppLovinAdView(this.mSdk, appLovinAdSizeFromAdMobAdSize, context);
            AppLovinBannerAdListener appLovinBannerAdListener = new AppLovinBannerAdListener(this.mZoneId, this.mAdView, this, mediationBannerListener);
            this.mAdView.setAdDisplayListener(appLovinBannerAdListener);
            this.mAdView.setAdClickListener(appLovinBannerAdListener);
            this.mAdView.setAdViewEventListener(appLovinBannerAdListener);
            if (!TextUtils.isEmpty(this.mZoneId)) {
                this.mSdk.getAdService().loadNextAdForZoneId(this.mZoneId, appLovinBannerAdListener);
            } else {
                this.mSdk.getAdService().loadNextAd(appLovinAdSizeFromAdMobAdSize, appLovinBannerAdListener);
            }
        } else {
            log(6, "Failed to request banner with unsupported size");
            if (mediationBannerListener != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        mediationBannerListener.onAdFailedToLoad(ApplovinAdapter.this, 1);
                    }
                });
            }
        }
    }

    public View getBannerView() {
        return this.mAdView;
    }

    public void onContextChanged(Context context) {
        if (context != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Context changed: ");
            sb.append(context);
            log(3, sb.toString());
            this.mContext = context;
        }
    }

    public static void log(int i, String str) {
        Log.println(i, "AppLovinAdapter", str);
    }
}
