package com.facebook.appevents.restrictivedatafilter;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({Scope.LIBRARY_GROUP})
public final class RestrictiveDataManager {
    private static final String TAG = "com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager";
    private static boolean enabled = false;
    private static final List<RestrictiveParamFilter> restrictiveParamFilters = new ArrayList();

    static class RestrictiveParamFilter {
        String eventName;
        Map<String, String> restrictiveParams;

        RestrictiveParamFilter(String str, Map<String, String> map) {
            this.eventName = str;
            this.restrictiveParams = map;
        }
    }

    public static void enable() {
        enabled = true;
        initialize();
    }

    private static void initialize() {
        try {
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings != null) {
                String restrictiveDataSetting = queryAppSettings.getRestrictiveDataSetting();
                if (restrictiveDataSetting != null && !restrictiveDataSetting.isEmpty()) {
                    JSONObject jSONObject = new JSONObject(restrictiveDataSetting);
                    restrictiveParamFilters.clear();
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                        if (jSONObject2 != null) {
                            JSONObject optJSONObject = jSONObject2.optJSONObject("restrictive_param");
                            RestrictiveParamFilter restrictiveParamFilter = new RestrictiveParamFilter(str, new HashMap());
                            if (optJSONObject != null) {
                                restrictiveParamFilter.restrictiveParams = Utility.convertJSONObjectToStringMap(optJSONObject);
                                restrictiveParamFilters.add(restrictiveParamFilter);
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void processParameters(Map<String, String> map, String str) {
        if (enabled) {
            HashMap hashMap = new HashMap();
            for (String str2 : new ArrayList(map.keySet())) {
                String matchedRuleType = getMatchedRuleType(str, str2);
                if (matchedRuleType != null) {
                    hashMap.put(str2, matchedRuleType);
                    map.remove(str2);
                }
            }
            if (hashMap.size() > 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Entry entry : hashMap.entrySet()) {
                        jSONObject.put((String) entry.getKey(), entry.getValue());
                    }
                    map.put("_restrictedParams", jSONObject.toString());
                } catch (JSONException unused) {
                }
            }
        }
    }

    @Nullable
    private static String getMatchedRuleType(String str, String str2) {
        try {
            for (RestrictiveParamFilter restrictiveParamFilter : new ArrayList(restrictiveParamFilters)) {
                if (restrictiveParamFilter != null) {
                    if (str.equals(restrictiveParamFilter.eventName)) {
                        for (String str3 : restrictiveParamFilter.restrictiveParams.keySet()) {
                            if (str2.equals(str3)) {
                                return (String) restrictiveParamFilter.restrictiveParams.get(str3);
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "getMatchedRuleType failed", e);
        }
        return null;
    }
}
