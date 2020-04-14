package com.applovin.mediation.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.p018ad.C1089i;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter.InitializationStatus;
import com.applovin.mediation.adapter.MaxAdapter.OnCompletionListener;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

public class AppLovinMediationAdapter extends MediationAdapterBase implements MaxAdViewAdapter, MaxInterstitialAdapter, MaxRewardedAdapter, MaxSignalProvider {
    /* access modifiers changed from: private */
    public AppLovinAdView mLoadedAdView;
    /* access modifiers changed from: private */
    public AppLovinAd mLoadedInterstitialAd;
    /* access modifiers changed from: private */
    public AppLovinAd mLoadedRewardedAd;
    /* access modifiers changed from: private */
    public MaxReward mPendingReward;

    private class RewardListenerWrapper implements C1089i, AppLovinAdClickListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {
        private boolean isFullyWatched;
        private final MaxRewardedAdapterListener listener;

        private RewardListenerWrapper(MaxRewardedAdapterListener maxRewardedAdapterListener) {
            this.isFullyWatched = false;
            this.listener = maxRewardedAdapterListener;
        }

        public void adClicked(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Rewarded ad clicked");
            this.listener.onRewardedAdClicked();
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Rewarded ad shown");
            this.listener.onRewardedAdDisplayed();
        }

        public void adHidden(AppLovinAd appLovinAd) {
            if (this.isFullyWatched && AppLovinMediationAdapter.this.mPendingReward != null) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append("Rewarded user with reward: ");
                sb.append(AppLovinMediationAdapter.this.mPendingReward);
                appLovinMediationAdapter.log(sb.toString());
                this.listener.onUserRewarded(AppLovinMediationAdapter.this.mPendingReward);
                AppLovinMediationAdapter.this.mPendingReward = null;
            }
            AppLovinMediationAdapter.this.log("Rewarded ad hidden");
            this.listener.onRewardedAdHidden();
        }

        public void onAdDisplayFailed(String str) {
            MaxAdapterError maxAdapterError = new MaxAdapterError((int) MaxAdapterError.ERROR_CODE_UNSPECIFIED, str);
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            StringBuilder sb = new StringBuilder();
            sb.append("Rewarded ad failed to display with error: ");
            sb.append(maxAdapterError);
            appLovinMediationAdapter.log(sb.toString());
            this.listener.onRewardedAdDisplayFailed(maxAdapterError);
        }

