package com.iab.omid.library.adcolony.p028d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.d.b */
public class C2045b {

    /* renamed from: a */
    static float f4047a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b */
    private static WindowManager f4048b;

    /* renamed from: c */
    private static String[] f4049c = {"x", "y", "width", "height"};

    /* renamed from: com.iab.omid.library.adcolony.d.b$a */
    private static class C2046a {

        /* renamed from: a */
        final float f4050a;

        /* renamed from: b */
        final float f4051b;

        C2046a(float f, float f2) {
            this.f4050a = f;
            this.f4051b = f2;
        }
    }

    /* renamed from: a */
    static float m3820a(int i) {
        return ((float) i) / f4047a;
    }

    /* renamed from: a */
    public static JSONObject m3821a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) m3820a(i));
            jSONObject.put("y", (double) m3820a(i2));
            jSONObject.put("width", (double) m3820a(i3));
            jSONObject.put("height", (double) m3820a(i4));
        } catch (JSONException e) {
            C2047c.m3836a("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m3822a(Context context) {
        if (context != null) {
            f4047a = context.getResources().getDisplayMetrics().density;
            f4048b = (WindowManager) context.getSystemService("window");
        }
    }

    /* renamed from: a */
    public static void m3823a(JSONObject jSONObject) {
        C2046a b = m3829b(jSONObject);
        try {
            jSONObject.put("width", (double) b.f4050a);
            jSONObject.put("height", (double) b.f4051b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m3824a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            C2047c.m3836a("Error with setting ad session id", e);
        }
    }

    /* renamed from: a */
    public static void m3825a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("JSONException during JSONObject.put for name [");
            sb.append(str);
            sb.append("]");
            C2047c.m3836a(sb.toString(), e);
        }
    }

    /* renamed from: a */
    public static void m3826a(JSONObject jSONObject, List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
        } catch (JSONException e) {
            C2047c.m3836a("Error with setting friendly obstruction", e);
        }
    }

    /* renamed from: a */
    public static void m3827a(JSONObject jSONObject, JSONObject jSONObject2) {
        String str = "childViews";
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put(str, optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static boolean m3828a(JSONArray jSONArray, JSONArray jSONArray2) {
        boolean z = true;
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray == null || jSONArray2 == null) {
            return false;
        }
        if (jSONArray.length() != jSONArray2.length()) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    private static C2046a m3829b(JSONObject jSONObject) {
        float f;
        float f2 = 0.0f;
        if (VERSION.SDK_INT < 17) {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                float f3 = 0.0f;
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        double optDouble = optJSONObject.optDouble("x");
                        double optDouble2 = optJSONObject.optDouble("y");
                        double optDouble3 = optJSONObject.optDouble("width");
                        double optDouble4 = optJSONObject.optDouble("height");
                        f2 = Math.max(f2, (float) (optDouble + optDouble3));
                        f3 = Math.max(f3, (float) (optDouble2 + optDouble4));
                    }
                }
                f = f3;
                return new C2046a(f2, f);
            }
        } else if (f4048b != null) {
            Point point = new Point(0, 0);
            f4048b.getDefaultDisplay().getRealSize(point);
            f2 = m3820a(point.x);
            f = m3820a(point.y);
            return new C2046a(f2, f);
        }
        f = 0.0f;
        return new C2046a(f2, f);
    }

    /* renamed from: b */
    public static boolean m3830b(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        boolean z = true;
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject == null || jSONObject2 == null) {
            return false;
        }
        if (!m3831c(jSONObject, jSONObject2) || !m3832d(jSONObject, jSONObject2) || !m3833e(jSONObject, jSONObject2) || !m3834f(jSONObject, jSONObject2)) {
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    private static boolean m3831c(JSONObject jSONObject, JSONObject jSONObject2) {
        String[] strArr;
        for (String str : f4049c) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private static boolean m3832d(JSONObject jSONObject, JSONObject jSONObject2) {
        String str = "";
        String str2 = "adSessionId";
        return jSONObject.optString(str2, str).equals(jSONObject2.optString(str2, str));
    }

    /* renamed from: e */
    private static boolean m3833e(JSONObject jSONObject, JSONObject jSONObject2) {
        String str = "isFriendlyObstructionFor";
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        JSONArray optJSONArray2 = jSONObject2.optJSONArray(str);
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m3828a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            String str2 = "";
            if (!optJSONArray.optString(i, str2).equals(optJSONArray2.optString(i, str2))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    private static boolean m3834f(JSONObject jSONObject, JSONObject jSONObject2) {
        String str = "childViews";
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        JSONArray optJSONArray2 = jSONObject2.optJSONArray(str);
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m3828a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (!m3830b(optJSONArray.optJSONObject(i), optJSONArray2.optJSONObject(i))) {
                return false;
            }
        }
        return true;
    }
}
