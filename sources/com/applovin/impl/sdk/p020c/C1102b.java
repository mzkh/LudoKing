package com.applovin.impl.sdk.p020c;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.c.b */
public class C1102b {

    /* renamed from: A */
    static final C1102b f2587A = m2180a("smwm", "AD_SHOWN_IN_MULTIWINDOW_MODE");

    /* renamed from: B */
    static final C1102b f2588B = m2180a("vssc", "VIDEO_STREAM_STALLED_COUNT");

    /* renamed from: C */
    public static final C1102b f2589C = m2180a("wvem", "WEB_VIEW_ERROR_MESSAGES");

    /* renamed from: D */
    public static final C1102b f2590D = m2180a("wvhec", "WEB_VIEW_HTTP_ERROR_COUNT");

    /* renamed from: E */
    public static final C1102b f2591E = m2180a("wvsem", "WEB_VIEW_SSL_ERROR_MESSAGES");

    /* renamed from: F */
    public static final C1102b f2592F = m2180a("wvruc", "WEB_VIEW_RENDERER_UNRESPONSIVE_COUNT");

    /* renamed from: I */
    private static final Set<String> f2593I = new HashSet(32);

    /* renamed from: a */
    static final C1102b f2594a = m2180a("sas", "AD_SOURCE");

    /* renamed from: b */
    static final C1102b f2595b = m2180a("srt", "AD_RENDER_TIME");

    /* renamed from: c */
    static final C1102b f2596c = m2180a("sft", "AD_FETCH_TIME");

    /* renamed from: d */
    static final C1102b f2597d = m2180a("sfs", "AD_FETCH_SIZE");

    /* renamed from: e */
    static final C1102b f2598e = m2180a("sadb", "AD_DOWNLOADED_BYTES");

    /* renamed from: f */
    static final C1102b f2599f = m2180a("sacb", "AD_CACHED_BYTES");

    /* renamed from: g */
    static final C1102b f2600g = m2180a("stdl", "TIME_TO_DISPLAY_FROM_LOAD");

    /* renamed from: h */
    static final C1102b f2601h = m2180a("stdi", "TIME_TO_DISPLAY_FROM_INIT");

    /* renamed from: i */
    static final C1102b f2602i = m2180a("snas", "AD_NUMBER_IN_SESSION");

    /* renamed from: j */
    static final C1102b f2603j = m2180a("snat", "AD_NUMBER_TOTAL");

    /* renamed from: k */
    static final C1102b f2604k = m2180a("stah", "TIME_AD_HIDDEN_FROM_SHOW");

    /* renamed from: l */
    static final C1102b f2605l = m2180a("stas", "TIME_TO_SKIP_FROM_SHOW");

    /* renamed from: m */
    static final C1102b f2606m = m2180a("stac", "TIME_TO_CLICK_FROM_SHOW");

    /* renamed from: n */
    static final C1102b f2607n = m2180a("stbe", "TIME_TO_EXPAND_FROM_SHOW");

    /* renamed from: o */
    static final C1102b f2608o = m2180a("stbc", "TIME_TO_CONTRACT_FROM_SHOW");

    /* renamed from: p */
    static final C1102b f2609p = m2180a("saan", "AD_SHOWN_WITH_ACTIVE_NETWORK");

    /* renamed from: q */
    static final C1102b f2610q = m2180a("suvs", "INTERSTITIAL_USED_VIDEO_STREAM");

    /* renamed from: r */
    static final C1102b f2611r = m2180a("sugs", "AD_USED_GRAPHIC_STREAM");

    /* renamed from: s */
    static final C1102b f2612s = m2180a("svpv", "INTERSTITIAL_VIDEO_PERCENT_VIEWED");

    /* renamed from: t */
    static final C1102b f2613t = m2180a("stpd", "INTERSTITIAL_PAUSED_DURATION");

    /* renamed from: u */
    static final C1102b f2614u = m2180a("sspe", "INTERSTITIAL_SHOW_POSTSTITIAL_CODE_EXECUTED");

    /* renamed from: v */
    static final C1102b f2615v = m2180a("shsc", "HTML_RESOURCE_CACHE_SUCCESS_COUNT");

    /* renamed from: w */
    static final C1102b f2616w = m2180a("shfc", "HTML_RESOURCE_CACHE_FAILURE_COUNT");

    /* renamed from: x */
    static final C1102b f2617x = m2180a("svmi", "INTERSTITIAL_VIDEO_MUTED_INITIALLY");

    /* renamed from: y */
    static final C1102b f2618y = m2180a("stvm", "TIME_TO_TOGGLE_VIDEO_MUTE");

    /* renamed from: z */
    static final C1102b f2619z = m2180a("schc", "AD_CANCELLED_HTML_CACHING");

    /* renamed from: G */
    private final String f2620G;

    /* renamed from: H */
    private final String f2621H;

    static {
        m2180a("sisw", "IS_STREAMING_WEBKIT");
        m2180a("surw", "UNABLE_TO_RETRIEVE_WEBKIT_HTML_STRING");
        m2180a("surp", "UNABLE_TO_PERSIST_WEBKIT_HTML_PLACEMENT_REPLACED_STRING");
        m2180a("swhp", "SUCCESSFULLY_PERSISTED_WEBKIT_HTML_STRING");
        m2180a("skr", "STOREKIT_REDIRECTED");
        m2180a("sklf", "STOREKIT_LOAD_FAILURE");
        m2180a("skps", "STOREKIT_PRELOAD_SKIPPED");
    }

    private C1102b(String str, String str2) {
        this.f2620G = str;
        this.f2621H = str2;
    }

    /* renamed from: a */
    private static C1102b m2180a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No key name specified");
        } else if (f2593I.contains(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Key has already been used: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        } else if (!TextUtils.isEmpty(str2)) {
            f2593I.add(str);
            return new C1102b(str, str2);
        } else {
            throw new IllegalArgumentException("No debug name specified");
        }
    }

    /* renamed from: a */
    public String mo9991a() {
        return this.f2620G;
    }

    /* renamed from: b */
    public String mo9992b() {
        return this.f2621H;
    }
}
