package com.applovin.impl.sdk.p021d;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.network.C1211a.C1214c;
import com.applovin.impl.sdk.p017a.C1075c;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.ae */
public abstract class C1129ae extends C1125ab {
    protected C1129ae(String str, C1192i iVar) {
        super(str, iVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2321b(JSONObject jSONObject) {
        if (!mo9529c()) {
            C1075c c = m2322c(jSONObject);
            if (c != null) {
                mo9528a(c);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r3 = java.util.Collections.emptyMap();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001b */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.applovin.impl.sdk.p017a.C1075c m2322c(org.json.JSONObject r3) {
        /*
            r2 = this;
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.C1246g.m2942a(r3)     // Catch:{ JSONException -> 0x002d }
            com.applovin.impl.sdk.i r1 = r2.f2745b     // Catch:{ JSONException -> 0x002d }
            com.applovin.impl.sdk.utils.C1246g.m2952d(r0, r1)     // Catch:{ JSONException -> 0x002d }
            com.applovin.impl.sdk.i r1 = r2.f2745b     // Catch:{ JSONException -> 0x002d }
            com.applovin.impl.sdk.utils.C1246g.m2951c(r3, r1)     // Catch:{ JSONException -> 0x002d }
            java.lang.String r3 = "params"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ Throwable -> 0x001b }
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ Throwable -> 0x001b }
            java.util.Map r3 = com.applovin.impl.sdk.utils.C1247h.m2973a(r3)     // Catch:{ Throwable -> 0x001b }
            goto L_0x001f
        L_0x001b:
            java.util.Map r3 = java.util.Collections.emptyMap()     // Catch:{ JSONException -> 0x002d }
        L_0x001f:
            java.lang.String r1 = "result"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Throwable -> 0x0026 }
            goto L_0x0028
        L_0x0026:
            java.lang.String r0 = "network_timeout"
        L_0x0028:
            com.applovin.impl.sdk.a.c r3 = com.applovin.impl.sdk.p017a.C1075c.m1949a(r0, r3)     // Catch:{ JSONException -> 0x002d }
            return r3
        L_0x002d:
            r3 = move-exception
            java.lang.String r0 = "Unable to parse API response"
            r2.mo10069a(r0, r3)
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p021d.C1129ae.m2322c(org.json.JSONObject):com.applovin.impl.sdk.a.c");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo9527a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo9528a(C1075c cVar);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract boolean mo9529c();

    public void run() {
        mo10079a(mo10080i(), new C1214c<JSONObject>() {
            /* renamed from: a */
            public void mo9301a(int i) {
                C1129ae.this.mo9527a(i);
            }

            /* renamed from: a */
            public void mo9302a(JSONObject jSONObject, int i) {
                C1129ae.this.m2321b(jSONObject);
            }
        });
    }
}
