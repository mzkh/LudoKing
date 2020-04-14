package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.cx */
public final class C2938cx {

    /* renamed from: a */
    public final String f6774a;

    /* renamed from: b */
    public final String f6775b;

    private C2938cx(String str, String str2) {
        this.f6774a = str;
        this.f6775b = str2;
    }

    /* renamed from: a */
    public static C2938cx m6693a(String str, String str2) {
        C2960do.m6755a(str, "Name is null or empty");
        C2960do.m6755a(str2, "Version is null or empty");
        return new C2938cx(str, str2);
    }
}
