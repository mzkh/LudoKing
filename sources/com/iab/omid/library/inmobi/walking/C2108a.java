package com.iab.omid.library.inmobi.walking;

import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.inmobi.adsession.C2077a;
import com.iab.omid.library.inmobi.p032b.C2079a;
import com.iab.omid.library.inmobi.p034d.C2098f;
import com.iab.omid.library.inmobi.p035e.C2099a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.iab.omid.library.inmobi.walking.a */
public class C2108a {

    /* renamed from: a */
    private final HashMap<View, String> f4178a = new HashMap<>();

    /* renamed from: b */
    private final HashMap<String, View> f4179b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<View, ArrayList<String>> f4180c = new HashMap<>();

    /* renamed from: d */
    private final HashSet<View> f4181d = new HashSet<>();

    /* renamed from: e */
    private final HashSet<String> f4182e = new HashSet<>();

    /* renamed from: f */
    private final HashSet<String> f4183f = new HashSet<>();

    /* renamed from: g */
    private final HashMap<String, String> f4184g = new HashMap<>();

    /* renamed from: h */
    private boolean f4185h;

    /* renamed from: a */
    private void m4106a(View view, C2077a aVar) {
        ArrayList arrayList = (ArrayList) this.f4180c.get(view);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f4180c.put(view, arrayList);
        }
        arrayList.add(aVar.getAdSessionId());
    }

    /* renamed from: a */
    private void m4107a(C2077a aVar) {
        for (C2099a aVar2 : aVar.mo27528a()) {
            View view = (View) aVar2.get();
            if (view != null) {
                m4106a(view, aVar);
            }
        }
    }

    /* renamed from: d */
    private String m4108d(View view) {
        if (!view.hasWindowFocus()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String e = C2098f.m4061e(view);
            if (e != null) {
                return e;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f4181d.addAll(hashSet);
        return null;
    }

    /* renamed from: a */
    public String mo27628a(View view) {
        if (this.f4178a.size() == 0) {
            return null;
        }
        String str = (String) this.f4178a.get(view);
        if (str != null) {
            this.f4178a.remove(view);
        }
        return str;
    }

    /* renamed from: a */
    public String mo27629a(String str) {
        return (String) this.f4184g.get(str);
    }

    /* renamed from: a */
    public HashSet<String> mo27630a() {
        return this.f4182e;
    }

    /* renamed from: b */
    public View mo27631b(String str) {
        return (View) this.f4179b.get(str);
    }

    /* renamed from: b */
    public ArrayList<String> mo27632b(View view) {
        if (this.f4180c.size() == 0) {
            return null;
        }
        ArrayList<String> arrayList = (ArrayList) this.f4180c.get(view);
        if (arrayList != null) {
            this.f4180c.remove(view);
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    /* renamed from: b */
    public HashSet<String> mo27633b() {
        return this.f4183f;
    }

    /* renamed from: c */
    public C2118c mo27634c(View view) {
        return this.f4181d.contains(view) ? C2118c.PARENT_VIEW : this.f4185h ? C2118c.OBSTRUCTION_VIEW : C2118c.UNDERLYING_VIEW;
    }

    /* renamed from: c */
    public void mo27635c() {
        C2079a a = C2079a.m3964a();
        if (a != null) {
            for (C2077a aVar : a.mo27557c()) {
                View c = aVar.mo27530c();
                if (aVar.mo27531d()) {
                    String adSessionId = aVar.getAdSessionId();
                    if (c != null) {
                        String d = m4108d(c);
                        if (d == null) {
                            this.f4182e.add(adSessionId);
                            this.f4178a.put(c, adSessionId);
                            m4107a(aVar);
                        } else {
                            this.f4183f.add(adSessionId);
                            this.f4179b.put(adSessionId, c);
                            this.f4184g.put(adSessionId, d);
                        }
                    } else {
                        this.f4183f.add(adSessionId);
                        this.f4184g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void mo27636d() {
        this.f4178a.clear();
        this.f4179b.clear();
        this.f4180c.clear();
        this.f4181d.clear();
        this.f4182e.clear();
        this.f4183f.clear();
        this.f4184g.clear();
        this.f4185h = false;
    }

    /* renamed from: e */
    public void mo27637e() {
        this.f4185h = true;
    }
}
