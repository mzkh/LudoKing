package com.google.android.gms.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzxc;
import com.google.android.gms.internal.ads.zzxl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class MobileAds {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public static final class Settings {
        private final zzxl zzabh = new zzxl();

        @Deprecated
        public final String getTrackingId() {
            return null;
        }

        @Deprecated
        public final boolean isGoogleAnalyticsEnabled() {
            return false;
        }

        @Deprecated
        public final Settings setGoogleAnalyticsEnabled(boolean z) {
            return this;
        }

        @Deprecated
        public final Settings setTrackingId(String str) {
            return this;
        }

        /* access modifiers changed from: 0000 */
        public final zzxl zzdd() {
            return this.zzabh;
        }
    }

    private MobileAds() {
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void initialize(Context context, String str) {
        initialize(context, str, null);
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzxl zzxl;
        zzxc zzph = zzxc.zzph();
        if (settings == null) {
            zzxl = null;
        } else {
            zzxl = settings.zzdd();
        }
        zzph.zza(context, str, zzxl, null);
    }

    public static void initialize(Context context) {
        initialize(context, null, null);
    }

    public static void initialize(Context context, OnInitializationCompleteListener onInitializationCompleteListener) {
        zzxc.zzph().zza(context, null, null, onInitializationCompleteListener);
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzxc.zzph().getRewardedVideoAdInstance(context);
    }

    public static void setAppVolume(float f) {
        zzxc.zzph().setAppVolume(f);
    }

    public static void setAppMuted(boolean z) {
        zzxc.zzph().setAppMuted(z);
    }

    public static void openDebugMenu(Context context, String str) {
        zzxc.zzph().openDebugMenu(context, str);
    }

    public static String getVersionString() {
        return zzxc.zzph().getVersionString();
    }

    @KeepForSdk
    public static void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        zzxc.zzph().registerRtbAdapter(cls);
    }

    public static InitializationStatus getInitializationStatus() {
        return zzxc.zzph().getInitializationStatus();
    }

    @NonNull
    public static RequestConfiguration getRequestConfiguration() {
        return zzxc.zzph().getRequestConfiguration();
    }

    public static void setRequestConfiguration(@NonNull RequestConfiguration requestConfiguration) {
        zzxc.zzph().setRequestConfiguration(requestConfiguration);
    }
}
