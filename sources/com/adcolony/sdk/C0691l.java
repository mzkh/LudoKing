package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import com.facebook.AccessToken;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.NativeProtocol;
import com.tapjoy.TapjoyConstants;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.l */
class C0691l {

    /* renamed from: a */
    static final String f1011a = "Production";

    /* renamed from: g */
    private static int f1012g = 2;

    /* renamed from: b */
    private String f1013b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f1014c;

    /* renamed from: d */
    private boolean f1015d;

    /* renamed from: e */
    private boolean f1016e;

    /* renamed from: f */
    private JSONObject f1017f = C0746u.m892a();

    /* renamed from: h */
    private String f1018h = "android";

    /* renamed from: i */
    private String f1019i = "android_native";

    /* renamed from: j */
    private String f1020j;

    /* renamed from: com.adcolony.sdk.l$a */
    private static class C0696a extends AsyncTask<Void, Void, JSONObject> {

        /* renamed from: a */
        private C0480ab f1027a;

        /* renamed from: b */
        private boolean f1028b;

        C0696a(C0480ab abVar, boolean z) {
            this.f1027a = abVar;
            this.f1028b = z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public JSONObject doInBackground(Void... voidArr) {
            if (VERSION.SDK_INT < 14) {
                return null;
            }
            return C0476a.m77a().mo8579m().mo8619J();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(JSONObject jSONObject) {
            if (this.f1028b) {
                new C0480ab("Device.update_info", 1, jSONObject).mo8217b();
            } else {
                this.f1027a.mo8216a(jSONObject).mo8217b();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: F */
    public String mo8615F() {
        return "4.1.0";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: x */
    public String mo8648x() {
        return "";
    }

    C0691l() {
        String str = "";
        this.f1013b = str;
        this.f1014c = str;
        this.f1020j = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8622a(JSONObject jSONObject) {
        this.f1017f = jSONObject;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo8620a() {
        return this.f1017f;
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"HardwareIds"})
    /* renamed from: b */
    public String mo8624b() {
        Context c = C0476a.m85c();
        if (c == null) {
            return "";
        }
        return Secure.getString(c.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo8627c() {
        return this.f1013b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8621a(String str) {
        this.f1013b = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8623a(boolean z) {
        this.f1015d = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo8628d() {
        return System.getProperty("os.arch").toLowerCase(Locale.ENGLISH);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo8629e() {
        this.f1015d = false;
        C0476a.m81a("Device.get_info", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                C0543at.m309a((Runnable) new Runnable() {
                    public void run() {
                        try {
                            if (C0691l.this.mo8643s() < 14) {
                                new C0696a(abVar, false).execute(new Void[0]);
                            } else {
                                new C0696a(abVar, false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            }
                        } catch (RuntimeException unused) {
                            new C0749a().mo8726a("Error retrieving device info, disabling AdColony.").mo8728a(C0748w.f1172h);
                            AdColony.disable();
                        }
                    }
                });
            }
        });
        C0476a.m81a("Device.application_exists", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                JSONObject a = C0746u.m892a();
                C0746u.m913b(a, "result", C0543at.m310a(C0746u.m908b(abVar.mo8220c(), "name")));
                C0746u.m913b(a, "success", true);
                abVar.mo8216a(a).mo8217b();
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo8630f() {
        return mo8645u() ? "tablet" : "phone";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo8631g() {
        return this.f1016e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8626b(boolean z) {
        this.f1016e = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public String mo8632h() {
        return this.f1020j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8625b(String str) {
        this.f1020j = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public String mo8633i() {
        Context c = C0476a.m85c();
        String str = "";
        if (c == null) {
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) c.getSystemService("phone");
        if (telephonyManager != null) {
            str = telephonyManager.getNetworkOperatorName();
        }
        if (str.length() == 0) {
            str = "unknown";
        }
        return str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public int mo8634j() {
        Context c = C0476a.m85c();
        int i = 0;
        if (c == null) {
            return 0;
        }
        ActivityManager activityManager = (ActivityManager) c.getSystemService("activity");
        if (activityManager != null) {
            i = activityManager.getMemoryClass();
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public String mo8635k() {
        Context c = C0476a.m85c();
        String str = "";
        if (c == null) {
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) c.getSystemService("phone");
        if (telephonyManager != null) {
            str = telephonyManager.getSimCountryIso();
        }
        return str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public String mo8636l() {
        return TimeZone.getDefault().getID();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public int mo8637m() {
        return TimeZone.getDefault().getOffset(15) / 60000;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public int mo8638n() {
        TimeZone timeZone = TimeZone.getDefault();
        if (!timeZone.inDaylightTime(new Date())) {
            return 0;
        }
        return timeZone.getDSTSavings() / 60000;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public long mo8639o() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / ((long) 1048576);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public float mo8640p() {
        Context c = C0476a.m85c();
        if (c == null) {
            return 0.0f;
        }
        return c.getResources().getDisplayMetrics().density;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public int mo8641q() {
        Context c = C0476a.m85c();
        if (c == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) c.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public int mo8642r() {
        Context c = C0476a.m85c();
        if (c == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) c.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public int mo8643s() {
        return VERSION.SDK_INT;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public double mo8644t() {
        Context c = C0476a.m85c();
        double d = 0.0d;
        if (c == null) {
            return 0.0d;
        }
        Intent registerReceiver = c.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return 0.0d;
        }
        int intExtra = registerReceiver.getIntExtra("level", -1);
        int intExtra2 = registerReceiver.getIntExtra("scale", -1);
        if (intExtra >= 0 && intExtra2 >= 0) {
            double d2 = (double) intExtra;
            double d3 = (double) intExtra2;
            Double.isNaN(d2);
            Double.isNaN(d3);
            d = d2 / d3;
        }
        return d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: u */
    public boolean mo8645u() {
        Context c = C0476a.m85c();
        boolean z = false;
        if (c == null) {
            return false;
        }
        DisplayMetrics displayMetrics = c.getResources().getDisplayMetrics();
        float f = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
        float f2 = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
        if (Math.sqrt((double) ((f * f) + (f2 * f2))) >= 6.0d) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: v */
    public String mo8646v() {
        return Locale.getDefault().getLanguage();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: w */
    public String mo8647w() {
        return Locale.getDefault().getCountry();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: y */
    public boolean mo8649y() {
        Context c = C0476a.m85c();
        if (c == null || VERSION.SDK_INT < 29) {
            return false;
        }
        int i = c.getResources().getConfiguration().uiMode & 48;
        if (i == 16 || i != 32) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: z */
    public String mo8650z() {
        return Build.MANUFACTURER;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: A */
    public String mo8610A() {
        return Build.MODEL;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: B */
    public String mo8611B() {
        return VERSION.RELEASE;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: C */
    public boolean mo8612C() {
        return VERSION.SDK_INT < 23 || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: D */
    public int mo8613D() {
        Context c = C0476a.m85c();
        if (c == null) {
            return 2;
        }
        int i = c.getResources().getConfiguration().orientation;
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return 2;
        }
        return 1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: E */
    public int mo8614E() {
        Context c = C0476a.m85c();
        if (c == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) c.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.densityDpi;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: G */
    public String mo8616G() {
        final Context c = C0476a.m85c();
        if (this.f1014c.equals("") && c != null) {
            C0543at.m309a((Runnable) new Runnable() {
                public void run() {
                    try {
                        C0691l.this.f1014c = new WebView(c).getSettings().getUserAgentString();
                    } catch (RuntimeException e) {
                        C0749a aVar = new C0749a();
                        StringBuilder sb = new StringBuilder();
                        sb.append(e.toString());
                        sb.append(": during WebView initialization.");
                        aVar.mo8726a(sb.toString()).mo8726a(" Disabling AdColony.").mo8728a(C0748w.f1171g);
                        AdColony.disable();
                    }
                    C0476a.m77a().mo8585s().mo8671a(C0691l.this.f1014c);
                }
            });
        }
        return this.f1014c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: H */
    public String mo8617H() {
        Context c = C0476a.m85c();
        return c == null ? "unknown" : c.getPackageName();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: I */
    public boolean mo8618I() {
        if (!C0476a.m86d()) {
            return false;
        }
        int D = mo8613D();
        String str = "Sending device info update";
        if (D != 0) {
            if (D == 1 && f1012g == 0) {
                new C0749a().mo8726a(str).mo8728a(C0748w.f1168d);
                f1012g = D;
                if (mo8643s() < 14) {
                    new C0696a(null, true).execute(new Void[0]);
                } else {
                    new C0696a(null, true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                }
                return true;
            }
        } else if (f1012g == 1) {
            new C0749a().mo8726a(str).mo8728a(C0748w.f1168d);
            f1012g = D;
            if (mo8643s() < 14) {
                new C0696a(null, true).execute(new Void[0]);
            } else {
                new C0696a(null, true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: J */
    public JSONObject mo8619J() {
        JSONObject a = C0746u.m892a();
        C0666j a2 = C0476a.m77a();
        C0746u.m902a(a, TapjoyConstants.TJC_CARRIER_NAME, mo8633i());
        C0746u.m902a(a, "data_path", C0476a.m77a().mo8581o().mo8316e());
        C0746u.m912b(a, "device_api", mo8643s());
        C0746u.m912b(a, "display_width", mo8641q());
        C0746u.m912b(a, "display_height", mo8642r());
        C0746u.m912b(a, "screen_width", mo8641q());
        C0746u.m912b(a, "screen_height", mo8642r());
        C0746u.m912b(a, "display_dpi", mo8614E());
        C0746u.m902a(a, TapjoyConstants.TJC_DEVICE_TYPE_NAME, mo8630f());
        C0746u.m902a(a, "locale_language_code", mo8646v());
        C0746u.m902a(a, UserDataStore.LAST_NAME, mo8646v());
        C0746u.m902a(a, "locale_country_code", mo8647w());
        C0746u.m902a(a, "locale", mo8647w());
        C0746u.m902a(a, TapjoyConstants.TJC_DEVICE_MAC_ADDRESS, mo8648x());
        C0746u.m902a(a, "manufacturer", mo8650z());
        C0746u.m902a(a, "device_brand", mo8650z());
        C0746u.m902a(a, "media_path", C0476a.m77a().mo8581o().mo8315d());
        C0746u.m902a(a, "temp_storage_path", C0476a.m77a().mo8581o().mo8317f());
        C0746u.m912b(a, "memory_class", mo8634j());
        C0746u.m912b(a, "network_speed", 20);
        C0746u.m901a(a, "memory_used_mb", mo8639o());
        C0746u.m902a(a, "model", mo8610A());
        C0746u.m902a(a, "device_model", mo8610A());
        C0746u.m902a(a, TapjoyConstants.TJC_SDK_TYPE, this.f1019i);
        C0746u.m902a(a, "sdk_version", mo8615F());
        C0746u.m902a(a, "network_type", a2.f957d.mo8243c());
        C0746u.m902a(a, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, mo8611B());
        C0746u.m902a(a, "os_name", this.f1018h);
        C0746u.m902a(a, TapjoyConstants.TJC_PLATFORM, this.f1018h);
        C0746u.m902a(a, "arch", mo8628d());
        JSONObject jSONObject = a2.mo8567d().f100d;
        String str = AccessToken.USER_ID_KEY;
        C0746u.m902a(a, str, C0746u.m908b(jSONObject, str));
        C0746u.m902a(a, "app_id", a2.mo8567d().f97a);
        C0746u.m902a(a, "app_bundle_name", C0543at.m323d());
        C0746u.m902a(a, "app_bundle_version", C0543at.m317b());
        C0746u.m900a(a, "battery_level", mo8644t());
        C0746u.m902a(a, "cell_service_country_code", mo8635k());
        C0746u.m902a(a, "timezone_ietf", mo8636l());
        C0746u.m912b(a, "timezone_gmt_m", mo8637m());
        C0746u.m912b(a, "timezone_dst_m", mo8638n());
        C0746u.m904a(a, "launch_metadata", mo8620a());
        C0746u.m902a(a, "controller_version", a2.mo8560b());
        f1012g = mo8613D();
        C0746u.m912b(a, "current_orientation", f1012g);
        C0746u.m913b(a, "cleartext_permitted", mo8612C());
        C0746u.m900a(a, "density", (double) mo8640p());
        C0746u.m913b(a, "dark_mode", mo8649y());
        JSONArray b = C0746u.m909b();
        if (C0543at.m310a("com.android.vending")) {
            b.put("google");
        }
        if (C0543at.m310a("com.amazon.venezia")) {
            b.put("amazon");
        }
        C0746u.m903a(a, "available_stores", b);
        C0746u.m903a(a, NativeProtocol.RESULT_ARGS_PERMISSIONS, C0543at.m324d(C0476a.m85c()));
        int i = 40;
        while (!this.f1015d && i > 0) {
            try {
                Thread.sleep(50);
                i--;
            } catch (Exception unused) {
            }
        }
        C0746u.m902a(a, "advertiser_id", mo8627c());
        C0746u.m913b(a, "limit_tracking", mo8631g());
        if (mo8627c() == null || mo8627c().equals("")) {
            C0746u.m902a(a, "android_id_sha1", C0543at.m322c(mo8624b()));
        }
        return a;
    }
}
