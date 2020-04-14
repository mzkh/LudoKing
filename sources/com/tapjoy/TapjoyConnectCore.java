package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.appsflyer.share.Constants;
import com.facebook.appevents.AppEventsConstants;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import com.tapjoy.internal.C1812bn;
import com.tapjoy.internal.C1831gz;
import com.tapjoy.internal.C1835hc;
import com.tapjoy.internal.C1852jq;
import com.tapjoy.internal.C1854jz;
import com.tapjoy.internal.C2874al;
import com.tapjoy.internal.C2895bh;
import com.tapjoy.internal.C3023eu;
import com.tapjoy.internal.C3041fa;
import com.tapjoy.internal.C3044fb;
import com.tapjoy.internal.C3062fh;
import com.tapjoy.internal.C3075fo;
import com.tapjoy.internal.C3075fo.C1820a;
import com.tapjoy.internal.C3081fs;
import com.tapjoy.internal.C3091ga;
import com.tapjoy.internal.C3104ge;
import com.tapjoy.internal.C3147hn;
import com.tapjoy.internal.C3256v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.w3c.dom.Document;

public class TapjoyConnectCore {

    /* renamed from: A */
    private static float f6476A = 1.0f;

    /* renamed from: B */
    private static int f6477B = 1;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public static String f6478C = null;

    /* renamed from: D */
    private static String f6479D = null;
    public static final float DEFAULT_CURRENCY_MULTIPLIER = 1.0f;

    /* renamed from: E */
    private static String f6480E;

    /* renamed from: F */
    private static String f6481F;

    /* renamed from: G */
    private static String f6482G;

    /* renamed from: H */
    private static String f6483H;

    /* renamed from: I */
    private static String f6484I;

    /* renamed from: J */
    private static String f6485J;

    /* renamed from: K */
    private static String f6486K;

    /* renamed from: L */
    private static String f6487L;

    /* renamed from: M */
    private static String f6488M;

    /* renamed from: N */
    private static String f6489N;

    /* renamed from: O */
    private static String f6490O = "native";

    /* renamed from: P */
    private static String f6491P;

    /* renamed from: Q */
    private static String f6492Q;

    /* renamed from: R */
    private static float f6493R = 1.0f;

    /* renamed from: S */
    private static boolean f6494S = false;

    /* renamed from: T */
    private static String f6495T;

    /* renamed from: U */
    private static String f6496U;

    /* renamed from: V */
    private static String f6497V;

    /* renamed from: W */
    private static String f6498W;

    /* renamed from: X */
    private static String f6499X = null;

    /* renamed from: a */
    protected static int f6500a = 0;

    /* renamed from: aA */
    private static Integer f6501aA;

    /* renamed from: aB */
    private static Long f6502aB;

    /* renamed from: aC */
    private static Long f6503aC;

    /* renamed from: aD */
    private static Long f6504aD;

    /* renamed from: aE */
    private static String f6505aE;

    /* renamed from: aF */
    private static Integer f6506aF;

    /* renamed from: aG */
    private static Double f6507aG;

    /* renamed from: aH */
    private static Double f6508aH;

    /* renamed from: aI */
    private static Long f6509aI;

    /* renamed from: aJ */
    private static Integer f6510aJ;

    /* renamed from: aK */
    private static Integer f6511aK;

    /* renamed from: aL */
    private static Integer f6512aL;

    /* renamed from: aM */
    private static String f6513aM;

    /* renamed from: aN */
    private static String f6514aN;

    /* renamed from: aO */
    private static String f6515aO;

    /* renamed from: aP */
    private static String f6516aP;

    /* renamed from: aQ */
    private static String f6517aQ;

    /* renamed from: aR */
    private static String f6518aR;

    /* renamed from: aS */
    private static boolean f6519aS = false;

    /* renamed from: aT */
    private static TJConnectListener f6520aT = null;

    /* renamed from: aU */
    private static boolean f6521aU = false;

    /* renamed from: aa */
    private static long f6522aa = 0;

    /* renamed from: ac */
    private static boolean f6523ac;

    /* renamed from: ad */
    private static PackageManager f6524ad;

    /* renamed from: ae */
    private static TapjoyGpsHelper f6525ae;

    /* renamed from: af */
    private static Hashtable f6526af = TapjoyConnectFlag.CONNECT_FLAG_DEFAULTS;

    /* renamed from: ag */
    private static Map f6527ag = new ConcurrentHashMap();

    /* renamed from: ah */
    private static String f6528ah;

    /* renamed from: ai */
    private static String f6529ai;

    /* renamed from: aj */
    private static String f6530aj;

    /* renamed from: ak */
    private static String f6531ak;

    /* renamed from: al */
    private static Integer f6532al;

    /* renamed from: am */
    private static String f6533am;

    /* renamed from: an */
    private static String f6534an;

    /* renamed from: ao */
    private static Long f6535ao;

    /* renamed from: ap */
    private static String f6536ap;

    /* renamed from: aq */
    private static Integer f6537aq;

    /* renamed from: ar */
    private static Integer f6538ar;

    /* renamed from: as */
    private static String f6539as;

    /* renamed from: at */
    private static String f6540at;

    /* renamed from: au */
    private static String f6541au;

    /* renamed from: av */
    private static String f6542av;

    /* renamed from: aw */
    private static String f6543aw;

    /* renamed from: ax */
    private static Set f6544ax;

    /* renamed from: ay */
    private static Integer f6545ay;

    /* renamed from: az */
    private static Integer f6546az;

    /* renamed from: b */
    protected static int f6547b = 0;

    /* renamed from: c */
    protected static String f6548c;

    /* renamed from: d */
    protected static boolean f6549d;

    /* renamed from: e */
    protected static String f6550e;

    /* renamed from: f */
    protected static String f6551f;

    /* renamed from: g */
    private static Context f6552g;

    /* renamed from: h */
    private static String f6553h;

    /* renamed from: i */
    private static TapjoyConnectCore f6554i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static TapjoyURLConnection f6555j;

    /* renamed from: k */
    private static TJConnectListener f6556k;

    /* renamed from: l */
    private static TJSetUserIDListener f6557l;

    /* renamed from: m */
    private static Vector f6558m = new Vector(Arrays.asList(TapjoyConstants.dependencyClassNames));

    /* renamed from: n */
    private static String f6559n;

    /* renamed from: o */
    private static String f6560o;

    /* renamed from: p */
    private static String f6561p;

    /* renamed from: q */
    private static String f6562q;

    /* renamed from: r */
    private static String f6563r;

    /* renamed from: s */
    private static String f6564s;

    /* renamed from: t */
    private static String f6565t;

    /* renamed from: u */
    private static String f6566u;

    /* renamed from: v */
    private static String f6567v;

    /* renamed from: w */
    private static String f6568w;

    /* renamed from: x */
    private static String f6569x;

    /* renamed from: y */
    private static String f6570y;

    /* renamed from: z */
    private static int f6571z = 1;

    /* renamed from: Y */
    private long f6572Y = 0;

    /* renamed from: Z */
    private boolean f6573Z = false;

    /* renamed from: ab */
    private boolean f6574ab = false;

    public class PPAThread implements Runnable {

        /* renamed from: b */
        private Map f6578b;

        public PPAThread(Map map) {
            this.f6578b = map;
        }

        public void run() {
            TapjoyURLConnection c = TapjoyConnectCore.f6555j;
            StringBuilder sb = new StringBuilder();
            sb.append(TapjoyConnectCore.getHostURL());
            sb.append(TapjoyConstants.TJC_CONNECT_URL_PATH);
            TapjoyHttpURLResponse responseFromURL = c.getResponseFromURL(sb.toString(), (Map) null, (Map) null, this.f6578b);
            if (responseFromURL.response != null) {
                TapjoyConnectCore.m6531d(responseFromURL.response);
            }
        }
    }

    public static String getConnectURL() {
        return TapjoyConfig.TJC_CONNECT_SERVICE_URL;
    }

    static {
        String str = "";
        f6559n = str;
        f6560o = str;
        f6561p = str;
        f6562q = str;
        f6563r = str;
        f6564s = str;
        f6565t = str;
        f6566u = str;
        f6567v = str;
        f6568w = str;
        f6569x = str;
        f6570y = str;
        f6478C = str;
        f6479D = str;
        f6480E = str;
        f6481F = str;
        f6482G = str;
        f6483H = str;
        f6484I = str;
        f6485J = str;
        f6486K = str;
        f6487L = str;
        f6488M = str;
        f6489N = str;
        f6491P = str;
        f6492Q = str;
        f6495T = str;
        f6496U = str;
        f6497V = str;
        f6498W = str;
        f6548c = str;
        f6550e = str;
        f6551f = str;
        f6516aP = str;
        f6517aQ = str;
        f6518aR = str;
    }

    public static TapjoyConnectCore getInstance() {
        return f6554i;
    }

    public static void requestTapjoyConnect(Context context, String str) {
        requestTapjoyConnect(context, str, null);
    }

    public static void requestTapjoyConnect(Context context, String str, Hashtable hashtable) {
        requestTapjoyConnect(context, str, hashtable, null);
    }

