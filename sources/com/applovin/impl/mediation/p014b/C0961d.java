package com.applovin.impl.mediation.p014b;

import com.applovin.impl.mediation.C0999i;
import com.applovin.impl.sdk.C1192i;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.d */
public class C0961d extends C0958a {
    private C0961d(C0961d dVar, C0999i iVar) {
        super(dVar.mo9493x(), dVar.mo9492w(), iVar, dVar.f1841b);
    }

    public C0961d(JSONObject jSONObject, JSONObject jSONObject2, C1192i iVar) {
        super(jSONObject, jSONObject2, null, iVar);
    }

    /* renamed from: a */
    public C0958a mo9425a(C0999i iVar) {
        return new C0961d(this, iVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediatedNativeAd{format=");
        sb.append(getFormat());
        sb.append(", adUnitId=");
        sb.append(getAdUnitId());
        sb.append(", isReady=");
        sb.append(mo9426a());
        sb.append(", adapterClass='");
        sb.append(mo9494y());
        sb.append("', adapterName='");
        sb.append(mo9495z());
        sb.append("', isTesting=");
        sb.append(mo9464A());
        sb.append(", isRefreshEnabled=");
        sb.append(mo9468E());
        sb.append(", getAdRefreshMillis=");
        sb.append(mo9469F());
        sb.append('}');
        return sb.toString();
    }
}
