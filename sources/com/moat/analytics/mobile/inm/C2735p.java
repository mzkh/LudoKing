package com.moat.analytics.mobile.inm;

import android.util.Log;
import android.view.View;

/* renamed from: com.moat.analytics.mobile.inm.p */
class C2735p {
    C2735p() {
    }

    /* renamed from: a */
    static String m6308a(View view) {
        if (view == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(view.getClass().getSimpleName());
        sb.append("@");
        sb.append(view.hashCode());
        return sb.toString();
    }

    /* renamed from: a */
    private static String m6309a(String str) {
        return "Moat".concat(String.valueOf(str));
    }

    /* renamed from: a */
    static void m6310a(int i, String str, Object obj, String str2) {
        if (C2750w.m6348a().f6156b) {
            if (obj == null) {
                Log.println(i, m6309a(str), String.format("message = %s", new Object[]{str2}));
                return;
            }
            Log.println(i, m6309a(str), String.format("id = %s, message = %s", new Object[]{Integer.valueOf(obj.hashCode()), str2}));
        }
    }

    /* renamed from: a */
    static void m6311a(String str, int i, String str2, Object obj, String str3) {
        m6310a(i, str2, obj, str3);
        m6313a(str, str3);
    }

    /* renamed from: a */
    static void m6312a(String str, Object obj, String str2, Throwable th) {
        if (C2750w.m6348a().f6156b) {
            Log.e(m6309a(str), String.format("id = %s, message = %s", new Object[]{Integer.valueOf(obj.hashCode()), str2}), th);
        }
    }

    /* renamed from: a */
    static void m6313a(String str, String str2) {
        if (!C2750w.m6348a().f6156b && ((C2724k) MoatAnalytics.getInstance()).f6100a) {
            int i = 2;
            if (str.equals("[ERROR] ")) {
                i = 6;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            Log.println(i, "MoatAnalytics", sb.toString());
        }
    }

    /* renamed from: b */
    static void m6314b(int i, String str, Object obj, String str2) {
        if (C2750w.m6348a().f6157c) {
            String a = m6309a(str);
            Object[] objArr = new Object[2];
            objArr[0] = obj == null ? "null" : Integer.valueOf(obj.hashCode());
            objArr[1] = str2;
            Log.println(i, a, String.format("id = %s, message = %s", objArr));
        }
    }
}
