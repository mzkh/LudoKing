package com.tapjoy.internal;

import java.io.IOException;
import java.io.Serializable;

/* renamed from: com.tapjoy.internal.eh */
public abstract class C2988eh implements Serializable {

    /* renamed from: a */
    transient int f6893a = 0;

    /* renamed from: b */
    protected transient int f6894b = 0;

    /* renamed from: c */
    private final transient C2991ej f6895c;

    /* renamed from: d */
    private final transient C3197iu f6896d;

    /* renamed from: com.tapjoy.internal.eh$a */
    public static abstract class C2989a {

        /* renamed from: a */
        C3194ir f6897a;

        /* renamed from: b */
        C3008el f6898b;

        protected C2989a() {
        }

        /* renamed from: a */
        public final C2989a mo29986a(C3197iu iuVar) {
            if (iuVar.mo30308c() > 0) {
                if (this.f6898b == null) {
                    this.f6897a = new C3194ir();
                    this.f6898b = new C3008el(this.f6897a);
                }
                try {
                    this.f6898b.mo30004a(iuVar);
                } catch (IOException unused) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        /* renamed from: a */
        public final C2989a mo29985a(int i, C2986eg egVar, Object obj) {
            if (this.f6898b == null) {
                this.f6897a = new C3194ir();
                this.f6898b = new C3008el(this.f6897a);
            }
            try {
                egVar.mo29982a().mo29992a(this.f6898b, i, obj);
                return this;
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }

        /* renamed from: a */
        public final C3197iu mo29987a() {
            C3194ir irVar = this.f6897a;
            return irVar != null ? new C3197iu(irVar.clone().mo30298g()) : C3197iu.f7628b;
        }
    }

    protected C2988eh(C2991ej ejVar, C3197iu iuVar) {
        if (ejVar == null) {
            throw new NullPointerException("adapter == null");
        } else if (iuVar != null) {
            this.f6895c = ejVar;
            this.f6896d = iuVar;
        } else {
            throw new NullPointerException("unknownFields == null");
        }
    }

    /* renamed from: a */
    public final C3197iu mo29983a() {
        C3197iu iuVar = this.f6896d;
        if (iuVar != null) {
            return iuVar;
        }
        return C3197iu.f7628b;
    }

    public String toString() {
        return C2991ej.m6807c(this);
    }
}
