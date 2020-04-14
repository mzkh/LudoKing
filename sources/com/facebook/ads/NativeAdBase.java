package com.facebook.ads;

import android.content.Context;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.C1431Ad.LoadAdConfig;
import com.facebook.ads.C1431Ad.LoadConfigBuilder;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeAdImageApi;
import com.facebook.ads.internal.api.NativeAdRatingApi;
import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import org.json.JSONObject;

@Keep
public abstract class NativeAdBase implements C1431Ad {
    final NativeAdBaseApi mNativeAdBaseApi;

    @Keep
    public static class Image {
        private final NativeAdImageApi mNativeAdImageApi;

        @Benchmark
        Image(NativeAdImageApi nativeAdImageApi) {
            this.mNativeAdImageApi = nativeAdImageApi;
        }

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        public int getWidth() {
            return this.mNativeAdImageApi.getWidth();
        }

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        public int getHeight() {
            return this.mNativeAdImageApi.getHeight();
        }

        @Nullable
        @Benchmark
        public static Image fromJSONObject(JSONObject jSONObject) {
            NativeAdImageApi createNativeAdImageApi = DynamicLoaderFactory.makeLoaderUnsafe().createNativeAdImageApi(jSONObject);
            if (createNativeAdImageApi == null) {
                return null;
            }
            return new Image(createNativeAdImageApi);
        }
    }

    @Keep
    public enum MediaCacheFlag {
        NONE,
        ALL
    }

    @Keep
    public interface NativeAdLoadConfigBuilder extends LoadConfigBuilder {
        public static final int UNKNOWN_IMAGE_SIZE = -1;

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        NativeLoadAdConfig build();

        @Deprecated
        @Benchmark
        void loadAd();

        NativeAdLoadConfigBuilder withAdListener(NativeAdListener nativeAdListener);

        NativeAdLoadConfigBuilder withBid(String str);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        NativeAdLoadConfigBuilder withMediaCacheFlag(MediaCacheFlag mediaCacheFlag);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        NativeAdLoadConfigBuilder withPreloadedIconView(int i, int i2);
    }

    @Keep
    public enum NativeComponentTag {
        AD_ICON,
        AD_TITLE,
        AD_COVER_IMAGE,
        AD_SUBTITLE,
        AD_BODY,
        AD_CALL_TO_ACTION,
        AD_SOCIAL_CONTEXT,
        AD_CHOICES_ICON,
        AD_OPTIONS_VIEW,
        AD_MEDIA;

        public static void tagView(View view, NativeComponentTag nativeComponentTag) {
            DynamicLoaderFactory.makeLoader(view.getContext()).createNativeComponentTagApi().tagView(view, nativeComponentTag);
        }
    }

    @Keep
    public interface NativeLoadAdConfig extends LoadAdConfig {
    }

    @Keep
    public static class Rating {
        private final NativeAdRatingApi mNativeAdRatingApi;

        @Benchmark
        Rating(NativeAdRatingApi nativeAdRatingApi) {
            this.mNativeAdRatingApi = nativeAdRatingApi;
        }

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        public double getValue() {
            return this.mNativeAdRatingApi.getValue();
        }

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        public double getScale() {
            return this.mNativeAdRatingApi.getScale();
        }

        @Nullable
        @Benchmark
        public static Rating fromJSONObject(JSONObject jSONObject) {
            NativeAdRatingApi createNativeAdRatingApi = DynamicLoaderFactory.makeLoaderUnsafe().createNativeAdRatingApi(jSONObject);
            if (createNativeAdRatingApi == null) {
                return null;
            }
            return new Rating(createNativeAdRatingApi);
        }
    }

    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean isNativeConfigEnabled() {
        return false;
    }

    @Benchmark
    public static NativeAdBase fromBidPayload(Context context, String str, String str2) throws Exception {
        return DynamicLoaderFactory.makeLoader(context).createNativeAdBaseFromBidPayload(context, str, str2);
    }

    @Benchmark
    public NativeAdBase(Context context, String str) {
        this.mNativeAdBaseApi = DynamicLoaderFactory.makeLoader(context).createNativeAdBaseApi(context, str);
    }

    @Benchmark
    public NativeAdBase(NativeAdBaseApi nativeAdBaseApi) {
        this.mNativeAdBaseApi = nativeAdBaseApi;
    }

    @Benchmark
    NativeAdBase(Context context, NativeAdBase nativeAdBase) {
        this.mNativeAdBaseApi = DynamicLoaderFactory.makeLoader(context).createNativeAdBaseApi(nativeAdBase.mNativeAdBaseApi);
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public NativeAdBaseApi getInternalNativeAd() {
        return this.mNativeAdBaseApi;
    }

    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public void setAdListener(NativeAdListener nativeAdListener) {
        this.mNativeAdBaseApi.setAdListener(nativeAdListener, this);
    }

    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mNativeAdBaseApi.setExtraHints(extraHints);
    }

