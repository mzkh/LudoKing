package com.facebook.ads.internal.api;

import android.view.View;
import androidx.annotation.Keep;
import com.facebook.ads.NativeAdBase.NativeComponentTag;

@Keep
public interface NativeComponentTagApi {
    void tagView(View view, NativeComponentTag nativeComponentTag);
}
