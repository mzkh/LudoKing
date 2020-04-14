package com.applovin.impl.sdk.utils;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p018ad.C1089i;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.utils.i */
public class C1248i {
    /* renamed from: a */
    public static void m2993a(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdViewEventListener.adOpenedFullscreen(C1248i.m3007b(appLovinAd), appLovinAdView);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen opened event", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2994a(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdLoaded(maxAd);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being loaded", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2995a(final MaxAdListener maxAdListener, final MaxAd maxAd, final int i) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdDisplayFailed(maxAd, i);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad failing to display", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2996a(final MaxAdListener maxAdListener, final MaxAd maxAd, final MaxReward maxReward) {
        if (maxAd != null && (maxAdListener instanceof MaxRewardedAdListener)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        ((MaxRewardedAdListener) maxAdListener).onUserRewarded(maxAd, maxReward);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about user being rewarded", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2997a(final MaxAdListener maxAdListener, final String str, final int i) {
        if (str != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdLoadFailed(str, i);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad failing to load", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2998a(final AppLovinAdClickListener appLovinAdClickListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdClickListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdClickListener.adClicked(C1248i.m3007b(appLovinAd));
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2999a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdDisplayListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdDisplayListener.adDisplayed(C1248i.m3007b(appLovinAd));
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m3000a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final String str) {
        if (appLovinAdDisplayListener instanceof C1089i) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    ((C1089i) appLovinAdDisplayListener).onAdDisplayFailed(str);
                }
            });
        }
    }

    /* renamed from: a */
    public static void m3001a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final int i) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdRewardListener.validationRequestFailed(C1248i.m3007b(appLovinAd), i);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request failing", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m3002a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdRewardListener.userRewardVerified(C1248i.m3007b(appLovinAd), map);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad reward listener about successful reward validation request", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m3003a(final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdVideoPlaybackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdVideoPlaybackListener.videoPlaybackBegan(C1248i.m3007b(appLovinAd));
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback began", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m3004a(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd, double d, boolean z) {
        if (appLovinAd != null && appLovinAdVideoPlaybackListener != null) {
            final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener2 = appLovinAdVideoPlaybackListener;
            final AppLovinAd appLovinAd2 = appLovinAd;
            final double d2 = d;
            final boolean z2 = z;
            C126423 r0 = new Runnable() {
                public void run() {
                    try {
                        appLovinAdVideoPlaybackListener2.videoPlaybackEnded(C1248i.m3007b(appLovinAd2), d2, z2);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback ended", th);
                    }
                }
            };
            AppLovinSdkUtils.runOnUiThread(r0);
        }
    }

    /* renamed from: a */
    public static void m3005a(final AppLovinPostbackListener appLovinPostbackListener, final String str) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinPostbackListener.onPostbackSuccess(str);
                    } catch (Throwable th) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unable to notify AppLovinPostbackListener about postback URL (");
                        sb.append(str);
                        sb.append(") executed");
                        C1227o.m2837c("ListenerCallbackInvoker", sb.toString(), th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m3006a(final AppLovinPostbackListener appLovinPostbackListener, final String str, final int i) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinPostbackListener.onPostbackFailure(str, i);
                    } catch (Throwable th) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unable to notify AppLovinPostbackListener about postback URL (");
                        sb.append(str);
                        sb.append(") failing to execute with error code (");
                        sb.append(i);
                        sb.append("):");
                        C1227o.m2837c("ListenerCallbackInvoker", sb.toString(), th);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static AppLovinAd m3007b(AppLovinAd appLovinAd) {
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) appLovinAd;
        return appLovinAdBase.getDummyAd() != null ? appLovinAdBase.getDummyAd() : appLovinAd;
    }

    /* renamed from: b */
    public static void m3008b(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdViewEventListener.adClosedFullscreen(C1248i.m3007b(appLovinAd), appLovinAdView);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen closed event", th);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public static void m3009b(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdDisplayed(maxAd);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public static void m3010b(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdDisplayListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdDisplayListener.adHidden(C1248i.m3007b(appLovinAd));
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public static void m3011b(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdRewardListener.userOverQuota(C1248i.m3007b(appLovinAd), map);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad reward listener about exceeding quota", th);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    public static void m3012c(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdViewEventListener.adLeftApplication(C1248i.m3007b(appLovinAd), appLovinAdView);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about application leave event", th);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    public static void m3013c(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdHidden(maxAd);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    public static void m3014c(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdRewardListener.userRewardRejected(C1248i.m3007b(appLovinAd), map);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request being rejected", th);
                    }
                }
            });
        }
    }

    /* renamed from: d */
    public static void m3015d(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdClicked(maxAd);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th);
                    }
                }
            });
        }
    }

    /* renamed from: e */
    public static void m3016e(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && (maxAdListener instanceof MaxRewardedAdListener)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        ((MaxRewardedAdListener) maxAdListener).onRewardedVideoStarted(maxAd);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about rewarded video starting", th);
                    }
                }
            });
        }
    }

    /* renamed from: f */
    public static void m3017f(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && (maxAdListener instanceof MaxRewardedAdListener)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        ((MaxRewardedAdListener) maxAdListener).onRewardedVideoCompleted(maxAd);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about rewarded video completing", th);
                    }
                }
            });
        }
    }

    /* renamed from: g */
    public static void m3018g(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && (maxAdListener instanceof MaxAdViewAdListener)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        ((MaxAdViewAdListener) maxAdListener).onAdExpanded(maxAd);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being expanded", th);
                    }
                }
            });
        }
    }

    /* renamed from: h */
    public static void m3019h(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && (maxAdListener instanceof MaxAdViewAdListener)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        ((MaxAdViewAdListener) maxAdListener).onAdCollapsed(maxAd);
                    } catch (Throwable th) {
                        C1227o.m2837c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being collapsed", th);
                    }
                }
            });
        }
    }
}
