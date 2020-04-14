package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.network.C1211a.C1214c;
import com.applovin.impl.sdk.network.C1215b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1277l;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.ab */
public abstract class C1125ab extends C1122a {
    protected C1125ab(String str, C1192i iVar) {
        super(str, iVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo9522a(JSONObject jSONObject);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo10079a(JSONObject jSONObject, final C1214c<JSONObject> cVar) {
        C11261 r0 = new C1173x<JSONObject>(C1215b.m2733a(this.f2745b).mo10324a(C1246g.m2940a(mo9523b(), this.f2745b)).mo10333c(C1246g.m2950b(mo9523b(), this.f2745b)).mo10325a(C1246g.m2953e(this.f2745b)).mo10330b("POST").mo10326a(jSONObject).mo10323a(new JSONObject()).mo10322a(((Integer) this.f2745b.mo10202a(C1096c.f2352bN)).intValue()).mo10328a(), this.f2745b) {
            /* renamed from: a */
            public void mo9301a(int i) {
                cVar.mo9301a(i);
            }

            /* renamed from: a */
            public void mo9302a(JSONObject jSONObject, int i) {
                cVar.mo9302a(jSONObject, i);
            }
        };
        r0.mo10153a(C1096c.f2296aK);
        r0.mo10155b(C1096c.f2297aL);
        this.f2745b.mo10185K().mo10130a((C1122a) r0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract String mo9523b();

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public JSONObject mo10080i() {
        JSONObject jSONObject = new JSONObject();
        String i = this.f2745b.mo10235i();
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2463dU)).booleanValue() && C1277l.m3042b(i)) {
            C1247h.m2979a(jSONObject, "cuid", i, this.f2745b);
        }
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2465dW)).booleanValue()) {
            C1247h.m2979a(jSONObject, "compass_random_token", this.f2745b.mo10236j(), this.f2745b);
        }
        if (((Boolean) this.f2745b.mo10202a(C1096c.f2467dY)).booleanValue()) {
            C1247h.m2979a(jSONObject, "applovin_random_token", this.f2745b.mo10237k(), this.f2745b);
        }
        mo9522a(jSONObject);
        return jSONObject;
    }
}
