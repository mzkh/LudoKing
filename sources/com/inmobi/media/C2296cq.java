package com.inmobi.media;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.inmobi.media.C2426eq.C2428b;
import com.inmobi.media.C2426eq.C2434h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.inmobi.media.cq */
/* compiled from: VastResponse */
public final class C2296cq implements C2297cr {

    /* renamed from: a */
    List<C2286cl> f4841a;

    /* renamed from: b */
    public String f4842b;

    /* renamed from: c */
    public String f4843c;

    /* renamed from: d */
    public List<C2234bo> f4844d;

    /* renamed from: e */
    public List<C2284ck> f4845e;

    /* renamed from: f */
    public int f4846f;

    /* renamed from: g */
    private String f4847g;

    /* renamed from: h */
    private C2284ck f4848h;

    /* renamed from: i */
    private C2434h f4849i;

    /* renamed from: j */
    private C2286cl f4850j;

    /* renamed from: a */
    private static boolean m4668a(double d, double d2, double d3) {
        return d3 > d && d3 <= d2;
    }

    public C2296cq(C2434h hVar) {
        this.f4850j = null;
        this.f4841a = new ArrayList();
        this.f4844d = new ArrayList();
        this.f4845e = new ArrayList();
        this.f4849i = hVar;
        this.f4846f = 0;
    }

    private C2296cq(List<C2234bo> list, C2434h hVar) {
        this(hVar);
        if (list.size() != 0) {
            this.f4844d = new ArrayList(list);
        }
    }

    public C2296cq(String str, String str2, String str3, List<C2234bo> list, List<C2284ck> list2, C2434h hVar) {
        this(list, hVar);
        if (list2.size() != 0) {
            this.f4845e = new ArrayList(list2);
        }
        this.f4847g = str;
        this.f4841a.add(new C2286cl(str));
        this.f4842b = str2;
        this.f4843c = str3;
    }

    @Nullable
    /* renamed from: a */
    public final String mo28135a() {
        return this.f4843c;
    }

