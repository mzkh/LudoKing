package com.adcolony.sdk;

import androidx.annotation.NonNull;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import org.json.JSONObject;

public class AdColonyZone {
    public static final int BANNER = 1;
    public static final int INTERSTITIAL = 0;
    @Deprecated
    public static final int NATIVE = 2;

    /* renamed from: a */
    static final int f130a = 0;

    /* renamed from: b */
    static final int f131b = 1;

    /* renamed from: c */
    static final int f132c = 2;

    /* renamed from: d */
    static final int f133d = 3;

    /* renamed from: e */
    static final int f134e = 4;

    /* renamed from: f */
    static final int f135f = 5;

    /* renamed from: g */
    static final int f136g = 6;

    /* renamed from: h */
    private String f137h;

    /* renamed from: i */
    private String f138i;

    /* renamed from: j */
    private String f139j;

    /* renamed from: k */
    private String f140k;

    /* renamed from: l */
    private int f141l = 5;

    /* renamed from: m */
    private int f142m;

    /* renamed from: n */
    private int f143n;

    /* renamed from: o */
    private int f144o;

    /* renamed from: p */
    private int f145p;

    /* renamed from: q */
    private int f146q;

    /* renamed from: r */
    private int f147r;

    /* renamed from: s */
    private boolean f148s;

    /* renamed from: t */
    private boolean f149t;

    AdColonyZone(@NonNull String str) {
        this.f137h = str;
    }

    /* renamed from: c */
    private int m69c(int i) {
        if (C0476a.m84b() && !C0476a.m77a().mo8573g() && !C0476a.m77a().mo8574h()) {
            return i;
        }
        m70c();
        return 0;
    }

    /* renamed from: a */
    private boolean m68a(boolean z) {
        if (C0476a.m84b() && !C0476a.m77a().mo8573g() && !C0476a.m77a().mo8574h()) {
            return z;
        }
        m70c();
        return false;
    }

    /* renamed from: a */
    private String m66a(String str) {
        return m67a(str, "");
    }

    /* renamed from: a */
    private String m67a(String str, String str2) {
        if (C0476a.m84b() && !C0476a.m77a().mo8573g() && !C0476a.m77a().mo8574h()) {
            return str;
        }
        m70c();
        return str2;
    }

    public String getZoneID() {
        return m66a(this.f137h);
    }

    public int getRemainingViewsUntilReward() {
        return m69c(this.f143n);
    }

    public int getRewardAmount() {
        return m69c(this.f146q);
    }

    public String getRewardName() {
        return m66a(this.f138i);
    }

    public int getViewsPerReward() {
        return m69c(this.f144o);
    }

    public int getZoneType() {
        return this.f142m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8191a() {
        return this.f141l == 0;
    }

    public boolean isValid() {
        return m68a(this.f148s);
    }

    public boolean isRewarded() {
        return this.f149t;
    }

    public int getPlayFrequency() {
        return m69c(this.f145p);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8190a(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        JSONObject f = C0746u.m921f(c, "reward");
        this.f138i = C0746u.m908b(f, "reward_name");
        this.f146q = C0746u.m914c(f, "reward_amount");
        this.f144o = C0746u.m914c(f, "views_per_reward");
        this.f143n = C0746u.m914c(f, "views_until_reward");
        this.f139j = C0746u.m908b(f, "reward_name_plural");
        this.f140k = C0746u.m908b(f, "reward_prompt");
        this.f149t = C0746u.m918d(c, "rewarded");
        this.f141l = C0746u.m914c(c, "status");
        this.f142m = C0746u.m914c(c, "type");
        this.f145p = C0746u.m914c(c, "play_interval");
        this.f137h = C0746u.m908b(c, AdColonyAdapterUtils.KEY_ZONE_ID);
        boolean z = true;
        if (this.f141l == 1) {
            z = false;
        }
        this.f148s = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8189a(int i) {
        this.f147r = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo8192b() {
        return this.f147r;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8193b(int i) {
        this.f141l = i;
    }

    /* renamed from: c */
    private void m70c() {
        new C0749a().mo8726a("The AdColonyZone API is not available while AdColony is disabled.").mo8728a(C0748w.f1171g);
    }
}
