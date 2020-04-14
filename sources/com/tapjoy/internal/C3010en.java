package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.tapjoy.internal.en */
final class C3010en extends AbstractList implements Serializable, RandomAccess {

    /* renamed from: a */
    private final ArrayList f6928a;

    C3010en(List list) {
        this.f6928a = new ArrayList(list);
    }

    public final int size() {
        return this.f6928a.size();
    }

    public final Object get(int i) {
        return this.f6928a.get(i);
    }

    public final Object[] toArray() {
        return this.f6928a.toArray();
    }
}
