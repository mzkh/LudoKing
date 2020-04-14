package com.iab.omid.library.adcolony.p026b;

import com.iab.omid.library.adcolony.adsession.C2029a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.iab.omid.library.adcolony.b.a */
public class C2031a {

    /* renamed from: a */
    private static C2031a f4022a = new C2031a();

    /* renamed from: b */
    private final ArrayList<C2029a> f4023b = new ArrayList<>();

    /* renamed from: c */
    private final ArrayList<C2029a> f4024c = new ArrayList<>();

    private C2031a() {
    }

    /* renamed from: a */
    public static C2031a m3760a() {
        return f4022a;
    }

    /* renamed from: a */
    public void mo27391a(C2029a aVar) {
        this.f4023b.add(aVar);
    }

    /* renamed from: b */
    public Collection<C2029a> mo27392b() {
        return Collections.unmodifiableCollection(this.f4023b);
    }

    /* renamed from: b */
    public void mo27393b(C2029a aVar) {
        boolean d = mo27396d();
        this.f4024c.add(aVar);
        if (!d) {
            C2038e.m3797a().mo27422b();
        }
    }

    /* renamed from: c */
    public Collection<C2029a> mo27394c() {
        return Collections.unmodifiableCollection(this.f4024c);
    }

    /* renamed from: c */
    public void mo27395c(C2029a aVar) {
        boolean d = mo27396d();
        this.f4023b.remove(aVar);
        this.f4024c.remove(aVar);
        if (d && !mo27396d()) {
            C2038e.m3797a().mo27423c();
        }
    }

    /* renamed from: d */
    public boolean mo27396d() {
        return this.f4024c.size() > 0;
    }
}
