package com.adcolony.sdk;

/* renamed from: com.adcolony.sdk.t */
class C0745t {

    /* renamed from: a */
    private String f1160a;

    /* renamed from: b */
    private String f1161b;

    /* renamed from: c */
    private String f1162c;

    /* renamed from: d */
    private String f1163d = "%s_%s_%s";

    public C0745t(String str, String str2, String str3) {
        this.f1160a = str;
        this.f1161b = str2;
        this.f1162c = str3;
    }

    /* renamed from: a */
    public String mo8717a() {
        return String.format(this.f1163d, new Object[]{mo8718b(), mo8719c(), mo8720d()});
    }

    /* renamed from: b */
    public String mo8718b() {
        return this.f1160a;
    }

    /* renamed from: c */
    public String mo8719c() {
        return this.f1161b;
    }

    /* renamed from: d */
    public String mo8720d() {
        return this.f1162c;
    }
}
