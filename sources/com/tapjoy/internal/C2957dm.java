package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.WindowManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.dm */
public final class C2957dm {

    /* renamed from: a */
    static float f6825a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b */
    private static WindowManager f6826b;

    /* renamed from: c */
    private static String[] f6827c = {"x", "y", "width", "height"};

    /* renamed from: com.tapjoy.internal.dm$a */
    static class C2958a {

        /* renamed from: a */
        final float f6828a;

        /* renamed from: b */
        final float f6829b;

        C2958a(float f, float f2) {
            this.f6828a = f;
            this.f6829b = f2;
        }
    }

    /* renamed from: a */
    public static void m6743a(Context context) {
        if (context != null) {
            f6825a = context.getResources().getDisplayMetrics().density;
            f6826b = (WindowManager) context.getSystemService("window");
        }
    }

    /* renamed from: a */
    public static void m6745a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            C2959dn.m6752a("Error with setting ad session id", e);
        }
    }

    /* renamed from: a */
    public static void m6746a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder("JSONException during JSONObject.put for name [");
            sb.append(str);
            sb.append("]");
            C2959dn.m6752a(sb.toString(), e);
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r3v0, types: [java.util.List, java.util.List<java.lang.String>] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m6747a(org.json.JSONObject r2, java.util.List<java.lang.String> r3) {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x0009:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x0019
            java.lang.Object r1 = r3.next()
            java.lang.String r1 = (java.lang.String) r1
            r0.put(r1)
            goto L_0x0009
        L_0x0019:
            java.lang.String r3 = "isFriendlyObstructionFor"
            r2.put(r3, r0)     // Catch:{ JSONException -> 0x001f }
            return
        L_0x001f:
            r2 = move-exception
            java.lang.String r3 = "Error with setting friendly obstruction"
            com.tapjoy.internal.C2959dn.m6752a(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C2957dm.m6747a(org.json.JSONObject, java.util.List):void");
    }

    /* renamed from: a */
    public static void m6748a(JSONObject jSONObject, JSONObject jSONObject2) {
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
    private static boolean m6749a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    /* renamed from: b */
    public static void m6750b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            C2959dn.m6752a("Error with setting not visible reason", e);
        }
    }

    /* renamed from: a */
    public static JSONObject m6742a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) (((float) i) / f6825a));
            jSONObject.put("y", (double) (((float) i2) / f6825a));
            jSONObject.put("width", (double) (((float) i3) / f6825a));
            jSONObject.put("height", (double) (((float) i4) / f6825a));
        } catch (JSONException e) {
            C2959dn.m6752a("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m6744a(JSONObject jSONObject) {
        float f;
        JSONObject jSONObject2 = jSONObject;
        String str = "height";
        String str2 = "width";
        float f2 = 0.0f;
        if (VERSION.SDK_INT < 17) {
            JSONArray optJSONArray = jSONObject2.optJSONArray("childViews");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                float f3 = 0.0f;
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        double optDouble = optJSONObject.optDouble("x");
                        double optDouble2 = optJSONObject.optDouble("y");
                        double optDouble3 = optJSONObject.optDouble(str2);
                        double optDouble4 = optJSONObject.optDouble(str);
                        f2 = Math.max(f2, (float) (optDouble + optDouble3));
                        f3 = Math.max(f3, (float) (optDouble2 + optDouble4));
                    }
                }
                f = f3;
                C2958a aVar = new C2958a(f2, f);
                jSONObject2.put(str2, (double) aVar.f6828a);
                jSONObject2.put(str, (double) aVar.f6829b);
            }
        } else if (f6826b != null) {
            Point point = new Point(0, 0);
            f6826b.getDefaultDisplay().getRealSize(point);
            f2 = ((float) point.x) / f6825a;
            f = ((float) point.y) / f6825a;
            C2958a aVar2 = new C2958a(f2, f);
            jSONObject2.put(str2, (double) aVar2.f6828a);
            jSONObject2.put(str, (double) aVar2.f6829b);
        }
        f = 0.0f;
        C2958a aVar22 = new C2958a(f2, f);
        try {
            jSONObject2.put(str2, (double) aVar22.f6828a);
            jSONObject2.put(str, (double) aVar22.f6829b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009f A[RETURN] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m6751b(@androidx.annotation.NonNull org.json.JSONObject r10, @androidx.annotation.Nullable org.json.JSONObject r11) {
        /*
            r0 = 1
            if (r10 != 0) goto L_0x0006
            if (r11 != 0) goto L_0x0006
            return r0
        L_0x0006:
            r1 = 0
            if (r10 == 0) goto L_0x00a0
            if (r11 != 0) goto L_0x000d
            goto L_0x00a0
        L_0x000d:
            java.lang.String[] r2 = f6827c
            int r3 = r2.length
            r4 = 0
        L_0x0011:
            if (r4 >= r3) goto L_0x0026
            r5 = r2[r4]
            double r6 = r10.optDouble(r5)
            double r8 = r11.optDouble(r5)
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x0023
            r2 = 0
            goto L_0x0027
        L_0x0023:
            int r4 = r4 + 1
            goto L_0x0011
        L_0x0026:
            r2 = 1
        L_0x0027:
            if (r2 == 0) goto L_0x00a0
            java.lang.String r2 = "adSessionId"
            java.lang.String r3 = ""
            java.lang.String r4 = r10.optString(r2, r3)
            java.lang.String r2 = r11.optString(r2, r3)
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x00a0
            java.lang.String r2 = "isFriendlyObstructionFor"
            org.json.JSONArray r4 = r10.optJSONArray(r2)
            org.json.JSONArray r2 = r11.optJSONArray(r2)
            if (r4 != 0) goto L_0x0049
            if (r2 == 0) goto L_0x006a
        L_0x0049:
            boolean r5 = m6749a(r4, r2)
            if (r5 != 0) goto L_0x0051
        L_0x004f:
            r2 = 0
            goto L_0x006b
        L_0x0051:
            r5 = 0
        L_0x0052:
            int r6 = r4.length()
            if (r5 >= r6) goto L_0x006a
            java.lang.String r6 = r4.optString(r5, r3)
            java.lang.String r7 = r2.optString(r5, r3)
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0067
            goto L_0x004f
        L_0x0067:
            int r5 = r5 + 1
            goto L_0x0052
        L_0x006a:
            r2 = 1
        L_0x006b:
            if (r2 == 0) goto L_0x00a0
            java.lang.String r2 = "childViews"
            org.json.JSONArray r10 = r10.optJSONArray(r2)
            org.json.JSONArray r11 = r11.optJSONArray(r2)
            if (r10 != 0) goto L_0x007b
            if (r11 == 0) goto L_0x009c
        L_0x007b:
            boolean r2 = m6749a(r10, r11)
            if (r2 != 0) goto L_0x0083
        L_0x0081:
            r10 = 0
            goto L_0x009d
        L_0x0083:
            r2 = 0
        L_0x0084:
            int r3 = r10.length()
            if (r2 >= r3) goto L_0x009c
            org.json.JSONObject r3 = r10.optJSONObject(r2)
            org.json.JSONObject r4 = r11.optJSONObject(r2)
            boolean r3 = m6751b(r3, r4)
            if (r3 != 0) goto L_0x0099
            goto L_0x0081
        L_0x0099:
            int r2 = r2 + 1
            goto L_0x0084
        L_0x009c:
            r10 = 1
        L_0x009d:
            if (r10 == 0) goto L_0x00a0
            return r0
        L_0x00a0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C2957dm.m6751b(org.json.JSONObject, org.json.JSONObject):boolean");
    }
}
