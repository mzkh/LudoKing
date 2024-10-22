package com.facebook.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

@Keep
public final class MediaViewVideoRendererWithBackgroundPlayback extends MediaViewVideoRenderer {
    private DefaultMediaViewVideoRendererApi mDefaultMediaViewVideoRendererApi;

    public boolean shouldAllowBackgroundPlayback() {
        return true;
    }

    public MediaViewVideoRendererWithBackgroundPlayback(Context context) {
        super(context);
        initialize(context);
    }

    public MediaViewVideoRendererWithBackgroundPlayback(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context);
    }

    public MediaViewVideoRendererWithBackgroundPlayback(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context);
    }

    @TargetApi(21)
    public MediaViewVideoRendererWithBackgroundPlayback(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initialize(context);
    }

    private void initialize(Context context) {
        this.mDefaultMediaViewVideoRendererApi = DynamicLoaderFactory.makeLoader(context).createDefaultMediaViewVideoRendererApi();
        this.mDefaultMediaViewVideoRendererApi.initialize(context, this, getMediaViewVideoRendererApi(), 1);
    }

    public void onPrepared() {
        super.onPrepared();
        this.mDefaultMediaViewVideoRendererApi.onPrepared();
    }
}
