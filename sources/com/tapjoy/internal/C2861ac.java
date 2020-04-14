package com.tapjoy.internal;

import android.view.ViewGroup;
import java.util.Iterator;

/* renamed from: com.tapjoy.internal.ac */
public final class C2861ac {

    /* renamed from: com.tapjoy.internal.ac$a */
    static class C2863a implements Iterator {

        /* renamed from: a */
        private final ViewGroup f6630a;

        /* renamed from: b */
        private int f6631b;

        /* renamed from: c */
        private int f6632c = 0;

        public C2863a(ViewGroup viewGroup) {
            this.f6630a = viewGroup;
            this.f6631b = viewGroup.getChildCount();
        }

        public final boolean hasNext() {
            return this.f6632c < this.f6631b;
        }

        public final void remove() {
            this.f6630a.removeViewAt(this.f6632c - 1);
        }

        public final /* synthetic */ Object next() {
            ViewGroup viewGroup = this.f6630a;
            int i = this.f6632c;
            this.f6632c = i + 1;
            return viewGroup.getChildAt(i);
        }
    }

    /* renamed from: a */
    public static Iterable m6563a(ViewGroup viewGroup) {
        final C2863a aVar = new C2863a(viewGroup);
        return new Iterable() {
            public final Iterator iterator() {
                return aVar;
            }
        };
    }
}
