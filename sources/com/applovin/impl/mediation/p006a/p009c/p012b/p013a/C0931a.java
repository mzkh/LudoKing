package com.applovin.impl.mediation.p006a.p009c.p012b.p013a;

import android.text.SpannedString;
import com.applovin.impl.mediation.p006a.p007a.C0911b;
import com.applovin.impl.mediation.p006a.p007a.C0911b.C0912a;

/* renamed from: com.applovin.impl.mediation.a.c.b.a.a */
public class C0931a extends C0911b {

    /* renamed from: d */
    final String f1752d;

    /* renamed from: e */
    final int f1753e;

    /* renamed from: f */
    final int f1754f;

    /* renamed from: g */
    final boolean f1755g;

    /* renamed from: com.applovin.impl.mediation.a.c.b.a.a$a */
    public static class C0933a {

        /* renamed from: a */
        SpannedString f1756a;

        /* renamed from: b */
        SpannedString f1757b;

        /* renamed from: c */
        String f1758c;

        /* renamed from: d */
        C0912a f1759d = C0912a.DETAIL;

        /* renamed from: e */
        int f1760e;

        /* renamed from: f */
        int f1761f;

        /* renamed from: g */
        boolean f1762g = false;

        /* renamed from: a */
        public C0933a mo9371a(int i) {
            this.f1760e = i;
            return this;
        }

        /* renamed from: a */
        public C0933a mo9372a(SpannedString spannedString) {
            this.f1757b = spannedString;
            return this;
        }

        /* renamed from: a */
        public C0933a mo9373a(C0912a aVar) {
            this.f1759d = aVar;
            return this;
        }

        /* renamed from: a */
        public C0933a mo9374a(String str) {
            this.f1756a = new SpannedString(str);
            return this;
        }

        /* renamed from: a */
        public C0933a mo9375a(boolean z) {
            this.f1762g = z;
            return this;
        }

        /* renamed from: a */
        public C0931a mo9376a() {
            return new C0931a(this);
        }

        /* renamed from: b */
        public C0933a mo9377b(int i) {
            this.f1761f = i;
            return this;
        }

        /* renamed from: b */
        public C0933a mo9378b(String str) {
            return mo9372a(new SpannedString(str));
        }

        /* renamed from: c */
        public C0933a mo9379c(String str) {
            this.f1758c = str;
            return this;
        }
    }

    private C0931a(C0933a aVar) {
        super(aVar.f1759d);
        this.f1695b = aVar.f1756a;
        this.f1696c = aVar.f1757b;
        this.f1752d = aVar.f1758c;
        this.f1753e = aVar.f1760e;
        this.f1754f = aVar.f1761f;
        this.f1755g = aVar.f1762g;
    }

    /* renamed from: j */
    public static C0933a m1501j() {
        return new C0933a();
    }

    /* renamed from: b */
    public boolean mo9311b() {
        return this.f1755g;
    }

    /* renamed from: g */
    public int mo9316g() {
        return this.f1753e;
    }

    /* renamed from: h */
    public int mo9317h() {
        return this.f1754f;
    }

    /* renamed from: i */
    public String mo9369i() {
        return this.f1752d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NetworkDetailListItemViewModel{text=");
        sb.append(this.f1695b);
        sb.append(", detailText=");
        sb.append(this.f1695b);
        sb.append("}");
        return sb.toString();
    }
}
