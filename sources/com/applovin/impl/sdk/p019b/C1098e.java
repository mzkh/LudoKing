package com.applovin.impl.sdk.p019b;

import java.util.HashSet;

/* renamed from: com.applovin.impl.sdk.b.e */
public class C1098e<T> {

    /* renamed from: a */
    public static final C1098e<String> f2555a = new C1098e<>("com.applovin.sdk.impl.isFirstRun", String.class);

    /* renamed from: b */
    public static final C1098e<Boolean> f2556b = new C1098e<>("com.applovin.sdk.launched_before", Boolean.class);

    /* renamed from: c */
    public static final C1098e<String> f2557c = new C1098e<>("com.applovin.sdk.user_id", String.class);

    /* renamed from: d */
    public static final C1098e<String> f2558d = new C1098e<>("com.applovin.sdk.compass_id", String.class);

    /* renamed from: e */
    public static final C1098e<String> f2559e = new C1098e<>("com.applovin.sdk.compass_random_token", String.class);

    /* renamed from: f */
    public static final C1098e<String> f2560f = new C1098e<>("com.applovin.sdk.applovin_random_token", String.class);

    /* renamed from: g */
    public static final C1098e<String> f2561g = new C1098e<>("com.applovin.sdk.device_test_group", String.class);

    /* renamed from: h */
    public static final C1098e<String> f2562h = new C1098e<>("com.applovin.sdk.variables", String.class);

    /* renamed from: i */
    public static final C1098e<Boolean> f2563i = new C1098e<>("com.applovin.sdk.compliance.has_user_consent", Boolean.class);

    /* renamed from: j */
    public static final C1098e<Boolean> f2564j = new C1098e<>("com.applovin.sdk.compliance.is_age_restricted_user", Boolean.class);

    /* renamed from: k */
    public static final C1098e<HashSet> f2565k = new C1098e<>("com.applovin.sdk.impl.postbackQueue.key", HashSet.class);

    /* renamed from: l */
    public static final C1098e<String> f2566l = new C1098e<>("com.applovin.sdk.stats", String.class);

    /* renamed from: m */
    public static final C1098e<String> f2567m = new C1098e<>("com.applovin.sdk.errors", String.class);

    /* renamed from: n */
    public static final C1098e<HashSet> f2568n = new C1098e<>("com.applovin.sdk.task.stats", HashSet.class);

    /* renamed from: o */
    public static final C1098e<String> f2569o = new C1098e<>("com.applovin.sdk.network_response_code_mapping", String.class);

    /* renamed from: p */
    public static final C1098e<String> f2570p = new C1098e<>("com.applovin.sdk.event_tracking.super_properties", String.class);

    /* renamed from: q */
    public static final C1098e<String> f2571q = new C1098e<>("com.applovin.sdk.request_tracker.counter", String.class);

    /* renamed from: r */
    public static final C1098e<String> f2572r = new C1098e<>("com.applovin.sdk.zones", String.class);

    /* renamed from: s */
    public static final C1098e<HashSet> f2573s = new C1098e<>("com.applovin.sdk.ad.stats", HashSet.class);

    /* renamed from: t */
    public static final C1098e<Integer> f2574t = new C1098e<>("com.applovin.sdk.last_video_position", Integer.class);

    /* renamed from: u */
    public static final C1098e<Boolean> f2575u = new C1098e<>("com.applovin.sdk.should_resume_video", Boolean.class);

    /* renamed from: v */
    public static final C1098e<String> f2576v = new C1098e<>("com.applovin.sdk.mediation.signal_providers", String.class);

    /* renamed from: w */
    public static final C1098e<String> f2577w = new C1098e<>("com.applovin.sdk.mediation.auto_init_adapters", String.class);

    /* renamed from: x */
    public static final C1098e<String> f2578x = new C1098e<>("com.applovin.sdk.persisted_data", String.class);

    /* renamed from: y */
    public static final C1098e<String> f2579y = new C1098e<>("com.applovin.sdk.mediation_provider", String.class);

    /* renamed from: z */
    public static final C1098e<String> f2580z = new C1098e<>("com.applovin.sdk.mediation.test_mode_network", String.class);

    /* renamed from: A */
    private final String f2581A;

    /* renamed from: B */
    private final Class<T> f2582B;

    public C1098e(String str, Class<T> cls) {
        this.f2581A = str;
        this.f2582B = cls;
    }

    /* renamed from: a */
    public String mo9960a() {
        return this.f2581A;
    }

    /* renamed from: b */
    public Class<T> mo9961b() {
        return this.f2582B;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Key{name='");
        sb.append(this.f2581A);
        sb.append('\'');
        sb.append(", type=");
        sb.append(this.f2582B);
        sb.append('}');
        return sb.toString();
    }
}
