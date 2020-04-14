package com.applovin.impl.p005a;

import android.net.Uri;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1283q;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.a.b */
public class C0774b {

    /* renamed from: a */
    private int f1249a;

    /* renamed from: b */
    private int f1250b;

    /* renamed from: c */
    private Uri f1251c;

    /* renamed from: d */
    private C0777e f1252d;

    /* renamed from: e */
    private Set<C0780g> f1253e = new HashSet();

    /* renamed from: f */
    private Map<String, Set<C0780g>> f1254f = new HashMap();

    private C0774b() {
    }

    /* renamed from: a */
    public static C0774b m1044a(C1283q qVar, C0774b bVar, C0775c cVar, C1192i iVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (iVar != null) {
            if (bVar == null) {
                try {
                    bVar = new C0774b();
                } catch (Throwable th) {
                    iVar.mo10249v().mo10379b("VastCompanionAd", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (bVar.f1249a == 0 && bVar.f1250b == 0) {
                int a = C1277l.m3031a((String) qVar.mo10450b().get("width"));
                int a2 = C1277l.m3031a((String) qVar.mo10450b().get("height"));
                if (a > 0 && a2 > 0) {
                    bVar.f1249a = a;
                    bVar.f1250b = a2;
                }
            }
            bVar.f1252d = C0777e.m1059a(qVar, bVar.f1252d, iVar);
            if (bVar.f1251c == null) {
                C1283q b = qVar.mo10449b("CompanionClickThrough");
                if (b != null) {
                    String c = b.mo10452c();
                    if (C1277l.m3042b(c)) {
                        bVar.f1251c = Uri.parse(c);
                    }
                }
            }
            C0782i.m1082a(qVar.mo10448a("CompanionClickTracking"), bVar.f1253e, cVar, iVar);
            C0782i.m1081a(qVar, bVar.f1254f, cVar, iVar);
            return bVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public Uri mo8913a() {
        return this.f1251c;
    }

    /* renamed from: b */
    public C0777e mo8914b() {
        return this.f1252d;
    }

    /* renamed from: c */
    public Set<C0780g> mo8915c() {
        return this.f1253e;
    }

    /* renamed from: d */
    public Map<String, Set<C0780g>> mo8916d() {
        return this.f1254f;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0774b)) {
            return false;
        }
        C0774b bVar = (C0774b) obj;
        if (this.f1249a != bVar.f1249a || this.f1250b != bVar.f1250b) {
            return false;
        }
        Uri uri = this.f1251c;
        if (uri == null ? bVar.f1251c != null : !uri.equals(bVar.f1251c)) {
            return false;
        }
        C0777e eVar = this.f1252d;
        if (eVar == null ? bVar.f1252d != null : !eVar.equals(bVar.f1252d)) {
            return false;
        }
        Set<C0780g> set = this.f1253e;
        if (set == null ? bVar.f1253e != null : !set.equals(bVar.f1253e)) {
            return false;
        }
        Map<String, Set<C0780g>> map = this.f1254f;
        if (map != null) {
            z = map.equals(bVar.f1254f);
        } else if (bVar.f1254f != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = ((this.f1249a * 31) + this.f1250b) * 31;
        Uri uri = this.f1251c;
        int i2 = 0;
        int hashCode = (i + (uri != null ? uri.hashCode() : 0)) * 31;
        C0777e eVar = this.f1252d;
        int hashCode2 = (hashCode + (eVar != null ? eVar.hashCode() : 0)) * 31;
        Set<C0780g> set = this.f1253e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<C0780g>> map = this.f1254f;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VastCompanionAd{width=");
        sb.append(this.f1249a);
        sb.append(", height=");
        sb.append(this.f1250b);
        sb.append(", destinationUri=");
        sb.append(this.f1251c);
        sb.append(", nonVideoResource=");
        sb.append(this.f1252d);
        sb.append(", clickTrackers=");
        sb.append(this.f1253e);
        sb.append(", eventTrackers=");
        sb.append(this.f1254f);
        sb.append('}');
        return sb.toString();
    }
}
