package com.applovin.impl.p005a;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.utils.C1243d;
import com.applovin.impl.sdk.utils.C1245f;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1283q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.j */
public class C0783j {

    /* renamed from: a */
    private List<C0786k> f1295a = Collections.EMPTY_LIST;

    /* renamed from: b */
    private List<String> f1296b = Collections.EMPTY_LIST;

    /* renamed from: c */
    private int f1297c;

    /* renamed from: d */
    private Uri f1298d;

    /* renamed from: e */
    private final Set<C0780g> f1299e = new HashSet();

    /* renamed from: f */
    private final Map<String, Set<C0780g>> f1300f = new HashMap();

    /* renamed from: com.applovin.impl.a.j$a */
    public enum C0785a {
        UNSPECIFIED,
        LOW,
        MEDIUM,
        HIGH
    }

    private C0783j() {
    }

    private C0783j(C0775c cVar) {
        this.f1296b = cVar.mo8927h();
    }

    /* renamed from: a */
    private static int m1091a(String str, C1192i iVar) {
        try {
            List a = C1243d.m2925a(str, ":");
            if (a.size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds((long) C1277l.m3031a((String) a.get(0))) + TimeUnit.MINUTES.toSeconds((long) C1277l.m3031a((String) a.get(1))) + ((long) C1277l.m3031a((String) a.get(2))));
            }
        } catch (Throwable unused) {
            C1227o v = iVar.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to parse duration from \"");
            sb.append(str);
            sb.append("\"");
            v.mo10382e("VastVideoCreative", sb.toString());
        }
        return 0;
    }

    /* renamed from: a */
    public static C0783j m1092a(C1283q qVar, C0783j jVar, C0775c cVar, C1192i iVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (cVar == null) {
            throw new IllegalArgumentException("No context specified.");
        } else if (iVar != null) {
            if (jVar == null) {
                try {
                    jVar = new C0783j(cVar);
                } catch (Throwable th) {
                    iVar.mo10249v().mo10379b("VastVideoCreative", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (jVar.f1297c == 0) {
                C1283q b = qVar.mo10449b("Duration");
                if (b != null) {
                    int a = m1091a(b.mo10452c(), iVar);
                    if (a > 0) {
                        jVar.f1297c = a;
                    }
                }
            }
            C1283q b2 = qVar.mo10449b("MediaFiles");
            if (b2 != null) {
                List<C0786k> a2 = m1093a(b2, iVar);
                if (a2 != null && a2.size() > 0) {
                    if (jVar.f1295a != null) {
                        a2.addAll(jVar.f1295a);
                    }
                    jVar.f1295a = a2;
                }
            }
            C1283q b3 = qVar.mo10449b("VideoClicks");
            if (b3 != null) {
                if (jVar.f1298d == null) {
                    C1283q b4 = b3.mo10449b("ClickThrough");
                    if (b4 != null) {
                        String c = b4.mo10452c();
                        if (C1277l.m3042b(c)) {
                            jVar.f1298d = Uri.parse(c);
                        }
                    }
                }
                C0782i.m1082a(b3.mo10448a("ClickTracking"), jVar.f1299e, cVar, iVar);
            }
            C0782i.m1081a(qVar, jVar.f1300f, cVar, iVar);
            return jVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    private static List<C0786k> m1093a(C1283q qVar, C1192i iVar) {
        String str = "VastVideoCreative";
        List<C1283q> a = qVar.mo10448a("MediaFile");
        ArrayList arrayList = new ArrayList(a.size());
        List a2 = C1243d.m2924a((String) iVar.mo10202a(C1096c.f2502eH));
        List a3 = C1243d.m2924a((String) iVar.mo10202a(C1096c.f2501eG));
        for (C1283q a4 : a) {
            C0786k a5 = C0786k.m1102a(a4, iVar);
            if (a5 != null) {
                try {
                    String d = a5.mo8962d();
                    if (!C1277l.m3042b(d) || a2.contains(d)) {
                        if (((Boolean) iVar.mo10202a(C1096c.f2503eI)).booleanValue()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(a5.mo8960b().toString());
                            if (C1277l.m3042b(fileExtensionFromUrl) && !a3.contains(fileExtensionFromUrl)) {
                            }
                        }
                        C1227o v = iVar.mo10249v();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Video file not supported: ");
                        sb.append(a5);
                        v.mo10381d(str, sb.toString());
                    }
                    arrayList.add(a5);
                } catch (Throwable th) {
                    C1227o v2 = iVar.mo10249v();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to validate vidoe file: ");
                    sb2.append(a5);
                    v2.mo10379b(str, sb2.toString(), th);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public C0786k mo8947a(C0785a aVar) {
        List<C0786k> list = this.f1295a;
        if (list == null || list.size() == 0) {
            return null;
        }
        List arrayList = new ArrayList(3);
        for (String str : this.f1296b) {
            for (C0786k kVar : this.f1295a) {
                String d = kVar.mo8962d();
                if (C1277l.m3042b(d) && str.equalsIgnoreCase(d)) {
                    arrayList.add(kVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.f1295a;
        }
        if (C1245f.m2934e()) {
            Collections.sort(arrayList, new Comparator<C0786k>() {
                @TargetApi(19)
                /* renamed from: a */
                public int compare(C0786k kVar, C0786k kVar2) {
                    return Integer.compare(kVar.mo8963e(), kVar2.mo8963e());
                }
            });
        }
        int size = aVar == C0785a.LOW ? 0 : aVar == C0785a.MEDIUM ? arrayList.size() / 2 : arrayList.size() - 1;
        return (C0786k) arrayList.get(size);
    }

    /* renamed from: a */
    public List<C0786k> mo8948a() {
        return this.f1295a;
    }

    /* renamed from: b */
    public int mo8949b() {
        return this.f1297c;
    }

    /* renamed from: c */
    public Uri mo8950c() {
        return this.f1298d;
    }

    /* renamed from: d */
    public Set<C0780g> mo8951d() {
        return this.f1299e;
    }

    /* renamed from: e */
    public Map<String, Set<C0780g>> mo8952e() {
        return this.f1300f;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0783j)) {
            return false;
        }
        C0783j jVar = (C0783j) obj;
        if (this.f1297c != jVar.f1297c) {
            return false;
        }
        List<C0786k> list = this.f1295a;
        if (list == null ? jVar.f1295a != null : !list.equals(jVar.f1295a)) {
            return false;
        }
        Uri uri = this.f1298d;
        if (uri == null ? jVar.f1298d != null : !uri.equals(jVar.f1298d)) {
            return false;
        }
        Set<C0780g> set = this.f1299e;
        if (set == null ? jVar.f1299e != null : !set.equals(jVar.f1299e)) {
            return false;
        }
        Map<String, Set<C0780g>> map = this.f1300f;
        if (map != null) {
            z = map.equals(jVar.f1300f);
        } else if (jVar.f1300f != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        List<C0786k> list = this.f1295a;
        int i = 0;
        int hashCode = (((list != null ? list.hashCode() : 0) * 31) + this.f1297c) * 31;
        Uri uri = this.f1298d;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set<C0780g> set = this.f1299e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<C0780g>> map = this.f1300f;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VastVideoCreative{videoFiles=");
        sb.append(this.f1295a);
        sb.append(", durationSeconds=");
        sb.append(this.f1297c);
        sb.append(", destinationUri=");
        sb.append(this.f1298d);
        sb.append(", clickTrackers=");
        sb.append(this.f1299e);
        sb.append(", eventTrackers=");
        sb.append(this.f1300f);
        sb.append('}');
        return sb.toString();
    }
}
