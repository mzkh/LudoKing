package com.facebook.ads.internal.api;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Keep;
import com.facebook.ads.BuildConfig;

@Keep
public class BuildConfigApi {
    static final String UNITY_SHARED_PREFERENCES_SUFIX = ".v2.playerprefs";
    static final String UNITY_TAG = "an_isUnitySDK";
    static final String UNITY_VERSION_SUFIX = "-unity";

    public static String getVersionName(Context context) {
        if (!isUnity(context)) {
            return BuildConfig.VERSION_NAME;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(BuildConfig.VERSION_NAME);
        sb.append(UNITY_VERSION_SUFIX);
        return sb.toString();
    }

    private static boolean isUnity(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(UNITY_SHARED_PREFERENCES_SUFIX);
        SharedPreferences sharedPreferences = context.getSharedPreferences(sb.toString(), 0);
        String str = UNITY_TAG;
        if (sharedPreferences.contains(str) || context.getSharedPreferences(context.getPackageName(), 0).contains(str)) {
            return true;
        }
        return false;
    }

    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
