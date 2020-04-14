package com.iab.omid.library.adcolony.adsession;

import com.iab.omid.library.adcolony.p028d.C2049e;

public class Partner {

    /* renamed from: a */
    private final String f3989a;

    /* renamed from: b */
    private final String f3990b;

    private Partner(String str, String str2) {
        this.f3989a = str;
        this.f3990b = str2;
    }

    public static Partner createPartner(String str, String str2) {
        C2049e.m3843a(str, "Name is null or empty");
        C2049e.m3843a(str2, "Version is null or empty");
        return new Partner(str, str2);
    }

    public String getName() {
        return this.f3989a;
    }

    public String getVersion() {
        return this.f3990b;
    }
}
