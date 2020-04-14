package com.facebook.ads.internal.api;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd.AdCreativeType;
import com.facebook.ads.VideoAutoplayBehavior;
import java.util.List;

@Keep
public interface NativeAdApi {
    AdCreativeType getAdCreativeType();

    VideoAutoplayBehavior getVideoAutoplayBehavior();

    void registerViewForInteraction(View view, MediaView mediaView);

    void registerViewForInteraction(View view, MediaView mediaView, @Nullable ImageView imageView);

    void registerViewForInteraction(View view, MediaView mediaView, @Nullable ImageView imageView, @Nullable List<View> list);

    void registerViewForInteraction(View view, MediaView mediaView, @Nullable MediaView mediaView2);

    void registerViewForInteraction(View view, MediaView mediaView, @Nullable MediaView mediaView2, @Nullable List<View> list);

    void registerViewForInteraction(View view, MediaView mediaView, @Nullable List<View> list);
}
