package com.unity3d.services.core.configuration;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.NetworkIOException;
import com.unity3d.services.core.request.WebRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Configuration {
    private String[] _moduleConfigurationList = {"com.unity3d.services.core.configuration.CoreModuleConfiguration", "com.unity3d.services.ads.configuration.AdsModuleConfiguration", "com.unity3d.services.monetization.core.configuration.MonetizationModuleConfiguration", "com.unity3d.services.purchasing.core.configuration.PurchasingModuleConfiguration", "com.unity3d.services.analytics.core.configuration.AnalyticsModuleConfiguration", "com.unity3d.services.ar.configuration.ARModuleConfiguration", "com.unity3d.services.banners.configuration.BannersModuleConfiguration", "com.unity3d.services.store.core.configuration.StoreModuleConfiguration"};
    private Map<String, IModuleConfiguration> _moduleConfigurations;
    private String _url;
    private Class[] _webAppApiClassList;
    private String _webViewData;
    private String _webViewHash;
    private String _webViewUrl;
    private String _webViewVersion;

    public Configuration() {
    }

    public Configuration(String str) {
        this._url = str;
    }

    public void setConfigUrl(String str) {
        this._url = str;
    }

    public String getConfigUrl() {
        return this._url;
    }

    public Class[] getWebAppApiClassList() {
        if (this._webAppApiClassList == null) {
            createWebAppApiClassList();
        }
        return this._webAppApiClassList;
    }

    public String[] getModuleConfigurationList() {
        return this._moduleConfigurationList;
    }

    public String getWebViewUrl() {
        return this._webViewUrl;
    }

    public void setWebViewUrl(String str) {
        this._webViewUrl = str;
    }

    public String getWebViewHash() {
        return this._webViewHash;
    }

    public void setWebViewHash(String str) {
        this._webViewHash = str;
    }

    public String getWebViewVersion() {
        return this._webViewVersion;
    }

    public String getWebViewData() {
        return this._webViewData;
    }

    public void setWebViewData(String str) {
        this._webViewData = str;
    }

    public IModuleConfiguration getModuleConfiguration(String str) {
        Map<String, IModuleConfiguration> map = this._moduleConfigurations;
        if (map != null && map.containsKey(str)) {
            return (IModuleConfiguration) this._moduleConfigurations.get(str);
        }
        try {
            IModuleConfiguration iModuleConfiguration = (IModuleConfiguration) Class.forName(str).newInstance();
            if (iModuleConfiguration != null) {
                if (this._moduleConfigurations == null) {
                    this._moduleConfigurations = new HashMap();
                    this._moduleConfigurations.put(str, iModuleConfiguration);
                }
                return iModuleConfiguration;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public String buildQueryString() {
        StringBuilder sb = new StringBuilder();
        sb.append("?ts=");
        sb.append(System.currentTimeMillis());
        sb.append("&sdkVersion=");
        sb.append(SdkProperties.getVersionCode());
        sb.append("&sdkVersionName=");
        sb.append(SdkProperties.getVersionName());
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void makeRequest() throws IOException, JSONException, IllegalStateException, NetworkIOException, IllegalArgumentException {
        if (this._url != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this._url);
            sb.append(buildQueryString());
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Requesting configuration with: ");
            sb3.append(sb2);
            DeviceLog.debug(sb3.toString());
            JSONObject jSONObject = new JSONObject(new WebRequest(sb2, "GET", null).makeRequest());
            this._webViewUrl = jSONObject.getString("url");
            String str = "hash";
            if (!jSONObject.isNull(str)) {
                this._webViewHash = jSONObject.getString(str);
            } else {
                this._webViewHash = null;
            }
            String str2 = "version";
            if (jSONObject.has(str2)) {
                this._webViewVersion = jSONObject.getString(str2);
            } else {
                this._webViewVersion = null;
            }
            String str3 = this._webViewUrl;
            if (str3 == null || str3.isEmpty()) {
                throw new MalformedURLException("Invalid data. Web view URL is null or empty");
            }
            return;
        }
        throw new MalformedURLException("Base URL is null");
    }

    private void createWebAppApiClassList() {
        ArrayList arrayList = new ArrayList();
        for (String moduleConfiguration : getModuleConfigurationList()) {
            IModuleConfiguration moduleConfiguration2 = getModuleConfiguration(moduleConfiguration);
            if (!(moduleConfiguration2 == null || moduleConfiguration2.getWebAppApiClassList() == null)) {
                arrayList.addAll(Arrays.asList(moduleConfiguration2.getWebAppApiClassList()));
            }
        }
        this._webAppApiClassList = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }
}
