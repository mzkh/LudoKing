package com.tapjoy.internal;

import com.tapjoy.internal.C2988eh.C2989a;

/* renamed from: com.tapjoy.internal.eu */
public final class C3023eu extends C2988eh {

    /* renamed from: c */
    public static final C2991ej f6961c = new C3025b();

    /* renamed from: d */
    public static final Integer f6962d = Integer.valueOf(0);

    /* renamed from: e */
    public final String f6963e;

    /* renamed from: f */
    public final Integer f6964f;

    /* renamed from: g */
    public final String f6965g;

    /* renamed from: h */
    public final String f6966h;

    /* renamed from: i */
    public final String f6967i;

    /* renamed from: com.tapjoy.internal.eu$a */
    public static final class C3024a extends C2989a {

        /* renamed from: c */
        public String f6968c;

        /* renamed from: d */
        public Integer f6969d;

        /* renamed from: e */
        public String f6970e;

        /* renamed from: f */
        public String f6971f;

        /* renamed from: g */
        public String f6972g;

        /* renamed from: b */
        public final C3023eu mo30082b() {
            C3023eu euVar = new C3023eu(this.f6968c, this.f6969d, this.f6970e, this.f6971f, this.f6972g, super.mo29987a());
            return euVar;
        }
    }

    /* renamed from: com.tapjoy.internal.eu$b */
    static final class C3025b extends C2991ej {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            C3023eu euVar = (C3023eu) obj;
            int i = 0;
            int a = (euVar.f6963e != null ? C2991ej.f6912p.mo29988a(1, (Object) euVar.f6963e) : 0) + (euVar.f6964f != null ? C2991ej.f6900d.mo29988a(2, (Object) euVar.f6964f) : 0) + (euVar.f6965g != null ? C2991ej.f6912p.mo29988a(3, (Object) euVar.f6965g) : 0) + (euVar.f6966h != null ? C2991ej.f6912p.mo29988a(4, (Object) euVar.f6966h) : 0);
            if (euVar.f6967i != null) {
                i = C2991ej.f6912p.mo29988a(5, (Object) euVar.f6967i);
            }
            return a + i + euVar.mo29983a().mo30308c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            C3023eu euVar = (C3023eu) obj;
            if (euVar.f6963e != null) {
                C2991ej.f6912p.mo29992a(elVar, 1, euVar.f6963e);
            }
            if (euVar.f6964f != null) {
                C2991ej.f6900d.mo29992a(elVar, 2, euVar.f6964f);
            }
            if (euVar.f6965g != null) {
                C2991ej.f6912p.mo29992a(elVar, 3, euVar.f6965g);
            }
            if (euVar.f6966h != null) {
                C2991ej.f6912p.mo29992a(elVar, 4, euVar.f6966h);
            }
            if (euVar.f6967i != null) {
                C2991ej.f6912p.mo29992a(elVar, 5, euVar.f6967i);
            }
            elVar.mo30004a(euVar.mo29983a());
        }

        C3025b() {
            super(C2986eg.LENGTH_DELIMITED, C3023eu.class);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            C3024a aVar = new C3024a();
            long a = ekVar.mo29995a();
            while (true) {
                int b = ekVar.mo29997b();
                if (b == -1) {
                    ekVar.mo29996a(a);
                    return aVar.mo30082b();
                } else if (b == 1) {
                    aVar.f6968c = (String) C2991ej.f6912p.mo29980a(ekVar);
                } else if (b == 2) {
                    aVar.f6969d = (Integer) C2991ej.f6900d.mo29980a(ekVar);
                } else if (b == 3) {
                    aVar.f6970e = (String) C2991ej.f6912p.mo29980a(ekVar);
                } else if (b == 4) {
                    aVar.f6971f = (String) C2991ej.f6912p.mo29980a(ekVar);
                } else if (b != 5) {
                    C2986eg c = ekVar.mo29998c();
                    aVar.mo29985a(b, c, c.mo29982a().mo29980a(ekVar));
                } else {
                    aVar.f6972g = (String) C2991ej.f6912p.mo29980a(ekVar);
                }
            }
        }
    }

    public C3023eu(String str, Integer num, String str2, String str3, String str4, C3197iu iuVar) {
        super(f6961c, iuVar);
        this.f6963e = str;
        this.f6964f = num;
        this.f6965g = str2;
        this.f6966h = str3;
        this.f6967i = str4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3023eu)) {
            return false;
        }
        C3023eu euVar = (C3023eu) obj;
        return mo29983a().equals(euVar.mo29983a()) && C3011eo.m6888a((Object) this.f6963e, (Object) euVar.f6963e) && C3011eo.m6888a((Object) this.f6964f, (Object) euVar.f6964f) && C3011eo.m6888a((Object) this.f6965g, (Object) euVar.f6965g) && C3011eo.m6888a((Object) this.f6966h, (Object) euVar.f6966h) && C3011eo.m6888a((Object) this.f6967i, (Object) euVar.f6967i);
    }

    public final int hashCode() {
        int i = this.f6894b;
        if (i != 0) {
            return i;
        }
        int hashCode = mo29983a().hashCode() * 37;
        String str = this.f6963e;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.f6964f;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.f6965g;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.f6966h;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.f6967i;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.f6894b = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f6963e != null) {
            sb.append(", pkgVer=");
            sb.append(this.f6963e);
        }
        if (this.f6964f != null) {
            sb.append(", pkgRev=");
            sb.append(this.f6964f);
        }
        if (this.f6965g != null) {
            sb.append(", dataVer=");
            sb.append(this.f6965g);
        }
        if (this.f6966h != null) {
            sb.append(", installer=");
            sb.append(this.f6966h);
        }
        if (this.f6967i != null) {
            sb.append(", store=");
            sb.append(this.f6967i);
        }
        StringBuilder replace = sb.replace(0, 2, "App{");
        replace.append('}');
        return replace.toString();
    }
}
