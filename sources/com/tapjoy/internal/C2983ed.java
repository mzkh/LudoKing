package com.tapjoy.internal;

import androidx.annotation.VisibleForTesting;
import com.tapjoy.internal.C2975dy.C2977b;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.ed */
public final class C2983ed implements C2977b {

    /* renamed from: a */
    final C2978dz f6880a;

    /* renamed from: b */
    private JSONObject f6881b;

    public C2983ed(C2978dz dzVar) {
        this.f6880a = dzVar;
    }

    @VisibleForTesting
    /* renamed from: a */
    public final JSONObject mo29971a() {
        return this.f6881b;
    }

    @VisibleForTesting
    /* renamed from: a */
    public final void mo29972a(JSONObject jSONObject) {
        this.f6881b = jSONObject;
    }

    /* renamed from: b */
    public final void mo29977b() {
        this.f6880a.mo29973a(new C2980ea(this));
    }
}
