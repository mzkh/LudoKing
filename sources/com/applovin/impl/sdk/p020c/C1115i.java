package com.applovin.impl.sdk.p020c;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.c.i */
public class C1115i {

    /* renamed from: A */
    public static final C1115i f2679A = m2260a("aia");

    /* renamed from: B */
    public static final C1115i f2680B = m2260a("cs");

    /* renamed from: C */
    public static final C1115i f2681C = m2260a("fnma");

    /* renamed from: D */
    public static final C1115i f2682D = m2260a("lad");

    /* renamed from: E */
    public static final C1115i f2683E = m2260a("pmw");

    /* renamed from: F */
    public static final C1115i f2684F = m2260a("pnma");

    /* renamed from: G */
    public static final C1115i f2685G = m2260a("tma");

    /* renamed from: H */
    public static final C1115i f2686H = m2260a("tsc");

    /* renamed from: I */
    public static final C1115i f2687I = m2260a("fmp");

    /* renamed from: J */
    public static final C1115i f2688J = m2260a("fmdi");

    /* renamed from: K */
    public static final C1115i f2689K = m2260a("vmr");

    /* renamed from: L */
    public static final C1115i f2690L = m2260a("rmr");

    /* renamed from: N */
    private static final Set<String> f2691N = new HashSet(64);

    /* renamed from: a */
    public static final C1115i f2692a = m2260a("is");

    /* renamed from: b */
    public static final C1115i f2693b = m2260a("cai");

    /* renamed from: c */
    public static final C1115i f2694c = m2260a("dp");

    /* renamed from: d */
    public static final C1115i f2695d = m2260a("fbs");

    /* renamed from: e */
    public static final C1115i f2696e = m2260a("rr");

    /* renamed from: f */
    public static final C1115i f2697f = m2260a("rt");

    /* renamed from: g */
    public static final C1115i f2698g = m2260a("ito");

    /* renamed from: h */
    public static final C1115i f2699h = m2260a("asd");

    /* renamed from: i */
    public static final C1115i f2700i = m2260a("caa");

    /* renamed from: j */
    public static final C1115i f2701j = m2260a("cnai");

    /* renamed from: k */
    public static final C1115i f2702k = m2260a("cnav");

    /* renamed from: l */
    public static final C1115i f2703l = m2260a("cva");

    /* renamed from: m */
    public static final C1115i f2704m = m2260a("fma");

    /* renamed from: n */
    public static final C1115i f2705n = m2260a("fna");

    /* renamed from: o */
    public static final C1115i f2706o = m2260a("fnna");

    /* renamed from: p */
    public static final C1115i f2707p = m2260a("fta");

    /* renamed from: q */
    public static final C1115i f2708q = m2260a("fvs");

    /* renamed from: r */
    public static final C1115i f2709r = m2260a("par");

    /* renamed from: s */
    public static final C1115i f2710s = m2260a("psvr");

    /* renamed from: t */
    public static final C1115i f2711t = m2260a("pvwr");

    /* renamed from: u */
    public static final C1115i f2712u = m2260a("raa");

    /* renamed from: v */
    public static final C1115i f2713v = m2260a("rna");

    /* renamed from: w */
    public static final C1115i f2714w = m2260a("rva");

    /* renamed from: x */
    public static final C1115i f2715x = m2260a("rrwd");

    /* renamed from: y */
    public static final C1115i f2716y = m2260a("rvw");

    /* renamed from: z */
    public static final C1115i f2717z = m2260a("vr");

    /* renamed from: M */
    private final String f2718M;

    static {
        m2260a("das");
        m2260a("bt");
    }

    protected C1115i(String str) {
        this.f2718M = str;
    }

    /* renamed from: a */
    private static C1115i m2260a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No key name specified");
        } else if (!f2691N.contains(str)) {
            f2691N.add(str);
            return new C1115i(str);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Key has already been used: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    public String mo10045a() {
        return this.f2718M;
    }
}
