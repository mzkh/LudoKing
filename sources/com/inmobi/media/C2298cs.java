package com.inmobi.media;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.inmobi.media.cs */
/* compiled from: TrackerAttr */
public final class C2298cs {

    /* renamed from: a */
    public int f4851a;

    /* renamed from: b */
    public Map<String, Object> f4852b = new HashMap();

    public C2298cs(int i) {
        this.f4851a = i;
    }

    /* renamed from: a */
    public final <T> T mo28143a(String str, Class<T> cls) {
        Object obj = this.f4852b.get(str);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }
}
