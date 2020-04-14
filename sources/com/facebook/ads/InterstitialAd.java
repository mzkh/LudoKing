package com.facebook.ads;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;
import com.facebook.ads.C1431Ad.LoadAdConfig;
import com.facebook.ads.C1431Ad.LoadConfigBuilder;
import com.facebook.ads.FullScreenAd.ShowAdConfig;
import com.facebook.ads.FullScreenAd.ShowConfigBuilder;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import java.util.EnumSet;

@UiThread
@Keep
public class InterstitialAd implements FullScreenAd {
    private final InterstitialAdApi mInterstitialAdApi;

    @Keep
    public interface InterstitialAdLoadConfigBuilder extends LoadConfigBuilder {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialLoadAdConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialAdLoadConfigBuilder withAdListener(InterstitialAdListener interstitialAdListener);

        InterstitialAdLoadConfigBuilder withBid(String str);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialAdLoadConfigBuilder withCacheFlags(EnumSet<CacheFlag> enumSet);

        InterstitialAdLoadConfigBuilder withRewardData(RewardData rewardData);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialAdLoadConfigBuilder withRewardedAdListener(RewardedAdListener rewardedAdListener);
    }

    @Keep
    public interface InterstitialAdShowConfigBuilder extends ShowConfigBuilder {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialShowAdConfig build();
    }

    @Keep
    public interface InterstitialLoadAdConfig extends LoadAdConfig {
    }

    @Keep
    public interface InterstitialShowAdConfig extends ShowAdConfig {
    }

    @Benchmark
    public InterstitialAd(Context context, String str) {
        this.mInterstitialAdApi = DynamicLoaderFactory.makeLoader(context).createInterstitialAd(context, str, this);
    }

    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public void setAdListener(InterstitialAdListener interstitialAdListener) {
        this.mInterstitialAdApi.setAdListener(interstitialAdListener);
    }

    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public void setRewardedAdListener(RewardedAdListener rewardedAdListener) {
        this.mInterstitialAdApi.setRewardedAdListener(rewardedAdListener);
    }

    public void setExtraHints(ExtraHints extraHints) {
        this.mInterstitialAdApi.setExtraHints(extraHints);
    }

    public void loadAd() {
        this.mInterstitialAdApi.loadAd();
    }

    public void loadAd(InterstitialLoadAdConfig interstitialLoadAdConfig) {
        this.mInterstitialAdApi.loadAd(interstitialLoadAdConfig);
    }

    @Deprecated
    @Benchmark
    public void loadAd(EnumSet<CacheFlag> enumSet) {
        this.mInterstitialAdApi.loadAd(enumSet);
    }

    @Deprecated
    public void loadAdFromBid(String str) {
        this.mInterstitialAdApi.loadAdFromBid(str);
    }

    @Deprecated
    @Benchmark
    public void loadAdFromBid(EnumSet<CacheFlag> enumSet, String str) {
        this.mInterstitialAdApi.loadAdFromBid(enumSet, str);
    }

    public boolean isAdInvalidated() {
        return this.mInterstitialAdApi.isAdInvalidated();
    }

    public void destroy() {
        this.mInterstitialAdApi.destroy();
    }

    public String getPlacementId() {
        return this.mInterstitialAdApi.getPlacementId();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean isAdLoaded() {
        return this.mInterstitialAdApi.isAdLoaded();
    }

    @Benchmark
    public boolean show() {
        return this.mInterstitialAdApi.show();
    }

    @Benchmark
    public boolean show(InterstitialShowAdConfig interstitialShowAdConfig) {
        return this.mInterstitialAdApi.show(interstitialShowAdConfig);
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public InterstitialAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mInterstitialAdApi.buildLoadAdConfig();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public InterstitialAdShowConfigBuilder buildShowAdConfig() {
        return this.mInterstitialAdApi.buildShowAdConfig();
    }
}
