package com.tapjoy.internal;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;

/* renamed from: com.tapjoy.internal.bh */
public final class C2895bh implements C2901bl {

    /* renamed from: a */
    private final StringWriter f6691a = new StringWriter();

    /* renamed from: b */
    private final C2909bt f6692b = new C2909bt(this.f6691a);

    public final String toString() {
        try {
            this.f6692b.f6734a.flush();
            return this.f6691a.toString();
        } catch (IOException e) {
            throw C1853jr.m3670a(e);
        }
    }

    /* renamed from: a */
    public final void mo29879a(Writer writer) {
        try {
            this.f6692b.f6734a.flush();
            writer.write(this.f6691a.toString());
        } catch (IOException e) {
            throw C1853jr.m3670a(e);
        }
    }

    /* renamed from: a */
    public final C2895bh mo29872a() {
        try {
            this.f6692b.mo29889a();
            return this;
        } catch (IOException e) {
            throw C1853jr.m3670a(e);
        }
    }

    /* renamed from: b */
    public final C2895bh mo29880b() {
        try {
            this.f6692b.mo29897b();
            return this;
        } catch (IOException e) {
            throw C1853jr.m3670a(e);
        }
    }

    /* renamed from: c */
    public final C2895bh mo29882c() {
        try {
            this.f6692b.mo29899c();
            return this;
        } catch (IOException e) {
            throw C1853jr.m3670a(e);
        }
    }

    /* renamed from: d */
    public final C2895bh mo29883d() {
        try {
            this.f6692b.mo29901d();
            return this;
        } catch (IOException e) {
            throw C1853jr.m3670a(e);
        }
    }

    /* renamed from: a */
    public final C2895bh mo29876a(String str) {
        try {
            this.f6692b.mo29894a(str);
            return this;
        } catch (IOException e) {
            throw C1853jr.m3670a(e);
        }
    }

    /* renamed from: a */
    public final C2895bh mo29874a(C2901bl blVar) {
        try {
            this.f6692b.mo29891a(blVar);
            return this;
        } catch (IOException e) {
            throw C1853jr.m3670a(e);
        }
    }

    /* renamed from: b */
    public final C2895bh mo29881b(String str) {
        try {
            this.f6692b.mo29898b(str);
            return this;
        } catch (IOException e) {
            throw C1853jr.m3670a(e);
        }
    }

    /* renamed from: a */
    public final C2895bh mo29873a(long j) {
        try {
            this.f6692b.mo29890a(j);
            return this;
        } catch (IOException e) {
            throw C1853jr.m3670a(e);
        }
    }

    /* renamed from: a */
    public final C2895bh mo29875a(Number number) {
        try {
            this.f6692b.mo29892a(number);
            return this;
        } catch (IOException e) {
            throw C1853jr.m3670a(e);
        }
    }

    /* renamed from: b */
    private C2895bh m6598b(Object obj) {
        try {
            this.f6692b.mo29893a(obj);
            return this;
        } catch (IOException e) {
            throw C1853jr.m3670a(e);
        }
    }

    /* renamed from: a */
    public final C2895bh mo29877a(Collection collection) {
        try {
            this.f6692b.mo29895a(collection);
            return this;
        } catch (IOException e) {
            throw C1853jr.m3670a(e);
        }
    }

    /* renamed from: a */
    public final C2895bh mo29878a(Map map) {
        try {
            this.f6692b.mo29896a(map);
            return this;
        } catch (IOException e) {
            throw C1853jr.m3670a(e);
        }
    }

    /* renamed from: a */
    public static String m6597a(Object obj) {
        return new C2895bh().m6598b(obj).toString();
    }
}
