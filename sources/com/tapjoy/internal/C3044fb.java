package com.tapjoy.internal;

import com.tapjoy.internal.C2988eh.C2989a;

/* renamed from: com.tapjoy.internal.fb */
public final class C3044fb extends C2988eh {

    /* renamed from: c */
    public static final C2991ej f7100c = new C3046b();

    /* renamed from: d */
    public final C3041fa f7101d;

    /* renamed from: e */
    public final C3023eu f7102e;

    /* renamed from: f */
    public final C3062fh f7103f;

    /* renamed from: com.tapjoy.internal.fb$a */
    public static final class C3045a extends C2989a {

        /* renamed from: c */
        public C3041fa f7104c;

        /* renamed from: d */
        public C3023eu f7105d;

        /* renamed from: e */
        public C3062fh f7106e;

        /* renamed from: b */
        public final C3044fb mo30100b() {
            return new C3044fb(this.f7104c, this.f7105d, this.f7106e, super.mo29987a());
        }
    }

    /* renamed from: com.tapjoy.internal.fb$b */
    static final class C3046b extends C2991ej {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            C3044fb fbVar = (C3044fb) obj;
            int i = 0;
            int a = (fbVar.f7101d != null ? C3041fa.f7060c.mo29988a(1, (Object) fbVar.f7101d) : 0) + (fbVar.f7102e != null ? C3023eu.f6961c.mo29988a(2, (Object) fbVar.f7102e) : 0);
            if (fbVar.f7103f != null) {
                i = C3062fh.f7162c.mo29988a(3, (Object) fbVar.f7103f);
            }
            return a + i + fbVar.mo29983a().mo30308c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            C3044fb fbVar = (C3044fb) obj;
            if (fbVar.f7101d != null) {
                C3041fa.f7060c.mo29992a(elVar, 1, fbVar.f7101d);
            }
            if (fbVar.f7102e != null) {
                C3023eu.f6961c.mo29992a(elVar, 2, fbVar.f7102e);
            }
            if (fbVar.f7103f != null) {
                C3062fh.f7162c.mo29992a(elVar, 3, fbVar.f7103f);
            }
            elVar.mo30004a(fbVar.mo29983a());
        }

        C3046b() {
            super(C2986eg.LENGTH_DELIMITED, C3044fb.class);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            C3045a aVar = new C3045a();
            long a = ekVar.mo29995a();
            while (true) {
                int b = ekVar.mo29997b();
                if (b == -1) {
                    ekVar.mo29996a(a);
                    return aVar.mo30100b();
                } else if (b == 1) {
                    aVar.f7104c = (C3041fa) C3041fa.f7060c.mo29980a(ekVar);
                } else if (b == 2) {
                    aVar.f7105d = (C3023eu) C3023eu.f6961c.mo29980a(ekVar);
                } else if (b != 3) {
                    C2986eg c = ekVar.mo29998c();
                    aVar.mo29985a(b, c, c.mo29982a().mo29980a(ekVar));
                } else {
                    aVar.f7106e = (C3062fh) C3062fh.f7162c.mo29980a(ekVar);
                }
            }
        }
    }

    public C3044fb(C3041fa faVar, C3023eu euVar, C3062fh fhVar) {
        this(faVar, euVar, fhVar, C3197iu.f7628b);
    }

    public C3044fb(C3041fa faVar, C3023eu euVar, C3062fh fhVar, C3197iu iuVar) {
        super(f7100c, iuVar);
        this.f7101d = faVar;
        this.f7102e = euVar;
        this.f7103f = fhVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3044fb)) {
            return false;
        }
        C3044fb fbVar = (C3044fb) obj;
        return mo29983a().equals(fbVar.mo29983a()) && C3011eo.m6888a((Object) this.f7101d, (Object) fbVar.f7101d) && C3011eo.m6888a((Object) this.f7102e, (Object) fbVar.f7102e) && C3011eo.m6888a((Object) this.f7103f, (Object) fbVar.f7103f);
    }

    public final int hashCode() {
        int i = this.f6894b;
        if (i != 0) {
            return i;
        }
        int hashCode = mo29983a().hashCode() * 37;
        C3041fa faVar = this.f7101d;
        int i2 = 0;
        int hashCode2 = (hashCode + (faVar != null ? faVar.hashCode() : 0)) * 37;
        C3023eu euVar = this.f7102e;
        int hashCode3 = (hashCode2 + (euVar != null ? euVar.hashCode() : 0)) * 37;
        C3062fh fhVar = this.f7103f;
        if (fhVar != null) {
            i2 = fhVar.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.f6894b = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f7101d != null) {
            sb.append(", info=");
            sb.append(this.f7101d);
        }
        if (this.f7102e != null) {
            sb.append(", app=");
            sb.append(this.f7102e);
        }
        if (this.f7103f != null) {
            sb.append(", user=");
            sb.append(this.f7103f);
        }
        StringBuilder replace = sb.replace(0, 2, "InfoSet{");
        replace.append('}');
        return replace.toString();
    }
}
