package com.facebook.ads;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;
import com.facebook.ads.C1431Ad.LoadAdConfig;
import com.facebook.ads.C1431Ad.LoadConfigBuilder;
import com.facebook.ads.FullScreenAd.ShowAdConfig;
import com.facebook.ads.FullScreenAd.ShowConfigBuilder;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

@UiThread
@Keep
public class RewardedVideoAd implements FullScreenAd {
    public static final int UNSET_VIDEO_DURATION = -1;
    private final RewardedVideoAdApi mRewardedVideoAdApi;

    @Keep
    public interface RewardedVideoAdLoadConfigBuilder extends LoadConfigBuilder {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoLoadAdConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withAdListener(RewardedVideoAdListener rewardedVideoAdListener);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withBid(String str);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withFailOnCacheFailureEnabled(boolean z);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withRVChainEnabled(boolean z);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withRewardData(RewardData rewardData);
    }

    @Keep
    public interface RewardedVideoAdShowConfigBuilder extends ShowConfigBuilder {
        RewardedVideoShowAdConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdShowConfigBuilder withAppOrientation(int i);
    }

    @Keep
    public interface RewardedVideoLoadAdConfig extends LoadAdConfig {
    }

    @Keep
    public interface RewardedVideoShowAdConfig extends ShowAdConfig {
    }

    @Benchmark
    public RewardedVideoAd(Context context, String str) {
        this.mRewardedVideoAdApi = DynamicLoaderFactory.makeLoader(context).createRewardedVideoAd(context, str, this);
    }

    public void setExtraHints(ExtraHints extraHints) {
        this.mRewardedVideoAdApi.setExtraHints(extraHints);
    }

    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public void enableRVChain(boolean z) {
        this.mRewardedVideoAdApi.enableRVChain(z);
    }

    public void loadAd() {
        this.mRewardedVideoAdApi.loadAd();
    }

    @Benchmark
    public void loadAd(RewardedVideoLoadAdConfig rewardedVideoLoadAdConfig) {
        this.mRewardedVideoAdApi.loadAd(rewardedVideoLoadAdConfig);
    }

    @Deprecated
    @Benchmark
    public void loadAd(boolean z) {
        this.mRewardedVideoAdApi.loadAd(z);
    }

    @Deprecated
    public void loadAdFromBid(String str) {
        this.mRewardedVideoAdApi.loadAdFromBid(str);
    }

    @Deprecated
    @Benchmark
    public void loadAdFromBid(String str, boolean z) {
        this.mRewardedVideoAdApi.loadAdFromBid(str, z);
    }

    public boolean isAdInvalidated() {
        return this.mRewardedVideoAdApi.isAdInvalidated();
    }

    public boolean show() {
        return this.mRewardedVideoAdApi.show();
    }

    @Benchmark
    public boolean show(RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        return this.mRewardedVideoAdApi.show(rewardedVideoShowAdConfig);
    }

    @Deprecated
    @Benchmark
    public boolean show(int i) {
        return this.mRewardedVideoAdApi.show(i);
    }

    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public void setAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.mRewardedVideoAdApi.setAdListener(rewardedVideoAdListener);
    }

    public void destroy() {
        this.mRewardedVideoAdApi.destroy();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean isAdLoaded() {
        return this.mRewardedVideoAdApi.isAdLoaded();
    }

    public String getPlacementId() {
        return this.mRewardedVideoAdApi.getPlacementId();
    }

    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public void setRewardData(RewardData rewardData) {
        this.mRewardedVideoAdApi.setRewardData(rewardData);
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public int getVideoDuration() {
        return this.mRewardedVideoAdApi.getVideoDuration();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public RewardedVideoAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mRewardedVideoAdApi.buildLoadAdConfig();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public RewardedVideoAdShowConfigBuilder buildShowAdConfig() {
        return this.mRewardedVideoAdApi.buildShowAdConfig();
    }
}
