package com.iab.omid.library.inmobi.p034d;

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

/* renamed from: com.iab.omid.library.inmobi.d.b */
public class C2093b {

    /* renamed from: a */
    static float f4147a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b */
    private static WindowManager f4148b;

    /* renamed from: c */
    private static String[] f4149c = {"x", "y", "width", "height"};

    /* renamed from: com.iab.omid.library.inmobi.d.b$a */
    static class C2094a {

        /* renamed from: a */
        final float f4150a;

        /* renamed from: b */
        final float f4151b;

        C2094a(float f, float f2) {
            this.f4150a = f;
            this.f4151b = f2;
        }
    }

    /* renamed from: a */
    static float m4025a(int i) {
        return ((float) i) / f4147a;
    }

    /* renamed from: a */
    public static JSONObject m4026a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) m4025a(i));
            jSONObject.put("y", (double) m4025a(i2));
            jSONObject.put("width", (double) m4025a(i3));
            jSONObject.put("height", (double) m4025a(i4));
        } catch (JSONException e) {
            C2095c.m4042a("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m4027a(Context context) {
        if (context != null) {
            f4147a = context.getResources().getDisplayMetrics().density;
            f4148b = (WindowManager) context.getSystemService("window");
        }
    }

    /* renamed from: a */
    public static void m4028a(JSONObject jSONObject) {
        C2094a b = m4034b(jSONObject);
        try {
            jSONObject.put("width", (double) b.f4150a);
            jSONObject.put("height", (double) b.f4151b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m4029a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            C2095c.m4042a("Error with setting ad session id", e);
        }
    }

    /* renamed from: a */
    public static void m4030a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder("JSONException during JSONObject.put for name [");
            sb.append(str);
            sb.append("]");
            C2095c.m4042a(sb.toString(), e);
        }
    }

    /* renamed from: a */
    public static void m4031a(JSONObject jSONObject, List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
        } catch (JSONException e) {
            C2095c.m4042a("Error with setting friendly obstruction", e);
        }
    }

    /* renamed from: a */
    public static void m4032a(JSONObject jSONObject, JSONObject jSONObject2) {
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
    private static boolean m4033a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    /* renamed from: b */
    private static C2094a m4034b(JSONObject jSONObject) {
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
                        f3 = Math.max(f3, (float) (optDouble + optDouble3));
                        f2 = Math.max(f2, (float) (optDouble2 + optDouble4));
                    }
                }
                f = f2;
                f2 = f3;
                return new C2094a(f2, f);
            }
        } else if (f4148b != null) {
            Point point = new Point(0, 0);
            f4148b.getDefaultDisplay().getRealSize(point);
            f2 = m4025a(point.x);
            f = m4025a(point.y);
            return new C2094a(f2, f);
        }
        f = 0.0f;
        return new C2094a(f2, f);
    }

    /* renamed from: b */
    public static void m4035b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            C2095c.m4042a("Error with setting not visible reason", e);
        }
    }

    /* renamed from: b */
    public static boolean m4036b(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && m4037c(jSONObject, jSONObject2) && m4038d(jSONObject, jSONObject2) && m4039e(jSONObject, jSONObject2) && m4040f(jSONObject, jSONObject2);
    }

    /* renamed from: c */
    private static boolean m4037c(JSONObject jSONObject, JSONObject jSONObject2) {
        String[] strArr;
        for (String str : f4149c) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private static boolean m4038d(JSONObject jSONObject, JSONObject jSONObject2) {
        String str = "";
        String str2 = "adSessionId";
        return jSONObject.optString(str2, str).equals(jSONObject2.optString(str2, str));
    }

    /* renamed from: e */
    private static boolean m4039e(JSONObject jSONObject, JSONObject jSONObject2) {
        String str = "isFriendlyObstructionFor";
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        JSONArray optJSONArray2 = jSONObject2.optJSONArray(str);
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m4033a(optJSONArray, optJSONArray2)) {
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
    private static boolean m4040f(JSONObject jSONObject, JSONObject jSONObject2) {
        String str = "childViews";
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        JSONArray optJSONArray2 = jSONObject2.optJSONArray(str);
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m4033a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (!m4036b(optJSONArray.optJSONObject(i), optJSONArray2.optJSONObject(i))) {
                return false;
            }
        }
        return true;
    }
}