    /* renamed from: b */
    public final String mo28138b() {
        C2286cl clVar;
        int i;
        String str = this.f4847g;
        if (str != null) {
            return str;
        }
        C2169am.m4358a();
        List f = C2169am.m4367f();
        C2286cl clVar2 = null;
        if (!f.isEmpty()) {
            Iterator it = this.f4841a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                clVar = (C2286cl) it.next();
                if (f.contains(clVar.f4805a)) {
                    break;
                }
            }
        }
        clVar = null;
        if (clVar != null) {
            this.f4850j = clVar;
            this.f4847g = clVar.f4805a;
            return this.f4847g;
        }
        double d = (double) this.f4849i.f5227b;
        Double.isNaN(d);
        double d2 = (d * 2.0d) / 1048576.0d;
        double d3 = (double) this.f4849i.f5228c;
        double d4 = 1.0d;
        Double.isNaN(d3);
        double d5 = (d3 * 1.0d) / 1048576.0d;
        for (C2286cl clVar3 : this.f4841a) {
            String[] split = this.f4842b.split(":");
            try {
                i = (Integer.parseInt(split[1]) * 60) + Integer.parseInt(split[2]);
            } catch (ArrayIndexOutOfBoundsException e) {
                i = 0;
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            }
            double d6 = (double) clVar3.f4806b;
            Double.isNaN(d6);
            double d7 = d6 * d4;
            double d8 = (double) i;
            Double.isNaN(d8);
            double d9 = (d7 * d8) / 8192.0d;
            clVar3.f4807c = d9;
            double d10 = d9;
            C2286cl clVar4 = clVar3;
            if (m4668a(0.0d, d2, d10)) {
                clVar = m4665a(clVar, clVar4, d10);
            } else {
                if (m4668a(d2, d5, d10)) {
                    clVar2 = m4669b(clVar2, clVar4, d10);
                }
            }
            d4 = 1.0d;
        }
        m4666a(clVar, clVar2);
        if (TextUtils.isEmpty(this.f4847g)) {
            C2428b bVar = this.f4849i.f5229d;
            if (bVar.f5193a || this.f4841a.size() == 0) {
                return this.f4847g;
            }
            CountDownLatch countDownLatch = new CountDownLatch(this.f4841a.size());
            try {
                m4667a(bVar, countDownLatch);
                countDownLatch.await((long) bVar.f5194b, TimeUnit.MILLISECONDS);
                for (C2286cl clVar5 : this.f4841a) {
                    double d11 = clVar5.f4807c;
                    double d12 = d11;
                    if (m4668a(0.0d, d2, d11)) {
                        clVar = m4665a(clVar, clVar5, d12);
                    } else {
                        if (m4668a(d2, d5, d12)) {
                            clVar2 = m4669b(clVar2, clVar5, d12);
                        }
                    }
                }
            } catch (Exception e2) {
                C2463fd.m5161a().mo28382a(new C2495fz(e2));
                for (C2286cl clVar6 : this.f4841a) {
                    double d13 = clVar6.f4807c;
                    double d14 = d13;
                    if (m4668a(0.0d, d2, d13)) {
                        clVar = m4665a(clVar, clVar6, d14);
                    } else {
                        if (m4668a(d2, d5, d14)) {
                            clVar2 = m4669b(clVar2, clVar6, d14);
                        }
                    }
                }
            } catch (Throwable th) {
                for (C2286cl clVar7 : this.f4841a) {
                    double d15 = clVar7.f4807c;
                    double d16 = d15;
                    if (m4668a(0.0d, d2, d15)) {
                        clVar = m4665a(clVar, clVar7, d16);
                    } else {
                        if (m4668a(d2, d5, d16)) {
                            clVar2 = m4669b(clVar2, clVar7, d16);
                        }
                    }
                }
                m4666a(clVar, clVar2);
                throw th;
            }
            m4666a(clVar, clVar2);
        }
        return this.f4847g;
    }

    /* renamed from: a */
    private void m4667a(C2428b bVar, CountDownLatch countDownLatch) {
        for (C2286cl cmVar : this.f4841a) {
            C2287cm cmVar2 = new C2287cm(cmVar, bVar.f5194b, countDownLatch);
            cmVar2.f4819c = SystemClock.elapsedRealtime();
            C2287cm.f4810d.execute(new Runnable() {
                public final void run() {
                    C2287cm cmVar;
                    try {
                        C2487fs a = new C2489fu(C2287cm.this.f4817a).mo28405a();
                        if (a == null) {
                            return;
                        }
                        if (a.mo28417a()) {
                            C2287cm.this.mo28128a(a);
                            return;
                        }
                        cmVar = C2287cm.this;
                        try {
                            C2566hi.m5571a().mo28564a(cmVar.f4817a.mo28416i());
                            C2566hi.m5571a().mo28565b(a.mo28421d());
                            C2566hi.m5571a().mo28566c(SystemClock.elapsedRealtime() - cmVar.f4819c);
                            if (cmVar.f4818b.get() != null) {
                                double d = (double) a.f5453b;
                                Double.isNaN(d);
                                ((C2286cl) cmVar.f4818b.get()).f4807c = (d * 1.0d) / 1048576.0d;
                            }
                            cmVar.mo28127a();
                        } catch (Exception e) {
                            C2463fd.m5161a().mo28382a(new C2495fz(e));
                            cmVar.mo28127a();
                        }
                    } catch (Exception unused) {
                        C2287cm.f4811e;
                        C2485fq fqVar = new C2485fq(-1, "Network request failed with unknown error");
                        C2487fs fsVar = new C2487fs();
                        fsVar.f5452a = fqVar;
                        C2287cm.this.mo28128a(fsVar);
                    } catch (Throwable th) {
                        cmVar.mo28127a();
                        throw th;
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m4666a(C2286cl clVar, C2286cl clVar2) {
        if (clVar != null) {
            this.f4850j = clVar;
            this.f4847g = clVar.f4805a;
            return;
        }
        if (clVar2 != null) {
            this.f4850j = clVar2;
            this.f4847g = clVar2.f4805a;
        }
    }

    /* renamed from: c */
    public final List<C2286cl> mo28139c() {
        return this.f4841a;
    }

    /* renamed from: d */
    public final List<C2234bo> mo28140d() {
        return this.f4844d;
    }

    /* renamed from: e */
    public final List<C2284ck> mo28141e() {
        return this.f4845e;
    }

    /* renamed from: a */
    public final void mo28137a(C2284ck ckVar) {
        this.f4848h = ckVar;
    }

    /* renamed from: f */
    public final C2284ck mo28142f() {
        return this.f4848h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28136a(C2234bo boVar) {
        this.f4844d.add(boVar);
    }

    /* renamed from: a */
    private static C2286cl m4665a(C2286cl clVar, C2286cl clVar2, double d) {
        return (clVar != null && d <= clVar.f4807c) ? clVar : clVar2;
    }

    /* renamed from: b */
    private static C2286cl m4669b(C2286cl clVar, C2286cl clVar2, double d) {
        return (clVar != null && d >= clVar.f4807c) ? clVar : clVar2;
    }
}
