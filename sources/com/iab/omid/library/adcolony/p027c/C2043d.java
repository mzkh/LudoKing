package com.iab.omid.library.adcolony.p027c;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.adcolony.p027c.C2039a.C2040a;
import com.iab.omid.library.adcolony.p028d.C2045b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.c.d */
public class C2043d implements C2039a {

    /* renamed from: a */
    private final int[] f4046a = new int[2];

    /* renamed from: a */
    private void m3812a(ViewGroup viewGroup, JSONObject jSONObject, C2040a aVar) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            aVar.mo27427a(viewGroup.getChildAt(i), this, jSONObject);
        }
    }

    @TargetApi(21)
    /* renamed from: b */
    private void m3813b(ViewGroup viewGroup, JSONObject jSONObject, C2040a aVar) {
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
                aVar.mo27427a((View) it2.next(), this, jSONObject);
            }
        }
    }

    /* renamed from: a */
    public JSONObject mo27425a(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f4046a);
        int[] iArr = this.f4046a;
        return C2045b.m3821a(iArr[0], iArr[1], width, height);
    }

    /* renamed from: a */
    public void mo27426a(View view, JSONObject jSONObject, C2040a aVar, boolean z) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || VERSION.SDK_INT < 21) {
                m3812a(viewGroup, jSONObject, aVar);
            } else {
                m3813b(viewGroup, jSONObject, aVar);
            }
        }
    }
}
