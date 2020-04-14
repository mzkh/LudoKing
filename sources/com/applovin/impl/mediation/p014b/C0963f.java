package com.applovin.impl.mediation.p014b;

import com.applovin.impl.mediation.C0999i;

/* renamed from: com.applovin.impl.mediation.b.f */
public class C0963f {

    /* renamed from: a */
    private final C0965g f1846a;

    /* renamed from: b */
    private final String f1847b;

    /* renamed from: c */
    private final String f1848c;

    /* renamed from: d */
    private final String f1849d;

    /* renamed from: e */
    private final String f1850e;

    /* renamed from: com.applovin.impl.mediation.b.f$a */
    public interface C0964a {
        /* renamed from: a */
        void mo9502a(C0963f fVar);
    }

    private C0963f(C0965g gVar, C0999i iVar, String str, String str2) {
        this.f1846a = gVar;
        this.f1850e = str2;
        if (str != null) {
            this.f1849d = str.substring(0, Math.min(str.length(), gVar.mo9426a()));
        } else {
            this.f1849d = null;
        }
        if (iVar != null) {
            this.f1847b = iVar.mo9559e();
            this.f1848c = iVar.mo9560f();
            return;
        }
        this.f1847b = null;
        this.f1848c = null;
    }

    /* renamed from: a */
    public static C0963f m1662a(C0965g gVar, C0999i iVar, String str) {
        if (gVar == null) {
            throw new IllegalArgumentException("No spec specified");
        } else if (iVar != null) {
            return new C0963f(gVar, iVar, str, null);
        } else {
            throw new IllegalArgumentException("No adapterWrapper specified");
        }
    }

    /* renamed from: a */
    public static C0963f m1663a(C0965g gVar, String str) {
        return m1664b(gVar, null, str);
    }

    /* renamed from: b */
    public static C0963f m1664b(C0965g gVar, C0999i iVar, String str) {
        if (gVar != null) {
            return new C0963f(gVar, iVar, null, str);
        }
        throw new IllegalArgumentException("No spec specified");
    }

    /* renamed from: a */
    public C0965g mo9496a() {
        return this.f1846a;
    }

    /* renamed from: b */
    public String mo9497b() {
        return this.f1847b;
    }

    /* renamed from: c */
    public String mo9498c() {
        return this.f1848c;
    }

    /* renamed from: d */
    public String mo9499d() {
        return this.f1849d;
    }

    /* renamed from: e */
    public String mo9500e() {
        return this.f1850e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SignalCollectionResult{mSignalProviderSpec=");
        sb.append(this.f1846a);
        sb.append(", mSdkVersion='");
        sb.append(this.f1847b);
        sb.append('\'');
        sb.append(", mAdapterVersion='");
        sb.append(this.f1848c);
        sb.append('\'');
        sb.append(", mSignalDataLength='");
        String str = this.f1849d;
        sb.append(str != null ? str.length() : 0);
        sb.append('\'');
        sb.append(", mErrorMessage=");
        sb.append(this.f1850e);
        sb.append('}');
        return sb.toString();
    }
}
