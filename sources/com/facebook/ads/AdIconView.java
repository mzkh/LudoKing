package com.facebook.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;

@Deprecated
@Keep
public class AdIconView extends MediaView {
    public AdIconView(Context context) {
        super(context);
    }

    public AdIconView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdIconView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public AdIconView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
