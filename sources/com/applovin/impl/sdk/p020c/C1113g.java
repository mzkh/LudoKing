package com.applovin.impl.sdk.p020c;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.c.g */
public class C1113g {

    /* renamed from: a */
    public static final C1113g f2656a = m2246a("ad_req");

    /* renamed from: b */
    public static final C1113g f2657b = m2246a("ad_imp");

    /* renamed from: c */
    public static final C1113g f2658c = m2246a("ad_session_start");

    /* renamed from: d */
    public static final C1113g f2659d = m2246a("ad_imp_session");

    /* renamed from: e */
    public static final C1113g f2660e = m2246a("cached_files_expired");

    /* renamed from: f */
    public static final C1113g f2661f = m2246a("cache_drop_count");

    /* renamed from: g */
    public static final C1113g f2662g = m2247a("sdk_reset_state_count", true);

    /* renamed from: h */
    public static final C1113g f2663h = m2247a("ad_response_process_failures", true);

    /* renamed from: i */
    public static final C1113g f2664i = m2247a("response_process_failures", true);

    /* renamed from: j */
    public static final C1113g f2665j = m2247a("incent_failed_to_display_count", true);

    /* renamed from: k */
    public static final C1113g f2666k = m2246a("app_paused_and_resumed");

    /* renamed from: l */
    public static final C1113g f2667l = m2247a("ad_rendered_with_mismatched_sdk_key", true);

    /* renamed from: m */
    public static final C1113g f2668m = m2246a("med_ad_req");

    /* renamed from: n */
    public static final C1113g f2669n = m2247a("med_ad_response_process_failures", true);

    /* renamed from: o */
    public static final C1113g f2670o = m2247a("med_adapters_failed_init_missing_activity", true);

    /* renamed from: p */
    public static final C1113g f2671p = m2247a("med_waterfall_ad_no_fill", true);

    /* renamed from: q */
    public static final C1113g f2672q = m2247a("med_waterfall_ad_adapter_load_failed", true);

    /* renamed from: r */
    public static final C1113g f2673r = m2247a("med_waterfall_ad_invalid_response", true);

    /* renamed from: s */
    private static final Set<String> f2674s = new HashSet(32);

    /* renamed from: u */
    private static final Set<C1113g> f2675u = new HashSet(16);

    /* renamed from: t */
    private final String f2676t;

    static {
        m2246a("fullscreen_ad_nil_vc_count");
        m2246a("applovin_bundle_missing");
    }

    private C1113g(String str) {
        this.f2676t = str;
    }

    /* renamed from: a */
    private static C1113g m2246a(String str) {
        return m2247a(str, false);
    }

    /* renamed from: a */
    private static C1113g m2247a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No key name specified");
        } else if (!f2674s.contains(str)) {
            f2674s.add(str);
            C1113g gVar = new C1113g(str);
            if (z) {
                f2675u.add(gVar);
            }
            return gVar;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Key has already been used: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: b */
    public static Set<C1113g> m2248b() {
        return f2675u;
    }

    /* renamed from: a */
    public String mo10035a() {
        return this.f2676t;
    }
}
