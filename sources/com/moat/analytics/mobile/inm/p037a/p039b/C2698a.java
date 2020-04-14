package com.moat.analytics.mobile.inm.p037a.p039b;

import java.util.NoSuchElementException;

/* renamed from: com.moat.analytics.mobile.inm.a.b.a */
public final class C2698a<T> {

    /* renamed from: a */
    private static final C2698a<?> f6012a = new C2698a<>();

    /* renamed from: b */
    private final T f6013b;

    private C2698a() {
        this.f6013b = null;
    }

    private C2698a(T t) {
        if (t != null) {
            this.f6013b = t;
            return;
        }
        throw new NullPointerException("Optional of null value.");
    }

    /* renamed from: a */
    public static <T> C2698a<T> m6150a() {
        return f6012a;
    }

    /* renamed from: a */
    public static <T> C2698a<T> m6151a(T t) {
        return new C2698a<>(t);
    }

    /* renamed from: b */
    public static <T> C2698a<T> m6152b(T t) {
        return t == null ? m6150a() : m6151a(t);
    }

    /* renamed from: b */
    public final T mo28992b() {
        T t = this.f6013b;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: c */
    public final T mo28993c(T t) {
        T t2 = this.f6013b;
        return t2 != null ? t2 : t;
    }

    /* renamed from: c */
    public final boolean mo28994c() {
        return this.f6013b != null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2698a)) {
            return false;
        }
        C2698a aVar = (C2698a) obj;
        T t = this.f6013b;
        T t2 = aVar.f6013b;
        return t == t2 || !(t == null || t2 == null || !t.equals(t2));
    }

    public final int hashCode() {
        T t = this.f6013b;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public final String toString() {
        T t = this.f6013b;
        if (t == null) {
            return "Optional.empty";
        }
        return String.format("Optional[%s]", new Object[]{t});
    }
}
