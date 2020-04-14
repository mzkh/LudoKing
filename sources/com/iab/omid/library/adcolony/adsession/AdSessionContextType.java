package com.iab.omid.library.adcolony.adsession;

import com.tapjoy.TJAdUnitConstants.String;

public enum AdSessionContextType {
    HTML(String.HTML),
    NATIVE("native");
    

    /* renamed from: a */
    private final String f3984a;

    private AdSessionContextType(String str) {
        this.f3984a = str;
    }

    public String toString() {
        return this.f3984a;
    }
}
