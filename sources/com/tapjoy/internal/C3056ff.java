package com.tapjoy.internal;

import com.tapjoy.internal.C2988eh.C2989a;
import java.util.List;

/* renamed from: com.tapjoy.internal.ff */
public final class C3056ff extends C2988eh {

    /* renamed from: c */
    public static final C2991ej f7156c = new C3058b();

    /* renamed from: d */
    public final List f7157d;

    /* renamed from: com.tapjoy.internal.ff$a */
    public static final class C3057a extends C2989a {

        /* renamed from: c */
        public List f7158c = C3011eo.m6886a();

        /* renamed from: b */
        public final C3056ff mo30113b() {
            return new C3056ff(this.f7158c, super.mo29987a());
        }
    }

    /* renamed from: com.tapjoy.internal.ff$b */
    static final class C3058b extends C2991ej {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            C3056ff ffVar = (C3056ff) obj;
            return C3053fe.f7147c.mo29989a().mo29988a(1, (Object) ffVar.f7157d) + ffVar.mo29983a().mo30308c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            C3056ff ffVar = (C3056ff) obj;
            C3053fe.f7147c.mo29989a().mo29992a(elVar, 1, ffVar.f7157d);
            elVar.mo30004a(ffVar.mo29983a());
        }

        C3058b() {
            super(C2986eg.LENGTH_DELIMITED, C3056ff.class);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            C3057a aVar = new C3057a();
            long a = ekVar.mo29995a();
            while (true) {
                int b = ekVar.mo29997b();
                if (b == -1) {
                    ekVar.mo29996a(a);
                    return aVar.mo30113b();
                } else if (b != 1) {
                    C2986eg c = ekVar.mo29998c();
                    aVar.mo29985a(b, c, c.mo29982a().mo29980a(ekVar));
                } else {
                    aVar.f7158c.add(C3053fe.f7147c.mo29980a(ekVar));
                }
            }
        }
    }

    public C3056ff(List list) {
        this(list, C3197iu.f7628b);
    }

    public C3056ff(List list, C3197iu iuVar) {
        super(f7156c, iuVar);
        this.f7157d = C3011eo.m6887a("pushes", list);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3056ff)) {
            return false;
        }
        C3056ff ffVar = (C3056ff) obj;
        return mo29983a().equals(ffVar.mo29983a()) && this.f7157d.equals(ffVar.f7157d);
    }

    public final int hashCode() {
        int i = this.f6894b;
        if (i != 0) {
            return i;
        }
        int hashCode = (mo29983a().hashCode() * 37) + this.f7157d.hashCode();
        this.f6894b = hashCode;
        return hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f7157d.isEmpty()) {
            sb.append(", pushes=");
            sb.append(this.f7157d);
        }
        StringBuilder replace = sb.replace(0, 2, "PushList{");
        replace.append('}');
        return replace.toString();
    }
}
