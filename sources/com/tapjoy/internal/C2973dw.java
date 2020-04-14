package com.tapjoy.internal;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.tapjoy.internal.dw */
public final class C2973dw {

    /* renamed from: a */
    final HashMap f6856a = new HashMap();

    /* renamed from: b */
    final HashMap f6857b = new HashMap();

    /* renamed from: c */
    final HashMap f6858c = new HashMap();

    /* renamed from: d */
    final HashSet f6859d = new HashSet();

    /* renamed from: e */
    final HashSet f6860e = new HashSet();

    /* renamed from: f */
    final HashSet f6861f = new HashSet();

    /* renamed from: g */
    final HashMap f6862g = new HashMap();

    /* renamed from: h */
    boolean f6863h;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo29967a(C2940cz czVar) {
        for (C2962dq dqVar : czVar.f6780b) {
            View view = (View) dqVar.get();
            if (view != null) {
                ArrayList arrayList = (ArrayList) this.f6858c.get(view);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f6858c.put(view, arrayList);
                }
                arrayList.add(czVar.f6784f);
            }
        }
    }
}
