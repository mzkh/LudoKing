package com.applovin.impl.sdk;

import android.util.Log;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.utils.C1277l;

/* renamed from: com.applovin.impl.sdk.o */
public class C1227o {

    /* renamed from: a */
    private final C1192i f3106a;

    C1227o(C1192i iVar) {
        this.f3106a = iVar;
    }

    /* renamed from: a */
    private boolean m2836a() {
        return this.f3106a.mo10178C().mo9959d();
    }

    /* renamed from: c */
    public static void m2837c(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(str);
        sb.append("] ");
        sb.append(str2);
        Log.e("AppLovinSdk", sb.toString(), th);
    }

    /* renamed from: f */
    public static void m2838f(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(str);
        sb.append("] ");
        sb.append(str2);
        Log.d("AppLovinSdk", sb.toString());
    }

    /* renamed from: g */
    public static void m2839g(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(str);
        sb.append("] ");
        sb.append(str2);
        Log.i("AppLovinSdk", sb.toString());
    }

    /* renamed from: h */
    public static void m2840h(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(str);
        sb.append("] ");
        sb.append(str2);
        Log.w("AppLovinSdk", sb.toString());
    }

    /* renamed from: i */
    public static void m2841i(String str, String str2) {
        m2837c(str, str2, null);
    }

    /* renamed from: j */
    private void m2842j(String str, String str2) {
    }

    /* renamed from: a */
    public void mo10374a(String str, Boolean bool, String str2) {
        mo10375a(str, bool, str2, null);
    }

    /* renamed from: a */
    public void mo10375a(String str, Boolean bool, String str2, Throwable th) {
        if (m2836a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            String sb2 = sb.toString();
            Log.e("AppLovinSdk", sb2, th);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(" : ");
            sb3.append(th);
            m2842j("ERROR", sb3.toString());
        }
        if (bool.booleanValue() && ((Boolean) this.f3106a.mo10202a(C1096c.f2546ez)).booleanValue() && this.f3106a.mo10190P() != null) {
            this.f3106a.mo10190P().mo10031a(str2, th);
        }
    }

    /* renamed from: a */
    public void mo10376a(String str, String str2) {
        if (m2836a() && C1277l.m3042b(str2)) {
            int intValue = ((Integer) this.f3106a.mo10202a(C1096c.f2320ai)).intValue();
            if (intValue > 0) {
                int length = str2.length();
                int i = ((length + intValue) - 1) / intValue;
                for (int i2 = 0; i2 < i; i2++) {
                    int i3 = i2 * intValue;
                    mo10378b(str, str2.substring(i3, Math.min(length, i3 + intValue)));
                }
            }
        }
    }

    /* renamed from: a */
    public void mo10377a(String str, String str2, Throwable th) {
        if (m2836a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            String sb2 = sb.toString();
            Log.w("AppLovinSdk", sb2, th);
            m2842j("WARN", sb2);
        }
    }

    /* renamed from: b */
    public void mo10378b(String str, String str2) {
        if (m2836a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            String sb2 = sb.toString();
            Log.d("AppLovinSdk", sb2);
            m2842j("DEBUG", sb2);
        }
    }

    /* renamed from: b */
    public void mo10379b(String str, String str2, Throwable th) {
        mo10375a(str, Boolean.valueOf(true), str2, th);
    }

    /* renamed from: c */
    public void mo10380c(String str, String str2) {
        if (m2836a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
            String sb2 = sb.toString();
            Log.i("AppLovinSdk", sb2);
            m2842j("INFO", sb2);
        }
    }

    /* renamed from: d */
    public void mo10381d(String str, String str2) {
        mo10377a(str, str2, (Throwable) null);
    }

    /* renamed from: e */
    public void mo10382e(String str, String str2) {
        mo10379b(str, str2, null);
    }
}
