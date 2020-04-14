package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tapjoy.internal.hj */
public final class C3144hj {

    /* renamed from: A */
    public final C3250o f7424A = new C3250o(this.f7429b, "idfa");

    /* renamed from: B */
    public final C3127h f7425B = new C3127h(this.f7429b, "idfa.optout");

    /* renamed from: C */
    final C3127h f7426C = new C3127h(this.f7429b, "push.optout");

    /* renamed from: D */
    final C3250o f7427D = new C3250o(this.f7429b, "appId");

    /* renamed from: a */
    final Context f7428a;

    /* renamed from: b */
    final SharedPreferences f7429b;

    /* renamed from: c */
    final C3250o f7430c = new C3250o(this.f7429b, "sdk");

    /* renamed from: d */
    final C3250o f7431d = new C3250o(this.f7429b, "ir");

    /* renamed from: e */
    final C3236k f7432e = new C3236k(this.f7429b, "fql", 0);

    /* renamed from: f */
    final C3236k f7433f = new C3236k(this.f7429b, "fq", 0);

    /* renamed from: g */
    final C3250o f7434g = new C3250o(this.f7429b, "push");

    /* renamed from: h */
    final C3236k f7435h = new C3236k(this.f7429b, "ss", 0);

    /* renamed from: i */
    final C3247l f7436i = new C3247l(this.f7429b, "std");

    /* renamed from: j */
    final C3247l f7437j = new C3247l(this.f7429b, "slt");

    /* renamed from: k */
    final C3247l f7438k = new C3247l(this.f7429b, "sld");

    /* renamed from: l */
    final C3250o f7439l = new C3250o(this.f7429b, "ptc");

    /* renamed from: m */
    final C3236k f7440m = new C3236k(this.f7429b, "pc", 0);

    /* renamed from: n */
    final C3169i f7441n = new C3169i(this.f7429b, "ptp");

    /* renamed from: o */
    final C3247l f7442o = new C3247l(this.f7429b, "lpt");

    /* renamed from: p */
    final C3169i f7443p = new C3169i(this.f7429b, "plp");

    /* renamed from: q */
    final C3250o f7444q = new C3250o(this.f7429b, "adv");

    /* renamed from: r */
    final C3250o f7445r = new C3250o(this.f7429b, "ui");

    /* renamed from: s */
    final C3236k f7446s = new C3236k(this.f7429b, "ul", -1);

    /* renamed from: t */
    final C3236k f7447t = new C3236k(this.f7429b, "uf", -1);

    /* renamed from: u */
    final C3250o f7448u = new C3250o(this.f7429b, TapjoyConstants.TJC_USER_VARIABLE_1);

    /* renamed from: v */
    final C3250o f7449v = new C3250o(this.f7429b, TapjoyConstants.TJC_USER_VARIABLE_2);

    /* renamed from: w */
    final C3250o f7450w = new C3250o(this.f7429b, TapjoyConstants.TJC_USER_VARIABLE_3);

    /* renamed from: x */
    final C3250o f7451x = new C3250o(this.f7429b, TapjoyConstants.TJC_USER_VARIABLE_4);

    /* renamed from: y */
    final C3250o f7452y = new C3250o(this.f7429b, TapjoyConstants.TJC_USER_VARIABLE_5);

    /* renamed from: z */
    final C3250o f7453z = new C3250o(this.f7429b, "utags");

    /* renamed from: a */
    public static C3144hj m7269a(Context context) {
        return new C3144hj(context);
    }

    private C3144hj(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f7428a = applicationContext;
        this.f7429b = applicationContext.getSharedPreferences("fiverocks", 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Editor mo30217a() {
        return this.f7429b.edit();
    }

    /* renamed from: b */
    public final String mo30219b() {
        String str = "ir";
        String string = this.f7429b.getString(str, null);
        if (string == null) {
            File file = new File(C1831gz.m3559c(this.f7428a), TapjoyConstants.TJC_REFERRER);
            if (file.exists()) {
                try {
                    string = C1810bg.m3458a(file, C2873ak.f6671c);
                } catch (IOException unused) {
                }
            }
            this.f7429b.edit().putString(str, string != null ? string : "").apply();
            if (string == null || string.length() <= 0) {
                return null;
            }
            return string;
        } else if (string.length() > 0) {
            return string;
        } else {
            return null;
        }
    }

    /* renamed from: a */
    public final void mo30218a(boolean z) {
        C3249n.m7542a(this.f7429b, "gcm.onServer", z);
    }
}
