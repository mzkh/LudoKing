package com.applovin.impl.sdk.p017a;

import java.util.Map;

/* renamed from: com.applovin.impl.sdk.a.c */
public class C1075c {

    /* renamed from: a */
    private final String f2131a;

    /* renamed from: b */
    private Map<String, String> f2132b;

    private C1075c(String str, Map<String, String> map) {
        this.f2131a = str;
        this.f2132b = map;
    }

    /* renamed from: a */
    public static C1075c m1948a(String str) {
        return m1949a(str, null);
    }

    /* renamed from: a */
    public static C1075c m1949a(String str, Map<String, String> map) {
        return new C1075c(str, map);
    }

    /* renamed from: a */
    public Map<String, String> mo9770a() {
        return this.f2132b;
    }

    /* renamed from: b */
    public String mo9771b() {
        return this.f2131a;
    }
}
