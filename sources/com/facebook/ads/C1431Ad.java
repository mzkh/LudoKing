package com.facebook.ads;

import androidx.annotation.Keep;
import com.facebook.ads.internal.bench.Benchmark;

@Keep
/* renamed from: com.facebook.ads.Ad */
public interface C1431Ad {

    @Keep
    /* renamed from: com.facebook.ads.Ad$LoadAdConfig */
    public interface LoadAdConfig {
    }

    @Keep
    /* renamed from: com.facebook.ads.Ad$LoadConfigBuilder */
    public interface LoadConfigBuilder {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        LoadAdConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        LoadConfigBuilder withBid(String str);
    }

    @Benchmark
    void destroy();

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    String getPlacementId();

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    boolean isAdInvalidated();

    @Benchmark
    void loadAd();

    @Benchmark
    void loadAdFromBid(String str);

    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    void setExtraHints(ExtraHints extraHints);
}
