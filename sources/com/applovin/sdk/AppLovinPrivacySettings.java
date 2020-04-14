package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.sdk.C1179f;

public class AppLovinPrivacySettings {
    public static boolean hasUserConsent(Context context) {
        Boolean a = C1179f.m2526a(context);
        if (a != null) {
            return a.booleanValue();
        }
        return false;
    }

    public static boolean isAgeRestrictedUser(Context context) {
        Boolean b = C1179f.m2530b(context);
        if (b != null) {
            return b.booleanValue();
        }
        return false;
    }

    public static void setHasUserConsent(boolean z, Context context) {
        if (C1179f.m2529a(z, context)) {
            AppLovinSdk.reinitializeAll(Boolean.valueOf(z));
        }
    }

    public static void setIsAgeRestrictedUser(boolean z, Context context) {
        if (C1179f.m2531b(z, context)) {
            AppLovinSdk.reinitializeAll();
        }
    }
}
