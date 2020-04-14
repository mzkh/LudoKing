package com.facebook.ads;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.NativeAdView.Type;
import com.facebook.ads.internal.api.NativeAdScrollViewApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

@Keep
public class NativeAdScrollView extends LinearLayout {
    public static final int DEFAULT_INSET = 20;
    public static final int DEFAULT_MAX_ADS = 10;
    private final NativeAdScrollViewApi mNativeAdScrollViewApi;

    @Keep
    public interface AdViewProvider {
        View createView(NativeAd nativeAd, int i);

        void destroyView(NativeAd nativeAd, View view);
    }

    private NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, @Nullable AdViewProvider adViewProvider, int i, @Nullable Type type, @Nullable NativeAdViewAttributes nativeAdViewAttributes, int i2) {
        super(context);
        this.mNativeAdScrollViewApi = DynamicLoaderFactory.makeLoader(context).createNativeAdScrollViewApi(this, context, nativeAdsManager, adViewProvider, i, type, nativeAdViewAttributes, i2);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider) {
        this(context, nativeAdsManager, adViewProvider, 0, null, null, 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider, int i) {
        this(context, nativeAdsManager, adViewProvider, 0, null, null, i);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, int i) {
        this(context, nativeAdsManager, null, i, null, null, 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, int i, NativeAdViewAttributes nativeAdViewAttributes) {
        this(context, nativeAdsManager, null, i, null, nativeAdViewAttributes, 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, int i, NativeAdViewAttributes nativeAdViewAttributes, int i2) {
        this(context, nativeAdsManager, null, i, null, nativeAdViewAttributes, i2);
    }

    @Deprecated
    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, Type type) {
        this(context, nativeAdsManager, null, 0, type, null, 10);
    }

    @Deprecated
    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        this(context, nativeAdsManager, null, 0, type, nativeAdViewAttributes, 10);
    }

    @Deprecated
    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, Type type, NativeAdViewAttributes nativeAdViewAttributes, int i) {
        this(context, nativeAdsManager, null, 0, type, nativeAdViewAttributes, i);
    }

    public void setInset(int i) {
        this.mNativeAdScrollViewApi.setInset(i);
    }
}
