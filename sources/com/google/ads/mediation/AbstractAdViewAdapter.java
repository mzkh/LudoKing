package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAdViewHolder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzawy;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzbej;
import com.google.android.gms.internal.ads.zztp;
import com.google.android.gms.internal.ads.zzuv;
import com.google.android.gms.internal.ads.zzwr;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, com.google.android.gms.ads.mediation.zza, MediationRewardedVideoAdAdapter, zzbej {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzmn;
    private InterstitialAd zzmo;
    private AdLoader zzmp;
    private Context zzmq;
    /* access modifiers changed from: private */
    public InterstitialAd zzmr;
    /* access modifiers changed from: private */
    public MediationRewardedVideoAdListener zzms;
    @VisibleForTesting
    private final RewardedVideoAdListener zzmt = new zzb(this);

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    static class zza extends NativeContentAdMapper {
        private final NativeContentAd zzmv;

        public zza(NativeContentAd nativeContentAd) {
            this.zzmv = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeContentAd.getVideoController());
        }

        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzmv);
            }
            NativeAdViewHolder nativeAdViewHolder = (NativeAdViewHolder) NativeAdViewHolder.zzbke.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd((NativeAd) this.zzmv);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    static class zzb extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd zzmw;

        public zzb(NativeAppInstallAd nativeAppInstallAd) {
            this.zzmw = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeAppInstallAd.getVideoController());
        }

        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzmw);
            }
            NativeAdViewHolder nativeAdViewHolder = (NativeAdViewHolder) NativeAdViewHolder.zzbke.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd((NativeAd) this.zzmw);
            }
        }
    }

    @VisibleForTesting
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    static final class zzc extends AdListener implements AppEventListener, zztp {
        @VisibleForTesting
        private final AbstractAdViewAdapter zzmx;
        @VisibleForTesting
        private final MediationBannerListener zzmy;

        public zzc(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            this.zzmx = abstractAdViewAdapter;
            this.zzmy = mediationBannerListener;
        }

        public final void onAdLoaded() {
            this.zzmy.onAdLoaded(this.zzmx);
        }

        public final void onAdFailedToLoad(int i) {
            this.zzmy.onAdFailedToLoad(this.zzmx, i);
        }

        public final void onAdOpened() {
            this.zzmy.onAdOpened(this.zzmx);
        }

        public final void onAdClosed() {
            this.zzmy.onAdClosed(this.zzmx);
        }

        public final void onAdLeftApplication() {
            this.zzmy.onAdLeftApplication(this.zzmx);
        }

        public final void onAdClicked() {
            this.zzmy.onAdClicked(this.zzmx);
        }

        public final void onAppEvent(String str, String str2) {
            this.zzmy.zza(this.zzmx, str, str2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    static class zzd extends UnifiedNativeAdMapper {
        private final UnifiedNativeAd zzmz;

        public zzd(UnifiedNativeAd unifiedNativeAd) {
            this.zzmz = unifiedNativeAd;
            setHeadline(unifiedNativeAd.getHeadline());
            setImages(unifiedNativeAd.getImages());
            setBody(unifiedNativeAd.getBody());
            setIcon(unifiedNativeAd.getIcon());
            setCallToAction(unifiedNativeAd.getCallToAction());
            setAdvertiser(unifiedNativeAd.getAdvertiser());
            setStarRating(unifiedNativeAd.getStarRating());
            setStore(unifiedNativeAd.getStore());
            setPrice(unifiedNativeAd.getPrice());
            zzn(unifiedNativeAd.zzji());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(unifiedNativeAd.getVideoController());
        }

        public final void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            if (view instanceof UnifiedNativeAdView) {
                ((UnifiedNativeAdView) view).setNativeAd(this.zzmz);
                return;
            }
            NativeAdViewHolder nativeAdViewHolder = (NativeAdViewHolder) NativeAdViewHolder.zzbke.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.zzmz);
            }
        }
    }

    @VisibleForTesting
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    static final class zze extends AdListener implements OnAppInstallAdLoadedListener, OnContentAdLoadedListener, OnCustomClickListener, OnCustomTemplateAdLoadedListener, OnUnifiedNativeAdLoadedListener {
        @VisibleForTesting
        private final AbstractAdViewAdapter zzmx;
        @VisibleForTesting
        private final MediationNativeListener zzna;

        public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.zzmx = abstractAdViewAdapter;
            this.zzna = mediationNativeListener;
        }

        public final void onAdLoaded() {
        }

        public final void onAdFailedToLoad(int i) {
            this.zzna.onAdFailedToLoad(this.zzmx, i);
        }

        public final void onAdOpened() {
            this.zzna.onAdOpened(this.zzmx);
        }

        public final void onAdClosed() {
            this.zzna.onAdClosed(this.zzmx);
        }

        public final void onAdLeftApplication() {
            this.zzna.onAdLeftApplication(this.zzmx);
        }

        public final void onAdClicked() {
            this.zzna.onAdClicked(this.zzmx);
        }

        public final void onAdImpression() {
            this.zzna.onAdImpression(this.zzmx);
        }

        public final void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.zzna.onAdLoaded((MediationNativeAdapter) this.zzmx, (NativeAdMapper) new zzb(nativeAppInstallAd));
        }

        public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
            this.zzna.onAdLoaded((MediationNativeAdapter) this.zzmx, (UnifiedNativeAdMapper) new zzd(unifiedNativeAd));
        }

        public final void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.zzna.onAdLoaded((MediationNativeAdapter) this.zzmx, (NativeAdMapper) new zza(nativeContentAd));
        }

        public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
            this.zzna.zza(this.zzmx, nativeCustomTemplateAd);
        }

        public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            this.zzna.zza(this.zzmx, nativeCustomTemplateAd, str);
        }
    }

    @VisibleForTesting
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    static final class zzf extends AdListener implements zztp {
        @VisibleForTesting
        private final AbstractAdViewAdapter zzmx;
        @VisibleForTesting
        private final MediationInterstitialListener zznb;

        public zzf(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzmx = abstractAdViewAdapter;
            this.zznb = mediationInterstitialListener;
        }

        public final void onAdLoaded() {
            this.zznb.onAdLoaded(this.zzmx);
        }

        public final void onAdFailedToLoad(int i) {
            this.zznb.onAdFailedToLoad(this.zzmx, i);
        }

        public final void onAdOpened() {
            this.zznb.onAdOpened(this.zzmx);
        }

        public final void onAdClosed() {
            this.zznb.onAdClosed(this.zzmx);
        }

        public final void onAdLeftApplication() {
            this.zznb.onAdLeftApplication(this.zzmx);
        }

        public final void onAdClicked() {
            this.zznb.onAdClicked(this.zzmx);
        }
    }

    /* access modifiers changed from: protected */
    public abstract Bundle zza(Bundle bundle, Bundle bundle2);

    private final AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            zzuv.zzoj();
            builder.addTestDevice(zzawy.zzbi(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            boolean z = true;
            if (mediationAdRequest.taggedForChildDirectedTreatment() != 1) {
                z = false;
            }
            builder.tagForChildDirectedTreatment(z);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }

    public void onDestroy() {
        AdView adView = this.zzmn;
        if (adView != null) {
            adView.destroy();
            this.zzmn = null;
        }
        if (this.zzmo != null) {
            this.zzmo = null;
        }
        if (this.zzmp != null) {
            this.zzmp = null;
        }
        if (this.zzmr != null) {
            this.zzmr = null;
        }
    }

    public void onPause() {
        AdView adView = this.zzmn;
        if (adView != null) {
            adView.pause();
        }
    }

    public void onResume() {
        AdView adView = this.zzmn;
        if (adView != null) {
            adView.resume();
        }
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString("pubid");
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzmn = new AdView(context);
        this.zzmn.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzmn.setAdUnitId(getAdUnitId(bundle));
        this.zzmn.setAdListener(new zzc(this, mediationBannerListener));
        this.zzmn.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public View getBannerView() {
        return this.zzmn;
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzmo = new InterstitialAd(context);
        this.zzmo.setAdUnitId(getAdUnitId(bundle));
        this.zzmo.setAdListener(new zzf(this, mediationInterstitialListener));
        this.zzmo.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void onImmersiveModeUpdated(boolean z) {
        InterstitialAd interstitialAd = this.zzmo;
        if (interstitialAd != null) {
            interstitialAd.setImmersiveMode(z);
        }
        InterstitialAd interstitialAd2 = this.zzmr;
        if (interstitialAd2 != null) {
            interstitialAd2.setImmersiveMode(z);
        }
    }

    public zzwr getVideoController() {
        AdView adView = this.zzmn;
        if (adView != null) {
            VideoController videoController = adView.getVideoController();
            if (videoController != null) {
                return videoController.zzde();
            }
        }
        return null;
    }

    public void showInterstitial() {
        this.zzmo.show();
    }

    public Bundle getInterstitialAdapterInfo() {
        return new com.google.android.gms.ads.mediation.MediationAdapter.zza().zzdc(1).zzaaz();
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        zze zze2 = new zze(this, mediationNativeListener);
        AdLoader.Builder withAdListener = new AdLoader.Builder(context, bundle.getString("pubid")).withAdListener(zze2);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            withAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            withAdListener.forUnifiedNativeAd(zze2);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(zze2);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(zze2);
        }
        if (nativeMediationAdRequest.zzsd()) {
            for (String str : nativeMediationAdRequest.zzse().keySet()) {
                withAdListener.forCustomTemplateAd(str, zze2, ((Boolean) nativeMediationAdRequest.zzse().get(str)).booleanValue() ? zze2 : null);
            }
        }
        this.zzmp = withAdListener.build();
        this.zzmp.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzmq = context.getApplicationContext();
        this.zzms = mediationRewardedVideoAdListener;
        this.zzms.onInitializationSucceeded(this);
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Context context = this.zzmq;
        if (context == null || this.zzms == null) {
            zzaxi.zzes("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzmr = new InterstitialAd(context);
        this.zzmr.zzc(true);
        this.zzmr.setAdUnitId(getAdUnitId(bundle));
        this.zzmr.setRewardedVideoAdListener(this.zzmt);
        this.zzmr.setAdMetadataListener(new zza(this));
        this.zzmr.loadAd(zza(this.zzmq, mediationAdRequest, bundle2, bundle));
    }

    public void showVideo() {
        this.zzmr.show();
    }

    public boolean isInitialized() {
        return this.zzms != null;
    }
}
