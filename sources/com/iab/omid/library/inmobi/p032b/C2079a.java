package com.iab.omid.library.inmobi.p032b;

import com.iab.omid.library.inmobi.adsession.C2077a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.iab.omid.library.inmobi.b.a */
public class C2079a {

    /* renamed from: a */
    private static C2079a f4121a = new C2079a();

    /* renamed from: b */
    private final ArrayList<C2077a> f4122b = new ArrayList<>();

    /* renamed from: c */
    private final ArrayList<C2077a> f4123c = new ArrayList<>();

    private C2079a() {
    }

    /* renamed from: a */
    public static C2079a m3964a() {
        return f4121a;
    }

    /* renamed from: a */
    public void mo27554a(C2077a aVar) {
        this.f4122b.add(aVar);
    }

    /* renamed from: b */
    public Collection<C2077a> mo27555b() {
        return Collections.unmodifiableCollection(this.f4122b);
    }

    /* renamed from: b */
    public void mo27556b(C2077a aVar) {
        boolean d = mo27559d();
        this.f4123c.add(aVar);
        if (!d) {
            C2086e.m4001a().mo27585b();
        }
    }

    /* renamed from: c */
    public Collection<C2077a> mo27557c() {
        return Collections.unmodifiableCollection(this.f4123c);
    }

    /* renamed from: c */
    public void mo27558c(C2077a aVar) {
        boolean d = mo27559d();
        this.f4122b.remove(aVar);
        this.f4123c.remove(aVar);
        if (d && !mo27559d()) {
            C2086e.m4001a().mo27586c();
        }
    }

    /* renamed from: d */
    public boolean mo27559d() {
        return this.f4123c.size() > 0;
    }
}
