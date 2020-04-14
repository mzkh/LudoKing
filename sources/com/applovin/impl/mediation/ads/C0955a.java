package com.applovin.impl.mediation.ads;

import com.applovin.impl.mediation.C0994f.C0996a;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;

/* renamed from: com.applovin.impl.mediation.ads.a */
public abstract class C0955a {
    protected final MaxAdFormat adFormat;
    protected MaxAdListener adListener = null;
    protected final String adUnitId;
    protected final C0996a loadRequestBuilder;
    protected final C1227o logger;
    protected final C1192i sdk;
    protected final String tag;

    protected C0955a(String str, MaxAdFormat maxAdFormat, String str2, C1192i iVar) {
        this.adUnitId = str;
        this.adFormat = maxAdFormat;
        this.sdk = iVar;
        this.tag = str2;
        this.logger = iVar.mo10249v();
        this.loadRequestBuilder = new C0996a();
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public void setExtraParameter(String str, String str2) {
        if (str != null) {
            this.loadRequestBuilder.mo9538a(str, str2);
            return;
        }
        throw new IllegalArgumentException("No key specified");
    }

    public void setListener(MaxAdListener maxAdListener) {
        C1227o oVar = this.logger;
        String str = this.tag;
        StringBuilder sb = new StringBuilder();
        sb.append("Setting listener: ");
        sb.append(maxAdListener);
        oVar.mo10378b(str, sb.toString());
        this.adListener = maxAdListener;
    }
}
