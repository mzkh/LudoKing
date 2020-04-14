package com.applovin.impl.mediation.p016d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p019b.C1095b;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.impl.sdk.utils.C1247h;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.d.b */
public class C0989b extends C1246g {
    /* renamed from: a */
    public static String m1762a(C1192i iVar) {
        return C1246g.m2941a((String) iVar.mo10202a(C1095b.f2252c), "1.0/mediate", iVar);
    }

    /* renamed from: a */
    public static void m1763a(JSONObject jSONObject, C1192i iVar) {
        if (C1247h.m2983a(jSONObject, "signal_providers")) {
            iVar.mo10209a(C1098e.f2576v, jSONObject.toString());
        }
    }

    /* renamed from: b */
    public static String m1764b(C1192i iVar) {
        return C1246g.m2941a((String) iVar.mo10202a(C1095b.f2253d), "1.0/mediate", iVar);
    }

    /* renamed from: b */
    public static void m1765b(JSONObject jSONObject, C1192i iVar) {
        if (C1247h.m2983a(jSONObject, "auto_init_adapters")) {
            iVar.mo10209a(C1098e.f2577w, jSONObject.toString());
        }
    }

    /* renamed from: c */
    public static String m1766c(C1192i iVar) {
        return C1246g.m2941a((String) iVar.mo10202a(C1095b.f2252c), "1.0/mediate_debug", iVar);
    }

    /* renamed from: d */
    public static String m1767d(C1192i iVar) {
        return C1246g.m2941a((String) iVar.mo10202a(C1095b.f2253d), "1.0/mediate_debug", iVar);
    }
}
