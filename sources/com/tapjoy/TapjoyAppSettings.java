package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tapjoy.internal.C1852jq;

public class TapjoyAppSettings {
    public static final String TAG = "TapjoyAppSettings";

    /* renamed from: b */
    private static TapjoyAppSettings f6449b;

    /* renamed from: a */
    String f6450a = this.f6452d.getString(TapjoyConstants.PREF_LOG_LEVEL, null);

    /* renamed from: c */
    private Context f6451c;

    /* renamed from: d */
    private SharedPreferences f6452d = this.f6451c.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);

    private TapjoyAppSettings(Context context) {
        this.f6451c = context;
        if (!C1852jq.m3669c(this.f6450a)) {
            String str = TAG;
            StringBuilder sb = new StringBuilder("restoreLoggingLevel from sharedPref -- loggingLevel=");
            sb.append(this.f6450a);
            TapjoyLog.m6550d(str, sb.toString());
            TapjoyLog.m6549a(this.f6450a, true);
        }
    }

    public static TapjoyAppSettings getInstance() {
        return f6449b;
    }

    public static void init(Context context) {
        TapjoyLog.m6550d(TAG, "initializing app settings");
        f6449b = new TapjoyAppSettings(context);
    }

    public void saveLoggingLevel(String str) {
        if (C1852jq.m3669c(str)) {
            TapjoyLog.m6550d(TAG, "saveLoggingLevel -- server logging level is NULL or Empty string");
            return;
        }
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("saveLoggingLevel -- currentLevel=");
        sb.append(this.f6450a);
        sb.append(";newLevel=");
        sb.append(str);
        TapjoyLog.m6550d(str2, sb.toString());
        if (C1852jq.m3669c(this.f6450a) || !this.f6450a.equals(str)) {
            Editor edit = this.f6452d.edit();
            edit.putString(TapjoyConstants.PREF_LOG_LEVEL, str);
            edit.apply();
            this.f6450a = str;
            TapjoyLog.m6549a(this.f6450a, true);
        }
        boolean isLoggingEnabled = TapjoyLog.isLoggingEnabled();
        String str3 = TAG;
        StringBuilder sb2 = new StringBuilder("Tapjoy remote device debugging set to '");
        sb2.append(str);
        sb2.append("'. The SDK Debug-setting is: ");
        sb2.append(isLoggingEnabled ? "'Enabled'" : "'Disabled'");
        TapjoyLog.m6553i(str3, sb2.toString());
    }

    public void clearLoggingLevel() {
        Editor edit = this.f6452d.edit();
        edit.remove(TapjoyConstants.PREF_LOG_LEVEL);
        edit.apply();
        this.f6450a = null;
        boolean isLoggingEnabled = TapjoyLog.isLoggingEnabled();
        String str = TAG;
        StringBuilder sb = new StringBuilder("Tapjoy remote device debugging 'Disabled'. The SDK Debug-setting is: ");
        sb.append(isLoggingEnabled ? "'Enabled'" : "'Disabled'");
        TapjoyLog.m6553i(str, sb.toString());
        TapjoyLog.setDebugEnabled(isLoggingEnabled);
    }

    public void saveConnectResultAndParams(String str, String str2, long j) {
        if (!C1852jq.m3669c(str) && !C1852jq.m3669c(str2)) {
            Editor edit = this.f6452d.edit();
            edit.putString(TapjoyConstants.PREF_LAST_CONNECT_RESULT, str);
            edit.putString(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH, str2);
            String str3 = TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES;
            if (j >= 0) {
                edit.putLong(str3, j);
            } else {
                edit.remove(str3);
            }
            TapjoyLog.m6553i(TAG, "Stored connect result");
            edit.apply();
        }
    }

    public void removeConnectResult() {
        SharedPreferences sharedPreferences = this.f6452d;
        String str = TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH;
        if (sharedPreferences.getString(str, null) != null) {
            Editor edit = this.f6452d.edit();
            edit.remove(TapjoyConstants.PREF_LAST_CONNECT_RESULT);
            edit.remove(str);
            edit.remove(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES);
            TapjoyLog.m6553i(TAG, "Removed connect result");
            edit.apply();
        }
    }

    public String getConnectResult(String str, long j) {
        String string = this.f6452d.getString(TapjoyConstants.PREF_LAST_CONNECT_RESULT, null);
        if (!C1852jq.m3669c(string) && !C1852jq.m3669c(str) && str.equals(this.f6452d.getString(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH, null))) {
            long j2 = this.f6452d.getLong(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES, -1);
            if (j2 < 0 || j2 >= j) {
                return string;
            }
        }
        return null;
    }
}
