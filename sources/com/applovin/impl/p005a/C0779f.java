package com.applovin.impl.p005a;

import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1283q;

/* renamed from: com.applovin.impl.a.f */
public class C0779f {

    /* renamed from: a */
    private String f1285a;

    /* renamed from: b */
    private String f1286b;

    private C0779f() {
    }

    /* renamed from: a */
    public static C0779f m1066a(C1283q qVar, C0779f fVar, C1192i iVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (iVar != null) {
            if (fVar == null) {
                try {
                    fVar = new C0779f();
                } catch (Throwable th) {
                    iVar.mo10249v().mo10379b("VastSystemInfo", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (!C1277l.m3042b(fVar.f1285a)) {
                String c = qVar.mo10452c();
                if (C1277l.m3042b(c)) {
                    fVar.f1285a = c;
                }
            }
            if (!C1277l.m3042b(fVar.f1286b)) {
                String str = (String) qVar.mo10450b().get("version");
                if (C1277l.m3042b(str)) {
                    fVar.f1286b = str;
                }
            }
            return fVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0779f)) {
            return false;
        }
        C0779f fVar = (C0779f) obj;
        String str = this.f1285a;
        if (str == null ? fVar.f1285a != null : !str.equals(fVar.f1285a)) {
            return false;
        }
        String str2 = this.f1286b;
        if (str2 != null) {
            z = str2.equals(fVar.f1286b);
        } else if (fVar.f1286b != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        String str = this.f1285a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f1286b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VastSystemInfo{name='");
        sb.append(this.f1285a);
        sb.append('\'');
        sb.append(", version='");
        sb.append(this.f1286b);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
