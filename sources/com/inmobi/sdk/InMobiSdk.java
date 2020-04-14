package com.inmobi.sdk;

import android.content.Context;
import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.inmobi.media.C2438es;
import com.inmobi.media.C2505gd;
import com.inmobi.media.C2506ge;
import com.inmobi.media.C2514gh;
import com.inmobi.media.C2516gj;
import com.inmobi.media.C2518gl;
import com.inmobi.media.C2532gs;
import com.inmobi.media.C2534gu;
import com.inmobi.media.C2579hs;
import java.util.Locale;
import org.json.JSONObject;

public final class InMobiSdk {
    public static final String IM_GDPR_CONSENT_AVAILABLE = "gdpr_consent_available";
    public static final String IM_GDPR_CONSENT_IAB = "gdpr_consent";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f5968a = "InMobiSdk";

    /* renamed from: com.inmobi.sdk.InMobiSdk$3 */
    static /* synthetic */ class C26773 {

        /* renamed from: a */
        static final /* synthetic */ int[] f5971a = new int[LogLevel.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.inmobi.sdk.InMobiSdk$LogLevel[] r0 = com.inmobi.sdk.InMobiSdk.LogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5971a = r0
                int[] r0 = f5971a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.inmobi.sdk.InMobiSdk$LogLevel r1 = com.inmobi.sdk.InMobiSdk.LogLevel.NONE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f5971a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.inmobi.sdk.InMobiSdk$LogLevel r1 = com.inmobi.sdk.InMobiSdk.LogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f5971a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.inmobi.sdk.InMobiSdk$LogLevel r1 = com.inmobi.sdk.InMobiSdk.LogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.inmobi.sdk.InMobiSdk.C26773.<clinit>():void");
        }
    }

    public enum AgeGroup {
        BELOW_18("below18"),
        BETWEEN_18_AND_24("between18and24"),
        BETWEEN_25_AND_29("between25and29"),
        BETWEEN_30_AND_34("between30and34"),
        BETWEEN_35_AND_44("between35and44"),
        BETWEEN_45_AND_54("between45and54"),
        BETWEEN_55_AND_65("between55and65"),
        ABOVE_65("above65");
        
        private String value;

        private AgeGroup(String str) {
            this.value = str;
        }

        public final String toString() {
            return this.value;
        }
    }

    public enum Education {
        HIGH_SCHOOL_OR_LESS("highschoolorless"),
        COLLEGE_OR_GRADUATE("collegeorgraduate"),
        POST_GRADUATE_OR_ABOVE("postgraduateorabove");
        
        private String value;

        private Education(String str) {
            this.value = str;
        }

        public final String toString() {
            return this.value;
        }
    }

    public enum Gender {
        FEMALE("f"),
        MALE("m");
        
        private String value;

        private Gender(String str) {
            this.value = str;
        }

        public final String toString() {
            return this.value;
        }
    }

    public enum LogLevel {
        NONE,
        ERROR,
        DEBUG
    }

    public static void init(@NonNull Context context, @Size(max = 36, min = 32) @NonNull String str) {
        init(context, str, null);
    }

    public static void init(@NonNull final Context context, @Size(max = 36, min = 32) @NonNull String str, @Nullable JSONObject jSONObject) {
        C2518gl.m5362a();
        final String trim = str.trim();
        try {
            C2532gs.m5402a(jSONObject);
            if (trim.length() == 0) {
                C2514gh.m5342a(1, f5968a, "Account id cannot be empty. Please provide a valid account id.");
                return;
            }
            if (!C2516gj.m5357a(context, "android.permission.ACCESS_COARSE_LOCATION") && !C2516gj.m5357a(context, "android.permission.ACCESS_FINE_LOCATION")) {
                C2514gh.m5342a(1, f5968a, "Please grant the location permissions (ACCESS_COARSE_LOCATION or ACCESS_FINE_LOCATION, or both) for better ad targeting.");
            }
            if (!(trim.length() == 32 || trim.length() == 36)) {
                C2514gh.m5342a(2, f5968a, "Invalid account id passed to init. Please provide a valid account id.");
            }
            if (!C2505gd.m5297b()) {
                C2579hs.m5619a(context);
                C2505gd.m5288a(context, trim);
                C2505gd.m5290a((Runnable) new Runnable() {
                    public final void run() {
                        try {
                            C2505gd.m5295b(trim);
                            C2438es.m5091a(trim);
                            C2579hs.m5622b(context);
                        } catch (Exception unused) {
                            InMobiSdk.f5968a;
                        }
                    }
                });
                C2514gh.m5342a(2, f5968a, "InMobi SDK initialized with account id: ".concat(String.valueOf(trim)));
                C2505gd.m5290a((Runnable) new Runnable() {
                    public final void run() {
                        String[] strArr = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE"};
                        StringBuilder sb = new StringBuilder("Permissions granted to SDK are :\nandroid.permission.INTERNET\nandroid.permission.ACCESS_NETWORK_STATE");
                        for (int i = 0; i < 4; i++) {
                            String str = strArr[i];
                            if (C2516gj.m5357a(C2505gd.m5298c(), str)) {
                                sb.append("\n");
                                sb.append(str);
                            }
                        }
                        C2514gh.m5342a(2, InMobiSdk.f5968a, sb.toString());
                    }
                });
            }
        } catch (Exception unused) {
            C2505gd.m5285a((Context) null);
            C2514gh.m5342a(1, f5968a, "SDK could not be initialized; an unexpected error was encountered");
        }
    }

    public static void updateGDPRConsent(JSONObject jSONObject) {
        C2532gs.m5402a(jSONObject);
    }

    public static void setApplicationMuted(boolean z) {
        C2505gd.m5291a(z);
    }

    public static String getVersion() {
        return C2506ge.m5320b();
    }

    public static void setLogLevel(LogLevel logLevel) {
        int i = C26773.f5971a[logLevel.ordinal()];
        if (i == 1) {
            C2514gh.m5341a(0);
        } else if (i == 2) {
            C2514gh.m5341a(1);
        } else if (i != 3) {
            C2514gh.m5341a(2);
        } else {
            C2514gh.m5341a(2);
        }
    }

    public static void setAge(int i) {
        C2534gu.m5410a(i);
    }

    public static void setAgeGroup(AgeGroup ageGroup) {
        C2534gu.m5412a(ageGroup.toString().toLowerCase(Locale.ENGLISH));
    }

    public static void setAreaCode(String str) {
        C2534gu.m5416b(str);
    }

    public static void setPostalCode(String str) {
        C2534gu.m5418c(str);
    }

    public static void setLocationWithCityStateCountry(String str, String str2, String str3) {
        C2534gu.m5419d(str);
        C2534gu.m5420e(str2);
        C2534gu.m5421f(str3);
    }

    public static void setYearOfBirth(int i) {
        C2534gu.m5415b(i);
    }

    public static void setGender(Gender gender) {
        C2534gu.m5422g(gender.toString().toLowerCase(Locale.ENGLISH));
    }

    public static void setEducation(Education education) {
        C2534gu.m5423h(education.toString().toLowerCase(Locale.ENGLISH));
    }

    public static void setLanguage(String str) {
        C2534gu.m5424i(str);
    }

    public static void setInterests(String str) {
        C2534gu.m5425j(str);
    }

    public static void setLocation(Location location) {
        C2534gu.m5411a(location);
    }
}
