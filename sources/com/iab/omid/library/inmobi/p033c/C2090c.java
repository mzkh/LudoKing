package com.iab.omid.library.inmobi.p033c;

import android.view.View;
import androidx.annotation.NonNull;
import com.iab.omid.library.inmobi.adsession.C2077a;
import com.iab.omid.library.inmobi.p032b.C2079a;
import com.iab.omid.library.inmobi.p033c.C2087a.C2088a;
import com.iab.omid.library.inmobi.p034d.C2093b;
import com.iab.omid.library.inmobi.p034d.C2098f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.inmobi.c.c */
public class C2090c implements C2087a {

    /* renamed from: a */
    private final C2087a f4145a;

    public C2090c(C2087a aVar) {
        this.f4145a = aVar;
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    /* renamed from: a */
    public ArrayList<View> mo27593a() {
        ArrayList<View> arrayList = new ArrayList<>();
        C2079a a = C2079a.m3964a();
        if (a != null) {
            Collection<C2077a> c = a.mo27557c();
            IdentityHashMap identityHashMap = new IdentityHashMap((c.size() * 2) + 3);
            for (C2077a c2 : c) {
                View c3 = c2.mo27530c();
                if (c3 != null && C2098f.m4059c(c3)) {
                    View rootView = c3.getRootView();
                    if (rootView != null && !identityHashMap.containsKey(rootView)) {
                        identityHashMap.put(rootView, rootView);
                        float a2 = C2098f.m4057a(rootView);
                        int size = arrayList.size();
                        while (size > 0 && C2098f.m4057a((View) arrayList.get(size - 1)) > a2) {
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
    public JSONObject mo27588a(View view) {
        return C2093b.m4026a(0, 0, 0, 0);
    }

    /* renamed from: a */
    public void mo27589a(View view, JSONObject jSONObject, C2088a aVar, boolean z) {
        Iterator it = mo27593a().iterator();
        while (it.hasNext()) {
            aVar.mo27590a((View) it.next(), this.f4145a, jSONObject);
        }
    }
}
