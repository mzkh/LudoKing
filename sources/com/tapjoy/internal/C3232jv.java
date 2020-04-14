package com.tapjoy.internal;

import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tapjoy.internal.jv */
public final class C3232jv {
    /* renamed from: a */
    public static HashSet m7505a(Iterator it) {
        HashSet hashSet = new HashSet();
        while (it.hasNext()) {
            hashSet.add(it.next());
        }
        return hashSet;
    }
}
