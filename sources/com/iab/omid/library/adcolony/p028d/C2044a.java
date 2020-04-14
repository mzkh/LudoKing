package com.iab.omid.library.adcolony.p028d;

import android.os.Build;
import android.os.Build.VERSION;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.d.a */
public final class C2044a {
    /* renamed from: a */
    public static String m3816a() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append("; ");
        sb.append(Build.MODEL);
        return sb.toString();
    }

    /* renamed from: b */
    public static String m3817b() {
        return Integer.toString(VERSION.SDK_INT);
    }

    /* renamed from: c */
    public static String m3818c() {
        return "Android";
    }

    /* renamed from: d */
    public static JSONObject m3819d() {
        JSONObject jSONObject = new JSONObject();
        C2045b.m3825a(jSONObject, "deviceType", m3816a());
        C2045b.m3825a(jSONObject, "osVersion", m3817b());
        C2045b.m3825a(jSONObject, "os", m3818c());
        return jSONObject;
    }
}
