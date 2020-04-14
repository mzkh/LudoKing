package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.C1431Ad;
import com.facebook.ads.ExtraHints.Builder;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FacebookRtbNativeAd extends UnifiedNativeAdMapper {
    private MediationNativeAdConfiguration adConfiguration;
    /* access modifiers changed from: private */
    public MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> callback;
    private MediaView mMediaView;
    private NativeAd mNativeAd;
    /* access modifiers changed from: private */
    public MediationNativeAdCallback mNativeAdCallback;

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

    private interface NativeAdMapperListener {
        void onMappingFailed();

        void onMappingSuccess();
    }

    private class NativeListener implements AdListener, NativeAdListener {
        private WeakReference<Context> mContext;
        private NativeAd mNativeAd;

        public void onLoggingImpression(C1431Ad ad) {
        }

        NativeListener(Context context, NativeAd nativeAd) {
            this.mNativeAd = nativeAd;
            this.mContext = new WeakReference<>(context);
        }

        public void onAdClicked(C1431Ad ad) {
            FacebookRtbNativeAd.this.mNativeAdCallback.onAdOpened();
            FacebookRtbNativeAd.this.mNativeAdCallback.onAdLeftApplication();
        }

        public void onAdLoaded(C1431Ad ad) {
            if (ad != this.mNativeAd) {
                Log.w(FacebookAdapter.TAG, "Ad loaded is not a native ad.");
                FacebookRtbNativeAd.this.callback.onFailure("Ad Loaded is not a Native Ad");
                return;
            }
            Context context = (Context) this.mContext.get();
            if (context == null) {
                Log.w(FacebookAdapter.TAG, "Failed to create ad options view, Context is null.");
                FacebookRtbNativeAd.this.callback.onFailure("Context is null");
                return;
            }
            FacebookRtbNativeAd.this.mapNativeAd(context, new NativeAdMapperListener() {
                public void onMappingSuccess() {
                    FacebookRtbNativeAd.this.mNativeAdCallback = (MediationNativeAdCallback) FacebookRtbNativeAd.this.callback.onSuccess(FacebookRtbNativeAd.this);
                }

                public void onMappingFailed() {
                    FacebookRtbNativeAd.this.callback.onFailure("Ad Failed to Load");
                }
            });
        }

        public void onError(C1431Ad ad, AdError adError) {
            String errorMessage = adError.getErrorMessage();
            if (!TextUtils.isEmpty(errorMessage)) {
                Log.w(FacebookAdapter.TAG, errorMessage);
            }
            FacebookRtbNativeAd.this.callback.onFailure(adError.getErrorMessage());
        }

        public void onMediaDownloaded(C1431Ad ad) {
            Log.d(FacebookAdapter.TAG, "onMediaDownloaded");
        }
    }

    public FacebookRtbNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        this.callback = mediationAdLoadCallback;
        this.adConfiguration = mediationNativeAdConfiguration;
    }

    public void render() {
        String placementID = FacebookMediationAdapter.getPlacementID(this.adConfiguration.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            String str = "Failed to request ad, placementID is null or empty.";
            Log.e(FacebookAdapter.TAG, str);
            this.callback.onFailure(str);
            return;
        }
        this.mMediaView = new MediaView(this.adConfiguration.getContext());
        this.mNativeAd = new NativeAd(this.adConfiguration.getContext(), placementID);
        if (!TextUtils.isEmpty(this.adConfiguration.getWatermark())) {
            this.mNativeAd.setExtraHints(new Builder().mediationData(this.adConfiguration.getWatermark()).build());
        }
        NativeAd nativeAd = this.mNativeAd;
        nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(new NativeListener(this.adConfiguration.getContext(), this.mNativeAd)).withBid(this.adConfiguration.getBidResponse()).build());
    }

    public void mapNativeAd(Context context, NativeAdMapperListener nativeAdMapperListener) {
        if (!containsRequiredFieldsForUnifiedNativeAd(this.mNativeAd)) {
            Log.w(FacebookAdapter.TAG, "Ad from Facebook doesn't have all assets required for the app install format.");
            nativeAdMapperListener.onMappingFailed();
            return;
        }
        setHeadline(this.mNativeAd.getAdHeadline());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FacebookAdapterNativeAdImage(null));
        setImages(arrayList);
        setBody(this.mNativeAd.getAdBodyText());
        setIcon(new FacebookAdapterNativeAdImage(null));
        setCallToAction(this.mNativeAd.getAdCallToAction());
        setAdvertiser(this.mNativeAd.getAdvertiserName());
        this.mMediaView.setListener(new MediaViewListener() {
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
                if (FacebookRtbNativeAd.this.mNativeAdCallback != null) {
                    FacebookRtbNativeAd.this.mNativeAdCallback.onVideoComplete();
                }
            }
        });
        setHasVideoContent(true);
        setMediaView(this.mMediaView);
        setStarRating(null);
        Bundle bundle = new Bundle();
        bundle.putCharSequence("id", this.mNativeAd.getId());
        bundle.putCharSequence(FacebookAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.mNativeAd.getAdSocialContext());
        setExtras(bundle);
        setAdChoicesContent(new AdOptionsView(context, this.mNativeAd, new NativeAdLayout(context)));
        nativeAdMapperListener.onMappingSuccess();
    }

    private boolean containsRequiredFieldsForUnifiedNativeAd(NativeAd nativeAd) {
        return (nativeAd.getAdHeadline() == null || nativeAd.getAdCoverImage() == null || nativeAd.getAdBodyText() == null || nativeAd.getAdIcon() == null || nativeAd.getAdCallToAction() == null || this.mMediaView == null) ? false : true;
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
        setOverrideClickHandling(true);
        ArrayList arrayList = new ArrayList();
        ImageView imageView = null;
        for (Entry entry : map.entrySet()) {
            arrayList.add(entry.getValue());
            if (((String) entry.getKey()).equals(UnifiedNativeAdAssetNames.ASSET_ICON)) {
                imageView = (ImageView) entry.getValue();
            }
        }
        this.mNativeAd.registerViewForInteraction(view, this.mMediaView, imageView, (List<View>) arrayList);
    }

    public void untrackView(View view) {
        super.untrackView(view);
    }
}
