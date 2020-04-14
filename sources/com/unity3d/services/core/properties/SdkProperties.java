package com.unity3d.services.core.properties;

import android.content.Context;
import com.appsflyer.share.Constants;
import com.unity3d.ads.BuildConfig;
import com.unity3d.services.IUnityServicesListener;
import com.unity3d.services.core.cache.CacheDirectory;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.log.DeviceLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class SdkProperties {
    private static final String CACHE_DIR_NAME = "UnityAdsCache";
    private static final String CHINA_ISO_ALPHA_2_CODE = "CN";
    private static final String CHINA_ISO_ALPHA_3_CODE = "CHN";
    private static final String LOCAL_CACHE_FILE_PREFIX = "UnityAdsCache-";
    private static final String LOCAL_STORAGE_FILE_PREFIX = "UnityAdsStorage-";
    private static CacheDirectory _cacheDirectory = null;
    private static String _configUrl = null;
    private static boolean _debugMode = false;
    private static long _initializationTime = 0;
    private static boolean _initialized = false;
    private static IUnityServicesListener _listener = null;
    private static boolean _perPlacementLoadEnabled = false;
    private static boolean _reinitialized = false;
    private static boolean _testMode = false;

    public static String getCacheDirectoryName() {
        return CACHE_DIR_NAME;
    }

    public static String getCacheFilePrefix() {
        return LOCAL_CACHE_FILE_PREFIX;
    }

    public static String getLocalStorageFilePrefix() {
        return LOCAL_STORAGE_FILE_PREFIX;
    }

    public static int getVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    public static String getVersionName() {
        return "3.3.0";
    }

    public static boolean isInitialized() {
        return _initialized;
    }

    public static void setInitialized(boolean z) {
        _initialized = z;
    }

    public static boolean isTestMode() {
        return _testMode;
    }

    public static void setTestMode(boolean z) {
        _testMode = z;
    }

    public static boolean isPerPlacementLoadEnabled() {
        return _perPlacementLoadEnabled;
    }

    public static void setPerPlacementLoadEnabled(boolean z) {
        _perPlacementLoadEnabled = z;
    }

    public static void setConfigUrl(String str) throws URISyntaxException, MalformedURLException {
        if (str == null) {
            throw new MalformedURLException();
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            new URL(str).toURI();
            _configUrl = str;
        } else {
            throw new MalformedURLException();
        }
    }

    public static String getConfigUrl() {
        if (_configUrl == null) {
            _configUrl = getDefaultConfigUrl("release");
        }
        return _configUrl;
    }

    public static String getDefaultConfigUrl(String str) {
        String str2 = isChinaLocale(Device.getNetworkCountryISO()) ? "https://config.unityads.unitychina.cn/webview/" : "https://config.unityads.unity3d.com/webview/";
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(getWebViewBranch());
        sb.append(Constants.URL_PATH_DELIMITER);
        sb.append(str);
        sb.append("/config.json");
        return sb.toString();
    }

    private static String getWebViewBranch() {
        return getVersionName();
    }

    public static String getLocalWebViewFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(getCacheDirectory().getAbsolutePath());
        sb.append("/UnityAdsWebApp.html");
        return sb.toString();
    }

    public static File getCacheDirectory() {
        return getCacheDirectory(ClientProperties.getApplicationContext());
    }

    public static File getCacheDirectory(Context context) {
        if (_cacheDirectory == null) {
            setCacheDirectory(new CacheDirectory(CACHE_DIR_NAME));
        }
        return _cacheDirectory.getCacheDirectory(context);
    }

    public static void setCacheDirectory(CacheDirectory cacheDirectory) {
        _cacheDirectory = cacheDirectory;
    }

    public static CacheDirectory getCacheDirectoryObject() {
        return _cacheDirectory;
    }

    public static void setInitializationTime(long j) {
        _initializationTime = j;
    }

    public static long getInitializationTime() {
        return _initializationTime;
    }

    public static void setReinitialized(boolean z) {
        _reinitialized = z;
    }

    public static boolean isReinitialized() {
        return _reinitialized;
    }

    public static void setDebugMode(boolean z) {
        _debugMode = z;
        if (z) {
            DeviceLog.setLogLevel(8);
        } else {
            DeviceLog.setLogLevel(4);
        }
    }

    public static boolean getDebugMode() {
        return _debugMode;
    }

    public static void setListener(IUnityServicesListener iUnityServicesListener) {
        _listener = iUnityServicesListener;
    }

    public static IUnityServicesListener getListener() {
        return _listener;
    }

    public static boolean isChinaLocale(String str) {
        return str.equalsIgnoreCase(CHINA_ISO_ALPHA_2_CODE) || str.equalsIgnoreCase(CHINA_ISO_ALPHA_3_CODE);
    }
}
