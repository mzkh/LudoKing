package com.tapjoy.internal;

import java.util.AbstractQueue;
import java.util.Iterator;

/* renamed from: com.tapjoy.internal.at */
public abstract class C2881at extends AbstractQueue implements C2886ax {
    public Iterator iterator() {
        return new Iterator() {

            /* renamed from: b */
            private int f6681b = 0;

            public final boolean hasNext() {
                return this.f6681b < C2881at.this.size();
            }

            public final Object next() {
                C2881at atVar = C2881at.this;
                int i = this.f6681b;
                this.f6681b = i + 1;
                return atVar.mo29817a(i);
            }

            public final void remove() {
                if (this.f6681b == 1) {
                    C2881at.this.mo29818b(1);
                    this.f6681b = 0;
                    return;
                }
                throw new UnsupportedOperationException("For the first element only");
            }
        };
    }
}
