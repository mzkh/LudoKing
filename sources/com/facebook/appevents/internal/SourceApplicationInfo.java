package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import bolts.AppLinks;
import com.facebook.FacebookSdk;

class SourceApplicationInfo {
    private static final String CALL_APPLICATION_PACKAGE_KEY = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage";
    private static final String OPENED_BY_APP_LINK_KEY = "com.facebook.appevents.SourceApplicationInfo.openedByApplink";
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
    private String callingApplicationPackage;
    private boolean openedByAppLink;

    public static class Factory {
        public static SourceApplicationInfo create(Activity activity) {
            String str;
            ComponentName callingActivity = activity.getCallingActivity();
            if (callingActivity != null) {
                str = callingActivity.getPackageName();
                if (str.equals(activity.getPackageName())) {
                    return null;
                }
            } else {
                str = "";
            }
            Intent intent = activity.getIntent();
            boolean z = false;
            String str2 = SourceApplicationInfo.SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT;
            if (intent != null && !intent.getBooleanExtra(str2, false)) {
                intent.putExtra(str2, true);
                Bundle appLinkData = AppLinks.getAppLinkData(intent);
                if (appLinkData != null) {
                    Bundle bundle = appLinkData.getBundle("referer_app_link");
                    if (bundle != null) {
                        str = bundle.getString("package");
                    }
                    z = true;
                }
            }
            if (intent != null) {
                intent.putExtra(str2, true);
            }
            return new SourceApplicationInfo(str, z);
        }
    }

    private SourceApplicationInfo(String str, boolean z) {
        this.callingApplicationPackage = str;
        this.openedByAppLink = z;
    }

    public static SourceApplicationInfo getStoredSourceApplicatioInfo() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
        String str = CALL_APPLICATION_PACKAGE_KEY;
        if (!defaultSharedPreferences.contains(str)) {
            return null;
        }
        return new SourceApplicationInfo(defaultSharedPreferences.getString(str, null), defaultSharedPreferences.getBoolean(OPENED_BY_APP_LINK_KEY, false));
    }

    public static void clearSavedSourceApplicationInfoFromDisk() {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.remove(CALL_APPLICATION_PACKAGE_KEY);
        edit.remove(OPENED_BY_APP_LINK_KEY);
        edit.apply();
    }

    public String getCallingApplicationPackage() {
        return this.callingApplicationPackage;
    }

    public boolean isOpenedByAppLink() {
        return this.openedByAppLink;
    }

    public String toString() {
        String str = this.openedByAppLink ? "Applink" : "Unclassified";
        if (this.callingApplicationPackage == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("(");
        sb.append(this.callingApplicationPackage);
        sb.append(")");
        return sb.toString();
    }

    public void writeSourceApplicationInfoToDisk() {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.putString(CALL_APPLICATION_PACKAGE_KEY, this.callingApplicationPackage);
        edit.putBoolean(OPENED_BY_APP_LINK_KEY, this.openedByAppLink);
        edit.apply();
    }
}
