package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.tapjoy.internal.ay */
public final class C2887ay extends AbstractSet implements Serializable, Set {

    /* renamed from: a */
    transient WeakHashMap f6688a;

    public C2887ay() {
        this(new WeakHashMap());
    }

    private C2887ay(WeakHashMap weakHashMap) {
        this.f6688a = weakHashMap;
    }

    public final boolean add(Object obj) {
        return this.f6688a.put(obj, this) == null;
    }

    public final void clear() {
        this.f6688a.clear();
    }

    public final Object clone() {
        try {
            return (C2887ay) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean contains(Object obj) {
        return this.f6688a.containsKey(obj);
    }

    public final boolean isEmpty() {
        return this.f6688a.isEmpty();
    }

    public final Iterator iterator() {
        return this.f6688a.keySet().iterator();
    }

    public final boolean remove(Object obj) {
        return this.f6688a.remove(obj) != null;
    }

    public final int size() {
        return this.f6688a.size();
    }
}
