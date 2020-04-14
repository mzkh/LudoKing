package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyConstants;

/* renamed from: com.tapjoy.internal.ge */
public final class C3104ge {

    /* renamed from: e */
    private static final C3104ge f7323e;

    /* renamed from: f */
    private static C3104ge f7324f;

    /* renamed from: a */
    public Boolean f7325a = null;

    /* renamed from: b */
    public String f7326b = null;

    /* renamed from: c */
    public Boolean f7327c = null;

    /* renamed from: d */
    public boolean f7328d = false;

    /* renamed from: g */
    private Context f7329g;

    static {
        C3104ge geVar = new C3104ge();
        f7323e = geVar;
        f7324f = geVar;
    }

    /* renamed from: a */
    public static C3104ge m7159a() {
        return f7324f;
    }

    /* renamed from: a */
    public final synchronized void mo30181a(Context context) {
        if (context != null) {
            if (this.f7329g == null) {
                this.f7329g = context;
            }
        }
        C3104ge geVar = f7324f;
        if (geVar.f7329g != null) {
            SharedPreferences sharedPreferences = geVar.f7329g.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
            if (geVar.f7325a == null && sharedPreferences.contains("gdpr")) {
                geVar.f7325a = Boolean.valueOf(sharedPreferences.getBoolean("gdpr", false));
            }
            if (geVar.f7326b == null) {
                geVar.f7326b = sharedPreferences.getString("cgdpr", "");
            }
            if (geVar.f7327c == null && sharedPreferences.contains(TapjoyConstants.PREF_BELOW_CONSENT_AGE)) {
                geVar.f7327c = Boolean.valueOf(sharedPreferences.getBoolean(TapjoyConstants.PREF_BELOW_CONSENT_AGE, false));
            }
        }
        if (this.f7328d) {
            this.f7328d = false;
            C3104ge geVar2 = f7324f;
            if (geVar2.f7329g != null) {
                if (geVar2.f7325a != null) {
                    geVar2.mo30182b();
                }
                if (geVar2.f7326b != null) {
                    geVar2.mo30183c();
                }
                if (geVar2.f7327c != null) {
                    geVar2.mo30184d();
                }
            }
        }
    }

    /* renamed from: b */
    public final boolean mo30182b() {
        Context context = this.f7329g;
        if (context == null) {
            return false;
        }
        Editor edit = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
        edit.putBoolean("gdpr", this.f7325a.booleanValue());
        edit.apply();
        return true;
    }

    /* renamed from: c */
    public final boolean mo30183c() {
        Context context = this.f7329g;
        if (context == null) {
            return false;
        }
        Editor edit = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
        edit.putString("cgdpr", this.f7326b);
        edit.apply();
        return true;
    }

    /* renamed from: d */
    public final boolean mo30184d() {
        Context context = this.f7329g;
        if (context == null) {
            return false;
        }
        Editor edit = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
        edit.putBoolean(TapjoyConstants.PREF_BELOW_CONSENT_AGE, this.f7327c.booleanValue());
        edit.apply();
        TapjoyConnectCore.setAdTrackingEnabled();
        return true;
    }
}
