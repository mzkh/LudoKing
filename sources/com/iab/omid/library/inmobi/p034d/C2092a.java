package com.iab.omid.library.inmobi.p034d;

import android.os.Build;
import android.os.Build.VERSION;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.inmobi.d.a */
public final class C2092a {
    /* renamed from: a */
    public static String m4021a() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append("; ");
        sb.append(Build.MODEL);
        return sb.toString();
    }

    /* renamed from: b */
    public static String m4022b() {
        return Integer.toString(VERSION.SDK_INT);
    }

    /* renamed from: c */
    public static String m4023c() {
        return "Android";
    }

    /* renamed from: d */
    public static JSONObject m4024d() {
        JSONObject jSONObject = new JSONObject();
        C2093b.m4030a(jSONObject, "deviceType", m4021a());
        C2093b.m4030a(jSONObject, "osVersion", m4022b());
        C2093b.m4030a(jSONObject, "os", m4023c());
        return jSONObject;
    }
}
