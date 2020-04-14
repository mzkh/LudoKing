package com.facebook.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import com.facebook.ads.C1431Ad.LoadAdConfig;
import com.facebook.ads.C1431Ad.LoadConfigBuilder;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

@Keep
public class AdView extends RelativeLayout implements C1431Ad {
    private final AdViewApi mAdViewApi;
    private final AdViewParentApi mAdViewParentApi = new AdViewParentApi() {
        @Benchmark
        public void onConfigurationChanged(Configuration configuration) {
            AdView.super.onConfigurationChanged(configuration);
        }
    };

    @Keep
    public interface AdViewLoadConfig extends LoadAdConfig {
    }

    @Keep
    public interface AdViewLoadConfigBuilder extends LoadConfigBuilder {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        AdViewLoadConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        AdViewLoadConfigBuilder withAdListener(AdListener adListener);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        AdViewLoadConfigBuilder withBid(String str);
    }

    @Deprecated
    public void disableAutoRefresh() {
    }

    @Benchmark
    public AdView(Context context, String str, AdSize adSize) {
        super(context);
        this.mAdViewApi = DynamicLoaderFactory.makeLoader(context).createAdViewApi(context, str, adSize, this.mAdViewParentApi, this);
    }

    @Benchmark
    public AdView(Context context, String str, String str2) throws Exception {
        super(context);
        this.mAdViewApi = DynamicLoaderFactory.makeLoader(context).createAdViewApi(context, str, str2, this.mAdViewParentApi, this);
    }

    @Deprecated
    @Benchmark
    public void setAdListener(AdListener adListener) {
        this.mAdViewApi.setAdListener(adListener);
    }

    @Benchmark
    public void loadAd() {
        this.mAdViewApi.loadAd();
    }

    @Benchmark
    public void loadAd(AdViewLoadConfig adViewLoadConfig) {
        this.mAdViewApi.loadAd(adViewLoadConfig);
    }

    public void loadAdFromBid(String str) {
        this.mAdViewApi.loadAdFromBid(str);
    }

    public boolean isAdInvalidated() {
        return this.mAdViewApi.isAdInvalidated();
    }

    public void setExtraHints(ExtraHints extraHints) {
        this.mAdViewApi.setExtraHints(extraHints);
    }

    public void destroy() {
        this.mAdViewApi.destroy();
    }

    public String getPlacementId() {
        return this.mAdViewApi.getPlacementId();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        this.mAdViewApi.onConfigurationChanged(configuration);
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public AdViewLoadConfigBuilder buildLoadAdConfig() {
        return this.mAdViewApi.buildLoadAdConfig();
    }
}
