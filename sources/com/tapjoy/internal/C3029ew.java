package com.tapjoy.internal;

import com.tapjoy.internal.C2988eh.C2989a;
import java.util.List;

/* renamed from: com.tapjoy.internal.ew */
public final class C3029ew extends C2988eh {

    /* renamed from: c */
    public static final C2991ej f7034c = new C3031b();

    /* renamed from: d */
    public final List f7035d;

    /* renamed from: com.tapjoy.internal.ew$a */
    public static final class C3030a extends C2989a {

        /* renamed from: c */
        public List f7036c = C3011eo.m6886a();

        /* renamed from: b */
        public final C3029ew mo30088b() {
            return new C3029ew(this.f7036c, super.mo29987a());
        }
    }

    /* renamed from: com.tapjoy.internal.ew$b */
    static final class C3031b extends C2991ej {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            C3029ew ewVar = (C3029ew) obj;
            return C3026ev.f6973c.mo29989a().mo29988a(1, (Object) ewVar.f7035d) + ewVar.mo29983a().mo30308c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            C3029ew ewVar = (C3029ew) obj;
            C3026ev.f6973c.mo29989a().mo29992a(elVar, 1, ewVar.f7035d);
            elVar.mo30004a(ewVar.mo29983a());
        }

        C3031b() {
            super(C2986eg.LENGTH_DELIMITED, C3029ew.class);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            C3030a aVar = new C3030a();
            long a = ekVar.mo29995a();
            while (true) {
                int b = ekVar.mo29997b();
                if (b == -1) {
                    ekVar.mo29996a(a);
                    return aVar.mo30088b();
                } else if (b != 1) {
                    C2986eg c = ekVar.mo29998c();
                    aVar.mo29985a(b, c, c.mo29982a().mo29980a(ekVar));
                } else {
                    aVar.f7036c.add(C3026ev.f6973c.mo29980a(ekVar));
                }
            }
        }
    }

    public C3029ew(List list, C3197iu iuVar) {
        super(f7034c, iuVar);
        this.f7035d = C3011eo.m6887a("events", list);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3029ew)) {
            return false;
        }
        C3029ew ewVar = (C3029ew) obj;
        return mo29983a().equals(ewVar.mo29983a()) && this.f7035d.equals(ewVar.f7035d);
    }

    public final int hashCode() {
        int i = this.f6894b;
        if (i != 0) {
            return i;
        }
        int hashCode = (mo29983a().hashCode() * 37) + this.f7035d.hashCode();
        this.f6894b = hashCode;
        return hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f7035d.isEmpty()) {
            sb.append(", events=");
            sb.append(this.f7035d);
        }
        StringBuilder replace = sb.replace(0, 2, "EventBatch{");
        replace.append('}');
        return replace.toString();
    }
}
