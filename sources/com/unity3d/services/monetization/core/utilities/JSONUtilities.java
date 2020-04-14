package com.unity3d.services.monetization.core.utilities;

import com.unity3d.services.core.log.DeviceLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtilities {
    public static Map<String, Object> jsonObjectToMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap(jSONObject.length());
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                hashMap.put(str, mapTypeFromJSON(jSONObject.get(str)));
            } catch (JSONException e) {
                DeviceLog.error("Could not put value in map: %s, %s", str, e.getMessage());
            }
        }
        return hashMap;
    }

    public static List<Object> jsonArrayToList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(mapTypeFromJSON(jSONArray.get(i)));
            } catch (JSONException e) {
                DeviceLog.error("Could not put value into list: %s", e.getMessage());
            }
        }
        return arrayList;
    }

    private static Object mapTypeFromJSON(Object obj) {
        if (obj instanceof JSONObject) {
            return jsonObjectToMap((JSONObject) obj);
        }
        return obj instanceof JSONArray ? jsonArrayToList((JSONArray) obj) : obj;
    }

    public static JSONObject mapToJsonObject(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), wrap(entry.getValue()));
            } catch (JSONException unused) {
                DeviceLog.error("Could not map entry to object: %s, %s", entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    public static Object wrap(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj);
            }
            if (obj.getClass().isArray()) {
                return new JSONArray(Arrays.asList(new Object[]{obj}));
            } else if (obj instanceof Map) {
                return new JSONObject((Map) obj);
            } else {
                if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short)) {
                    if (!(obj instanceof String)) {
                        if (obj instanceof Enum) {
                            return obj.toString();
                        }
                        if (obj.getClass().getPackage().getName().startsWith("java.")) {
                            obj = obj.toString();
                        }
                        return null;
                    }
                }
                return obj;
            }
        } catch (Exception unused) {
        }
    }
}
