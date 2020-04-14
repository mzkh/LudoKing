package com.adcolony.sdk;

import java.util.ArrayList;

/* renamed from: com.adcolony.sdk.as */
class C0542as {

    /* renamed from: a */
    C0496ak f390a;

    /* renamed from: b */
    C0763z f391b = new C0763z().mo8753b();

    /* renamed from: c */
    float[] f392c = new float[16];

    /* renamed from: d */
    C0763z f393d = new C0763z().mo8753b();

    /* renamed from: e */
    C0763z f394e = new C0763z().mo8753b();

    /* renamed from: f */
    C0763z f395f = new C0763z().mo8753b();

    /* renamed from: g */
    ArrayList<C0763z> f396g = new ArrayList<>();

    /* renamed from: h */
    ArrayList<C0763z> f397h = new ArrayList<>();

    /* renamed from: i */
    boolean f398i;

    /* renamed from: j */
    boolean f399j;

    /* renamed from: k */
    boolean f400k = true;

    C0542as(C0496ak akVar) {
        this.f390a = akVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8357a() {
        this.f390a.mo8286d();
        this.f394e.mo8753b();
        this.f398i = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8363b() {
        mo8357a();
        do {
        } while (mo8367d());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C0763z mo8366c() {
        int size = this.f397h.size();
        if (size == 0) {
            return new C0763z();
        }
        return (C0763z) this.f397h.remove(size - 1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo8367d() {
        int size = this.f396g.size();
        if (size == 0) {
            return false;
        }
        this.f390a.mo8286d();
        this.f399j = true;
        this.f397h.add(this.f396g.remove(size - 1));
        this.f394e.mo8753b();
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo8368e() {
        this.f390a.mo8286d();
        this.f396g.add(mo8366c().mo8757b(this.f394e));
        this.f394e.mo8753b();
        this.f399j = true;
        this.f398i = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8360a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10;
        double d11;
        boolean z;
        double d12 = d3;
        double d13 = d4;
        this.f390a.mo8286d();
        double d14 = d12 / d8;
        double d15 = d13 / d9;
        double d16 = 1.0d;
        boolean z2 = true;
        if (d14 >= 0.0d) {
            d11 = d14;
            d10 = 1.0d;
            z = false;
        } else {
            d11 = -d14;
            d10 = -1.0d;
            z = true;
        }
        if (d15 >= 0.0d) {
            z2 = false;
        } else {
            d15 = -d15;
            d16 = -1.0d;
        }
        double d17 = d5 * d12;
        double d18 = d6 * d13;
        if (z || z2) {
            d17 -= d12 / 2.0d;
            d18 -= d13 / 2.0d;
            mo8365b((-d12) / 2.0d, (-d13) / 2.0d);
        }
        double cos = Math.cos(d7);
        double sin = Math.sin(d7);
        double d19 = d17 * d11;
        double d20 = (d - (d19 * cos)) + (sin * d15 * d18);
        double d21 = d11 * sin * d10;
        double d22 = cos * d15;
        this.f394e.mo8747a(cos * d11 * d10, d21, 0.0d, 0.0d, (-sin) * d15 * d16, d22 * d16, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, d20, (d2 - (d19 * sin)) - (d22 * d18), 0.0d, 1.0d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8358a(double d) {
        this.f390a.mo8286d();
        this.f394e.mo8754b(d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8364b(double d) {
        this.f390a.mo8286d();
        this.f394e.mo8745a(d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8359a(double d, double d2) {
        this.f390a.mo8286d();
        this.f394e.mo8746a(d, d2, 1.0d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8361a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
        double d17 = d;
        double d18 = d2;
        double d19 = d3;
        double d20 = d4;
        double d21 = d5;
        double d22 = d6;
        double d23 = d7;
        double d24 = d8;
        double d25 = d9;
        double d26 = d10;
        double d27 = d11;
        double d28 = d12;
        double d29 = d13;
        double d30 = d14;
        double d31 = d15;
        double d32 = d16;
        this.f390a.mo8286d();
        this.f394e.mo8756b(d17, d18, d19, d20, d21, d22, d23, d24, d25, d26, d27, d28, d29, d30, d31, d32);
        this.f398i = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8362a(C0763z zVar) {
        this.f390a.mo8286d();
        this.f393d.mo8757b(zVar);
        this.f400k = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo8369f() {
        mo8363b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8365b(double d, double d2) {
        this.f394e.mo8755b(d, d2, 0.0d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo8370g() {
        if (this.f399j || this.f400k) {
            this.f400k = false;
            if (this.f399j) {
                this.f399j = false;
                this.f395f.mo8753b();
                for (int size = this.f396g.size() - 1; size >= 0; size--) {
                    this.f395f.mo8750a((C0763z) this.f396g.get(size));
                }
            }
            this.f391b.mo8753b();
            this.f391b.mo8750a(this.f394e);
            this.f391b.mo8750a(this.f395f);
            this.f391b.mo8750a(this.f393d);
            this.f391b.mo8752a(this.f392c);
        }
    }
}
