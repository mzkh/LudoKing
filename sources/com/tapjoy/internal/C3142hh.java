package com.tapjoy.internal;

import com.tapjoy.internal.C3181ij.C3182a;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tapjoy.internal.hh */
public final class C3142hh implements C2920cf {

    /* renamed from: a */
    public final C1831gz f7417a;

    /* renamed from: b */
    Set f7418b = null;

    /* renamed from: c */
    private final Map f7419c = Collections.synchronizedMap(new HashMap());

    /* renamed from: d */
    private final Map f7420d = C3231ju.m7503a();

    public C3142hh(C1831gz gzVar) {
        this.f7417a = gzVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void mo18135a(C1817ca caVar, C3182a aVar) {
        if (caVar instanceof C3181ij) {
            if (aVar.f7580b != null) {
                List list = aVar.f7580b;
                synchronized (this) {
                    this.f7418b = list instanceof Collection ? new HashSet(C3227js.m7501a(list)) : C3232jv.m7505a(list.iterator());
                }
            }
            C3181ij ijVar = (C3181ij) caVar;
            String str = ijVar.f7572c;
            boolean z = ijVar.f7573d;
            this.f7420d.remove(str);
            if (!z) {
                this.f7419c.put(str, aVar.f7579a);
            }
            C1837hg hgVar = aVar.f7579a;
            C3128ha haVar = this.f7417a.f3832p;
            if (hgVar instanceof C3141hf) {
                C3124gw.m7218a("No content for \"{}\"", str);
                haVar.mo29403a(str);
                return;
            }
            C3124gw.m7218a("New content for \"{}\" is ready", str);
            if (z) {
                hgVar.mo18173a(haVar, new C3085fw());
            } else {
                haVar.mo29406b(str);
            }
        } else {
            throw new IllegalStateException(caVar.getClass().getName());
        }
    }

    /* renamed from: a */
    public final void mo18134a(C1817ca caVar) {
        mo18135a(caVar, new C3182a(new C3141hf(), null));
    }
}
