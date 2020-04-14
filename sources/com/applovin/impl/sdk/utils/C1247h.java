package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.utils.h */
public class C1247h {
    /* renamed from: a */
    public static float m2961a(JSONObject jSONObject, String str, float f, C1192i iVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return f;
        }
        try {
            double d = jSONObject.getDouble(str);
            return (-3.4028234663852886E38d >= d || d >= 3.4028234663852886E38d) ? f : (float) d;
        } catch (JSONException e) {
            if (iVar == null) {
                return f;
            }
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve float property for key = ");
            sb.append(str);
            v.mo10379b("JsonUtils", sb.toString(), e);
            return f;
        }
    }

    /* renamed from: a */
    public static long m2962a(JSONObject jSONObject, String str, long j, C1192i iVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return j;
        }
        try {
            return jSONObject.getLong(str);
        } catch (JSONException e) {
            if (iVar == null) {
                return j;
            }
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve int property for key = ");
            sb.append(str);
            v.mo10379b("JsonUtils", sb.toString(), e);
            return j;
        }
    }

    /* renamed from: a */
    public static Boolean m2963a(JSONObject jSONObject, String str, Boolean bool, C1192i iVar) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                bool = Boolean.valueOf(jSONObject.getBoolean(str));
            } catch (JSONException unused) {
                boolean z = true;
                if (m2984b(jSONObject, str, (bool == null || !bool.booleanValue()) ? 0 : 1, iVar) <= 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }
        return bool;
    }

    /* renamed from: a */
    private static Object m2964a(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return m2973a((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            obj = m2986b((JSONArray) obj);
        }
        return obj;
    }

    /* renamed from: a */
    public static Object m2965a(JSONArray jSONArray, int i, Object obj, C1192i iVar) {
        if (jSONArray == null || jSONArray.length() <= i) {
            return obj;
        }
        try {
            return jSONArray.get(i);
        } catch (JSONException e) {
            if (iVar == null) {
                return obj;
            }
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve object at index ");
            sb.append(i);
            sb.append(" for JSON array");
            v.mo10379b("JsonUtils", sb.toString(), e);
            return obj;
        }
    }

    /* renamed from: a */
    public static Object m2966a(JSONObject jSONObject, String str, Object obj, C1192i iVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return obj;
        }
        try {
            Object obj2 = jSONObject.get(str);
            return obj2 != null ? obj2 : obj;
        } catch (JSONException e) {
            if (iVar == null) {
                return obj;
            }
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve Object for key = ");
            sb.append(str);
            v.mo10379b("JsonUtils", sb.toString(), e);
            return obj;
        }
    }

    /* renamed from: a */
    public static String m2967a(Map<String, Object> map, String str, C1192i iVar) {
        try {
            return m2976a(map).toString();
        } catch (JSONException e) {
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to convert map '");
            sb.append(map);
            sb.append("' to JSON string.");
            v.mo10379b("JsonUtils", sb.toString(), e);
            return str;
        }
    }

    /* renamed from: a */
    public static String m2968a(JSONObject jSONObject, C1192i iVar) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.toString(4);
        } catch (JSONException e) {
            if (iVar != null) {
                iVar.mo10249v().mo10379b("JsonUtils", "Failed to convert to indented string", e);
            }
            return jSONObject.toString();
        }
    }

    /* renamed from: a */
    public static ArrayList<Bundle> m2969a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m2991c(jSONArray.optJSONObject(i)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List m2970a(JSONObject jSONObject, String str, List list, C1192i iVar) {
        try {
            JSONArray b = m2988b(jSONObject, str, (JSONArray) null, iVar);
            return b != null ? m2986b(b) : list;
        } catch (JSONException unused) {
            return list;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m2971a(Bundle bundle) {
        if (bundle == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(bundle.size());
        for (String str : bundle.keySet()) {
            hashMap.put(str, String.valueOf(bundle.get(str)));
        }
        return hashMap;
    }

    /* renamed from: a */
    public static Map<String, Object> m2972a(String str, Map<String, Object> map, C1192i iVar) {
        try {
            return m2987b(new JSONObject(str));
        } catch (JSONException e) {
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to convert json string '");
            sb.append(str);
            sb.append("' to map");
            v.mo10379b("JsonUtils", sb.toString(), e);
            return map;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m2973a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, m2964a(jSONObject.get(str)).toString());
        }
        return hashMap;
    }

    /* renamed from: a */
    public static JSONObject m2974a(String str, C1192i iVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to deserialize into JSON: ");
            sb.append(str);
            v.mo10382e("JsonUtils", sb.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static JSONObject m2975a(String str, JSONObject jSONObject, C1192i iVar) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            if (iVar != null) {
                C1227o v = iVar.mo10249v();
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to convert JSON string '");
                sb.append(str);
                sb.append("' to JSONObject");
                v.mo10379b("JsonUtils", sb.toString(), e);
            }
            return jSONObject;
        }
    }

    /* renamed from: a */
    public static JSONObject m2976a(Map<String, ?> map) throws JSONException {
        if (map == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m2977a(JSONArray jSONArray, int i, JSONObject jSONObject, C1192i iVar) {
        if (jSONArray == null || i >= jSONArray.length()) {
            return jSONObject;
        }
        try {
            return jSONArray.getJSONObject(i);
        } catch (JSONException e) {
            if (iVar == null) {
                return jSONObject;
            }
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve JSON object from array for index = ");
            sb.append(i);
            v.mo10379b("JsonUtils", sb.toString(), e);
            return jSONObject;
        }
    }

    /* renamed from: a */
    public static void m2978a(JSONObject jSONObject, String str, int i, C1192i iVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, i);
            } catch (JSONException e) {
                if (iVar != null) {
                    C1227o v = iVar.mo10249v();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to put int property for key = ");
                    sb.append(str);
                    v.mo10379b("JsonUtils", sb.toString(), e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2979a(JSONObject jSONObject, String str, String str2, C1192i iVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException e) {
                if (iVar != null) {
                    C1227o v = iVar.mo10249v();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to put String property for key = ");
                    sb.append(str);
                    v.mo10379b("JsonUtils", sb.toString(), e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2980a(JSONObject jSONObject, String str, JSONArray jSONArray, C1192i iVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, jSONArray);
            } catch (JSONException e) {
                if (iVar != null) {
                    C1227o v = iVar.mo10249v();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to put JSONArray property for key = ");
                    sb.append(str);
                    v.mo10379b("JsonUtils", sb.toString(), e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2981a(JSONObject jSONObject, String str, JSONObject jSONObject2, C1192i iVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, jSONObject2);
            } catch (JSONException e) {
                if (iVar != null) {
                    C1227o v = iVar.mo10249v();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to put JSON property for key = ");
                    sb.append(str);
                    v.mo10379b("JsonUtils", sb.toString(), e);
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m2982a(String str, JSONArray jSONArray) {
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                Object obj = jSONArray.get(i);
                if ((obj instanceof String) && ((String) obj).equalsIgnoreCase(str)) {
                    return true;
                }
                i++;
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2983a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    /* renamed from: b */
    public static int m2984b(JSONObject jSONObject, String str, int i, C1192i iVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return i;
        }
        try {
            return jSONObject.getInt(str);
        } catch (JSONException e) {
            if (iVar == null) {
                return i;
            }
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve int property for key = ");
            sb.append(str);
            v.mo10379b("JsonUtils", sb.toString(), e);
            return i;
        }
    }

    /* renamed from: b */
    public static String m2985b(JSONObject jSONObject, String str, String str2, C1192i iVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return str2;
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException e) {
            if (iVar == null) {
                return str2;
            }
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve string property for key = ");
            sb.append(str);
            v.mo10379b("JsonUtils", sb.toString(), e);
            return str2;
        }
    }

    /* renamed from: b */
    public static List m2986b(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m2964a(jSONArray.get(i)));
        }
        return arrayList;
    }

    /* renamed from: b */
    public static Map<String, Object> m2987b(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, m2964a(jSONObject.get(str)));
        }
        return hashMap;
    }

    /* renamed from: b */
    public static JSONArray m2988b(JSONObject jSONObject, String str, JSONArray jSONArray, C1192i iVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return jSONArray;
        }
        try {
            return jSONObject.getJSONArray(str);
        } catch (JSONException e) {
            if (iVar == null) {
                return jSONArray;
            }
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve JSON array for key = ");
            sb.append(str);
            v.mo10379b("JsonUtils", sb.toString(), e);
            return jSONArray;
        }
    }

    /* renamed from: b */
    public static JSONObject m2989b(JSONObject jSONObject, String str, JSONObject jSONObject2, C1192i iVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return jSONObject2;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e) {
            if (iVar == null) {
                return jSONObject2;
            }
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve JSON property for key = ");
            sb.append(str);
            v.mo10379b("JsonUtils", sb.toString(), e);
            return jSONObject2;
        }
    }

    /* renamed from: b */
    public static void m2990b(JSONObject jSONObject, String str, long j, C1192i iVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, j);
            } catch (JSONException e) {
                if (iVar != null) {
                    C1227o v = iVar.mo10249v();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to put long property for key = ");
                    sb.append(str);
                    v.mo10379b("JsonUtils", sb.toString(), e);
                }
            }
        }
    }

    /* renamed from: c */
    public static Bundle m2991c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return Bundle.EMPTY;
        }
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            if (jSONObject.isNull(str)) {
                bundle.putString(str, null);
            } else {
                Object opt = jSONObject.opt(str);
                if (opt instanceof JSONObject) {
                    bundle.putBundle(str, m2991c((JSONObject) opt));
                } else if (opt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) opt;
                    if (jSONArray.length() == 0) {
                        bundle.putStringArrayList(str, new ArrayList(0));
                    } else if (m2965a(jSONArray, 0, (Object) null, (C1192i) null) instanceof String) {
                        ArrayList arrayList = new ArrayList(jSONArray.length());
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add((String) m2965a(jSONArray, i, (Object) null, (C1192i) null));
                        }
                        bundle.putStringArrayList(str, arrayList);
                    } else {
                        bundle.putParcelableArrayList(str, m2969a(jSONArray));
                    }
                } else if (opt instanceof Boolean) {
                    bundle.putBoolean(str, ((Boolean) opt).booleanValue());
                } else if (opt instanceof String) {
                    bundle.putString(str, (String) opt);
                } else if (opt instanceof Integer) {
                    bundle.putInt(str, ((Integer) opt).intValue());
                } else if (opt instanceof Long) {
                    bundle.putLong(str, ((Long) opt).longValue());
                } else if (opt instanceof Double) {
                    bundle.putDouble(str, ((Double) opt).doubleValue());
                }
            }
        }
        return bundle;
    }
}
