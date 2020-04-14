package com.iab.omid.library.adcolony.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.adcolony.walking.p030a.C2062b.C2064b;
import com.iab.omid.library.adcolony.walking.p030a.C2065c;
import com.iab.omid.library.adcolony.walking.p030a.C2066d;
import com.iab.omid.library.adcolony.walking.p030a.C2067e;
import com.iab.omid.library.adcolony.walking.p030a.C2068f;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.walking.b */
public class C2069b implements C2064b {

    /* renamed from: a */
    private JSONObject f4093a;

    /* renamed from: b */
    private final C2065c f4094b;

    public C2069b(C2065c cVar) {
        this.f4094b = cVar;
    }

    /* renamed from: a */
    public void mo27486a() {
        this.f4094b.mo27479b(new C2066d(this));
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo27477a(JSONObject jSONObject) {
        this.f4093a = jSONObject;
    }

    /* renamed from: a */
    public void mo27487a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        C2065c cVar = this.f4094b;
        C2068f fVar = new C2068f(this, hashSet, jSONObject, j);
        cVar.mo27479b(fVar);
    }

    @VisibleForTesting
    /* renamed from: b */
    public JSONObject mo27478b() {
        return this.f4093a;
    }

    /* renamed from: b */
    public void mo27488b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        C2065c cVar = this.f4094b;
        C2067e eVar = new C2067e(this, hashSet, jSONObject, j);
        cVar.mo27479b(eVar);
    }
}
