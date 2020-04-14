package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.view.WindowManager;

/* renamed from: com.applovin.impl.sdk.utils.f */
public class C1245f {
    /* renamed from: a */
    public static Point m2928a(Context context) {
        Point point = new Point();
        point.x = 480;
        point.y = 320;
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        } catch (Throwable unused) {
        }
        return point;
    }

    /* renamed from: a */
    public static void m2929a() {
        try {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static boolean m2930a(String str, Context context) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: b */
    public static boolean m2931b() {
        return VERSION.SDK_INT >= 14;
    }

    /* renamed from: c */
    public static boolean m2932c() {
        return VERSION.SDK_INT >= 16;
    }

    /* renamed from: d */
    public static boolean m2933d() {
        return VERSION.SDK_INT >= 17;
    }

    /* renamed from: e */
    public static boolean m2934e() {
        return VERSION.SDK_INT >= 19;
    }

    /* renamed from: f */
    public static boolean m2935f() {
        return VERSION.SDK_INT >= 21;
    }

    /* renamed from: g */
    public static boolean m2936g() {
        return VERSION.SDK_INT >= 23;
    }

    /* renamed from: h */
    public static boolean m2937h() {
        return VERSION.SDK_INT >= 24;
    }

    /* renamed from: i */
    public static boolean m2938i() {
        return VERSION.SDK_INT >= 29;
    }
}
