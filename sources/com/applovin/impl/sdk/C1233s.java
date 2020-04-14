package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.utils.C1247h;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.s */
public class C1233s {

    /* renamed from: a */
    private final C1192i f3121a;

    /* renamed from: b */
    private final JSONObject f3122b;

    /* renamed from: c */
    private final Object f3123c = new Object();

    public C1233s(C1192i iVar) {
        this.f3121a = iVar;
        this.f3122b = C1247h.m2975a((String) iVar.mo10222b(C1098e.f2571q, "{}"), new JSONObject(), iVar);
    }

    /* renamed from: a */
    public Integer mo10395a(String str) {
        Integer valueOf;
        synchronized (this.f3123c) {
            if (this.f3122b.has(str)) {
                C1247h.m2978a(this.f3122b, str, C1247h.m2984b(this.f3122b, str, 0, this.f3121a) + 1, this.f3121a);
            } else {
                C1247h.m2978a(this.f3122b, str, 1, this.f3121a);
            }
            this.f3121a.mo10209a(C1098e.f2571q, this.f3122b.toString());
            valueOf = Integer.valueOf(C1247h.m2984b(this.f3122b, str, 0, this.f3121a));
        }
        return valueOf;
    }
}
