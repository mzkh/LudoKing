package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.tapjoy.internal.ep */
final class C3012ep extends AbstractList implements Serializable, RandomAccess {

    /* renamed from: a */
    List f6929a;

    /* renamed from: b */
    private final List f6930b;

    C3012ep(List list) {
        this.f6930b = list;
        this.f6929a = list;
    }

    public final Object get(int i) {
        return this.f6929a.get(i);
    }

    public final int size() {
        return this.f6929a.size();
    }

    public final Object set(int i, Object obj) {
        List list = this.f6929a;
        List list2 = this.f6930b;
        if (list == list2) {
            this.f6929a = new ArrayList(list2);
        }
        return this.f6929a.set(i, obj);
    }

    public final void add(int i, Object obj) {
        List list = this.f6929a;
        List list2 = this.f6930b;
        if (list == list2) {
            this.f6929a = new ArrayList(list2);
        }
        this.f6929a.add(i, obj);
    }

    public final Object remove(int i) {
        List list = this.f6929a;
        List list2 = this.f6930b;
        if (list == list2) {
            this.f6929a = new ArrayList(list2);
        }
        return this.f6929a.remove(i);
    }
}
