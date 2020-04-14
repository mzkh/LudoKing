package com.applovin.mediation;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.Iterator;

public class AppLovinUtils {
    private static final String DEFAULT_ZONE = "";

    private static class ServerParameterKeys {
        private static final String PLACEMENT = "placement";
        private static final String SDK_KEY = "sdkKey";
        private static final String ZONE_ID = "zone_id";

        private ServerParameterKeys() {
        }
    }

    public static int toAdMobErrorCode(int i) {
        if (i == 204) {
            return 3;
        }
        return i == -102 ? 2 : 0;
    }

    public static AppLovinSdk retrieveSdk(Bundle bundle, Context context) {
        AppLovinSdk appLovinSdk;
        String string = bundle != null ? bundle.getString("sdkKey") : null;
        if (!TextUtils.isEmpty(string)) {
            appLovinSdk = AppLovinSdk.getInstance(string, new AppLovinSdkSettings(), context);
        } else {
            appLovinSdk = AppLovinSdk.getInstance(context);
        }
        appLovinSdk.setPluginVersion(BuildConfig.VERSION_NAME);
        appLovinSdk.setMediationProvider(AppLovinMediationProvider.ADMOB);
        return appLovinSdk;
    }

    public static boolean androidManifestHasValidSdkKey(Context context) {
        Bundle retrieveMetadata = retrieveMetadata(context);
        if (retrieveMetadata != null) {
            return !TextUtils.isEmpty(retrieveMetadata.getString("applovin.sdk.key"));
        }
        return false;
    }

    private static Bundle retrieveMetadata(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    public static String retrievePlacement(Bundle bundle) {
        String str = "placement";
        if (bundle.containsKey(str)) {
            return bundle.getString(str);
        }
        return null;
    }

    public static String retrieveZoneId(Bundle bundle) {
        String str = AdColonyAdapterUtils.KEY_ZONE_ID;
        return bundle.containsKey(str) ? bundle.getString(str) : "";
    }

    public static boolean shouldMuteAudio(Bundle bundle) {
        return bundle != null && bundle.getBoolean("mute_audio");
    }

    public static AppLovinAdSize appLovinAdSizeFromAdMobAdSize(Context context, AdSize adSize) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(0, AdSize.BANNER);
        arrayList.add(1, AdSize.LEADERBOARD);
        arrayList.add(2, AdSize.MEDIUM_RECTANGLE);
        AdSize findClosestSize = findClosestSize(context, adSize, arrayList);
        if (findClosestSize == null) {
            return null;
        }
        if (AdSize.BANNER.equals(findClosestSize)) {
            return AppLovinAdSize.BANNER;
        }
        if (AdSize.MEDIUM_RECTANGLE.equals(findClosestSize)) {
            return AppLovinAdSize.MREC;
        }
        if (AdSize.LEADERBOARD.equals(findClosestSize)) {
            return AppLovinAdSize.LEADER;
        }
        return null;
    }

    public static AdSize findClosestSize(Context context, AdSize adSize, ArrayList<AdSize> arrayList) {
        AdSize adSize2 = null;
        if (!(arrayList == null || adSize == null)) {
            float f = context.getResources().getDisplayMetrics().density;
            AdSize adSize3 = new AdSize(Math.round(((float) adSize.getWidthInPixels(context)) / f), Math.round(((float) adSize.getHeightInPixels(context)) / f));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                AdSize adSize4 = (AdSize) it.next();
                if (isSizeInRange(adSize3, adSize4)) {
                    if (adSize2 != null) {
                        adSize4 = getLargerByArea(adSize2, adSize4);
                    }
                    adSize2 = adSize4;
                }
            }
        }
        return adSize2;
    }

    private static boolean isSizeInRange(AdSize adSize, AdSize adSize2) {
        if (adSize2 == null) {
            return false;
        }
        int width = adSize.getWidth();
        int width2 = adSize2.getWidth();
        int height = adSize.getHeight();
        int height2 = adSize2.getHeight();
        double d = (double) width;
        Double.isNaN(d);
        if (d * 0.5d <= ((double) width2) && width >= width2) {
            double d2 = (double) height;
            Double.isNaN(d2);
            if (d2 * 0.7d <= ((double) height2) && height >= height2) {
                return true;
            }
        }
        return false;
    }

    private static AdSize getLargerByArea(AdSize adSize, AdSize adSize2) {
        return adSize.getWidth() * adSize.getHeight() > adSize2.getWidth() * adSize2.getHeight() ? adSize : adSize2;
    }
}
