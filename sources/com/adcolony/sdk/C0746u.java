package com.adcolony.sdk;

import java.io.IOException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.u */
class C0746u {
    C0746u() {
    }

    /* renamed from: a */
    static JSONObject m892a() {
        return new JSONObject();
    }

    /* renamed from: a */
    static JSONObject m893a(String str) {
        return m894a(str, (String) null);
    }

    /* renamed from: a */
    static JSONObject m894a(String str, String str2) {
        String str3;
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            if (str2 == null) {
                str3 = "";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(": ");
                sb.append(e.toString());
                str3 = sb.toString();
            }
            new C0749a().mo8726a(str3).mo8728a(C0748w.f1172h);
            return new JSONObject();
        }
    }

    /* renamed from: b */
    static JSONArray m909b() {
        return new JSONArray();
    }

    /* renamed from: b */
    static JSONArray m910b(String str) {
        try {
            return new JSONArray(str);
        } catch (JSONException e) {
            new C0749a().mo8726a(e.toString()).mo8728a(C0748w.f1172h);
            return new JSONArray();
        }
    }

    /* renamed from: a */
    static JSONObject m895a(JSONArray jSONArray, int i) {
        try {
            return jSONArray.getJSONObject(i);
        } catch (JSONException e) {
            new C0749a().mo8726a(e.toString()).mo8728a(C0748w.f1172h);
            return new JSONObject();
        }
    }

    /* renamed from: a */
    static Object m889a(JSONObject jSONObject, String str) {
        Object opt = jSONObject.opt(str);
        return opt == null ? Boolean.valueOf(false) : opt;
    }

    /* renamed from: b */
    static Object m907b(JSONArray jSONArray, int i) {
        Object opt = jSONArray.opt(i);
        return opt == null ? Boolean.valueOf(false) : opt;
    }

    /* renamed from: c */
    static String m915c(JSONArray jSONArray, int i) {
        return jSONArray.optString(i);
    }

    /* renamed from: b */
    static String m908b(JSONObject jSONObject, String str) {
        return jSONObject.optString(str);
    }

    /* renamed from: c */
    static int m914c(JSONObject jSONObject, String str) {
        return jSONObject.optInt(str);
    }

    /* renamed from: a */
    static int m888a(JSONObject jSONObject, String str, int i) {
        return jSONObject.optInt(str, i);
    }

    /* renamed from: d */
    static boolean m918d(JSONObject jSONObject, String str) {
        return jSONObject.optBoolean(str);
    }

    /* renamed from: a */
    static boolean m905a(JSONObject jSONObject, String str, boolean z) {
        return jSONObject.optBoolean(str, z);
    }

    /* renamed from: e */
    static double m919e(JSONObject jSONObject, String str) {
        return jSONObject.optDouble(str, 0.0d);
    }

    /* renamed from: f */
    static JSONObject m921f(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        return optJSONObject == null ? new JSONObject() : optJSONObject;
    }

    /* renamed from: d */
    static JSONObject m917d(JSONArray jSONArray, int i) {
        JSONObject optJSONObject = jSONArray.optJSONObject(i);
        return optJSONObject == null ? new JSONObject() : optJSONObject;
    }

    /* renamed from: g */
    static JSONArray m922g(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        return optJSONArray == null ? new JSONArray() : optJSONArray;
    }

    /* renamed from: a */
    static boolean m902a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
            return true;
        } catch (JSONException e) {
            new C0749a().mo8726a("JSON error in ADCJSON putString(): ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
            return false;
        }
    }

    /* renamed from: b */
    static boolean m912b(JSONObject jSONObject, String str, int i) {
        try {
            jSONObject.put(str, i);
            return true;
        } catch (JSONException e) {
            new C0749a().mo8726a("JSON error in ADCJSON putInteger(): ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m901a(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
            return true;
        } catch (JSONException e) {
            new C0749a().mo8726a("JSON error in ADCJSON putLong(): ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
            return false;
        }
    }

    /* renamed from: b */
    static boolean m913b(JSONObject jSONObject, String str, boolean z) {
        try {
            jSONObject.put(str, z);
            return true;
        } catch (JSONException e) {
            new C0749a().mo8726a("JSON error in ADCJSON putBoolean(): ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m903a(JSONObject jSONObject, String str, JSONArray jSONArray) {
        try {
            jSONObject.put(str, jSONArray);
            return true;
        } catch (JSONException e) {
            new C0749a().mo8726a("JSON error in ADCJSON putArray(): ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m904a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        try {
            jSONObject.put(str, jSONObject2);
            return true;
        } catch (JSONException e) {
            new C0749a().mo8726a("JSON error in ADCJSON putObject(): ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m900a(JSONObject jSONObject, String str, double d) {
        try {
            jSONObject.put(str, d);
            return true;
        } catch (JSONException e) {
            new C0749a().mo8726a("JSON error in ADCJSON putDouble(): ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
            return false;
        }
    }

    /* renamed from: e */
    static void m920e(JSONArray jSONArray, int i) {
        jSONArray.put(i);
    }

    /* renamed from: a */
    static void m899a(JSONArray jSONArray, boolean z) {
        jSONArray.put(z);
    }

    /* renamed from: a */
    static void m898a(JSONArray jSONArray, String str) {
        jSONArray.put(str);
    }

    /* renamed from: a */
    static void m897a(JSONArray jSONArray, Object obj) {
        jSONArray.put(obj);
    }

    /* renamed from: h */
    static boolean m923h(JSONObject jSONObject, String str) {
        try {
            C0476a.m77a().mo8576j().mo8694a(str, jSONObject.toString(), false);
            return true;
        } catch (IOException e) {
            new C0749a().mo8726a("IOException in ADCJSON's saveObject: ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
            return false;
        }
    }

    /* renamed from: c */
    static JSONObject m916c(String str) {
        try {
            String sb = C0476a.m77a().mo8576j().mo8691a(str, false).toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("loadObject from filepath ");
            sb2.append(str);
            return m894a(sb, sb2.toString());
        } catch (IOException e) {
            new C0749a().mo8726a("IOException in ADCJSON's loadObject: ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
            return m892a();
        }
    }

    /* renamed from: a */
    static String[] m906a(JSONArray jSONArray) {
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = m915c(jSONArray, i);
        }
        return strArr;
    }

    /* renamed from: a */
    static JSONArray m891a(String[] strArr) {
        JSONArray b = m909b();
        for (String a : strArr) {
            m898a(b, a);
        }
        return b;
    }

    /* renamed from: b */
    static boolean m911b(JSONArray jSONArray, String str) {
        for (int i = 0; i < jSONArray.length(); i++) {
            if (m915c(jSONArray, i).equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    static boolean m924i(JSONObject jSONObject, String str) {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            if (str.equals(keys.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static JSONArray m890a(JSONArray jSONArray, String[] strArr, boolean z) {
        for (String str : strArr) {
            if (!z || !m911b(jSONArray, str)) {
                m898a(jSONArray, str);
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    static JSONObject m896a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                jSONObject.put(str, jSONObject2.get(str));
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
