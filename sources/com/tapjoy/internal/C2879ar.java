package com.tapjoy.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* renamed from: com.tapjoy.internal.ar */
public final class C2879ar extends C1808aq {

    /* renamed from: a */
    private final LinkedHashMap f6678a = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: b */
    private int f6679b = 10;

    /* renamed from: a */
    private void m6580a() {
        int size = this.f6678a.size() - this.f6679b;
        if (size > 0) {
            Iterator it = this.f6678a.entrySet().iterator();
            while (size > 0 && it.hasNext()) {
                size--;
                it.next();
                it.remove();
            }
        }
    }

    /* renamed from: a */
    public final void mo18048a(Object obj, Object obj2) {
        super.mo18048a(obj, obj2);
        m6580a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C2876ao mo18049a(Object obj, boolean z) {
        C2875am amVar = (C2875am) this.f6678a.get(obj);
        if (amVar != null || !z) {
            return amVar;
        }
        C2875am amVar2 = new C2875am(obj);
        this.f6678a.put(obj, amVar2);
        m6580a();
        return amVar2;
    }
}
