package com.iab.omid.library.inmobi.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.inmobi.walking.p036a.C2110b.C2112b;
import com.iab.omid.library.inmobi.walking.p036a.C2113c;
import com.iab.omid.library.inmobi.walking.p036a.C2114d;
import com.iab.omid.library.inmobi.walking.p036a.C2115e;
import com.iab.omid.library.inmobi.walking.p036a.C2116f;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.inmobi.walking.b */
public class C2117b implements C2112b {

    /* renamed from: a */
    private JSONObject f4195a;

    /* renamed from: b */
    private final C2113c f4196b;

    public C2117b(C2113c cVar) {
        this.f4196b = cVar;
    }

    /* renamed from: a */
    public void mo27652a() {
        this.f4196b.mo27645b(new C2114d(this));
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo27643a(JSONObject jSONObject) {
        this.f4195a = jSONObject;
    }

    /* renamed from: a */
    public void mo27653a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        C2113c cVar = this.f4196b;
        C2116f fVar = new C2116f(this, hashSet, jSONObject, j);
        cVar.mo27645b(fVar);
    }

    @VisibleForTesting
    /* renamed from: b */
    public JSONObject mo27644b() {
        return this.f4195a;
    }

    /* renamed from: b */
    public void mo27654b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        C2113c cVar = this.f4196b;
        C2115e eVar = new C2115e(this, hashSet, jSONObject, j);
        cVar.mo27645b(eVar);
    }
}
