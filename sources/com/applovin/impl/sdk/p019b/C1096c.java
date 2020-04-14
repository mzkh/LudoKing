package com.applovin.impl.sdk.p019b;

import android.net.Uri;
import com.applovin.impl.p005a.C0783j.C0785a;
import com.applovin.sdk.AppLovinAdSize;
import com.tapjoy.TJAdUnitConstants;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.b.c */
public class C1096c<T> implements Comparable {

    /* renamed from: R */
    public static final C1096c<Boolean> f2276R;

    /* renamed from: S */
    public static final C1096c<String> f2277S;

    /* renamed from: T */
    public static final C1096c<String> f2278T;

    /* renamed from: U */
    public static final C1096c<Boolean> f2279U;

    /* renamed from: V */
    public static final C1096c<String> f2280V;

    /* renamed from: W */
    public static final C1096c<String> f2281W;

    /* renamed from: X */
    public static final C1096c<String> f2282X;

    /* renamed from: Y */
    public static final C1096c<String> f2283Y = m2127a("hash_algorithm", "SHA-1");

    /* renamed from: Z */
    public static final C1096c<Integer> f2284Z = m2127a("short_hash_size", Integer.valueOf(16));

    /* renamed from: a */
    private static final List<?> f2285a = Arrays.asList(new Class[]{Boolean.class, Float.class, Integer.class, Long.class, String.class});

    /* renamed from: aA */
    public static final C1096c<String> f2286aA = m2127a("text_alert_consent_body", "If you don't give us consent to use your data, you will be making our ability to support this app harder, which may negatively affect the user experience.");

    /* renamed from: aB */
    public static final C1096c<String> f2287aB = m2127a("text_alert_consent_yes_option", "I Agree");

    /* renamed from: aC */
    public static final C1096c<String> f2288aC = m2127a("text_alert_consent_no_option", "Cancel");

