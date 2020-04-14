package com.applovin.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.nativeAds.AppLovinNativeAdService;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AppLovinSdk {
    private static final String TAG = "AppLovinSdk";
    public static final String VERSION = getVersion();
    public static final int VERSION_CODE = getVersionCode();
    private static final Map<String, AppLovinSdk> sdkInstances = new HashMap();
    private static final Object sdkInstancesLock = new Object();
    private final C1192i mSdkImpl;

    public interface SdkInitializationListener {
        void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration);
    }

    /* renamed from: com.applovin.sdk.AppLovinSdk$a */
    private static class C1312a extends AppLovinSdkSettings {
        C1312a(Context context) {
            super(context);
        }
    }

    private AppLovinSdk(C1192i iVar) {
        this.mSdkImpl = iVar;
    }

    /* renamed from: a */
    public static List<AppLovinSdk> m3157a() {
        return new ArrayList(sdkInstances.values());
    }

    public static AppLovinSdk getInstance(Context context) {
        return getInstance(new C1312a(context), context);
    }

    public static AppLovinSdk getInstance(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (context != null) {
            return getInstance(C1281o.m3074a(context), appLovinSdkSettings, context);
        }
        throw new IllegalArgumentException("No context specified");
    }

    public static AppLovinSdk getInstance(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (appLovinSdkSettings == null) {
            throw new IllegalArgumentException("No userSettings specified");
        } else if (context != null) {
            synchronized (sdkInstancesLock) {
                if (sdkInstances.containsKey(str)) {
                    AppLovinSdk appLovinSdk = (AppLovinSdk) sdkInstances.get(str);
                    return appLovinSdk;
                }
                if (!TextUtils.isEmpty(str) && str.contains(File.separator)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("\n**************************************************\nINVALID SDK KEY: ");
                    sb.append(str);
                    sb.append("\n**************************************************\n");
                    C1227o.m2841i(TAG, sb.toString());
                    if (!sdkInstances.isEmpty()) {
                        AppLovinSdk appLovinSdk2 = (AppLovinSdk) sdkInstances.values().iterator().next();
                        return appLovinSdk2;
                    }
                    str = str.replace(File.separator, "");
                }
                C1192i iVar = new C1192i();
                iVar.mo10214a(str, appLovinSdkSettings, context);
                AppLovinSdk appLovinSdk3 = new AppLovinSdk(iVar);
                iVar.mo10212a(appLovinSdk3);
                sdkInstances.put(str, appLovinSdk3);
                return appLovinSdk3;
            }
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    private static String getVersion() {
        return "9.9.1";
    }

    private static int getVersionCode() {
        return 90901;
    }

    public static void initializeSdk(Context context) {
        initializeSdk(context, null);
    }

    public static void initializeSdk(Context context, SdkInitializationListener sdkInitializationListener) {
        if (context != null) {
            AppLovinSdk instance = getInstance(context);
            if (instance != null) {
                instance.initializeSdk(sdkInitializationListener);
            } else {
                C1227o.m2841i(TAG, "Unable to initialize AppLovin SDK: SDK object not created");
            }
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    static void reinitializeAll() {
        reinitializeAll(null);
    }

    static void reinitializeAll(Boolean bool) {
        synchronized (sdkInstancesLock) {
            for (AppLovinSdk appLovinSdk : sdkInstances.values()) {
                appLovinSdk.mSdkImpl.mo10225b();
                if (bool != null && bool.booleanValue()) {
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("value", bool.toString());
                    appLovinSdk.getEventService().trackEvent("huc", hashMap);
                }
            }
        }
    }

    public AppLovinAdService getAdService() {
        return this.mSdkImpl.mo10241o();
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    public Context getApplicationContext() {
        return this.mSdkImpl.mo10179D();
    }

    public AppLovinSdkConfiguration getConfiguration() {
        return this.mSdkImpl.mo10239m();
    }

    public AppLovinEventService getEventService() {
        return this.mSdkImpl.mo10243q();
    }

    @Deprecated
    public C1227o getLogger() {
        return this.mSdkImpl.mo10249v();
    }

    public String getMediationProvider() {
        return this.mSdkImpl.mo10240n();
    }

    public AppLovinNativeAdService getNativeAdService() {
        return this.mSdkImpl.mo10242p();
    }

    public AppLovinPostbackService getPostbackService() {
        return this.mSdkImpl.mo10192R();
    }

    public String getSdkKey() {
        return this.mSdkImpl.mo10246t();
    }

    public AppLovinSdkSettings getSettings() {
        return this.mSdkImpl.mo10238l();
    }

    public String getUserIdentifier() {
        return this.mSdkImpl.mo10235i();
    }

    public AppLovinUserService getUserService() {
        return this.mSdkImpl.mo10244r();
    }

    public AppLovinVariableService getVariableService() {
        return this.mSdkImpl.mo10245s();
    }

    public boolean hasCriticalErrors() {
        return this.mSdkImpl.mo10248u();
    }

    public void initializeSdk() {
    }

    public void initializeSdk(SdkInitializationListener sdkInitializationListener) {
        this.mSdkImpl.mo10211a(sdkInitializationListener);
    }

    public boolean isEnabled() {
        return this.mSdkImpl.mo10230d();
    }

    public void setMediationProvider(String str) {
        this.mSdkImpl.mo10228c(str);
    }

    public void setPluginVersion(String str) {
        this.mSdkImpl.mo10213a(str);
    }

    public void setUserIdentifier(String str) {
        this.mSdkImpl.mo10227b(str);
    }

    public void showMediationDebugger() {
        this.mSdkImpl.mo10233g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppLovinSdk{sdkKey='");
        sb.append(getSdkKey());
        sb.append("', isEnabled=");
        sb.append(isEnabled());
        sb.append(", isFirstSession=");
        sb.append(this.mSdkImpl.mo10182H());
        sb.append('}');
        return sb.toString();
    }
}
