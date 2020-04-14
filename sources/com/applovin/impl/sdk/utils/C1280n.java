package com.applovin.impl.sdk.utils;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.p019b.C1099f;
import java.util.Locale;
import java.util.UUID;

/* renamed from: com.applovin.impl.sdk.utils.n */
public final class C1280n {

    /* renamed from: a */
    private final C1192i f3218a;

    /* renamed from: b */
    private String f3219b = m3056d();

    /* renamed from: c */
    private final String f3220c;

    /* renamed from: d */
    private final String f3221d;

    public C1280n(C1192i iVar) {
        this.f3218a = iVar;
        this.f3220c = m3055a(C1098e.f2559e, (String) C1099f.m2152b(C1098e.f2558d, null, iVar.mo10179D()));
        this.f3221d = m3055a(C1098e.f2560f, (String) iVar.mo10202a(C1096c.f2277S));
    }

    /* renamed from: a */
    private String m3055a(C1098e<String> eVar, String str) {
        String str2 = (String) C1099f.m2152b(eVar, null, this.f3218a.mo10179D());
        if (C1277l.m3042b(str2)) {
            return str2;
        }
        if (!C1277l.m3042b(str)) {
            str = UUID.randomUUID().toString().toLowerCase(Locale.US);
        }
        C1099f.m2150a(eVar, str, this.f3218a.mo10179D());
        return str;
    }

    /* renamed from: d */
    private String m3056d() {
        if (!((Boolean) this.f3218a.mo10202a(C1096c.f2521ea)).booleanValue()) {
            this.f3218a.mo10226b(C1098e.f2557c);
        }
        String str = (String) this.f3218a.mo10203a(C1098e.f2557c);
        if (C1277l.m3042b(str)) {
            C1227o v = this.f3218a.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Using identifier (");
            sb.append(str);
            sb.append(") from previous session");
            v.mo10378b("AppLovinSdk", sb.toString());
            this.f3219b = str;
        }
        return null;
    }

    /* renamed from: a */
    public String mo10443a() {
        return this.f3219b;
    }

    /* renamed from: a */
    public void mo10444a(String str) {
        if (((Boolean) this.f3218a.mo10202a(C1096c.f2521ea)).booleanValue()) {
            this.f3218a.mo10209a(C1098e.f2557c, str);
        }
        this.f3219b = str;
    }

    /* renamed from: b */
    public String mo10445b() {
        return this.f3220c;
    }

    /* renamed from: c */
    public String mo10446c() {
        return this.f3221d;
    }
}
