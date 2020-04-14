package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.utils.C1281o;
import java.util.HashMap;
import java.util.Map;

public class AppLovinSdkSettings {

    /* renamed from: a */
    private boolean f3276a;

    /* renamed from: b */
    private boolean f3277b;

    /* renamed from: c */
    private long f3278c;

    /* renamed from: d */
    private String f3279d;

    /* renamed from: e */
    private String f3280e;

    /* renamed from: f */
    private boolean f3281f;
    private final Map<String, Object> localSettings;

    public AppLovinSdkSettings() {
        this(null);
    }

    public AppLovinSdkSettings(Context context) {
        this.localSettings = new HashMap();
        this.f3277b = C1281o.m3106c(context);
        this.f3276a = C1281o.m3102b(context);
        this.f3278c = -1;
        StringBuilder sb = new StringBuilder();
        sb.append(AppLovinAdSize.INTERSTITIAL.getLabel());
        String str = ",";
        sb.append(str);
        sb.append(AppLovinAdSize.BANNER.getLabel());
        sb.append(str);
        sb.append(AppLovinAdSize.MREC.getLabel());
        this.f3279d = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AppLovinAdType.INCENTIVIZED.getLabel());
        sb2.append(str);
        sb2.append(AppLovinAdType.REGULAR.getLabel());
        sb2.append(str);
        sb2.append(AppLovinAdType.NATIVE.getLabel());
        this.f3280e = sb2.toString();
    }

    @Deprecated
    public String getAutoPreloadSizes() {
        return this.f3279d;
    }

    @Deprecated
    public String getAutoPreloadTypes() {
        return this.f3280e;
    }

    @Deprecated
    public long getBannerAdRefreshSeconds() {
        return this.f3278c;
    }

    public boolean isMuted() {
        return this.f3281f;
    }

    public boolean isTestAdsEnabled() {
        return this.f3276a;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.f3277b;
    }

    @Deprecated
    public void setAutoPreloadSizes(String str) {
        this.f3279d = str;
    }

    @Deprecated
    public void setAutoPreloadTypes(String str) {
        this.f3280e = str;
    }

    @Deprecated
    public void setBannerAdRefreshSeconds(long j) {
        this.f3278c = j;
    }

    public void setMuted(boolean z) {
        this.f3281f = z;
    }

    public void setTestAdsEnabled(boolean z) {
        this.f3276a = z;
    }

    public void setVerboseLogging(boolean z) {
        if (C1281o.m3088a()) {
            C1227o.m2841i("AppLovinSdkSettings", "Ignoring setting of verbose logging - it is configured from Android manifest already or AppLovinSdkSettings was initialized without a context.");
        } else {
            this.f3277b = z;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppLovinSdkSettings{isTestAdsEnabled=");
        sb.append(this.f3276a);
        sb.append(", isVerboseLoggingEnabled=");
        sb.append(this.f3277b);
        sb.append(", muted=");
        sb.append(this.f3281f);
        sb.append('}');
        return sb.toString();
    }
}
