package com.google.ads.mediation.adcolony;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adcolony.sdk.AdColonyAdSize;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.Iterator;

public class AdColonyAdapterUtils {
    public static final String KEY_APP_ID = "app_id";
    public static final String KEY_ZONE_ID = "zone_id";
    public static final String KEY_ZONE_IDS = "zone_ids";

    @Nullable
    public static AdColonyAdSize adColonyAdSizeFromAdMobAdSize(@NonNull Context context, @NonNull AdSize adSize) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(AdSize.BANNER);
        arrayList.add(AdSize.LEADERBOARD);
        arrayList.add(AdSize.MEDIUM_RECTANGLE);
        arrayList.add(AdSize.WIDE_SKYSCRAPER);
        AdSize findClosestSize = findClosestSize(context, adSize, arrayList);
        if (AdSize.BANNER.equals(findClosestSize)) {
            return AdColonyAdSize.BANNER;
        }
        if (AdSize.MEDIUM_RECTANGLE.equals(findClosestSize)) {
            return AdColonyAdSize.MEDIUM_RECTANGLE;
        }
        if (AdSize.LEADERBOARD.equals(findClosestSize)) {
            return AdColonyAdSize.LEADERBOARD;
        }
        if (AdSize.WIDE_SKYSCRAPER.equals(findClosestSize)) {
            return AdColonyAdSize.SKYSCRAPER;
        }
        return null;
    }

    private static AdSize findClosestSize(Context context, AdSize adSize, ArrayList<AdSize> arrayList) {
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
