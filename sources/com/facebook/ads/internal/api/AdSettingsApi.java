package com.facebook.ads.internal.api;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
public interface AdSettingsApi {
    boolean isTestMode(Context context);

    void turnOnDebugger();
}
