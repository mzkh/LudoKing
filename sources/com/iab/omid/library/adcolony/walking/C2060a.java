package com.iab.omid.library.adcolony.walking;

import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.adcolony.adsession.C2029a;
import com.iab.omid.library.adcolony.p026b.C2031a;
import com.iab.omid.library.adcolony.p028d.C2050f;
import com.iab.omid.library.adcolony.p029e.C2051a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.iab.omid.library.adcolony.walking.a */
public class C2060a {

    /* renamed from: a */
    private final HashMap<View, String> f4078a = new HashMap<>();

    /* renamed from: b */
    private final HashMap<View, ArrayList<String>> f4079b = new HashMap<>();

    /* renamed from: c */
    private final HashSet<View> f4080c = new HashSet<>();

    /* renamed from: d */
    private final HashSet<String> f4081d = new HashSet<>();

    /* renamed from: e */
    private final HashSet<String> f4082e = new HashSet<>();

    /* renamed from: f */
    private boolean f4083f;

    /* renamed from: a */
    private void m3898a(View view, C2029a aVar) {
        ArrayList arrayList = (ArrayList) this.f4079b.get(view);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f4079b.put(view, arrayList);
        }
        arrayList.add(aVar.getAdSessionId());
    }

    /* renamed from: a */
    private void m3899a(C2029a aVar) {
        for (C2051a aVar2 : aVar.mo27365a()) {
            View view = (View) aVar2.get();
            if (view != null) {
                m3898a(view, aVar);
            }
        }
    }

    /* renamed from: d */
    private boolean m3900d(View view) {
        if (!view.hasWindowFocus()) {
            return false;
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            if (!C2050f.m3854d(view)) {
                return false;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f4080c.addAll(hashSet);
        return true;
    }

    /* renamed from: a */
    public String mo27464a(View view) {
        if (this.f4078a.size() == 0) {
            return null;
        }
        String str = (String) this.f4078a.get(view);
        if (str != null) {
            this.f4078a.remove(view);
        }
        return str;
    }

    /* renamed from: a */
    public HashSet<String> mo27465a() {
        return this.f4081d;
    }

    /* renamed from: b */
    public ArrayList<String> mo27466b(View view) {
        if (this.f4079b.size() == 0) {
            return null;
        }
        ArrayList<String> arrayList = (ArrayList) this.f4079b.get(view);
        if (arrayList != null) {
            this.f4079b.remove(view);
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    /* renamed from: b */
    public HashSet<String> mo27467b() {
        return this.f4082e;
    }

    /* renamed from: c */
    public C2070c mo27468c(View view) {
        if (this.f4080c.contains(view)) {
            return C2070c.PARENT_VIEW;
        }
        return this.f4083f ? C2070c.OBSTRUCTION_VIEW : C2070c.UNDERLYING_VIEW;
    }

    /* renamed from: c */
    public void mo27469c() {
        C2031a a = C2031a.m3760a();
        if (a != null) {
            for (C2029a aVar : a.mo27394c()) {
                View c = aVar.mo27367c();
                if (aVar.mo27368d()) {
                    if (c == null || !m3900d(c)) {
                        this.f4082e.add(aVar.getAdSessionId());
                    } else {
                        this.f4081d.add(aVar.getAdSessionId());
                        this.f4078a.put(c, aVar.getAdSessionId());
                        m3899a(aVar);
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void mo27470d() {
        this.f4078a.clear();
        this.f4079b.clear();
        this.f4080c.clear();
        this.f4081d.clear();
        this.f4082e.clear();
        this.f4083f = false;
    }

    /* renamed from: e */
    public void mo27471e() {
        this.f4083f = true;
    }
}
