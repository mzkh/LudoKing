package com.tapjoy.internal;

import com.tapjoy.internal.C2988eh.C2989a;

/* renamed from: com.tapjoy.internal.fc */
public final class C3047fc extends C2988eh {

    /* renamed from: c */
    public static final C2991ej f7107c = new C3049b();

    /* renamed from: d */
    public final String f7108d;

    /* renamed from: e */
    public final String f7109e;

    /* renamed from: f */
    public final String f7110f;

    /* renamed from: com.tapjoy.internal.fc$a */
    public static final class C3048a extends C2989a {

        /* renamed from: c */
        public String f7111c;

        /* renamed from: d */
        public String f7112d;

        /* renamed from: e */
        public String f7113e;

        /* renamed from: b */
        public final C3047fc mo30103b() {
            return new C3047fc(this.f7111c, this.f7112d, this.f7113e, super.mo29987a());
        }
    }

    /* renamed from: com.tapjoy.internal.fc$b */
    static final class C3049b extends C2991ej {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            C3047fc fcVar = (C3047fc) obj;
            int i = 0;
            int a = (fcVar.f7108d != null ? C2991ej.f6912p.mo29988a(1, (Object) fcVar.f7108d) : 0) + (fcVar.f7109e != null ? C2991ej.f6912p.mo29988a(2, (Object) fcVar.f7109e) : 0);
            if (fcVar.f7110f != null) {
                i = C2991ej.f6912p.mo29988a(3, (Object) fcVar.f7110f);
            }
            return a + i + fcVar.mo29983a().mo30308c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            C3047fc fcVar = (C3047fc) obj;
            if (fcVar.f7108d != null) {
                C2991ej.f6912p.mo29992a(elVar, 1, fcVar.f7108d);
            }
            if (fcVar.f7109e != null) {
                C2991ej.f6912p.mo29992a(elVar, 2, fcVar.f7109e);
            }
            if (fcVar.f7110f != null) {
                C2991ej.f6912p.mo29992a(elVar, 3, fcVar.f7110f);
            }
            elVar.mo30004a(fcVar.mo29983a());
        }

        C3049b() {
            super(C2986eg.LENGTH_DELIMITED, C3047fc.class);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            C3048a aVar = new C3048a();
            long a = ekVar.mo29995a();
            while (true) {
                int b = ekVar.mo29997b();
                if (b == -1) {
                    ekVar.mo29996a(a);
                    return aVar.mo30103b();
                } else if (b == 1) {
                    aVar.f7111c = (String) C2991ej.f6912p.mo29980a(ekVar);
                } else if (b == 2) {
                    aVar.f7112d = (String) C2991ej.f6912p.mo29980a(ekVar);
                } else if (b != 3) {
                    C2986eg c = ekVar.mo29998c();
                    aVar.mo29985a(b, c, c.mo29982a().mo29980a(ekVar));
                } else {
                    aVar.f7113e = (String) C2991ej.f6912p.mo29980a(ekVar);
                }
            }
        }
    }

    public C3047fc(String str, String str2, String str3) {
        this(str, str2, str3, C3197iu.f7628b);
    }

    public C3047fc(String str, String str2, String str3, C3197iu iuVar) {
        super(f7107c, iuVar);
        this.f7108d = str;
        this.f7109e = str2;
        this.f7110f = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3047fc)) {
            return false;
        }
        C3047fc fcVar = (C3047fc) obj;
        return mo29983a().equals(fcVar.mo29983a()) && C3011eo.m6888a((Object) this.f7108d, (Object) fcVar.f7108d) && C3011eo.m6888a((Object) this.f7109e, (Object) fcVar.f7109e) && C3011eo.m6888a((Object) this.f7110f, (Object) fcVar.f7110f);
    }

    public final int hashCode() {
        int i = this.f6894b;
        if (i != 0) {
            return i;
        }
        int hashCode = mo29983a().hashCode() * 37;
        String str = this.f7108d;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.f7109e;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.f7110f;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.f6894b = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f7108d != null) {
            sb.append(", fq7Change=");
            sb.append(this.f7108d);
        }
        if (this.f7109e != null) {
            sb.append(", fq30Change=");
            sb.append(this.f7109e);
        }
        if (this.f7110f != null) {
            sb.append(", pushId=");
            sb.append(this.f7110f);
        }
        StringBuilder replace = sb.replace(0, 2, "Meta{");
        replace.append('}');
        return replace.toString();
    }
}
