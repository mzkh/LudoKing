package com.tapjoy.internal;

import java.net.URL;

/* renamed from: com.tapjoy.internal.cy */
public final class C2939cy {

    /* renamed from: a */
    public final String f6776a;

    /* renamed from: b */
    public final URL f6777b;

    /* renamed from: c */
    public final String f6778c;

    private C2939cy(String str, URL url, String str2) {
        this.f6776a = str;
        this.f6777b = url;
        this.f6778c = str2;
    }

    /* renamed from: a */
    public static C2939cy m6694a(String str, URL url, String str2) {
        C2960do.m6755a(str, "VendorKey is null or empty");
        C2960do.m6754a((Object) url, "ResourceURL is null");
        C2960do.m6755a(str2, "VerificationParameters is null or empty");
        return new C2939cy(str, url, str2);
    }

    /* renamed from: a */
    public static C2939cy m6695a(URL url) {
        C2960do.m6754a((Object) url, "ResourceURL is null");
        return new C2939cy(null, url, null);
    }
}
