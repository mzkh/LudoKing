package com.tapjoy.internal;

import com.tapjoy.internal.C2988eh.C2989a;

/* renamed from: com.tapjoy.internal.ez */
public final class C3037ez extends C2988eh {

    /* renamed from: c */
    public static final C2991ej f7047c = new C3039b();

    /* renamed from: d */
    public static final Long f7048d = Long.valueOf(0);

    /* renamed from: e */
    public final String f7049e;

    /* renamed from: f */
    public final Long f7050f;

    /* renamed from: com.tapjoy.internal.ez$a */
    public static final class C3038a extends C2989a {

        /* renamed from: c */
        public String f7051c;

        /* renamed from: d */
        public Long f7052d;

        /* renamed from: b */
        public final C3037ez mo30094b() {
            String str = this.f7051c;
            if (str != null) {
                Long l = this.f7052d;
                if (l != null) {
                    return new C3037ez(str, l, super.mo29987a());
                }
            }
            throw C3011eo.m6885a(this.f7051c, "name", this.f7052d, "value");
        }
    }

    /* renamed from: com.tapjoy.internal.ez$b */
    static final class C3039b extends C2991ej {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            C3037ez ezVar = (C3037ez) obj;
            return C2991ej.f6912p.mo29988a(1, (Object) ezVar.f7049e) + C2991ej.f6905i.mo29988a(2, (Object) ezVar.f7050f) + ezVar.mo29983a().mo30308c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            C3037ez ezVar = (C3037ez) obj;
            C2991ej.f6912p.mo29992a(elVar, 1, ezVar.f7049e);
            C2991ej.f6905i.mo29992a(elVar, 2, ezVar.f7050f);
            elVar.mo30004a(ezVar.mo29983a());
        }

        C3039b() {
            super(C2986eg.LENGTH_DELIMITED, C3037ez.class);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            C3038a aVar = new C3038a();
            long a = ekVar.mo29995a();
            while (true) {
                int b = ekVar.mo29997b();
                if (b == -1) {
                    ekVar.mo29996a(a);
                    return aVar.mo30094b();
                } else if (b == 1) {
                    aVar.f7051c = (String) C2991ej.f6912p.mo29980a(ekVar);
                } else if (b != 2) {
                    C2986eg c = ekVar.mo29998c();
                    aVar.mo29985a(b, c, c.mo29982a().mo29980a(ekVar));
                } else {
                    aVar.f7052d = (Long) C2991ej.f6905i.mo29980a(ekVar);
                }
            }
        }
    }

    public C3037ez(String str, Long l) {
        this(str, l, C3197iu.f7628b);
    }

    public C3037ez(String str, Long l, C3197iu iuVar) {
        super(f7047c, iuVar);
        this.f7049e = str;
        this.f7050f = l;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3037ez)) {
            return false;
        }
        C3037ez ezVar = (C3037ez) obj;
        return mo29983a().equals(ezVar.mo29983a()) && this.f7049e.equals(ezVar.f7049e) && this.f7050f.equals(ezVar.f7050f);
    }

    public final int hashCode() {
        int i = this.f6894b;
        if (i != 0) {
            return i;
        }
        int hashCode = (((mo29983a().hashCode() * 37) + this.f7049e.hashCode()) * 37) + this.f7050f.hashCode();
        this.f6894b = hashCode;
        return hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", name=");
        sb.append(this.f7049e);
        sb.append(", value=");
        sb.append(this.f7050f);
        StringBuilder replace = sb.replace(0, 2, "EventValue{");
        replace.append('}');
        return replace.toString();
    }
}
