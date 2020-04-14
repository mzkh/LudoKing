package com.iab.omid.library.adcolony.p027c;

import android.view.View;
import androidx.annotation.NonNull;
import com.iab.omid.library.adcolony.adsession.C2029a;
import com.iab.omid.library.adcolony.p026b.C2031a;
import com.iab.omid.library.adcolony.p027c.C2039a.C2040a;
import com.iab.omid.library.adcolony.p028d.C2045b;
import com.iab.omid.library.adcolony.p028d.C2050f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.c.c */
public class C2042c implements C2039a {

    /* renamed from: a */
    private final C2039a f4045a;

    public C2042c(C2039a aVar) {
        this.f4045a = aVar;
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    /* renamed from: a */
    public ArrayList<View> mo27429a() {
        ArrayList<View> arrayList = new ArrayList<>();
        C2031a a = C2031a.m3760a();
        if (a != null) {
            Collection<C2029a> c = a.mo27394c();
            IdentityHashMap identityHashMap = new IdentityHashMap((c.size() * 2) + 3);
            for (C2029a c2 : c) {
                View c3 = c2.mo27367c();
                if (c3 != null && C2050f.m3853c(c3)) {
                    View rootView = c3.getRootView();
                    if (rootView != null && !identityHashMap.containsKey(rootView)) {
                        identityHashMap.put(rootView, rootView);
                        float a2 = C2050f.m3851a(rootView);
                        int size = arrayList.size();
                        while (size > 0 && C2050f.m3851a((View) arrayList.get(size - 1)) > a2) {
                            size--;
                        }
                        arrayList.add(size, rootView);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public JSONObject mo27425a(View view) {
        return C2045b.m3821a(0, 0, 0, 0);
    }

    /* renamed from: a */
    public void mo27426a(View view, JSONObject jSONObject, C2040a aVar, boolean z) {
        Iterator it = mo27429a().iterator();
        while (it.hasNext()) {
            aVar.mo27427a((View) it.next(), this.f4045a, jSONObject);
        }
    }
}
