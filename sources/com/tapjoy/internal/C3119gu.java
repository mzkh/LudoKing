package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.gu */
public final class C3119gu {
    /* renamed from: a */
    public static String m7204a(String str) {
        if (!(str == null || str.length() == 0)) {
            String trim = str.trim();
            if (trim == null || trim.length() == 0) {
                return null;
            }
            return trim;
        }
        return null;
    }

    /* renamed from: b */
    public static String m7206b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim;
    }

    /* renamed from: a */
    public static String m7205a(String str, String str2, String str3) {
        if (str == null) {
            C3124gw.m7217a(str2, str3, "must not be null");
            return null;
        } else if (str.length() == 0) {
            C3124gw.m7217a(str2, str3, "must not be empty");
            return null;
        } else {
            String trim = str.trim();
            if (trim.length() != 0) {
                return trim;
            }
            C3124gw.m7217a(str2, str3, "must not be blank");
            return null;
        }
    }
}