    public void loadAd() {
        this.mNativeAdBaseApi.loadAd();
    }

    @Benchmark
    public void loadAd(NativeLoadAdConfig nativeLoadAdConfig) {
        this.mNativeAdBaseApi.loadAd(nativeLoadAdConfig);
    }

    @Deprecated
    @Benchmark
    public void loadAd(MediaCacheFlag mediaCacheFlag) {
        this.mNativeAdBaseApi.loadAd(mediaCacheFlag);
    }

    @Deprecated
    public void loadAdFromBid(String str) {
        this.mNativeAdBaseApi.loadAdFromBid(str);
    }

    @Deprecated
    @Benchmark
    public void loadAdFromBid(String str, MediaCacheFlag mediaCacheFlag) {
        this.mNativeAdBaseApi.loadAdFromBid(str, mediaCacheFlag);
    }

    @Benchmark
    public void downloadMedia() {
        this.mNativeAdBaseApi.downloadMedia();
    }

    public void destroy() {
        this.mNativeAdBaseApi.destroy();
    }

    public String getPlacementId() {
        return this.mNativeAdBaseApi.getPlacementId();
    }

    public boolean isAdInvalidated() {
        return this.mNativeAdBaseApi.isAdInvalidated();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean isAdLoaded() {
        return this.mNativeAdBaseApi.isAdLoaded();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean hasCallToAction() {
        return this.mNativeAdBaseApi.hasCallToAction();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public Image getAdIcon() {
        if (this.mNativeAdBaseApi.getAdIcon() == null) {
            return null;
        }
        return new Image(this.mNativeAdBaseApi.getAdIcon());
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public Image getAdCoverImage() {
        if (this.mNativeAdBaseApi.getAdCoverImage() == null) {
            return null;
        }
        return new Image(this.mNativeAdBaseApi.getAdCoverImage());
    }

    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public NativeAdViewAttributes getAdViewAttributes() {
        return new NativeAdViewAttributes();
    }

    @Nullable
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdvertiserName() {
        return this.mNativeAdBaseApi.getAdvertiserName();
    }

    @Nullable
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdHeadline() {
        return this.mNativeAdBaseApi.getAdHeadline();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdBodyText() {
        return this.mNativeAdBaseApi.getAdBodyText();
    }

    @Nullable
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdUntrimmedBodyText() {
        return this.mNativeAdBaseApi.getAdUntrimmedBodyText();
    }

    @Nullable
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdCallToAction() {
        return this.mNativeAdBaseApi.getAdCallToAction();
    }

    @Nullable
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdSocialContext() {
        return this.mNativeAdBaseApi.getAdSocialContext();
    }

    @Nullable
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdLinkDescription() {
        return this.mNativeAdBaseApi.getAdLinkDescription();
    }

    @Nullable
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getSponsoredTranslation() {
        return this.mNativeAdBaseApi.getSponsoredTranslation();
    }

    @Nullable
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdTranslation() {
        return this.mNativeAdBaseApi.getAdTranslation();
    }

    @Nullable
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getPromotedTranslation() {
        return this.mNativeAdBaseApi.getPromotedTranslation();
    }

    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public Rating getAdStarRating() {
        if (this.mNativeAdBaseApi.getAdStarRating() == null) {
            return null;
        }
        return new Rating(this.mNativeAdBaseApi.getAdStarRating());
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getId() {
        return this.mNativeAdBaseApi.getId();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public Image getAdChoicesIcon() {
        if (this.mNativeAdBaseApi.getAdChoicesIcon() == null) {
            return null;
        }
        return new Image(this.mNativeAdBaseApi.getAdChoicesIcon());
    }

    @Nullable
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdChoicesImageUrl() {
        return this.mNativeAdBaseApi.getAdChoicesImageUrl();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public float getAspectRatio() {
        return this.mNativeAdBaseApi.getAspectRatio();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdChoicesLinkUrl() {
        return this.mNativeAdBaseApi.getAdChoicesLinkUrl();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdChoicesText() {
        return this.mNativeAdBaseApi.getAdChoicesText();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public void onCtaBroadcast() {
        this.mNativeAdBaseApi.onCtaBroadcast();
    }

    @Benchmark
    public void unregisterView() {
        this.mNativeAdBaseApi.unregisterView();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.mNativeAdBaseApi.setOnTouchListener(onTouchListener);
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public NativeAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mNativeAdBaseApi.buildLoadAdConfig(this);
    }
}
