package com.facebook.ads;

import androidx.annotation.Keep;
import com.facebook.ads.internal.bench.Benchmark;

@Keep
public interface AdListener {
    @Benchmark
    void onAdClicked(C1431Ad ad);

    @Benchmark
    void onAdLoaded(C1431Ad ad);

    @Benchmark
    void onError(C1431Ad ad, AdError adError);

    @Benchmark
    void onLoggingImpression(C1431Ad ad);
}
