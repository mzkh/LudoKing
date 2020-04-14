package com.tapjoy.internal;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/* renamed from: com.tapjoy.internal.az */
public final class C2888az extends AbstractMap {

    /* renamed from: a */
    private final HashMap f6689a = new HashMap();

    /* renamed from: b */
    private final C2914bx f6690b = new C2914bx();

    public final int size() {
        m6593b();
        return this.f6689a.size();
    }

    public final void clear() {
        this.f6689a.clear();
        do {
        } while (this.f6690b.mo29902a() != null);
    }

    public final boolean containsKey(Object obj) {
        m6593b();
        return this.f6689a.containsKey(obj);
    }

    public final boolean containsValue(Object obj) {
        m6593b();
        for (C2913bw bwVar : this.f6689a.values()) {
            if (obj.equals(bwVar.get())) {
                return true;
            }
        }
        return false;
    }

    public final Object get(Object obj) {
        m6593b();
        return m6592a((C2913bw) this.f6689a.get(obj));
    }

    public final Object put(Object obj, Object obj2) {
        m6593b();
        return m6592a((C2913bw) this.f6689a.put(obj, new C2913bw(obj, obj2, this.f6690b)));
    }

    public final Object remove(Object obj) {
        m6593b();
        return m6592a((C2913bw) this.f6689a.remove(obj));
    }

    /* renamed from: a */
    private static Object m6592a(C2913bw bwVar) {
        if (bwVar != null) {
            return bwVar.get();
        }
        return null;
    }

    public final Set entrySet() {
        m6593b();
        throw new UnsupportedOperationException();
    }

    public final Set keySet() {
        m6593b();
        return this.f6689a.keySet();
    }

    public final Collection values() {
        m6593b();
        throw new UnsupportedOperationException();
    }

    public final boolean equals(Object obj) {
        m6593b();
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        m6593b();
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        m6593b();
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    private void m6593b() {
        while (true) {
            C2913bw a = this.f6690b.mo29902a();
            if (a != null) {
                this.f6689a.remove(a.f6740a);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static C2888az m6591a() {
        return new C2888az();
    }
}
