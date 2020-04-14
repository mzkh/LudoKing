package com.tapjoy.internal;

import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.cc */
public final class C1818cc implements Runnable {

    /* renamed from: a */
    private final C1817ca f3780a;
    @Nullable

    /* renamed from: b */
    private final C2920cf f3781b;

    protected C1818cc(C1817ca caVar, @Nullable C2920cf cfVar) {
        this.f3780a = caVar;
        this.f3781b = cfVar;
    }

    public final void run() {
        try {
            Object f = this.f3780a.mo18087f();
            C2920cf cfVar = this.f3781b;
            if (cfVar != null && !(cfVar instanceof C2921cg)) {
                cfVar.mo18135a(this.f3780a, f);
            }
        } catch (Throwable unused) {
            C2920cf cfVar2 = this.f3781b;
            if (cfVar2 != null && !(cfVar2 instanceof C2921cg)) {
                cfVar2.mo18134a(this.f3780a);
            }
        }
    }
}
