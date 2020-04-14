package com.facebook.ads.internal.api;

import androidx.annotation.Keep;
import androidx.annotation.UiThread;

@UiThread
@Keep
public interface AdComponentViewApiProvider {
    AdComponentViewApi getAdComponentViewApi();
}
