package com.applovin.impl.mediation.p006a.p007a;

import android.text.SpannedString;
import androidx.core.view.ViewCompat;
import com.applovin.sdk.C1314R;

/* renamed from: com.applovin.impl.mediation.a.a.b */
public abstract class C0911b {

    /* renamed from: a */
    protected C0912a f1694a;

    /* renamed from: b */
    protected SpannedString f1695b;

    /* renamed from: c */
    protected SpannedString f1696c;

    /* renamed from: com.applovin.impl.mediation.a.a.b$a */
    public enum C0912a {
        SECTION(0),
        SIMPLE(1),
        DETAIL(2),
        RIGHT_DETAIL(3),
        COUNT(4);
        

        /* renamed from: f */
        private final int f1703f;

        private C0912a(int i) {
            this.f1703f = i;
        }

        /* renamed from: a */
        public int mo9318a() {
            return this.f1703f;
        }

        /* renamed from: b */
        public int mo9319b() {
            if (this == SECTION) {
                return C1314R.layout.list_section;
            }
            if (this == SIMPLE) {
                return 17367043;
            }
            return this == DETAIL ? C1314R.layout.list_item_detail : C1314R.layout.list_item_right_detail;
        }
    }

    public C0911b(C0912a aVar) {
        this.f1694a = aVar;
    }

    /* renamed from: a */
    public static int m1442a() {
        return C0912a.COUNT.mo9318a();
    }

    /* renamed from: b */
    public boolean mo9311b() {
        return false;
    }

    /* renamed from: c */
    public SpannedString mo9312c() {
        return this.f1695b;
    }

    /* renamed from: d */
    public SpannedString mo9313d() {
        return this.f1696c;
    }

    /* renamed from: e */
    public int mo9314e() {
        return this.f1694a.mo9318a();
    }

    /* renamed from: f */
    public int mo9315f() {
        return this.f1694a.mo9319b();
    }

    /* renamed from: g */
    public int mo9316g() {
        return 0;
    }

    /* renamed from: h */
    public int mo9317h() {
        return ViewCompat.MEASURED_STATE_MASK;
    }
}
