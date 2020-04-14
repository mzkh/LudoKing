package com.tapjoy.internal;

import java.io.Writer;

/* renamed from: com.tapjoy.internal.bm */
public final class C2902bm implements C2901bl {

    /* renamed from: a */
    public final String f6696a;

    public C2902bm(String str) {
        this.f6696a = str;
    }

    /* renamed from: a */
    public final void mo29879a(Writer writer) {
        writer.write(this.f6696a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2902bm)) {
            return false;
        }
        return this.f6696a.equals(((C2902bm) obj).f6696a);
    }

    public final int hashCode() {
        return this.f6696a.hashCode();
    }

    public final String toString() {
        return this.f6696a;
    }
}