    public static void requestTapjoyConnect(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener) {
        String str2 = "TapjoyConnect";
        try {
            C3075fo foVar = new C3075fo(str);
            if (foVar.f7249a == C1820a.SDK_ANDROID) {
                f6553h = str;
                f6567v = foVar.f7250b;
                f6488M = foVar.f7251c;
                f6489N = foVar.f7252d;
                if (hashtable != null) {
                    f6526af.putAll(hashtable);
                    C3091ga.m7138b().mo18090a(hashtable);
                }
                C1831gz.m3555a(context).f3826j = str;
                f6556k = tJConnectListener;
                if (f6554i == null) {
                    f6554i = new TapjoyConnectCore();
                }
                TapjoyConnectCore tapjoyConnectCore = f6554i;
                try {
                    m6522a(context);
                    new Thread(new Runnable() {
                        public final void run() {
                            TapjoyConnectCore.m6518a();
                            TapjoyConnectCore.this.completeConnectCall();
                        }
                    }).start();
                    tapjoyConnectCore.f6574ab = true;
                } catch (TapjoyIntegrationException e) {
                    TapjoyLog.m6551e(str2, new TapjoyErrorMessage(ErrorType.INTEGRATION_ERROR, e.getMessage()));
                    m6530d();
                    C3081fs.f7265b.notifyObservers(Boolean.FALSE);
                } catch (TapjoyException e2) {
                    TapjoyLog.m6551e(str2, new TapjoyErrorMessage(ErrorType.SDK_ERROR, e2.getMessage()));
                    m6530d();
                    C3081fs.f7265b.notifyObservers(Boolean.FALSE);
                }
            } else {
                throw new IllegalArgumentException("The given API key was not for Android.");
            }
        } catch (IllegalArgumentException e3) {
            throw new TapjoyIntegrationException(e3.getMessage());
        }
    }

    public static void requestLimitedTapjoyConnect(Context context, String str, TJConnectListener tJConnectListener) {
        String str2 = "TapjoyConnect";
        try {
            C3075fo foVar = new C3075fo(str);
            if (foVar.f7249a == C1820a.SDK_ANDROID) {
                f6516aP = foVar.f7250b;
                f6517aQ = foVar.f7251c;
                if (f6554i == null) {
                    f6554i = new TapjoyConnectCore();
                }
                f6520aT = tJConnectListener;
                TapjoyConnectCore tapjoyConnectCore = f6554i;
                try {
                    m6522a(context);
                    new Thread(new Runnable() {
                        public final void run() {
                            TapjoyConnectCore.m6518a();
                            TapjoyConnectCore.this.completeLimitedConnectCall();
                        }
                    }).start();
                } catch (TapjoyIntegrationException e) {
                    TapjoyLog.m6551e(str2, new TapjoyErrorMessage(ErrorType.INTEGRATION_ERROR, e.getMessage()));
                    m6532e();
                    C3081fs.f7265b.notifyObservers(Boolean.FALSE);
                } catch (TapjoyException e2) {
                    TapjoyLog.m6551e(str2, new TapjoyErrorMessage(ErrorType.SDK_ERROR, e2.getMessage()));
                    m6532e();
                    C3081fs.f7265b.notifyObservers(Boolean.FALSE);
                }
                TapjoyLog.m6550d(str2, "requestTapjoyConnect function complete");
                return;
            }
            throw new IllegalArgumentException("The given API key was not for Android.");
        } catch (IllegalArgumentException e3) {
            TapjoyLog.m6550d(str2, e3.getMessage());
            throw new TapjoyIntegrationException(e3.getMessage());
        }
    }

    /* renamed from: d */
    private static void m6530d() {
        if (!C1852jq.m3669c(f6489N)) {
            C1831gz.m3554a().mo18119a(f6552g, f6553h, "12.4.1", TapjoyConfig.TJC_ANALYTICS_SERVICE_URL, f6489N, f6488M);
        }
        TJConnectListener tJConnectListener = f6556k;
        if (tJConnectListener != null) {
            tJConnectListener.onConnectFailure();
        }
    }

    /* renamed from: e */
    private static void m6532e() {
        TJConnectListener tJConnectListener = f6520aT;
        if (tJConnectListener != null) {
            tJConnectListener.onConnectFailure();
        }
    }

    public void appPause() {
        this.f6573Z = true;
    }

    public void appResume() {
        if (this.f6573Z) {
            m6544p();
            this.f6573Z = false;
        }
    }

    public static Map getURLParams() {
        Map genericURLParams = getGenericURLParams();
        genericURLParams.putAll(getTimeStampAndVerifierParams());
        return genericURLParams;
    }

    public static Map getLimitedURLParams() {
        Map limitedGenericURLParams = getLimitedGenericURLParams();
        limitedGenericURLParams.putAll(getLimitedTimeStampAndVerifierParams());
        return limitedGenericURLParams;
    }

    public static Map getGenericURLParams() {
        Map f = m6534f();
        TapjoyUtil.safePut(f, "app_id", f6567v, true);
        return f;
    }

    public static Map getLimitedGenericURLParams() {
        Map f = m6534f();
        TapjoyUtil.safePut(f, "app_id", f6516aP, true);
        TapjoyUtil.safePut(f, TapjoyConstants.TJC_APP_GROUP_ID, f6518aR, true);
        TapjoyUtil.safePut(f, TapjoyConstants.TJC_LIMITED, "true", true);
        return f;
    }

