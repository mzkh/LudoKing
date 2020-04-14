package com.tapjoy.internal;

import com.tapjoy.internal.C2988eh.C2989a;

/* renamed from: com.tapjoy.internal.fe */
public final class C3053fe extends C2988eh {

    /* renamed from: c */
    public static final C2991ej f7147c = new C3055b();

    /* renamed from: d */
    public static final Long f7148d;

    /* renamed from: e */
    public static final Long f7149e;

    /* renamed from: f */
    public final String f7150f;

    /* renamed from: g */
    public final Long f7151g;

    /* renamed from: h */
    public final Long f7152h;

    /* renamed from: com.tapjoy.internal.fe$a */
    public static final class C3054a extends C2989a {

        /* renamed from: c */
        public String f7153c;

        /* renamed from: d */
        public Long f7154d;

        /* renamed from: e */
        public Long f7155e;

        /* renamed from: b */
        public final C3053fe mo30110b() {
            String str = this.f7153c;
            if (str != null) {
                Long l = this.f7154d;
                if (l != null) {
                    return new C3053fe(str, l, this.f7155e, super.mo29987a());
                }
            }
            throw C3011eo.m6885a(this.f7153c, "id", this.f7154d, "received");
        }
    }

    /* renamed from: com.tapjoy.internal.fe$b */
    static final class C3055b extends C2991ej {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            C3053fe feVar = (C3053fe) obj;
            return C2991ej.f6912p.mo29988a(1, (Object) feVar.f7150f) + C2991ej.f6905i.mo29988a(2, (Object) feVar.f7151g) + (feVar.f7152h != null ? C2991ej.f6905i.mo29988a(3, (Object) feVar.f7152h) : 0) + feVar.mo29983a().mo30308c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            C3053fe feVar = (C3053fe) obj;
            C2991ej.f6912p.mo29992a(elVar, 1, feVar.f7150f);
            C2991ej.f6905i.mo29992a(elVar, 2, feVar.f7151g);
            if (feVar.f7152h != null) {
                C2991ej.f6905i.mo29992a(elVar, 3, feVar.f7152h);
            }
            elVar.mo30004a(feVar.mo29983a());
        }

        C3055b() {
            super(C2986eg.LENGTH_DELIMITED, C3053fe.class);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            C3054a aVar = new C3054a();
            long a = ekVar.mo29995a();
            while (true) {
                int b = ekVar.mo29997b();
                if (b == -1) {
                    ekVar.mo29996a(a);
                    return aVar.mo30110b();
                } else if (b == 1) {
                    aVar.f7153c = (String) C2991ej.f6912p.mo29980a(ekVar);
                } else if (b == 2) {
                    aVar.f7154d = (Long) C2991ej.f6905i.mo29980a(ekVar);
                } else if (b != 3) {
                    C2986eg c = ekVar.mo29998c();
                    aVar.mo29985a(b, c, c.mo29982a().mo29980a(ekVar));
                } else {
                    aVar.f7155e = (Long) C2991ej.f6905i.mo29980a(ekVar);
                }
            }
        }
    }

    static {
        Long valueOf = Long.valueOf(0);
        f7148d = valueOf;
        f7149e = valueOf;
    }

    public C3053fe(String str, Long l) {
        this(str, l, null, C3197iu.f7628b);
    }

    public C3053fe(String str, Long l, Long l2, C3197iu iuVar) {
        super(f7147c, iuVar);
        this.f7150f = str;
        this.f7151g = l;
        this.f7152h = l2;
    }

    /* renamed from: b */
    public final C3054a mo30107b() {
        C3054a aVar = new C3054a();
        aVar.f7153c = this.f7150f;
        aVar.f7154d = this.f7151g;
        aVar.f7155e = this.f7152h;
        aVar.mo29986a(mo29983a());
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3053fe)) {
            return false;
        }
        C3053fe feVar = (C3053fe) obj;
        return mo29983a().equals(feVar.mo29983a()) && this.f7150f.equals(feVar.f7150f) && this.f7151g.equals(feVar.f7151g) && C3011eo.m6888a((Object) this.f7152h, (Object) feVar.f7152h);
    }

    public final int hashCode() {
        int i = this.f6894b;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((mo29983a().hashCode() * 37) + this.f7150f.hashCode()) * 37) + this.f7151g.hashCode()) * 37;
        Long l = this.f7152h;
        int hashCode2 = hashCode + (l != null ? l.hashCode() : 0);
        this.f6894b = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", id=");
        sb.append(this.f7150f);
        sb.append(", received=");
        sb.append(this.f7151g);
        if (this.f7152h != null) {
            sb.append(", clicked=");
            sb.append(this.f7152h);
        }
        StringBuilder replace = sb.replace(0, 2, "Push{");
        replace.append('}');
        return replace.toString();
    }
}
