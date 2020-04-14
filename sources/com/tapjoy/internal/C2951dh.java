package com.tapjoy.internal;

import com.tapjoy.internal.C2945de.C2947a;
import java.util.Collections;

/* renamed from: com.tapjoy.internal.dh */
public final class C2951dh implements C2929co, C2947a {

    /* renamed from: c */
    private static C2951dh f6815c;

    /* renamed from: a */
    public float f6816a = 0.0f;

    /* renamed from: b */
    public C2930cp f6817b;

    /* renamed from: d */
    private final C2931cq f6818d;

    /* renamed from: e */
    private final C2928cn f6819e;

    /* renamed from: f */
    private C2944dd f6820f;

    private C2951dh(C2931cq cqVar, C2928cn cnVar) {
        this.f6818d = cqVar;
        this.f6819e = cnVar;
    }

    /* renamed from: a */
    public static C2951dh m6732a() {
        if (f6815c == null) {
            f6815c = new C2951dh(new C2931cq(), new C2928cn());
        }
        return f6815c;
    }

    /* renamed from: a */
    public final void mo29946a(boolean z) {
        if (z) {
            C2969dv.m6771a();
            C2969dv.m6775b();
            return;
        }
        C2969dv.m6771a();
        C2969dv.m6777c();
    }

    /* renamed from: a */
    public final void mo29916a(float f) {
        this.f6816a = f;
        if (this.f6820f == null) {
            this.f6820f = C2944dd.m6718a();
        }
        for (C2940cz czVar : Collections.unmodifiableCollection(this.f6820f.f6801b)) {
            czVar.f6781c.mo29955a(f);
        }
    }
}