    /* renamed from: f */
    private static Map m6534f() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_PLUGIN, f6490O, true);
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_SDK_TYPE, f6491P, true);
        TapjoyUtil.safePut(hashMap3, "app_id", f6567v, true);
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_LIBRARY_VERSION, f6569x, true);
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_LIBRARY_REVISION, TapjoyRevision.GIT_REVISION, true);
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_BRIDGE_VERSION, f6570y, true);
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_APP_VERSION_NAME, f6568w, true);
        hashMap2.putAll(hashMap3);
        HashMap hashMap4 = new HashMap();
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_NAME, f6563r, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_PLATFORM, f6480E, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, f6566u, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_MANUFACTURER, f6564s, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_TYPE_NAME, f6565t, true);
        StringBuilder sb = new StringBuilder();
        sb.append(f6477B);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_SCREEN_LAYOUT_SIZE, sb.toString(), true);
        String str = f6487L;
        String str2 = TapjoyConstants.TJC_STORE_NAME;
        TapjoyUtil.safePut(hashMap4, str2, str, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_STORE_VIEW, String.valueOf(f6494S), true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_CARRIER_NAME, f6481F, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_CARRIER_COUNTRY_CODE, f6482G, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_MOBILE_NETWORK_CODE, f6484I, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_MOBILE_COUNTRY_CODE, f6483H, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, Locale.getDefault().getCountry(), true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_LANGUAGE, Locale.getDefault().getLanguage(), true);
        f6485J = getConnectionType();
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_CONNECTION_TYPE, f6485J, true);
        f6486K = getConnectionSubType();
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_CONNECTION_SUBTYPE, f6486K, true);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f6571z);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_SCREEN_DENSITY, sb2.toString(), true);
        hashMap2.putAll(hashMap4);
        HashMap hashMap5 = new HashMap();
        if (m6541m()) {
            TapjoyUtil.safePut(hashMap5, "advertising_id", f6548c, true);
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_AD_TRACKING_ENABLED, String.valueOf(f6549d), true);
        }
        if ((m6542n() && !m6541m()) || !m6543o()) {
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_ANDROID_ID, f6559n, true);
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_DEVICE_MAC_ADDRESS, f6561p, true);
        }
        TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_INSTALL_ID, f6562q, true);
        TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_USER_ID, f6478C, true);
        TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_ADVERTISING_ID_CHECK_DISABLED, f6550e, true);
        TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_LEGACY_ID_FALLBACK_ALLOWED, f6551f, true);
        int i = f6500a;
        if (i != 0) {
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_PACKAGED_GOOGLE_PLAY_SERVICES_VERSION, Integer.toString(i), true);
        }
        int i2 = f6547b;
        if (i2 != 0) {
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_DEVICE_GOOGLE_PLAY_SERVICES_VERSION, Integer.toString(i2), true);
        }
        String str3 = f6560o;
        if (str3 == null || str3.length() == 0 || System.currentTimeMillis() - f6522aa > TapjoyConstants.SESSION_ID_INACTIVITY_TIME) {
            f6560o = m6544p();
        } else {
            f6522aa = System.currentTimeMillis();
        }
        TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_SESSION_ID, f6560o, true);
        hashMap2.putAll(hashMap5);
        HashMap hashMap6 = new HashMap();
        TapjoyUtil.safePut(hashMap6, TapjoyConstants.TJC_APP_GROUP_ID, f6495T, true);
        TapjoyUtil.safePut(hashMap6, "store", f6496U, true);
        TapjoyUtil.safePut(hashMap6, TapjoyConstants.TJC_ANALYTICS_API_KEY, f6497V, true);
        TapjoyUtil.safePut(hashMap6, TapjoyConstants.TJC_MANAGED_DEVICE_ID, f6498W, true);
        hashMap2.putAll(hashMap6);
        C3104ge a = C3104ge.m7159a();
        HashMap hashMap7 = new HashMap();
        if (a.f7325a != null) {
            TapjoyUtil.safePut(hashMap7, "gdpr", a.f7325a.booleanValue() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO, true);
        }
        if (!C2874al.m6573a(a.f7326b)) {
            TapjoyUtil.safePut(hashMap7, "cgdpr", a.f7326b, true);
        }
        hashMap2.putAll(hashMap7);
        if (!(TapjoyCache.getInstance() == null || TapjoyCache.getInstance().getCachedOfferIDs() == null || TapjoyCache.getInstance().getCachedOfferIDs().length() <= 0)) {
            TapjoyUtil.safePut(hashMap2, TapjoyConstants.TJC_CACHED_OFFERS, TapjoyCache.getInstance().getCachedOfferIDs(), true);
        }
        TapjoyUtil.safePut(hashMap2, TapjoyConstants.TJC_CURRENCY_MULTIPLIER, Float.toString(f6493R), true);
        hashMap.putAll(hashMap2);
        HashMap hashMap8 = new HashMap();
        m6536h();
        HashMap hashMap9 = new HashMap();
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_ANALYTICS_ID, f6528ah, true);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_PACKAGE_ID, f6529ai, true);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_PACKAGE_SIGN, f6530aj, true);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_DEVICE_DISPLAY_DENSITY, f6510aJ);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_DEVICE_DISPLAY_WIDTH, f6511aK);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_DEVICE_DISPLAY_HEIGHT, f6512aL);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_DEVICE_COUNTRY_SIM, f6513aM, true);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_DEVICE_TIMEZONE, f6514aN, true);
        hashMap8.putAll(hashMap9);
        HashMap hashMap10 = new HashMap();
        TapjoyUtil.safePut(hashMap10, TapjoyConstants.TJC_PACKAGE_VERSION, f6531ak, true);
        TapjoyUtil.safePut(hashMap10, TapjoyConstants.TJC_PACKAGE_REVISION, f6532al);
        TapjoyUtil.safePut(hashMap10, TapjoyConstants.TJC_PACKAGE_DATA_VERSION, f6533am, true);
        TapjoyUtil.safePut(hashMap10, TapjoyConstants.TJC_INSTALLER, f6534an, true);
        if (C1852jq.m3669c(f6487L)) {
            TapjoyUtil.safePut(hashMap10, str2, f6515aO, true);
        }
        hashMap8.putAll(hashMap10);
        hashMap8.putAll(m6535g());
        hashMap.putAll(hashMap8);
        return hashMap;
    }

    public static Map getTimeStampAndVerifierParams() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String a = m6517a(currentTimeMillis);
        HashMap hashMap = new HashMap();
        TapjoyUtil.safePut(hashMap, "timestamp", String.valueOf(currentTimeMillis), true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_VERIFIER, a, true);
        return hashMap;
    }

    public static Map getLimitedTimeStampAndVerifierParams() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String b = m6526b(currentTimeMillis);
        HashMap hashMap = new HashMap();
        TapjoyUtil.safePut(hashMap, "timestamp", String.valueOf(currentTimeMillis), true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_VERIFIER, b, true);
        return hashMap;
    }

    /* renamed from: g */
    private static Map m6535g() {
        HashMap hashMap = new HashMap();
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_INSTALLED, f6535ao);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_REFERRER, f6536ap, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_LEVEL, f6537aq);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_FRIEND_COUNT, f6538ar);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_VARIABLE_1, f6539as, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_VARIABLE_2, f6540at, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_VARIABLE_3, f6541au, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_VARIABLE_4, f6542av, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_VARIABLE_5, f6543aw, true);
        int i = 0;
        for (String str : f6544ax) {
            StringBuilder sb = new StringBuilder("user_tags[");
            int i2 = i + 1;
            sb.append(i);
            sb.append("]");
            TapjoyUtil.safePut(hashMap, sb.toString(), str, true);
            i = i2;
        }
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_WEEKLY_FREQUENCY, f6545ay);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_MONTHLY_FREQUENCY, f6546az);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_SESSION_TOTAL_COUNT, f6501aA);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_SESSION_TOTAL_LENGTH, f6502aB);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_SESSION_LAST_AT, f6503aC);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_SESSION_LAST_LENGTH, f6504aD);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_PURCHASE_CURRENCY, f6505aE, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_PURCHASE_TOTAL_COUNT, f6506aF);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_PURCHASE_TOTAL_PRICE, f6507aG);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_PURCHASE_LAST_PRICE, f6508aH);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_PURCHASE_LAST_AT, f6509aI);
        return hashMap;
    }

    /* renamed from: a */
    private static boolean m6522a(Context context) {
        String str = "TapjoyConnect";
        f6552g = context;
        f6524ad = context.getPackageManager();
        C3104ge.m7159a().mo30181a(context);
        C3091ga.m7137a().mo30164a(context);
        f6525ae = new TapjoyGpsHelper(f6552g);
        if (f6555j == null) {
            f6555j = new TapjoyURLConnection();
        }
        if (f6526af == null) {
            f6526af = new Hashtable();
        }
        m6538j();
        int identifier = f6552g.getResources().getIdentifier("raw/tapjoy_config", null, f6552g.getPackageName());
        Properties properties = new Properties();
        try {
            properties.load(f6552g.getResources().openRawResource(identifier));
            m6520a(properties);
        } catch (Exception unused) {
        }
        if (C1852jq.m3669c(getConnectFlagValue("unit_test_mode"))) {
            m6539k();
        }
        String string = Secure.getString(f6552g.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
        f6559n = string;
        if (string != null) {
            f6559n = f6559n.toLowerCase();
        }
        try {
            boolean z = false;
            f6568w = f6524ad.getPackageInfo(f6552g.getPackageName(), 0).versionName;
            String str2 = "android";
            f6565t = str2;
            f6480E = str2;
            f6563r = Build.MODEL;
            f6564s = Build.MANUFACTURER;
            f6566u = VERSION.RELEASE;
            f6569x = "12.4.1";
            f6570y = TapjoyConstants.TJC_BRIDGE_VERSION_NUMBER;
            try {
                if (VERSION.SDK_INT > 3) {
                    TapjoyDisplayMetricsUtil tapjoyDisplayMetricsUtil = new TapjoyDisplayMetricsUtil(f6552g);
                    f6571z = tapjoyDisplayMetricsUtil.getScreenDensityDPI();
                    f6476A = tapjoyDisplayMetricsUtil.getScreenDensityScale();
                    f6477B = tapjoyDisplayMetricsUtil.getScreenLayoutSize();
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("Error getting screen density/dimensions/layout: ");
                sb.append(e.toString());
                TapjoyLog.m6552e(str, sb.toString());
            }
            String str3 = "";
            if (m6533e("android.permission.ACCESS_WIFI_STATE")) {
                try {
                    WifiManager wifiManager = (WifiManager) f6552g.getSystemService(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI);
                    if (wifiManager != null) {
                        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        if (connectionInfo != null) {
                            String macAddress = connectionInfo.getMacAddress();
                            f6561p = macAddress;
                            if (macAddress != null) {
                                f6561p = f6561p.replace(":", str3).toLowerCase();
                            }
                        }
                    }
                } catch (Exception e2) {
                    StringBuilder sb2 = new StringBuilder("Error getting device mac address: ");
                    sb2.append(e2.toString());
                    TapjoyLog.m6552e(str, sb2.toString());
                }
            } else {
                TapjoyLog.m6550d(str, "*** ignore macAddress");
            }
            TelephonyManager telephonyManager = (TelephonyManager) f6552g.getSystemService("phone");
            if (telephonyManager != null) {
                f6481F = telephonyManager.getNetworkOperatorName();
                f6482G = telephonyManager.getNetworkCountryIso();
                String networkOperator = telephonyManager.getNetworkOperator();
                if (networkOperator != null && (networkOperator.length() == 5 || networkOperator.length() == 6)) {
                    f6483H = networkOperator.substring(0, 3);
                    f6484I = networkOperator.substring(3);
                }
            }
            SharedPreferences sharedPreferences = f6552g.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
            String str4 = TapjoyConstants.PREF_INSTALL_ID;
            String string2 = sharedPreferences.getString(str4, str3);
            f6562q = string2;
            if (string2 == null || f6562q.length() == 0) {
                try {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(UUID.randomUUID().toString());
                    sb3.append(System.currentTimeMillis());
                    f6562q = TapjoyUtil.SHA256(sb3.toString());
                    Editor edit = sharedPreferences.edit();
                    edit.putString(str4, f6562q);
                    edit.apply();
                } catch (Exception e3) {
                    StringBuilder sb4 = new StringBuilder("Error generating install id: ");
                    sb4.append(e3.toString());
                    TapjoyLog.m6552e(str, sb4.toString());
                }
            }
            String str5 = TapjoyConnectFlag.STORE_NAME;
            if (getConnectFlagValue(str5) != null && getConnectFlagValue(str5).length() > 0) {
                f6487L = getConnectFlagValue(str5);
                if (!new ArrayList(Arrays.asList(TapjoyConnectFlag.STORE_ARRAY)).contains(f6487L)) {
                    StringBuilder sb5 = new StringBuilder("Warning -- undefined STORE_NAME: ");
                    sb5.append(f6487L);
                    TapjoyLog.m6555w(str, sb5.toString());
                }
            }
            try {
                String str6 = f6487L;
                Intent intent = new Intent("android.intent.action.VIEW");
                if (str6.length() <= 0) {
                    intent.setData(Uri.parse("market://details"));
                    if (f6524ad.queryIntentActivities(intent, 0).size() > 0) {
                        z = true;
                    }
                }
                f6494S = z;
            } catch (Exception e4) {
                StringBuilder sb6 = new StringBuilder("Error trying to detect store intent on devicee: ");
                sb6.append(e4.toString());
                TapjoyLog.m6552e(str, sb6.toString());
            }
            m6536h();
            String str7 = TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK;
            if (getConnectFlagValue(str7) != null && getConnectFlagValue(str7).length() > 0) {
                f6551f = getConnectFlagValue(str7);
            }
            String str8 = TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK;
            if (getConnectFlagValue(str8) != null && getConnectFlagValue(str8).length() > 0) {
                f6550e = getConnectFlagValue(str8);
            }
            String str9 = TapjoyConnectFlag.USER_ID;
            if (getConnectFlagValue(str9) != null && getConnectFlagValue(str9).length() > 0) {
                StringBuilder sb7 = new StringBuilder("Setting userID to: ");
                sb7.append(getConnectFlagValue(str9));
                TapjoyLog.m6553i(str, sb7.toString());
                setUserID(getConnectFlagValue(str9), null);
            }
            String str10 = TapjoyConnectFlag.PLACEMENT_TIMEOUT;
            if (getConnectFlagValue(str10) != null && getConnectFlagValue(str10).length() > 0) {
                TJPlacementManager.setPlacementResponseTimeOut(Integer.parseInt(getConnectFlagValue(str10)) * 1000);
            }
            f6492Q = TapjoyUtil.getRedirectDomain(getConnectFlagValue(TapjoyConnectFlag.SERVICE_URL));
            if (f6526af != null) {
                m6537i();
            }
            return true;
        } catch (NameNotFoundException e5) {
            throw new TapjoyException(e5.getMessage());
        }
    }

    /* renamed from: h */
    private static void m6536h() {
        C3044fb a = C1831gz.m3555a(f6552g).mo18118a(true);
        C3041fa faVar = a.f7101d;
        f6528ah = faVar.f7065h;
        f6529ai = faVar.f7075r;
        f6530aj = faVar.f7076s;
        f6510aJ = faVar.f7070m;
        f6511aK = faVar.f7071n;
        f6512aL = faVar.f7072o;
        f6513aM = faVar.f7078u;
        f6514aN = faVar.f7074q;
        C3023eu euVar = a.f7102e;
        f6531ak = euVar.f6963e;
        f6532al = euVar.f6964f;
        f6533am = euVar.f6965g;
        f6534an = euVar.f6966h;
        f6515aO = euVar.f6967i;
        C3062fh fhVar = a.f7103f;
        f6535ao = fhVar.f7196s;
        f6536ap = fhVar.f7197t;
        f6537aq = fhVar.f7187J;
        f6538ar = fhVar.f7188K;
        f6539as = fhVar.f7189L;
        f6540at = fhVar.f7190M;
        f6541au = fhVar.f7191N;
        f6542av = fhVar.f7192O;
        f6543aw = fhVar.f7193P;
        f6544ax = new HashSet(fhVar.f7194Q);
        f6545ay = fhVar.f7198u;
        f6546az = fhVar.f7199v;
        f6501aA = fhVar.f7201x;
        f6502aB = fhVar.f7202y;
        f6503aC = fhVar.f7203z;
        f6504aD = fhVar.f7178A;
        f6505aE = fhVar.f7179B;
        f6506aF = fhVar.f7180C;
        f6507aG = fhVar.f7181D;
        f6508aH = fhVar.f7183F;
        f6509aI = fhVar.f7182E;
    }

    /* renamed from: i */
    private static void m6537i() {
        String str = "TapjoyConnect";
        TapjoyLog.m6553i(str, "Connect Flags:");
        String str2 = "--------------------";
        TapjoyLog.m6553i(str, str2);
        for (Entry entry : f6526af.entrySet()) {
            StringBuilder sb = new StringBuilder("key: ");
            sb.append((String) entry.getKey());
            sb.append(", value: ");
            sb.append(Uri.encode(entry.getValue().toString()));
            TapjoyLog.m6553i(str, sb.toString());
        }
        StringBuilder sb2 = new StringBuilder("hostURL: [");
        sb2.append(getConnectFlagValue(TapjoyConnectFlag.SERVICE_URL));
        String str3 = "]";
        sb2.append(str3);
        TapjoyLog.m6553i(str, sb2.toString());
        StringBuilder sb3 = new StringBuilder("redirectDomain: [");
        sb3.append(f6492Q);
        sb3.append(str3);
        TapjoyLog.m6553i(str, sb3.toString());
        TapjoyLog.m6553i(str, str2);
    }

    /* renamed from: j */
    private static void m6538j() {
        String[] strArr;
        String str = "TapjoyConnect";
        try {
            if (f6524ad != null) {
                ApplicationInfo applicationInfo = f6524ad.getApplicationInfo(f6552g.getPackageName(), 128);
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    TapjoyLog.m6550d(str, "No metadata present.");
                } else {
                    for (String str2 : TapjoyConnectFlag.FLAG_ARRAY) {
                        Bundle bundle = applicationInfo.metaData;
                        StringBuilder sb = new StringBuilder("tapjoy.");
                        sb.append(str2);
                        String string = bundle.getString(sb.toString());
                        if (string != null) {
                            StringBuilder sb2 = new StringBuilder("Found manifest flag: ");
                            sb2.append(str2);
                            sb2.append(", ");
                            sb2.append(string);
                            TapjoyLog.m6550d(str, sb2.toString());
                            m6519a(str2, string);
                        }
                    }
                    TapjoyLog.m6550d(str, "Metadata successfully loaded");
                }
            }
        } catch (Exception e) {
            ErrorType errorType = ErrorType.SDK_ERROR;
            StringBuilder sb3 = new StringBuilder("Error reading manifest meta-data -- ");
            sb3.append(e.toString());
            TapjoyLog.m6551e(str, new TapjoyErrorMessage(errorType, sb3.toString()));
        }
    }

    /* renamed from: a */
    private static void m6520a(Properties properties) {
        Enumeration keys = properties.keys();
        while (keys.hasMoreElements()) {
            try {
                String str = (String) keys.nextElement();
                m6519a(str, (String) properties.get(str));
            } catch (ClassCastException unused) {
                TapjoyLog.m6552e("TapjoyConnect", "Error parsing configuration properties in tapjoy_config.txt");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r1 = new java.lang.StringBuilder("[ClassNotFoundException] Could not find dependency class ");
        r1.append((java.lang.String) f6558m.get(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0135, code lost:
        throw new com.tapjoy.TapjoyIntegrationException(r1.toString());
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x011a */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m6539k() {
        /*
            android.content.pm.PackageManager r0 = f6524ad     // Catch:{ Exception -> 0x01d9 }
            android.content.Context r1 = f6552g     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ Exception -> 0x01d9 }
            r2 = 1
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r2)     // Catch:{ Exception -> 0x01d9 }
            android.content.pm.ActivityInfo[] r0 = r0.activities     // Catch:{ Exception -> 0x01d9 }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r1 = "TapjoyConnect"
            if (r0 == 0) goto L_0x0136
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x01d9 }
        L_0x001b:
            boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x01d9 }
            if (r3 == 0) goto L_0x0136
            java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x01d9 }
            android.content.pm.ActivityInfo r3 = (android.content.pm.ActivityInfo) r3     // Catch:{ Exception -> 0x01d9 }
            java.util.Vector r4 = f6558m     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r5 = r3.name     // Catch:{ Exception -> 0x01d9 }
            boolean r4 = r4.contains(r5)     // Catch:{ Exception -> 0x01d9 }
            if (r4 == 0) goto L_0x001b
            java.util.Vector r4 = f6558m     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r5 = r3.name     // Catch:{ Exception -> 0x01d9 }
            int r4 = r4.indexOf(r5)     // Catch:{ Exception -> 0x01d9 }
            java.util.Vector r5 = f6558m     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.Class.forName(r5)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.util.Vector r5 = new java.util.Vector     // Catch:{ ClassNotFoundException -> 0x011a }
            r5.<init>()     // Catch:{ ClassNotFoundException -> 0x011a }
            int r6 = r3.configChanges     // Catch:{ ClassNotFoundException -> 0x011a }
            r7 = 128(0x80, float:1.794E-43)
            r6 = r6 & r7
            if (r6 == r7) goto L_0x0055
            java.lang.String r6 = "orientation"
            r5.add(r6)     // Catch:{ ClassNotFoundException -> 0x011a }
        L_0x0055:
            int r6 = r3.configChanges     // Catch:{ ClassNotFoundException -> 0x011a }
            r7 = 32
            r6 = r6 & r7
            if (r6 == r7) goto L_0x0061
            java.lang.String r6 = "keyboardHidden"
            r5.add(r6)     // Catch:{ ClassNotFoundException -> 0x011a }
        L_0x0061:
            int r6 = r5.size()     // Catch:{ ClassNotFoundException -> 0x011a }
            if (r6 == 0) goto L_0x00b9
            int r0 = r5.size()     // Catch:{ ClassNotFoundException -> 0x011a }
            if (r0 != r2) goto L_0x0093
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x011a }
            r1.<init>()     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x011a }
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = " property is not specified in manifest configChanges for "
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.util.Vector r2 = f6558m     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ ClassNotFoundException -> 0x011a }
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r1 = r1.toString()     // Catch:{ ClassNotFoundException -> 0x011a }
            r0.<init>(r1)     // Catch:{ ClassNotFoundException -> 0x011a }
            throw r0     // Catch:{ ClassNotFoundException -> 0x011a }
        L_0x0093:
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x011a }
            r1.<init>()     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x011a }
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = " properties are not specified in manifest configChanges for "
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.util.Vector r2 = f6558m     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ ClassNotFoundException -> 0x011a }
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r1 = r1.toString()     // Catch:{ ClassNotFoundException -> 0x011a }
            r0.<init>(r1)     // Catch:{ ClassNotFoundException -> 0x011a }
            throw r0     // Catch:{ ClassNotFoundException -> 0x011a }
        L_0x00b9:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ ClassNotFoundException -> 0x011a }
            r6 = 13
            if (r5 < r6) goto L_0x00df
            int r5 = r3.configChanges     // Catch:{ ClassNotFoundException -> 0x011a }
            r6 = 1024(0x400, float:1.435E-42)
            r5 = r5 & r6
            if (r5 == r6) goto L_0x00df
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r6 = "WARNING -- screenSize property is not specified in manifest configChanges for "
            r5.<init>(r6)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.util.Vector r6 = f6558m     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.Object r6 = r6.get(r4)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ClassNotFoundException -> 0x011a }
            r5.append(r6)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r5 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x011a }
            com.tapjoy.TapjoyLog.m6555w(r1, r5)     // Catch:{ ClassNotFoundException -> 0x011a }
        L_0x00df:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ ClassNotFoundException -> 0x011a }
            r6 = 11
            if (r5 < r6) goto L_0x0113
            java.lang.String r5 = r3.name     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r6 = "com.tapjoy.TJAdUnitActivity"
            boolean r5 = r5.equals(r6)     // Catch:{ ClassNotFoundException -> 0x011a }
            if (r5 == 0) goto L_0x0113
            int r3 = r3.flags     // Catch:{ ClassNotFoundException -> 0x011a }
            r5 = 512(0x200, float:7.175E-43)
            r3 = r3 & r5
            if (r3 != r5) goto L_0x00f7
            goto L_0x0113
        L_0x00f7:
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = "'hardwareAccelerated' property not specified in manifest for "
            r1.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.util.Vector r2 = f6558m     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ ClassNotFoundException -> 0x011a }
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r1 = r1.toString()     // Catch:{ ClassNotFoundException -> 0x011a }
            r0.<init>(r1)     // Catch:{ ClassNotFoundException -> 0x011a }
            throw r0     // Catch:{ ClassNotFoundException -> 0x011a }
        L_0x0113:
            java.util.Vector r3 = f6558m     // Catch:{ ClassNotFoundException -> 0x011a }
            r3.remove(r4)     // Catch:{ ClassNotFoundException -> 0x011a }
            goto L_0x001b
        L_0x011a:
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException     // Catch:{ Exception -> 0x01d9 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r2 = "[ClassNotFoundException] Could not find dependency class "
            r1.<init>(r2)     // Catch:{ Exception -> 0x01d9 }
            java.util.Vector r2 = f6558m     // Catch:{ Exception -> 0x01d9 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x01d9 }
            r1.append(r2)     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01d9 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x01d9 }
            throw r0     // Catch:{ Exception -> 0x01d9 }
        L_0x0136:
            java.util.Vector r0 = f6558m
            int r0 = r0.size()
            if (r0 == 0) goto L_0x0194
            java.util.Vector r0 = f6558m
            int r0 = r0.size()
            java.lang.String r1 = "Missing "
            if (r0 != r2) goto L_0x016e
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.util.Vector r1 = f6558m
            int r1 = r1.size()
            r2.append(r1)
            java.lang.String r1 = " dependency class in manifest: "
            r2.append(r1)
            java.util.Vector r1 = f6558m
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x016e:
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.util.Vector r1 = f6558m
            int r1 = r1.size()
            r2.append(r1)
            java.lang.String r1 = " dependency classes in manifest: "
            r2.append(r1)
            java.util.Vector r1 = f6558m
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0194:
            m6540l()
            java.lang.String r0 = "com.tapjoy.TJAdUnitJSBridge"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x01d1 }
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x01c9 }
            r3 = 0
            java.lang.Class<java.lang.Boolean> r4 = java.lang.Boolean.class
            r2[r3] = r4     // Catch:{ NoSuchMethodException -> 0x01c9 }
            java.lang.String r3 = "closeRequested"
            r0.getMethod(r3, r2)     // Catch:{ NoSuchMethodException -> 0x01c9 }
            java.lang.String r0 = "TJC_OPTION_DISABLE_ADVERTISING_ID_CHECK"
            java.lang.String r2 = getConnectFlagValue(r0)
            if (r2 == 0) goto L_0x01c3
            java.lang.String r0 = getConnectFlagValue(r0)
            java.lang.String r2 = "true"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x01c3
            java.lang.String r0 = "Skipping integration check for Google Play Services and Advertising ID. Do this only if you do not have access to Google Play Services."
            com.tapjoy.TapjoyLog.m6553i(r1, r0)
            return
        L_0x01c3:
            com.tapjoy.TapjoyGpsHelper r0 = f6525ae
            r0.checkGooglePlayIntegration()
            return
        L_0x01c9:
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException
            java.lang.String r1 = "Try configuring Proguard or other code obfuscators to ignore com.tapjoy classes. Visit http://dev.tapjoy.comfor more information."
            r0.<init>(r1)
            throw r0
        L_0x01d1:
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException
            java.lang.String r1 = "ClassNotFoundException: com.tapjoy.TJAdUnitJSBridge was not found."
            r0.<init>(r1)
            throw r0
        L_0x01d9:
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException
            java.lang.String r1 = "Error while getting package info."
            r0.<init>(r1)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyConnectCore.m6539k():void");
    }

    /* renamed from: l */
    private static void m6540l() {
        String[] strArr;
        String[] strArr2;
        Vector vector = new Vector();
        for (String str : TapjoyConstants.dependencyPermissions) {
            if (!m6533e(str)) {
                vector.add(str);
            }
        }
        if (vector.size() == 0) {
            Vector vector2 = new Vector();
            for (String str2 : TapjoyConstants.optionalPermissions) {
                if (!m6533e(str2)) {
                    vector2.add(str2);
                }
            }
            if (vector2.size() != 0) {
                String str3 = "WARNING -- ";
                String str4 = "TapjoyConnect";
                if (vector2.size() == 1) {
                    StringBuilder sb = new StringBuilder(str3);
                    sb.append(vector2.toString());
                    sb.append(" permission was not found in manifest. The exclusion of this permission could cause problems.");
                    TapjoyLog.m6555w(str4, sb.toString());
                    return;
                }
                StringBuilder sb2 = new StringBuilder(str3);
                sb2.append(vector2.toString());
                sb2.append(" permissions were not found in manifest. The exclusion of these permissions could cause problems.");
                TapjoyLog.m6555w(str4, sb2.toString());
            }
        } else if (vector.size() == 1) {
            StringBuilder sb3 = new StringBuilder("Missing 1 permission in manifest: ");
            sb3.append(vector.toString());
            throw new TapjoyIntegrationException(sb3.toString());
        } else {
            StringBuilder sb4 = new StringBuilder("Missing ");
            sb4.append(vector.size());
            sb4.append(" permissions in manifest: ");
            sb4.append(vector.toString());
            throw new TapjoyIntegrationException(sb4.toString());
        }
    }

    /* renamed from: m */
    private static boolean m6541m() {
        String str = f6548c;
        return str != null && str.length() > 0;
    }

    /* renamed from: n */
    private static boolean m6542n() {
        String str = TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK;
        return getConnectFlagValue(str) != null && getConnectFlagValue(str).equals("true");
    }

    /* renamed from: o */
    private static boolean m6543o() {
        if (!f6525ae.isGooglePlayServicesAvailable() || !f6525ae.isGooglePlayManifestConfigured()) {
            String str = TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK;
            if (getConnectFlagValue(str) != null && getConnectFlagValue(str).equals("true")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m6524a(String str, boolean z) {
        C1812bn bnVar;
        C1812bn bnVar2;
        C1812bn bnVar3;
        long j;
        String str2 = "TapjoyConnect";
        String str3 = TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS;
        try {
            bnVar = C1812bn.m3464b(str);
            try {
                Map d = bnVar.mo18059d();
                String a = C1852jq.m3667a((String) d.get(TapjoyConstants.TJC_APP_GROUP_ID));
                String a2 = C1852jq.m3667a((String) d.get("store"));
                String a3 = C1852jq.m3667a((String) d.get(TapjoyConstants.TJC_ANALYTICS_API_KEY));
                String a4 = C1852jq.m3667a((String) d.get(TapjoyConstants.TJC_MANAGED_DEVICE_ID));
                Object obj = d.get("cache_max_age");
                C3075fo foVar = new C3075fo(a3);
                if (foVar.f7249a == C1820a.RPC_ANALYTICS) {
                    String a5 = C3075fo.m7101a(foVar.f7250b);
                    String str4 = foVar.f7251c;
                    if (a == null) {
                        a = a5;
                    }
                    Object obj2 = obj;
                    C1831gz.m3554a().mo18119a(f6552g, a3, "12.4.1", TapjoyConfig.TJC_ANALYTICS_SERVICE_URL, a5, str4);
                    f6495T = a;
                    f6496U = a2;
                    f6497V = a3;
                    f6498W = a4;
                    bnVar.close();
                    if (!z) {
                        try {
                            if (obj2 instanceof String) {
                                try {
                                    j = Long.parseLong(((String) obj2).trim());
                                } catch (NumberFormatException unused) {
                                }
                            } else {
                                if (obj2 instanceof Number) {
                                    j = ((Number) obj2).longValue();
                                }
                                j = 0;
                            }
                            if (j <= 0) {
                                TapjoyAppSettings.getInstance().removeConnectResult();
                            } else {
                                TapjoyAppSettings.getInstance().saveConnectResultAndParams(str, m6546r(), (j * 1000) + C3256v.m7569b());
                            }
                            C3091ga a6 = C3091ga.m7137a();
                            Object obj3 = d.get(str3);
                            if (obj3 instanceof Map) {
                                try {
                                    a6.f7289a.mo18091a((Map) obj3);
                                    a6.mo30165c().edit().putString(str3, C2895bh.m6597a(obj3)).apply();
                                } catch (Exception unused2) {
                                }
                            } else if (obj3 == null) {
                                a6.f7289a.mo18091a((Map) null);
                                a6.mo30165c().edit().remove(str3).apply();
                            }
                        } catch (IOException e) {
                            e = e;
                            bnVar3 = null;
                        } catch (RuntimeException e2) {
                            e = e2;
                            bnVar2 = null;
                            TapjoyLog.m6554v(str2, e.getMessage());
                            C1854jz.m3672a(bnVar2);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            bnVar = null;
                            C1854jz.m3672a(bnVar);
                            throw th;
                        }
                    }
                    C1854jz.m3672a(null);
                    return true;
                }
                throw new IOException("Invalid analytics_api_key");
            } catch (IOException e3) {
                e = e3;
                bnVar3 = bnVar;
                TapjoyLog.m6554v(str2, e.getMessage());
                C1854jz.m3672a(bnVar2);
                return false;
            } catch (RuntimeException e4) {
                e = e4;
                bnVar2 = bnVar;
                TapjoyLog.m6554v(str2, e.getMessage());
                C1854jz.m3672a(bnVar2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                C1854jz.m3672a(bnVar);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bnVar3 = null;
            TapjoyLog.m6554v(str2, e.getMessage());
            C1854jz.m3672a(bnVar2);
            return false;
        } catch (RuntimeException e6) {
            e = e6;
            bnVar2 = null;
            TapjoyLog.m6554v(str2, e.getMessage());
            C1854jz.m3672a(bnVar2);
            return false;
        } catch (Throwable th3) {
            th = th3;
            bnVar = bnVar2;
            C1854jz.m3672a(bnVar);
            throw th;
        }
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r9v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r9v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: type inference failed for: r9v12, types: [com.tapjoy.internal.bn] */
    /* JADX WARNING: type inference failed for: r9v13 */
    /* JADX WARNING: type inference failed for: r9v14 */
    /* JADX WARNING: type inference failed for: r9v15 */
    /* JADX WARNING: type inference failed for: r9v16 */
    /* JADX WARNING: type inference failed for: r9v17 */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=null, for r9v0, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v4
      assigns: []
      uses: []
      mth insns count: 64
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m6529c(java.lang.String r9) {
        /*
            java.lang.String r0 = "TapjoyConnect"
            r1 = 0
            com.tapjoy.internal.bn r9 = com.tapjoy.internal.C1812bn.m3464b(r9)     // Catch:{ IOException -> 0x007a, RuntimeException -> 0x006e, all -> 0x006b }
            java.util.Map r2 = r9.mo18059d()     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            java.lang.String r3 = "app_group_id"
            java.lang.Object r3 = r2.get(r3)     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            java.lang.String r3 = com.tapjoy.internal.C1852jq.m3667a(r3)     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            java.lang.String r4 = "store"
            java.lang.Object r4 = r2.get(r4)     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            java.lang.String r4 = com.tapjoy.internal.C1852jq.m3667a(r4)     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            java.lang.String r5 = "analytics_api_key"
            java.lang.Object r5 = r2.get(r5)     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            java.lang.String r5 = com.tapjoy.internal.C1852jq.m3667a(r5)     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            java.lang.String r6 = "managed_device_id"
            java.lang.Object r2 = r2.get(r6)     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            java.lang.String r2 = com.tapjoy.internal.C1852jq.m3667a(r2)     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            com.tapjoy.internal.fo r6 = new com.tapjoy.internal.fo     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            com.tapjoy.internal.fo$a r5 = r6.f7249a     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            com.tapjoy.internal.fo$a r7 = com.tapjoy.internal.C3075fo.C1820a.RPC_ANALYTICS     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            if (r5 != r7) goto L_0x005d
            java.lang.String r5 = r6.f7250b     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            java.lang.String r5 = com.tapjoy.internal.C3075fo.m7101a(r5)     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            if (r3 != 0) goto L_0x004f
            r3 = r5
        L_0x004f:
            f6518aR = r3     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            f6496U = r4     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            f6498W = r2     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            r9.close()     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            com.tapjoy.internal.C1854jz.m3672a(r1)
            r9 = 1
            return r9
        L_0x005d:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            java.lang.String r2 = "Invalid analytics_api_key"
            r1.<init>(r2)     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
            throw r1     // Catch:{ IOException -> 0x0069, RuntimeException -> 0x0067 }
        L_0x0065:
            r0 = move-exception
            goto L_0x008a
        L_0x0067:
            r1 = move-exception
            goto L_0x0072
        L_0x0069:
            r1 = move-exception
            goto L_0x007e
        L_0x006b:
            r0 = move-exception
            r9 = r1
            goto L_0x008a
        L_0x006e:
            r9 = move-exception
            r8 = r1
            r1 = r9
            r9 = r8
        L_0x0072:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0065 }
            com.tapjoy.TapjoyLog.m6554v(r0, r1)     // Catch:{ all -> 0x0065 }
            goto L_0x0085
        L_0x007a:
            r9 = move-exception
            r8 = r1
            r1 = r9
            r9 = r8
        L_0x007e:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0065 }
            com.tapjoy.TapjoyLog.m6554v(r0, r1)     // Catch:{ all -> 0x0065 }
        L_0x0085:
            com.tapjoy.internal.C1854jz.m3672a(r9)
            r9 = 0
            return r9
        L_0x008a:
            com.tapjoy.internal.C1854jz.m3672a(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyConnectCore.m6529c(java.lang.String):boolean");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r4v13, types: [com.tapjoy.internal.bn] */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r4v18 */
    /* JADX WARNING: type inference failed for: r4v19 */
    /* JADX WARNING: type inference failed for: r4v20 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=null, for r4v0, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v5
      assigns: []
      uses: []
      mth insns count: 44
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m6531d(java.lang.String r4) {
        /*
            java.lang.String r0 = "TapjoyConnect"
            r1 = 0
            com.tapjoy.internal.bn r4 = com.tapjoy.internal.C1812bn.m3464b(r4)     // Catch:{ IOException -> 0x0039, RuntimeException -> 0x002d, all -> 0x002a }
            boolean r2 = r4.mo18055a()     // Catch:{ IOException -> 0x0028, RuntimeException -> 0x0026 }
            if (r2 == 0) goto L_0x001d
            r4.mo18078s()     // Catch:{ IOException -> 0x0028, RuntimeException -> 0x0026 }
            java.lang.String r2 = "Successfully sent completed Pay-Per-Action to Tapjoy server."
            com.tapjoy.TapjoyLog.m6550d(r0, r2)     // Catch:{ IOException -> 0x0028, RuntimeException -> 0x0026 }
            r4.close()     // Catch:{ IOException -> 0x0028, RuntimeException -> 0x0026 }
            com.tapjoy.internal.C1854jz.m3672a(r1)
            r4 = 1
            return r4
        L_0x001d:
            r4.close()     // Catch:{ IOException -> 0x0028, RuntimeException -> 0x0026 }
            com.tapjoy.internal.C1854jz.m3672a(r1)
            goto L_0x0047
        L_0x0024:
            r0 = move-exception
            goto L_0x0055
        L_0x0026:
            r1 = move-exception
            goto L_0x0031
        L_0x0028:
            r1 = move-exception
            goto L_0x003d
        L_0x002a:
            r0 = move-exception
            r4 = r1
            goto L_0x0055
        L_0x002d:
            r4 = move-exception
            r3 = r1
            r1 = r4
            r4 = r3
        L_0x0031:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0024 }
            com.tapjoy.TapjoyLog.m6554v(r0, r1)     // Catch:{ all -> 0x0024 }
            goto L_0x0044
        L_0x0039:
            r4 = move-exception
            r3 = r1
            r1 = r4
            r4 = r3
        L_0x003d:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0024 }
            com.tapjoy.TapjoyLog.m6554v(r0, r1)     // Catch:{ all -> 0x0024 }
        L_0x0044:
            com.tapjoy.internal.C1854jz.m3672a(r4)
        L_0x0047:
            com.tapjoy.TapjoyErrorMessage r4 = new com.tapjoy.TapjoyErrorMessage
            com.tapjoy.TapjoyErrorMessage$ErrorType r1 = com.tapjoy.TapjoyErrorMessage.ErrorType.SDK_ERROR
            java.lang.String r2 = "Completed Pay-Per-Action call failed."
            r4.<init>(r1, r2)
            com.tapjoy.TapjoyLog.m6551e(r0, r4)
            r4 = 0
            return r4
        L_0x0055:
            com.tapjoy.internal.C1854jz.m3672a(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyConnectCore.m6531d(java.lang.String):boolean");
    }

    public void release() {
        f6554i = null;
        f6555j = null;
        TapjoyLog.m6550d("TapjoyConnect", "Releasing core static instance.");
    }

    public static String getAppID() {
        return f6567v;
    }

    public static String getLimitedAppID() {
        return f6516aP;
    }

    public static String getUserID() {
        return f6478C;
    }

    public static String getHostURL() {
        return getConnectFlagValue(TapjoyConnectFlag.SERVICE_URL);
    }

    public static String getPlacementURL() {
        return getConnectFlagValue(TapjoyConnectFlag.PLACEMENT_URL);
    }

    public static String getRedirectDomain() {
        return f6492Q;
    }

    public static String getCarrierName() {
        return f6481F;
    }

    public static String getConnectionType() {
        String str = "TapjoyConnect";
        String str2 = "";
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) f6552g.getSystemService("connectivity");
            if (!(connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null)) {
                int type = connectivityManager.getActiveNetworkInfo().getType();
                str2 = (type == 1 || type == 6) ? TapjoyConstants.TJC_CONNECTION_TYPE_WIFI : TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE;
                StringBuilder sb = new StringBuilder("connectivity: ");
                sb.append(connectivityManager.getActiveNetworkInfo().getType());
                TapjoyLog.m6550d(str, sb.toString());
                StringBuilder sb2 = new StringBuilder("connection_type: ");
                sb2.append(str2);
                TapjoyLog.m6550d(str, sb2.toString());
            }
        } catch (Exception e) {
            StringBuilder sb3 = new StringBuilder("getConnectionType error: ");
            sb3.append(e.toString());
            TapjoyLog.m6552e(str, sb3.toString());
        }
        return str2;
    }

    public static String getConnectionSubType() {
        String str = "TapjoyConnect";
        String str2 = "";
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) f6552g.getSystemService("connectivity");
            if (connectivityManager == null) {
                return str2;
            }
            String subtypeName = connectivityManager.getActiveNetworkInfo().getSubtypeName();
            StringBuilder sb = new StringBuilder("connection_sub_type: ");
            sb.append(subtypeName);
            TapjoyLog.m6550d(str, sb.toString());
            return subtypeName;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder("getConnectionSubType error: ");
            sb2.append(e.toString());
            TapjoyLog.m6552e(str, sb2.toString());
            return str2;
        }
    }

    /* renamed from: p */
    private static String m6544p() {
        String str = "TapjoyConnect";
        TapjoyLog.m6553i(str, "generating sessionID...");
        String str2 = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis() / 1000);
            sb.append(f6567v);
            str2 = TapjoyUtil.SHA256(sb.toString());
            f6522aa = System.currentTimeMillis();
            return str2;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder("unable to generate session id: ");
            sb2.append(e.toString());
            TapjoyLog.m6552e(str, sb2.toString());
            return str2;
        }
    }

    public static Context getContext() {
        return f6552g;
    }

    /* renamed from: q */
    private static String m6545q() {
        if (m6541m()) {
            return f6548c;
        }
        if (m6542n() || !m6543o()) {
            String str = f6561p;
            boolean z = true;
            if (str != null && str.length() > 0) {
                return f6561p;
            }
            String str2 = f6559n;
            if (str2 == null || str2.length() <= 0) {
                z = false;
            }
            if (z) {
                return f6559n;
            }
        }
        TapjoyLog.m6552e("TapjoyConnect", "Error -- no valid device identifier");
        return null;
    }

    /* renamed from: a */
    private static String m6517a(long j) {
        String str = ":";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(f6567v);
            sb.append(str);
            sb.append(m6545q());
            sb.append(str);
            sb.append(j);
            sb.append(str);
            sb.append(f6488M);
            return TapjoyUtil.SHA256(sb.toString());
        } catch (Exception e) {
            ErrorType errorType = ErrorType.SDK_ERROR;
            StringBuilder sb2 = new StringBuilder("Error in computing verifier value -- ");
            sb2.append(e.toString());
            TapjoyLog.m6551e("TapjoyConnect", new TapjoyErrorMessage(errorType, sb2.toString()));
            return "";
        }
    }

    /* renamed from: b */
    private static String m6526b(long j) {
        String str = ":";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(f6516aP);
            sb.append(str);
            sb.append(m6545q());
            sb.append(str);
            sb.append(j);
            sb.append(str);
            sb.append(f6517aQ);
            return TapjoyUtil.SHA256(sb.toString());
        } catch (Exception e) {
            ErrorType errorType = ErrorType.SDK_ERROR;
            StringBuilder sb2 = new StringBuilder("Error in computing verifier value -- ");
            sb2.append(e.toString());
            TapjoyLog.m6551e("TapjoyConnect", new TapjoyErrorMessage(errorType, sb2.toString()));
            return "";
        }
    }

    public static String getAwardCurrencyVerifier(long j, int i, String str) {
        String str2 = ":";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(f6567v);
            sb.append(str2);
            sb.append(m6545q());
            sb.append(str2);
            sb.append(j);
            sb.append(str2);
            sb.append(f6488M);
            sb.append(str2);
            sb.append(i);
            sb.append(str2);
            sb.append(str);
            return TapjoyUtil.SHA256(sb.toString());
        } catch (Exception e) {
            ErrorType errorType = ErrorType.SDK_ERROR;
            StringBuilder sb2 = new StringBuilder("Error in computing awardCurrencyVerifier -- ");
            sb2.append(e.toString());
            TapjoyLog.m6551e("TapjoyConnect", new TapjoyErrorMessage(errorType, sb2.toString()));
            return "";
        }
    }

    public boolean isInitialized() {
        return this.f6574ab;
    }

    public static void setPlugin(String str) {
        f6490O = str;
    }

    public static void setSDKType(String str) {
        f6491P = str;
    }

    public static void setUserID(String str, TJSetUserIDListener tJSetUserIDListener) {
        f6478C = str;
        f6557l = tJSetUserIDListener;
        StringBuilder sb = new StringBuilder("URL parameters: ");
        sb.append(getURLParams());
        TapjoyLog.m6550d("TapjoyConnect", sb.toString());
        new Thread(new Runnable() {
            public final void run() {
                StringBuilder sb = new StringBuilder("Setting userID to ");
                sb.append(TapjoyConnectCore.f6478C);
                TapjoyLog.m6553i("TapjoyConnect", sb.toString());
                TapjoyURLConnection c = TapjoyConnectCore.f6555j;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(TapjoyConnectCore.getHostURL());
                sb2.append(TapjoyConstants.TJC_USER_ID_URL_PATH);
                TapjoyHttpURLResponse responseFromURL = c.getResponseFromURL(sb2.toString(), TapjoyConnectCore.getURLParams());
                TapjoyConnectCore.m6521a(responseFromURL.response != null ? TapjoyConnectCore.m6523a(responseFromURL.response) : false);
            }
        }).start();
    }

    public static void viewDidClose(String str) {
        StringBuilder sb = new StringBuilder("viewDidClose: ");
        sb.append(str);
        TapjoyLog.m6550d("TapjoyConnect", sb.toString());
        f6527ag.remove(str);
        C3081fs.f7268e.notifyObservers();
    }

    public static void viewWillOpen(String str, int i) {
        StringBuilder sb = new StringBuilder("viewWillOpen: ");
        sb.append(str);
        TapjoyLog.m6550d("TapjoyConnect", sb.toString());
        f6527ag.put(str, Integer.valueOf(i));
    }

    public static boolean isViewOpen() {
        StringBuilder sb = new StringBuilder("isViewOpen: ");
        sb.append(f6527ag.size());
        TapjoyLog.m6550d("TapjoyConnect", sb.toString());
        return !f6527ag.isEmpty();
    }

    public static boolean isFullScreenViewOpen() {
        for (Integer intValue : f6527ag.values()) {
            int intValue2 = intValue.intValue();
            if (intValue2 != 1) {
                if (intValue2 == 2) {
                }
            }
            return true;
        }
        return false;
    }

    public static void setViewShowing(boolean z) {
        if (z) {
            f6527ag.put("", Integer.valueOf(1));
            return;
        }
        f6527ag.clear();
    }

    /* renamed from: a */
    private static void m6519a(String str, String str2) {
        if (str.equals(TapjoyConnectFlag.SERVICE_URL) || str.equals(TapjoyConnectFlag.PLACEMENT_URL)) {
            String str3 = Constants.URL_PATH_DELIMITER;
            if (!str2.endsWith(str3)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(str3);
                str2 = sb.toString();
            }
        }
        f6526af.put(str, str2);
    }

    /* renamed from: e */
    private static boolean m6533e(String str) {
        return f6524ad.checkPermission(str, f6552g.getPackageName()) == 0;
    }

    public void actionComplete(String str) {
        StringBuilder sb = new StringBuilder("actionComplete: ");
        sb.append(str);
        String str2 = "TapjoyConnect";
        TapjoyLog.m6553i(str2, sb.toString());
        Map f = m6534f();
        TapjoyUtil.safePut(f, "app_id", str, true);
        f.putAll(getTimeStampAndVerifierParams());
        StringBuilder sb2 = new StringBuilder("PPA URL parameters: ");
        sb2.append(f);
        TapjoyLog.m6550d(str2, sb2.toString());
        new Thread(new PPAThread(f)).start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void completeConnectCall() {
        /*
            r8 = this;
            java.lang.String r0 = "TapjoyConnect"
            java.lang.String r1 = "starting connect call..."
            com.tapjoy.TapjoyLog.m6550d(r0, r1)
            java.lang.String r1 = getHostURL()
            java.lang.String r2 = "https://ws.tapjoyads.com/"
            if (r1 == r2) goto L_0x0014
            java.lang.String r1 = getHostURL()
            goto L_0x0016
        L_0x0014:
            java.lang.String r1 = "https://connect.tapjoy.com/"
        L_0x0016:
            boolean r2 = isConnected()
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x004b
            com.tapjoy.TapjoyAppSettings r2 = com.tapjoy.TapjoyAppSettings.getInstance()
            java.lang.String r5 = m6546r()
            long r6 = com.tapjoy.internal.C3256v.m7569b()
            java.lang.String r2 = r2.getConnectResult(r5, r6)
            if (r2 == 0) goto L_0x004b
            boolean r2 = m6524a(r2, r4)
            if (r2 == 0) goto L_0x004b
            java.lang.String r2 = "Connect using stored connect result"
            com.tapjoy.TapjoyLog.m6553i(r0, r2)
            f6523ac = r4
            com.tapjoy.TJConnectListener r2 = f6556k
            if (r2 == 0) goto L_0x0044
            r2.onConnectSuccess()
        L_0x0044:
            com.tapjoy.internal.fs$a r2 = com.tapjoy.internal.C3081fs.f7264a
            r2.notifyObservers()
            r2 = 1
            goto L_0x004c
        L_0x004b:
            r2 = 0
        L_0x004c:
            com.tapjoy.TapjoyURLConnection r5 = f6555j
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r1)
            java.lang.String r1 = "api/connect/v3.json?"
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            java.util.Map r6 = getURLParams()
            r7 = 0
            com.tapjoy.TapjoyHttpURLResponse r1 = r5.getResponseFromURL(r1, r7, r7, r6)
            if (r1 == 0) goto L_0x00de
            int r5 = r1.statusCode
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 != r6) goto L_0x00de
            java.lang.String r1 = r1.response
            boolean r1 = m6524a(r1, r3)
            if (r1 == 0) goto L_0x00d1
            java.lang.String r1 = "Successfully connected to Tapjoy"
            com.tapjoy.TapjoyLog.m6553i(r0, r1)
            f6523ac = r4
            java.util.Map r1 = getGenericURLParams()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x008b:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00bb
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Object r5 = r3.getKey()
            java.lang.String r5 = (java.lang.String) r5
            r4.append(r5)
            java.lang.String r5 = ": "
            r4.append(r5)
            java.lang.Object r3 = r3.getValue()
            java.lang.String r3 = (java.lang.String) r3
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.tapjoy.TapjoyLog.m6550d(r0, r3)
            goto L_0x008b
        L_0x00bb:
            if (r2 != 0) goto L_0x00c9
            com.tapjoy.TJConnectListener r0 = f6556k
            if (r0 == 0) goto L_0x00c4
            r0.onConnectSuccess()
        L_0x00c4:
            com.tapjoy.internal.fs$a r0 = com.tapjoy.internal.C3081fs.f7264a
            r0.notifyObservers()
        L_0x00c9:
            com.tapjoy.internal.fs$a r0 = com.tapjoy.internal.C3081fs.f7265b
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.notifyObservers(r1)
            return
        L_0x00d1:
            if (r2 != 0) goto L_0x00d6
            m6530d()
        L_0x00d6:
            com.tapjoy.internal.fs$a r0 = com.tapjoy.internal.C3081fs.f7265b
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.notifyObservers(r1)
            return
        L_0x00de:
            if (r2 != 0) goto L_0x00e3
            m6530d()
        L_0x00e3:
            com.tapjoy.internal.fs$a r0 = com.tapjoy.internal.C3081fs.f7265b
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.notifyObservers(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyConnectCore.completeConnectCall():void");
    }

    public void completeLimitedConnectCall() {
        String hostURL = getHostURL() != TapjoyConfig.TJC_SERVICE_URL ? getHostURL() : TapjoyConfig.TJC_CONNECT_SERVICE_URL;
        Map limitedURLParams = getLimitedURLParams();
        TapjoyURLConnection tapjoyURLConnection = f6555j;
        StringBuilder sb = new StringBuilder();
        sb.append(hostURL);
        sb.append(TapjoyConstants.TJC_CONNECT_URL_PATH);
        TapjoyHttpURLResponse responseFromURL = tapjoyURLConnection.getResponseFromURL(sb.toString(), (Map) null, (Map) null, limitedURLParams);
        if (responseFromURL == null || responseFromURL.statusCode != 200) {
            m6532e();
            C3081fs.f7265b.notifyObservers(Boolean.FALSE);
        } else if (m6529c(responseFromURL.response)) {
            String str = "TapjoyConnect";
            TapjoyLog.m6553i(str, "Successfully connected to Tapjoy");
            f6519aS = true;
            for (Entry entry : getLimitedGenericURLParams().entrySet()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append((String) entry.getKey());
                sb2.append(": ");
                sb2.append((String) entry.getValue());
                TapjoyLog.m6550d(str, sb2.toString());
            }
            TJConnectListener tJConnectListener = f6520aT;
            if (tJConnectListener != null) {
                tJConnectListener.onConnectSuccess();
            }
            C3081fs.f7264a.notifyObservers();
            C3081fs.f7265b.notifyObservers(Boolean.TRUE);
        } else {
            m6532e();
            C3081fs.f7265b.notifyObservers(Boolean.FALSE);
        }
    }

    public void setCurrencyMultiplier(float f) {
        StringBuilder sb = new StringBuilder("setVirtualCurrencyMultiplier: ");
        sb.append(f);
        TapjoyLog.m6553i("TapjoyConnect", sb.toString());
        f6493R = f;
    }

    public float getCurrencyMultiplier() {
        return f6493R;
    }

    public static String getConnectFlagValue(String str) {
        Hashtable hashtable = f6526af;
        return (hashtable == null || hashtable.get(str) == null) ? "" : f6526af.get(str).toString();
    }

    public static String getSecretKey() {
        return f6488M;
    }

    public static String getAndroidID() {
        return f6559n;
    }

    public static String getSha1MacAddress() {
        try {
            return TapjoyUtil.SHA1(f6561p);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Error generating sha1 of macAddress: ");
            sb.append(e.toString());
            TapjoyLog.m6552e("TapjoyConnect", sb.toString());
            return null;
        }
    }

    public static String getMacAddress() {
        return f6561p;
    }

    public static float getDeviceScreenDensityScale() {
        return f6476A;
    }

    public static String getSupportURL(String str) {
        if (str == null) {
            str = f6567v;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getHostURL());
        sb.append("support_requests/new?currency_id=");
        sb.append(str);
        sb.append("&app_id=");
        sb.append(f6567v);
        sb.append("&udid=");
        sb.append(f6498W);
        sb.append("&language_code=");
        sb.append(Locale.getDefault().getLanguage());
        return sb.toString();
    }

    public static String getUserToken() {
        if (C1852jq.m3669c(f6478C)) {
            return f6498W;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f6498W);
        sb.append(":");
        sb.append(f6478C);
        return sb.toString();
    }

    public static boolean isConnected() {
        return f6523ac;
    }

    public static boolean isLimitedConnected() {
        return f6519aS;
    }

    public static boolean isUnitTestMode() {
        return getConnectFlagValue("unit_test_mode") == "true";
    }

    /* renamed from: r */
    private static String m6546r() {
        StringBuilder sb = new StringBuilder();
        sb.append(f6567v);
        sb.append(f6568w);
        sb.append(f6569x);
        sb.append(f6548c);
        sb.append(f6562q);
        String sb2 = sb.toString();
        try {
            return TapjoyUtil.SHA1(sb2);
        } catch (Exception unused) {
            return sb2;
        }
    }

    public static void setAdTrackingEnabled() {
        boolean z;
        if (C3104ge.m7159a() != null) {
            C3104ge a = C3104ge.m7159a();
            if (a.f7327c == null) {
                z = false;
            } else {
                z = a.f7327c.booleanValue();
            }
            if (z) {
                f6549d = false;
                return;
            }
        }
        TapjoyGpsHelper tapjoyGpsHelper = f6525ae;
        if (tapjoyGpsHelper != null) {
            f6549d = tapjoyGpsHelper.isAdTrackingEnabled();
        }
    }

    public static void setCustomParameter(String str) {
        f6479D = str;
    }

    public static String getCustomParameter() {
        return f6479D;
    }

    /* renamed from: a */
    static /* synthetic */ void m6518a() {
        if (!f6521aU) {
            try {
                f6525ae.loadAdvertisingId(!m6542n());
                if (f6525ae.isGooglePlayServicesAvailable() && f6525ae.isGooglePlayManifestConfigured()) {
                    f6547b = f6525ae.getDeviceGooglePlayServicesVersion();
                    f6500a = f6525ae.getPackagedGooglePlayServicesVersion();
                }
                if (f6525ae.isAdIdAvailable()) {
                    setAdTrackingEnabled();
                    f6548c = f6525ae.getAdvertisingId();
                    C1831gz a = C1831gz.m3554a();
                    String str = f6548c;
                    boolean z = !f6549d;
                    C1835hc hcVar = a.f3822f;
                    String a2 = hcVar.f3843c.f7424A.mo30368a();
                    hcVar.f3842b.f7220q = str;
                    hcVar.f3842b.f7221r = Boolean.valueOf(z);
                    hcVar.f3843c.f7424A.mo30369a(str);
                    hcVar.f3843c.f7425B.mo30204a(z);
                    C3147hn.m7279a(str, z);
                    if (!C1852jq.m3669c(a2) && !str.equals(a2)) {
                        hcVar.f3843c.mo30218a(false);
                    }
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("Error fetching advertising id: ");
                sb.append(e.toString());
                TapjoyLog.m6553i("TapjoyConnect", sb.toString());
                e.printStackTrace();
            }
            f6521aU = true;
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m6523a(String str) {
        Document buildDocument = TapjoyUtil.buildDocument(str);
        if (buildDocument != null) {
            String nodeTrimValue = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Success"));
            if (nodeTrimValue == null || !nodeTrimValue.equals("true")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6521a(boolean z) {
        String str = "TapjoyConnect";
        if (z) {
            TapjoyLog.m6553i(str, "Set userID is successful");
            TJSetUserIDListener tJSetUserIDListener = f6557l;
            if (tJSetUserIDListener != null) {
                tJSetUserIDListener.onSetUserIDSuccess();
            }
        } else {
            String str2 = "Failed to set userID";
            TapjoyLog.m6551e(str, new TapjoyErrorMessage(ErrorType.SDK_ERROR, str2));
            TJSetUserIDListener tJSetUserIDListener2 = f6557l;
            if (tJSetUserIDListener2 != null) {
                tJSetUserIDListener2.onSetUserIDFailure(str2);
            }
        }
    }
}