        public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("User declined to view rewarded ad");
            AppLovinMediationAdapter.this.mPendingReward = null;
            this.listener.onRewardedAdDisplayFailed(MaxAdapterError.REWARD_ERROR);
        }

        public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            StringBuilder sb = new StringBuilder();
            sb.append("User is over quota: ");
            sb.append(map);
            appLovinMediationAdapter.log(sb.toString());
            AppLovinMediationAdapter.this.mPendingReward = null;
        }

        public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            StringBuilder sb = new StringBuilder();
            sb.append("Reward rejected: ");
            sb.append(map);
            appLovinMediationAdapter.log(sb.toString());
            AppLovinMediationAdapter.this.mPendingReward = null;
        }

        public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
            String str = (String) map.get("currency");
            String str2 = (String) map.get("amount");
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                AppLovinMediationAdapter.this.mPendingReward = MaxReward.createDefault();
            } else {
                int i = 0;
                try {
                    i = (int) Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to parse AppLovin reward amount: ");
                    sb.append(str2);
                    appLovinMediationAdapter.log(sb.toString(), e);
                }
                AppLovinMediationAdapter.this.mPendingReward = MaxReward.create(i, str);
            }
            AppLovinMediationAdapter appLovinMediationAdapter2 = AppLovinMediationAdapter.this;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Rewarded verified: ");
            sb2.append(AppLovinMediationAdapter.this.mPendingReward);
            appLovinMediationAdapter2.log(sb2.toString());
        }

        public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            StringBuilder sb = new StringBuilder();
            sb.append("Reward validation request failed with code: ");
            sb.append(i);
            appLovinMediationAdapter.log(sb.toString());
            AppLovinMediationAdapter.this.mPendingReward = null;
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Rewarded ad video started");
            this.listener.onRewardedAdVideoStarted();
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            StringBuilder sb = new StringBuilder();
            sb.append("Rewarded ad video ended at ");
            sb.append(d);
            sb.append("% and is fully watched: ");
            sb.append(z);
            appLovinMediationAdapter.log(sb.toString());
            this.isFullyWatched = z;
            this.listener.onRewardedAdVideoCompleted();
        }
    }

    public AppLovinMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    /* access modifiers changed from: private */
    public static MaxAdapterError toMaxError(int i) {
        int i2 = 204;
        if (i == -103) {
            i2 = MaxAdapterError.ERROR_CODE_NO_CONNECTION;
        } else if (i != 204) {
            i2 = i == -1 ? MaxAdapterError.ERROR_CODE_INTERNAL_ERROR : i >= 500 ? MaxAdapterError.ERROR_CODE_SERVER_ERROR : MaxAdapterError.ERROR_CODE_UNSPECIFIED;
        }
        return new MaxAdapterError(i2, i);
    }

    /* access modifiers changed from: private */
    public static MaxAdapterError toMaxError(AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        return MaxAdapterError.UNSPECIFIED;
    }

    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        log("Collecting signal...");
        maxSignalCollectionListener.onSignalCollected(getWrappingSdk().getAdService().getBidToken());
    }

    public String getAdapterVersion() {
        return getSdkVersion();
    }

    public String getSdkVersion() {
        return AppLovinSdk.VERSION;
    }

    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, OnCompletionListener onCompletionListener) {
        if (AppLovinSdk.VERSION_CODE >= 90800) {
            onCompletionListener.onCompletion(InitializationStatus.DOES_NOT_APPLY, null);
        } else {
            onCompletionListener.onCompletion();
        }
    }

    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, final Activity activity, final MaxAdViewAdapterListener maxAdViewAdapterListener) {
        C13031 r0 = new AppLovinAdLoadListener() {
            public void adReceived(final AppLovinAd appLovinAd) {
                AppLovinMediationAdapter.this.log("Banner ad loaded");
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        AppLovinMediationAdapter.this.mLoadedAdView = new AppLovinAdView(AppLovinMediationAdapter.this.getWrappingSdk(), appLovinAd.getSize(), (Context) activity);
                        AppLovinMediationAdapter.this.mLoadedAdView.setAdDisplayListener(new AppLovinAdDisplayListener() {
                            public void adDisplayed(AppLovinAd appLovinAd) {
                                AppLovinMediationAdapter.this.log("Banner shown");
                                maxAdViewAdapterListener.onAdViewAdDisplayed();
                            }

                            public void adHidden(AppLovinAd appLovinAd) {
                                AppLovinMediationAdapter.this.log("Banner hidden");
                                maxAdViewAdapterListener.onAdViewAdHidden();
                            }
                        });
                        AppLovinMediationAdapter.this.mLoadedAdView.setAdClickListener(new AppLovinAdClickListener() {
                            public void adClicked(AppLovinAd appLovinAd) {
                                AppLovinMediationAdapter.this.log("Banner ad clicked");
                                maxAdViewAdapterListener.onAdViewAdClicked();
                            }
                        });
                        AppLovinMediationAdapter.this.mLoadedAdView.setAdViewEventListener(new AppLovinAdViewEventListener() {
                            public void adClosedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
                                AppLovinMediationAdapter.this.log("Banner collapsed");
                                maxAdViewAdapterListener.onAdViewAdCollapsed();
                            }

                            public void adFailedToDisplay(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
                                MaxAdapterError access$100 = AppLovinMediationAdapter.toMaxError(appLovinAdViewDisplayErrorCode);
                                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                                StringBuilder sb = new StringBuilder();
                                sb.append("Banner failed to display with error: ");
                                sb.append(access$100);
                                appLovinMediationAdapter.log(sb.toString());
                                maxAdViewAdapterListener.onAdViewAdDisplayFailed(access$100);
                            }

                            public void adLeftApplication(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
                            }

                            public void adOpenedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
                                AppLovinMediationAdapter.this.log("Banner expanded");
                                maxAdViewAdapterListener.onAdViewAdExpanded();
                            }
                        });
                        maxAdViewAdapterListener.onAdViewAdLoaded(AppLovinMediationAdapter.this.mLoadedAdView);
                        AppLovinMediationAdapter.this.mLoadedAdView.renderAd(appLovinAd);
                    }
                });
            }

            public void failedToReceiveAd(int i) {
                MaxAdapterError access$200 = AppLovinMediationAdapter.toMaxError(i);
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append("Banner ad failed to load with error: ");
                sb.append(access$200);
                appLovinMediationAdapter.log(sb.toString());
                maxAdViewAdapterListener.onAdViewAdLoadFailed(access$200);
            }
        };
        if (!TextUtils.isEmpty(maxAdapterResponseParameters.getBidResponse())) {
            log("Loading bidding banner ad...");
            getWrappingSdk().getAdService().loadNextAdForAdToken(maxAdapterResponseParameters.getBidResponse(), r0);
        } else if (!TextUtils.isEmpty(maxAdapterResponseParameters.getThirdPartyAdPlacementId())) {
            String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            StringBuilder sb = new StringBuilder();
            sb.append("Loading mediated banner ad: ");
            sb.append(thirdPartyAdPlacementId);
            sb.append("...");
            log(sb.toString());
            getWrappingSdk().getAdService().loadNextAdForZoneId(thirdPartyAdPlacementId, r0);
        } else {
            AppLovinAdSize appLovinAdSize = null;
            if (maxAdFormat == MaxAdFormat.BANNER) {
                appLovinAdSize = AppLovinAdSize.BANNER;
            } else if (maxAdFormat == MaxAdFormat.MREC) {
                appLovinAdSize = AppLovinAdSize.MREC;
            } else if (maxAdFormat == MaxAdFormat.LEADER) {
                appLovinAdSize = AppLovinAdSize.LEADER;
            }
            if (appLovinAdSize != null) {
                log("Loading mediated banner ad...");
                getWrappingSdk().getAdService().loadNextAd(appLovinAdSize, r0);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to load ad for format: ");
            sb2.append(maxAdFormat);
            log(sb2.toString());
        }
    }

    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        C13082 r3 = new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd appLovinAd) {
                AppLovinMediationAdapter.this.log("Interstitial ad loaded");
                AppLovinMediationAdapter.this.mLoadedInterstitialAd = appLovinAd;
                maxInterstitialAdapterListener.onInterstitialAdLoaded();
            }

            public void failedToReceiveAd(int i) {
                MaxAdapterError access$200 = AppLovinMediationAdapter.toMaxError(i);
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append("Banner ad failed to load with error: ");
                sb.append(access$200);
                appLovinMediationAdapter.log(sb.toString());
                maxInterstitialAdapterListener.onInterstitialAdLoadFailed(access$200);
            }
        };
        if (!TextUtils.isEmpty(maxAdapterResponseParameters.getBidResponse())) {
            log("Loading bidder interstitial ad...");
            getWrappingSdk().getAdService().loadNextAdForAdToken(maxAdapterResponseParameters.getBidResponse(), r3);
        } else if (!TextUtils.isEmpty(maxAdapterResponseParameters.getThirdPartyAdPlacementId())) {
            String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            StringBuilder sb = new StringBuilder();
            sb.append("Loading mediated interstitial ad: ");
            sb.append(thirdPartyAdPlacementId);
            sb.append("...");
            log(sb.toString());
            getWrappingSdk().getAdService().loadNextAdForZoneId(thirdPartyAdPlacementId, r3);
        } else {
            log("Loading mediated interstitial ad...");
            getWrappingSdk().getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, r3);
        }
    }

    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxRewardedAdapterListener maxRewardedAdapterListener) {
        C13115 r4 = new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd appLovinAd) {
                AppLovinMediationAdapter.this.log("Rewarded ad loaded");
                AppLovinMediationAdapter.this.mLoadedRewardedAd = appLovinAd;
                maxRewardedAdapterListener.onRewardedAdLoaded();
            }

            public void failedToReceiveAd(int i) {
                MaxAdapterError access$200 = AppLovinMediationAdapter.toMaxError(i);
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append("Rewarded ad failed to load with error: ");
                sb.append(access$200);
                appLovinMediationAdapter.log(sb.toString());
                maxRewardedAdapterListener.onRewardedAdLoadFailed(access$200);
            }
        };
        if (!TextUtils.isEmpty(maxAdapterResponseParameters.getBidResponse())) {
            log("Loading bidding rewarded ad...");
            getWrappingSdk().getAdService().loadNextAdForAdToken(maxAdapterResponseParameters.getBidResponse(), r4);
        } else if (!TextUtils.isEmpty(maxAdapterResponseParameters.getThirdPartyAdPlacementId())) {
            String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            StringBuilder sb = new StringBuilder();
            sb.append("Loading mediated rewarded ad: ");
            sb.append(thirdPartyAdPlacementId);
            sb.append("...");
            log(sb.toString());
            getWrappingSdk().getAdService().loadNextAdForZoneId(maxAdapterResponseParameters.getThirdPartyAdPlacementId(), r4);
        } else {
            log("Loading mediated rewarded ad...");
            getWrappingSdk().getAdService().loadNextAdForZoneId("inter_videoa", r4);
        }
    }

    public void onDestroy() {
        this.mLoadedInterstitialAd = null;
        this.mLoadedRewardedAd = null;
        AppLovinAdView appLovinAdView = this.mLoadedAdView;
        if (appLovinAdView != null) {
            appLovinAdView.destroy();
            this.mLoadedAdView = null;
        }
    }

    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("Showing interstitial: ");
        sb.append(maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        sb.append("...");
        log(sb.toString());
        AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(getWrappingSdk(), activity);
        create.setAdDisplayListener(new C1089i() {
            public void adDisplayed(AppLovinAd appLovinAd) {
                AppLovinMediationAdapter.this.log("Interstitial ad shown");
                maxInterstitialAdapterListener.onInterstitialAdDisplayed();
            }

            public void adHidden(AppLovinAd appLovinAd) {
                AppLovinMediationAdapter.this.log("Interstitial ad hidden");
                maxInterstitialAdapterListener.onInterstitialAdHidden();
            }

            public void onAdDisplayFailed(String str) {
                MaxAdapterError maxAdapterError = new MaxAdapterError((int) MaxAdapterError.ERROR_CODE_UNSPECIFIED, str);
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append("Interstitial ad failed to display with error: ");
                sb.append(maxAdapterError);
                appLovinMediationAdapter.log(sb.toString());
                maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(maxAdapterError);
            }
        });
        create.setAdClickListener(new AppLovinAdClickListener() {
            public void adClicked(AppLovinAd appLovinAd) {
                AppLovinMediationAdapter.this.log("Interstitial ad clicked");
                maxInterstitialAdapterListener.onInterstitialAdClicked();
            }
        });
        create.showAndRender(this.mLoadedInterstitialAd);
    }

    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("Showing rewarded ad: ");
        sb.append(maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        sb.append("...");
        log(sb.toString());
        AppLovinIncentivizedInterstitial create = AppLovinIncentivizedInterstitial.create(getWrappingSdk());
        RewardListenerWrapper rewardListenerWrapper = new RewardListenerWrapper(maxRewardedAdapterListener);
        create.show(this.mLoadedRewardedAd, (Context) activity, (AppLovinAdRewardListener) rewardListenerWrapper, (AppLovinAdVideoPlaybackListener) rewardListenerWrapper, (AppLovinAdDisplayListener) rewardListenerWrapper, (AppLovinAdClickListener) rewardListenerWrapper);
    }
}
