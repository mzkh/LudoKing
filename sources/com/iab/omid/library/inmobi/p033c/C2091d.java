package com.iab.omid.library.inmobi.p033c;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.p033c.C2087a.C2088a;
import com.iab.omid.library.inmobi.p034d.C2093b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.inmobi.c.d */
public class C2091d implements C2087a {

    /* renamed from: a */
    private final int[] f4146a = new int[2];

    /* renamed from: a */
    private void m4017a(ViewGroup viewGroup, JSONObject jSONObject, C2088a aVar) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            aVar.mo27590a(viewGroup.getChildAt(i), this, jSONObject);
        }
    }

    @TargetApi(21)
    /* renamed from: b */
    private void m4018b(ViewGroup viewGroup, JSONObject jSONObject, C2088a aVar) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) hashMap.get((Float) it.next())).iterator();
            while (it2.hasNext()) {
                aVar.mo27590a((View) it2.next(), this, jSONObject);
            }
        }
    }

    /* renamed from: a */
    public JSONObject mo27588a(View view) {
        if (view == null) {
            return C2093b.m4026a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f4146a);
        int[] iArr = this.f4146a;
        return C2093b.m4026a(iArr[0], iArr[1], width, height);
    }

    /* renamed from: a */
    public void mo27589a(View view, JSONObject jSONObject, C2088a aVar, boolean z) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || VERSION.SDK_INT < 21) {
                m4017a(viewGroup, jSONObject, aVar);
            } else {
                m4018b(viewGroup, jSONObject, aVar);
            }
        }
    }
}
