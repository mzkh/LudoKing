package com.tapjoy.internal;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import com.tapjoy.internal.C2952di.C2953a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.dl */
public final class C2956dl implements C2952di {

    /* renamed from: a */
    private final int[] f6824a = new int[2];

    /* renamed from: a */
    public final JSONObject mo29951a(View view) {
        if (view == null) {
            return C2957dm.m6742a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f6824a);
        int[] iArr = this.f6824a;
        return C2957dm.m6742a(iArr[0], iArr[1], width, height);
    }

    /* renamed from: a */
    public final void mo29952a(View view, JSONObject jSONObject, C2953a aVar, boolean z) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            if (!z || VERSION.SDK_INT < 21) {
                while (i < viewGroup.getChildCount()) {
                    aVar.mo29953a(viewGroup.getChildAt(i), this, jSONObject);
                    i++;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            while (i < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i);
                ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
                }
                arrayList.add(childAt);
                i++;
            }
            ArrayList arrayList2 = new ArrayList(hashMap.keySet());
            Collections.sort(arrayList2);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((ArrayList) hashMap.get((Float) it.next())).iterator();
                while (it2.hasNext()) {
                    aVar.mo29953a((View) it2.next(), this, jSONObject);
                }
            }
        }
    }
}
