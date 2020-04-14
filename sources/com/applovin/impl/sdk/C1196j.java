package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1142i;
import com.applovin.impl.sdk.p021d.C1142i.C1143a;
import com.applovin.impl.sdk.utils.C1243d;
import com.applovin.impl.sdk.utils.C1245f;
import com.applovin.impl.sdk.utils.C1275j;
import com.applovin.impl.sdk.utils.C1276k;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.tapjoy.TJAdUnitConstants.String;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.j */
public class C1196j {

    /* renamed from: e */
    private static String f2964e;

    /* renamed from: f */
    private static String f2965f;

    /* renamed from: g */
    private static int f2966g;

    /* renamed from: a */
    private final C1192i f2967a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1227o f2968b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f2969c;

    /* renamed from: d */
    private final Map<Class, Object> f2970d;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final AtomicReference<C1199a> f2971h = new AtomicReference<>();

    /* renamed from: com.applovin.impl.sdk.j$a */
    public static class C1199a {

        /* renamed from: a */
        public boolean f2976a;

        /* renamed from: b */
        public String f2977b = "";
    }

    /* renamed from: com.applovin.impl.sdk.j$b */
    public static class C1200b {

        /* renamed from: a */
        public String f2978a;

        /* renamed from: b */
        public String f2979b;

        /* renamed from: c */
        public String f2980c;

        /* renamed from: d */
        public String f2981d;

        /* renamed from: e */
        public String f2982e;

        /* renamed from: f */
        public String f2983f;

        /* renamed from: g */
        public long f2984g;
    }

    /* renamed from: com.applovin.impl.sdk.j$c */
    public static class C1201c {

        /* renamed from: a */
        public int f2985a = -1;

        /* renamed from: b */
        public int f2986b = -1;
    }

    /* renamed from: com.applovin.impl.sdk.j$d */
    public static class C1202d {

        /* renamed from: A */
        public boolean f2987A;

        /* renamed from: B */
        public boolean f2988B;

        /* renamed from: C */
        public int f2989C = -1;

        /* renamed from: D */
        public String f2990D;

        /* renamed from: E */
        public long f2991E;

        /* renamed from: F */
        public C1203e f2992F = new C1203e();

        /* renamed from: G */
        public Boolean f2993G;

        /* renamed from: H */
        public Boolean f2994H;

        /* renamed from: I */
        public boolean f2995I;

        /* renamed from: a */
        public String f2996a;

        /* renamed from: b */
        public String f2997b;

        /* renamed from: c */
        public String f2998c;

        /* renamed from: d */
        public String f2999d;

        /* renamed from: e */
        public String f3000e;

        /* renamed from: f */
        public String f3001f;

        /* renamed from: g */
        public String f3002g;

        /* renamed from: h */
        public int f3003h;

        /* renamed from: i */
        public String f3004i;

        /* renamed from: j */
        public String f3005j;

        /* renamed from: k */
        public Locale f3006k;

        /* renamed from: l */
        public String f3007l;

        /* renamed from: m */
        public float f3008m;

        /* renamed from: n */
        public int f3009n;

        /* renamed from: o */
        public float f3010o;

        /* renamed from: p */
        public float f3011p;

        /* renamed from: q */
        public double f3012q;

        /* renamed from: r */
        public double f3013r;

        /* renamed from: s */
        public int f3014s;

        /* renamed from: t */
        public boolean f3015t;

        /* renamed from: u */
        public C1201c f3016u;

        /* renamed from: v */
        public int f3017v;

        /* renamed from: w */
        public String f3018w;

        /* renamed from: x */
        public boolean f3019x;

        /* renamed from: y */
        public boolean f3020y;

        /* renamed from: z */
        public boolean f3021z;
    }

    /* renamed from: com.applovin.impl.sdk.j$e */
    public static class C1203e {

        /* renamed from: a */
        public long f3022a = -1;

        /* renamed from: b */
        public long f3023b = -1;

        /* renamed from: c */
        public long f3024c = -1;

        /* renamed from: d */
        public boolean f3025d = false;
    }

