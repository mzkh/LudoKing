package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaxi;

@KeepName
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View zznj;
    @VisibleForTesting
    private CustomEventBanner zznk;
    @VisibleForTesting
    private CustomEventInterstitial zznl;

    @VisibleForTesting
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zznh;
        private final MediationBannerListener zzni;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zznh = customEventAdapter;
            this.zzni = mediationBannerListener;
        }

        public final void onReceivedAd(View view) {
            zzaxi.zzdv("Custom event adapter called onReceivedAd.");
            this.zznh.zza(view);
            this.zzni.onReceivedAd(this.zznh);
        }

        public final void onFailedToReceiveAd() {
            zzaxi.zzdv("Custom event adapter called onFailedToReceiveAd.");
            this.zzni.onFailedToReceiveAd(this.zznh, ErrorCode.NO_FILL);
        }

        public final void onClick() {
            zzaxi.zzdv("Custom event adapter called onFailedToReceiveAd.");
            this.zzni.onClick(this.zznh);
        }

        public final void onPresentScreen() {
            zzaxi.zzdv("Custom event adapter called onFailedToReceiveAd.");
            this.zzni.onPresentScreen(this.zznh);
        }

        public final void onDismissScreen() {
            zzaxi.zzdv("Custom event adapter called onFailedToReceiveAd.");
            this.zzni.onDismissScreen(this.zznh);
        }

        public final void onLeaveApplication() {
            zzaxi.zzdv("Custom event adapter called onFailedToReceiveAd.");
            this.zzni.onLeaveApplication(this.zznh);
        }
    }

    @VisibleForTesting
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zznh;
        private final MediationInterstitialListener zznm;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zznh = customEventAdapter;
            this.zznm = mediationInterstitialListener;
        }

        public final void onReceivedAd() {
            zzaxi.zzdv("Custom event adapter called onReceivedAd.");
            this.zznm.onReceivedAd(CustomEventAdapter.this);
        }

        public final void onFailedToReceiveAd() {
            zzaxi.zzdv("Custom event adapter called onFailedToReceiveAd.");
            this.zznm.onFailedToReceiveAd(this.zznh, ErrorCode.NO_FILL);
        }

        public final void onPresentScreen() {
            zzaxi.zzdv("Custom event adapter called onPresentScreen.");
            this.zznm.onPresentScreen(this.zznh);
        }

        public final void onDismissScreen() {
            zzaxi.zzdv("Custom event adapter called onDismissScreen.");
            this.zznm.onDismissScreen(this.zznh);
        }

        public final void onLeaveApplication() {
            zzaxi.zzdv("Custom event adapter called onLeaveApplication.");
            this.zznm.onLeaveApplication(this.zznh);
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

    public final void destroy() {
        CustomEventBanner customEventBanner = this.zznk;
        if (customEventBanner != null) {
            customEventBanner.destroy();
        }
        CustomEventInterstitial customEventInterstitial = this.zznl;
        if (customEventInterstitial != null) {
            customEventInterstitial.destroy();
        }
    }

    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public final View getBannerView() {
        return this.zznj;
    }

    public final Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public final void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        Object obj;
        this.zznk = (CustomEventBanner) zzam(customEventServerParameters.className);
        if (this.zznk == null) {
            mediationBannerListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras == null) {
            obj = null;
        } else {
            obj = customEventExtras.getExtra(customEventServerParameters.label);
        }
        Activity activity2 = activity;
        this.zznk.requestBannerAd(new zza(this, mediationBannerListener), activity2, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, obj);
    }

    public final void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        Object obj;
        this.zznl = (CustomEventInterstitial) zzam(customEventServerParameters.className);
        if (this.zznl == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras == null) {
            obj = null;
        } else {
            obj = customEventExtras.getExtra(customEventServerParameters.label);
        }
        Activity activity2 = activity;
        this.zznl.requestInterstitialAd(new zzb(this, mediationInterstitialListener), activity2, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, obj);
    }

    public final void showInterstitial() {
        this.zznl.showInterstitial();
    }

    /* access modifiers changed from: private */
    public final void zza(View view) {
        this.zznj = view;
    }
}
