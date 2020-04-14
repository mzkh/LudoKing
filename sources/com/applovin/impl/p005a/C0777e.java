package com.applovin.impl.p005a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1283q;

/* renamed from: com.applovin.impl.a.e */
public class C0777e {

    /* renamed from: a */
    private C0778a f1277a;

    /* renamed from: b */
    private Uri f1278b;

    /* renamed from: c */
    private String f1279c;

    /* renamed from: com.applovin.impl.a.e$a */
    public enum C0778a {
        UNSPECIFIED,
        STATIC,
        IFRAME,
        HTML
    }

    private C0777e() {
    }

    /* renamed from: a */
    static C0777e m1059a(C1283q qVar, C0777e eVar, C1192i iVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (iVar != null) {
            if (eVar == null) {
                try {
                    eVar = new C0777e();
                } catch (Throwable th) {
                    iVar.mo10249v().mo10379b("VastNonVideoResource", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (eVar.f1278b == null && !C1277l.m3042b(eVar.f1279c)) {
                String a = m1060a(qVar, "StaticResource");
                if (URLUtil.isValidUrl(a)) {
                    eVar.f1278b = Uri.parse(a);
                    eVar.f1277a = C0778a.STATIC;
                    return eVar;
                }
                String a2 = m1060a(qVar, "IFrameResource");
                if (C1277l.m3042b(a2)) {
                    eVar.f1277a = C0778a.IFRAME;
                    if (URLUtil.isValidUrl(a2)) {
                        eVar.f1278b = Uri.parse(a2);
                    } else {
                        eVar.f1279c = a2;
                    }
                    return eVar;
                }
                String a3 = m1060a(qVar, "HTMLResource");
                if (C1277l.m3042b(a3)) {
                    eVar.f1277a = C0778a.HTML;
                    if (URLUtil.isValidUrl(a3)) {
                        eVar.f1278b = Uri.parse(a3);
                    } else {
                        eVar.f1279c = a3;
                    }
                }
            }
            return eVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    private static String m1060a(C1283q qVar, String str) {
        C1283q b = qVar.mo10449b(str);
        if (b != null) {
            return b.mo10452c();
        }
        return null;
    }

    /* renamed from: a */
    public C0778a mo8930a() {
        return this.f1277a;
    }

    /* renamed from: a */
    public void mo8931a(Uri uri) {
        this.f1278b = uri;
    }

    /* renamed from: a */
    public void mo8932a(String str) {
        this.f1279c = str;
    }

    /* renamed from: b */
    public Uri mo8933b() {
        return this.f1278b;
    }

    /* renamed from: c */
    public String mo8934c() {
        return this.f1279c;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0777e)) {
            return false;
        }
        C0777e eVar = (C0777e) obj;
        if (this.f1277a != eVar.f1277a) {
            return false;
        }
        Uri uri = this.f1278b;
        if (uri == null ? eVar.f1278b != null : !uri.equals(eVar.f1278b)) {
            return false;
        }
        String str = this.f1279c;
        if (str != null) {
            z = str.equals(eVar.f1279c);
        } else if (eVar.f1279c != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        C0778a aVar = this.f1277a;
        int i = 0;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Uri uri = this.f1278b;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.f1279c;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VastNonVideoResource{type=");
        sb.append(this.f1277a);
        sb.append(", resourceUri=");
        sb.append(this.f1278b);
        sb.append(", resourceContents='");
        sb.append(this.f1279c);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
