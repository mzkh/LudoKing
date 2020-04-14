package com.google.ads.mediation.inmobi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.nearby.messages.Strategy;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.InMobiBanner.AnimationType;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.listeners.BannerAdEventListener;
import com.inmobi.ads.listeners.InterstitialAdEventListener;
import com.inmobi.ads.listeners.NativeAdEventListener;
import com.inmobi.ads.listeners.VideoEventListener;
import com.inmobi.sdk.InMobiSdk;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public final class InMobiAdapter extends InMobiMediationAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    /* access modifiers changed from: private */
    public static final String TAG = "InMobiAdapter";
    private static Boolean sDisableHardwareFlag;
    private static Boolean sIsAppInitialized;
    private InMobiInterstitial mAdInterstitial;
    private InMobiNative mAdNative;
    /* access modifiers changed from: private */
    public MediationBannerListener mBannerListener;
    /* access modifiers changed from: private */
    public MediationInterstitialListener mInterstitialListener;
    /* access modifiers changed from: private */
    public MediationNativeListener mNativeListener;
    /* access modifiers changed from: private */
    public NativeMediationAdRequest mNativeMedAdReq;
    private FrameLayout mWrappedAdView;

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    static {
        Boolean valueOf = Boolean.valueOf(false);
        sDisableHardwareFlag = valueOf;
        sIsAppInitialized = valueOf;
    }

    public static Boolean isAppInitialized() {
        return sIsAppInitialized;
    }

    /* access modifiers changed from: private */
    public static int getAdRequestErrorCode(StatusCode statusCode) {
        switch (statusCode) {
            case INTERNAL_ERROR:
                return 0;
            case AD_ACTIVE:
            case REQUEST_INVALID:
            case REQUEST_PENDING:
            case EARLY_REFRESH_REQUEST:
            case MISSING_REQUIRED_DEPENDENCIES:
                return 1;
            case REQUEST_TIMED_OUT:
            case NETWORK_UNREACHABLE:
                return 2;
            default:
                return 3;
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        InMobiBanner inMobiBanner;
        AdSize supportedAdSize = getSupportedAdSize(context, adSize);
        if (supportedAdSize == null) {
            Log.w(TAG, "Failed to request ad, AdSize is null.");
            if (mediationBannerListener != null) {
                mediationBannerListener.onAdFailedToLoad(this, 1);
            }
            return;
        }
        String str = "placementid";
        if (!sIsAppInitialized.booleanValue() && bundle != null) {
            String str2 = "accountid";
            Log.d(TAG, bundle.getString(str2));
            Log.d(TAG, bundle.getString(str));
            InMobiSdk.init(context, bundle.getString(str2), InMobiConsent.getConsentObj());
            sIsAppInitialized = Boolean.valueOf(true);
        }
        this.mBannerListener = mediationBannerListener;
        LayoutParams layoutParams = new LayoutParams(supportedAdSize.getWidthInPixels(context), supportedAdSize.getHeightInPixels(context));
        if (bundle != null) {
            if (context instanceof Activity) {
                inMobiBanner = new InMobiBanner((Context) (Activity) context, Long.parseLong(bundle.getString(str)));
            } else {
                inMobiBanner = new InMobiBanner(context, Long.parseLong(bundle.getString(str)));
            }
            inMobiBanner.setEnableAutoRefresh(false);
            inMobiBanner.setAnimationType(AnimationType.ANIMATION_OFF);
            if (mediationAdRequest.getKeywords() != null) {
                inMobiBanner.setKeywords(TextUtils.join(", ", mediationAdRequest.getKeywords()));
            }
            inMobiBanner.setExtras(InMobiAdapterUtils.createInMobiParameterMap(mediationAdRequest));
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            inMobiBanner.setListener(new BannerAdEventListener() {
                public void onUserLeftApplication(InMobiBanner inMobiBanner) {
                    Log.d(InMobiAdapter.TAG, "onUserLeftApplication");
                    InMobiAdapter.this.mBannerListener.onAdLeftApplication(InMobiAdapter.this);
                }

                public void onRewardsUnlocked(InMobiBanner inMobiBanner, Map<Object, Object> map) {
                    Log.d(InMobiAdapter.TAG, "InMobi Banner onRewardsUnlocked.");
                    if (map != null) {
                        for (Object obj : map.keySet()) {
                            String obj2 = obj.toString();
                            String obj3 = map.get(obj2).toString();
                            StringBuilder sb = new StringBuilder();
                            sb.append(obj2);
                            sb.append(":");
                            sb.append(obj3);
                            Log.d("Rewards: ", sb.toString());
                        }
                    }
                }

                public void onAdLoadSucceeded(InMobiBanner inMobiBanner) {
                    System.out.println("onLoadSucceeded");
                    Log.d(InMobiAdapter.TAG, "onAdLoadSucceeded");
                    InMobiAdapter.this.mBannerListener.onAdLoaded(InMobiAdapter.this);
                }

                public void onAdLoadFailed(InMobiBanner inMobiBanner, InMobiAdRequestStatus inMobiAdRequestStatus) {
                    InMobiAdapter.this.mBannerListener.onAdFailedToLoad(InMobiAdapter.this, InMobiAdapter.getAdRequestErrorCode(inMobiAdRequestStatus.getStatusCode()));
                    String access$000 = InMobiAdapter.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onAdLoadFailed: ");
                    sb.append(inMobiAdRequestStatus.getMessage());
                    Log.d(access$000, sb.toString());
                }

                public void onAdDisplayed(InMobiBanner inMobiBanner) {
                    Log.d(InMobiAdapter.TAG, "onAdDisplayed");
                    InMobiAdapter.this.mBannerListener.onAdOpened(InMobiAdapter.this);
                }

                public void onAdDismissed(InMobiBanner inMobiBanner) {
                    Log.d(InMobiAdapter.TAG, "onAdDismissed");
                    InMobiAdapter.this.mBannerListener.onAdClosed(InMobiAdapter.this);
                }

                public void onAdClicked(InMobiBanner inMobiBanner, Map<Object, Object> map) {
                    Log.d("onBannerClicked", "onBannerClick called");
                    InMobiAdapter.this.mBannerListener.onAdClicked(InMobiAdapter.this);
                }
            });
            if (sDisableHardwareFlag.booleanValue()) {
                inMobiBanner.disableHardwareAcceleration();
            }
            this.mWrappedAdView = new FrameLayout(context);
            this.mWrappedAdView.setLayoutParams(layoutParams);
            inMobiBanner.setLayoutParams(new LinearLayout.LayoutParams(supportedAdSize.getWidthInPixels(context), supportedAdSize.getHeightInPixels(context)));
            this.mWrappedAdView.addView(inMobiBanner);
            InMobiAdapterUtils.setGlobalTargeting(mediationAdRequest, bundle2);
            inMobiBanner.load();
            return;
        }
        mediationBannerListener.onAdFailedToLoad(this, 1);
    }

    private AdSize getSupportedAdSize(Context context, AdSize adSize) {
        AdSize adSize2 = new AdSize(adSize.getWidth(), adSize.getHeight());
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(new AdSize(Strategy.TTL_SECONDS_DEFAULT, 50));
        arrayList.add(new AdSize(600, 100));
        arrayList.add(new AdSize(320, 48));
        arrayList.add(new AdSize(640, 96));
        arrayList.add(new AdSize(320, 50));
        arrayList.add(new AdSize(640, 100));
        arrayList.add(new AdSize(Strategy.TTL_SECONDS_DEFAULT, Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
        arrayList.add(new AdSize(600, TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL));
        arrayList.add(new AdSize(120, 600));
        arrayList.add(new AdSize(240, 1200));
        arrayList.add(new AdSize(468, 60));
        arrayList.add(new AdSize(936, 120));
        arrayList.add(new AdSize(728, 90));
        arrayList.add(new AdSize(1456, 180));
        arrayList.add(new AdSize(1024, 768));
        arrayList.add(new AdSize(1536, 2048));
        arrayList.add(new AdSize(320, 480));
        arrayList.add(new AdSize(640, 960));
        arrayList.add(new AdSize(1280, 800));
        arrayList.add(new AdSize(1600, 2560));
        Log.i(TAG, arrayList.toString());
        return InMobiAdapterUtils.findClosestSize(context, adSize2, arrayList);
    }

    public View getBannerView() {
        return this.mWrappedAdView;
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        if (!sIsAppInitialized.booleanValue()) {
            InMobiSdk.init(context, bundle.getString("accountid"), InMobiConsent.getConsentObj());
            sIsAppInitialized = Boolean.valueOf(true);
        }
        this.mInterstitialListener = mediationInterstitialListener;
        this.mAdInterstitial = new InMobiInterstitial(context, Long.parseLong(bundle.getString("placementid")), new InterstitialAdEventListener() {
            public void onUserLeftApplication(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiAdapter.TAG, "onUserLeftApplication");
                InMobiAdapter.this.mInterstitialListener.onAdLeftApplication(InMobiAdapter.this);
            }

            public void onRewardsUnlocked(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
                Log.d(InMobiAdapter.TAG, "InMobi Interstitial onRewardsUnlocked.");
                if (map != null) {
                    for (Object obj : map.keySet()) {
                        String obj2 = obj.toString();
                        String obj3 = map.get(obj2).toString();
                        StringBuilder sb = new StringBuilder();
                        sb.append(obj2);
                        sb.append(": ");
                        sb.append(obj3);
                        Log.d("Rewards: ", sb.toString());
                    }
                }
            }

            public void onAdDisplayFailed(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiAdapter.TAG, "Ad Display failed.");
            }

            public void onAdWillDisplay(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiAdapter.TAG, "Ad Will Display.");
            }

            public void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiAdapter.TAG, "onAdLoadSucceeded");
                InMobiAdapter.this.mInterstitialListener.onAdLoaded(InMobiAdapter.this);
            }

            public void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, InMobiAdRequestStatus inMobiAdRequestStatus) {
                InMobiAdapter.this.mInterstitialListener.onAdFailedToLoad(InMobiAdapter.this, InMobiAdapter.getAdRequestErrorCode(inMobiAdRequestStatus.getStatusCode()));
                String access$000 = InMobiAdapter.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onAdLoadFailed: ");
                sb.append(inMobiAdRequestStatus.getMessage());
                Log.d(access$000, sb.toString());
            }

            public void onAdReceived(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiAdapter.TAG, "InMobi Ad server responded with an Ad.");
            }

            public void onAdDisplayed(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiAdapter.TAG, "onAdDisplayed");
                InMobiAdapter.this.mInterstitialListener.onAdOpened(InMobiAdapter.this);
            }

            public void onAdDismissed(InMobiInterstitial inMobiInterstitial) {
                Log.d(InMobiAdapter.TAG, "onAdDismissed");
                InMobiAdapter.this.mInterstitialListener.onAdClosed(InMobiAdapter.this);
            }

            public void onAdClicked(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
                Log.d(InMobiAdapter.TAG, "InterstitialClicked");
                InMobiAdapter.this.mInterstitialListener.onAdClicked(InMobiAdapter.this);
            }
        });
        if (mediationAdRequest.getKeywords() != null) {
            this.mAdInterstitial.setKeywords(TextUtils.join(", ", mediationAdRequest.getKeywords()));
        }
        this.mAdInterstitial.setExtras(InMobiAdapterUtils.createInMobiParameterMap(mediationAdRequest));
        if (sDisableHardwareFlag.booleanValue()) {
            this.mAdInterstitial.disableHardwareAcceleration();
        }
        InMobiAdapterUtils.setGlobalTargeting(mediationAdRequest, bundle2);
        this.mAdInterstitial.load();
    }

    public void showInterstitial() {
        if (this.mAdInterstitial.isReady()) {
            Log.d(TAG, "Ad is ready to show");
            this.mAdInterstitial.show();
        }
    }

    public void requestNativeAd(final Context context, MediationNativeListener mediationNativeListener, Bundle bundle, final NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.mNativeMedAdReq = nativeMediationAdRequest;
        if (!sIsAppInitialized.booleanValue() && bundle != null) {
            InMobiSdk.init(context, bundle.getString("accountid"), InMobiConsent.getConsentObj());
            sIsAppInitialized = Boolean.valueOf(true);
        }
        this.mNativeListener = mediationNativeListener;
        if (this.mNativeMedAdReq.isUnifiedNativeAdRequested() || this.mNativeMedAdReq.isAppInstallAdRequested()) {
            this.mAdNative = new InMobiNative(context, Long.parseLong(bundle.getString("placementid")), new NativeAdEventListener() {
                public void onAdFullScreenWillDisplay(InMobiNative inMobiNative) {
                }

                public void onAdStatusChanged(@NonNull InMobiNative inMobiNative) {
                }

                public void onAdLoadSucceeded(InMobiNative inMobiNative) {
                    System.out.println(" [ InMobi Native Ad ] : onAdLoadSucceeded ");
                    Log.d(InMobiAdapter.TAG, "onAdLoadSucceeded");
                    if (inMobiNative != null) {
                        NativeAdOptions nativeAdOptions = InMobiAdapter.this.mNativeMedAdReq.getNativeAdOptions();
                        boolean z = false;
                        if (nativeAdOptions != null) {
                            z = nativeAdOptions.shouldReturnUrlsForImageAssets();
                        }
                        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
                            new InMobiUnifiedNativeAdMapper(InMobiAdapter.this, inMobiNative, Boolean.valueOf(z), InMobiAdapter.this.mNativeListener).mapUnifiedNativeAd(context);
                        } else if (nativeMediationAdRequest.isAppInstallAdRequested()) {
                            new InMobiAppInstallNativeAdMapper(InMobiAdapter.this, inMobiNative, Boolean.valueOf(z), InMobiAdapter.this.mNativeListener).mapAppInstallAd(context);
                        }
                    }
                }

                public void onAdLoadFailed(InMobiNative inMobiNative, InMobiAdRequestStatus inMobiAdRequestStatus) {
                    InMobiAdapter.this.mNativeListener.onAdFailedToLoad(InMobiAdapter.this, InMobiAdapter.getAdRequestErrorCode(inMobiAdRequestStatus.getStatusCode()));
                    String access$000 = InMobiAdapter.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onAdLoadFailed: ");
                    sb.append(inMobiAdRequestStatus.getMessage());
                    Log.d(access$000, sb.toString());
                }

                public void onAdFullScreenDismissed(InMobiNative inMobiNative) {
                    Log.d(InMobiAdapter.TAG, "onAdDismissed");
                    InMobiAdapter.this.mNativeListener.onAdClosed(InMobiAdapter.this);
                }

                public void onAdFullScreenDisplayed(InMobiNative inMobiNative) {
                    InMobiAdapter.this.mNativeListener.onAdOpened(InMobiAdapter.this);
                }

                public void onUserWillLeaveApplication(InMobiNative inMobiNative) {
                    Log.d(InMobiAdapter.TAG, "onUserLeftApplication");
                    InMobiAdapter.this.mNativeListener.onAdLeftApplication(InMobiAdapter.this);
                }

                public void onAdImpressed(@NonNull InMobiNative inMobiNative) {
                    Log.d(InMobiAdapter.TAG, "InMobi impression recorded successfully");
                    InMobiAdapter.this.mNativeListener.onAdImpression(InMobiAdapter.this);
                }

                public void onAdClicked(@NonNull InMobiNative inMobiNative) {
                    InMobiAdapter.this.mNativeListener.onAdClicked(InMobiAdapter.this);
                }
            });
            this.mAdNative.setVideoEventListener(new VideoEventListener() {
                public void onVideoCompleted(InMobiNative inMobiNative) {
                    super.onVideoCompleted(inMobiNative);
                    Log.d(InMobiAdapter.TAG, "InMobi native video ad completed");
                    InMobiAdapter.this.mNativeListener.onVideoEnd(InMobiAdapter.this);
                }

                public void onVideoSkipped(InMobiNative inMobiNative) {
                    super.onVideoSkipped(inMobiNative);
                    Log.d(InMobiAdapter.TAG, "InMobi native video skipped");
                }
            });
            Set keywords = nativeMediationAdRequest.getKeywords();
            if (keywords != null) {
                this.mAdNative.setKeywords(TextUtils.join(", ", keywords));
            }
            this.mAdNative.setExtras(InMobiAdapterUtils.createInMobiParameterMap((MediationAdRequest) nativeMediationAdRequest));
            InMobiAdapterUtils.setGlobalTargeting((MediationAdRequest) nativeMediationAdRequest, bundle2);
            this.mAdNative.load();
            return;
        }
        Log.e(TAG, "Failed to request native ad. Unified Native Ad or App install Ad should be requested");
        mediationNativeListener.onAdFailedToLoad(this, 1);
    }
}
