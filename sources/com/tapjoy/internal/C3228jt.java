package com.tapjoy.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.tapjoy.internal.jt */
public final class C3228jt {

    /* renamed from: a */
    static final C3233jw f7742a = new C3233jw() {
        public final boolean hasNext() {
            return false;
        }

        public final Object next() {
            throw new NoSuchElementException();
        }
    };

    /* renamed from: b */
    private static final Iterator f7743b = new Iterator() {
        public final boolean hasNext() {
            return false;
        }

        public final Object next() {
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new IllegalStateException();
        }
    };

    /* renamed from: a */
    public static Object m7502a(Iterator it) {
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }
}