    protected C1196j(C1192i iVar) {
        if (iVar != null) {
            this.f2967a = iVar;
            this.f2968b = iVar.mo10249v();
            this.f2969c = iVar.mo10179D();
            this.f2970d = Collections.synchronizedMap(new HashMap());
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: a */
    private C1202d m2646a(C1202d dVar) {
        String str = "DataCollector";
        if (dVar == null) {
            dVar = new C1202d();
        }
        dVar.f2993G = C1179f.m2526a(this.f2969c);
        dVar.f2994H = C1179f.m2530b(this.f2969c);
        dVar.f3016u = ((Boolean) this.f2967a.mo10202a(C1096c.f2523ec)).booleanValue() ? m2657j() : null;
        if (((Boolean) this.f2967a.mo10202a(C1096c.f2534en)).booleanValue()) {
            dVar.f3015t = m2661n();
        }
        try {
            AudioManager audioManager = (AudioManager) this.f2969c.getSystemService("audio");
            if (audioManager != null) {
                dVar.f3017v = (int) (((float) audioManager.getStreamVolume(3)) * ((Float) this.f2967a.mo10202a(C1096c.f2535eo)).floatValue());
            }
        } catch (Throwable th) {
            this.f2968b.mo10379b(str, "Unable to collect volume", th);
        }
        if (((Boolean) this.f2967a.mo10202a(C1096c.f2536ep)).booleanValue()) {
            if (f2964e == null) {
                String r = m2665r();
                if (!C1277l.m3042b(r)) {
                    r = "";
                }
                f2964e = r;
            }
            if (C1277l.m3042b(f2964e)) {
                dVar.f3018w = f2964e;
            }
        }
        if (((Boolean) this.f2967a.mo10202a(C1096c.f2527eg)).booleanValue()) {
            try {
                dVar.f2991E = Environment.getDataDirectory().getFreeSpace();
            } catch (Throwable th2) {
                dVar.f2991E = -1;
                this.f2968b.mo10379b(str, "Unable to collect free space.", th2);
            }
        }
        if (((Boolean) this.f2967a.mo10202a(C1096c.f2528eh)).booleanValue()) {
            try {
                ActivityManager activityManager = (ActivityManager) this.f2969c.getSystemService("activity");
                MemoryInfo memoryInfo = new MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                dVar.f2992F.f3023b = memoryInfo.availMem;
                dVar.f2992F.f3025d = memoryInfo.lowMemory;
                dVar.f2992F.f3024c = memoryInfo.threshold;
                dVar.f2992F.f3022a = memoryInfo.totalMem;
            } catch (Throwable th3) {
                this.f2968b.mo10379b(str, "Unable to collect memory info.", th3);
            }
        }
        String str2 = (String) this.f2967a.mo10178C().mo9951a(C1096c.f2538er);
        int i = 0;
        if (!str2.equalsIgnoreCase(f2965f)) {
            try {
                f2965f = str2;
                PackageInfo packageInfo = this.f2969c.getPackageManager().getPackageInfo(str2, 0);
                dVar.f3014s = packageInfo.versionCode;
                f2966g = packageInfo.versionCode;
            } catch (Throwable unused) {
                f2966g = 0;
            }
        } else {
            dVar.f3014s = f2966g;
        }
        if (((Boolean) this.f2967a.mo10202a(C1096c.f2524ed)).booleanValue()) {
            dVar.f3021z = AppLovinSdkUtils.isTablet(this.f2969c);
        }
        if (((Boolean) this.f2967a.mo10202a(C1096c.f2525ee)).booleanValue()) {
            dVar.f2987A = m2660m();
        }
        if (((Boolean) this.f2967a.mo10202a(C1096c.f2526ef)).booleanValue()) {
            String k = m2658k();
            if (!TextUtils.isEmpty(k)) {
                dVar.f2990D = k;
            }
        }
        dVar.f3007l = m2654g();
        if (((Boolean) this.f2967a.mo10202a(C1096c.f2529ei)).booleanValue()) {
            dVar.f2988B = C1281o.m3110d();
        }
        if (C1245f.m2935f()) {
            try {
                if (((PowerManager) this.f2969c.getSystemService("power")).isPowerSaveMode()) {
                    i = 1;
                }
                dVar.f2989C = i;
            } catch (Throwable th4) {
                this.f2968b.mo10379b(str, "Unable to collect power saving mode", th4);
            }
        }
        return dVar;
    }

    /* renamed from: a */
    private String m2647a(int i) {
        if (i == 1) {
            return "receiver";
        }
        if (i == 2) {
            return "speaker";
        }
        if (i == 4 || i == 3) {
            return "headphones";
        }
        if (i == 8) {
            return "bluetootha2dpoutput";
        }
        if (i == 13 || i == 19 || i == 5 || i == 6 || i == 12 || i == 11) {
            return "lineout";
        }
        if (i == 9 || i == 10) {
            return "hdmioutput";
        }
        return null;
    }

    /* renamed from: a */
    private boolean m2648a(String str) {
        if (str != null) {
            Context context = this.f2969c;
            if (context != null) {
                return C1275j.m3020a(str, context.getPackageName(), this.f2969c.getPackageManager()) == 0;
            }
            throw new IllegalArgumentException("No context specified");
        }
        throw new IllegalArgumentException("No permission name specified");
    }

    /* renamed from: a */
    private boolean m2649a(String str, C1096c<String> cVar) {
        for (String startsWith : C1243d.m2924a((String) this.f2967a.mo10202a(cVar))) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private String m2651b(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        int length2 = iArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = str.charAt(i);
            for (int i2 = length2 - 1; i2 >= 0; i2--) {
                cArr[i] = (char) (cArr[i] ^ iArr[i2]);
            }
        }
        return new String(cArr);
    }

    /* renamed from: f */
    private Map<String, String> m2653f() {
        return mo10259a(null, false, true);
    }

    /* renamed from: g */
    private String m2654g() {
        String str = "none";
        try {
            int d = C1281o.m3108d(this.f2969c);
            return d == 1 ? String.PORTRAIT : d == 2 ? String.LANDSCAPE : str;
        } catch (Throwable th) {
            this.f2967a.mo10249v().mo10379b("DataCollector", "Encountered error while attempting to collect application orientation", th);
            return str;
        }
    }

    /* renamed from: h */
    private C1199a m2655h() {
        String str = "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }";
        String str2 = "DataCollector";
        if (m2656i()) {
            try {
                C1199a aVar = new C1199a();
                Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f2969c);
                aVar.f2976a = advertisingIdInfo.isLimitAdTrackingEnabled();
                aVar.f2977b = advertisingIdInfo.getId();
                return aVar;
            } catch (Throwable th) {
                this.f2968b.mo10379b(str2, str, th);
            }
        } else {
            C1227o.m2841i(str2, str);
            return new C1199a();
        }
    }

    /* renamed from: i */
    private boolean m2656i() {
        return C1281o.m3112e("com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }

    /* renamed from: j */
    private C1201c m2657j() {
        try {
            C1201c cVar = new C1201c();
            Intent registerReceiver = this.f2969c.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i = -1;
            int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("level", -1) : -1;
            int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1;
            if (intExtra <= 0 || intExtra2 <= 0) {
                cVar.f2986b = -1;
            } else {
                cVar.f2986b = (int) ((((float) intExtra) / ((float) intExtra2)) * 100.0f);
            }
            if (registerReceiver != null) {
                i = registerReceiver.getIntExtra("status", -1);
            }
            cVar.f2985a = i;
            return cVar;
        } catch (Throwable th) {
            this.f2968b.mo10379b("DataCollector", "Unable to collect battery info", th);
            return null;
        }
    }

    /* renamed from: k */
    private String m2658k() {
        String str = "DataCollector";
        try {
            AudioManager audioManager = (AudioManager) this.f2969c.getSystemService("audio");
            StringBuilder sb = new StringBuilder();
            String str2 = ",";
            if (C1245f.m2936g()) {
                for (AudioDeviceInfo type : audioManager.getDevices(2)) {
                    String a = m2647a(type.getType());
                    if (!TextUtils.isEmpty(a)) {
                        sb.append(a);
                        sb.append(str2);
                    }
                }
            } else {
                if (audioManager.isWiredHeadsetOn()) {
                    sb.append("headphones");
                    sb.append(str2);
                }
                if (audioManager.isBluetoothA2dpOn()) {
                    sb.append("bluetootha2dpoutput");
                }
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                this.f2968b.mo10378b(str, "No sound outputs detected");
            }
            return sb2;
        } catch (Throwable th) {
            this.f2968b.mo10379b(str, "Unable to collect sound outputs", th);
            return null;
        }
    }

    /* renamed from: l */
    private double m2659l() {
        double offset = (double) TimeZone.getDefault().getOffset(new Date().getTime());
        Double.isNaN(offset);
        double round = (double) Math.round((offset * 10.0d) / 3600000.0d);
        Double.isNaN(round);
        return round / 10.0d;
    }

    /* renamed from: m */
    private boolean m2660m() {
        try {
            PackageManager packageManager = this.f2969c.getPackageManager();
            return C1245f.m2935f() ? packageManager.hasSystemFeature("android.software.leanback") : C1245f.m2932c() ? packageManager.hasSystemFeature("android.hardware.type.television") : !packageManager.hasSystemFeature("android.hardware.touchscreen");
        } catch (Throwable th) {
            this.f2968b.mo10379b("DataCollector", "Failed to determine if device is TV.", th);
            return false;
        }
    }

    /* renamed from: n */
    private boolean m2661n() {
        try {
            return m2662o() || m2663p();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: o */
    private boolean m2662o() {
        String str = Build.TAGS;
        return str != null && str.contains(m2651b("lz}$blpz"));
    }

    /* renamed from: p */
    private boolean m2663p() {
        for (String b : new String[]{"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"}) {
            if (new File(m2651b(b)).exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: q */
    private boolean m2664q() {
        return m2649a(Build.DEVICE, C1096c.f2531ek) || m2649a(Build.HARDWARE, C1096c.f2530ej) || m2649a(Build.MANUFACTURER, C1096c.f2532el) || m2649a(Build.MODEL, C1096c.f2533em);
    }

    /* renamed from: r */
    private String m2665r() {
        final AtomicReference atomicReference = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Handler(this.f2969c.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    atomicReference.set(new WebView(C1196j.this.f2969c).getSettings().getUserAgentString());
                } catch (Throwable th) {
                    countDownLatch.countDown();
                    throw th;
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(((Long) this.f2967a.mo10202a(C1096c.f2537eq)).longValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
        }
        return (String) atomicReference.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo10258a() {
        String encodeToString = Base64.encodeToString(new JSONObject(m2653f()).toString().getBytes(Charset.defaultCharset()), 2);
        if (!((Boolean) this.f2967a.mo10202a(C1096c.f2508eN)).booleanValue()) {
            return encodeToString;
        }
        return C1276k.m3022a(encodeToString, this.f2967a.mo10246t(), C1281o.m3064a(this.f2967a));
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x03e1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0401  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x041c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0437  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0444  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0460  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.String> mo10259a(java.util.Map<java.lang.String, java.lang.String> r6, boolean r7, boolean r8) {
        /*
            r5 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.applovin.impl.sdk.j$d r1 = r5.mo10260b()
            java.lang.String r2 = r1.f2999d
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3044d(r2)
            java.lang.String r3 = "brand"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f3000e
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3044d(r2)
            java.lang.String r3 = "brand_name"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f3001f
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3044d(r2)
            java.lang.String r3 = "hardware"
            r0.put(r3, r2)
            int r2 = r1.f3003h
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "api_level"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f3005j
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3044d(r2)
            java.lang.String r3 = "carrier"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f3004i
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3044d(r2)
            java.lang.String r3 = "country_code"
            r0.put(r3, r2)
            java.util.Locale r2 = r1.f3006k
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3044d(r2)
            java.lang.String r3 = "locale"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f2996a
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3044d(r2)
            java.lang.String r3 = "model"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f2997b
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3044d(r2)
            java.lang.String r3 = "os"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f2998c
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3044d(r2)
            java.lang.String r3 = "platform"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f3002g
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3044d(r2)
            java.lang.String r3 = "revision"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f3007l
            java.lang.String r3 = "orientation_lock"
            r0.put(r3, r2)
            double r2 = r1.f3013r
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "tz_offset"
            r0.put(r3, r2)
            boolean r2 = r1.f2995I
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "aida"
            r0.put(r3, r2)
            int r2 = r1.f3014s
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "wvvc"
            r0.put(r3, r2)
            float r2 = r1.f3008m
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "adns"
            r0.put(r3, r2)
            int r2 = r1.f3009n
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "adnsd"
            r0.put(r3, r2)
            float r2 = r1.f3010o
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "xdpi"
            r0.put(r3, r2)
            float r2 = r1.f3011p
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "ydpi"
            r0.put(r3, r2)
            double r2 = r1.f3012q
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "screen_size_in"
            r0.put(r3, r2)
            boolean r2 = r1.f3019x
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3038a(r2)
            java.lang.String r3 = "sim"
            r0.put(r3, r2)
            boolean r2 = r1.f3020y
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3038a(r2)
            java.lang.String r3 = "gy"
            r0.put(r3, r2)
            boolean r2 = r1.f3021z
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3038a(r2)
            java.lang.String r3 = "is_tablet"
            r0.put(r3, r2)
            boolean r2 = r1.f2987A
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3038a(r2)
            java.lang.String r3 = "tv"
            r0.put(r3, r2)
            boolean r2 = r1.f2988B
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3038a(r2)
            java.lang.String r3 = "vs"
            r0.put(r3, r2)
            int r2 = r1.f2989C
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "lpm"
            r0.put(r3, r2)
            long r2 = r1.f2991E
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "fs"
            r0.put(r3, r2)
            com.applovin.impl.sdk.j$e r2 = r1.f2992F
            long r2 = r2.f3023b
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "fm"
            r0.put(r3, r2)
            com.applovin.impl.sdk.j$e r2 = r1.f2992F
            long r2 = r2.f3022a
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "tm"
            r0.put(r3, r2)
            com.applovin.impl.sdk.j$e r2 = r1.f2992F
            long r2 = r2.f3024c
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "lmt"
            r0.put(r3, r2)
            com.applovin.impl.sdk.j$e r2 = r1.f2992F
            boolean r2 = r2.f3025d
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "lm"
            r0.put(r3, r2)
            boolean r2 = r1.f3015t
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3038a(r2)
            java.lang.String r3 = "adr"
            r0.put(r3, r2)
            int r2 = r1.f3017v
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "volume"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f3018w
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3044d(r2)
            java.lang.String r3 = "ua"
            com.applovin.impl.sdk.utils.C1281o.m3085a(r3, r2, r0)
            java.lang.String r2 = r1.f2990D
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3044d(r2)
            java.lang.String r3 = "so"
            com.applovin.impl.sdk.utils.C1281o.m3085a(r3, r2, r0)
            com.applovin.impl.sdk.j$c r2 = r1.f3016u
            if (r2 == 0) goto L_0x01ac
            int r3 = r2.f2985a
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "act"
            r0.put(r4, r3)
            int r2 = r2.f2986b
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "acm"
            r0.put(r3, r2)
        L_0x01ac:
            java.lang.Boolean r2 = r1.f2993G
            if (r2 == 0) goto L_0x01b9
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "huc"
            r0.put(r3, r2)
        L_0x01b9:
            java.lang.Boolean r1 = r1.f2994H
            if (r1 == 0) goto L_0x01c6
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "aru"
            r0.put(r2, r1)
        L_0x01c6:
            android.content.Context r1 = r5.f2969c
            android.graphics.Point r1 = com.applovin.impl.sdk.utils.C1245f.m2928a(r1)
            int r2 = r1.x
            java.lang.String r2 = java.lang.Integer.toString(r2)
            java.lang.String r3 = "dx"
            r0.put(r3, r2)
            int r1 = r1.y
            java.lang.String r1 = java.lang.Integer.toString(r1)
            java.lang.String r2 = "dy"
            r0.put(r2, r1)
            java.lang.String r1 = "accept"
            java.lang.String r2 = "custom_size,launch_app,video"
            r0.put(r1, r2)
            com.applovin.impl.sdk.i r1 = r5.f2967a
            com.applovin.impl.sdk.b.c<java.lang.String> r2 = com.applovin.impl.sdk.p019b.C1096c.f2277S
            java.lang.Object r1 = r1.mo10202a(r2)
            java.lang.String r2 = "api_did"
            r0.put(r2, r1)
            java.lang.String r1 = com.applovin.sdk.AppLovinSdk.VERSION
            java.lang.String r2 = "sdk_version"
            r0.put(r2, r1)
            r1 = 131(0x83, float:1.84E-43)
            java.lang.String r1 = java.lang.Integer.toString(r1)
            java.lang.String r2 = "build"
            r0.put(r2, r1)
            java.lang.String r1 = "format"
            java.lang.String r2 = "json"
            r0.put(r1, r2)
            com.applovin.impl.sdk.j$b r1 = r5.mo10261c()
            java.lang.String r2 = r1.f2979b
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1277l.m3044d(r2)
            java.lang.String r3 = "app_version"
            r0.put(r3, r2)
            long r2 = r1.f2984g
            java.lang.String r2 = java.lang.Long.toString(r2)
            java.lang.String r3 = "ia"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f2982e
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "tg"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f2981d
            java.lang.String r3 = "installer_name"
            r0.put(r3, r2)
            java.lang.String r1 = r1.f2983f
            java.lang.String r2 = "debug"
            r0.put(r2, r1)
            com.applovin.impl.sdk.i r1 = r5.f2967a
            java.lang.String r1 = r1.mo10240n()
            java.lang.String r1 = com.applovin.impl.sdk.utils.C1277l.m3044d(r1)
            java.lang.String r2 = "mediation_provider"
            com.applovin.impl.sdk.utils.C1281o.m3085a(r2, r1, r0)
            com.applovin.impl.sdk.i r1 = r5.f2967a
            java.lang.String r1 = com.applovin.impl.sdk.utils.C1246g.m2955f(r1)
            java.lang.String r2 = "network"
            r0.put(r2, r1)
            com.applovin.impl.sdk.i r1 = r5.f2967a
            com.applovin.impl.sdk.b.c<java.lang.String> r2 = com.applovin.impl.sdk.p019b.C1096c.f2522eb
            java.lang.Object r1 = r1.mo10202a(r2)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "plugin_version"
            com.applovin.impl.sdk.utils.C1281o.m3085a(r2, r1, r0)
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r1 = "preloading"
            r0.put(r1, r7)
            com.applovin.impl.sdk.i r7 = r5.f2967a
            com.applovin.sdk.AppLovinSdkSettings r7 = r7.mo10238l()
            boolean r7 = r7.isTestAdsEnabled()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r1 = "test_ads"
            com.applovin.impl.sdk.utils.C1281o.m3084a(r1, r7, r0)
            com.applovin.impl.sdk.i r7 = r5.f2967a
            boolean r7 = r7.mo10182H()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r1 = "first_install"
            r0.put(r1, r7)
            com.applovin.impl.sdk.i r7 = r5.f2967a
            boolean r7 = r7.mo10183I()
            r1 = 1
            r7 = r7 ^ r1
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r2 = "first_install_v2"
            r0.put(r2, r7)
            com.applovin.impl.sdk.i r7 = r5.f2967a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r2 = com.applovin.impl.sdk.p019b.C1096c.f2507eM
            java.lang.Object r7 = r7.mo10202a(r2)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x02c2
            com.applovin.impl.sdk.i r7 = r5.f2967a
            java.lang.String r7 = r7.mo10246t()
            java.lang.String r2 = "sdk_key"
            r0.put(r2, r7)
        L_0x02c2:
            com.applovin.impl.sdk.i r7 = r5.f2967a
            com.applovin.impl.sdk.b.c<java.lang.String> r2 = com.applovin.impl.sdk.p019b.C1096c.f2280V
            java.lang.Object r7 = r7.mo10202a(r2)
            java.lang.String r2 = "sc"
            r0.put(r2, r7)
            com.applovin.impl.sdk.i r7 = r5.f2967a
            com.applovin.impl.sdk.b.c<java.lang.String> r2 = com.applovin.impl.sdk.p019b.C1096c.f2281W
            java.lang.Object r7 = r7.mo10202a(r2)
            java.lang.String r2 = "sc2"
            r0.put(r2, r7)
            com.applovin.impl.sdk.i r7 = r5.f2967a
            com.applovin.impl.sdk.b.c<java.lang.String> r2 = com.applovin.impl.sdk.p019b.C1096c.f2282X
            java.lang.Object r7 = r7.mo10202a(r2)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = com.applovin.impl.sdk.utils.C1277l.m3044d(r7)
            java.lang.String r2 = "server_installed_at"
            r0.put(r2, r7)
            com.applovin.impl.sdk.i r7 = r5.f2967a
            com.applovin.impl.sdk.b.e<java.lang.String> r2 = com.applovin.impl.sdk.p019b.C1098e.f2578x
            java.lang.Object r7 = r7.mo10203a(r2)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = com.applovin.impl.sdk.utils.C1277l.m3044d(r7)
            java.lang.String r2 = "persisted_data"
            com.applovin.impl.sdk.utils.C1281o.m3085a(r2, r7, r0)
            android.content.Context r7 = r5.f2969c
            java.lang.String r2 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r7 = com.applovin.impl.sdk.utils.C1245f.m2930a(r2, r7)
            java.lang.String r7 = java.lang.Boolean.toString(r7)
            java.lang.String r2 = "v1"
            r0.put(r2, r7)
            java.lang.String r7 = "true"
            java.lang.String r2 = "v2"
            r0.put(r2, r7)
            java.lang.String r2 = "v3"
            r0.put(r2, r7)
            java.lang.String r2 = "v4"
            r0.put(r2, r7)
            java.lang.String r2 = "v5"
            r0.put(r2, r7)
            com.applovin.impl.sdk.i r7 = r5.f2967a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r2 = com.applovin.impl.sdk.p019b.C1096c.f2539es
            java.lang.Object r7 = r7.mo10202a(r2)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x038a
            com.applovin.impl.sdk.i r7 = r5.f2967a
            com.applovin.impl.sdk.c.h r7 = r7.mo10186L()
            com.applovin.impl.sdk.c.g r2 = com.applovin.impl.sdk.p020c.C1113g.f2657b
            long r2 = r7.mo10039b(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "li"
            r0.put(r3, r2)
            com.applovin.impl.sdk.c.g r2 = com.applovin.impl.sdk.p020c.C1113g.f2659d
            long r2 = r7.mo10039b(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "si"
            r0.put(r3, r2)
            com.applovin.impl.sdk.c.g r2 = com.applovin.impl.sdk.p020c.C1113g.f2663h
            long r2 = r7.mo10039b(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "pf"
            r0.put(r3, r2)
            com.applovin.impl.sdk.c.g r2 = com.applovin.impl.sdk.p020c.C1113g.f2669n
            long r2 = r7.mo10039b(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "mpf"
            r0.put(r3, r2)
            com.applovin.impl.sdk.c.g r2 = com.applovin.impl.sdk.p020c.C1113g.f2664i
            long r2 = r7.mo10039b(r2)
            java.lang.String r7 = java.lang.String.valueOf(r2)
            java.lang.String r2 = "gpf"
            r0.put(r2, r7)
        L_0x038a:
            android.content.Context r7 = r5.f2969c
            java.lang.String r7 = r7.getPackageName()
            com.applovin.impl.sdk.i r2 = r5.f2967a
            java.lang.String r7 = com.applovin.impl.sdk.utils.C1277l.m3034a(r7, r2)
            java.lang.String r2 = "vz"
            r0.put(r2, r7)
            com.applovin.impl.sdk.i r7 = r5.f2967a
            boolean r7 = r7.mo10234h()
            java.lang.String r7 = java.lang.Boolean.toString(r7)
            java.lang.String r2 = "pnr"
            r0.put(r2, r7)
            if (r8 == 0) goto L_0x03cf
            java.util.concurrent.atomic.AtomicReference<com.applovin.impl.sdk.j$a> r7 = r5.f2971h
            java.lang.Object r7 = r7.get()
            com.applovin.impl.sdk.j$a r7 = (com.applovin.impl.sdk.C1196j.C1199a) r7
            if (r7 == 0) goto L_0x03ba
            r5.mo10263e()
            goto L_0x03d9
        L_0x03ba:
            boolean r7 = com.applovin.impl.sdk.utils.C1281o.m3101b()
            if (r7 == 0) goto L_0x03cf
            com.applovin.impl.sdk.j$a r7 = new com.applovin.impl.sdk.j$a
            r7.<init>()
            java.lang.String r8 = java.lang.Boolean.toString(r1)
            java.lang.String r1 = "inc"
            r0.put(r1, r8)
            goto L_0x03d9
        L_0x03cf:
            com.applovin.impl.sdk.i r7 = r5.f2967a
            com.applovin.impl.sdk.j r7 = r7.mo10189O()
            com.applovin.impl.sdk.j$a r7 = r7.mo10262d()
        L_0x03d9:
            java.lang.String r8 = r7.f2977b
            boolean r1 = com.applovin.impl.sdk.utils.C1277l.m3042b(r8)
            if (r1 == 0) goto L_0x03e6
            java.lang.String r1 = "idfa"
            r0.put(r1, r8)
        L_0x03e6:
            boolean r7 = r7.f2976a
            java.lang.String r7 = java.lang.Boolean.toString(r7)
            java.lang.String r8 = "dnt"
            r0.put(r8, r7)
            com.applovin.impl.sdk.i r7 = r5.f2967a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r8 = com.applovin.impl.sdk.p019b.C1096c.f2462dT
            java.lang.Object r7 = r7.mo10202a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x040c
            com.applovin.impl.sdk.i r7 = r5.f2967a
            java.lang.String r7 = r7.mo10235i()
            java.lang.String r8 = "cuid"
            com.applovin.impl.sdk.utils.C1281o.m3085a(r8, r7, r0)
        L_0x040c:
            com.applovin.impl.sdk.i r7 = r5.f2967a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r8 = com.applovin.impl.sdk.p019b.C1096c.f2465dW
            java.lang.Object r7 = r7.mo10202a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0427
            com.applovin.impl.sdk.i r7 = r5.f2967a
            java.lang.String r7 = r7.mo10236j()
            java.lang.String r8 = "compass_random_token"
            r0.put(r8, r7)
        L_0x0427:
            com.applovin.impl.sdk.i r7 = r5.f2967a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r8 = com.applovin.impl.sdk.p019b.C1096c.f2467dY
            java.lang.Object r7 = r7.mo10202a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0442
            com.applovin.impl.sdk.i r7 = r5.f2967a
            java.lang.String r7 = r7.mo10237k()
            java.lang.String r8 = "applovin_random_token"
            r0.put(r8, r7)
        L_0x0442:
            if (r6 == 0) goto L_0x0447
            r0.putAll(r6)
        L_0x0447:
            java.util.UUID r6 = java.util.UUID.randomUUID()
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "rid"
            r0.put(r7, r6)
            com.applovin.impl.sdk.i r6 = r5.f2967a
            com.applovin.impl.sdk.network.a r6 = r6.mo10184J()
            com.applovin.impl.sdk.network.a$b r6 = r6.mo10293a()
            if (r6 == 0) goto L_0x0490
            long r7 = r6.mo10297a()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "lrm_ts_ms"
            r0.put(r8, r7)
            java.lang.String r7 = r6.mo10298b()
            java.lang.String r8 = "lrm_url"
            r0.put(r8, r7)
            long r7 = r6.mo10300d()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "lrm_ct_ms"
            r0.put(r8, r7)
            long r6 = r6.mo10299c()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r7 = "lrm_rs"
            r0.put(r7, r6)
        L_0x0490:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1196j.mo10259a(java.util.Map, boolean, boolean):java.util.Map");
    }

    /* renamed from: b */
    public C1202d mo10260b() {
        C1202d dVar;
        Object obj = this.f2970d.get(C1202d.class);
        if (obj != null) {
            dVar = (C1202d) obj;
        } else {
            dVar = new C1202d();
            dVar.f3006k = Locale.getDefault();
            dVar.f2996a = Build.MODEL;
            dVar.f2997b = VERSION.RELEASE;
            dVar.f2998c = "android";
            dVar.f2999d = Build.MANUFACTURER;
            dVar.f3000e = Build.BRAND;
            dVar.f3001f = Build.HARDWARE;
            dVar.f3003h = VERSION.SDK_INT;
            dVar.f3002g = Build.DEVICE;
            dVar.f3013r = m2659l();
            dVar.f3019x = m2664q();
            dVar.f2995I = m2656i();
            try {
                dVar.f3020y = ((SensorManager) this.f2969c.getSystemService("sensor")).getDefaultSensor(4) != null;
            } catch (Throwable th) {
                this.f2968b.mo10379b("DataCollector", "Unable to retrieve gyroscope availability", th);
            }
            if (m2648a("android.permission.READ_PHONE_STATE")) {
                TelephonyManager telephonyManager = (TelephonyManager) this.f2969c.getSystemService("phone");
                if (telephonyManager != null) {
                    dVar.f3004i = telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH);
                    String networkOperatorName = telephonyManager.getNetworkOperatorName();
                    try {
                        dVar.f3005j = URLEncoder.encode(networkOperatorName, "UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                        dVar.f3005j = networkOperatorName;
                    }
                }
            }
            try {
                DisplayMetrics displayMetrics = this.f2969c.getResources().getDisplayMetrics();
                dVar.f3008m = displayMetrics.density;
                dVar.f3009n = displayMetrics.densityDpi;
                dVar.f3010o = displayMetrics.xdpi;
                dVar.f3011p = displayMetrics.ydpi;
                Point a = C1245f.m2928a(this.f2969c);
                double sqrt = Math.sqrt(Math.pow((double) a.x, 2.0d) + Math.pow((double) a.y, 2.0d));
                double d = (double) dVar.f3010o;
                Double.isNaN(d);
                dVar.f3012q = sqrt / d;
            } catch (Throwable unused2) {
            }
            this.f2970d.put(C1202d.class, dVar);
        }
        return m2646a(dVar);
    }

    /* renamed from: c */
    public C1200b mo10261c() {
        PackageInfo packageInfo;
        Object obj = this.f2970d.get(C1200b.class);
        if (obj != null) {
            return (C1200b) obj;
        }
        ApplicationInfo applicationInfo = this.f2969c.getApplicationInfo();
        long lastModified = new File(applicationInfo.sourceDir).lastModified();
        PackageManager packageManager = this.f2969c.getPackageManager();
        String str = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.f2969c.getPackageName(), 0);
            try {
                str = packageManager.getInstallerPackageName(applicationInfo.packageName);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            packageInfo = null;
        }
        C1200b bVar = new C1200b();
        bVar.f2980c = applicationInfo.packageName;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        bVar.f2981d = str;
        bVar.f2984g = lastModified;
        bVar.f2978a = String.valueOf(packageManager.getApplicationLabel(applicationInfo));
        if (packageInfo != null) {
            str2 = packageInfo.versionName;
        }
        bVar.f2979b = str2;
        bVar.f2982e = (String) this.f2967a.mo10203a(C1098e.f2561g);
        bVar.f2983f = Boolean.toString(C1281o.m3107c(this.f2967a));
        this.f2970d.put(C1200b.class, bVar);
        return bVar;
    }

    /* renamed from: d */
    public C1199a mo10262d() {
        C1199a h = m2655h();
        if (!((Boolean) this.f2967a.mo10202a(C1096c.f2461dS)).booleanValue()) {
            return new C1199a();
        }
        if (!h.f2976a || ((Boolean) this.f2967a.mo10202a(C1096c.f2460dR)).booleanValue()) {
            return h;
        }
        h.f2977b = "";
        return h;
    }

    /* renamed from: e */
    public void mo10263e() {
        this.f2967a.mo10185K().mo10131a((C1122a) new C1142i(this.f2967a, new C1143a() {
            /* renamed from: a */
            public void mo9706a(C1199a aVar) {
                C1196j.this.f2971h.set(aVar);
            }
        }), C1281o.m3096b(this.f2967a));
    }
}
