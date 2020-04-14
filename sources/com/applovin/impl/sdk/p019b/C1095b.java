package com.applovin.impl.sdk.p019b;

import com.applovin.mediation.adapters.AppLovinMediationAdapter;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.b.b */
public class C1095b<T> extends C1096c<T> {

    /* renamed from: A */
    public static final C1096c<Long> f2233A = m2127a("fullscreen_display_delay_ms", Long.valueOf(600));

    /* renamed from: B */
    public static final C1096c<Long> f2234B = m2127a("ahdm", Long.valueOf(500));

    /* renamed from: C */
    public static final C1096c<Long> f2235C = m2127a("ad_view_refresh_precache_request_viewability_undesired_flags", Long.valueOf(118));

    /* renamed from: D */
    public static final C1096c<Long> f2236D = m2127a("ad_view_refresh_precache_request_delay_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(2)));

    /* renamed from: E */
    public static final C1096c<Boolean> f2237E;

    /* renamed from: F */
    public static final C1096c<Boolean> f2238F;

    /* renamed from: G */
    public static final C1096c<Long> f2239G = m2127a("ad_expiration_ms", Long.valueOf(TimeUnit.HOURS.toMillis(4)));

    /* renamed from: H */
    public static final C1096c<Boolean> f2240H;

    /* renamed from: I */
    public static final C1096c<Boolean> f2241I;

    /* renamed from: J */
    public static final C1096c<Long> f2242J = m2127a("ad_hidden_timeout_ms", Long.valueOf(-1));

    /* renamed from: K */
    public static final C1096c<Boolean> f2243K;

    /* renamed from: L */
    public static final C1096c<Long> f2244L = m2127a("ad_hidden_on_ad_dismiss_callback_delay_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: M */
    public static final C1096c<Boolean> f2245M;

    /* renamed from: N */
    public static final C1096c<String> f2246N;

    /* renamed from: O */
    public static final C1096c<String> f2247O;

    /* renamed from: P */
    public static final C1096c<String> f2248P = m2127a("faespcn", AppLovinMediationAdapter.class.getName());

    /* renamed from: Q */
    public static final C1096c<Long> f2249Q = m2127a("fard_s", Long.valueOf(3));

    /* renamed from: a */
    public static final C1096c<String> f2250a;

    /* renamed from: b */
    public static final C1096c<Long> f2251b = m2127a("afi_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(5)));

    /* renamed from: c */
    public static final C1096c<String> f2252c = m2127a("mediation_endpoint", "https://ms.applovin.com/");

    /* renamed from: d */
    public static final C1096c<String> f2253d = m2127a("mediation_backup_endpoint", "https://ms.applvn.com/");

    /* renamed from: e */
    public static final C1096c<Long> f2254e = m2127a("fetch_next_ad_retry_delay_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(2)));

    /* renamed from: f */
    public static final C1096c<Long> f2255f = m2127a("fetch_next_ad_timeout_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(5)));

    /* renamed from: g */
    public static final C1096c<Long> f2256g = m2127a("fetch_mediation_debugger_info_timeout_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(7)));

    /* renamed from: h */
    public static final C1096c<Boolean> f2257h;

    /* renamed from: i */
    public static final C1096c<String> f2258i = m2127a("postback_macros", "{\"{MCODE}\":\"mcode\",\"{BCODE}\":\"bcode\",\"{ICODE}\":\"icode\",\"{SCODE}\":\"scode\"}");

    /* renamed from: j */
    public static final C1096c<Boolean> f2259j;

    /* renamed from: k */
    public static final C1096c<Long> f2260k = m2127a("max_signal_provider_latency_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: l */
    public static final C1096c<Integer> f2261l;

    /* renamed from: m */
    public static final C1096c<Integer> f2262m;

    /* renamed from: n */
    public static final C1096c<Integer> f2263n = m2127a("max_adapter_signal_length", Integer.valueOf(5120));

    /* renamed from: o */
    public static final C1096c<Long> f2264o = m2127a("default_adapter_timeout_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: p */
    public static final C1096c<Integer> f2265p;

    /* renamed from: q */
    public static final C1096c<Integer> f2266q;

    /* renamed from: r */
    public static final C1096c<Long> f2267r = m2127a("ad_refresh_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: s */
    public static final C1096c<Long> f2268s = m2127a("ad_load_failure_refresh_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: t */
    public static final C1096c<String> f2269t = m2127a("ad_load_failure_refresh_ignore_error_codes", "204");

    /* renamed from: u */
    public static final C1096c<Long> f2270u = m2127a("refresh_ad_on_app_resume_elapsed_threshold_ms", Long.valueOf(0));

    /* renamed from: v */
    public static final C1096c<Boolean> f2271v;

    /* renamed from: w */
    public static final C1096c<Boolean> f2272w;

    /* renamed from: x */
    public static final C1096c<Boolean> f2273x;

    /* renamed from: y */
    public static final C1096c<Long> f2274y;

    /* renamed from: z */
    public static final C1096c<Long> f2275z;

    static {
        String str = "";
        f2250a = m2127a("afi", str);
        Boolean valueOf = Boolean.valueOf(true);
        f2257h = m2127a("pass_extra_parameters", valueOf);
        Boolean valueOf2 = Boolean.valueOf(false);
        f2259j = m2127a("persistent_mediated_postbacks", valueOf2);
        Integer valueOf3 = Integer.valueOf(20);
        f2261l = m2127a("max_adapter_version_length", valueOf3);
        f2262m = m2127a("max_adapter_sdk_version_length", valueOf3);
        Integer valueOf4 = Integer.valueOf(-2);
        f2265p = m2127a("default_ad_view_width", valueOf4);
        f2266q = m2127a("default_ad_view_height", valueOf4);
        f2271v = m2127a("refresh_ad_view_timer_responds_to_background", valueOf);
        f2272w = m2127a("refresh_ad_view_timer_responds_to_store_kit", valueOf);
        f2273x = m2127a("refresh_ad_view_timer_responds_to_window_visibility_changed", valueOf2);
        Long valueOf5 = Long.valueOf(150);
        f2274y = m2127a("ad_view_fade_in_animation_ms", valueOf5);
        f2275z = m2127a("ad_view_fade_out_animation_ms", valueOf5);
        f2237E = m2127a("ad_view_block_publisher_load_if_refresh_scheduled", valueOf);
        f2238F = m2127a("fullscreen_ads_block_publisher_load_if_another_showing", valueOf);
        f2240H = m2127a("saewib", valueOf2);
        f2241I = m2127a("utaoae", valueOf2);
        f2243K = m2127a("schedule_ad_hidden_on_ad_dismiss", valueOf2);
        f2245M = m2127a("proe", valueOf2);
        f2246N = m2127a("fitaui", str);
        f2247O = m2127a("finaui", str);
    }
}
