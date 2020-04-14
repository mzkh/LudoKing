package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AppsFlyerProperties {
    public static final String ADDITIONAL_CUSTOM_DATA = "additionalCustomData";
    public static final String AF_KEY = "AppsFlyerKey";
    public static final String AF_WAITFOR_CUSTOMERID = "waitForCustomerId";
    public static final String APP_ID = "appid";
    public static final String APP_USER_ID = "AppUserId";
    public static final String CHANNEL = "channel";
    public static final String COLLECT_ANDROID_ID = "collectAndroidId";
    public static final String COLLECT_ANDROID_ID_FORCE_BY_USER = "collectAndroidIdForceByUser";
    public static final String COLLECT_FACEBOOK_ATTR_ID = "collectFacebookAttrId";
    public static final String COLLECT_FINGER_PRINT = "collectFingerPrint";
    public static final String COLLECT_IMEI = "collectIMEI";
    public static final String COLLECT_IMEI_FORCE_BY_USER = "collectIMEIForceByUser";
    public static final String COLLECT_MAC = "collectMAC";
    public static final String COLLECT_OAID = "collectOAID";
    public static final String CURRENCY_CODE = "currencyCode";
    public static final String DEVICE_TRACKING_DISABLED = "deviceTrackingDisabled";
    public static final String DISABLE_KEYSTORE = "keyPropDisableAFKeystore";
    public static final String DISABLE_LOGS_COMPLETELY = "disableLogs";
    public static final String DISABLE_OTHER_SDK = "disableOtherSdk";
    public static final String DPM = "disableProxy";
    public static final String EMAIL_CRYPT_TYPE = "userEmailsCryptType";
    public static final String ENABLE_GPS_FALLBACK = "enableGpsFallback";
    public static final String EXTENSION = "sdkExtension";
    public static final String IS_UPDATE = "IS_UPDATE";
    public static final String LAUNCH_PROTECT_ENABLED = "launchProtectEnabled";
    public static final String NEW_REFERRER_SENT = "newGPReferrerSent";
    public static final String ONELINK_DOMAIN = "onelinkDomain";
    public static final String ONELINK_ID = "oneLinkSlug";
    public static final String ONELINK_SCHEME = "onelinkScheme";
    public static final String USER_EMAIL = "userEmail";
    public static final String USER_EMAILS = "userEmails";
    public static final String USE_HTTP_FALLBACK = "useHttpFallback";

    /* renamed from: ॱ */
    private static AppsFlyerProperties f3392 = new AppsFlyerProperties();

    /* renamed from: ˊ */
    private boolean f3393;

    /* renamed from: ˋ */
    private String f3394;

    /* renamed from: ˎ */
    private Map<String, Object> f3395 = new HashMap();

    /* renamed from: ˏ */
    private boolean f3396;

    /* renamed from: ᐝ */
    private boolean f3397 = false;

    public enum EmailsCryptType {
        NONE(0),
        SHA256(3);
        

        /* renamed from: ˊ */
        private final int f3399;

        private EmailsCryptType(int i) {
            this.f3399 = i;
        }

        public final int getValue() {
            return this.f3399;
        }
    }

    private AppsFlyerProperties() {
    }

    public static AppsFlyerProperties getInstance() {
        return f3392;
    }

    public synchronized void remove(String str) {
        this.f3395.remove(str);
    }

    public synchronized void set(String str, String str2) {
        this.f3395.put(str, str2);
    }

    public synchronized void set(String str, String[] strArr) {
        this.f3395.put(str, strArr);
    }

    public synchronized void set(String str, int i) {
        this.f3395.put(str, Integer.toString(i));
    }

    public synchronized void set(String str, long j) {
        this.f3395.put(str, Long.toString(j));
    }

    public synchronized void set(String str, boolean z) {
        this.f3395.put(str, Boolean.toString(z));
    }

    public synchronized void setCustomData(String str) {
        this.f3395.put(ADDITIONAL_CUSTOM_DATA, str);
    }

    public synchronized void setUserEmails(String str) {
        this.f3395.put(USER_EMAILS, str);
    }

    public synchronized String getString(String str) {
        return (String) this.f3395.get(str);
    }

    public boolean getBoolean(String str, boolean z) {
        String string = getString(str);
        if (string == null) {
            return z;
        }
        return Boolean.valueOf(string).booleanValue();
    }

    public int getInt(String str, int i) {
        String string = getString(str);
        if (string == null) {
            return i;
        }
        return Integer.valueOf(string).intValue();
    }

    public long getLong(String str, long j) {
        String string = getString(str);
        if (string == null) {
            return j;
        }
        return Long.valueOf(string).longValue();
    }

    public synchronized Object getObject(String str) {
        return this.f3395.get(str);
    }

    /* access modifiers changed from: protected */
    public boolean isOnReceiveCalled() {
        return this.f3393;
    }

    /* access modifiers changed from: protected */
    public void setOnReceiveCalled() {
        this.f3393 = true;
    }

    /* access modifiers changed from: protected */
    public boolean isFirstLaunchCalled() {
        return this.f3396;
    }

    /* access modifiers changed from: protected */
    public void setFirstLaunchCalled(boolean z) {
        this.f3396 = z;
    }

    /* access modifiers changed from: protected */
    public void setFirstLaunchCalled() {
        this.f3396 = true;
    }

    /* access modifiers changed from: protected */
    public void setReferrer(String str) {
        set("AF_REFERRER", str);
        this.f3394 = str;
    }

    public String getReferrer(Context context) {
        String str = this.f3394;
        if (str != null) {
            return str;
        }
        String str2 = "AF_REFERRER";
        if (getString(str2) != null) {
            return getString(str2);
        }
        if (context == null) {
            return null;
        }
        return AppsFlyerLibCore.m3225(context).getString(TapjoyConstants.TJC_REFERRER, null);
    }

    public boolean isEnableLog() {
        return getBoolean("shouldLog", true);
    }

    public boolean isLogsDisabledCompletely() {
        return getBoolean(DISABLE_LOGS_COMPLETELY, false);
    }

    public boolean isOtherSdkStringDisabled() {
        return getBoolean(DISABLE_OTHER_SDK, false);
    }

    public synchronized void saveProperties(SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putString("savedProperties", new JSONObject(this.f3395).toString()).apply();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void loadProperties(android.content.Context r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.f3397     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            android.content.SharedPreferences r5 = com.appsflyer.AppsFlyerLibCore.m3225(r5)     // Catch:{ all -> 0x005f }
            java.lang.String r0 = "savedProperties"
            r1 = 0
            java.lang.String r5 = r5.getString(r0, r1)     // Catch:{ all -> 0x005f }
            if (r5 == 0) goto L_0x005d
            java.lang.String r0 = "Loading properties.."
            com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ all -> 0x005f }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0044 }
            r0.<init>(r5)     // Catch:{ JSONException -> 0x0044 }
            java.util.Iterator r5 = r0.keys()     // Catch:{ JSONException -> 0x0044 }
        L_0x0022:
            boolean r1 = r5.hasNext()     // Catch:{ JSONException -> 0x0044 }
            if (r1 == 0) goto L_0x0040
            java.lang.Object r1 = r5.next()     // Catch:{ JSONException -> 0x0044 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x0044 }
            java.util.Map<java.lang.String, java.lang.Object> r2 = r4.f3395     // Catch:{ JSONException -> 0x0044 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ JSONException -> 0x0044 }
            if (r2 != 0) goto L_0x0022
            java.util.Map<java.lang.String, java.lang.Object> r2 = r4.f3395     // Catch:{ JSONException -> 0x0044 }
            java.lang.String r3 = r0.getString(r1)     // Catch:{ JSONException -> 0x0044 }
            r2.put(r1, r3)     // Catch:{ JSONException -> 0x0044 }
            goto L_0x0022
        L_0x0040:
            r5 = 1
            r4.f3397 = r5     // Catch:{ JSONException -> 0x0044 }
            goto L_0x004a
        L_0x0044:
            r5 = move-exception
            java.lang.String r0 = "Failed loading properties"
            com.appsflyer.AFLogger.afErrorLog(r0, r5)     // Catch:{ all -> 0x005f }
        L_0x004a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            java.lang.String r0 = "Done loading properties: "
            r5.<init>(r0)     // Catch:{ all -> 0x005f }
            boolean r0 = r4.f3397     // Catch:{ all -> 0x005f }
            r5.append(r0)     // Catch:{ all -> 0x005f }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x005f }
            com.appsflyer.AFLogger.afDebugLog(r5)     // Catch:{ all -> 0x005f }
        L_0x005d:
            monitor-exit(r4)
            return
        L_0x005f:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerProperties.loadProperties(android.content.Context):void");
    }
}
