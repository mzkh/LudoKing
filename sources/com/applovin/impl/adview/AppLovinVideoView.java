package com.applovin.impl.adview;

import android.content.Context;
import android.widget.VideoView;
import com.applovin.impl.sdk.C1192i;

public class AppLovinVideoView extends VideoView implements C0890t {

    /* renamed from: a */
    private final C1192i f1366a;

    public AppLovinVideoView(Context context, C1192i iVar) {
        super(context, null, 0);
        this.f1366a = iVar;
    }

    public void setVideoSize(int i, int i2) {
        try {
            getHolder().setFixedSize(i, i2);
            requestLayout();
            invalidate();
        } catch (Exception unused) {
        }
    }
}
