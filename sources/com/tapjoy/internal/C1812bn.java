package com.tapjoy.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.bn */
public abstract class C1812bn implements C1811bk, C1815bp {

    /* renamed from: a */
    private HashMap f3774a;

    /* renamed from: com.tapjoy.internal.bn$a */
    public static abstract class C1814a {

        /* renamed from: a */
        private static C1814a f3776a;

        /* renamed from: a */
        public static C1814a m3479a() {
            C1814a aVar = f3776a;
            if (aVar != null) {
                return aVar;
            }
            C1814a aVar2 = C2903bo.f6697a;
            f3776a = aVar2;
            return aVar2;
        }

        /* renamed from: a */
        public final C1812bn mo18061a(InputStream inputStream) {
            return mo18062a((Reader) new InputStreamReader(inputStream, C3223jm.f7734c));
        }

        /* renamed from: a */
        public C1812bn mo18062a(Reader reader) {
            return mo18063a(C3235jy.m7508a(reader));
        }

        /* renamed from: a */
        public C1812bn mo18063a(String str) {
            return mo18061a((InputStream) new ByteArrayInputStream(str.getBytes(C3223jm.f7734c.name())));
        }
    }

    /* renamed from: a */
    public static C1812bn m3462a(InputStream inputStream) {
        return C1814a.m3479a().mo18061a(inputStream);
    }

    /* renamed from: b */
    public static C1812bn m3464b(String str) {
        return C1814a.m3479a().mo18063a(str);
    }

    /* renamed from: a */
    public final Object mo18050a(String str) {
        HashMap hashMap = this.f3774a;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    /* renamed from: a */
    public final void mo18051a(String str, Object obj) {
        if (this.f3774a == null) {
            this.f3774a = new HashMap();
        }
        this.f3774a.put(str, obj);
    }

    /* renamed from: a */
    public final boolean mo18055a() {
        return mo18070k() == C2908bs.BEGIN_OBJECT;
    }

    /* renamed from: t */
    private boolean m3466t() {
        if (mo18070k() != C2908bs.NULL) {
            return false;
        }
        mo18074o();
        return true;
    }

    /* renamed from: b */
    public final String mo18056b() {
        if (m3466t()) {
            return null;
        }
        return mo18072m();
    }

    /* renamed from: c */
    public final String mo18057c(String str) {
        if (m3466t()) {
            return str;
        }
        return mo18072m();
    }

    /* renamed from: u */
    private Object m3467u() {
        C2908bs k = mo18070k();
        switch (k) {
            case BEGIN_ARRAY:
                return mo18058c();
            case BEGIN_OBJECT:
                return mo18059d();
            case NULL:
                mo18074o();
                return null;
            case BOOLEAN:
                return Boolean.valueOf(mo18073n());
            case NUMBER:
                return new C2923ci(mo18072m());
            case STRING:
                return mo18072m();
            default:
                StringBuilder sb = new StringBuilder("Expected a value but was ");
                sb.append(k);
                throw new IllegalStateException(sb.toString());
        }
    }

    /* renamed from: c */
    public final List mo18058c() {
        LinkedList linkedList = new LinkedList();
        m3463a((List) linkedList);
        return linkedList;
    }

    /* renamed from: a */
    private void m3463a(List list) {
        mo18065f();
        while (mo18069j()) {
            list.add(m3467u());
        }
        mo18066g();
    }

    /* renamed from: d */
    public final Map mo18059d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        mo18054a((Map) linkedHashMap);
        return linkedHashMap;
    }

    /* renamed from: a */
    public final void mo18054a(Map map) {
        mo18067h();
        while (mo18069j()) {
            map.put(mo18071l(), m3467u());
        }
        mo18068i();
    }

    @Nullable
    /* renamed from: a */
    public final Object mo18052a(C2896bi biVar) {
        if (m3466t()) {
            return null;
        }
        return biVar.mo18189a(this);
    }

    /* renamed from: a */
    public final void mo18053a(List list, C2896bi biVar) {
        mo18065f();
        while (mo18069j()) {
            list.add(biVar.mo18189a(this));
        }
        mo18066g();
    }

    /* renamed from: d */
    private static URI m3465d(String str) {
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            throw new C2912bv(e);
        }
    }

    /* renamed from: e */
    public final URL mo18060e() {
        URI uri = (URI) mo18050a("BASE_URI");
        if (uri != null) {
            return uri.resolve(m3465d(mo18072m())).toURL();
        }
        return new URL(mo18072m());
    }
}