    /* renamed from: aD */
    public static final C1096c<Long> f2289aD = m2127a("ttc_max_click_duration_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: aE */
    public static final C1096c<Integer> f2290aE;

    /* renamed from: aF */
    public static final C1096c<String> f2291aF = m2127a("whitelisted_postback_endpoints", "https://prod-a.applovin.com,https://rt.applovin.com/4.0/pix, https://rt.applvn.com/4.0/pix,https://ms.applovin.com/,https://ms.applvn.com/");

    /* renamed from: aG */
    public static final C1096c<String> f2292aG = m2127a("fetch_settings_endpoint", "https://ms.applovin.com/");

    /* renamed from: aH */
    public static final C1096c<String> f2293aH = m2127a("fetch_settings_backup_endpoint", "https://ms.applvn.com/");

    /* renamed from: aI */
    public static final C1096c<String> f2294aI = m2127a("adserver_endpoint", "https://a.applovin.com/");

    /* renamed from: aJ */
    public static final C1096c<String> f2295aJ = m2127a("adserver_backup_endpoint", "https://a.applvn.com/");

    /* renamed from: aK */
    public static final C1096c<String> f2296aK = m2127a("api_endpoint", "https://d.applovin.com/");

    /* renamed from: aL */
    public static final C1096c<String> f2297aL = m2127a("api_backup_endpoint", "https://d.applvn.com/");

    /* renamed from: aM */
    public static final C1096c<String> f2298aM = m2127a("event_tracking_endpoint_v2", "https://rt.applovin.com/");

    /* renamed from: aN */
    public static final C1096c<String> f2299aN = m2127a("event_tracking_backup_endpoint_v2", "https://rt.applvn.com/");

    /* renamed from: aO */
    public static final C1096c<String> f2300aO = m2127a("fetch_variables_endpoint", "https://ms.applovin.com/");

    /* renamed from: aP */
    public static final C1096c<String> f2301aP = m2127a("fetch_variables_backup_endpoint", "https://ms.applvn.com/");

    /* renamed from: aQ */
    public static final C1096c<Boolean> f2302aQ;

    /* renamed from: aR */
    public static final C1096c<String> f2303aR = m2127a("token_type_prefixes_r", "4!");

    /* renamed from: aS */
    public static final C1096c<String> f2304aS = m2127a("token_type_prefixes_arj", "json_v3!");

    /* renamed from: aT */
    public static final C1096c<String> f2305aT = m2127a("top_level_events", "landing,paused,resumed,checkout,iap");

    /* renamed from: aU */
    public static final C1096c<Boolean> f2306aU;

    /* renamed from: aV */
    public static final C1096c<String> f2307aV;

    /* renamed from: aW */
    public static final C1096c<Boolean> f2308aW;

    /* renamed from: aX */
    public static final C1096c<Integer> f2309aX = m2127a("super_property_string_max_length", Integer.valueOf(1024));

    /* renamed from: aY */
    public static final C1096c<Integer> f2310aY = m2127a("super_property_url_max_length", Integer.valueOf(1024));

    /* renamed from: aZ */
    public static final C1096c<Integer> f2311aZ = m2127a("preload_callback_timeout_seconds", Integer.valueOf(-1));

    /* renamed from: aa */
    public static final C1096c<Boolean> f2312aa;

    /* renamed from: ab */
    public static final C1096c<Boolean> f2313ab;

    /* renamed from: ac */
    public static final C1096c<Boolean> f2314ac;

    /* renamed from: ad */
    public static final C1096c<Boolean> f2315ad;

    /* renamed from: ae */
    public static final C1096c<Boolean> f2316ae;

    /* renamed from: af */
    public static final C1096c<Boolean> f2317af;

    /* renamed from: ag */
    public static final C1096c<Boolean> f2318ag;

    /* renamed from: ah */
    public static final C1096c<Long> f2319ah;

    /* renamed from: ai */
    public static final C1096c<Integer> f2320ai = m2127a("logcat_max_line_size", Integer.valueOf(1000));

    /* renamed from: aj */
    public static final C1096c<Integer> f2321aj = m2127a("stps", Integer.valueOf(32));

    /* renamed from: ak */
    public static final C1096c<Boolean> f2322ak;

    /* renamed from: al */
    public static final C1096c<Boolean> f2323al;

    /* renamed from: am */
    public static final C1096c<String> f2324am = m2127a("consent_dialog_url", "https://assets.applovin.com/gdpr/flow_v1/gdpr-flow-1.html");

    /* renamed from: an */
    public static final C1096c<Boolean> f2325an;

    /* renamed from: ao */
    public static final C1096c<Long> f2326ao = m2127a("consent_dialog_show_from_alert_delay_ms", Long.valueOf(450));

    /* renamed from: ap */
    public static final C1096c<Boolean> f2327ap;

    /* renamed from: aq */
    public static final C1096c<Boolean> f2328aq;

    /* renamed from: ar */
    public static final C1096c<Boolean> f2329ar;

    /* renamed from: as */
    public static final C1096c<Boolean> f2330as;

    /* renamed from: at */
    public static final C1096c<Long> f2331at = m2127a("alert_consent_after_init_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));

    /* renamed from: au */
    public static final C1096c<Long> f2332au = m2127a("alert_consent_after_dialog_rejection_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(30)));

    /* renamed from: av */
    public static final C1096c<Long> f2333av = m2127a("alert_consent_after_dialog_close_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));

    /* renamed from: aw */
    public static final C1096c<Long> f2334aw = m2127a("alert_consent_after_dialog_close_with_back_button_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));

    /* renamed from: ax */
    public static final C1096c<Long> f2335ax = m2127a("alert_consent_after_cancel_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(10)));

    /* renamed from: ay */
    public static final C1096c<Long> f2336ay = m2127a("alert_consent_reschedule_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));

    /* renamed from: az */
    public static final C1096c<String> f2337az = m2127a("text_alert_consent_title", "Make this App Better and Stay Free!");

    /* renamed from: b */
    private static final Map<String, C1096c<?>> f2338b = new HashMap(512);

    /* renamed from: bA */
    public static final C1096c<Boolean> f2339bA;

    /* renamed from: bB */
    public static final C1096c<Boolean> f2340bB;

    /* renamed from: bC */
    public static final C1096c<Boolean> f2341bC;

    /* renamed from: bD */
    public static final C1096c<String> f2342bD = m2127a("cdt", "external");

    /* renamed from: bE */
    public static final C1096c<Boolean> f2343bE;

    /* renamed from: bF */
    public static final C1096c<Long> f2344bF = m2127a("cache_file_ttl_seconds", Long.valueOf(TimeUnit.DAYS.toSeconds(1)));

    /* renamed from: bG */
    public static final C1096c<Integer> f2345bG = m2127a("cache_max_size_mb", Integer.valueOf(-1));

    /* renamed from: bH */
    public static final C1096c<String> f2346bH = m2127a("precache_delimiters", ")]',");

    /* renamed from: bI */
    public static final C1096c<Boolean> f2347bI;

    /* renamed from: bJ */
    public static final C1096c<Boolean> f2348bJ;

    /* renamed from: bK */
    public static final C1096c<Boolean> f2349bK;

    /* renamed from: bL */
    public static final C1096c<String> f2350bL = m2127a("resource_cache_prefix", "https://vid.applovin.com/,https://pdn.applovin.com/,https://img.applovin.com/,https://d.applovin.com/,https://assets.applovin.com/,https://cdnjs.cloudflare.com/,http://vid.applovin.com/,http://pdn.applovin.com/,http://img.applovin.com/,http://d.applovin.com/,http://assets.applovin.com/,http://cdnjs.cloudflare.com/");

    /* renamed from: bM */
    public static final C1096c<Integer> f2351bM;

    /* renamed from: bN */
    public static final C1096c<Integer> f2352bN;

    /* renamed from: bO */
    public static final C1096c<Boolean> f2353bO;

    /* renamed from: bP */
    public static final C1096c<String> f2354bP = m2127a("text_incent_warning_title", "Attention!");

    /* renamed from: bQ */
    public static final C1096c<String> f2355bQ = m2127a("text_incent_warning_body", "You won’t get your reward if the video hasn’t finished.");

    /* renamed from: bR */
    public static final C1096c<String> f2356bR = m2127a("text_incent_warning_close_option", "Close");

    /* renamed from: bS */
    public static final C1096c<String> f2357bS = m2127a("text_incent_warning_continue_option", "Keep Watching");

    /* renamed from: bT */
    public static final C1096c<Boolean> f2358bT;

    /* renamed from: bU */
    public static final C1096c<String> f2359bU = m2127a("text_incent_nonvideo_warning_title", "Attention!");

    /* renamed from: bV */
    public static final C1096c<String> f2360bV = m2127a("text_incent_nonvideo_warning_body", "You won’t get your reward if the game hasn’t finished.");

    /* renamed from: bW */
    public static final C1096c<String> f2361bW = m2127a("text_incent_nonvideo_warning_close_option", "Close");

    /* renamed from: bX */
    public static final C1096c<String> f2362bX = m2127a("text_incent_nonvideo_warning_continue_option", "Keep Playing");

    /* renamed from: bY */
    public static final C1096c<Boolean> f2363bY;

    /* renamed from: bZ */
    public static final C1096c<Boolean> f2364bZ;

    /* renamed from: ba */
    public static final C1096c<Boolean> f2365ba;

    /* renamed from: bb */
    public static final C1096c<String> f2366bb;

    /* renamed from: bc */
    public static final C1096c<Boolean> f2367bc;

    /* renamed from: bd */
    public static final C1096c<Boolean> f2368bd;

    /* renamed from: be */
    public static final C1096c<Boolean> f2369be;

    /* renamed from: bf */
    public static final C1096c<Integer> f2370bf;

    /* renamed from: bg */
    public static final C1096c<Integer> f2371bg;

    /* renamed from: bh */
    public static final C1096c<Integer> f2372bh;

    /* renamed from: bi */
    public static final C1096c<Integer> f2373bi;

    /* renamed from: bj */
    public static final C1096c<Integer> f2374bj;

    /* renamed from: bk */
    public static final C1096c<Boolean> f2375bk;

    /* renamed from: bl */
    public static final C1096c<Integer> f2376bl;

    /* renamed from: bm */
    public static final C1096c<Integer> f2377bm;

    /* renamed from: bn */
    public static final C1096c<Integer> f2378bn;

    /* renamed from: bo */
    public static final C1096c<Integer> f2379bo;

    /* renamed from: bp */
    public static final C1096c<Integer> f2380bp;

    /* renamed from: bq */
    public static final C1096c<Integer> f2381bq;

    /* renamed from: br */
    public static final C1096c<Integer> f2382br;

    /* renamed from: bs */
    public static final C1096c<Integer> f2383bs;

    /* renamed from: bt */
    public static final C1096c<Integer> f2384bt;

    /* renamed from: bu */
    public static final C1096c<Boolean> f2385bu;

    /* renamed from: bv */
    public static final C1096c<Boolean> f2386bv;

    /* renamed from: bw */
    public static final C1096c<Boolean> f2387bw;

    /* renamed from: bx */
    public static final C1096c<Boolean> f2388bx;

    /* renamed from: by */
    public static final C1096c<Boolean> f2389by;

    /* renamed from: bz */
    public static final C1096c<Boolean> f2390bz;

    /* renamed from: cA */
    public static final C1096c<Integer> f2391cA = m2127a("caching_operations_threads", Integer.valueOf(8));

    /* renamed from: cB */
    public static final C1096c<Long> f2392cB = m2127a("fullscreen_ad_pending_display_state_timeout_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: cC */
    public static final C1096c<Long> f2393cC = m2127a("fullscreen_ad_showing_state_timeout_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(2)));

    /* renamed from: cD */
    public static final C1096c<Boolean> f2394cD;

    /* renamed from: cE */
    public static final C1096c<Integer> f2395cE = m2127a("close_button_right_margin_video", Integer.valueOf(4));

    /* renamed from: cF */
    public static final C1096c<Integer> f2396cF = m2127a("close_button_size_video", Integer.valueOf(30));

    /* renamed from: cG */
    public static final C1096c<Integer> f2397cG = m2127a("close_button_top_margin_video", Integer.valueOf(8));

    /* renamed from: cH */
    public static final C1096c<Integer> f2398cH = m2127a("close_fade_in_time", Integer.valueOf(400));

    /* renamed from: cI */
    public static final C1096c<Boolean> f2399cI;

    /* renamed from: cJ */
    public static final C1096c<Integer> f2400cJ;

    /* renamed from: cK */
    public static final C1096c<Integer> f2401cK = m2127a("video_countdown_clock_gravity", Integer.valueOf(83));

    /* renamed from: cL */
    public static final C1096c<Integer> f2402cL = m2127a("countdown_clock_size", Integer.valueOf(32));

    /* renamed from: cM */
    public static final C1096c<Integer> f2403cM = m2127a("countdown_clock_stroke_size", Integer.valueOf(4));

    /* renamed from: cN */
    public static final C1096c<Integer> f2404cN = m2127a("countdown_clock_text_size", Integer.valueOf(28));

    /* renamed from: cO */
    public static final C1096c<Boolean> f2405cO;

    /* renamed from: cP */
    public static final C1096c<Boolean> f2406cP;

    /* renamed from: cQ */
    public static final C1096c<Boolean> f2407cQ;

    /* renamed from: cR */
    public static final C1096c<Boolean> f2408cR;

    /* renamed from: cS */
    public static final C1096c<Long> f2409cS;

    /* renamed from: cT */
    public static final C1096c<Boolean> f2410cT;

    /* renamed from: cU */
    public static final C1096c<Long> f2411cU = m2127a("inter_display_delay", Long.valueOf(200));

    /* renamed from: cV */
    public static final C1096c<Boolean> f2412cV;

    /* renamed from: cW */
    public static final C1096c<Boolean> f2413cW;

    /* renamed from: cX */
    public static final C1096c<String> f2414cX = m2127a("soft_buttons_resource_id", "config_showNavigationBar");

    /* renamed from: cY */
    public static final C1096c<Boolean> f2415cY;

    /* renamed from: cZ */
    public static final C1096c<Boolean> f2416cZ;

    /* renamed from: ca */
    public static final C1096c<String> f2417ca;

    /* renamed from: cb */
    public static final C1096c<Boolean> f2418cb;

    /* renamed from: cc */
    public static final C1096c<Boolean> f2419cc;

    /* renamed from: cd */
    public static final C1096c<Boolean> f2420cd;

    /* renamed from: ce */
    public static final C1096c<Integer> f2421ce;

    /* renamed from: cf */
    public static final C1096c<Long> f2422cf = m2127a("viewability_adview_imp_delay_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: cg */
    public static final C1096c<Integer> f2423cg = m2127a("viewability_adview_banner_min_width", Integer.valueOf(320));

    /* renamed from: ch */
    public static final C1096c<Integer> f2424ch = m2127a("viewability_adview_banner_min_height", Integer.valueOf(AppLovinAdSize.BANNER.getHeight()));

    /* renamed from: ci */
    public static final C1096c<Integer> f2425ci = m2127a("viewability_adview_mrec_min_width", Integer.valueOf(AppLovinAdSize.MREC.getWidth()));

    /* renamed from: cj */
    public static final C1096c<Integer> f2426cj = m2127a("viewability_adview_mrec_min_height", Integer.valueOf(AppLovinAdSize.MREC.getWidth()));

    /* renamed from: ck */
    public static final C1096c<Integer> f2427ck = m2127a("viewability_adview_leader_min_width", Integer.valueOf(728));

    /* renamed from: cl */
    public static final C1096c<Integer> f2428cl = m2127a("viewability_adview_leader_min_height", Integer.valueOf(AppLovinAdSize.LEADER.getWidth()));

    /* renamed from: cm */
    public static final C1096c<Float> f2429cm = m2127a("viewability_adview_min_alpha", Float.valueOf(10.0f));

    /* renamed from: cn */
    public static final C1096c<Long> f2430cn = m2127a("viewability_timer_min_visible_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: co */
    public static final C1096c<Long> f2431co = m2127a("viewability_timer_interval_ms", Long.valueOf(100));

    /* renamed from: cp */
    public static final C1096c<Boolean> f2432cp;

    /* renamed from: cq */
    public static final C1096c<Boolean> f2433cq;

    /* renamed from: cr */
    public static final C1096c<Boolean> f2434cr;

    /* renamed from: cs */
    public static final C1096c<Long> f2435cs = m2127a("expandable_close_button_animation_duration_ms", Long.valueOf(300));

    /* renamed from: ct */
    public static final C1096c<Integer> f2436ct = m2127a("expandable_close_button_size", Integer.valueOf(27));

    /* renamed from: cu */
    public static final C1096c<Integer> f2437cu;

    /* renamed from: cv */
    public static final C1096c<Integer> f2438cv;

    /* renamed from: cw */
    public static final C1096c<Boolean> f2439cw;

    /* renamed from: cx */
    public static final C1096c<Integer> f2440cx;

    /* renamed from: cy */
    public static final C1096c<Boolean> f2441cy;

    /* renamed from: cz */
    public static final C1096c<Integer> f2442cz = m2127a("auxiliary_operations_threads", Integer.valueOf(3));

    /* renamed from: dA */
    public static final C1096c<Integer> f2443dA = m2127a("fetch_ad_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: dB */
    public static final C1096c<Integer> f2444dB;

    /* renamed from: dC */
    public static final C1096c<Integer> f2445dC;

    /* renamed from: dD */
    public static final C1096c<Integer> f2446dD = m2127a("response_buffer_size", Integer.valueOf(16000));

    /* renamed from: dE */
    public static final C1096c<Integer> f2447dE = m2127a("fetch_basic_settings_connection_timeout_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: dF */
    public static final C1096c<Integer> f2448dF = m2127a("fetch_basic_settings_retry_count", Integer.valueOf(3));

    /* renamed from: dG */
    public static final C1096c<Boolean> f2449dG;

    /* renamed from: dH */
    public static final C1096c<Boolean> f2450dH;

    /* renamed from: dI */
    public static final C1096c<Integer> f2451dI = m2127a("fetch_basic_settings_retry_delay_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(2)));

    /* renamed from: dJ */
    public static final C1096c<Integer> f2452dJ = m2127a("fetch_variables_connection_timeout_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(5)));

    /* renamed from: dK */
    public static final C1096c<Boolean> f2453dK;

    /* renamed from: dL */
    public static final C1096c<Boolean> f2454dL;

    /* renamed from: dM */
    public static final C1096c<Integer> f2455dM = m2127a("ad_session_minutes", Integer.valueOf(60));

    /* renamed from: dN */
    public static final C1096c<Boolean> f2456dN;

    /* renamed from: dO */
    public static final C1096c<Long> f2457dO = m2127a("session_tracking_resumed_cooldown_minutes", Long.valueOf(90));

    /* renamed from: dP */
    public static final C1096c<Long> f2458dP = m2127a("session_tracking_paused_cooldown_minutes", Long.valueOf(90));

    /* renamed from: dQ */
    public static final C1096c<Boolean> f2459dQ;

    /* renamed from: dR */
    public static final C1096c<Boolean> f2460dR;

    /* renamed from: dS */
    public static final C1096c<Boolean> f2461dS;

    /* renamed from: dT */
    public static final C1096c<Boolean> f2462dT;

    /* renamed from: dU */
    public static final C1096c<Boolean> f2463dU;

    /* renamed from: dV */
    public static final C1096c<Boolean> f2464dV;

    /* renamed from: dW */
    public static final C1096c<Boolean> f2465dW;

    /* renamed from: dX */
    public static final C1096c<Boolean> f2466dX;

    /* renamed from: dY */
    public static final C1096c<Boolean> f2467dY;

    /* renamed from: dZ */
    public static final C1096c<Boolean> f2468dZ;

    /* renamed from: da */
    public static final C1096c<Boolean> f2469da;

    /* renamed from: db */
    public static final C1096c<Boolean> f2470db;

    /* renamed from: dc */
    public static final C1096c<Boolean> f2471dc;

    /* renamed from: dd */
    public static final C1096c<Boolean> f2472dd;

    /* renamed from: de */
    public static final C1096c<Integer> f2473de = m2127a("mute_button_size", Integer.valueOf(32));

    /* renamed from: df */
    public static final C1096c<Integer> f2474df;

    /* renamed from: dg */
    public static final C1096c<Integer> f2475dg = m2127a("mute_button_gravity", Integer.valueOf(85));

    /* renamed from: dh */
    public static final C1096c<Boolean> f2476dh;

    /* renamed from: di */
    public static final C1096c<Long> f2477di = m2127a("progress_bar_step", Long.valueOf(25));

    /* renamed from: dj */
    public static final C1096c<Integer> f2478dj = m2127a("progress_bar_scale", Integer.valueOf(10000));

    /* renamed from: dk */
    public static final C1096c<Integer> f2479dk = m2127a("progress_bar_vertical_padding", Integer.valueOf(-8));

    /* renamed from: dl */
    public static final C1096c<Long> f2480dl = m2127a("video_resume_delay", Long.valueOf(250));

    /* renamed from: dm */
    public static final C1096c<Boolean> f2481dm;

    /* renamed from: dn */
    public static final C1096c<Integer> f2482dn = m2127a("vs_buffer_indicator_size", Integer.valueOf(50));

    /* renamed from: do */
    public static final C1096c<Boolean> f2483do;

    /* renamed from: dp */
    public static final C1096c<Long> f2484dp = m2127a("set_poststitial_muted_initial_delay_ms", Long.valueOf(500));

    /* renamed from: dq */
    public static final C1096c<Boolean> f2485dq;

    /* renamed from: dr */
    public static final C1096c<Integer> f2486dr;

    /* renamed from: ds */
    public static final C1096c<Integer> f2487ds = m2127a("submit_postback_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: dt */
    public static final C1096c<Integer> f2488dt = m2127a("submit_postback_retries", Integer.valueOf(4));

    /* renamed from: du */
    public static final C1096c<Integer> f2489du = m2127a("max_postback_attempts", Integer.valueOf(3));

    /* renamed from: dv */
    public static final C1096c<Integer> f2490dv = m2127a("get_retry_delay_v1", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: dw */
    public static final C1096c<Integer> f2491dw = m2127a("http_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: dx */
    public static final C1096c<Integer> f2492dx = m2127a("http_socket_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(20)));

    /* renamed from: dy */
    public static final C1096c<Boolean> f2493dy;

    /* renamed from: dz */
    public static final C1096c<Boolean> f2494dz;

    /* renamed from: eA */
    public static final C1096c<Integer> f2495eA = m2127a("error_reporting_log_limit", Integer.valueOf(100));

    /* renamed from: eB */
    public static final C1096c<String> f2496eB = m2127a("vast_image_html", "<html><head><style>html,body{height:100%;width:100%}body{background-image:url({SOURCE});background-repeat:no-repeat;background-size:contain;background-position:center;}a{position:absolute;top:0;bottom:0;left:0;right:0}</style></head><body><a href=\"applovin://com.applovin.sdk/adservice/track_click_now\"></a></body></html>");

    /* renamed from: eC */
    public static final C1096c<String> f2497eC = m2127a("vast_link_html", "<html><head><style>html,body,iframe{height:100%;width:100%;}body{margin:0}iframe{border:0;overflow:hidden;position:absolute}</style></head><body><iframe src={SOURCE} frameborder=0></iframe></body></html>");

    /* renamed from: eD */
    public static final C1096c<Integer> f2498eD = m2127a("vast_max_response_length", Integer.valueOf(640000));

    /* renamed from: eE */
    public static final C1096c<Integer> f2499eE = m2127a("vast_max_wrapper_depth", Integer.valueOf(5));

    /* renamed from: eF */
    public static final C1096c<Long> f2500eF = m2127a("vast_progress_tracking_countdown_step", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: eG */
    public static final C1096c<String> f2501eG = m2127a("vast_unsupported_video_extensions", "ogv,flv");

    /* renamed from: eH */
    public static final C1096c<String> f2502eH = m2127a("vast_unsupported_video_types", "video/ogg,video/x-flv");

    /* renamed from: eI */
    public static final C1096c<Boolean> f2503eI;

    /* renamed from: eJ */
    public static final C1096c<Integer> f2504eJ = m2127a("vast_video_selection_policy", Integer.valueOf(C0785a.MEDIUM.ordinal()));

    /* renamed from: eK */
    public static final C1096c<Integer> f2505eK;

    /* renamed from: eL */
    public static final C1096c<Integer> f2506eL = m2127a("vast_wrapper_resolution_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: eM */
    public static final C1096c<Boolean> f2507eM;

    /* renamed from: eN */
    public static final C1096c<Boolean> f2508eN;

    /* renamed from: eO */
    public static final C1096c<Long> f2509eO;

    /* renamed from: eP */
    public static final C1096c<Long> f2510eP;

    /* renamed from: eQ */
    public static final C1096c<Boolean> f2511eQ;

    /* renamed from: eR */
    public static final C1096c<Boolean> f2512eR;

    /* renamed from: eS */
    public static final C1096c<Boolean> f2513eS;

    /* renamed from: eT */
    public static final C1096c<Boolean> f2514eT;

    /* renamed from: eU */
    public static final C1096c<Boolean> f2515eU;

    /* renamed from: eV */
    public static final C1096c<Boolean> f2516eV;

    /* renamed from: eW */
    public static final C1096c<Boolean> f2517eW;

    /* renamed from: eX */
    public static final C1096c<Boolean> f2518eX;

    /* renamed from: eY */
    public static final C1096c<Boolean> f2519eY;

    /* renamed from: eZ */
    public static final C1096c<String> f2520eZ = m2127a("config_consent_dialog_state", "unknown");

    /* renamed from: ea */
    public static final C1096c<Boolean> f2521ea;

    /* renamed from: eb */
    public static final C1096c<String> f2522eb;

    /* renamed from: ec */
    public static final C1096c<Boolean> f2523ec;

    /* renamed from: ed */
    public static final C1096c<Boolean> f2524ed;

    /* renamed from: ee */
    public static final C1096c<Boolean> f2525ee;

    /* renamed from: ef */
    public static final C1096c<Boolean> f2526ef;

    /* renamed from: eg */
    public static final C1096c<Boolean> f2527eg;

    /* renamed from: eh */
    public static final C1096c<Boolean> f2528eh;

    /* renamed from: ei */
    public static final C1096c<Boolean> f2529ei;

    /* renamed from: ej */
    public static final C1096c<String> f2530ej = m2127a("emulator_hardware_list", "ranchu,goldfish,vbox");

    /* renamed from: ek */
    public static final C1096c<String> f2531ek = m2127a("emulator_device_list", "generic,vbox");

    /* renamed from: el */
    public static final C1096c<String> f2532el = m2127a("emulator_manufacturer_list", "Genymotion");

    /* renamed from: em */
    public static final C1096c<String> f2533em = m2127a("emulator_model_list", "Android SDK built for x86");

    /* renamed from: en */
    public static final C1096c<Boolean> f2534en;

    /* renamed from: eo */
    public static final C1096c<Float> f2535eo = m2127a("volume_normalization_factor", Float.valueOf(6.6666665f));

    /* renamed from: ep */
    public static final C1096c<Boolean> f2536ep;

    /* renamed from: eq */
    public static final C1096c<Long> f2537eq = m2127a("user_agent_collection_timeout_ms", Long.valueOf(600));

    /* renamed from: er */
    public static final C1096c<String> f2538er = m2127a("webview_package_name", "com.google.android.webview");

    /* renamed from: es */
    public static final C1096c<Boolean> f2539es;

    /* renamed from: et */
    public static final C1096c<Boolean> f2540et;

    /* renamed from: eu */
    public static final C1096c<Integer> f2541eu = m2127a("submit_ad_stats_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: ev */
    public static final C1096c<Integer> f2542ev;

    /* renamed from: ew */
    public static final C1096c<Integer> f2543ew = m2127a("submit_ad_stats_max_count", Integer.valueOf(TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL));

    /* renamed from: ex */
    public static final C1096c<Boolean> f2544ex;

    /* renamed from: ey */
    public static final C1096c<Boolean> f2545ey;

    /* renamed from: ez */
    public static final C1096c<Boolean> f2546ez;

    /* renamed from: c */
    private final String f2547c;

    /* renamed from: d */
    private final T f2548d;

    static {
        Integer valueOf = Integer.valueOf(0);
        Boolean valueOf2 = Boolean.valueOf(false);
        Integer valueOf3 = Integer.valueOf(1);
        Boolean valueOf4 = Boolean.valueOf(true);
        f2276R = m2127a("is_disabled", valueOf2);
        String str = "";
        f2277S = m2127a("device_id", str);
        f2278T = m2127a("device_token", str);
        f2279U = m2127a("is_verbose_logging", valueOf2);
        f2280V = m2127a("sc", str);
        f2281W = m2127a("sc2", str);
        f2282X = m2127a("server_installed_at", str);
        f2312aa = m2127a("trn", valueOf2);
        f2313ab = m2127a("honor_publisher_settings", valueOf4);
        f2314ac = m2127a("track_network_response_codes", valueOf2);
        f2315ad = m2127a("submit_network_response_codes", valueOf2);
        f2316ae = m2127a("clear_network_response_codes_on_request", valueOf4);
        f2317af = m2127a("preserve_network_response_codes", valueOf2);
        f2318ag = m2127a("clear_completion_callback_on_failure", valueOf2);
        Long valueOf5 = Long.valueOf(0);
        f2319ah = m2127a("sicd_ms", valueOf5);
        f2322ak = m2127a("ustp", valueOf2);
        f2323al = m2127a("publisher_can_show_consent_dialog", valueOf4);
        f2325an = m2127a("consent_dialog_immersive_mode_on", valueOf2);
        f2327ap = m2127a("alert_consent_for_dialog_rejected", valueOf2);
        f2328aq = m2127a("alert_consent_for_dialog_closed", valueOf2);
        f2329ar = m2127a("alert_consent_for_dialog_closed_with_back_button", valueOf2);
        f2330as = m2127a("alert_consent_after_init", valueOf2);
        Integer valueOf6 = Integer.valueOf(10);
        f2290aE = m2127a("ttc_max_click_distance_dp", valueOf6);
        f2302aQ = m2127a("bte", valueOf4);
        f2306aU = m2127a("events_enabled", valueOf4);
        StringBuilder sb = new StringBuilder();
        sb.append(String.class.getName());
        String str2 = ",";
        sb.append(str2);
        sb.append(Integer.class.getName());
        sb.append(str2);
        sb.append(Long.class.getName());
        sb.append(str2);
        sb.append(Double.class.getName());
        sb.append(str2);
        sb.append(Float.class.getName());
        sb.append(str2);
        sb.append(Date.class.getName());
        sb.append(str2);
        sb.append(Uri.class.getName());
        sb.append(str2);
        sb.append(List.class.getName());
        sb.append(str2);
        sb.append(Map.class.getName());
        f2307aV = m2127a("valid_super_property_types", sb.toString());
        f2308aW = m2127a("persist_super_properties", valueOf4);
        f2365ba = m2127a("ad_preload_enabled", valueOf4);
        f2366bb = m2127a("ad_auto_preload_sizes", str);
        f2367bc = m2127a("ad_auto_preload_incent", valueOf4);
        f2368bd = m2127a("ad_auto_preload_native", valueOf2);
        f2369be = m2127a("preload_native_ad_on_dequeue", valueOf2);
        f2370bf = m2127a("preload_capacity_banner_regular", valueOf);
        f2371bg = m2127a("preload_capacity_mrec_regular", valueOf);
        f2372bh = m2127a("preload_capacity_leader_regular", valueOf);
        f2373bi = m2127a("preload_capacity_inter_regular", valueOf);
        f2374bj = m2127a("preload_capacity_inter_videoa", valueOf);
        f2375bk = m2127a("use_per_format_cache_queues", valueOf4);
        Integer valueOf7 = Integer.valueOf(15);
        f2376bl = m2127a("extended_preload_capacity_banner_regular", valueOf7);
        f2377bm = m2127a("extended_preload_capacity_mrec_regular", valueOf7);
        f2378bn = m2127a("extended_preload_capacity_leader_regular", valueOf7);
        f2379bo = m2127a("extended_preload_capacity_inter_regular", valueOf7);
        f2380bp = m2127a("extended_preload_capacity_inter_videoa", valueOf7);
        f2381bq = m2127a("preload_capacity_zone", valueOf3);
        f2382br = m2127a("preload_capacity_zone_native", valueOf3);
        f2383bs = m2127a("extended_preload_capacity_zone", valueOf7);
        f2384bt = m2127a("preload_capacity_native_native", valueOf);
        f2385bu = m2127a("preload_merge_init_tasks_inter_regular", valueOf2);
        f2386bv = m2127a("preload_merge_init_tasks_inter_videoa", valueOf2);
        f2387bw = m2127a("preload_merge_init_tasks_banner_regular", valueOf2);
        f2388bx = m2127a("preload_merge_init_tasks_mrec_regular", valueOf2);
        f2389by = m2127a("preload_merge_init_tasks_leader_regular", valueOf2);
        f2390bz = m2127a("preload_merge_init_tasks_zones", valueOf2);
        f2339bA = m2127a("honor_publisher_settings_verbose_logging", valueOf4);
        f2340bB = m2127a("honor_publisher_settings_auto_preload_ad_sizes", valueOf4);
        f2341bC = m2127a("honor_publisher_settings_auto_preload_ad_types", valueOf4);
        f2343bE = m2127a("cache_cleanup_enabled", valueOf2);
        f2347bI = m2127a("native_auto_cache_preload_resources", valueOf4);
        f2348bJ = m2127a("ad_resource_caching_enabled", valueOf4);
        f2349bK = m2127a("fail_ad_load_on_failed_video_cache", valueOf4);
        f2351bM = m2127a("vr_retry_count_v1", valueOf3);
        f2352bN = m2127a("cr_retry_count_v1", valueOf3);
        f2353bO = m2127a("incent_warning_enabled", valueOf2);
        f2358bT = m2127a("incent_nonvideo_warning_enabled", valueOf2);
        f2363bY = m2127a("video_callbacks_for_incent_nonvideo_ads_enabled", valueOf4);
        f2364bZ = m2127a("wrapped_zones", valueOf2);
        f2417ca = m2127a("wrapped_sizes", str);
        f2418cb = m2127a("return_wrapped_ad_on_empty_queue", valueOf2);
        f2419cc = m2127a("consider_wrapped_ad_preloaded", valueOf2);
        f2420cd = m2127a("check_webview_has_gesture", valueOf2);
        f2421ce = m2127a("close_button_touch_area", valueOf);
        f2432cp = m2127a("dismiss_expanded_adview_on_refresh", valueOf2);
        f2433cq = m2127a("dismiss_expanded_adview_on_detach", valueOf2);
        f2434cr = m2127a("contract_expanded_ad_on_close", valueOf4);
        f2437cu = m2127a("expandable_h_close_button_margin", valueOf6);
        f2438cv = m2127a("expandable_t_close_button_margin", valueOf6);
        f2439cw = m2127a("expandable_lhs_close_button", valueOf2);
        f2440cx = m2127a("expandable_close_button_touch_area", valueOf);
        f2441cy = m2127a("click_failed_expand", valueOf2);
        f2394cD = m2127a("lhs_close_button_video", valueOf2);
        f2399cI = m2127a("show_close_on_exit", valueOf4);
        f2400cJ = m2127a("video_countdown_clock_margin", valueOf6);
        f2405cO = m2127a("draw_countdown_clock", valueOf4);
        f2406cP = m2127a("force_back_button_enabled_always", valueOf2);
        f2407cQ = m2127a("force_back_button_enabled_close_button", valueOf2);
        f2408cR = m2127a("force_back_button_enabled_poststitial", valueOf2);
        f2409cS = m2127a("force_hide_status_bar_delay_ms", valueOf5);
        f2410cT = m2127a("handle_window_actions", valueOf2);
        f2412cV = m2127a("lock_specific_orientation", valueOf2);
        f2413cW = m2127a("lhs_skip_button", valueOf4);
        f2415cY = m2127a("countdown_toggleable", valueOf2);
        f2416cZ = m2127a("mute_controls_enabled", valueOf2);
        f2469da = m2127a("allow_user_muting", valueOf4);
        f2470db = m2127a("mute_videos", valueOf2);
        f2471dc = m2127a("show_mute_by_default", valueOf2);
        f2472dd = m2127a("mute_with_user_settings", valueOf4);
        f2474df = m2127a("mute_button_margin", valueOf6);
        f2476dh = m2127a("video_immersive_mode_enabled", valueOf2);
        f2481dm = m2127a("is_video_skippable", valueOf2);
        f2483do = m2127a("video_zero_length_as_computed", valueOf2);
        f2485dq = m2127a("widget_fail_on_slot_count_diff", valueOf4);
        f2486dr = m2127a("native_batch_precache_count", valueOf3);
        f2493dy = m2127a("force_ssl", valueOf2);
        f2494dz = m2127a("network_available_if_none_detected", valueOf4);
        f2444dB = m2127a("fetch_ad_retry_count_v1", valueOf3);
        f2445dC = m2127a("submit_data_retry_count_v1", valueOf3);
        f2449dG = m2127a("fetch_basic_settings_on_reconnect", valueOf2);
        f2450dH = m2127a("skip_fetch_basic_settings_if_not_connected", valueOf2);
        f2453dK = m2127a("preload_persisted_zones", valueOf4);
        f2454dL = m2127a("persist_zones", valueOf4);
        f2456dN = m2127a("session_tracking_cooldown_on_event_fire", valueOf4);
        f2459dQ = m2127a("track_app_paused", valueOf2);
        f2460dR = m2127a("qq", valueOf2);
        f2461dS = m2127a("qq1", valueOf4);
        f2462dT = m2127a("qq3", valueOf4);
        f2463dU = m2127a("qq4", valueOf4);
        f2464dV = m2127a("qq5", valueOf4);
        f2465dW = m2127a("qq6", valueOf4);
        f2466dX = m2127a("qq7", valueOf4);
        f2467dY = m2127a("qq8", valueOf4);
        f2468dZ = m2127a("aicq", valueOf2);
        f2521ea = m2127a("pui", valueOf4);
        f2522eb = m2127a("plugin_version", str);
        f2523ec = m2127a("hgn", valueOf2);
        f2524ed = m2127a("citab", valueOf2);
        f2525ee = m2127a("cit", valueOf2);
        f2526ef = m2127a("cso", valueOf2);
        f2527eg = m2127a("cfs", valueOf2);
        f2528eh = m2127a("cmi", valueOf2);
        f2529ei = m2127a("cvs", valueOf2);
        f2534en = m2127a("adr", valueOf2);
        f2536ep = m2127a("user_agent_collection_enabled", valueOf2);
        f2539es = m2127a("is_track_ad_info", valueOf4);
        f2540et = m2127a("submit_ad_stats_enabled", valueOf2);
        f2542ev = m2127a("submit_ad_stats_retry_count", valueOf3);
        f2544ex = m2127a("asdm", valueOf2);
        f2545ey = m2127a("task_stats_enabled", valueOf2);
        f2546ez = m2127a("error_reporting_enabled", valueOf2);
        f2503eI = m2127a("vast_validate_with_extension_if_no_video_type", valueOf4);
        f2505eK = m2127a("vast_wrapper_resolution_retry_count_v1", valueOf3);
        f2507eM = m2127a("ree", valueOf4);
        f2508eN = m2127a("btee", valueOf4);
        f2509eO = m2127a("server_timestamp_ms", valueOf5);
        f2510eP = m2127a("device_timestamp_ms", valueOf5);
        f2511eQ = m2127a("immediate_render", valueOf2);
        f2512eR = m2127a("cleanup_webview", valueOf2);
        f2513eS = m2127a("sanitize_webview", valueOf2);
        f2514eT = m2127a("force_rerender", valueOf2);
        f2515eU = m2127a("ignore_is_showing", valueOf2);
        f2516eV = m2127a("render_empty_adview", valueOf4);
        f2517eW = m2127a("pp", valueOf2);
        f2518eX = m2127a("daostr", valueOf2);
        f2519eY = m2127a("urrr", valueOf2);
    }

    public C1096c(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        } else if (t != null) {
            this.f2547c = str;
            this.f2548d = t;
        } else {
            throw new IllegalArgumentException("No default value specified");
        }
    }

    /* renamed from: a */
    protected static <T> C1096c<T> m2127a(String str, T t) {
        if (t == null) {
            throw new IllegalArgumentException("No default value specified");
        } else if (f2285a.contains(t.getClass())) {
            C1096c<T> cVar = new C1096c<>(str, t);
            if (!f2338b.containsKey(str)) {
                f2338b.put(str, cVar);
                return cVar;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Setting has already been used: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unsupported value type: ");
            sb2.append(t.getClass());
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* renamed from: c */
    public static Collection<C1096c<?>> m2128c() {
        return Collections.unmodifiableCollection(f2338b.values());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public T mo9946a(Object obj) {
        return this.f2548d.getClass().cast(obj);
    }

    /* renamed from: a */
    public String mo9947a() {
        return this.f2547c;
    }

    /* renamed from: b */
    public T mo9948b() {
        return this.f2548d;
    }

    public int compareTo(Object obj) {
        if (!(obj instanceof C1096c)) {
            return 0;
        }
        return this.f2547c.compareTo(((C1096c) obj).mo9947a());
    }
}
