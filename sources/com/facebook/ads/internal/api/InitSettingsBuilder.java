package com.facebook.ads.internal.api;

import android.content.Context;
import androidx.annotation.Keep;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds.InitListener;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import java.util.ArrayList;
import java.util.List;

@Keep
public class InitSettingsBuilder implements com.facebook.ads.AudienceNetworkAds.InitSettingsBuilder {
    public static final String PLACEMENTS_KEY = "PLACEMENTS_KEY";
    private final Context mContext;
    private final MultithreadedBundleWrapper mInitSettings = new MultithreadedBundleWrapper();
    private InitListener mInitializationListener;

    public InitSettingsBuilder(Context context) {
        this.mContext = context;
    }

    public InitSettingsBuilder withPlacementIds(List<String> list) {
        this.mInitSettings.putStringArrayList(PLACEMENTS_KEY, new ArrayList(list));
        return this;
    }

    public InitSettingsBuilder withMediationService(String str) {
        AdSettings.setMediationService(str);
        return this;
    }

    public InitSettingsBuilder withInitListener(InitListener initListener) {
        this.mInitializationListener = initListener;
        return this;
    }

    public void initialize() {
        DynamicLoaderFactory.initialize(this.mContext, this.mInitSettings, this.mInitializationListener, false);
    }
}
