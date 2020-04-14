package com.facebook.appevents.eventdeactivation;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@RestrictTo({Scope.LIBRARY_GROUP})
public final class EventDeactivationManager {
    private static final Set<String> deprecatedEvents = new HashSet();
    private static final List<DeprecatedParamFilter> deprecatedParamFilters = new ArrayList();
    private static boolean enabled = false;

    static class DeprecatedParamFilter {
        List<String> deprecateParams;
        String eventName;

        DeprecatedParamFilter(String str, List<String> list) {
            this.eventName = str;
            this.deprecateParams = list;
        }
    }

    public static void enable() {
        enabled = true;
        initialize();
    }

    private static synchronized void initialize() {
        synchronized (EventDeactivationManager.class) {
            try {
                FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if (queryAppSettings != null) {
                    String restrictiveDataSetting = queryAppSettings.getRestrictiveDataSetting();
                    if (!restrictiveDataSetting.isEmpty()) {
                        JSONObject jSONObject = new JSONObject(restrictiveDataSetting);
                        deprecatedParamFilters.clear();
                        Iterator keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String str = (String) keys.next();
                            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                            if (jSONObject2 != null) {
                                if (jSONObject2.optBoolean("is_deprecated_event")) {
                                    deprecatedEvents.add(str);
                                } else {
                                    JSONArray optJSONArray = jSONObject2.optJSONArray("deprecated_param");
                                    DeprecatedParamFilter deprecatedParamFilter = new DeprecatedParamFilter(str, new ArrayList());
                                    if (optJSONArray != null) {
                                        deprecatedParamFilter.deprecateParams = Utility.convertJSONArrayToList(optJSONArray);
                                    }
                                    deprecatedParamFilters.add(deprecatedParamFilter);
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void processEvents(List<AppEvent> list) {
        if (enabled) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (deprecatedEvents.contains(((AppEvent) it.next()).getName())) {
                    it.remove();
                }
            }
        }
    }

    public static void processDeprecatedParameters(Map<String, String> map, String str) {
        if (enabled) {
            ArrayList<String> arrayList = new ArrayList<>(map.keySet());
            for (DeprecatedParamFilter deprecatedParamFilter : new ArrayList(deprecatedParamFilters)) {
                if (deprecatedParamFilter.eventName.equals(str)) {
                    for (String str2 : arrayList) {
                        if (deprecatedParamFilter.deprecateParams.contains(str2)) {
                            map.remove(str2);
                        }
                    }
                }
            }
        }
    }
}
