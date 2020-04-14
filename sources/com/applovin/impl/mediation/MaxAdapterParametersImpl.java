package com.applovin.impl.mediation;

import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.mediation.p014b.C0958a;
import com.applovin.impl.mediation.p014b.C0962e;
import com.applovin.impl.mediation.p014b.C0965g;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;

public class MaxAdapterParametersImpl implements MaxAdapterInitializationParameters, MaxAdapterResponseParameters, MaxAdapterSignalCollectionParameters {

    /* renamed from: a */
    private Bundle f1645a;

    /* renamed from: b */
    private boolean f1646b;

    /* renamed from: c */
    private boolean f1647c;

    /* renamed from: d */
    private boolean f1648d;

    /* renamed from: e */
    private String f1649e;

    /* renamed from: f */
    private String f1650f;

    /* renamed from: g */
    private MaxAdFormat f1651g;

    private MaxAdapterParametersImpl() {
    }

    /* renamed from: a */
    static MaxAdapterParametersImpl m1398a(C0958a aVar, Context context) {
        MaxAdapterParametersImpl a = m1399a((C0962e) aVar, context);
        a.f1649e = aVar.mo9430e();
        a.f1650f = aVar.mo9429d();
        return a;
    }

    /* renamed from: a */
    static MaxAdapterParametersImpl m1399a(C0962e eVar, Context context) {
        MaxAdapterParametersImpl maxAdapterParametersImpl = new MaxAdapterParametersImpl();
        maxAdapterParametersImpl.f1646b = eVar.mo9486b(context);
        maxAdapterParametersImpl.f1647c = eVar.mo9481a(context);
        maxAdapterParametersImpl.f1645a = eVar.mo9466C();
        maxAdapterParametersImpl.f1648d = eVar.mo9464A();
        return maxAdapterParametersImpl;
    }

    /* renamed from: a */
    static MaxAdapterParametersImpl m1400a(C0965g gVar, MaxAdFormat maxAdFormat, Context context) {
        MaxAdapterParametersImpl a = m1399a((C0962e) gVar, context);
        a.f1651g = maxAdFormat;
        return a;
    }

    public MaxAdFormat getAdFormat() {
        return this.f1651g;
    }

    public String getBidResponse() {
        return this.f1650f;
    }

    public Bundle getServerParameters() {
        return this.f1645a;
    }

    public String getThirdPartyAdPlacementId() {
        return this.f1649e;
    }

    public boolean hasUserConsent() {
        return this.f1647c;
    }

    public boolean isAgeRestrictedUser() {
        return this.f1646b;
    }

    public boolean isTesting() {
        return this.f1648d;
    }
}
