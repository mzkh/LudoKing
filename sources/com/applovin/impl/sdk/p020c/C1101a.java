package com.applovin.impl.sdk.p020c;

/* renamed from: com.applovin.impl.sdk.c.a */
public class C1101a {

    /* renamed from: a */
    private final String f2585a;

    /* renamed from: b */
    private final String f2586b;

    public C1101a(String str, String str2) {
        this.f2585a = str;
        this.f2586b = str2;
    }

    /* renamed from: a */
    public String mo9988a() {
        return this.f2585a;
    }

    /* renamed from: b */
    public String mo9989b() {
        return this.f2586b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdEventPostback{url='");
        sb.append(this.f2585a);
        sb.append('\'');
        sb.append(", backupUrl='");
        sb.append(this.f2586b);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
