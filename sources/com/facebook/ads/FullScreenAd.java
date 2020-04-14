package com.facebook.ads;

import androidx.annotation.Keep;
import com.facebook.ads.C1431Ad.LoadConfigBuilder;

public interface FullScreenAd extends C1431Ad {

    @Keep
    public interface ShowAdConfig {
    }

    @Keep
    public interface ShowConfigBuilder {
        ShowAdConfig build();
    }

    LoadConfigBuilder buildLoadAdConfig();

    ShowConfigBuilder buildShowAdConfig();

    boolean show();
}
