package com.tapjoy.internal;

import java.io.Closeable;
import java.io.Flushable;
import java.util.LinkedList;

/* renamed from: com.tapjoy.internal.au */
public final class C2883au extends C2881at implements C2886ax, Closeable, Flushable {

    /* renamed from: a */
    private final C2886ax f6682a;

    /* renamed from: b */
    private final LinkedList f6683b = new LinkedList();

    /* renamed from: c */
    private final LinkedList f6684c = new LinkedList();

    /* renamed from: d */
    private int f6685d;

    /* renamed from: e */
    private boolean f6686e;

    /* renamed from: a */
    public static C2883au m6583a(C2886ax axVar) {
        return new C2883au(axVar);
    }

    private C2883au(C2886ax axVar) {
        this.f6682a = axVar;
        this.f6685d = axVar.size();
        this.f6686e = this.f6685d == 0;
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        close();
        super.finalize();
    }

    public final void close() {
        try {
            flush();
        } finally {
            C2886ax axVar = this.f6682a;
            if (axVar instanceof Closeable) {
                ((Closeable) axVar).close();
            }
        }
    }

    public final void flush() {
        if (!this.f6684c.isEmpty()) {
            this.f6682a.addAll(this.f6684c);
            if (this.f6686e) {
                this.f6683b.addAll(this.f6684c);
            }
            this.f6684c.clear();
        }
    }

    public final int size() {
        return this.f6685d;
    }

    public final boolean offer(Object obj) {
        this.f6684c.add(obj);
        this.f6685d++;
        return true;
    }

    public final Object poll() {
        Object obj;
        if (this.f6685d <= 0) {
            return null;
        }
        if (!this.f6683b.isEmpty()) {
            obj = this.f6683b.remove();
            this.f6682a.mo29818b(1);
        } else if (this.f6686e) {
            obj = this.f6684c.remove();
        } else {
            obj = this.f6682a.remove();
            if (this.f6685d == this.f6684c.size() + 1) {
                this.f6686e = true;
            }
        }
        this.f6685d--;
        return obj;
    }

    public final Object peek() {
        if (this.f6685d <= 0) {
            return null;
        }
        if (!this.f6683b.isEmpty()) {
            return this.f6683b.element();
        }
        if (this.f6686e) {
            return this.f6684c.element();
        }
        Object peek = this.f6682a.peek();
        this.f6683b.add(peek);
        if (this.f6685d == this.f6683b.size() + this.f6684c.size()) {
            this.f6686e = true;
        }
        return peek;
    }

    /* renamed from: a */
    public final Object mo29817a(int i) {
        if (i < 0 || i >= this.f6685d) {
            throw new IndexOutOfBoundsException();
        }
        int size = this.f6683b.size();
        if (i < size) {
            return this.f6683b.get(i);
        }
        if (this.f6686e) {
            return this.f6684c.get(i - size);
        }
        if (i >= this.f6682a.size()) {
            return this.f6684c.get(i - this.f6682a.size());
        }
        Object obj = null;
        while (size <= i) {
            obj = this.f6682a.mo29817a(size);
            this.f6683b.add(obj);
            size++;
        }
        if (i + 1 + this.f6684c.size() == this.f6685d) {
            this.f6686e = true;
        }
        return obj;
    }

    /* renamed from: b */
    public final void mo29818b(int i) {
        if (i <= 0 || i > this.f6685d) {
            throw new IndexOutOfBoundsException();
        }
        if (i <= this.f6683b.size()) {
            C2885aw.m6588a(this.f6683b, i);
            this.f6682a.mo29818b(i);
        } else {
            this.f6683b.clear();
            int size = (this.f6684c.size() + i) - this.f6685d;
            if (size < 0) {
                this.f6682a.mo29818b(i);
            } else {
                this.f6682a.clear();
                this.f6686e = true;
                if (size > 0) {
                    C2885aw.m6588a(this.f6684c, size);
                }
            }
        }
        this.f6685d -= i;
    }
}
