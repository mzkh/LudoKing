package com.applovin.impl.mediation.p014b;

import com.applovin.impl.sdk.C1192i;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.g */
public class C0965g extends C0962e {
    public C0965g(JSONObject jSONObject, JSONObject jSONObject2, C1192i iVar) {
        super(jSONObject, jSONObject2, iVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo9426a() {
        return mo9475a("max_signal_length", 2048);
    }

    /* renamed from: b */
    public boolean mo9503b() {
        return mo9488b("only_collect_signal_when_initialized", Boolean.valueOf(false));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SignalProviderSpec{specObject=");
        sb.append(mo9493x());
        sb.append('}');
        return sb.toString();
    }
}
