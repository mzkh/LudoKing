package com.tapjoy.internal;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tapjoy.internal.C2988eh.C2989a;
import java.util.List;

/* renamed from: com.tapjoy.internal.fg */
public final class C3059fg extends C2988eh {

    /* renamed from: c */
    public static final C2991ej f7159c = new C3061b();

    /* renamed from: d */
    public final List f7160d;

    /* renamed from: com.tapjoy.internal.fg$a */
    public static final class C3060a extends C2989a {

        /* renamed from: c */
        public List f7161c = C3011eo.m6886a();

        /* renamed from: b */
        public final C3059fg mo30116b() {
            return new C3059fg(this.f7161c, super.mo29987a());
        }
    }

    /* renamed from: com.tapjoy.internal.fg$b */
    static final class C3061b extends C2991ej {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            C3059fg fgVar = (C3059fg) obj;
            return C2991ej.f6912p.mo29989a().mo29988a(1, (Object) fgVar.f7160d) + fgVar.mo29983a().mo30308c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            C3059fg fgVar = (C3059fg) obj;
            C2991ej.f6912p.mo29989a().mo29992a(elVar, 1, fgVar.f7160d);
            elVar.mo30004a(fgVar.mo29983a());
        }

        C3061b() {
            super(C2986eg.LENGTH_DELIMITED, C3059fg.class);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            C3060a aVar = new C3060a();
            long a = ekVar.mo29995a();
            while (true) {
                int b = ekVar.mo29997b();
                if (b == -1) {
                    ekVar.mo29996a(a);
                    return aVar.mo30116b();
                } else if (b != 1) {
                    C2986eg c = ekVar.mo29998c();
                    aVar.mo29985a(b, c, c.mo29982a().mo29980a(ekVar));
                } else {
                    aVar.f7161c.add(C2991ej.f6912p.mo29980a(ekVar));
                }
            }
        }
    }

    public C3059fg(List list) {
        this(list, C3197iu.f7628b);
    }

    public C3059fg(List list, C3197iu iuVar) {
        super(f7159c, iuVar);
        this.f7160d = C3011eo.m6887a(MessengerShareContentUtility.ELEMENTS, list);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3059fg)) {
            return false;
        }
        C3059fg fgVar = (C3059fg) obj;
        return mo29983a().equals(fgVar.mo29983a()) && this.f7160d.equals(fgVar.f7160d);
    }

    public final int hashCode() {
        int i = this.f6894b;
        if (i != 0) {
            return i;
        }
        int hashCode = (mo29983a().hashCode() * 37) + this.f7160d.hashCode();
        this.f6894b = hashCode;
        return hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f7160d.isEmpty()) {
            sb.append(", elements=");
            sb.append(this.f7160d);
        }
        StringBuilder replace = sb.replace(0, 2, "StringList{");
        replace.append('}');
        return replace.toString();
    }
}
