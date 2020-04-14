package com.tapjoy.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: com.tapjoy.internal.av */
public final class C2884av implements C2886ax {

    /* renamed from: a */
    private final List f6687a;

    public C2884av(List list) {
        this.f6687a = list;
    }

    public final boolean add(Object obj) {
        return this.f6687a.add(obj);
    }

    public final boolean addAll(Collection collection) {
        return this.f6687a.addAll(collection);
    }

    public final void clear() {
        this.f6687a.clear();
    }

    public final boolean contains(Object obj) {
        return this.f6687a.contains(obj);
    }

    public final boolean containsAll(Collection collection) {
        return this.f6687a.containsAll(collection);
    }

    public final boolean equals(Object obj) {
        return this.f6687a.equals(obj);
    }

    /* renamed from: a */
    public final Object mo29817a(int i) {
        return this.f6687a.get(i);
    }

    public final int hashCode() {
        return this.f6687a.hashCode();
    }

    public final boolean isEmpty() {
        return this.f6687a.isEmpty();
    }

    public final Iterator iterator() {
        return this.f6687a.iterator();
    }

    public final boolean remove(Object obj) {
        return this.f6687a.remove(obj);
    }

    public final boolean removeAll(Collection collection) {
        return this.f6687a.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        return this.f6687a.retainAll(collection);
    }

    public final int size() {
        return this.f6687a.size();
    }

    public final Object[] toArray() {
        return this.f6687a.toArray();
    }

    public final Object[] toArray(Object[] objArr) {
        return this.f6687a.toArray(objArr);
    }

    public final boolean offer(Object obj) {
        return this.f6687a.add(obj);
    }

    public final Object remove() {
        Object poll = poll();
        if (poll != null) {
            return poll;
        }
        throw new NoSuchElementException();
    }

    public final Object poll() {
        if (this.f6687a.isEmpty()) {
            return null;
        }
        return this.f6687a.remove(0);
    }

    public final Object element() {
        Object peek = peek();
        if (peek != null) {
            return peek;
        }
        throw new NoSuchElementException();
    }

    public final Object peek() {
        if (this.f6687a.isEmpty()) {
            return null;
        }
        return this.f6687a.get(0);
    }

    /* renamed from: b */
    public final void mo29818b(int i) {
        C2885aw.m6588a(this.f6687a, i);
    }
}
