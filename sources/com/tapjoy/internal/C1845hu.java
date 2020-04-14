package com.tapjoy.internal;

import android.graphics.Point;
import android.os.SystemClock;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.hu */
public final class C1845hu extends C1844hq {

    /* renamed from: n */
    public static final C2896bi f3865n = new C2896bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18189a(C1812bn bnVar) {
            return new C1845hu(bnVar);
        }
    };
    @Nullable

    /* renamed from: a */
    public C3163hx f3866a;
    @Nullable

    /* renamed from: b */
    public C3163hx f3867b;

    /* renamed from: c */
    public C3163hx f3868c;
    @Nullable

    /* renamed from: d */
    public Point f3869d;
    @Nullable

    /* renamed from: e */
    public C3163hx f3870e;
    @Nullable

    /* renamed from: f */
    public C3163hx f3871f;

    /* renamed from: g */
    public String f3872g;
    @Nullable

    /* renamed from: h */
    public C1829gl f3873h;

    /* renamed from: i */
    public ArrayList f3874i = new ArrayList();

    /* renamed from: j */
    public ArrayList f3875j = new ArrayList();

    /* renamed from: k */
    public Map f3876k;

    /* renamed from: l */
    public long f3877l;
    @Nullable

    /* renamed from: m */
    public C3159hv f3878m;

    public C1845hu() {
    }

    C1845hu(C1812bn bnVar) {
        bnVar.mo18067h();
        String str = null;
        String str2 = null;
        while (bnVar.mo18069j()) {
            String l = bnVar.mo18071l();
            boolean equals = "frame".equals(l);
            String str3 = String.LANDSCAPE;
            String str4 = String.PORTRAIT;
            if (equals) {
                bnVar.mo18067h();
                while (bnVar.mo18069j()) {
                    String l2 = bnVar.mo18071l();
                    if (str4.equals(l2)) {
                        this.f3866a = (C3163hx) C3163hx.f7498e.mo18189a(bnVar);
                    } else if (str3.equals(l2)) {
                        this.f3867b = (C3163hx) C3163hx.f7498e.mo18189a(bnVar);
                    } else if ("close_button".equals(l2)) {
                        this.f3868c = (C3163hx) C3163hx.f7498e.mo18189a(bnVar);
                    } else if ("close_button_offset".equals(l2)) {
                        this.f3869d = (Point) C2897bj.f6693a.mo18189a(bnVar);
                    } else {
                        bnVar.mo18078s();
                    }
                }
                bnVar.mo18068i();
            } else if ("creative".equals(l)) {
                bnVar.mo18067h();
                while (bnVar.mo18069j()) {
                    String l3 = bnVar.mo18071l();
                    if (str4.equals(l3)) {
                        this.f3870e = (C3163hx) C3163hx.f7498e.mo18189a(bnVar);
                    } else if (str3.equals(l3)) {
                        this.f3871f = (C3163hx) C3163hx.f7498e.mo18189a(bnVar);
                    } else {
                        bnVar.mo18078s();
                    }
                }
                bnVar.mo18068i();
            } else if ("url".equals(l)) {
                this.f3872g = bnVar.mo18056b();
            } else if (C1843ho.m3639a(l)) {
                this.f3873h = C1843ho.m3638a(l, bnVar);
            } else if ("mappings".equals(l)) {
                bnVar.mo18067h();
                while (bnVar.mo18069j()) {
                    String l4 = bnVar.mo18071l();
                    if (str4.equals(l4)) {
                        bnVar.mo18053a((List) this.f3874i, C3153hs.f7471h);
                    } else if (str3.equals(l4)) {
                        bnVar.mo18053a((List) this.f3875j, C3153hs.f7471h);
                    } else {
                        bnVar.mo18078s();
                    }
                }
                bnVar.mo18068i();
            } else if ("meta".equals(l)) {
                this.f3876k = bnVar.mo18059d();
            } else if ("ttl".equals(l)) {
                this.f3877l = SystemClock.elapsedRealtime() + ((long) (bnVar.mo18075p() * 1000.0d));
            } else if ("no_more_today".equals(l)) {
                this.f3878m = (C3159hv) C3159hv.f7491d.mo18189a(bnVar);
            } else if ("ad_content".equals(l)) {
                str = bnVar.mo18056b();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l)) {
                str2 = bnVar.mo18056b();
            } else {
                bnVar.mo18078s();
            }
        }
        bnVar.mo18068i();
        if (this.f3872g == null) {
            this.f3872g = "";
        }
        ArrayList arrayList = this.f3874i;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C3153hs hsVar = (C3153hs) it.next();
                if (hsVar.f7477f == null) {
                    hsVar.f7477f = str;
                }
                if (hsVar.f7476e == null) {
                    hsVar.f7476e = str2;
                }
            }
        }
        ArrayList arrayList2 = this.f3875j;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                C3153hs hsVar2 = (C3153hs) it2.next();
                if (hsVar2.f7477f == null) {
                    hsVar2.f7477f = str;
                }
                if (hsVar2.f7476e == null) {
                    hsVar2.f7476e = str2;
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean mo18187a() {
        return (this.f3868c == null || this.f3866a == null || this.f3870e == null) ? false : true;
    }

    /* renamed from: b */
    public final boolean mo18188b() {
        return (this.f3868c == null || this.f3867b == null || this.f3871f == null) ? false : true;
    }
}
