package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaxi;

@KeepName
@KeepForSdkWithMembers
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    @VisibleForTesting
    private CustomEventBanner zzejl;
    @VisibleForTesting
    private CustomEventInterstitial zzejm;
    @VisibleForTesting
    private CustomEventNative zzejn;
    private View zznj;

    @VisibleForTesting
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzejj;
        private final MediationBannerListener zzejk;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzejj = customEventAdapter;
            this.zzejk = mediationBannerListener;
        }

        public final void onAdLoaded(View view) {
            zzaxi.zzdv("Custom event adapter called onAdLoaded.");
            this.zzejj.zza(view);
            this.zzejk.onAdLoaded(this.zzejj);
        }

        public final void onAdFailedToLoad(int i) {
            zzaxi.zzdv("Custom event adapter called onAdFailedToLoad.");
            this.zzejk.onAdFailedToLoad(this.zzejj, i);
        }

        public final void onAdClicked() {
            zzaxi.zzdv("Custom event adapter called onAdClicked.");
            this.zzejk.onAdClicked(this.zzejj);
        }

        public final void onAdOpened() {
            zzaxi.zzdv("Custom event adapter called onAdOpened.");
            this.zzejk.onAdOpened(this.zzejj);
        }

        public final void onAdClosed() {
            zzaxi.zzdv("Custom event adapter called onAdClosed.");
            this.zzejk.onAdClosed(this.zzejj);
        }

        public final void onAdLeftApplication() {
            zzaxi.zzdv("Custom event adapter called onAdLeftApplication.");
            this.zzejk.onAdLeftApplication(this.zzejj);
        }
    }

    @VisibleForTesting
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    static class zzb implements CustomEventNativeListener {
        private final CustomEventAdapter zzejj;
        private final MediationNativeListener zzejo;

        public zzb(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.zzejj = customEventAdapter;
            this.zzejo = mediationNativeListener;
        }

        public final void onAdLoaded(NativeAdMapper nativeAdMapper) {
            zzaxi.zzdv("Custom event adapter called onAdLoaded.");
            this.zzejo.onAdLoaded((MediationNativeAdapter) this.zzejj, nativeAdMapper);
        }

        public final void onAdLoaded(UnifiedNativeAdMapper unifiedNativeAdMapper) {
            zzaxi.zzdv("Custom event adapter called onAdLoaded.");
            this.zzejo.onAdLoaded((MediationNativeAdapter) this.zzejj, unifiedNativeAdMapper);
        }

        public final void onAdFailedToLoad(int i) {
            zzaxi.zzdv("Custom event adapter called onAdFailedToLoad.");
            this.zzejo.onAdFailedToLoad(this.zzejj, i);
        }

        public final void onAdOpened() {
            zzaxi.zzdv("Custom event adapter called onAdOpened.");
            this.zzejo.onAdOpened(this.zzejj);
        }

        public final void onAdClicked() {
            zzaxi.zzdv("Custom event adapter called onAdClicked.");
            this.zzejo.onAdClicked(this.zzejj);
        }

        public final void onAdClosed() {
            zzaxi.zzdv("Custom event adapter called onAdClosed.");
            this.zzejo.onAdClosed(this.zzejj);
        }

        public final void onAdLeftApplication() {
            zzaxi.zzdv("Custom event adapter called onAdLeftApplication.");
            this.zzejo.onAdLeftApplication(this.zzejj);
        }

        public final void onAdImpression() {
            zzaxi.zzdv("Custom event adapter called onAdImpression.");
            this.zzejo.onAdImpression(this.zzejj);
        }
    }

    @VisibleForTesting
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    class zzc implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzejj;
        private final MediationInterstitialListener zzejp;

        public zzc(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzejj = customEventAdapter;
            this.zzejp = mediationInterstitialListener;
        }

        public final void onAdLoaded() {
            zzaxi.zzdv("Custom event adapter called onReceivedAd.");
            this.zzejp.onAdLoaded(CustomEventAdapter.this);
        }

        public final void onAdFailedToLoad(int i) {
            zzaxi.zzdv("Custom event adapter called onFailedToReceiveAd.");
            this.zzejp.onAdFailedToLoad(this.zzejj, i);
        }

        public final void onAdClicked() {
            zzaxi.zzdv("Custom event adapter called onAdClicked.");
            this.zzejp.onAdClicked(this.zzejj);
        }

        public final void onAdOpened() {
            zzaxi.zzdv("Custom event adapter called onAdOpened.");
            this.zzejp.onAdOpened(this.zzejj);
        }

        public final void onAdClosed() {
            zzaxi.zzdv("Custom event adapter called onAdClosed.");
            this.zzejp.onAdClosed(this.zzejj);
        }

        public final void onAdLeftApplication() {
            zzaxi.zzdv("Custom event adapter called onAdLeftApplication.");
            this.zzejp.onAdLeftApplication(this.zzejj);
        }
    }

    private static <T> T zzam(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzaxi.zzeu(sb.toString());
            return null;
        }
    }

    public final void onDestroy() {
        CustomEventBanner customEventBanner = this.zzejl;
        if (customEventBanner != null) {
            customEventBanner.onDestroy();
        }
        CustomEventInterstitial customEventInterstitial = this.zzejm;
        if (customEventInterstitial != null) {
            customEventInterstitial.onDestroy();
        }
        CustomEventNative customEventNative = this.zzejn;
        if (customEventNative != null) {
            customEventNative.onDestroy();
        }
    }

    public final void onPause() {
        CustomEventBanner customEventBanner = this.zzejl;
        if (customEventBanner != null) {
            customEventBanner.onPause();
        }
        CustomEventInterstitial customEventInterstitial = this.zzejm;
        if (customEventInterstitial != null) {
            customEventInterstitial.onPause();
        }
        CustomEventNative customEventNative = this.zzejn;
        if (customEventNative != null) {
            customEventNative.onPause();
        }
    }

    public final void onResume() {
        CustomEventBanner customEventBanner = this.zzejl;
        if (customEventBanner != null) {
            customEventBanner.onResume();
        }
        CustomEventInterstitial customEventInterstitial = this.zzejm;
        if (customEventInterstitial != null) {
            customEventInterstitial.onResume();
        }
        CustomEventNative customEventNative = this.zzejn;
        if (customEventNative != null) {
            customEventNative.onResume();
        }
    }

    public final View getBannerView() {
        return this.zznj;
    }

    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        Bundle bundle3;
        String str = "class_name";
        this.zzejl = (CustomEventBanner) zzam(bundle.getString(str));
        if (this.zzejl == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
            return;
        }
        if (bundle2 == null) {
            bundle3 = null;
        } else {
            bundle3 = bundle2.getBundle(bundle.getString(str));
        }
        Context context2 = context;
        this.zzejl.requestBannerAd(context2, new zza(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle3);
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        Bundle bundle3;
        String str = "class_name";
        this.zzejm = (CustomEventInterstitial) zzam(bundle.getString(str));
        if (this.zzejm == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
            return;
        }
        if (bundle2 == null) {
            bundle3 = null;
        } else {
            bundle3 = bundle2.getBundle(bundle.getString(str));
        }
        Context context2 = context;
        this.zzejm.requestInterstitialAd(context2, new zzc(this, mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle3);
    }

    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        Bundle bundle3;
        String str = "class_name";
        this.zzejn = (CustomEventNative) zzam(bundle.getString(str));
        if (this.zzejn == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
            return;
        }
        if (bundle2 == null) {
            bundle3 = null;
        } else {
            bundle3 = bundle2.getBundle(bundle.getString(str));
        }
        Context context2 = context;
        this.zzejn.requestNativeAd(context2, new zzb(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle3);
    }

    public final void showInterstitial() {
        this.zzejm.showInterstitial();
    }

    /* access modifiers changed from: private */
    public final void zza(View view) {
        this.zznj = view;
    }
}
