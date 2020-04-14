package com.applovin.impl.mediation.p006a.p007a;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.impl.sdk.utils.C1247h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.a.d */
public class C0915d {

    /* renamed from: a */
    private final boolean f1720a;

    /* renamed from: b */
    private final boolean f1721b;

    /* renamed from: c */
    private final String f1722c;

    public C0915d(JSONObject jSONObject, C1192i iVar) {
        JSONObject b = C1247h.m2989b(jSONObject, "cleartext_traffic", (JSONObject) null, iVar);
        String str = "";
        boolean z = false;
        if (b != null) {
            this.f1720a = true;
            this.f1722c = C1247h.m2985b(b, "description", str, iVar);
            if (C1246g.m2945a()) {
                this.f1721b = true;
                return;
            }
            List a = C1247h.m2970a(b, "domains", (List) new ArrayList(), iVar);
            if (a.size() > 0) {
                Iterator it = a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!C1246g.m2948a((String) it.next())) {
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
            }
            this.f1721b = z;
            return;
        }
        this.f1720a = false;
        this.f1722c = str;
        this.f1721b = C1246g.m2945a();
    }

    /* renamed from: a */
    public boolean mo9331a() {
        return this.f1720a;
    }

    /* renamed from: b */
    public boolean mo9332b() {
        return this.f1721b;
    }

    /* renamed from: c */
    public String mo9333c() {
        return this.f1722c;
    }
}
