package com.tapjoy.internal;

import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.jq */
public final class C1852jq {
    /* renamed from: a */
    public static String m3667a(@Nullable String str) {
        return str == null ? "" : str;
    }

    @Nullable
    /* renamed from: b */
    public static String m3668b(@Nullable String str) {
        if (m3669c(str)) {
            return null;
        }
        return str;
    }

    /* renamed from: c */
    public static boolean m3669c(@Nullable String str) {
        return str == null || str.length() == 0;
    }
}
