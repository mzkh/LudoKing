package com.tapjoy.internal;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import java.util.Collections;

/* renamed from: com.tapjoy.internal.de */
public final class C2945de {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f */
    private static C2945de f6802f = new C2945de();

    /* renamed from: a */
    public Context f6803a;

    /* renamed from: b */
    public BroadcastReceiver f6804b;

    /* renamed from: c */
    public boolean f6805c;

    /* renamed from: d */
    public boolean f6806d;

    /* renamed from: e */
    public C2947a f6807e;

    /* renamed from: com.tapjoy.internal.de$a */
    public interface C2947a {
        /* renamed from: a */
        void mo29946a(boolean z);
    }

    private C2945de() {
    }

    /* renamed from: a */
    public static C2945de m6720a() {
        return f6802f;
    }

    /* renamed from: b */
    public final boolean mo29943b() {
        return !this.f6806d;
    }

    /* renamed from: c */
    public final void mo29944c() {
        boolean z = !this.f6806d;
        for (C2940cz czVar : Collections.unmodifiableCollection(C2944dd.m6718a().f6800a)) {
            C2964ds dsVar = czVar.f6781c;
            if (dsVar.f6830a.get() != null) {
                C2949dg.m6726a().mo29948a(dsVar.mo29961c(), "setState", z ? "foregrounded" : "backgrounded");
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m6721a(C2945de deVar, boolean z) {
        if (deVar.f6806d != z) {
            deVar.f6806d = z;
            if (deVar.f6805c) {
                deVar.mo29944c();
                C2947a aVar = deVar.f6807e;
                if (aVar != null) {
                    aVar.mo29946a(deVar.mo29943b());
                }
            }
        }
    }
}
