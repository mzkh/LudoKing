package com.applovin.impl.mediation;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;

/* renamed from: com.applovin.impl.mediation.l */
public class C1043l implements MaxAd {

    /* renamed from: a */
    private final String f2027a;

    /* renamed from: b */
    private final MaxAdFormat f2028b;

    public C1043l(String str, MaxAdFormat maxAdFormat) {
        this.f2027a = str;
        this.f2028b = maxAdFormat;
    }

    public String getAdUnitId() {
        return this.f2027a;
    }

    public MaxAdFormat getFormat() {
        return this.f2028b;
    }
}
