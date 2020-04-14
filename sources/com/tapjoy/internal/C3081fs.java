package com.tapjoy.internal;

import java.util.Observable;

/* renamed from: com.tapjoy.internal.fs */
public final class C3081fs {

    /* renamed from: a */
    public static final C3082a f7264a = new C3082a();

    /* renamed from: b */
    public static final C3082a f7265b = new C3082a();

    /* renamed from: c */
    public static final C3082a f7266c = new C3082a();

    /* renamed from: d */
    public static final C3082a f7267d = new C3082a();

    /* renamed from: e */
    public static final C3082a f7268e = new C3082a();

    /* renamed from: com.tapjoy.internal.fs$a */
    public static class C3082a extends Observable {
        public final void notifyObservers() {
            setChanged();
            super.notifyObservers();
        }

        public final void notifyObservers(Object obj) {
            setChanged();
            super.notifyObservers(obj);
        }
    }
}
