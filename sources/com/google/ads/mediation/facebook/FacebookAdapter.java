package com.google.ads.mediation.facebook;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdView;
import com.facebook.ads.C1431Ad;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase.NativeAdLoadConfigBuilder;
import com.facebook.ads.NativeAdBase.Rating;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;

@Keep
public final class FacebookAdapter extends FacebookMediationAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    public static final String KEY_ID = "id";
    public static final String KEY_SOCIAL_CONTEXT_ASSET = "social_context";
    private static final int MAX_STAR_RATING = 5;
    /* access modifiers changed from: private */
    public AtomicBoolean didInterstitialAdClose = new AtomicBoolean();
    /* access modifiers changed from: private */
    public boolean isNativeBanner;
    private AdView mAdView;
    /* access modifiers changed from: private */
    public MediationBannerListener mBannerListener;
    private InterstitialAd mInterstitialAd;
    /* access modifiers changed from: private */
    public MediationInterstitialListener mInterstitialListener;
    /* access modifiers changed from: private */
    public boolean mIsImpressionRecorded;
    /* access modifiers changed from: private */
    public MediaView mMediaView;
    private NativeAd mNativeAd;
    private NativeBannerAd mNativeBannerAd;
    /* access modifiers changed from: private */
    public MediationNativeListener mNativeListener;
    private RelativeLayout mWrappedAdView;

    class AppInstallMapper extends NativeAppInstallAdMapper {
        private NativeAd mNativeAd;
        private NativeAdOptions mNativeAdOptions;
        private NativeBannerAd mNativeBannerAd;

        public AppInstallMapper(NativeAd nativeAd, NativeAdOptions nativeAdOptions) {
            this.mNativeAd = nativeAd;
            this.mNativeAdOptions = nativeAdOptions;
        }

        public AppInstallMapper(NativeBannerAd nativeBannerAd, NativeAdOptions nativeAdOptions) {
            this.mNativeBannerAd = nativeBannerAd;
            this.mNativeAdOptions = nativeAdOptions;
        }

        public void mapNativeAd(Context context, NativeAdMapperListener nativeAdMapperListener) {
            AdOptionsView adOptionsView;
            boolean access$1300 = FacebookAdapter.this.isNativeBanner;
            String str = FacebookAdapter.KEY_SOCIAL_CONTEXT_ASSET;
            String str2 = "id";
            if (access$1300) {
                if (!containsRequiredFieldsForNativeBannerAd(this.mNativeBannerAd)) {
                    Log.w(FacebookMediationAdapter.TAG, "Ad from Facebook doesn't have all assets required for the Native Banner Ad format.");
                    nativeAdMapperListener.onMappingFailed();
                    return;
                }
                setHeadline(this.mNativeBannerAd.getAdHeadline());
                setBody(this.mNativeBannerAd.getAdBodyText());
                setIcon(new FacebookAdapterNativeAdImage(Uri.parse(this.mNativeBannerAd.getAdIcon().toString())));
                setCallToAction(this.mNativeBannerAd.getAdCallToAction());
                Bundle bundle = new Bundle();
                bundle.putCharSequence(str2, this.mNativeBannerAd.getId());
                bundle.putCharSequence(str, this.mNativeBannerAd.getAdSocialContext());
                setExtras(bundle);
            } else if (!containsRequiredFieldsForNativeAppInstallAd(this.mNativeAd)) {
                Log.w(FacebookMediationAdapter.TAG, "Ad from Facebook doesn't have all assets required for the app install format.");
                nativeAdMapperListener.onMappingFailed();
                return;
            } else {
                setHeadline(this.mNativeAd.getAdHeadline());
                ArrayList arrayList = new ArrayList();
                arrayList.add(new FacebookAdapterNativeAdImage(Uri.parse(this.mNativeAd.getAdCoverImage().toString())));
                setImages(arrayList);
                setBody(this.mNativeAd.getAdBodyText());
                setIcon(new FacebookAdapterNativeAdImage(Uri.parse(this.mNativeAd.getAdIcon().toString())));
                setCallToAction(this.mNativeAd.getAdCallToAction());
                FacebookAdapter.this.mMediaView.setListener(new MediaViewListener() {
                    public void onEnterFullscreen(MediaView mediaView) {
                    }

                    public void onExitFullscreen(MediaView mediaView) {
                    }

                    public void onFullscreenBackground(MediaView mediaView) {
                    }

                    public void onFullscreenForeground(MediaView mediaView) {
                    }

                    public void onPause(MediaView mediaView) {
                    }

                    public void onPlay(MediaView mediaView) {
                    }

                    public void onVolumeChange(MediaView mediaView, float f) {
                    }

                    public void onComplete(MediaView mediaView) {
                        if (FacebookAdapter.this.mNativeListener != null) {
                            FacebookAdapter.this.mNativeListener.onVideoEnd(FacebookAdapter.this);
                        }
                    }
                });
                setMediaView(FacebookAdapter.this.mMediaView);
                setHasVideoContent(true);
                Double rating = getRating(this.mNativeAd.getAdStarRating());
                if (rating != null) {
                    setStarRating(rating.doubleValue());
                }
                Bundle bundle2 = new Bundle();
                bundle2.putCharSequence(str2, this.mNativeAd.getId());
                bundle2.putCharSequence(str, this.mNativeAd.getAdSocialContext());
                setExtras(bundle2);
            }
            NativeAdLayout nativeAdLayout = new NativeAdLayout(context);
            if (FacebookAdapter.this.isNativeBanner) {
                adOptionsView = new AdOptionsView(context, this.mNativeBannerAd, nativeAdLayout);
            } else {
                adOptionsView = new AdOptionsView(context, this.mNativeAd, nativeAdLayout);
            }
            setAdChoicesContent(adOptionsView);
            nativeAdMapperListener.onMappingSuccess();
        }

        private boolean containsRequiredFieldsForNativeAppInstallAd(NativeAd nativeAd) {
            return (nativeAd.getAdHeadline() == null || nativeAd.getAdCoverImage() == null || nativeAd.getAdBodyText() == null || nativeAd.getAdIcon() == null || nativeAd.getAdCallToAction() == null || FacebookAdapter.this.mMediaView == null) ? false : true;
        }

        private boolean containsRequiredFieldsForNativeBannerAd(NativeBannerAd nativeBannerAd) {
            return (nativeBannerAd.getAdHeadline() == null || nativeBannerAd.getAdBodyText() == null || nativeBannerAd.getAdIcon() == null || nativeBannerAd.getAdCallToAction() == null) ? false : true;
        }

        public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            ArrayList arrayList = new ArrayList();
            ImageView imageView = null;
            for (Entry entry : map.entrySet()) {
                arrayList.add(entry.getValue());
                if (((String) entry.getKey()).equals(NativeAppInstallAd.ASSET_ICON) || ((String) entry.getKey()).equals(UnifiedNativeAdAssetNames.ASSET_ICON)) {
                    imageView = (ImageView) entry.getValue();
                }
            }
            if (FacebookAdapter.this.isNativeBanner) {
                this.mNativeBannerAd.registerViewForInteraction(view, imageView);
            } else {
                this.mNativeAd.registerViewForInteraction(view, FacebookAdapter.this.mMediaView, imageView, (List<View>) arrayList);
            }
        }

        public void untrackView(View view) {
            super.untrackView(view);
        }

        private Double getRating(Rating rating) {
            if (rating == null) {
                return null;
            }
            return Double.valueOf((rating.getValue() * 5.0d) / rating.getScale());
        }
    }

    private class BannerListener implements AdListener {
        public void onLoggingImpression(C1431Ad ad) {
        }

        private BannerListener() {
        }

        public void onAdClicked(C1431Ad ad) {
            FacebookAdapter.this.mBannerListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mBannerListener.onAdOpened(FacebookAdapter.this);
            FacebookAdapter.this.mBannerListener.onAdLeftApplication(FacebookAdapter.this);
        }

        public void onAdLoaded(C1431Ad ad) {
            FacebookAdapter.this.mBannerListener.onAdLoaded(FacebookAdapter.this);
        }

        public void onError(C1431Ad ad, AdError adError) {
            String errorMessage = adError.getErrorMessage();
            if (!TextUtils.isEmpty(errorMessage)) {
                Log.w(FacebookMediationAdapter.TAG, errorMessage);
            }
            MediationBannerListener access$100 = FacebookAdapter.this.mBannerListener;
            FacebookAdapter facebookAdapter = FacebookAdapter.this;
            access$100.onAdFailedToLoad(facebookAdapter, facebookAdapter.convertErrorCode(adError));
        }
    }

    private class FacebookAdapterNativeAdImage extends Image {
        private Drawable mDrawable;
        private Uri mUri;

        public double getScale() {
            return 1.0d;
        }

        public FacebookAdapterNativeAdImage(Uri uri) {
            this.mUri = uri;
        }

        /* access modifiers changed from: protected */
        public void setDrawable(Drawable drawable) {
            this.mDrawable = drawable;
        }

        public Drawable getDrawable() {
            return this.mDrawable;
        }

        public Uri getUri() {
            return this.mUri;
        }
    }

    private class InterstitialListener implements InterstitialAdExtendedListener {
        public void onLoggingImpression(C1431Ad ad) {
        }

        public void onRewardedAdCompleted() {
        }

        public void onRewardedAdServerFailed() {
        }

        public void onRewardedAdServerSucceeded() {
        }

        private InterstitialListener() {
        }

        public void onAdClicked(C1431Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mInterstitialListener.onAdLeftApplication(FacebookAdapter.this);
        }

        public void onAdLoaded(C1431Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdLoaded(FacebookAdapter.this);
        }

        public void onError(C1431Ad ad, AdError adError) {
            String errorMessage = adError.getErrorMessage();
            if (!TextUtils.isEmpty(errorMessage)) {
                Log.w(FacebookMediationAdapter.TAG, errorMessage);
            }
            MediationInterstitialListener access$300 = FacebookAdapter.this.mInterstitialListener;
            FacebookAdapter facebookAdapter = FacebookAdapter.this;
            access$300.onAdFailedToLoad(facebookAdapter, facebookAdapter.convertErrorCode(adError));
        }

        public void onInterstitialDismissed(C1431Ad ad) {
            if (!FacebookAdapter.this.didInterstitialAdClose.getAndSet(true)) {
                FacebookAdapter.this.mInterstitialListener.onAdClosed(FacebookAdapter.this);
            }
        }

        public void onInterstitialDisplayed(C1431Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdOpened(FacebookAdapter.this);
        }

        public void onInterstitialActivityDestroyed() {
            if (!FacebookAdapter.this.didInterstitialAdClose.getAndSet(true)) {
                FacebookAdapter.this.mInterstitialListener.onAdClosed(FacebookAdapter.this);
            }
        }
    }

    private interface NativeAdMapperListener {
        void onMappingFailed();

        void onMappingSuccess();
    }

    private class NativeBannerListener implements AdListener, NativeAdListener {
        private WeakReference<Context> mContext;
        private NativeMediationAdRequest mMediationAdRequest;
        private NativeBannerAd mNativeBannerAd;

        private NativeBannerListener(Context context, NativeBannerAd nativeBannerAd, NativeMediationAdRequest nativeMediationAdRequest) {
            this.mContext = new WeakReference<>(context);
            this.mNativeBannerAd = nativeBannerAd;
            this.mMediationAdRequest = nativeMediationAdRequest;
        }

        public void onMediaDownloaded(C1431Ad ad) {
            Log.d(FacebookMediationAdapter.TAG, "onMediaDownloaded");
        }

        public void onError(C1431Ad ad, AdError adError) {
            String errorMessage = adError.getErrorMessage();
            if (!TextUtils.isEmpty(errorMessage)) {
                Log.w(FacebookMediationAdapter.TAG, errorMessage);
            }
            MediationNativeListener access$500 = FacebookAdapter.this.mNativeListener;
            FacebookAdapter facebookAdapter = FacebookAdapter.this;
            access$500.onAdFailedToLoad(facebookAdapter, facebookAdapter.convertErrorCode(adError));
        }

        public void onAdLoaded(C1431Ad ad) {
            if (ad != this.mNativeBannerAd) {
                Log.w(FacebookMediationAdapter.TAG, "Ad loaded is not a native banner ad.");
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad(FacebookAdapter.this, 0);
                return;
            }
            Context context = (Context) this.mContext.get();
            if (context == null) {
                Log.w(FacebookMediationAdapter.TAG, "Failed to create ad options view, Context is null.");
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad(FacebookAdapter.this, 1);
                return;
            }
            NativeAdOptions nativeAdOptions = this.mMediationAdRequest.getNativeAdOptions();
            if (this.mMediationAdRequest.isUnifiedNativeAdRequested()) {
                final UnifiedAdMapper unifiedAdMapper = new UnifiedAdMapper(this.mNativeBannerAd, nativeAdOptions);
                unifiedAdMapper.mapUnifiedNativeAd(context, new NativeAdMapperListener() {
                    public void onMappingSuccess() {
                        FacebookAdapter.this.mNativeListener.onAdLoaded((MediationNativeAdapter) FacebookAdapter.this, (UnifiedNativeAdMapper) unifiedAdMapper);
                    }

                    public void onMappingFailed() {
                        FacebookAdapter.this.mNativeListener.onAdFailedToLoad(FacebookAdapter.this, 3);
                    }
                });
            } else if (this.mMediationAdRequest.isAppInstallAdRequested()) {
                final AppInstallMapper appInstallMapper = new AppInstallMapper(this.mNativeBannerAd, nativeAdOptions);
                appInstallMapper.mapNativeAd(context, new NativeAdMapperListener() {
                    public void onMappingSuccess() {
                        FacebookAdapter.this.mNativeListener.onAdLoaded((MediationNativeAdapter) FacebookAdapter.this, (NativeAdMapper) appInstallMapper);
                    }

                    public void onMappingFailed() {
                        FacebookAdapter.this.mNativeListener.onAdFailedToLoad(FacebookAdapter.this, 3);
                    }
                });
            } else {
                Log.e(FacebookMediationAdapter.TAG, "Content Ads are not supported.");
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad(FacebookAdapter.this, 1);
            }
        }

        public void onAdClicked(C1431Ad ad) {
            FacebookAdapter.this.mNativeListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mNativeListener.onAdOpened(FacebookAdapter.this);
            FacebookAdapter.this.mNativeListener.onAdLeftApplication(FacebookAdapter.this);
        }

        public void onLoggingImpression(C1431Ad ad) {
            if (FacebookAdapter.this.mIsImpressionRecorded) {
                Log.d(FacebookMediationAdapter.TAG, "Received onLoggingImpression callback for a native whose impression is already recorded. Ignoring the duplicate callback.");
                return;
            }
            FacebookAdapter.this.mNativeListener.onAdImpression(FacebookAdapter.this);
            FacebookAdapter.this.mIsImpressionRecorded = true;
        }
    }

    private class NativeListener implements AdListener, NativeAdListener {
        private WeakReference<Context> mContext;
        private NativeMediationAdRequest mMediationAdRequest;
        private NativeAd mNativeAd;

        private NativeListener(Context context, NativeAd nativeAd, NativeMediationAdRequest nativeMediationAdRequest) {
            this.mContext = new WeakReference<>(context);
            this.mNativeAd = nativeAd;
            this.mMediationAdRequest = nativeMediationAdRequest;
        }

        public void onAdClicked(C1431Ad ad) {
            FacebookAdapter.this.mNativeListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mNativeListener.onAdOpened(FacebookAdapter.this);
            FacebookAdapter.this.mNativeListener.onAdLeftApplication(FacebookAdapter.this);
        }

        public void onLoggingImpression(C1431Ad ad) {
            if (FacebookAdapter.this.mIsImpressionRecorded) {
                Log.d(FacebookMediationAdapter.TAG, "Received onLoggingImpression callback for a native whose impression is already recorded. Ignoring the duplicate callback.");
                return;
            }
            FacebookAdapter.this.mNativeListener.onAdImpression(FacebookAdapter.this);
            FacebookAdapter.this.mIsImpressionRecorded = true;
        }

        public void onAdLoaded(C1431Ad ad) {
            if (ad != this.mNativeAd) {
                Log.w(FacebookMediationAdapter.TAG, "Ad loaded is not a native ad.");
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad(FacebookAdapter.this, 0);
                return;
            }
            Context context = (Context) this.mContext.get();
            if (context == null) {
                Log.w(FacebookMediationAdapter.TAG, "Failed to create ad options view, Context is null.");
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad(FacebookAdapter.this, 1);
                return;
            }
            NativeAdOptions nativeAdOptions = this.mMediationAdRequest.getNativeAdOptions();
            if (this.mMediationAdRequest.isUnifiedNativeAdRequested()) {
                final UnifiedAdMapper unifiedAdMapper = new UnifiedAdMapper(this.mNativeAd, nativeAdOptions);
                unifiedAdMapper.mapUnifiedNativeAd(context, new NativeAdMapperListener() {
                    public void onMappingSuccess() {
                        FacebookAdapter.this.mNativeListener.onAdLoaded((MediationNativeAdapter) FacebookAdapter.this, (UnifiedNativeAdMapper) unifiedAdMapper);
                    }

                    public void onMappingFailed() {
                        FacebookAdapter.this.mNativeListener.onAdFailedToLoad(FacebookAdapter.this, 3);
                    }
                });
            } else if (this.mMediationAdRequest.isAppInstallAdRequested()) {
                final AppInstallMapper appInstallMapper = new AppInstallMapper(this.mNativeAd, nativeAdOptions);
                appInstallMapper.mapNativeAd(context, new NativeAdMapperListener() {
                    public void onMappingSuccess() {
                        FacebookAdapter.this.mNativeListener.onAdLoaded((MediationNativeAdapter) FacebookAdapter.this, (NativeAdMapper) appInstallMapper);
                    }

                    public void onMappingFailed() {
                        FacebookAdapter.this.mNativeListener.onAdFailedToLoad(FacebookAdapter.this, 3);
                    }
                });
            } else {
                Log.e(FacebookMediationAdapter.TAG, "Content Ads are not supported.");
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad(FacebookAdapter.this, 1);
            }
        }

        public void onError(C1431Ad ad, AdError adError) {
            String errorMessage = adError.getErrorMessage();
            if (!TextUtils.isEmpty(errorMessage)) {
                Log.w(FacebookMediationAdapter.TAG, errorMessage);
            }
            MediationNativeListener access$500 = FacebookAdapter.this.mNativeListener;
            FacebookAdapter facebookAdapter = FacebookAdapter.this;
            access$500.onAdFailedToLoad(facebookAdapter, facebookAdapter.convertErrorCode(adError));
        }

        public void onMediaDownloaded(C1431Ad ad) {
            Log.d(FacebookMediationAdapter.TAG, "onMediaDownloaded");
        }
    }

    class UnifiedAdMapper extends UnifiedNativeAdMapper {
        private NativeAd mNativeAd;
        private NativeAdOptions mNativeAdOptions;
        private NativeBannerAd mNativeBannerAd;

        public UnifiedAdMapper(NativeAd nativeAd, NativeAdOptions nativeAdOptions) {
            this.mNativeAd = nativeAd;
            this.mNativeAdOptions = nativeAdOptions;
        }

        public UnifiedAdMapper(NativeBannerAd nativeBannerAd, NativeAdOptions nativeAdOptions) {
            this.mNativeBannerAd = nativeBannerAd;
            this.mNativeAdOptions = nativeAdOptions;
        }

        public void mapUnifiedNativeAd(Context context, NativeAdMapperListener nativeAdMapperListener) {
            AdOptionsView adOptionsView;
            boolean access$1300 = FacebookAdapter.this.isNativeBanner;
            String str = FacebookAdapter.KEY_SOCIAL_CONTEXT_ASSET;
            String str2 = "id";
            if (access$1300) {
                if (!containsRequiredFieldsForNativeBannerAd(this.mNativeBannerAd)) {
                    Log.w(FacebookMediationAdapter.TAG, "Ad from Facebook doesn't have all assets required for the Native Banner Ad format.");
                    nativeAdMapperListener.onMappingFailed();
                    return;
                }
                setHeadline(this.mNativeBannerAd.getAdHeadline());
                setBody(this.mNativeBannerAd.getAdBodyText());
                setIcon(new FacebookAdapterNativeAdImage(Uri.parse(this.mNativeBannerAd.getAdIcon().toString())));
                setCallToAction(this.mNativeBannerAd.getAdCallToAction());
                setAdvertiser(this.mNativeBannerAd.getAdvertiserName());
                Bundle bundle = new Bundle();
                bundle.putCharSequence(str2, this.mNativeBannerAd.getId());
                bundle.putCharSequence(str, this.mNativeBannerAd.getAdSocialContext());
                setExtras(bundle);
            } else if (!containsRequiredFieldsForUnifiedNativeAd(this.mNativeAd)) {
                Log.w(FacebookMediationAdapter.TAG, "Ad from Facebook doesn't have all assets required for the Native Ad format.");
                nativeAdMapperListener.onMappingFailed();
                return;
            } else {
                setHeadline(this.mNativeAd.getAdHeadline());
                ArrayList arrayList = new ArrayList();
                arrayList.add(new FacebookAdapterNativeAdImage(Uri.parse(this.mNativeAd.getAdCoverImage().toString())));
                setImages(arrayList);
                setBody(this.mNativeAd.getAdBodyText());
                setIcon(new FacebookAdapterNativeAdImage(Uri.parse(this.mNativeAd.getAdIcon().toString())));
                setCallToAction(this.mNativeAd.getAdCallToAction());
                setAdvertiser(this.mNativeAd.getAdvertiserName());
                FacebookAdapter.this.mMediaView.setListener(new MediaViewListener() {
                    public void onEnterFullscreen(MediaView mediaView) {
                    }

                    public void onExitFullscreen(MediaView mediaView) {
                    }

                    public void onFullscreenBackground(MediaView mediaView) {
                    }

                    public void onFullscreenForeground(MediaView mediaView) {
                    }

                    public void onPause(MediaView mediaView) {
                    }

                    public void onPlay(MediaView mediaView) {
                    }

                    public void onVolumeChange(MediaView mediaView, float f) {
                    }

                    public void onComplete(MediaView mediaView) {
                        if (FacebookAdapter.this.mNativeListener != null) {
                            FacebookAdapter.this.mNativeListener.onVideoEnd(FacebookAdapter.this);
                        }
                    }
                });
                setMediaView(FacebookAdapter.this.mMediaView);
                setHasVideoContent(true);
                Double rating = getRating(this.mNativeAd.getAdStarRating());
                if (rating != null) {
                    setStarRating(rating);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putCharSequence(str2, this.mNativeAd.getId());
                bundle2.putCharSequence(str, this.mNativeAd.getAdSocialContext());
                setExtras(bundle2);
            }
            NativeAdLayout nativeAdLayout = new NativeAdLayout(context);
            if (FacebookAdapter.this.isNativeBanner) {
                adOptionsView = new AdOptionsView(context, this.mNativeBannerAd, nativeAdLayout);
            } else {
                adOptionsView = new AdOptionsView(context, this.mNativeAd, nativeAdLayout);
            }
            setAdChoicesContent(adOptionsView);
            nativeAdMapperListener.onMappingSuccess();
        }

        private boolean containsRequiredFieldsForUnifiedNativeAd(NativeAd nativeAd) {
            return (nativeAd.getAdHeadline() == null || nativeAd.getAdCoverImage() == null || nativeAd.getAdBodyText() == null || nativeAd.getAdIcon() == null || nativeAd.getAdCallToAction() == null || FacebookAdapter.this.mMediaView == null) ? false : true;
        }

        private boolean containsRequiredFieldsForNativeBannerAd(NativeBannerAd nativeBannerAd) {
            return (nativeBannerAd.getAdHeadline() == null || nativeBannerAd.getAdBodyText() == null || nativeBannerAd.getAdIcon() == null || nativeBannerAd.getAdCallToAction() == null) ? false : true;
        }

        public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            ArrayList arrayList = new ArrayList();
            ImageView imageView = null;
            for (Entry entry : map.entrySet()) {
                arrayList.add(entry.getValue());
                if (((String) entry.getKey()).equals(NativeAppInstallAd.ASSET_ICON) || ((String) entry.getKey()).equals(UnifiedNativeAdAssetNames.ASSET_ICON)) {
                    imageView = (ImageView) entry.getValue();
                }
            }
            if (FacebookAdapter.this.isNativeBanner) {
                this.mNativeBannerAd.registerViewForInteraction(view, imageView);
            } else {
                this.mNativeAd.registerViewForInteraction(view, FacebookAdapter.this.mMediaView, imageView, (List<View>) arrayList);
            }
        }

        public void untrackView(View view) {
            super.untrackView(view);
        }

        private Double getRating(Rating rating) {
            if (rating == null) {
                return null;
            }
            return Double.valueOf((rating.getValue() * 5.0d) / rating.getScale());
        }
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.destroy();
        }
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.unregisterView();
            this.mNativeAd.destroy();
        }
        MediaView mediaView = this.mMediaView;
        if (mediaView != null) {
            mediaView.destroy();
        }
        NativeBannerAd nativeBannerAd = this.mNativeBannerAd;
        if (nativeBannerAd != null) {
            nativeBannerAd.unregisterView();
            this.mNativeBannerAd.destroy();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.mBannerListener = mediationBannerListener;
        String placementID = getPlacementID(bundle);
        if (TextUtils.isEmpty(placementID)) {
            Log.e(TAG, "Failed to request ad, placementID is null or empty");
            this.mBannerListener.onAdFailedToLoad(this, 1);
        } else if (adSize == null) {
            Log.w(TAG, "Fail to request banner ad, adSize is null");
            this.mBannerListener.onAdFailedToLoad(this, 1);
        } else if (getAdSize(context, adSize) == null) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("The input ad size ");
            sb.append(adSize.toString());
            sb.append(" is not supported at this moment.");
            Log.w(str, sb.toString());
            this.mBannerListener.onAdFailedToLoad(this, 3);
        } else {
            FacebookInitializer instance = FacebookInitializer.getInstance();
            final Context context2 = context;
            final String str2 = placementID;
            final AdSize adSize2 = adSize;
            final MediationAdRequest mediationAdRequest2 = mediationAdRequest;
            C17301 r0 = new Listener() {
                public void onInitializeSuccess() {
                    FacebookAdapter.this.createAndLoadBannerAd(context2, str2, adSize2, mediationAdRequest2);
                }

                public void onInitializeError(String str) {
                    String str2 = FacebookMediationAdapter.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to load ad from Facebook: ");
                    sb.append(str);
                    Log.w(str2, sb.toString());
                    if (FacebookAdapter.this.mBannerListener != null) {
                        FacebookAdapter.this.mBannerListener.onAdFailedToLoad(FacebookAdapter.this, 0);
                    }
                }
            };
            instance.initialize(context, placementID, (Listener) r0);
        }
    }

    public View getBannerView() {
        return this.mWrappedAdView;
    }

    public void requestInterstitialAd(final Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, final MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.mInterstitialListener = mediationInterstitialListener;
        final String placementID = getPlacementID(bundle);
        if (TextUtils.isEmpty(placementID)) {
            Log.e(TAG, "Failed to request ad, placementID is null or empty");
            this.mInterstitialListener.onAdFailedToLoad(this, 1);
            return;
        }
        FacebookInitializer.getInstance().initialize(context, placementID, (Listener) new Listener() {
            public void onInitializeSuccess() {
                FacebookAdapter.this.createAndLoadInterstitial(context, placementID, mediationAdRequest);
            }

            public void onInitializeError(String str) {
                String str2 = FacebookMediationAdapter.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to load ad from Facebook: ");
                sb.append(str);
                Log.w(str2, sb.toString());
                if (FacebookAdapter.this.mInterstitialListener != null) {
                    FacebookAdapter.this.mInterstitialListener.onAdFailedToLoad(FacebookAdapter.this, 0);
                }
            }
        });
    }

    public void showInterstitial() {
        if (this.mInterstitialAd.isAdLoaded()) {
            this.mInterstitialAd.show();
        }
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.mNativeListener = mediationNativeListener;
        String placementID = getPlacementID(bundle);
        if (TextUtils.isEmpty(placementID)) {
            Log.e(TAG, "Failed to request ad, placementID is null or empty.");
            this.mNativeListener.onAdFailedToLoad(this, 1);
            return;
        }
        boolean z = nativeMediationAdRequest.isAppInstallAdRequested() && nativeMediationAdRequest.isContentAdRequested();
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested() || z) {
            FacebookInitializer instance = FacebookInitializer.getInstance();
            final Context context2 = context;
            final String str = placementID;
            final NativeMediationAdRequest nativeMediationAdRequest2 = nativeMediationAdRequest;
            final Bundle bundle3 = bundle2;
            C17323 r0 = new Listener() {
                public void onInitializeSuccess() {
                    FacebookAdapter.this.createAndLoadNativeAd(context2, str, nativeMediationAdRequest2, bundle3);
                }

                public void onInitializeError(String str) {
                    String str2 = FacebookMediationAdapter.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to load ad from Facebook: ");
                    sb.append(str);
                    Log.w(str2, sb.toString());
                    if (FacebookAdapter.this.mNativeListener != null) {
                        FacebookAdapter.this.mNativeListener.onAdFailedToLoad(FacebookAdapter.this, 0);
                    }
                }
            };
            instance.initialize(context, placementID, (Listener) r0);
            return;
        }
        Log.w(TAG, "Either unified native ads or both app install and content ads must be requested.");
        this.mNativeListener.onAdFailedToLoad(this, 1);
    }

    /* access modifiers changed from: private */
    public int convertErrorCode(AdError adError) {
        if (adError == null) {
            return 0;
        }
        int errorCode = adError.getErrorCode();
        if (errorCode != 2000) {
            switch (errorCode) {
                case 1000:
                    break;
                case 1001:
                    return 3;
                case 1002:
                    return 1;
                default:
                    return 0;
            }
        }
        return 2;
    }

    private void buildAdRequest(MediationAdRequest mediationAdRequest) {
        if (mediationAdRequest != null) {
            boolean z = true;
            if (mediationAdRequest.taggedForChildDirectedTreatment() != 1) {
                z = false;
            }
            AdSettings.setIsChildDirected(z);
        }
    }

    /* access modifiers changed from: private */
    public void createAndLoadBannerAd(Context context, String str, AdSize adSize, MediationAdRequest mediationAdRequest) {
        this.mAdView = new AdView(context, str, getAdSize(context, adSize));
        buildAdRequest(mediationAdRequest);
        LayoutParams layoutParams = new LayoutParams(adSize.getWidthInPixels(context), adSize.getHeightInPixels(context));
        this.mWrappedAdView = new RelativeLayout(context);
        this.mAdView.setLayoutParams(layoutParams);
        this.mWrappedAdView.addView(this.mAdView);
        AdView adView = this.mAdView;
        adView.loadAd(adView.buildLoadAdConfig().withAdListener(new BannerListener()).build());
    }

    /* access modifiers changed from: private */
    public void createAndLoadInterstitial(Context context, String str, MediationAdRequest mediationAdRequest) {
        this.mInterstitialAd = new InterstitialAd(context, str);
        buildAdRequest(mediationAdRequest);
        InterstitialAd interstitialAd = this.mInterstitialAd;
        interstitialAd.loadAd(interstitialAd.buildLoadAdConfig().withAdListener(new InterstitialListener()).build());
    }

    /* access modifiers changed from: private */
    public void createAndLoadNativeAd(Context context, String str, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle) {
        if (bundle != null) {
            this.isNativeBanner = bundle.getBoolean(FacebookExtras.NATIVE_BANNER);
        }
        if (this.isNativeBanner) {
            this.mNativeBannerAd = new NativeBannerAd(context, str);
            buildAdRequest(nativeMediationAdRequest);
            NativeBannerAd nativeBannerAd = this.mNativeBannerAd;
            NativeAdLoadConfigBuilder buildLoadAdConfig = nativeBannerAd.buildLoadAdConfig();
            NativeBannerListener nativeBannerListener = new NativeBannerListener(context, this.mNativeBannerAd, nativeMediationAdRequest);
            nativeBannerAd.loadAd(buildLoadAdConfig.withAdListener(nativeBannerListener).build());
            return;
        }
        this.mMediaView = new MediaView(context);
        this.mNativeAd = new NativeAd(context, str);
        buildAdRequest(nativeMediationAdRequest);
        NativeAd nativeAd = this.mNativeAd;
        NativeAdLoadConfigBuilder buildLoadAdConfig2 = nativeAd.buildLoadAdConfig();
        NativeListener nativeListener = new NativeListener(context, this.mNativeAd, nativeMediationAdRequest);
        nativeAd.loadAd(buildLoadAdConfig2.withAdListener(nativeListener).build());
    }

    private com.facebook.ads.AdSize getAdSize(Context context, AdSize adSize) {
        int width = adSize.getWidth();
        if (width < 0) {
            width = Math.round(((float) adSize.getWidthInPixels(context)) / context.getResources().getDisplayMetrics().density);
        }
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(0, new AdSize(width, 50));
        arrayList.add(1, new AdSize(width, 90));
        arrayList.add(2, new AdSize(width, Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Potential ad sizes: ");
        sb.append(arrayList.toString());
        Log.i(str, sb.toString());
        AdSize findClosestSize = findClosestSize(context, adSize, arrayList);
        if (findClosestSize == null) {
            return null;
        }
        String str2 = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Found closest ad size: ");
        sb2.append(findClosestSize.toString());
        Log.i(str2, sb2.toString());
        int height = findClosestSize.getHeight();
        if (height == com.facebook.ads.AdSize.BANNER_HEIGHT_50.getHeight()) {
            return com.facebook.ads.AdSize.BANNER_HEIGHT_50;
        }
        if (height == com.facebook.ads.AdSize.BANNER_HEIGHT_90.getHeight()) {
            return com.facebook.ads.AdSize.BANNER_HEIGHT_90;
        }
        if (height == com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250.getHeight()) {
            return com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250;
        }
        return null;
    }

    public static AdSize findClosestSize(Context context, AdSize adSize, ArrayList<AdSize> arrayList) {
        AdSize adSize2 = null;
        if (!(arrayList == null || adSize == null)) {
            float f = context.getResources().getDisplayMetrics().density;
            AdSize adSize3 = new AdSize(Math.round(((float) adSize.getWidthInPixels(context)) / f), Math.round(((float) adSize.getHeightInPixels(context)) / f));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                AdSize adSize4 = (AdSize) it.next();
                if (isSizeInRange(adSize3, adSize4)) {
                    if (adSize2 != null) {
                        adSize4 = getLargerByArea(adSize2, adSize4);
                    }
                    adSize2 = adSize4;
                }
            }
        }
        return adSize2;
    }

    private static boolean isSizeInRange(AdSize adSize, AdSize adSize2) {
        if (adSize2 == null) {
            return false;
        }
        int width = adSize.getWidth();
        int width2 = adSize2.getWidth();
        int height = adSize.getHeight();
        int height2 = adSize2.getHeight();
        double d = (double) width;
        Double.isNaN(d);
        if (d * 0.5d <= ((double) width2) && width >= width2) {
            double d2 = (double) height;
            Double.isNaN(d2);
            if (d2 * 0.7d <= ((double) height2) && height >= height2) {
                return true;
            }
        }
        return false;
    }

    private static AdSize getLargerByArea(AdSize adSize, AdSize adSize2) {
        return adSize.getWidth() * adSize.getHeight() > adSize2.getWidth() * adSize2.getHeight() ? adSize : adSize2;
    }
}
