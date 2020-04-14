package com.tapjoy.internal;

import android.view.View;
import com.tapjoy.internal.C2952di.C2953a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.dk */
public final class C2955dk implements C2952di {

    /* renamed from: a */
    private final C2952di f6823a;

    public C2955dk(C2952di diVar) {
        this.f6823a = diVar;
    }

    /* renamed from: a */
    public final JSONObject mo29951a(View view) {
        return C2957dm.m6742a(0, 0, 0, 0);
    }

    /* renamed from: a */
    public final void mo29952a(View view, JSONObject jSONObject, C2953a aVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        C2944dd a = C2944dd.m6718a();
        if (a != null) {
            Collection<C2940cz> unmodifiableCollection = Collections.unmodifiableCollection(a.f6801b);
            IdentityHashMap identityHashMap = new IdentityHashMap((unmodifiableCollection.size() * 2) + 3);
            for (C2940cz c : unmodifiableCollection) {
                View c2 = c.mo29926c();
                if (c2 != null && C2961dp.m6758b(c2)) {
                    View rootView = c2.getRootView();
                    if (rootView != null && !identityHashMap.containsKey(rootView)) {
                        identityHashMap.put(rootView, rootView);
                        float a2 = C2961dp.m6757a(rootView);
                        int size = arrayList.size();
                        while (size > 0 && C2961dp.m6757a((View) arrayList.get(size - 1)) > a2) {
                            size--;
                        }
                        arrayList.add(size, rootView);
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aVar.mo29953a((View) it.next(), this.f6823a, jSONObject);
        }
    }
}
