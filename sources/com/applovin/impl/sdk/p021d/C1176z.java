package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.network.C1211a.C1214c;
import com.applovin.impl.sdk.p017a.C1075c;
import com.applovin.impl.sdk.utils.C1247h;
import com.facebook.internal.NativeProtocol;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.z */
public abstract class C1176z extends C1125ab {
    protected C1176z(String str, C1192i iVar) {
        super(str, iVar);
    }

    /* renamed from: a */
    private JSONObject m2515a(C1075c cVar) {
        JSONObject i = mo10080i();
        C1247h.m2979a(i, "result", cVar.mo9771b(), this.f2745b);
        Map a = cVar.mo9770a();
        if (a != null) {
            C1247h.m2981a(i, NativeProtocol.WEB_DIALOG_PARAMS, new JSONObject(a), this.f2745b);
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo9521a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo9524b(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract C1075c mo9525c();

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract void mo9526d();

    public void run() {
        C1075c c = mo9525c();
        if (c != null) {
            mo10079a(m2515a(c), new C1214c<JSONObject>() {
                /* renamed from: a */
                public void mo9301a(int i) {
                    C1176z.this.mo9521a(i);
                }

                /* renamed from: a */
                public void mo9302a(JSONObject jSONObject, int i) {
                    C1176z.this.mo9524b(jSONObject);
                }
            });
        } else {
            mo9526d();
        }
    }
}
