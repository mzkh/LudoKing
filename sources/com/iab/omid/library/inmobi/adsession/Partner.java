package com.iab.omid.library.inmobi.adsession;

import com.iab.omid.library.inmobi.p034d.C2097e;

public class Partner {
    private final String name;
    private final String version;

    private Partner(String str, String str2) {
        this.name = str;
        this.version = str2;
    }

    public static Partner createPartner(String str, String str2) {
        C2097e.m4049a(str, "Name is null or empty");
        C2097e.m4049a(str2, "Version is null or empty");
        return new Partner(str, str2);
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }
}
