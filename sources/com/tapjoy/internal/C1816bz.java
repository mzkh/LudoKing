package com.tapjoy.internal;

import java.io.InputStream;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.tapjoy.internal.bz */
public abstract class C1816bz extends C1817ca {
    /* renamed from: a */
    public abstract Object mo18079a(C1812bn bnVar);

    /* renamed from: a */
    public final Map mo18081a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Accept", "application/json");
        return linkedHashMap;
    }

    /* renamed from: a */
    public final Object mo18080a(URI uri, InputStream inputStream) {
        C1812bn a = C1812bn.m3462a(inputStream);
        a.mo18051a("BASE_URI", uri);
        int i = 0;
        try {
            a.mo18067h();
            Object obj = null;
            String str = null;
            while (a.mo18069j()) {
                String l = a.mo18071l();
                if ("status".equals(l)) {
                    i = a.mo18077r();
                } else if ("message".equals(l)) {
                    str = a.mo18072m();
                } else if ("data".equals(l)) {
                    obj = mo18079a(a);
                } else {
                    a.mo18078s();
                }
            }
            a.mo18068i();
            if (i == 200) {
                return obj;
            }
            throw new C2917cb(i, str);
        } finally {
            a.close();
        }
    }
}
