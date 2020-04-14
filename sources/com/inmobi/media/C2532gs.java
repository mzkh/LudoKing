package com.inmobi.media;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.inmobi.sdk.InMobiSdk;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.gs */
/* compiled from: GDPRInfo */
public final class C2532gs {

    /* renamed from: a */
    private static final String f5544a = "gs";

    /* renamed from: b */
    private static JSONObject f5545b;

    /* renamed from: c */
    private static C2454fa f5546c;

    private C2532gs() {
    }

    @VisibleForTesting
    /* renamed from: a */
    public static void m5401a() {
        f5546c = (C2454fa) C2436er.m5081a("root", C2505gd.m5306f());
    }

    @Nullable
    /* renamed from: b */
    public static JSONObject m5403b() {
        return f5545b;
    }

    /* renamed from: a */
    public static void m5402a(@Nullable JSONObject jSONObject) {
        f5545b = jSONObject;
    }

    /* renamed from: f */
    private static int m5407f() {
        JSONObject b = m5403b();
        if (b == null) {
            return -1;
        }
        if (b.has(InMobiSdk.IM_GDPR_CONSENT_IAB)) {
            return 1;
        }
        String str = InMobiSdk.IM_GDPR_CONSENT_AVAILABLE;
        if (!b.has(str)) {
            return -1;
        }
        try {
            if (b.getBoolean(str)) {
                return 1;
            }
            return 0;
        } catch (JSONException unused) {
            return -1;
        }
    }

    /* renamed from: c */
    public static int m5404c() {
        return m5400a(false);
    }

    /* renamed from: d */
    public static void m5405d() {
        f5546c = (C2454fa) C2438es.m5087a("root", C2505gd.m5306f(), null);
    }

    /* renamed from: a */
    public static int m5400a(boolean z) {
        if (f5546c == null) {
            m5405d();
        }
        int i = f5546c.f5302d;
        int f = m5407f();
        return (f == 1 || i == 1 || z || !(i == 0 || i != -1 || f == 0)) ? 1 : 0;
    }

    /* renamed from: e */
    public static boolean m5406e() {
        return m5404c() != 0;
    }
}
