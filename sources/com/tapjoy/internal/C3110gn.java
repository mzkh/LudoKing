package com.tapjoy.internal;

import android.app.Activity;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;

/* renamed from: com.tapjoy.internal.gn */
public final class C3110gn {
    /* renamed from: a */
    public static void m7177a(Activity activity) {
        C1831gz a = C1831gz.m3554a();
        if (C3124gw.m7219a((Object) activity, "onActivityStart: The given activity was null")) {
            String str = "onActivityStart";
            C3124gw.m7223c(str);
            C1809b.m3452a(activity.getApplication());
            C1809b.m3453b(activity);
            if (a.mo18130c(str) && a.mo18133e()) {
                C3118gt.m7202b(activity);
            }
        }
    }

    /* renamed from: b */
    public static void m7182b(Activity activity) {
        C1831gz a = C1831gz.m3554a();
        if (C3124gw.m7219a((Object) activity, "onActivityStop: The given activity was null")) {
            String str = "onActivityStop";
            C3124gw.m7223c(str);
            C1809b.m3456c(activity);
            if (a.mo18130c(str) && !C1809b.m3454b()) {
                a.f3824h.mo18184a();
            }
        }
    }

    /* renamed from: a */
    public static void m7176a() {
        C1831gz a = C1831gz.m3554a();
        if (a.mo18130c("startSession") && a.mo18133e()) {
            C3118gt.m7202b(null);
        }
    }

    /* renamed from: b */
    public static void m7181b() {
        C1831gz a = C1831gz.m3554a();
        if (a.mo18130c("endSession")) {
            a.f3824h.mo18184a();
        }
    }

    /* renamed from: a */
    public static void m7179a(String str, String str2, String str3, String str4, long j) {
        C1831gz a = C1831gz.m3554a();
        if (a.mo18132d("trackEvent") && C3124gw.m7219a((Object) str2, "trackEvent: name was null")) {
            LinkedHashMap linkedHashMap = null;
            if (j != 0) {
                linkedHashMap = C3231ju.m7504b();
                linkedHashMap.put("value", Long.valueOf(j));
            }
            a.f3823g.mo18117a(str, str2, str3, str4, linkedHashMap);
            C3124gw.m7218a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", str, str2, str3, str4, linkedHashMap);
        }
    }

    /* renamed from: a */
    public static void m7180a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, String str7, long j3) {
        String str8 = str2;
        String str9 = str5;
        String str10 = str6;
        String str11 = str7;
        C1831gz a = C1831gz.m3554a();
        if (a.mo18132d("trackEvent") && C3124gw.m7219a((Object) str2, "trackEvent: name was null")) {
            LinkedHashMap b = C3231ju.m7504b();
            if (!(str9 == null || j == 0)) {
                b.put(str5, Long.valueOf(j));
            }
            if (!(str10 == null || j2 == 0)) {
                b.put(str10, Long.valueOf(j2));
            }
            if (!(str11 == null || j3 == 0)) {
                b.put(str11, Long.valueOf(j3));
            }
            if (b.isEmpty()) {
                b = null;
            }
            a.f3823g.mo18117a(str, str2, str3, str4, b);
            C3124gw.m7218a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", str, str8, str3, str4, b);
        }
    }

    /* renamed from: a */
    public static void m7178a(String str, String str2, String str3, String str4) {
        String str5 = "skuDetails";
        C1831gz a = C1831gz.m3554a();
        String str6 = "trackPurchase";
        if (a.mo18130c(str6)) {
            try {
                C2979e eVar = new C2979e(str);
                String b = C3119gu.m7206b(eVar.f6873a);
                String b2 = C3119gu.m7206b(eVar.f6878f);
                String str7 = "insufficient fields";
                if (b == null || b2 == null) {
                    C3124gw.m7217a(str6, str5, str7);
                } else if (b2.length() != 3) {
                    C3124gw.m7217a(str6, str5, "invalid currency code");
                } else {
                    String b3 = C3119gu.m7206b(str2);
                    String b4 = C3119gu.m7206b(str3);
                    String str8 = "purchaseData";
                    if (b3 != null) {
                        if (b4 != null) {
                            try {
                                C3040f fVar = new C3040f(b3);
                                if (C1852jq.m3669c(fVar.f7053a) || C1852jq.m3669c(fVar.f7054b) || C1852jq.m3669c(fVar.f7055c) || fVar.f7056d == 0) {
                                    C3124gw.m7217a(str6, str8, str7);
                                }
                            } catch (IOException unused) {
                                C3124gw.m7217a(str6, str8, "invalid PurchaseData JSON");
                            }
                        } else {
                            C3124gw.m7217a(str6, "dataSignature", "is null, skipping purchase validation");
                        }
                    } else if (b4 != null) {
                        C3124gw.m7217a(str6, str8, "is null. skipping purchase validation");
                    }
                    String upperCase = b2.toUpperCase(Locale.US);
                    String b5 = C3119gu.m7206b(str4);
                    C1830gy gyVar = a.f3823g;
                    double d = (double) eVar.f6879g;
                    Double.isNaN(d);
                    gyVar.mo18115a(b, upperCase, d / 1000000.0d, b3, b4, b5);
                    if (b3 == null || b4 == null) {
                        C3124gw.m7216a("trackPurchase without purchaseData called");
                    } else {
                        C3124gw.m7216a("trackPurchase with purchaseData called");
                    }
                }
            } catch (IOException unused2) {
                C3124gw.m7217a(str6, str5, "invalid SkuDetails JSON");
            }
        }
    }
}
