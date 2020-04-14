package com.tapjoy.internal;

import com.tapjoy.internal.C2988eh.C2989a;
import com.tapjoy.internal.C2991ej.C3006a;

/* renamed from: com.tapjoy.internal.ex */
public final class C3032ex extends C2988eh {

    /* renamed from: c */
    public static final C2991ej f7037c = new C3034b();

    /* renamed from: d */
    public static final C3035ey f7038d = C3035ey.APP;

    /* renamed from: e */
    public final C3035ey f7039e;

    /* renamed from: f */
    public final String f7040f;

    /* renamed from: g */
    public final String f7041g;

    /* renamed from: com.tapjoy.internal.ex$a */
    public static final class C3033a extends C2989a {

        /* renamed from: c */
        public C3035ey f7042c;

        /* renamed from: d */
        public String f7043d;

        /* renamed from: e */
        public String f7044e;

        /* renamed from: b */
        public final C3032ex mo30091b() {
            C3035ey eyVar = this.f7042c;
            if (eyVar != null) {
                String str = this.f7043d;
                if (str != null) {
                    return new C3032ex(eyVar, str, this.f7044e, super.mo29987a());
                }
            }
            throw C3011eo.m6885a(this.f7042c, "type", this.f7043d, "name");
        }
    }

    /* renamed from: com.tapjoy.internal.ex$b */
    static final class C3034b extends C2991ej {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            C3032ex exVar = (C3032ex) obj;
            return C3035ey.ADAPTER.mo29988a(1, (Object) exVar.f7039e) + C2991ej.f6912p.mo29988a(2, (Object) exVar.f7040f) + (exVar.f7041g != null ? C2991ej.f6912p.mo29988a(3, (Object) exVar.f7041g) : 0) + exVar.mo29983a().mo30308c();
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            return m7040b(ekVar);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            C3032ex exVar = (C3032ex) obj;
            C3035ey.ADAPTER.mo29992a(elVar, 1, exVar.f7039e);
            C2991ej.f6912p.mo29992a(elVar, 2, exVar.f7040f);
            if (exVar.f7041g != null) {
                C2991ej.f6912p.mo29992a(elVar, 3, exVar.f7041g);
            }
            elVar.mo30004a(exVar.mo29983a());
        }

        C3034b() {
            super(C2986eg.LENGTH_DELIMITED, C3032ex.class);
        }

        /* renamed from: b */
        private static C3032ex m7040b(C3007ek ekVar) {
            C3033a aVar = new C3033a();
            long a = ekVar.mo29995a();
            while (true) {
                int b = ekVar.mo29997b();
                if (b == -1) {
                    ekVar.mo29996a(a);
                    return aVar.mo30091b();
                } else if (b == 1) {
                    try {
                        aVar.f7042c = (C3035ey) C3035ey.ADAPTER.mo29980a(ekVar);
                    } catch (C3006a e) {
                        aVar.mo29985a(b, C2986eg.VARINT, Long.valueOf((long) e.f6918a));
                    }
                } else if (b == 2) {
                    aVar.f7043d = (String) C2991ej.f6912p.mo29980a(ekVar);
                } else if (b != 3) {
                    C2986eg c = ekVar.mo29998c();
                    aVar.mo29985a(b, c, c.mo29982a().mo29980a(ekVar));
                } else {
                    aVar.f7044e = (String) C2991ej.f6912p.mo29980a(ekVar);
                }
            }
        }
    }

    public C3032ex(C3035ey eyVar, String str, String str2, C3197iu iuVar) {
        super(f7037c, iuVar);
        this.f7039e = eyVar;
        this.f7040f = str;
        this.f7041g = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3032ex)) {
            return false;
        }
        C3032ex exVar = (C3032ex) obj;
        return mo29983a().equals(exVar.mo29983a()) && this.f7039e.equals(exVar.f7039e) && this.f7040f.equals(exVar.f7040f) && C3011eo.m6888a((Object) this.f7041g, (Object) exVar.f7041g);
    }

    public final int hashCode() {
        int i = this.f6894b;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((mo29983a().hashCode() * 37) + this.f7039e.hashCode()) * 37) + this.f7040f.hashCode()) * 37;
        String str = this.f7041g;
        int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
        this.f6894b = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", type=");
        sb.append(this.f7039e);
        sb.append(", name=");
        sb.append(this.f7040f);
        if (this.f7041g != null) {
            sb.append(", category=");
            sb.append(this.f7041g);
        }
        StringBuilder replace = sb.replace(0, 2, "EventGroup{");
        replace.append('}');
        return replace.toString();
    }
}
