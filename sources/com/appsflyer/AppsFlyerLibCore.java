package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFExecutor.C13175.C13183;
import com.appsflyer.AFFacebookDeferredDeeplink.AppLinkFetchEvents;
import com.appsflyer.AFFacebookDeferredDeeplink.C13194;
import com.appsflyer.AFLogger.LogLevel;
import com.appsflyer.AppsFlyerProperties.EmailsCryptType;
import com.appsflyer.OneLinkHttpTask.HttpsUrlConnectionProvider;
import com.appsflyer.internal.C1336aa;
import com.appsflyer.internal.C1338ab;
import com.appsflyer.internal.C1339ac;
import com.appsflyer.internal.C1341ad;
import com.appsflyer.internal.C1343ae;
import com.appsflyer.internal.C1346af;
import com.appsflyer.internal.C1347ag;
import com.appsflyer.internal.C1348ah;
import com.appsflyer.internal.C1348ah.C1350d;
import com.appsflyer.internal.C1351ai;
import com.appsflyer.internal.C1351ai.C1352e;
import com.appsflyer.internal.C1356am;
import com.appsflyer.internal.C1366f;
import com.appsflyer.internal.C1366f.C13675;
import com.appsflyer.internal.C1372j;
import com.appsflyer.internal.C1373m;
import com.appsflyer.internal.C1376r.C13773;
import com.appsflyer.internal.C1376r.C1378c;
import com.appsflyer.internal.C1379s;
import com.appsflyer.internal.C1379s.C1380d;
import com.appsflyer.internal.C1379s.C1381e;
import com.appsflyer.internal.C1382u;
import com.appsflyer.internal.C1388w;
import com.appsflyer.internal.C1393x;
import com.appsflyer.internal.C1396z;
import com.appsflyer.internal.model.event.AdRevenue;
import com.appsflyer.internal.model.event.BackgroundReferrerLaunch;
import com.appsflyer.internal.model.event.CachedEvent;
import com.appsflyer.internal.model.event.InAppEvent;
import com.appsflyer.internal.model.event.Launch;
import com.appsflyer.internal.model.event.NewGPReferrer;
import com.appsflyer.share.Constants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.GoogleApiAvailability;
import com.tapjoy.TapjoyConstants;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.NetworkInterface;
import java.security.KeyStoreException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppsFlyerLibCore extends AppsFlyerLib {
    public static final String AF_PRE_INSTALL_PATH = "AF_PRE_INSTALL_PATH";
    public static final String IS_STOP_TRACKING_USED = "is_stop_tracking_used";
    public static final String LOG_TAG = "AppsFlyer_5.1.1";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT = "/data/local/tmp/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT_ETC = "/etc/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_RO_PROP = "ro.appsflyer.preinstall.path";

    /* renamed from: ʻ */
    private static String f3327 = "https://%slaunches.%s/api/v4.11/androidevent?app_id=";

    /* renamed from: ʽ */
    private static String f3328 = "https://%sconversions.%s/api/v4.11/androidevent?app_id=";

    /* renamed from: ˊ */
    public static final String f3329 = "292";
    @VisibleForTesting

    /* renamed from: ˊॱ */
    private static AppsFlyerLibCore f3330 = new AppsFlyerLibCore();

    /* renamed from: ˋ */
    public static AppsFlyerInAppPurchaseValidatorListener f3331 = null;

    /* renamed from: ˏॱ */
    private static final List<String> f3332 = Arrays.asList(new String[]{"is_cache"});
    /* access modifiers changed from: private */

    /* renamed from: ॱˊ */
    public static AppsFlyerConversionListener f3333 = null;
    public Uri latestDeepLink = null;

    /* renamed from: ʻॱ */
    private long f3334 = -1;

    /* renamed from: ʼ */
    public long f3335;

    /* renamed from: ʼॱ */
    private C1350d f3336;

    /* renamed from: ʽॱ */
    private boolean f3337 = false;
    /* access modifiers changed from: private */

    /* renamed from: ʾ */
    public ScheduledExecutorService f3338 = null;

    /* renamed from: ʿ */
    private long f3339;

    /* renamed from: ˈ */
    private boolean f3340 = false;

    /* renamed from: ˉ */
    private boolean f3341;

    /* renamed from: ˊˊ */
    private String f3342;

    /* renamed from: ˊˋ */
    private Map<Long, String> f3343;

    /* renamed from: ˊᐝ */
    private boolean f3344;

    /* renamed from: ˋˊ */
    private C1343ae f3345 = new C1343ae();

    /* renamed from: ˋˋ */
    private boolean f3346 = false;

    /* renamed from: ˋॱ */
    private long f3347 = -1;

    /* renamed from: ˋᐝ */
    private Application f3348;
    /* access modifiers changed from: private */

    /* renamed from: ˌ */
    public Map<String, Object> f3349;

    /* renamed from: ˍ */
    private boolean f3350 = false;
    @VisibleForTesting

    /* renamed from: ˎ */
    long f3351;
    /* access modifiers changed from: private */

    /* renamed from: ˎˎ */
    public Map<String, Object> f3352;

    /* renamed from: ˏ */
    public String f3353;

    /* renamed from: ˏˏ */
    private String f3354;
    /* access modifiers changed from: private */

    /* renamed from: ˑ */
    public boolean f3355 = false;

    /* renamed from: ͺ */
    private String f3356;

    /* renamed from: ॱ */
    public String f3357;
    /* access modifiers changed from: private */

    /* renamed from: ॱˋ */
    public boolean f3358 = false;
    /* access modifiers changed from: private */

    /* renamed from: ॱˎ */
    public Map<String, Object> f3359;

    /* renamed from: ॱॱ */
    public boolean f3360 = false;

    /* renamed from: ॱᐝ */
    private long f3361 = TimeUnit.SECONDS.toMillis(5);

    /* renamed from: ᐝ */
    public long f3362;

    /* renamed from: ᐝॱ */
    private C1372j f3363 = null;

    /* renamed from: com.appsflyer.AppsFlyerLibCore$10 */
    static /* synthetic */ class C132110 {

        /* renamed from: ˎ */
        static final /* synthetic */ int[] f3366 = new int[EmailsCryptType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.appsflyer.AppsFlyerProperties$EmailsCryptType[] r0 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3366 = r0
                int[] r0 = f3366     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.SHA256     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3366     // Catch:{ NoSuchFieldError -> 0x001f }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.NONE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.C132110.<clinit>():void");
        }
    }

    @VisibleForTesting
    /* renamed from: com.appsflyer.AppsFlyerLibCore$a */
    static class C1328a implements Runnable {

        /* renamed from: ˋ */
        private static final List<String> f3378 = Arrays.asList(new String[]{"googleplay", "playstore", "googleplaystore"});
        @VisibleForTesting

        /* renamed from: ˏ */
        private static String f3379 = "https://%sgcdsdk.%s/install_data/v4.0/";

        /* renamed from: ʽ */
        private AppsFlyerLibCore f3380;

        /* renamed from: ˊ */
        private final String f3381;

        /* renamed from: ˎ */
        final ScheduledExecutorService f3382;

        /* renamed from: ॱ */
        private final Application f3383;

        /* renamed from: ॱॱ */
        private final int f3384;

        /* renamed from: ᐝ */
        private final AtomicInteger f3385;

        /* synthetic */ C1328a(AppsFlyerLibCore appsFlyerLibCore, Application application, String str, byte b) {
            this(appsFlyerLibCore, application, str);
        }

        private C1328a(AppsFlyerLibCore appsFlyerLibCore, Application application, String str) {
            this.f3382 = AFExecutor.getInstance().mo10646();
            this.f3385 = new AtomicInteger(0);
            this.f3380 = appsFlyerLibCore;
            this.f3383 = application;
            this.f3381 = str;
            this.f3384 = 0;
        }

        private C1328a(C1328a aVar) {
            this.f3382 = AFExecutor.getInstance().mo10646();
            this.f3385 = new AtomicInteger(0);
            this.f3380 = aVar.f3380;
            this.f3383 = aVar.f3383;
            this.f3381 = aVar.f3381;
            this.f3384 = aVar.f3384 + 1;
        }

        /* renamed from: ˏ */
        private void m3255(String str, int i) {
            String str2 = "Calling onConversionFailure with:\n";
            if (500 > i || i >= 600) {
                AFLogger.afDebugLog(str2.concat(String.valueOf(str)));
                AppsFlyerLibCore.f3333.onConversionDataFail(str);
            } else if (this.f3384 == 2) {
                AFLogger.afDebugLog(str2.concat(String.valueOf(str)));
                AppsFlyerLibCore.f3333.onConversionDataFail(str);
            } else {
                C1328a aVar = new C1328a(this);
                AppsFlyerLibCore.m3195(aVar.f3382, aVar, 10, TimeUnit.MILLISECONDS);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:100:0x02a5  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00a8 A[Catch:{ Throwable -> 0x0279 }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00f2 A[Catch:{ Throwable -> 0x0273, all -> 0x0271 }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0111 A[Catch:{ Throwable -> 0x0273, all -> 0x0271 }] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0161 A[Catch:{ Throwable -> 0x0273, all -> 0x0271 }] */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x026d  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0280 A[Catch:{ all -> 0x0276 }] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0295  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r14 = this;
                java.lang.String r0 = "is_first_launch"
                java.lang.String r1 = "af_siteid"
                java.lang.String r2 = r14.f3381
                if (r2 == 0) goto L_0x02a9
                int r2 = r2.length()
                if (r2 != 0) goto L_0x0010
                goto L_0x02a9
            L_0x0010:
                com.appsflyer.AppsFlyerLibCore r2 = r14.f3380
                boolean r2 = r2.isTrackingStopped()
                if (r2 == 0) goto L_0x0019
                return
            L_0x0019:
                java.util.concurrent.atomic.AtomicInteger r2 = r14.f3385
                r2.incrementAndGet()
                r2 = 0
                r3 = 0
                android.app.Application r4 = r14.f3383     // Catch:{ Throwable -> 0x0279 }
                if (r4 != 0) goto L_0x002a
                java.util.concurrent.atomic.AtomicInteger r0 = r14.f3385
                r0.decrementAndGet()
                return
            L_0x002a:
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0279 }
                android.app.Application r6 = r14.f3383     // Catch:{ Throwable -> 0x0279 }
                java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference     // Catch:{ Throwable -> 0x0279 }
                android.app.Application r8 = r14.f3383     // Catch:{ Throwable -> 0x0279 }
                r7.<init>(r8)     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r7 = com.appsflyer.AppsFlyerLibCore.m3227(r7)     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r6 = com.appsflyer.AppsFlyerLibCore.m3199(r6, r7)     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r7 = ""
                r8 = 1
                if (r6 == 0) goto L_0x0068
                java.util.List<java.lang.String> r9 = f3378     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r10 = r6.toLowerCase()     // Catch:{ Throwable -> 0x0279 }
                boolean r9 = r9.contains(r10)     // Catch:{ Throwable -> 0x0279 }
                if (r9 != 0) goto L_0x005b
                java.lang.String r9 = "-"
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r6 = r9.concat(r6)     // Catch:{ Throwable -> 0x0279 }
                goto L_0x0069
            L_0x005b:
                java.lang.String r9 = "AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix."
                java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x0279 }
                r10[r3] = r6     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r6 = java.lang.String.format(r9, r10)     // Catch:{ Throwable -> 0x0279 }
                com.appsflyer.AFLogger.afWarnLog(r6)     // Catch:{ Throwable -> 0x0279 }
            L_0x0068:
                r6 = r7
            L_0x0069:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0279 }
                r9.<init>()     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r10 = f3379     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r10 = com.appsflyer.ServerConfigHandler.getUrl(r10)     // Catch:{ Throwable -> 0x0279 }
                r9.append(r10)     // Catch:{ Throwable -> 0x0279 }
                android.app.Application r10 = r14.f3383     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r10 = r10.getPackageName()     // Catch:{ Throwable -> 0x0279 }
                r9.append(r10)     // Catch:{ Throwable -> 0x0279 }
                r9.append(r6)     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r6 = "?devkey="
                r9.append(r6)     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r6 = r14.f3381     // Catch:{ Throwable -> 0x0279 }
                r9.append(r6)     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r6 = "&device_id="
                r9.append(r6)     // Catch:{ Throwable -> 0x0279 }
                java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ Throwable -> 0x0279 }
                android.app.Application r10 = r14.f3383     // Catch:{ Throwable -> 0x0279 }
                r6.<init>(r10)     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r6 = com.appsflyer.internal.C1347ag.m3284(r6)     // Catch:{ Throwable -> 0x0279 }
                r9.append(r6)     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r6 = r9.toString()     // Catch:{ Throwable -> 0x0279 }
                com.appsflyer.internal.am r9 = com.appsflyer.internal.C1356am.f3467     // Catch:{ Throwable -> 0x0279 }
                if (r9 != 0) goto L_0x00af
                com.appsflyer.internal.am r9 = new com.appsflyer.internal.am     // Catch:{ Throwable -> 0x0279 }
                r9.<init>()     // Catch:{ Throwable -> 0x0279 }
                com.appsflyer.internal.C1356am.f3467 = r9     // Catch:{ Throwable -> 0x0279 }
            L_0x00af:
                com.appsflyer.internal.am r9 = com.appsflyer.internal.C1356am.f3467     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r10 = "server_request"
                java.lang.String[] r11 = new java.lang.String[r8]     // Catch:{ Throwable -> 0x0279 }
                r11[r3] = r7     // Catch:{ Throwable -> 0x0279 }
                r9.mo10812(r10, r6, r11)     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r7 = "Calling server for attribution url: "
                java.lang.String r9 = java.lang.String.valueOf(r6)     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r7 = r7.concat(r9)     // Catch:{ Throwable -> 0x0279 }
                com.appsflyer.AFFacebookDeferredDeeplink.C13194.m3166(r7)     // Catch:{ Throwable -> 0x0279 }
                java.net.URL r7 = new java.net.URL     // Catch:{ Throwable -> 0x0279 }
                r7.<init>(r6)     // Catch:{ Throwable -> 0x0279 }
                java.net.URLConnection r7 = r7.openConnection()     // Catch:{ Throwable -> 0x0279 }
                java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Throwable -> 0x0279 }
                java.lang.String r2 = "GET"
                r7.setRequestMethod(r2)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r2 = 10000(0x2710, float:1.4013E-41)
                r7.setConnectTimeout(r2)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r2 = "Connection"
                java.lang.String r9 = "close"
                r7.setRequestProperty(r2, r9)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r7.connect()     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                int r2 = r7.getResponseCode()     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r9 = com.appsflyer.AppsFlyerLibCore.m3215(r7)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                com.appsflyer.internal.am r10 = com.appsflyer.internal.C1356am.f3467     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                if (r10 != 0) goto L_0x00f9
                com.appsflyer.internal.am r10 = new com.appsflyer.internal.am     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r10.<init>()     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                com.appsflyer.internal.C1356am.f3467 = r10     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
            L_0x00f9:
                com.appsflyer.internal.am r10 = com.appsflyer.internal.C1356am.f3467     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r11 = "server_response"
                r12 = 2
                java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r13 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r12[r3] = r13     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r12[r8] = r9     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r10.mo10812(r11, r6, r12)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r10 = 200(0xc8, float:2.8E-43)
                r11 = 404(0x194, float:5.66E-43)
                if (r2 == r10) goto L_0x0142
                if (r2 != r11) goto L_0x0114
                goto L_0x0142
            L_0x0114:
                com.appsflyer.AppsFlyerConversionListener r0 = com.appsflyer.AppsFlyerLibCore.f3333     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                if (r0 == 0) goto L_0x0127
                java.lang.String r0 = "Error connection to server: "
                java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r0 = r0.concat(r1)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r14.m3255(r0, r2)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
            L_0x0127:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r1 = "AttributionIdFetcher response code: "
                r0.<init>(r1)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r0.append(r2)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r1 = "  url: "
                r0.append(r1)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r0.append(r6)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                com.appsflyer.AFFacebookDeferredDeeplink.C13194.m3166(r0)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                goto L_0x0266
            L_0x0142:
                long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                android.app.Application r6 = r14.f3383     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r10 = "appsflyerGetConversionDataTiming"
                long r12 = r12 - r4
                com.appsflyer.AppsFlyerLibCore.m3191(r6, r10, r12)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r4 = "Attribution data: "
                java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r4 = r4.concat(r5)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                com.appsflyer.AFFacebookDeferredDeeplink.C13194.m3166(r4)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                int r4 = r9.length()     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                if (r4 <= 0) goto L_0x0266
                java.util.Map r4 = com.appsflyer.AppsFlyerLibCore.m3217(r9)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r5 = "iscache"
                java.lang.Object r5 = r4.get(r5)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                if (r2 != r11) goto L_0x0187
                java.lang.String r2 = "error_reason"
                r4.remove(r2)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r2 = "status_code"
                r4.remove(r2)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r2 = "af_status"
                java.lang.String r6 = "Organic"
                r4.put(r2, r6)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r2 = "af_message"
                java.lang.String r6 = "organic install"
                r4.put(r2, r6)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
            L_0x0187:
                if (r5 == 0) goto L_0x019a
                boolean r2 = r5.booleanValue()     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                if (r2 != 0) goto L_0x019a
                android.app.Application r2 = r14.f3383     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r6 = "appsflyerConversionDataCacheExpiration"
                long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                com.appsflyer.AppsFlyerLibCore.m3191(r2, r6, r10)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
            L_0x019a:
                boolean r2 = r4.containsKey(r1)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r6 = "[Invite] Detected App-Invite via channel: "
                java.lang.String r10 = "af_channel"
                if (r2 == 0) goto L_0x01cf
                boolean r2 = r4.containsKey(r10)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                if (r2 == 0) goto L_0x01be
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r2.<init>(r6)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.Object r11 = r4.get(r10)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r2.append(r11)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                goto L_0x01cf
            L_0x01be:
                java.lang.String r2 = "[CrossPromotion] App was installed via %s's Cross Promotion"
                java.lang.Object[] r11 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.Object r12 = r4.get(r1)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r11[r3] = r12     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r2 = java.lang.String.format(r2, r11)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
            L_0x01cf:
                boolean r1 = r4.containsKey(r1)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                if (r1 == 0) goto L_0x01e8
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r1.<init>(r6)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.Object r2 = r4.get(r10)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r1.append(r2)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
            L_0x01e8:
                java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r4.put(r0, r1)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r1.<init>(r4)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r2 = "attributionId"
                if (r1 == 0) goto L_0x0200
                android.app.Application r6 = r14.f3383     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                com.appsflyer.AppsFlyerLibCore.m3219(r6, r2, r1)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                goto L_0x0205
            L_0x0200:
                android.app.Application r1 = r14.f3383     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                com.appsflyer.AppsFlyerLibCore.m3219(r1, r2, r9)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
            L_0x0205:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r2 = "iscache="
                r1.<init>(r2)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r1.append(r5)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r2 = " caching conversion data"
                r1.append(r2)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                com.appsflyer.AppsFlyerConversionListener r1 = com.appsflyer.AppsFlyerLibCore.f3333     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                if (r1 == 0) goto L_0x0266
                java.util.concurrent.atomic.AtomicInteger r1 = r14.f3385     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                int r1 = r1.intValue()     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                if (r1 > r8) goto L_0x0266
                android.app.Application r1 = r14.f3383     // Catch:{ ab -> 0x0243 }
                java.util.Map r1 = com.appsflyer.AppsFlyerLibCore.m3237(r1)     // Catch:{ ab -> 0x0243 }
                android.app.Application r2 = r14.f3383     // Catch:{ ab -> 0x0243 }
                android.content.SharedPreferences r2 = com.appsflyer.AppsFlyerLibCore.m3225(r2)     // Catch:{ ab -> 0x0243 }
                java.lang.String r5 = "sixtyDayConversionData"
                boolean r2 = r2.getBoolean(r5, r3)     // Catch:{ ab -> 0x0243 }
                if (r2 != 0) goto L_0x024a
                java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ ab -> 0x0243 }
                r1.put(r0, r2)     // Catch:{ ab -> 0x0243 }
                goto L_0x024a
            L_0x0243:
                r0 = move-exception
                java.lang.String r1 = "Exception while trying to fetch attribution data. "
                com.appsflyer.AFLogger.afErrorLog(r1, r0)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r1 = r4
            L_0x024a:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r2 = "Calling onConversionDataSuccess with:\n"
                r0.<init>(r2)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r2 = r1.toString()     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r0.append(r2)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                com.appsflyer.AppsFlyerConversionListener r0 = com.appsflyer.AppsFlyerLibCore.f3333     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
                r0.onConversionDataSuccess(r1)     // Catch:{ Throwable -> 0x0273, all -> 0x0271 }
            L_0x0266:
                java.util.concurrent.atomic.AtomicInteger r0 = r14.f3385
                r0.decrementAndGet()
                if (r7 == 0) goto L_0x0298
                r7.disconnect()
                goto L_0x0298
            L_0x0271:
                r0 = move-exception
                goto L_0x029e
            L_0x0273:
                r0 = move-exception
                r2 = r7
                goto L_0x027a
            L_0x0276:
                r0 = move-exception
                r7 = r2
                goto L_0x029e
            L_0x0279:
                r0 = move-exception
            L_0x027a:
                com.appsflyer.AppsFlyerConversionListener r1 = com.appsflyer.AppsFlyerLibCore.f3333     // Catch:{ all -> 0x0276 }
                if (r1 == 0) goto L_0x0287
                java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x0276 }
                r14.m3255(r1, r3)     // Catch:{ all -> 0x0276 }
            L_0x0287:
                java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x0276 }
                com.appsflyer.AFLogger.afErrorLog(r1, r0)     // Catch:{ all -> 0x0276 }
                java.util.concurrent.atomic.AtomicInteger r0 = r14.f3385
                r0.decrementAndGet()
                if (r2 == 0) goto L_0x0298
                r2.disconnect()
            L_0x0298:
                java.util.concurrent.ScheduledExecutorService r0 = r14.f3382
                r0.shutdown()
                return
            L_0x029e:
                java.util.concurrent.atomic.AtomicInteger r1 = r14.f3385
                r1.decrementAndGet()
                if (r7 == 0) goto L_0x02a8
                r7.disconnect()
            L_0x02a8:
                throw r0
            L_0x02a9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.C1328a.run():void");
        }
    }

    /* renamed from: com.appsflyer.AppsFlyerLibCore$b */
    class C1329b implements Runnable {

        /* renamed from: ˏ */
        private final AFEvent f3386;

        /* synthetic */ C1329b(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent, byte b) {
            this(aFEvent);
        }

        private C1329b(AFEvent aFEvent) {
            aFEvent.f3295 = new WeakReference<>(aFEvent.f3291);
            aFEvent.f3291 = null;
            this.f3386 = aFEvent;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
            r6.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0113, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0114, code lost:
            r7 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0125, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0126, code lost:
            com.appsflyer.AFLogger.afErrorLog(r0.getMessage(), r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x012d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0154, code lost:
            r2.mkdir();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0159, code lost:
            r2 = r2.listFiles();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x015d, code lost:
            if (r2 == null) goto L_0x016d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x0164, code lost:
            android.util.Log.i(com.appsflyer.AppsFlyerLibCore.LOG_TAG, "reached cache limit, not caching request");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x016d, code lost:
            android.util.Log.i(com.appsflyer.AppsFlyerLibCore.LOG_TAG, "caching request...");
            r2 = new java.io.File(com.appsflyer.internal.C1396z.m3367(r4), java.lang.Long.toString(java.lang.System.currentTimeMillis()));
            r2.createNewFile();
            r3 = new java.io.OutputStreamWriter(new java.io.FileOutputStream(r2.getPath(), true));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
            r3.write("version=");
            r3.write(r1.f3314);
            r3.write(10);
            r3.write("url=");
            r3.write(r1.f3312);
            r3.write(10);
            r3.write("data=");
            r3.write(android.util.Base64.encodeToString(r1.f3313, 2));
            r3.write(10);
            r3.flush();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
            r3.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x01ca, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x01cb, code lost:
            r6 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x01cd, code lost:
            r6 = r3;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:100:0x01da A[SYNTHETIC, Splitter:B:100:0x01da] */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x01e7 A[SYNTHETIC, Splitter:B:105:0x01e7] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0125 A[ExcHandler: Throwable (r0v7 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:35:0x00c8] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0154 A[Catch:{ Exception -> 0x01d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0159 A[Catch:{ Exception -> 0x01d1 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r13 = this;
                com.appsflyer.AFEvent r0 = r13.f3386
                java.util.Map<java.lang.String, java.lang.Object> r0 = r0.f3293
                com.appsflyer.AFEvent r1 = r13.f3386
                boolean r1 = r1.f3294
                com.appsflyer.AFEvent r2 = r13.f3386
                java.lang.String r2 = r2.f3297
                com.appsflyer.AFEvent r3 = r13.f3386
                int r3 = r3.f3292
                com.appsflyer.AFEvent r4 = r13.f3386
                android.content.Context r5 = r4.f3291
                r6 = 0
                if (r5 == 0) goto L_0x001a
                android.content.Context r4 = r4.f3291
                goto L_0x0028
            L_0x001a:
                java.lang.ref.WeakReference<android.content.Context> r5 = r4.f3295
                if (r5 == 0) goto L_0x0027
                java.lang.ref.WeakReference<android.content.Context> r4 = r4.f3295
                java.lang.Object r4 = r4.get()
                android.content.Context r4 = (android.content.Context) r4
                goto L_0x0028
            L_0x0027:
                r4 = r6
            L_0x0028:
                com.appsflyer.AppsFlyerLibCore r5 = com.appsflyer.AppsFlyerLibCore.this
                boolean r5 = r5.isTrackingStopped()
                if (r5 == 0) goto L_0x0031
                return
            L_0x0031:
                r5 = 0
                byte[] r7 = new byte[r5]
                r8 = 2
                r9 = 1
                if (r1 == 0) goto L_0x00ba
                if (r3 > r8) goto L_0x00ba
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                boolean r1 = com.appsflyer.AppsFlyerLibCore.m3213(r1)
                if (r1 == 0) goto L_0x0074
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r1 = r1.f3359
                java.lang.String r3 = "rfr"
                r0.put(r3, r1)
                com.appsflyer.AFEvent r1 = r13.f3386
                android.content.Context r3 = r1.f3291
                if (r3 == 0) goto L_0x0056
                android.content.Context r1 = r1.f3291
                goto L_0x0064
            L_0x0056:
                java.lang.ref.WeakReference<android.content.Context> r3 = r1.f3295
                if (r3 == 0) goto L_0x0063
                java.lang.ref.WeakReference<android.content.Context> r1 = r1.f3295
                java.lang.Object r1 = r1.get()
                android.content.Context r1 = (android.content.Context) r1
                goto L_0x0064
            L_0x0063:
                r1 = r6
            L_0x0064:
                android.content.SharedPreferences r1 = com.appsflyer.AppsFlyerLibCore.m3225(r1)
                android.content.SharedPreferences$Editor r1 = r1.edit()
                java.lang.String r3 = "newGPReferrerSent"
                r1.putBoolean(r3, r9)
                r1.apply()
            L_0x0074:
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r1 = r1.f3349
                if (r1 == 0) goto L_0x0087
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r1 = r1.f3349
                java.lang.String r3 = "fb_ddl"
                r0.put(r3, r1)
            L_0x0087:
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                boolean r1 = com.appsflyer.AppsFlyerLibCore.m3205(r1)
                if (r1 == 0) goto L_0x009b
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r1 = r1.f3352
                java.lang.String r3 = "lvl"
                r0.put(r3, r1)
                goto L_0x00ba
            L_0x009b:
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                boolean r1 = r1.f3355
                if (r1 == 0) goto L_0x00ba
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                java.util.HashMap r3 = new java.util.HashMap
                r3.<init>()
                r1.f3352 = r3
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r1 = r1.f3352
                java.lang.String r3 = "error"
                java.lang.String r10 = "operation timed out."
                r1.put(r3, r10)
            L_0x00ba:
                com.appsflyer.AFEvent r1 = r13.f3386
                boolean r1 = r1 instanceof com.appsflyer.internal.model.event.AdRevenue
                if (r1 != 0) goto L_0x00c8
                com.appsflyer.internal.d$b r1 = new com.appsflyer.internal.d$b
                r1.<init>(r0, r4)
                r0.putAll(r1)
            L_0x00c8:
                com.appsflyer.AFEvent r1 = r13.f3386     // Catch:{ IOException -> 0x012e, Throwable -> 0x0125 }
                com.appsflyer.AFEvent r3 = r13.f3386     // Catch:{ IOException -> 0x012e, Throwable -> 0x0125 }
                boolean r3 = r3 instanceof com.appsflyer.internal.model.event.AdRevenue     // Catch:{ IOException -> 0x012e, Throwable -> 0x0125 }
                if (r3 == 0) goto L_0x00d9
                java.lang.String r3 = "af_key"
                java.lang.Object r3 = r0.get(r3)     // Catch:{ IOException -> 0x012e, Throwable -> 0x0125 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x012e, Throwable -> 0x0125 }
                goto L_0x00e1
            L_0x00d9:
                java.lang.String r3 = "appsflyerKey"
                java.lang.Object r3 = r0.get(r3)     // Catch:{ IOException -> 0x012e, Throwable -> 0x0125 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x012e, Throwable -> 0x0125 }
            L_0x00e1:
                r1.f3290 = r3     // Catch:{ IOException -> 0x012e, Throwable -> 0x0125 }
                monitor-enter(r0)     // Catch:{ IOException -> 0x012e, Throwable -> 0x0125 }
                com.appsflyer.AFEvent r1 = r13.f3386     // Catch:{ all -> 0x0122 }
                java.lang.Object[] r3 = new java.lang.Object[r9]     // Catch:{ all -> 0x0119 }
                r3[r5] = r1     // Catch:{ all -> 0x0119 }
                r1 = 48
                r10 = 24
                java.lang.Object r1 = com.appsflyer.internal.C1335a.m3268(r1, r10, r5)     // Catch:{ all -> 0x0119 }
                java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x0119 }
                java.lang.String r10 = "ˊ"
                java.lang.Class[] r11 = new java.lang.Class[r9]     // Catch:{ all -> 0x0119 }
                java.lang.Class<com.appsflyer.AFEvent> r12 = com.appsflyer.AFEvent.class
                r11[r5] = r12     // Catch:{ all -> 0x0119 }
                java.lang.reflect.Method r1 = r1.getMethod(r10, r11)     // Catch:{ all -> 0x0119 }
                java.lang.Object r1 = r1.invoke(r6, r3)     // Catch:{ all -> 0x0119 }
                byte[] r1 = (byte[]) r1     // Catch:{ all -> 0x0119 }
                monitor-exit(r0)     // Catch:{ all -> 0x0116 }
                com.appsflyer.AppsFlyerLibCore r0 = com.appsflyer.AppsFlyerLibCore.this     // Catch:{ IOException -> 0x0113, Throwable -> 0x0125 }
                com.appsflyer.AFEvent r3 = r13.f3386     // Catch:{ IOException -> 0x0113, Throwable -> 0x0125 }
                com.appsflyer.AFEvent r3 = r3.post(r1)     // Catch:{ IOException -> 0x0113, Throwable -> 0x0125 }
                com.appsflyer.AppsFlyerLibCore.m3221(r0, r3)     // Catch:{ IOException -> 0x0113, Throwable -> 0x0125 }
                return
            L_0x0113:
                r0 = move-exception
                r7 = r1
                goto L_0x012f
            L_0x0116:
                r3 = move-exception
                r7 = r1
                goto L_0x0123
            L_0x0119:
                r1 = move-exception
                java.lang.Throwable r3 = r1.getCause()     // Catch:{ all -> 0x0122 }
                if (r3 == 0) goto L_0x0121
                throw r3     // Catch:{ all -> 0x0122 }
            L_0x0121:
                throw r1     // Catch:{ all -> 0x0122 }
            L_0x0122:
                r3 = move-exception
            L_0x0123:
                monitor-exit(r0)     // Catch:{ IOException -> 0x012e, Throwable -> 0x0125 }
                throw r3     // Catch:{ IOException -> 0x012e, Throwable -> 0x0125 }
            L_0x0125:
                r0 = move-exception
                java.lang.String r1 = r0.getMessage()
                com.appsflyer.AFLogger.afErrorLog(r1, r0)
                return
            L_0x012e:
                r0 = move-exception
            L_0x012f:
                java.lang.String r1 = "Exception while sending request to server. "
                com.appsflyer.AFLogger.afErrorLog(r1, r0)
                if (r7 == 0) goto L_0x01eb
                if (r4 == 0) goto L_0x01eb
                java.lang.String r1 = "&isCachedRequest=true&timeincache="
                boolean r1 = r2.contains(r1)
                if (r1 != 0) goto L_0x01eb
                com.appsflyer.internal.C1396z.m3366()
                com.appsflyer.AFFacebookDeferredDeeplink r1 = new com.appsflyer.AFFacebookDeferredDeeplink
                java.lang.String r3 = "5.1.1"
                r1.<init>(r2, r7, r3)
                java.io.File r2 = com.appsflyer.internal.C1396z.m3367(r4)     // Catch:{ Exception -> 0x01d1 }
                boolean r3 = r2.exists()     // Catch:{ Exception -> 0x01d1 }
                if (r3 != 0) goto L_0x0159
                r2.mkdir()     // Catch:{ Exception -> 0x01d1 }
                goto L_0x01dd
            L_0x0159:
                java.io.File[] r2 = r2.listFiles()     // Catch:{ Exception -> 0x01d1 }
                if (r2 == 0) goto L_0x016d
                int r2 = r2.length     // Catch:{ Exception -> 0x01d1 }
                r3 = 40
                if (r2 <= r3) goto L_0x016d
                java.lang.String r1 = "AppsFlyer_5.1.1"
                java.lang.String r2 = "reached cache limit, not caching request"
                android.util.Log.i(r1, r2)     // Catch:{ Exception -> 0x01d1 }
                goto L_0x01dd
            L_0x016d:
                java.lang.String r2 = "AppsFlyer_5.1.1"
                java.lang.String r3 = "caching request..."
                android.util.Log.i(r2, r3)     // Catch:{ Exception -> 0x01d1 }
                java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x01d1 }
                java.io.File r3 = com.appsflyer.internal.C1396z.m3367(r4)     // Catch:{ Exception -> 0x01d1 }
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01d1 }
                java.lang.String r4 = java.lang.Long.toString(r4)     // Catch:{ Exception -> 0x01d1 }
                r2.<init>(r3, r4)     // Catch:{ Exception -> 0x01d1 }
                r2.createNewFile()     // Catch:{ Exception -> 0x01d1 }
                java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x01d1 }
                java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x01d1 }
                java.lang.String r2 = r2.getPath()     // Catch:{ Exception -> 0x01d1 }
                r4.<init>(r2, r9)     // Catch:{ Exception -> 0x01d1 }
                r3.<init>(r4)     // Catch:{ Exception -> 0x01d1 }
                java.lang.String r2 = "version="
                r3.write(r2)     // Catch:{ Exception -> 0x01cd, all -> 0x01ca }
                java.lang.String r2 = r1.f3314     // Catch:{ Exception -> 0x01cd, all -> 0x01ca }
                r3.write(r2)     // Catch:{ Exception -> 0x01cd, all -> 0x01ca }
                r2 = 10
                r3.write(r2)     // Catch:{ Exception -> 0x01cd, all -> 0x01ca }
                java.lang.String r4 = "url="
                r3.write(r4)     // Catch:{ Exception -> 0x01cd, all -> 0x01ca }
                java.lang.String r4 = r1.f3312     // Catch:{ Exception -> 0x01cd, all -> 0x01ca }
                r3.write(r4)     // Catch:{ Exception -> 0x01cd, all -> 0x01ca }
                r3.write(r2)     // Catch:{ Exception -> 0x01cd, all -> 0x01ca }
                java.lang.String r4 = "data="
                r3.write(r4)     // Catch:{ Exception -> 0x01cd, all -> 0x01ca }
                byte[] r1 = r1.f3313     // Catch:{ Exception -> 0x01cd, all -> 0x01ca }
                java.lang.String r1 = android.util.Base64.encodeToString(r1, r8)     // Catch:{ Exception -> 0x01cd, all -> 0x01ca }
                r3.write(r1)     // Catch:{ Exception -> 0x01cd, all -> 0x01ca }
                r3.write(r2)     // Catch:{ Exception -> 0x01cd, all -> 0x01ca }
                r3.flush()     // Catch:{ Exception -> 0x01cd, all -> 0x01ca }
                r3.close()     // Catch:{ IOException -> 0x01dd }
                goto L_0x01dd
            L_0x01ca:
                r0 = move-exception
                r6 = r3
                goto L_0x01e5
            L_0x01cd:
                r6 = r3
                goto L_0x01d1
            L_0x01cf:
                r0 = move-exception
                goto L_0x01e5
            L_0x01d1:
                java.lang.String r1 = "AppsFlyer_5.1.1"
                java.lang.String r2 = "Could not cache request"
                android.util.Log.i(r1, r2)     // Catch:{ all -> 0x01cf }
                if (r6 == 0) goto L_0x01dd
                r6.close()     // Catch:{ IOException -> 0x01dd }
            L_0x01dd:
                java.lang.String r1 = r0.getMessage()
                com.appsflyer.AFLogger.afErrorLog(r1, r0)
                goto L_0x01eb
            L_0x01e5:
                if (r6 == 0) goto L_0x01ea
                r6.close()     // Catch:{ IOException -> 0x01ea }
            L_0x01ea:
                throw r0
            L_0x01eb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.C1329b.run():void");
        }
    }

    /* renamed from: com.appsflyer.AppsFlyerLibCore$c */
    class C1330c implements Runnable {

        /* renamed from: ˏ */
        private WeakReference<Context> f3389 = null;

        public C1330c(Context context) {
            this.f3389 = new WeakReference<>(context);
        }

        public final void run() {
            if (!AppsFlyerLibCore.this.f3358) {
                AppsFlyerLibCore.this.f3351 = System.currentTimeMillis();
                if (this.f3389 != null) {
                    AppsFlyerLibCore.this.f3358 = true;
                    try {
                        String r1 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
                        synchronized (this.f3389) {
                            C1396z.m3366();
                            for (AFFacebookDeferredDeeplink aFFacebookDeferredDeeplink : C1396z.m3370((Context) this.f3389.get())) {
                                StringBuilder sb = new StringBuilder("resending request: ");
                                sb.append(aFFacebookDeferredDeeplink.f3312);
                                AFLogger.afInfoLog(sb.toString());
                                try {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long parseLong = Long.parseLong(aFFacebookDeferredDeeplink.f3311, 10);
                                    AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.this;
                                    CachedEvent cachedEvent = new CachedEvent();
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(aFFacebookDeferredDeeplink.f3312);
                                    sb2.append("&isCachedRequest=true&timeincache=");
                                    sb2.append((currentTimeMillis - parseLong) / 1000);
                                    AFEvent post = cachedEvent.urlString(sb2.toString()).post(aFFacebookDeferredDeeplink.f3313);
                                    post.f3290 = r1;
                                    post.f3295 = this.f3389;
                                    AFEvent cacheKey = post.cacheKey(aFFacebookDeferredDeeplink.f3311);
                                    cacheKey.f3294 = false;
                                    AppsFlyerLibCore.m3221(appsFlyerLibCore, cacheKey);
                                } catch (Exception e) {
                                    AFLogger.afErrorLog("Failed to resend cached request", e);
                                }
                            }
                        }
                    } catch (Exception e2) {
                        try {
                            AFLogger.afErrorLog("failed to check cache. ", e2);
                        } catch (Throwable th) {
                            AppsFlyerLibCore.this.f3358 = false;
                            throw th;
                        }
                    }
                    AppsFlyerLibCore.this.f3358 = false;
                    AppsFlyerLibCore.this.f3338.shutdown();
                    AppsFlyerLibCore.this.f3338 = null;
                }
            }
        }
    }

    /* renamed from: com.appsflyer.AppsFlyerLibCore$d */
    class C1331d implements Runnable {

        /* renamed from: ˋ */
        private AFEvent f3391;

        /* synthetic */ C1331d(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent, byte b) {
            this(aFEvent);
        }

        private C1331d(AFEvent aFEvent) {
            this.f3391 = aFEvent;
        }

        public final void run() {
            AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.this;
            AFEvent aFEvent = this.f3391;
            aFEvent.f3291 = (Context) aFEvent.f3295.get();
            appsFlyerLibCore.m3220(aFEvent);
        }
    }

    @VisibleForTesting
    AppsFlyerLibCore() {
        AFVersionDeclaration.init();
    }

    public static AppsFlyerLibCore getInstance() {
        return f3330;
    }

    /* renamed from: ˏ */
    private static void m3218(Context context, String str) {
        Intent intent = new Intent("com.appsflyer.testIntgrationBroadcast");
        intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, str);
        if (VERSION.SDK_INT >= 26) {
            String str2 = "com.appsflyer.referrerSender";
            if (context.getPackageManager().queryBroadcastReceivers(intent, 0).toString().contains(str2)) {
                Intent intent2 = new Intent(intent);
                intent2.setComponent(new ComponentName(str2, "com.appsflyer.referrerSender.Receiver"));
                context.sendBroadcast(intent2);
            }
            return;
        }
        context.sendBroadcast(intent);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ */
    public final void mo10733(Context context, Intent intent) {
        String str = "appsflyer_preinstall";
        if (intent.getStringExtra(str) != null) {
            getInstance();
            String stringExtra = intent.getStringExtra(str);
            try {
                if (new JSONObject(stringExtra).has(Constants.URL_MEDIA_SOURCE)) {
                    AppsFlyerProperties.getInstance().set("preInstallName", stringExtra);
                } else {
                    AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
                }
            } catch (JSONException e) {
                AFLogger.afErrorLog("Error parsing JSON for preinstall", e);
            }
        }
        AFLogger.afInfoLog("****** onReceive called *******");
        AppsFlyerProperties.getInstance().setOnReceiveCalled();
        String str2 = TapjoyConstants.TJC_REFERRER;
        String stringExtra2 = intent.getStringExtra(str2);
        AFLogger.afInfoLog("Play store referrer: ".concat(String.valueOf(stringExtra2)));
        if (stringExtra2 != null) {
            String str3 = "appsflyer-data";
            if ("AppsFlyer_Test".equals(intent.getStringExtra("TestIntegrationMode"))) {
                Editor edit = context.getApplicationContext().getSharedPreferences(str3, 0).edit();
                edit.clear();
                edit.apply();
                AppsFlyerProperties.getInstance().setFirstLaunchCalled(false);
                AFLogger.afInfoLog("Test mode started..");
                this.f3339 = System.currentTimeMillis();
            }
            Editor edit2 = context.getApplicationContext().getSharedPreferences(str3, 0).edit();
            edit2.putString(str2, stringExtra2);
            edit2.apply();
            AppsFlyerProperties.getInstance().setReferrer(stringExtra2);
            if (AppsFlyerProperties.getInstance().isFirstLaunchCalled()) {
                AFLogger.afInfoLog("onReceive: isLaunchCalled");
                if (stringExtra2 != null && stringExtra2.length() > 5) {
                    ScheduledThreadPoolExecutor r0 = AFExecutor.getInstance().mo10646();
                    AFEvent r8 = new BackgroundReferrerLaunch().context(context).mo10644();
                    r8.f3295 = new WeakReference<>(r8.f3291);
                    r8.f3291 = null;
                    r8.f3298 = stringExtra2;
                    r8.f3299 = intent;
                    m3195(r0, new C1331d(this, r8, 0), 5, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    /* renamed from: ॱ */
    private static void m3235(JSONObject jSONObject) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator keys = jSONObject.keys();
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get((String) keys.next()));
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(Long.valueOf(jSONArray.getLong(i)));
                }
            } catch (JSONException unused) {
            }
        }
        Collections.sort(arrayList);
        Iterator keys2 = jSONObject.keys();
        loop2:
        while (true) {
            str = null;
            while (keys2.hasNext() && str == null) {
                String str2 = (String) keys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(str2));
                    String str3 = str;
                    int i2 = 0;
                    while (i2 < jSONArray2.length()) {
                        try {
                            if (jSONArray2.getLong(i2) != ((Long) arrayList.get(0)).longValue() && jSONArray2.getLong(i2) != ((Long) arrayList.get(1)).longValue() && jSONArray2.getLong(i2) != ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                                i2++;
                                str3 = str2;
                            }
                        } catch (JSONException unused2) {
                        }
                    }
                    str = str3;
                } catch (JSONException unused3) {
                }
            }
        }
        if (str != null) {
            jSONObject.remove(str);
        }
    }

    /* renamed from: ˊ */
    static void m3190(Context context, String str) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        String str2 = "extraReferrers";
        String str3 = "appsflyer-data";
        AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String string = context.getApplicationContext().getSharedPreferences(str3, 0).getString(str2, null);
            if (string == null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                jSONObject = jSONObject2;
                jSONArray = jSONArray2;
            } else {
                jSONObject = new JSONObject(string);
                if (jSONObject.has(str)) {
                    jSONArray = new JSONArray((String) jSONObject.get(str));
                } else {
                    jSONArray = new JSONArray();
                }
            }
            if (((long) jSONArray.length()) < 5) {
                jSONArray.put(currentTimeMillis);
            }
            if (((long) jSONObject.length()) >= 4) {
                m3235(jSONObject);
            }
            jSONObject.put(str, jSONArray.toString());
            String jSONObject3 = jSONObject.toString();
            Editor edit = context.getApplicationContext().getSharedPreferences(str3, 0).edit();
            edit.putString(str2, jSONObject3);
            edit.apply();
        } catch (JSONException unused) {
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Couldn't save referrer - ");
            sb.append(str);
            sb.append(": ");
            AFLogger.afErrorLog(sb.toString(), th);
        }
    }

    public void stopTracking(boolean z, Context context) {
        File[] listFiles;
        String str = LOG_TAG;
        this.f3346 = z;
        C1396z.m3366();
        try {
            File r1 = C1396z.m3367(context);
            if (!r1.exists()) {
                r1.mkdir();
            } else {
                for (File file : r1.listFiles()) {
                    StringBuilder sb = new StringBuilder("Found cached request");
                    sb.append(file.getName());
                    Log.i(str, sb.toString());
                    C1396z.m3368(C1396z.m3369(file).f3311, context);
                }
            }
        } catch (Exception unused) {
            Log.i(str, "Could not cache request");
        }
        if (this.f3346) {
            Editor edit = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).edit();
            edit.putBoolean(IS_STOP_TRACKING_USED, true);
            edit.apply();
        }
    }

    public void onPause(Context context) {
        C13675.m3335(context);
        C1388w r2 = C1388w.m3355(context);
        r2.f3612.post(r2.f3620);
    }

    public void updateServerUninstallToken(Context context, String str) {
        C13773.m3342(context, str);
    }

    public AppsFlyerLib enableLocationCollection(boolean z) {
        this.f3337 = z;
        return this;
    }

    /* renamed from: ˋ */
    public static String m3200(String str) {
        return AppsFlyerProperties.getInstance().getString(str);
    }

    public void waitForCustomerUserId(boolean z) {
        AFLogger.afInfoLog("initAfterCustomerUserID: ".concat(String.valueOf(z)), true);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z);
    }

    public String getOutOfStore(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            return string;
        }
        String r3 = m3210(new WeakReference<>(context), "AF_STORE");
        if (r3 != null) {
            return r3;
        }
        AFLogger.afInfoLog("No out-of-store value set");
        return null;
    }

    public void setOutOfStore(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            AppsFlyerProperties.getInstance().set("api_store_value", lowerCase);
            AFLogger.afInfoLog("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
            return;
        }
        AFLogger.m3177("Cannot set setOutOfStore with null");
    }

    public void sendDeepLinkData(Activity activity) {
        String str = "public_api_call";
        String str2 = "sendDeepLinkData";
        if (activity != null && activity.getIntent() != null) {
            if (C1356am.f3467 == null) {
                C1356am.f3467 = new C1356am();
            }
            C1356am amVar = C1356am.f3467;
            StringBuilder sb = new StringBuilder("activity_intent_");
            sb.append(activity.getIntent().toString());
            amVar.mo10812(str, str2, activity.getLocalClassName(), sb.toString());
        } else if (activity != null) {
            if (C1356am.f3467 == null) {
                C1356am.f3467 = new C1356am();
            }
            C1356am.f3467.mo10812(str, str2, activity.getLocalClassName(), "activity_intent_null");
        } else {
            if (C1356am.f3467 == null) {
                C1356am.f3467 = new C1356am();
            }
            C1356am.f3467.mo10812(str, str2, "activity_null");
        }
        try {
            m3232(new Launch().context(activity.getApplication()));
            StringBuilder sb2 = new StringBuilder("getDeepLinkData with activity ");
            sb2.append(activity.getIntent().getDataString());
            AFLogger.afInfoLog(sb2.toString());
        } catch (Exception e) {
            AFLogger.afInfoLog("getDeepLinkData Exception: ".concat(String.valueOf(e)));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0194  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendPushNotificationData(android.app.Activity r19) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            java.lang.String r0 = "c"
            java.lang.String r3 = "pid"
            r4 = 2
            java.lang.String r5 = "public_api_call"
            r6 = 0
            r7 = 1
            java.lang.String r8 = "sendPushNotificationData"
            if (r2 == 0) goto L_0x0048
            android.content.Intent r9 = r19.getIntent()
            if (r9 == 0) goto L_0x0048
            com.appsflyer.internal.am r9 = com.appsflyer.internal.C1356am.f3467
            if (r9 != 0) goto L_0x0022
            com.appsflyer.internal.am r9 = new com.appsflyer.internal.am
            r9.<init>()
            com.appsflyer.internal.C1356am.f3467 = r9
        L_0x0022:
            com.appsflyer.internal.am r9 = com.appsflyer.internal.C1356am.f3467
            java.lang.String[] r10 = new java.lang.String[r4]
            java.lang.String r11 = r19.getLocalClassName()
            r10[r6] = r11
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r11 = "activity_intent_"
            r6.<init>(r11)
            android.content.Intent r11 = r19.getIntent()
            java.lang.String r11 = r11.toString()
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            r10[r7] = r6
            r9.mo10812(r5, r8, r10)
            goto L_0x007d
        L_0x0048:
            if (r2 == 0) goto L_0x0067
            com.appsflyer.internal.am r9 = com.appsflyer.internal.C1356am.f3467
            if (r9 != 0) goto L_0x0055
            com.appsflyer.internal.am r9 = new com.appsflyer.internal.am
            r9.<init>()
            com.appsflyer.internal.C1356am.f3467 = r9
        L_0x0055:
            com.appsflyer.internal.am r9 = com.appsflyer.internal.C1356am.f3467
            java.lang.String[] r10 = new java.lang.String[r4]
            java.lang.String r11 = r19.getLocalClassName()
            r10[r6] = r11
            java.lang.String r6 = "activity_intent_null"
            r10[r7] = r6
            r9.mo10812(r5, r8, r10)
            goto L_0x007d
        L_0x0067:
            com.appsflyer.internal.am r9 = com.appsflyer.internal.C1356am.f3467
            if (r9 != 0) goto L_0x0072
            com.appsflyer.internal.am r9 = new com.appsflyer.internal.am
            r9.<init>()
            com.appsflyer.internal.C1356am.f3467 = r9
        L_0x0072:
            com.appsflyer.internal.am r9 = com.appsflyer.internal.C1356am.f3467
            java.lang.String[] r7 = new java.lang.String[r7]
            java.lang.String r10 = "activity_null"
            r7[r6] = r10
            r9.mo10812(r5, r8, r7)
        L_0x007d:
            boolean r5 = r2 instanceof android.app.Activity
            if (r5 == 0) goto L_0x00b0
            r5 = r2
            android.app.Activity r5 = (android.app.Activity) r5
            android.content.Intent r7 = r5.getIntent()
            if (r7 == 0) goto L_0x00b0
            android.os.Bundle r8 = r7.getExtras()
            if (r8 == 0) goto L_0x00b0
            java.lang.String r9 = "af"
            java.lang.String r10 = r8.getString(r9)
            if (r10 == 0) goto L_0x00b1
            java.lang.String r11 = java.lang.String.valueOf(r10)
            java.lang.String r12 = "Push Notification received af payload = "
            java.lang.String r11 = r12.concat(r11)
            com.appsflyer.AFLogger.afInfoLog(r11)
            r8.remove(r9)
            android.content.Intent r7 = r7.putExtras(r8)
            r5.setIntent(r7)
            goto L_0x00b1
        L_0x00b0:
            r10 = 0
        L_0x00b1:
            r1.f3342 = r10
            java.lang.String r5 = r1.f3342
            if (r5 == 0) goto L_0x01cc
            long r7 = java.lang.System.currentTimeMillis()
            java.util.Map<java.lang.Long, java.lang.String> r5 = r1.f3343
            java.lang.String r9 = ")"
            if (r5 != 0) goto L_0x00d0
            java.lang.String r0 = "pushes: initializing pushes history.."
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r1.f3343 = r0
            r12 = r7
            goto L_0x0181
        L_0x00d0:
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0166 }
            java.lang.String r10 = "pushPayloadMaxAging"
            r11 = 1800000(0x1b7740, double:8.89318E-318)
            long r10 = r5.getLong(r10, r11)     // Catch:{ Throwable -> 0x0166 }
            java.util.Map<java.lang.Long, java.lang.String> r5 = r1.f3343     // Catch:{ Throwable -> 0x0166 }
            java.util.Set r5 = r5.keySet()     // Catch:{ Throwable -> 0x0166 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Throwable -> 0x0166 }
            r12 = r7
        L_0x00e8:
            boolean r14 = r5.hasNext()     // Catch:{ Throwable -> 0x0164 }
            if (r14 == 0) goto L_0x0181
            java.lang.Object r14 = r5.next()     // Catch:{ Throwable -> 0x0164 }
            java.lang.Long r14 = (java.lang.Long) r14     // Catch:{ Throwable -> 0x0164 }
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0164 }
            java.lang.String r4 = r1.f3342     // Catch:{ Throwable -> 0x0164 }
            r15.<init>(r4)     // Catch:{ Throwable -> 0x0164 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0164 }
            java.util.Map<java.lang.Long, java.lang.String> r6 = r1.f3343     // Catch:{ Throwable -> 0x0164 }
            java.lang.Object r6 = r6.get(r14)     // Catch:{ Throwable -> 0x0164 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Throwable -> 0x0164 }
            r4.<init>(r6)     // Catch:{ Throwable -> 0x0164 }
            java.lang.Object r6 = r15.get(r3)     // Catch:{ Throwable -> 0x0164 }
            java.lang.Object r2 = r4.get(r3)     // Catch:{ Throwable -> 0x0164 }
            boolean r2 = r6.equals(r2)     // Catch:{ Throwable -> 0x0164 }
            if (r2 == 0) goto L_0x0144
            java.lang.Object r2 = r15.get(r0)     // Catch:{ Throwable -> 0x0164 }
            java.lang.Object r6 = r4.get(r0)     // Catch:{ Throwable -> 0x0164 }
            boolean r2 = r2.equals(r6)     // Catch:{ Throwable -> 0x0164 }
            if (r2 == 0) goto L_0x0144
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0164 }
            java.lang.String r2 = "PushNotificationMeasurement: A previous payload with same PID and campaign was already acknowledged! (old: "
            r0.<init>(r2)     // Catch:{ Throwable -> 0x0164 }
            r0.append(r4)     // Catch:{ Throwable -> 0x0164 }
            java.lang.String r2 = ", new: "
            r0.append(r2)     // Catch:{ Throwable -> 0x0164 }
            r0.append(r15)     // Catch:{ Throwable -> 0x0164 }
            r0.append(r9)     // Catch:{ Throwable -> 0x0164 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0164 }
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ Throwable -> 0x0164 }
            r2 = 0
            r1.f3342 = r2     // Catch:{ Throwable -> 0x0164 }
            return
        L_0x0144:
            r2 = 0
            long r16 = r14.longValue()     // Catch:{ Throwable -> 0x0164 }
            long r16 = r7 - r16
            int r4 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x0154
            java.util.Map<java.lang.Long, java.lang.String> r4 = r1.f3343     // Catch:{ Throwable -> 0x0164 }
            r4.remove(r14)     // Catch:{ Throwable -> 0x0164 }
        L_0x0154:
            long r16 = r14.longValue()     // Catch:{ Throwable -> 0x0164 }
            int r4 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
            if (r4 > 0) goto L_0x0160
            long r12 = r14.longValue()     // Catch:{ Throwable -> 0x0164 }
        L_0x0160:
            r2 = r19
            r4 = 2
            goto L_0x00e8
        L_0x0164:
            r0 = move-exception
            goto L_0x0168
        L_0x0166:
            r0 = move-exception
            r12 = r7
        L_0x0168:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Error while handling push notification measurement: "
            r2.<init>(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.appsflyer.AFLogger.afErrorLog(r2, r0)
        L_0x0181:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "pushPayloadHistorySize"
            r3 = 2
            int r0 = r0.getInt(r2, r3)
            java.util.Map<java.lang.Long, java.lang.String> r2 = r1.f3343
            int r2 = r2.size()
            if (r2 != r0) goto L_0x01b1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "pushes: removing oldest overflowing push (oldest push:"
            r0.<init>(r2)
            r0.append(r12)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.f3343
            java.lang.Long r2 = java.lang.Long.valueOf(r12)
            r0.remove(r2)
        L_0x01b1:
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.f3343
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            java.lang.String r3 = r1.f3342
            r0.put(r2, r3)
            android.app.Application r0 = r19.getApplication()
            com.appsflyer.internal.model.event.Launch r2 = new com.appsflyer.internal.model.event.Launch
            r2.<init>()
            com.appsflyer.AFEvent r0 = r2.context(r0)
            r1.m3232(r0)
        L_0x01cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.sendPushNotificationData(android.app.Activity):void");
    }

    public void setUserEmails(EmailsCryptType emailsCryptType, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        C1356am.f3467.mo10812("public_api_call", "setUserEmails", (String[]) arrayList.toArray(new String[(strArr.length + 1)]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        String str = null;
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : strArr) {
            if (C132110.f3366[emailsCryptType.ordinal()] != 2) {
                arrayList2.add(C1346af.m3279(str2));
                str = "sha256_el_arr";
            } else {
                arrayList2.add(str2);
                str = "plain_el_arr";
            }
        }
        hashMap.put(str, arrayList2);
        AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(hashMap).toString());
    }

    public void setResolveDeepLinkURLs(String... strArr) {
        AFLogger.afDebugLog(String.format("setResolveDeepLinkURLs %s", new Object[]{Arrays.toString(strArr)}));
        C1366f.f3550 = strArr;
    }

    public void setOneLinkCustomDomain(String... strArr) {
        AFLogger.afDebugLog(String.format("setOneLinkCustomDomain %s", new Object[]{Arrays.toString(strArr)}));
        C1366f.f3546 = strArr;
    }

    public AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener, Context context) {
        if (context != null) {
            this.f3348 = (Application) context.getApplicationContext();
            if (m3197(context)) {
                if (this.f3363 == null) {
                    this.f3363 = new C1372j();
                    this.f3363.mo10833(context, new C1373m() {
                        /* renamed from: ˏ */
                        public final void mo10735(Map<String, Object> map) {
                            AppsFlyerLibCore.this.f3359 = map;
                            AppsFlyerLibCore.m3204(AppsFlyerLibCore.this, (Map) map);
                        }
                    });
                } else {
                    AFLogger.afWarnLog("AFInstallReferrer instance already created");
                }
            }
            this.f3355 = m3224(context);
        } else {
            AFLogger.afWarnLog("init :: context is null, Google Install Referrer will be not initialized!");
        }
        return init(str, appsFlyerConversionListener);
    }

    /* renamed from: ˏ */
    private boolean m3224(Context context) {
        String str = "com.appsflyer.lvl.AppsFlyerLVL";
        try {
            Class.forName(str);
            final long currentTimeMillis = System.currentTimeMillis();
            this.f3352 = new ConcurrentHashMap();
            C13244 r4 = new C1378c() {
                /* renamed from: ॱ */
                public final void mo10737(@NonNull String str, @NonNull String str2) {
                    AppsFlyerLibCore.this.f3352.put("signedData", str);
                    AppsFlyerLibCore.this.f3352.put(InAppPurchaseMetaData.KEY_SIGNATURE, str2);
                    String str3 = "ttr";
                    AppsFlyerLibCore.this.f3352.put(str3, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AFLogger.afInfoLog("Successfully retrieved Google LVL data.");
                }

                /* renamed from: ॱ */
                public final void mo10736(String str, Exception exc) {
                    String message = exc.getMessage();
                    if (message == null) {
                        message = "unknown";
                    }
                    AppsFlyerLibCore.this.f3352.put("error", message);
                    AFLogger.afErrorLog(str, exc, true);
                }
            };
            try {
                Class cls = Class.forName(str);
                Class cls2 = Class.forName("com.appsflyer.lvl.AppsFlyerLVL$resultListener");
                Method method = cls.getMethod("checkLicense", new Class[]{Long.TYPE, Context.class, cls2});
                C13773 r7 = new C13773(r4);
                method.invoke(null, new Object[]{Long.valueOf(currentTimeMillis), context, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, r7)});
            } catch (ClassNotFoundException e) {
                r4.mo10736(e.getClass().getSimpleName(), (Exception) e);
            } catch (NoSuchMethodException e2) {
                r4.mo10736(e2.getClass().getSimpleName(), (Exception) e2);
            } catch (IllegalAccessException e3) {
                r4.mo10736(e3.getClass().getSimpleName(), (Exception) e3);
            } catch (InvocationTargetException e4) {
                r4.mo10736(e4.getClass().getSimpleName(), (Exception) e4);
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void enableFacebookDeferredApplinks(boolean z) {
        this.f3350 = z;
    }

    public void startTracking(Application application) {
        if (!this.f3341) {
            AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! The API call 'startTracking(Application)' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
        } else {
            startTracking(application, null);
        }
    }

    public void startTracking(Application application, String str) {
        startTracking(application, str, null);
    }

    public void startTracking(Application application, String str, AppsFlyerTrackingRequestListener appsFlyerTrackingRequestListener) {
        Application application2 = application;
        String str2 = str;
        this.f3348 = application2;
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str3 = "public_api_call";
        C1356am.f3467.mo10812(str3, "startTracking", str2);
        AFLogger.afInfoLog(String.format("Starting AppsFlyer Tracking: (v%s.%s)", new Object[]{BuildConfig.VERSION_NAME, f3329}));
        StringBuilder sb = new StringBuilder("Build Number: ");
        sb.append(f3329);
        AFLogger.afInfoLog(sb.toString());
        AppsFlyerProperties.getInstance().loadProperties(application.getApplicationContext());
        boolean isEmpty = TextUtils.isEmpty(str);
        String str4 = AppsFlyerProperties.AF_KEY;
        if (!isEmpty) {
            AppsFlyerProperties.getInstance().set(str4, str2);
            C13194.m3167(str);
        } else if (TextUtils.isEmpty(AppsFlyerProperties.getInstance().getString(str4))) {
            AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the startTracking API method (should be called on Activity's onCreate).");
            return;
        }
        Context baseContext = application.getBaseContext();
        try {
            if ((baseContext.getPackageManager().getPackageInfo(baseContext.getPackageName(), 0).applicationInfo.flags & 32768) != 0) {
                if (baseContext.getResources().getIdentifier("appsflyer_backup_rules", "xml", baseContext.getPackageName()) != 0) {
                    AFLogger.afInfoLog("appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", true);
                } else {
                    AFLogger.m3177("'allowBackup' is set to true; appsflyer_backup_rules.xml not detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules");
                }
            }
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder("checkBackupRules Exception: ");
            sb2.append(e.toString());
            AFLogger.afRDLog(sb2.toString());
        }
        if (this.f3350) {
            Context applicationContext = application.getApplicationContext();
            this.f3349 = new HashMap();
            final long currentTimeMillis = System.currentTimeMillis();
            C13201 r9 = new AppLinkFetchEvents() {
                public final void onAppLinkFetchFinished(String str, String str2, String str3) {
                    String str4 = "link";
                    if (str != null) {
                        AFLogger.afInfoLog("Facebook Deferred AppLink data received: ".concat(String.valueOf(str)));
                        AppsFlyerLibCore.this.f3349.put(str4, str);
                        if (str2 != null) {
                            AppsFlyerLibCore.this.f3349.put("target_url", str2);
                        }
                        if (str3 != null) {
                            HashMap hashMap = new HashMap();
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put(ShareConstants.PROMO_CODE, str3);
                            hashMap.put(ShareConstants.DEEPLINK_CONTEXT, hashMap2);
                            AppsFlyerLibCore.this.f3349.put("extras", hashMap);
                        }
                    } else {
                        AppsFlyerLibCore.this.f3349.put(str4, "");
                    }
                    AppsFlyerLibCore.this.f3349.put("ttr", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }

                public final void onAppLinkFetchFailed(String str) {
                    AppsFlyerLibCore.this.f3349.put("error", str);
                }
            };
            try {
                Class.forName("com.facebook.FacebookSdk").getMethod("sdkInitialize", new Class[]{Context.class}).invoke(null, new Object[]{applicationContext});
                Class cls = Class.forName("com.facebook.applinks.AppLinkData");
                Class cls2 = Class.forName("com.facebook.applinks.AppLinkData$CompletionHandler");
                Method method = cls.getMethod("fetchDeferredAppLinkData", new Class[]{Context.class, String.class, cls2});
                C13194 r13 = new C13194(cls, r9);
                Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, r13);
                String string = applicationContext.getString(applicationContext.getResources().getIdentifier("facebook_app_id", "string", applicationContext.getPackageName()));
                if (TextUtils.isEmpty(string)) {
                    r9.onAppLinkFetchFailed("Facebook app id not defined in resources");
                } else {
                    method.invoke(null, new Object[]{applicationContext, string, newProxyInstance});
                }
            } catch (NoSuchMethodException e2) {
                r9.onAppLinkFetchFailed(e2.toString());
            } catch (InvocationTargetException e3) {
                r9.onAppLinkFetchFailed(e3.toString());
            } catch (ClassNotFoundException e4) {
                r9.onAppLinkFetchFailed(e4.toString());
            } catch (IllegalAccessException e5) {
                r9.onAppLinkFetchFailed(e5.toString());
            }
        }
        AFEvent context = new Launch().context(application2);
        context.f3290 = str2;
        context.f3296 = appsFlyerTrackingRequestListener;
        m3232(context);
    }

    public void setPhoneNumber(String str) {
        this.f3354 = C1346af.m3279(str);
    }

    public void trackAppLaunch(Context context, String str) {
        if (m3197(context)) {
            if (this.f3363 == null) {
                this.f3363 = new C1372j();
                this.f3363.mo10833(context, new C1373m() {
                    /* renamed from: ˏ */
                    public final void mo10735(Map<String, Object> map) {
                        AppsFlyerLibCore.this.f3359 = map;
                        AppsFlyerLibCore.m3204(AppsFlyerLibCore.this, (Map) map);
                    }
                });
            } else {
                AFLogger.afWarnLog("AFInstallReferrer instance already created");
            }
        }
        m3231(context, str, "", null);
    }

    /* access modifiers changed from: protected */
    public void setDeepLinkData(Intent intent) {
        if (intent != null) {
            try {
                if ("android.intent.action.VIEW".equals(intent.getAction())) {
                    this.latestDeepLink = intent.getData();
                    StringBuilder sb = new StringBuilder("Unity setDeepLinkData = ");
                    sb.append(this.latestDeepLink);
                    AFLogger.afDebugLog(sb.toString());
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog("Exception while setting deeplink data (unity). ", th);
            }
        }
    }

    public void setPluginDeepLinkData(Intent intent) {
        setDeepLinkData(intent);
    }

    public void trackEvent(Context context, String str, Map<String, Object> map, AppsFlyerTrackingRequestListener appsFlyerTrackingRequestListener) {
        JSONObject jSONObject = new JSONObject(map == null ? new HashMap<>() : map);
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        C1356am.f3467.mo10812("public_api_call", "trackEvent", str, jSONObject.toString());
        if (str != null) {
            C1388w r0 = C1388w.m3355(context);
            long currentTimeMillis = System.currentTimeMillis();
            if (r0.f3614 != 0) {
                r0.f3615++;
                if (r0.f3614 - currentTimeMillis < 500) {
                    r0.f3612.removeCallbacks(r0.f3610);
                    r0.f3612.post(r0.f3619);
                }
            } else {
                r0.f3612.post(r0.f3620);
                r0.f3612.post(r0.f3619);
            }
            r0.f3614 = currentTimeMillis;
        }
        AFEvent context2 = new InAppEvent().context(context);
        context2.f3302 = str;
        context2.f3289 = map;
        context2.f3296 = appsFlyerTrackingRequestListener;
        mo10731(context2);
    }

    public void sendAdRevenue(Context context, Map<String, Object> map) {
        AFEvent context2 = new AdRevenue().context(context);
        context2.f3289 = map;
        Context context3 = context2.f3291 != null ? context2.f3291 : context2.f3295 != null ? (Context) context2.f3295.get() : null;
        String url = ServerConfigHandler.getUrl("https://%sadrevenue.%s/api/v5.1/android?buildnumber=5.1.1&app_id=");
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append(context3.getPackageName());
        String obj = sb.toString();
        SharedPreferences sharedPreferences = context3.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
        int r4 = m3206(sharedPreferences, "appsFlyerCount", false);
        int r5 = m3206(sharedPreferences, "appsFlyerAdRevenueCount", true);
        HashMap hashMap = new HashMap();
        hashMap.put("ad_network", context2.f3289);
        hashMap.put("adrevenue_counter", Integer.valueOf(r5));
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        hashMap.put("af_key", string);
        hashMap.put("launch_counter", Integer.valueOf(r4));
        hashMap.put("af_timestamp", Long.toString(new Date().getTime()));
        hashMap.put("uid", C1347ag.m3284(new WeakReference(context3)));
        AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
        String str = ServerParameters.ADVERTISING_ID_PARAM;
        String string2 = instance.getString(str);
        String str2 = "advertiserIdEnabled";
        hashMap.put(str2, AppsFlyerProperties.getInstance().getString(str2));
        if (string2 != null) {
            hashMap.put(str, string2);
        }
        hashMap.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, Build.DEVICE);
        m3193(context3, (Map<String, Object>) hashMap);
        try {
            PackageInfo packageInfo = context3.getPackageManager().getPackageInfo(context3.getPackageName(), 0);
            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            long j = packageInfo.firstInstallTime;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            hashMap.put("install_date", simpleDateFormat.format(new Date(j)));
            String string3 = sharedPreferences.getString("appsFlyerFirstInstall", null);
            if (string3 == null) {
                string3 = m3201(simpleDateFormat, context3);
            }
            hashMap.put("first_launch_date", string3);
        } catch (Throwable th) {
            AFLogger.afErrorLog("AdRevenue - Exception while collecting app version data ", th);
        }
        AFEvent urlString = context2.urlString(obj);
        urlString.f3293 = hashMap;
        AFEvent r13 = urlString.mo10644();
        r13.f3292 = r4;
        r13.f3290 = string;
        m3195(AFExecutor.getInstance().mo10646(), new C1329b(this, r13, 0), 1, TimeUnit.MILLISECONDS);
    }

    public void trackEvent(Context context, String str, Map<String, Object> map) {
        trackEvent(context, str, map, null);
    }

    /* access modifiers changed from: protected */
    public void getConversionData(Context context, final ConversionDataListener conversionDataListener) {
        f3333 = new AppsFlyerConversionListener() {
            public final void onAppOpenAttribution(Map<String, String> map) {
            }

            public final void onAttributionFailure(String str) {
            }

            public final void onConversionDataSuccess(Map<String, Object> map) {
                StringBuilder sb = new StringBuilder("Calling onConversionDataLoaded with:\n");
                sb.append(map.toString());
                AFLogger.afDebugLog(sb.toString());
                conversionDataListener.onConversionDataLoaded(map);
            }

            public final void onConversionDataFail(String str) {
                AFLogger.afDebugLog("Calling onConversionFailure with:\n".concat(String.valueOf(str)));
                conversionDataListener.onConversionFailure(str);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ */
    public static Map<String, Object> m3217(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if (!f3332.contains(str2)) {
                    hashMap.put(str2, jSONObject.isNull(str2) ? null : jSONObject.get(str2));
                }
            }
            return hashMap;
        } catch (JSONException e) {
            AFLogger.afErrorLog(e.getMessage(), e);
            return null;
        }
    }

    /* renamed from: ॱ */
    private void m3231(Context context, String str, String str2, Intent intent) {
        AFEvent context2 = new Launch().context(context);
        context2.f3302 = null;
        context2.f3290 = str;
        context2.f3289 = null;
        context2.f3298 = str2;
        context2.f3299 = intent;
        context2.f3287 = null;
        m3194(context2);
    }

    /* renamed from: ˊ */
    private void m3194(AFEvent aFEvent) {
        aFEvent.mo10644();
        boolean z = aFEvent.f3302 == null;
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false) && AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID) == null) {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        if (z) {
            if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true)) {
                AFLogger.afInfoLog("Allowing multiple launches within a 5 second time window.");
            } else if (m3223()) {
                return;
            }
            this.f3347 = System.currentTimeMillis();
        }
        ScheduledThreadPoolExecutor r0 = AFExecutor.getInstance().mo10646();
        aFEvent.f3295 = new WeakReference<>(aFEvent.f3291);
        aFEvent.f3291 = null;
        m3195(r0, new C1331d(this, aFEvent, 0), 150, TimeUnit.MILLISECONDS);
    }

    /* renamed from: ˏ */
    private boolean m3223() {
        if (this.f3347 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f3347;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", Locale.US);
            long j = this.f3347;
            String str = "UTC";
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str));
            String format = simpleDateFormat.format(new Date(j));
            long j2 = this.f3334;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str));
            String format2 = simpleDateFormat.format(new Date(j2));
            if (currentTimeMillis < this.f3361 && !isTrackingStopped()) {
                AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", new Object[]{format, format2, Long.valueOf(currentTimeMillis), Long.valueOf(this.f3361)}));
                return true;
            } else if (!isTrackingStopped()) {
                AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", new Object[]{format, format2, Long.valueOf(currentTimeMillis)}));
            }
        } else if (!isTrackingStopped()) {
            AFLogger.afInfoLog("Sending first launch for this session!");
        }
        return false;
    }

    /* renamed from: ॱ */
    public static boolean m3236(@NonNull SharedPreferences sharedPreferences) {
        return Boolean.parseBoolean(sharedPreferences.getString("sentSuccessfully", null));
    }

    /* renamed from: ˊ */
    private static void m3193(Context context, Map<String, Object> map) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            String str = rotation != 0 ? rotation != 1 ? rotation != 2 ? rotation != 3 ? "" : "lr" : "pr" : "l" : "p";
            map.put("sc_o", str);
        }
    }

    public void setConsumeAFDeepLinks(boolean z) {
        AppsFlyerProperties.getInstance().set("consumeAfDeepLink", z);
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str = "public_api_call";
        C1356am.f3467.mo10812(str, "setConsumeAFDeepLinks: ".concat(String.valueOf(z)), new String[0]);
    }

    public void handleDeepLinkCallback(Context context, Map<String, Object> map, Uri uri) {
        String str;
        String obj = uri.toString();
        if (obj == null) {
            obj = null;
        } else if (obj.matches("fb\\d*?://authorize.*")) {
            String str2 = "access_token";
            if (obj.contains(str2)) {
                int indexOf = obj.indexOf(63);
                if (indexOf == -1) {
                    str = "";
                } else {
                    str = obj.substring(indexOf);
                }
                if (str.length() != 0) {
                    ArrayList arrayList = new ArrayList();
                    String str3 = "&";
                    if (str.contains(str3)) {
                        arrayList = new ArrayList(Arrays.asList(str.split(str3)));
                    } else {
                        arrayList.add(str);
                    }
                    StringBuilder sb = new StringBuilder();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str4 = (String) it.next();
                        if (str4.contains(str2)) {
                            it.remove();
                        } else {
                            if (sb.length() != 0) {
                                sb.append(str3);
                            } else {
                                String str5 = "?";
                                if (!str4.startsWith(str5)) {
                                    sb.append(str5);
                                }
                            }
                            sb.append(str4);
                        }
                    }
                    obj = obj.replace(str, sb.toString());
                }
            }
        }
        String str6 = "af_deeplink";
        boolean z = true;
        if (!map.containsKey(str6)) {
            map.put(str6, obj);
        } else {
            this.f3340 = "AppsFlyer_Test".equals(uri.getQueryParameter("media_source")) && Boolean.parseBoolean(uri.getQueryParameter("is_retargeting"));
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("link", uri.toString());
        final WeakReference weakReference = new WeakReference(context);
        C1351ai aiVar = new C1351ai(uri, this);
        aiVar.setConnProvider(new HttpsUrlConnectionProvider());
        if (TextUtils.isEmpty(aiVar.f3408) || TextUtils.isEmpty(aiVar.f3452) || aiVar.f3408.equals(TapjoyConstants.TJC_APP_PLACEMENT)) {
            z = false;
        }
        if (z) {
            aiVar.f3451 = new C1352e() {
                /* renamed from: ˋ */
                public final void mo10740(String str) {
                    if (AppsFlyerLibCore.f3333 != null) {
                        m3252(hashMap);
                        AFLogger.afDebugLog("Calling onAttributionFailure with:\n".concat(String.valueOf(str)));
                        AppsFlyerLibCore.f3333.onAttributionFailure(str);
                    }
                }

                /* renamed from: ˏ */
                private void m3252(Map<String, String> map) {
                    if (weakReference.get() != null) {
                        AppsFlyerLibCore.m3219((Context) weakReference.get(), "deeplinkAttribution", new JSONObject(map).toString());
                    }
                }

                /* renamed from: ˎ */
                public final void mo10741(Map<String, String> map) {
                    for (String str : map.keySet()) {
                        hashMap.put(str, map.get(str));
                    }
                    m3252(hashMap);
                    AppsFlyerLibCore.m3222(hashMap);
                }
            };
            AFExecutor.getInstance().getThreadPoolExecutor().execute(aiVar);
            return;
        }
        m3222(C13183.m3164(context, hashMap, uri));
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ */
    public static void m3222(Map<String, String> map) {
        if (f3333 != null) {
            try {
                StringBuilder sb = new StringBuilder("Calling onAppOpenAttribution with:\n");
                sb.append(map.toString());
                AFLogger.afDebugLog(sb.toString());
                f3333.onAppOpenAttribution(map);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    /* renamed from: ʽ */
    private static boolean m3184(Context context) {
        try {
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
                return true;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog("WARNING:  Google play services is unavailable. ", th);
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            return true;
        } catch (NameNotFoundException e) {
            AFLogger.afErrorLog("WARNING:  Google Play Services is unavailable. ", e);
            return false;
        }
    }

    /* renamed from: ᐝ */
    private static boolean m3241(Context context) {
        if ((AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) || !m3184(context)) {
            return true;
        }
        return false;
    }

    /* renamed from: ʼ */
    private static String m3182(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            return string;
        }
        String r2 = m3210(new WeakReference<>(context), "AF_STORE");
        if (r2 != null) {
            return r2;
        }
        return null;
    }

    /* renamed from: ˎ */
    private static String m3208(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{str});
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    @Nullable
    /* renamed from: ˎ */
    private static String m3210(WeakReference<Context> weakReference, String str) {
        if (weakReference.get() == null) {
            return null;
        }
        return m3209(str, ((Context) weakReference.get()).getPackageManager(), ((Context) weakReference.get()).getPackageName());
    }

    @Nullable
    /* renamed from: ˎ */
    private static String m3209(String str, PackageManager packageManager, String str2) {
        try {
            Bundle bundle = packageManager.getApplicationInfo(str2, 128).metaData;
            if (bundle == null) {
                return null;
            }
            Object obj = bundle.get(str);
            if (obj != null) {
                return obj.toString();
            }
            return null;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Could not find ");
            sb.append(str);
            sb.append(" value in the manifest");
            AFLogger.afErrorLog(sb.toString(), th);
            return null;
        }
    }

    public void setPreinstallAttribution(String str, String str2, String str3) {
        AFLogger.afDebugLog("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        String str4 = Constants.URL_MEDIA_SOURCE;
        if (str != null) {
            try {
                jSONObject.put(str4, str);
            } catch (JSONException e) {
                AFLogger.afErrorLog(e.getMessage(), e);
            }
        }
        if (str2 != null) {
            jSONObject.put(Constants.URL_CAMPAIGN, str2);
        }
        if (str3 != null) {
            jSONObject.put(Constants.URL_SITE_ID, str3);
        }
        if (jSONObject.has(str4)) {
            AppsFlyerProperties.getInstance().set("preInstallName", jSONObject.toString());
            return;
        }
        AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0042 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034 A[SYNTHETIC, Splitter:B:18:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060 A[SYNTHETIC, Splitter:B:32:0x0060] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0042=Splitter:B:24:0x0042, B:15:0x002b=Splitter:B:15:0x002b} */
    /* renamed from: ˎ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m3207(java.io.File r4, java.lang.String r5) {
        /*
            r0 = 0
            java.util.Properties r1 = new java.util.Properties     // Catch:{ FileNotFoundException -> 0x0041, Throwable -> 0x0029, all -> 0x0026 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x0041, Throwable -> 0x0029, all -> 0x0026 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0041, Throwable -> 0x0029, all -> 0x0026 }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0041, Throwable -> 0x0029, all -> 0x0026 }
            r1.load(r2)     // Catch:{ FileNotFoundException -> 0x0042, Throwable -> 0x0024 }
            java.lang.String r3 = "Found PreInstall property!"
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ FileNotFoundException -> 0x0042, Throwable -> 0x0024 }
            java.lang.String r4 = r1.getProperty(r5)     // Catch:{ FileNotFoundException -> 0x0042, Throwable -> 0x0024 }
            r2.close()     // Catch:{ Throwable -> 0x001b }
            goto L_0x0023
        L_0x001b:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x0023:
            return r4
        L_0x0024:
            r4 = move-exception
            goto L_0x002b
        L_0x0026:
            r4 = move-exception
            r2 = r0
            goto L_0x005e
        L_0x0029:
            r4 = move-exception
            r2 = r0
        L_0x002b:
            java.lang.String r5 = r4.getMessage()     // Catch:{ all -> 0x005d }
            com.appsflyer.AFLogger.afErrorLog(r5, r4)     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x005c
            r2.close()     // Catch:{ Throwable -> 0x0038 }
            goto L_0x005c
        L_0x0038:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r5, r4)
            goto L_0x005c
        L_0x0041:
            r2 = r0
        L_0x0042:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            java.lang.String r1 = "PreInstall file wasn't found: "
            r5.<init>(r1)     // Catch:{ all -> 0x005d }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x005d }
            r5.append(r4)     // Catch:{ all -> 0x005d }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x005d }
            com.appsflyer.AFLogger.afDebugLog(r4)     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x005c
            r2.close()     // Catch:{ Throwable -> 0x0038 }
        L_0x005c:
            return r0
        L_0x005d:
            r4 = move-exception
        L_0x005e:
            if (r2 == 0) goto L_0x006c
            r2.close()     // Catch:{ Throwable -> 0x0064 }
            goto L_0x006c
        L_0x0064:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x006c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m3207(java.io.File, java.lang.String):java.lang.String");
    }

    /* renamed from: ʻ */
    private static File m3180(String str) {
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    return new File(str.trim());
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getMessage(), th);
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: ॱ */
    public static String m3227(WeakReference<Context> weakReference) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.CHANNEL);
        if (string == null) {
            string = m3210(weakReference, "CHANNEL");
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }

    public boolean isPreInstalledApp(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
            AFLogger.afErrorLog("Could not check if app is pre installed", e);
        }
    }

    public String getAttributionId(Context context) {
        try {
            return new C1341ad(context).mo10794();
        } catch (Throwable th) {
            AFLogger.afErrorLog("Could not collect facebook attribution id. ", th);
            return null;
        }
    }

    /* renamed from: ॱ */
    public static SharedPreferences m3225(Context context) {
        return context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
    }

    /* renamed from: ˎ */
    public static int m3206(SharedPreferences sharedPreferences, String str, boolean z) {
        int i = sharedPreferences.getInt(str, 0);
        if (z) {
            i++;
            Editor edit = sharedPreferences.edit();
            edit.putInt(str, i);
            edit.apply();
        }
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        if (C1356am.f3467.f3478) {
            if (C1356am.f3467 == null) {
                C1356am.f3467 = new C1356am();
            }
            C1356am.f3467.mo10815(String.valueOf(i));
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: ˊ */
    public static void m3195(ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j, TimeUnit timeUnit) {
        if (scheduledExecutorService != null) {
            try {
                if (!scheduledExecutorService.isShutdown() && !scheduledExecutorService.isTerminated()) {
                    scheduledExecutorService.schedule(runnable, j, timeUnit);
                    return;
                }
            } catch (RejectedExecutionException e) {
                AFLogger.afErrorLog("scheduleJob failed with RejectedExecutionException Exception", e);
                return;
            } catch (Throwable th) {
                AFLogger.afErrorLog("scheduleJob failed with Exception", th);
                return;
            }
        }
        AFLogger.afWarnLog("scheduler is null, shut downed or terminated");
    }

    public boolean isTrackingStopped() {
        return this.f3346;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        if (r3 != null) goto L_0x002c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a A[SYNTHETIC, Splitter:B:27:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0086 A[SYNTHETIC, Splitter:B:45:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008b A[Catch:{ Throwable -> 0x008e }] */
    @androidx.annotation.NonNull
    /* renamed from: ˏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m3215(java.net.HttpURLConnection r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.InputStream r2 = r7.getErrorStream()     // Catch:{ Throwable -> 0x003d, all -> 0x003a }
            if (r2 != 0) goto L_0x0010
            java.io.InputStream r2 = r7.getInputStream()     // Catch:{ Throwable -> 0x003d, all -> 0x003a }
        L_0x0010:
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Throwable -> 0x003d, all -> 0x003a }
            r3.<init>(r2)     // Catch:{ Throwable -> 0x003d, all -> 0x003a }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x0038 }
            r2.<init>(r3)     // Catch:{ Throwable -> 0x0038 }
        L_0x001a:
            java.lang.String r1 = r2.readLine()     // Catch:{ Throwable -> 0x0033, all -> 0x0030 }
            if (r1 == 0) goto L_0x0029
            r0.append(r1)     // Catch:{ Throwable -> 0x0033, all -> 0x0030 }
            r1 = 10
            r0.append(r1)     // Catch:{ Throwable -> 0x0033, all -> 0x0030 }
            goto L_0x001a
        L_0x0029:
            r2.close()     // Catch:{ Throwable -> 0x0060 }
        L_0x002c:
            r3.close()     // Catch:{ Throwable -> 0x0060 }
            goto L_0x0060
        L_0x0030:
            r7 = move-exception
            r1 = r2
            goto L_0x0084
        L_0x0033:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x003f
        L_0x0038:
            r2 = move-exception
            goto L_0x003f
        L_0x003a:
            r7 = move-exception
            r3 = r1
            goto L_0x0084
        L_0x003d:
            r2 = move-exception
            r3 = r1
        L_0x003f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = "Could not read connection response from: "
            r4.<init>(r5)     // Catch:{ all -> 0x0083 }
            java.net.URL r7 = r7.getURL()     // Catch:{ all -> 0x0083 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0083 }
            r4.append(r7)     // Catch:{ all -> 0x0083 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0083 }
            com.appsflyer.AFLogger.afErrorLog(r7, r2)     // Catch:{ all -> 0x0083 }
            if (r1 == 0) goto L_0x005d
            r1.close()     // Catch:{ Throwable -> 0x0060 }
        L_0x005d:
            if (r3 == 0) goto L_0x0060
            goto L_0x002c
        L_0x0060:
            java.lang.String r7 = r0.toString()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x006a }
            r0.<init>(r7)     // Catch:{ JSONException -> 0x006a }
            return r7
        L_0x006a:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "string_response"
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r7 = r0.toString()     // Catch:{ JSONException -> 0x0079 }
            return r7
        L_0x0079:
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r7 = r7.toString()
            return r7
        L_0x0083:
            r7 = move-exception
        L_0x0084:
            if (r1 == 0) goto L_0x0089
            r1.close()     // Catch:{ Throwable -> 0x008e }
        L_0x0089:
            if (r3 == 0) goto L_0x008e
            r3.close()     // Catch:{ Throwable -> 0x008e }
        L_0x008e:
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m3215(java.net.HttpURLConnection):java.lang.String");
    }

    /* renamed from: ʻ */
    private static float m3179(Context context) {
        float f;
        try {
            Intent registerReceiver = context.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra == -1 || intExtra2 == -1) {
                return 50.0f;
            }
            f = (((float) intExtra) / ((float) intExtra2)) * 100.0f;
            return f;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            f = 1.0f;
        }
    }

    /* renamed from: ˊॱ */
    private static boolean m3198(Context context) {
        if (context != null) {
            String str = "Failed collecting ivc data";
            if (VERSION.SDK_INT >= 23) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    for (Network networkCapabilities : connectivityManager.getAllNetworks()) {
                        NetworkCapabilities networkCapabilities2 = connectivityManager.getNetworkCapabilities(networkCapabilities);
                        if (networkCapabilities2.hasTransport(4) && !networkCapabilities2.hasCapability(15)) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e) {
                    AFLogger.afErrorLog(str, e);
                }
            } else if (VERSION.SDK_INT >= 16) {
                ArrayList arrayList = new ArrayList();
                try {
                    Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (it.hasNext()) {
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface.isUp()) {
                            arrayList.add(networkInterface.getName());
                        }
                    }
                    return arrayList.contains("tun0");
                } catch (Exception e2) {
                    AFLogger.afErrorLog(str, e2);
                }
            }
        }
        return false;
    }

    public void setLogLevel(LogLevel logLevel) {
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
    }

    public void setMinTimeBetweenSessions(int i) {
        this.f3361 = TimeUnit.SECONDS.toMillis((long) i);
    }

    public String getSdkVersion() {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str = "public_api_call";
        C1356am.f3467.mo10812(str, "getSdkVersion", new String[0]);
        StringBuilder sb = new StringBuilder("version: 5.1.1 (build ");
        sb.append(f3329);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: ॱ */
    private void m3232(final AFEvent aFEvent) {
        Context context = aFEvent.f3291 != null ? aFEvent.f3291 : aFEvent.f3295 != null ? (Context) aFEvent.f3295.get() : null;
        Application application = (Application) context;
        AppsFlyerProperties.getInstance().loadProperties(application.getApplicationContext());
        if (this.f3336 == null) {
            if (C1348ah.f3444 == null) {
                C1348ah.f3444 = new C1348ah();
            }
            this.f3336 = new C1350d() {
                /* renamed from: ˏ */
                public final void mo10739(Activity activity) {
                    if (AppsFlyerLibCore.m3206(AppsFlyerLibCore.m3225((Context) activity), "appsFlyerCount", false) < 2) {
                        C1388w r0 = C1388w.m3355((Context) activity);
                        r0.f3612.post(r0.f3620);
                        r0.f3612.post(r0.f3619);
                    }
                    AFEvent context = aFEvent.context(activity);
                    AFLogger.afInfoLog("onBecameForeground");
                    AppsFlyerLibCore.getInstance().f3362 = System.currentTimeMillis();
                    AppsFlyerLibCore.getInstance().mo10731(context);
                    AFLogger.resetDeltaTime();
                }

                /* renamed from: ˋ */
                public final void mo10738(WeakReference<Context> weakReference) {
                    C13675.m3335((Context) weakReference.get());
                    C1388w r2 = C1388w.m3355((Context) weakReference.get());
                    r2.f3612.post(r2.f3620);
                }
            };
            if (C1348ah.f3444 != null) {
                C1348ah.f3444.f3447 = this.f3336;
                application.registerActivityLifecycleCallbacks(C1348ah.f3444);
                return;
            }
            throw new IllegalStateException("Foreground is not initialised - invoke at least once with parameter init/get");
        }
    }

    public void setDebugLog(boolean z) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        C1356am.f3467.mo10812("public_api_call", "setDebugLog", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("shouldLog", z);
        AppsFlyerProperties.getInstance().set("logLevel", (z ? LogLevel.DEBUG : LogLevel.NONE).getLevel());
    }

    public void setImeiData(String str) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str2 = "public_api_call";
        C1356am.f3467.mo10812(str2, "setImeiData", str);
        this.f3353 = str;
    }

    public void setOaidData(String str) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str2 = "public_api_call";
        C1356am.f3467.mo10812(str2, "setOaidData", str);
        this.f3356 = str;
    }

    public void setAndroidIdData(String str) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str2 = "public_api_call";
        C1356am.f3467.mo10812(str2, "setAndroidIdData", str);
        this.f3357 = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ */
    public static void m3219(Context context, String str, String str2) {
        Editor edit = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    /* access modifiers changed from: private */
    /* renamed from: ˊ */
    public static void m3191(Context context, String str, long j) {
        Editor edit = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public void setCustomerIdAndTrack(String str, @NonNull Context context) {
        Intent intent;
        if (context != null) {
            AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
            String str2 = AppsFlyerProperties.AF_WAITFOR_CUSTOMERID;
            if (instance.getBoolean(str2, false) && AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID) == null) {
                setCustomerUserId(str);
                AppsFlyerProperties.getInstance().set(str2, false);
                StringBuilder sb = new StringBuilder("CustomerUserId set: ");
                sb.append(str);
                sb.append(" - Initializing AppsFlyer Tacking");
                AFLogger.afInfoLog(sb.toString(), true);
                String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
                String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
                if (referrer == null) {
                    referrer = "";
                }
                if (context instanceof Activity) {
                    intent = ((Activity) context).getIntent();
                } else {
                    intent = null;
                }
                m3231(context, string, referrer, intent);
                String str3 = "afUninstallToken";
                if (AppsFlyerProperties.getInstance().getString(str3) != null) {
                    mo10734(context, AppsFlyerProperties.getInstance().getString(str3));
                }
                return;
            }
            setCustomerUserId(str);
            AFLogger.afInfoLog("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
        }
    }

    public void setAppInviteOneLink(String str) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str2 = "public_api_call";
        C1356am.f3467.mo10812(str2, "setAppInviteOneLink", str);
        AFLogger.afInfoLog("setAppInviteOneLink = ".concat(String.valueOf(str)));
        String str3 = AppsFlyerProperties.ONELINK_ID;
        if (str == null || !str.equals(AppsFlyerProperties.getInstance().getString(str3))) {
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_DOMAIN);
            AppsFlyerProperties.getInstance().remove("onelinkVersion");
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_SCHEME);
        }
        AppsFlyerProperties.getInstance().set(str3, str);
    }

    public void setAdditionalData(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            if (C1356am.f3467 == null) {
                C1356am.f3467 = new C1356am();
            }
            String str = "public_api_call";
            C1356am.f3467.mo10812(str, "setAdditionalData", hashMap.toString());
            AppsFlyerProperties.getInstance().setCustomData(new JSONObject(hashMap).toString());
        }
    }

    public void setUserEmails(String... strArr) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        C1356am.f3467.mo10812("public_api_call", "setUserEmails", strArr);
        setUserEmails(EmailsCryptType.NONE, strArr);
    }

    public void setCollectAndroidID(boolean z) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str = "public_api_call";
        C1356am.f3467.mo10812(str, "setCollectAndroidID", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z));
    }

    public void setCollectIMEI(boolean z) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str = "public_api_call";
        C1356am.f3467.mo10812(str, "setCollectIMEI", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z));
    }

    public void setCollectOaid(boolean z) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str = "public_api_call";
        C1356am.f3467.mo10812(str, "setCollectOaid", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z));
    }

    @Deprecated
    public AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        C1356am amVar = C1356am.f3467;
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = appsFlyerConversionListener == null ? "null" : "conversionDataListener";
        amVar.mo10812("public_api_call", "init", strArr);
        AFLogger.m3173(String.format("Initializing AppsFlyer SDK: (v%s.%s)", new Object[]{BuildConfig.VERSION_NAME, f3329}));
        this.f3341 = true;
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_KEY, str);
        C13194.m3167(str);
        f3333 = appsFlyerConversionListener;
        return this;
    }

    /* renamed from: ˊ */
    private static boolean m3197(@NonNull Context context) {
        if (m3206(context.getApplicationContext().getSharedPreferences("appsflyer-data", 0), "appsFlyerCount", false) > 2) {
            AFLogger.afRDLog("Install referrer will not load, the counter > 2, ");
            return false;
        }
        try {
            Class.forName("com.android.installreferrer.api.InstallReferrerClient");
            if (C13183.m3165(context, "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE")) {
                AFLogger.afDebugLog("Install referrer is allowed");
                return true;
            }
            AFLogger.afDebugLog("Install referrer is not allowed");
            return false;
        } catch (ClassNotFoundException unused) {
            AFLogger.afRDLog("Class com.android.installreferrer.api.InstallReferrerClient not found");
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest : com.android.installreferrer.api.InstallReferrerClient", th);
            return false;
        }
    }

    /* renamed from: ˎ */
    private static void m3211(Context context) {
        int i;
        if ("OPPO".equals(Build.BRAND)) {
            i = 23;
            AFLogger.afRDLog("OPPO device found");
        } else {
            i = 18;
        }
        if (VERSION.SDK_INT < i || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DISABLE_KEYSTORE, false)) {
            StringBuilder sb = new StringBuilder("OS SDK is=");
            sb.append(VERSION.SDK_INT);
            sb.append("; no KeyStore usage");
            AFLogger.afRDLog(sb.toString());
            return;
        }
        StringBuilder sb2 = new StringBuilder("OS SDK is=");
        sb2.append(VERSION.SDK_INT);
        sb2.append("; use KeyStore");
        AFLogger.afRDLog(sb2.toString());
        AFKeystoreWrapper aFKeystoreWrapper = new AFKeystoreWrapper(context);
        if (!aFKeystoreWrapper.mo10652()) {
            aFKeystoreWrapper.f3320 = C1347ag.m3284(new WeakReference(context));
            aFKeystoreWrapper.f3323 = 0;
            aFKeystoreWrapper.mo10654(aFKeystoreWrapper.mo10653());
        } else {
            String r4 = aFKeystoreWrapper.mo10653();
            synchronized (aFKeystoreWrapper.f3322) {
                aFKeystoreWrapper.f3323++;
                AFLogger.afInfoLog("Deleting key with alias: ".concat(String.valueOf(r4)));
                try {
                    synchronized (aFKeystoreWrapper.f3322) {
                        aFKeystoreWrapper.f3319.deleteEntry(r4);
                    }
                } catch (KeyStoreException e) {
                    StringBuilder sb3 = new StringBuilder("Exception ");
                    sb3.append(e.getMessage());
                    sb3.append(" occurred");
                    AFLogger.afErrorLog(sb3.toString(), e);
                }
            }
            aFKeystoreWrapper.mo10654(aFKeystoreWrapper.mo10653());
        }
        AppsFlyerProperties.getInstance().set("KSAppsFlyerId", aFKeystoreWrapper.mo10656());
        AppsFlyerProperties.getInstance().set("KSAppsFlyerRICounter", String.valueOf(aFKeystoreWrapper.mo10655()));
    }

    public void setCustomerUserId(String str) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str2 = "public_api_call";
        C1356am.f3467.mo10812(str2, "setCustomerUserId", str);
        AFLogger.afInfoLog("setCustomerUserId = ".concat(String.valueOf(str)));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.APP_USER_ID, str);
    }

    public void setAppId(String str) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str2 = "public_api_call";
        C1356am.f3467.mo10812(str2, "setAppId", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.APP_ID, str);
    }

    public void setExtension(String str) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str2 = "public_api_call";
        C1356am.f3467.mo10812(str2, "setExtension", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
    }

    public void setIsUpdate(boolean z) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str = "public_api_call";
        C1356am.f3467.mo10812(str, "setIsUpdate", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z);
    }

    public void setCurrencyCode(String str) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str2 = "public_api_call";
        C1356am.f3467.mo10812(str2, "setCurrencyCode", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
    }

    public void trackLocation(Context context, double d, double d2) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str = "public_api_call";
        C1356am.f3467.mo10812(str, "trackLocation", String.valueOf(d), String.valueOf(d2));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGTITUDE, Double.toString(d2));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d));
        AFEvent context2 = new InAppEvent().context(context);
        context2.f3302 = AFInAppEventType.LOCATION_COORDINATES;
        context2.f3289 = hashMap;
        mo10731(context2);
    }

    public void reportTrackSession(Context context) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str = "public_api_call";
        C1356am.f3467.mo10812(str, "reportTrackSession", new String[0]);
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        C1356am.f3467.f3488 = false;
        AFEvent context2 = new InAppEvent().context(context);
        context2.f3302 = null;
        context2.f3289 = null;
        mo10731(context2);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    /* renamed from: ˋ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo10731(com.appsflyer.AFEvent r7) {
        /*
            r6 = this;
            android.content.Context r0 = r7.f3291
            r1 = 0
            if (r0 == 0) goto L_0x0008
            android.content.Context r0 = r7.f3291
            goto L_0x0016
        L_0x0008:
            java.lang.ref.WeakReference<android.content.Context> r0 = r7.f3295
            if (r0 == 0) goto L_0x0015
            java.lang.ref.WeakReference<android.content.Context> r0 = r7.f3295
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            boolean r2 = r0 instanceof android.app.Activity
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0037
            r2 = r0
            android.app.Activity r2 = (android.app.Activity) r2
            android.content.Intent r4 = r2.getIntent()
            android.net.Uri r1 = androidx.core.app.ActivityCompat.getReferrer(r2)     // Catch:{ Throwable -> 0x0028 }
            goto L_0x0030
        L_0x0028:
            r2 = move-exception
            java.lang.String r5 = r2.getLocalizedMessage()
            com.appsflyer.AFLogger.afErrorLog(r5, r2)
        L_0x0030:
            if (r1 == 0) goto L_0x0038
            java.lang.String r1 = r1.toString()
            goto L_0x0039
        L_0x0037:
            r4 = r1
        L_0x0038:
            r1 = r3
        L_0x0039:
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r5 = "AppsFlyerKey"
            java.lang.String r2 = r2.getString(r5)
            if (r2 != 0) goto L_0x004b
            java.lang.String r7 = "[TrackEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey."
            com.appsflyer.AFLogger.afWarnLog(r7)
            return
        L_0x004b:
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r2.getReferrer(r0)
            if (r0 != 0) goto L_0x0056
            r0 = r3
        L_0x0056:
            r7.f3298 = r0
            r7.f3299 = r4
            r7.f3287 = r1
            r6.m3194(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.mo10731(com.appsflyer.AFEvent):void");
    }

    /* renamed from: ˎ */
    public final void mo10734(Context context, String str) {
        boolean z = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
        String str2 = AppsFlyerProperties.APP_USER_ID;
        if (z && AppsFlyerProperties.getInstance().getString(str2) == null) {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        HashMap hashMap = new HashMap();
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        if (string == null) {
            AFLogger.afWarnLog("[registerUninstall] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
            hashMap.put("app_version_name", packageInfo.versionName);
            hashMap.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
            long j = packageInfo.firstInstallTime;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            hashMap.put("installDate", simpleDateFormat.format(new Date(j)));
        } catch (Throwable th) {
            AFLogger.afErrorLog("Exception while collecting application version info.", th);
        }
        m3212(context, (Map<String, ? super String>) hashMap);
        String string2 = AppsFlyerProperties.getInstance().getString(str2);
        if (string2 != null) {
            hashMap.put("appUserId", string2);
        }
        try {
            hashMap.put("model", Build.MODEL);
            hashMap.put("brand", Build.BRAND);
        } catch (Throwable th2) {
            AFLogger.afErrorLog("Exception while collecting device brand and model.", th2);
        }
        AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
        String str3 = AppsFlyerProperties.DEVICE_TRACKING_DISABLED;
        if (instance.getBoolean(str3, false)) {
            hashMap.put(str3, "true");
        }
        C1393x r3 = C1336aa.m3269(context.getContentResolver());
        if (r3 != null) {
            hashMap.put("amazon_aid", r3.f3627);
            hashMap.put("amazon_aid_limit", String.valueOf(r3.f3626));
        }
        AppsFlyerProperties instance2 = AppsFlyerProperties.getInstance();
        String str4 = ServerParameters.ADVERTISING_ID_PARAM;
        String string3 = instance2.getString(str4);
        if (string3 != null) {
            hashMap.put(str4, string3);
        }
        hashMap.put("devkey", string);
        hashMap.put("uid", C1347ag.m3284(new WeakReference(context)));
        hashMap.put("af_gcm_token", str);
        hashMap.put("launch_counter", Integer.toString(m3206(context.getApplicationContext().getSharedPreferences("appsflyer-data", 0), "appsFlyerCount", false)));
        hashMap.put("sdk", Integer.toString(VERSION.SDK_INT));
        String r12 = m3227(new WeakReference<>(context));
        if (r12 != null) {
            hashMap.put(AppsFlyerProperties.CHANNEL, r12);
        }
        try {
            C1339ac acVar = new C1339ac(context, isTrackingStopped());
            acVar.f3422 = new JSONObject(hashMap).toString();
            StringBuilder sb = new StringBuilder();
            sb.append(ServerConfigHandler.getUrl("https://%sregister.%s/api/v4.11/androidevent?buildnumber=5.1.1&app_id="));
            sb.append(packageName);
            new Thread(new Runnable(sb.toString()) {

                /* renamed from: ॱ */
                private /* synthetic */ String f3428;

                {
                    this.f3428 = r2;
                }

                public final void run() {
                    C1339ac.this.mo10792(this.f3428);
                }
            }).start();
        } catch (Throwable th3) {
            AFLogger.afErrorLog(th3.getMessage(), th3);
        }
    }

    public void setDeviceTrackingDisabled(boolean z) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str = "public_api_call";
        C1356am.f3467.mo10812(str, "setDeviceTrackingDisabled", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: ॱॱ */
    public static Map<String, Object> m3237(Context context) throws C1338ab {
        String string = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).getString("attributionId", null);
        if (string != null && string.length() > 0) {
            return m3217(string);
        }
        throw new C1338ab();
    }

    public void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str = "public_api_call";
        C1356am.f3467.mo10812(str, "registerConversionListener", new String[0]);
        if (appsFlyerConversionListener != null) {
            f3333 = appsFlyerConversionListener;
        }
    }

    public void unregisterConversionListener() {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str = "public_api_call";
        C1356am.f3467.mo10812(str, "unregisterConversionListener", new String[0]);
        f3333 = null;
    }

    public void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str = "public_api_call";
        C1356am.f3467.mo10812(str, "registerValidatorListener", new String[0]);
        AFLogger.afDebugLog("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener == null) {
            AFLogger.afDebugLog("registerValidatorListener null listener");
        } else {
            f3331 = appsFlyerInAppPurchaseValidatorListener;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01c9, code lost:
        if (r3 != false) goto L_0x01cc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01b1  */
    /* renamed from: ˏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m3220(com.appsflyer.AFEvent r12) {
        /*
            r11 = this;
            android.content.Context r0 = r12.f3291
            if (r0 == 0) goto L_0x0007
            android.content.Context r0 = r12.f3291
            goto L_0x0015
        L_0x0007:
            java.lang.ref.WeakReference<android.content.Context> r0 = r12.f3295
            if (r0 == 0) goto L_0x0014
            java.lang.ref.WeakReference<android.content.Context> r0 = r12.f3295
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            java.lang.String r1 = r12.f3302
            if (r0 != 0) goto L_0x001f
            java.lang.String r12 = "sendTrackingWithEvent - got null context. skipping event/launch."
            com.appsflyer.AFLogger.afDebugLog(r12)
            return
        L_0x001f:
            android.content.Context r2 = r0.getApplicationContext()
            r3 = 0
            java.lang.String r4 = "appsflyer-data"
            android.content.SharedPreferences r2 = r2.getSharedPreferences(r4, r3)
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()
            r4.saveProperties(r2)
            boolean r4 = r11.isTrackingStopped()
            if (r4 != 0) goto L_0x0050
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "sendTrackingWithEvent from activity: "
            r4.<init>(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getName()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.appsflyer.AFLogger.afInfoLog(r4)
        L_0x0050:
            r4 = 1
            if (r1 != 0) goto L_0x0055
            r1 = 1
            goto L_0x0056
        L_0x0055:
            r1 = 0
        L_0x0056:
            boolean r5 = r12 instanceof com.appsflyer.internal.model.event.BackgroundReferrerLaunch
            boolean r6 = r12 instanceof com.appsflyer.internal.model.event.NewGPReferrer
            java.lang.String r7 = "appsFlyerCount"
            if (r6 != 0) goto L_0x0060
            if (r5 == 0) goto L_0x0083
        L_0x0060:
            int r8 = m3206(r2, r7, r3)
            if (r8 != r4) goto L_0x006a
            if (r6 != 0) goto L_0x006a
            r9 = 1
            goto L_0x006b
        L_0x006a:
            r9 = 0
        L_0x006b:
            java.lang.String r10 = "newGPReferrerSent"
            boolean r10 = r2.getBoolean(r10, r3)
            if (r10 != 0) goto L_0x0077
            if (r8 != r4) goto L_0x0077
            r8 = 1
            goto L_0x0078
        L_0x0077:
            r8 = 0
        L_0x0078:
            if (r8 != 0) goto L_0x007f
            if (r9 == 0) goto L_0x007d
            goto L_0x007f
        L_0x007d:
            r8 = 0
            goto L_0x0080
        L_0x007f:
            r8 = 1
        L_0x0080:
            if (r8 != 0) goto L_0x0083
            return
        L_0x0083:
            r12.f3294 = r1
            java.util.Map r8 = r11.mo10732(r12)
            java.lang.String r9 = "appsflyerKey"
            java.lang.Object r9 = r8.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x01f8
            int r9 = r9.length()
            if (r9 != 0) goto L_0x009b
            goto L_0x01f8
        L_0x009b:
            boolean r9 = r11.isTrackingStopped()
            if (r9 != 0) goto L_0x00a6
            java.lang.String r9 = "AppsFlyerLib.sendTrackingWithEvent"
            com.appsflyer.AFLogger.afInfoLog(r9)
        L_0x00a6:
            int r2 = m3206(r2, r7, r3)
            if (r6 != 0) goto L_0x00c9
            if (r5 == 0) goto L_0x00af
            goto L_0x00c9
        L_0x00af:
            if (r1 == 0) goto L_0x00c2
            r5 = 2
            if (r2 >= r5) goto L_0x00bb
            java.lang.String r5 = f3328
            java.lang.String r5 = com.appsflyer.ServerConfigHandler.getUrl(r5)
            goto L_0x00cf
        L_0x00bb:
            java.lang.String r5 = f3327
            java.lang.String r5 = com.appsflyer.ServerConfigHandler.getUrl(r5)
            goto L_0x00cf
        L_0x00c2:
            java.lang.String r5 = "https://%sinapps.%s/api/v4.11/androidevent?app_id="
            java.lang.String r5 = com.appsflyer.ServerConfigHandler.getUrl(r5)
            goto L_0x00cf
        L_0x00c9:
            java.lang.String r5 = "https://%sattr.%s/api/v4.11/androidevent?app_id="
            java.lang.String r5 = com.appsflyer.ServerConfigHandler.getUrl(r5)
        L_0x00cf:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = r0.getPackageName()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = "&buildnumber=5.1.1"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference
            r6.<init>(r0)
            java.lang.String r6 = m3227(r6)
            if (r6 == 0) goto L_0x0112
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            java.lang.String r5 = "&channel="
            r7.append(r5)
            r7.append(r6)
            java.lang.String r5 = r7.toString()
        L_0x0112:
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r7 = "collectAndroidIdForceByUser"
            boolean r6 = r6.getBoolean(r7, r3)
            if (r6 != 0) goto L_0x012d
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r7 = "collectIMEIForceByUser"
            boolean r6 = r6.getBoolean(r7, r3)
            if (r6 == 0) goto L_0x012b
            goto L_0x012d
        L_0x012b:
            r6 = 0
            goto L_0x012e
        L_0x012d:
            r6 = 1
        L_0x012e:
            if (r6 != 0) goto L_0x0169
            java.lang.String r6 = "advertiserId"
            java.lang.Object r6 = r8.get(r6)
            if (r6 == 0) goto L_0x0169
            java.lang.String r6 = r11.f3357     // Catch:{ Exception -> 0x0163 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0163 }
            if (r6 == 0) goto L_0x014d
            java.lang.String r6 = "android_id"
            java.lang.Object r6 = r8.remove(r6)     // Catch:{ Exception -> 0x0163 }
            if (r6 == 0) goto L_0x014d
            java.lang.String r6 = "validateGaidAndIMEI :: removing: android_id"
            com.appsflyer.AFLogger.afInfoLog(r6)     // Catch:{ Exception -> 0x0163 }
        L_0x014d:
            java.lang.String r6 = r11.f3353     // Catch:{ Exception -> 0x0163 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0163 }
            if (r6 == 0) goto L_0x0169
            java.lang.String r6 = "imei"
            java.lang.Object r6 = r8.remove(r6)     // Catch:{ Exception -> 0x0163 }
            if (r6 == 0) goto L_0x0169
            java.lang.String r6 = "validateGaidAndIMEI :: removing: imei"
            com.appsflyer.AFLogger.afInfoLog(r6)     // Catch:{ Exception -> 0x0163 }
            goto L_0x0169
        L_0x0163:
            r6 = move-exception
            java.lang.String r7 = "failed to remove IMEI or AndroidID key from params; "
            com.appsflyer.AFLogger.afErrorLog(r7, r6)
        L_0x0169:
            com.appsflyer.AppsFlyerLibCore$b r6 = new com.appsflyer.AppsFlyerLibCore$b
            com.appsflyer.AFEvent r12 = r12.urlString(r5)
            r12.f3293 = r8
            com.appsflyer.AFEvent r12 = r12.mo10644()
            r12.f3292 = r2
            r6.<init>(r11, r12, r3)
            r12 = 500(0x1f4, float:7.0E-43)
            if (r1 == 0) goto L_0x019b
            boolean r0 = m3197(r0)
            if (r0 == 0) goto L_0x019b
            java.util.Map<java.lang.String, java.lang.Object> r0 = r11.f3359
            if (r0 == 0) goto L_0x0190
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0190
            r0 = 1
            goto L_0x0191
        L_0x0190:
            r0 = 0
        L_0x0191:
            if (r0 != 0) goto L_0x019b
            java.lang.String r0 = "Failed to get new referrer, wait ..."
            com.appsflyer.AFLogger.afDebugLog(r0)
            r0 = 500(0x1f4, float:7.0E-43)
            goto L_0x019c
        L_0x019b:
            r0 = 0
        L_0x019c:
            if (r1 == 0) goto L_0x01b8
            boolean r2 = r11.f3350
            if (r2 == 0) goto L_0x01b8
            java.util.Map<java.lang.String, java.lang.Object> r2 = r11.f3349
            if (r2 == 0) goto L_0x01ae
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x01ae
            r2 = 1
            goto L_0x01af
        L_0x01ae:
            r2 = 0
        L_0x01af:
            if (r2 != 0) goto L_0x01b8
            java.lang.String r0 = "fetching Facebook deferred AppLink data, wait ..."
            com.appsflyer.AFLogger.afDebugLog(r0)
            r0 = 500(0x1f4, float:7.0E-43)
        L_0x01b8:
            if (r1 == 0) goto L_0x01cc
            boolean r1 = r11.f3355
            if (r1 == 0) goto L_0x01cc
            java.util.Map<java.lang.String, java.lang.Object> r1 = r11.f3352
            if (r1 == 0) goto L_0x01c9
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x01c9
            r3 = 1
        L_0x01c9:
            if (r3 != 0) goto L_0x01cc
            goto L_0x01cd
        L_0x01cc:
            r12 = r0
        L_0x01cd:
            boolean r0 = com.appsflyer.internal.C1366f.f3549
            if (r0 == 0) goto L_0x01e9
            java.lang.String r0 = "ESP deeplink: execute launch on SerialExecutor"
            com.appsflyer.AFLogger.afRDLog(r0)
            com.appsflyer.AFExecutor r0 = com.appsflyer.AFExecutor.getInstance()
            java.util.concurrent.ScheduledExecutorService r1 = r0.f3307
            if (r1 != 0) goto L_0x01e6
            java.util.concurrent.ThreadFactory r1 = r0.f3305
            java.util.concurrent.ScheduledExecutorService r1 = java.util.concurrent.Executors.newSingleThreadScheduledExecutor(r1)
            r0.f3307 = r1
        L_0x01e6:
            java.util.concurrent.ScheduledExecutorService r0 = r0.f3307
            goto L_0x01f1
        L_0x01e9:
            com.appsflyer.AFExecutor r0 = com.appsflyer.AFExecutor.getInstance()
            java.util.concurrent.ScheduledThreadPoolExecutor r0 = r0.mo10646()
        L_0x01f1:
            long r1 = (long) r12
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.MILLISECONDS
            m3195(r0, r6, r1, r12)
            return
        L_0x01f8:
            java.lang.String r12 = "Not sending data yet, waiting for dev key"
            com.appsflyer.AFLogger.afDebugLog(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m3220(com.appsflyer.AFEvent):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:135:0x0322 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0335 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0386 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x038c A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x03a8 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03c6 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x03fd A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0411 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x041d A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0425 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0431 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0439 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0445 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0454 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0455 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0470 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x047f A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x048c A[SYNTHETIC, Splitter:B:223:0x048c] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x04a4 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x04b9 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x04c6 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x04cc A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x04e3 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x04fb A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0516 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0544 A[Catch:{ Exception -> 0x033b, Throwable -> 0x02d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0561 A[SYNTHETIC, Splitter:B:261:0x0561] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0581 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0595  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x05a0 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0607  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x0615 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0622 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0630 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x064b A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x0656 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x066b A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x06b8 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x06be A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x06c9 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x06d7 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x06d9 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x06dc A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x06e0 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x0709 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x0727 A[Catch:{ Exception -> 0x072d }] */
    /* JADX WARNING: Removed duplicated region for block: B:416:0x07e1 A[Catch:{ Throwable -> 0x084a }] */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x0876 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x087f A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:439:0x08af A[SYNTHETIC, Splitter:B:439:0x08af] */
    /* JADX WARNING: Removed duplicated region for block: B:451:0x08f3 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:454:0x091e A[ADDED_TO_REGION, Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:460:0x092d A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:463:0x0958 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x097e A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:472:0x09b3 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:473:0x09b5 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:480:0x09d8 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:484:0x09f3 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:485:0x09f4 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:488:0x0a2f A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:510:0x0ba8 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:513:0x0bc2 A[Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570, Throwable -> 0x0c1f }] */
    /* renamed from: ˎ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Object> mo10732(com.appsflyer.AFEvent r29) {
        /*
            r28 = this;
            r1 = r28
            r2 = r29
            java.lang.String r3 = "INSTALL_STORE"
            java.lang.String r4 = "prev_event_name"
            java.lang.String r5 = "preInstallName"
            android.content.Context r6 = r2.f3291
            if (r6 == 0) goto L_0x0011
            android.content.Context r6 = r2.f3291
            goto L_0x001f
        L_0x0011:
            java.lang.ref.WeakReference<android.content.Context> r6 = r2.f3295
            if (r6 == 0) goto L_0x001e
            java.lang.ref.WeakReference<android.content.Context> r6 = r2.f3295
            java.lang.Object r6 = r6.get()
            android.content.Context r6 = (android.content.Context) r6
            goto L_0x001f
        L_0x001e:
            r6 = 0
        L_0x001f:
            java.lang.String r8 = r2.f3290
            java.lang.String r9 = r2.f3302
            org.json.JSONObject r10 = new org.json.JSONObject
            java.util.Map<java.lang.String, java.lang.Object> r11 = r2.f3289
            if (r11 != 0) goto L_0x002f
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            goto L_0x0031
        L_0x002f:
            java.util.Map<java.lang.String, java.lang.Object> r11 = r2.f3289
        L_0x0031:
            r10.<init>(r11)
            java.lang.String r10 = r10.toString()
            java.lang.String r11 = r2.f3298
            android.content.Context r12 = r6.getApplicationContext()
            java.lang.String r13 = "appsflyer-data"
            r14 = 0
            android.content.SharedPreferences r12 = r12.getSharedPreferences(r13, r14)
            boolean r15 = r2.f3294
            android.content.Intent r7 = r29.intent()
            java.lang.String r2 = r2.f3287
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            com.appsflyer.internal.C1336aa.m3270(r6, r14)
            java.util.Date r16 = new java.util.Date
            r16.<init>()
            r18 = r7
            r17 = r8
            long r7 = r16.getTime()
            r16 = r2
            java.lang.String r2 = java.lang.Long.toString(r7)
            r19 = r5
            java.lang.String r5 = "af_timestamp"
            r14.put(r5, r2)
            java.lang.String r2 = com.appsflyer.internal.C1363d.m3316(r6, r7)
            if (r2 == 0) goto L_0x007a
            java.lang.String r7 = "cksm_v1"
            r14.put(r7, r2)
        L_0x007a:
            boolean r2 = r28.isTrackingStopped()     // Catch:{ Throwable -> 0x0c21 }
            if (r2 != 0) goto L_0x0098
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0c21 }
            java.lang.String r7 = "******* sendTrackingWithEvent: "
            r2.<init>(r7)     // Catch:{ Throwable -> 0x0c21 }
            if (r15 == 0) goto L_0x008c
            java.lang.String r7 = "Launch"
            goto L_0x008d
        L_0x008c:
            r7 = r9
        L_0x008d:
            r2.append(r7)     // Catch:{ Throwable -> 0x0c21 }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0c21 }
            com.appsflyer.AFLogger.afInfoLog(r2)     // Catch:{ Throwable -> 0x0c21 }
            goto L_0x009d
        L_0x0098:
            java.lang.String r2 = "SDK tracking has been stopped"
            com.appsflyer.AFLogger.afInfoLog(r2)     // Catch:{ Throwable -> 0x0c21 }
        L_0x009d:
            com.appsflyer.internal.C1396z.m3366()     // Catch:{ Throwable -> 0x0c21 }
            java.io.File r2 = com.appsflyer.internal.C1396z.m3367(r6)     // Catch:{ Exception -> 0x00b2 }
            boolean r2 = r2.exists()     // Catch:{ Exception -> 0x00b2 }
            if (r2 != 0) goto L_0x00b9
            java.io.File r2 = com.appsflyer.internal.C1396z.m3367(r6)     // Catch:{ Exception -> 0x00b2 }
            r2.mkdir()     // Catch:{ Exception -> 0x00b2 }
            goto L_0x00b9
        L_0x00b2:
            java.lang.String r2 = "AppsFlyer_5.1.1"
            java.lang.String r7 = "Could not create cache directory"
            android.util.Log.i(r2, r7)     // Catch:{ Throwable -> 0x0c21 }
        L_0x00b9:
            android.content.pm.PackageManager r2 = r6.getPackageManager()     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r7 = r6.getPackageName()     // Catch:{ Exception -> 0x00f5 }
            r8 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r7, r8)     // Catch:{ Exception -> 0x00f5 }
            java.lang.String[] r2 = r2.requestedPermissions     // Catch:{ Exception -> 0x00f5 }
            java.util.List r2 = java.util.Arrays.asList(r2)     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r7 = "android.permission.INTERNET"
            boolean r7 = r2.contains(r7)     // Catch:{ Exception -> 0x00f5 }
            if (r7 != 0) goto L_0x00da
            java.lang.String r7 = "Permission android.permission.INTERNET is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r7)     // Catch:{ Exception -> 0x00f5 }
        L_0x00da:
            java.lang.String r7 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r7 = r2.contains(r7)     // Catch:{ Exception -> 0x00f5 }
            if (r7 != 0) goto L_0x00e7
            java.lang.String r7 = "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r7)     // Catch:{ Exception -> 0x00f5 }
        L_0x00e7:
            java.lang.String r7 = "android.permission.ACCESS_WIFI_STATE"
            boolean r2 = r2.contains(r7)     // Catch:{ Exception -> 0x00f5 }
            if (r2 != 0) goto L_0x00fc
            java.lang.String r2 = "Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r2)     // Catch:{ Exception -> 0x00f5 }
            goto L_0x00fc
        L_0x00f5:
            r0 = move-exception
            r2 = r0
            java.lang.String r7 = "Exception while validation permissions. "
            com.appsflyer.AFLogger.afErrorLog(r7, r2)     // Catch:{ Throwable -> 0x0c21 }
        L_0x00fc:
            java.lang.String r2 = "af_events_api"
            java.lang.String r7 = "1"
            r14.put(r2, r7)     // Catch:{ Throwable -> 0x0c21 }
            java.lang.String r2 = "brand"
            java.lang.String r7 = android.os.Build.BRAND     // Catch:{ Throwable -> 0x0c21 }
            r14.put(r2, r7)     // Catch:{ Throwable -> 0x0c21 }
            java.lang.String r2 = "device"
            java.lang.String r7 = android.os.Build.DEVICE     // Catch:{ Throwable -> 0x0c21 }
            r14.put(r2, r7)     // Catch:{ Throwable -> 0x0c21 }
            java.lang.String r2 = "product"
            java.lang.String r7 = android.os.Build.PRODUCT     // Catch:{ Throwable -> 0x0c21 }
            r14.put(r2, r7)     // Catch:{ Throwable -> 0x0c21 }
            java.lang.String r2 = "sdk"
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0c21 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ Throwable -> 0x0c21 }
            r14.put(r2, r7)     // Catch:{ Throwable -> 0x0c21 }
            java.lang.String r2 = "model"
            java.lang.String r7 = android.os.Build.MODEL     // Catch:{ Throwable -> 0x0c21 }
            r14.put(r2, r7)     // Catch:{ Throwable -> 0x0c21 }
            java.lang.String r2 = "deviceType"
            java.lang.String r7 = android.os.Build.TYPE     // Catch:{ Throwable -> 0x0c21 }
            r14.put(r2, r7)     // Catch:{ Throwable -> 0x0c21 }
            m3193(r6, r14)     // Catch:{ Throwable -> 0x0c21 }
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0c21 }
            java.lang.String r7 = "appsFlyerCount"
            r20 = r9
            r8 = 1
            if (r15 == 0) goto L_0x025b
            android.content.Context r4 = r6.getApplicationContext()     // Catch:{ Throwable -> 0x0c21 }
            r9 = 0
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r13, r9)     // Catch:{ Throwable -> 0x0c21 }
            boolean r4 = r4.contains(r7)     // Catch:{ Throwable -> 0x0c21 }
            r4 = r4 ^ r8
            if (r4 == 0) goto L_0x0199
            boolean r4 = r2.isOtherSdkStringDisabled()     // Catch:{ Throwable -> 0x0c21 }
            if (r4 != 0) goto L_0x0162
            float r4 = m3179(r6)     // Catch:{ Throwable -> 0x0c21 }
            java.lang.String r9 = "batteryLevel"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Throwable -> 0x0c21 }
            r14.put(r9, r4)     // Catch:{ Throwable -> 0x0c21 }
        L_0x0162:
            m3211(r6)     // Catch:{ Throwable -> 0x0c21 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0c21 }
            r9 = 23
            if (r4 < r9) goto L_0x0174
            java.lang.Class<android.app.UiModeManager> r4 = android.app.UiModeManager.class
            java.lang.Object r4 = r6.getSystemService(r4)     // Catch:{ Throwable -> 0x0c21 }
            android.app.UiModeManager r4 = (android.app.UiModeManager) r4     // Catch:{ Throwable -> 0x0c21 }
            goto L_0x017c
        L_0x0174:
            java.lang.String r4 = "uimode"
            java.lang.Object r4 = r6.getSystemService(r4)     // Catch:{ Throwable -> 0x0c21 }
            android.app.UiModeManager r4 = (android.app.UiModeManager) r4     // Catch:{ Throwable -> 0x0c21 }
        L_0x017c:
            if (r4 == 0) goto L_0x018c
            int r4 = r4.getCurrentModeType()     // Catch:{ Throwable -> 0x0c21 }
            r9 = 4
            if (r4 != r9) goto L_0x018c
            java.lang.String r4 = "tv"
            java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ Throwable -> 0x0c21 }
            r14.put(r4, r9)     // Catch:{ Throwable -> 0x0c21 }
        L_0x018c:
            boolean r4 = com.appsflyer.internal.instant.AFInstantApps.isInstantApp(r6)     // Catch:{ Throwable -> 0x0c21 }
            if (r4 == 0) goto L_0x0199
            java.lang.String r4 = "inst_app"
            java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ Throwable -> 0x0c21 }
            r14.put(r4, r9)     // Catch:{ Throwable -> 0x0c21 }
        L_0x0199:
            java.lang.String r4 = "timepassedsincelastlaunch"
            android.content.Context r9 = r6.getApplicationContext()     // Catch:{ Throwable -> 0x0c21 }
            r8 = 0
            android.content.SharedPreferences r9 = r9.getSharedPreferences(r13, r8)     // Catch:{ Throwable -> 0x0c21 }
            java.lang.String r8 = "AppsFlyerTimePassedSincePrevLaunch"
            r24 = r2
            r23 = r3
            r2 = 0
            long r8 = r9.getLong(r8, r2)     // Catch:{ Throwable -> 0x0c21 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0c21 }
            r25 = r5
            java.lang.String r5 = "AppsFlyerTimePassedSincePrevLaunch"
            m3191(r6, r5, r2)     // Catch:{ Throwable -> 0x0c21 }
            r21 = 0
            int r5 = (r8 > r21 ? 1 : (r8 == r21 ? 0 : -1))
            if (r5 <= 0) goto L_0x01c6
            long r2 = r2 - r8
            r8 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r8
            goto L_0x01c8
        L_0x01c6:
            r2 = -1
        L_0x01c8:
            java.lang.String r2 = java.lang.Long.toString(r2)     // Catch:{ Throwable -> 0x0c21 }
            r14.put(r4, r2)     // Catch:{ Throwable -> 0x0c21 }
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0c21 }
            java.lang.String r3 = "oneLinkSlug"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Throwable -> 0x0c21 }
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0c21 }
            java.lang.String r4 = "onelinkVersion"
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Throwable -> 0x0c21 }
            if (r2 == 0) goto L_0x01ea
            java.lang.String r4 = "onelink_id"
            r14.put(r4, r2)     // Catch:{ Throwable -> 0x0c21 }
        L_0x01ea:
            if (r3 == 0) goto L_0x01f1
            java.lang.String r2 = "onelink_ver"
            r14.put(r2, r3)     // Catch:{ Throwable -> 0x0c21 }
        L_0x01f1:
            java.lang.String r2 = "appsflyerGetConversionDataTiming"
            r3 = 0
            long r8 = r12.getLong(r2, r3)     // Catch:{ Throwable -> 0x0c21 }
            int r2 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x0214
            java.lang.String r2 = "gcd_timing"
            java.lang.String r3 = java.lang.Long.toString(r8)     // Catch:{ Throwable -> 0x0c21 }
            r14.put(r2, r3)     // Catch:{ Throwable -> 0x0c21 }
            java.lang.String r2 = "appsflyerGetConversionDataTiming"
            android.content.SharedPreferences$Editor r3 = r12.edit()     // Catch:{ Throwable -> 0x0c21 }
            r4 = 0
            r3.putLong(r2, r4)     // Catch:{ Throwable -> 0x0c21 }
            r3.apply()     // Catch:{ Throwable -> 0x0c21 }
        L_0x0214:
            java.lang.String r2 = r1.f3354     // Catch:{ Throwable -> 0x0c21 }
            if (r2 == 0) goto L_0x021f
            java.lang.String r2 = "phone"
            java.lang.String r3 = r1.f3354     // Catch:{ Throwable -> 0x0c21 }
            r14.put(r2, r3)     // Catch:{ Throwable -> 0x0c21 }
        L_0x021f:
            boolean r2 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Throwable -> 0x0c21 }
            if (r2 != 0) goto L_0x022a
            java.lang.String r2 = "referrer"
            r14.put(r2, r11)     // Catch:{ Throwable -> 0x0c21 }
        L_0x022a:
            java.lang.String r2 = "extraReferrers"
            r3 = 0
            java.lang.String r2 = r12.getString(r2, r3)     // Catch:{ Throwable -> 0x0c21 }
            if (r2 == 0) goto L_0x0238
            java.lang.String r3 = "extraReferrers"
            r14.put(r3, r2)     // Catch:{ Throwable -> 0x0c21 }
        L_0x0238:
            r2 = r24
            java.lang.String r3 = r2.getReferrer(r6)     // Catch:{ Throwable -> 0x0c21 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Throwable -> 0x0c21 }
            if (r4 != 0) goto L_0x0251
            java.lang.String r4 = "referrer"
            java.lang.Object r4 = r14.get(r4)     // Catch:{ Throwable -> 0x0c21 }
            if (r4 != 0) goto L_0x0251
            java.lang.String r4 = "referrer"
            r14.put(r4, r3)     // Catch:{ Throwable -> 0x0c21 }
        L_0x0251:
            r27 = r2
            r26 = r12
            r24 = r15
            r1 = r20
            goto L_0x02ea
        L_0x025b:
            r23 = r3
            r25 = r5
            android.content.Context r3 = r6.getApplicationContext()     // Catch:{ Throwable -> 0x0c21 }
            r5 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r13, r5)     // Catch:{ Throwable -> 0x0c21 }
            android.content.SharedPreferences$Editor r5 = r3.edit()     // Catch:{ Throwable -> 0x0c21 }
            r8 = 0
            java.lang.String r9 = r3.getString(r4, r8)     // Catch:{ Exception -> 0x02db }
            java.lang.String r8 = "prev_event_timestamp"
            java.lang.String r11 = "prev_event_value"
            if (r9 == 0) goto L_0x02bb
            r24 = r15
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x02b2 }
            r15.<init>()     // Catch:{ Exception -> 0x02b2 }
            r26 = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ae }
            r12.<init>()     // Catch:{ Exception -> 0x02ae }
            r27 = r2
            r1 = -1
            long r1 = r3.getLong(r8, r1)     // Catch:{ Exception -> 0x02ac }
            r12.append(r1)     // Catch:{ Exception -> 0x02ac }
            java.lang.String r1 = r12.toString()     // Catch:{ Exception -> 0x02ac }
            r15.put(r8, r1)     // Catch:{ Exception -> 0x02ac }
            r1 = 0
            java.lang.String r2 = r3.getString(r11, r1)     // Catch:{ Exception -> 0x02ac }
            r15.put(r11, r2)     // Catch:{ Exception -> 0x02ac }
            r15.put(r4, r9)     // Catch:{ Exception -> 0x02ac }
            java.lang.String r1 = "prev_event"
            java.lang.String r2 = r15.toString()     // Catch:{ Exception -> 0x02ac }
            r14.put(r1, r2)     // Catch:{ Exception -> 0x02ac }
            goto L_0x02c1
        L_0x02ac:
            r0 = move-exception
            goto L_0x02b7
        L_0x02ae:
            r0 = move-exception
            r27 = r2
            goto L_0x02b7
        L_0x02b2:
            r0 = move-exception
            r27 = r2
            r26 = r12
        L_0x02b7:
            r2 = r0
            r1 = r20
            goto L_0x02e5
        L_0x02bb:
            r27 = r2
            r26 = r12
            r24 = r15
        L_0x02c1:
            r1 = r20
            r5.putString(r4, r1)     // Catch:{ Exception -> 0x02d4 }
            r5.putString(r11, r10)     // Catch:{ Exception -> 0x02d4 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02d4 }
            r5.putLong(r8, r2)     // Catch:{ Exception -> 0x02d4 }
            r5.apply()     // Catch:{ Exception -> 0x02d4 }
            goto L_0x02ea
        L_0x02d4:
            r0 = move-exception
            goto L_0x02e4
        L_0x02d6:
            r0 = move-exception
            r4 = r28
            goto L_0x0c23
        L_0x02db:
            r0 = move-exception
            r27 = r2
            r26 = r12
            r24 = r15
            r1 = r20
        L_0x02e4:
            r2 = r0
        L_0x02e5:
            java.lang.String r3 = "Error while processing previous event."
            com.appsflyer.AFLogger.afErrorLog(r3, r2)     // Catch:{ Throwable -> 0x02d6 }
        L_0x02ea:
            java.lang.String r2 = "KSAppsFlyerId"
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r2 = r3.getString(r2)     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r3 = "KSAppsFlyerRICounter"
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r3 = r4.getString(r3)     // Catch:{ Throwable -> 0x02d6 }
            if (r2 == 0) goto L_0x0316
            if (r3 == 0) goto L_0x0316
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ Throwable -> 0x02d6 }
            int r4 = r4.intValue()     // Catch:{ Throwable -> 0x02d6 }
            if (r4 <= 0) goto L_0x0316
            java.lang.String r4 = "reinstallCounter"
            r14.put(r4, r3)     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r3 = "originalAppsflyerId"
            r14.put(r3, r2)     // Catch:{ Throwable -> 0x02d6 }
        L_0x0316:
            java.lang.String r2 = "additionalCustomData"
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r2 = r3.getString(r2)     // Catch:{ Throwable -> 0x02d6 }
            if (r2 == 0) goto L_0x0327
            java.lang.String r3 = "customData"
            r14.put(r3, r2)     // Catch:{ Throwable -> 0x02d6 }
        L_0x0327:
            android.content.pm.PackageManager r2 = r6.getPackageManager()     // Catch:{ Exception -> 0x033b }
            java.lang.String r3 = r6.getPackageName()     // Catch:{ Exception -> 0x033b }
            java.lang.String r2 = r2.getInstallerPackageName(r3)     // Catch:{ Exception -> 0x033b }
            if (r2 == 0) goto L_0x0342
            java.lang.String r3 = "installer_package"
            r14.put(r3, r2)     // Catch:{ Exception -> 0x033b }
            goto L_0x0342
        L_0x033b:
            r0 = move-exception
            r2 = r0
            java.lang.String r3 = "Exception while getting the app's installer package. "
            com.appsflyer.AFLogger.afErrorLog(r3, r2)     // Catch:{ Throwable -> 0x02d6 }
        L_0x0342:
            java.lang.String r2 = "sdkExtension"
            r3 = r27
            java.lang.String r2 = r3.getString(r2)     // Catch:{ Throwable -> 0x02d6 }
            if (r2 == 0) goto L_0x0357
            int r4 = r2.length()     // Catch:{ Throwable -> 0x02d6 }
            if (r4 <= 0) goto L_0x0357
            java.lang.String r4 = "sdkExtension"
            r14.put(r4, r2)     // Catch:{ Throwable -> 0x02d6 }
        L_0x0357:
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch:{ Throwable -> 0x02d6 }
            r2.<init>(r6)     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r2 = m3227(r2)     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r4 = m3199(r6, r2)     // Catch:{ Throwable -> 0x02d6 }
            if (r4 == 0) goto L_0x036c
            boolean r5 = r4.equals(r2)     // Catch:{ Throwable -> 0x02d6 }
            if (r5 == 0) goto L_0x0370
        L_0x036c:
            if (r4 != 0) goto L_0x0375
            if (r2 == 0) goto L_0x0375
        L_0x0370:
            java.lang.String r4 = "af_latestchannel"
            r14.put(r4, r2)     // Catch:{ Throwable -> 0x02d6 }
        L_0x0375:
            android.content.Context r2 = r6.getApplicationContext()     // Catch:{ Throwable -> 0x02d6 }
            r4 = 0
            android.content.SharedPreferences r2 = r2.getSharedPreferences(r13, r4)     // Catch:{ Throwable -> 0x02d6 }
            r4 = r23
            boolean r5 = r2.contains(r4)     // Catch:{ Throwable -> 0x02d6 }
            if (r5 == 0) goto L_0x038c
            r5 = 0
            java.lang.String r2 = r2.getString(r4, r5)     // Catch:{ Throwable -> 0x02d6 }
            goto L_0x03a6
        L_0x038c:
            android.content.Context r2 = r6.getApplicationContext()     // Catch:{ Throwable -> 0x02d6 }
            r5 = 0
            android.content.SharedPreferences r2 = r2.getSharedPreferences(r13, r5)     // Catch:{ Throwable -> 0x02d6 }
            boolean r2 = r2.contains(r7)     // Catch:{ Throwable -> 0x02d6 }
            r5 = 1
            r2 = r2 ^ r5
            if (r2 == 0) goto L_0x03a2
            java.lang.String r2 = m3182(r6)     // Catch:{ Throwable -> 0x02d6 }
            goto L_0x03a3
        L_0x03a2:
            r2 = 0
        L_0x03a3:
            m3219(r6, r4, r2)     // Catch:{ Throwable -> 0x02d6 }
        L_0x03a6:
            if (r2 == 0) goto L_0x03b1
            java.lang.String r4 = "af_installstore"
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ Throwable -> 0x02d6 }
            r14.put(r4, r2)     // Catch:{ Throwable -> 0x02d6 }
        L_0x03b1:
            android.content.Context r2 = r6.getApplicationContext()     // Catch:{ Throwable -> 0x02d6 }
            r4 = 0
            android.content.SharedPreferences r2 = r2.getSharedPreferences(r13, r4)     // Catch:{ Throwable -> 0x02d6 }
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x02d6 }
            r5 = r19
            java.lang.String r4 = r4.getString(r5)     // Catch:{ Throwable -> 0x02d6 }
            if (r4 != 0) goto L_0x046e
            boolean r8 = r2.contains(r5)     // Catch:{ Throwable -> 0x02d6 }
            if (r8 == 0) goto L_0x03d4
            r4 = 0
            java.lang.String r2 = r2.getString(r5, r4)     // Catch:{ Throwable -> 0x02d6 }
            r4 = r2
            goto L_0x0465
        L_0x03d4:
            android.content.Context r2 = r6.getApplicationContext()     // Catch:{ Throwable -> 0x02d6 }
            r8 = 0
            android.content.SharedPreferences r2 = r2.getSharedPreferences(r13, r8)     // Catch:{ Throwable -> 0x02d6 }
            boolean r2 = r2.contains(r7)     // Catch:{ Throwable -> 0x02d6 }
            r8 = 1
            r2 = r2 ^ r8
            if (r2 == 0) goto L_0x0460
            java.lang.String r2 = "ro.appsflyer.preinstall.path"
            java.lang.String r2 = m3208(r2)     // Catch:{ Throwable -> 0x02d6 }
            java.io.File r2 = m3180(r2)     // Catch:{ Throwable -> 0x02d6 }
            if (r2 == 0) goto L_0x03fa
            boolean r4 = r2.exists()     // Catch:{ Throwable -> 0x02d6 }
            if (r4 != 0) goto L_0x03f8
            goto L_0x03fa
        L_0x03f8:
            r4 = 0
            goto L_0x03fb
        L_0x03fa:
            r4 = 1
        L_0x03fb:
            if (r4 == 0) goto L_0x040f
            java.lang.String r2 = "AF_PRE_INSTALL_PATH"
            android.content.pm.PackageManager r4 = r6.getPackageManager()     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r8 = r6.getPackageName()     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r2 = m3209(r2, r4, r8)     // Catch:{ Throwable -> 0x02d6 }
            java.io.File r2 = m3180(r2)     // Catch:{ Throwable -> 0x02d6 }
        L_0x040f:
            if (r2 == 0) goto L_0x041a
            boolean r4 = r2.exists()     // Catch:{ Throwable -> 0x02d6 }
            if (r4 != 0) goto L_0x0418
            goto L_0x041a
        L_0x0418:
            r4 = 0
            goto L_0x041b
        L_0x041a:
            r4 = 1
        L_0x041b:
            if (r4 == 0) goto L_0x0423
            java.lang.String r2 = "/data/local/tmp/pre_install.appsflyer"
            java.io.File r2 = m3180(r2)     // Catch:{ Throwable -> 0x02d6 }
        L_0x0423:
            if (r2 == 0) goto L_0x042e
            boolean r4 = r2.exists()     // Catch:{ Throwable -> 0x02d6 }
            if (r4 != 0) goto L_0x042c
            goto L_0x042e
        L_0x042c:
            r4 = 0
            goto L_0x042f
        L_0x042e:
            r4 = 1
        L_0x042f:
            if (r4 == 0) goto L_0x0437
            java.lang.String r2 = "/etc/pre_install.appsflyer"
            java.io.File r2 = m3180(r2)     // Catch:{ Throwable -> 0x02d6 }
        L_0x0437:
            if (r2 == 0) goto L_0x0442
            boolean r4 = r2.exists()     // Catch:{ Throwable -> 0x02d6 }
            if (r4 != 0) goto L_0x0440
            goto L_0x0442
        L_0x0440:
            r4 = 0
            goto L_0x0443
        L_0x0442:
            r4 = 1
        L_0x0443:
            if (r4 != 0) goto L_0x0451
            java.lang.String r4 = r6.getPackageName()     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r2 = m3207(r2, r4)     // Catch:{ Throwable -> 0x02d6 }
            if (r2 == 0) goto L_0x0451
            r4 = r2
            goto L_0x0452
        L_0x0451:
            r4 = 0
        L_0x0452:
            if (r4 == 0) goto L_0x0455
            goto L_0x0460
        L_0x0455:
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch:{ Throwable -> 0x02d6 }
            r2.<init>(r6)     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r4 = "AF_PRE_INSTALL_NAME"
            java.lang.String r4 = m3210(r2, r4)     // Catch:{ Throwable -> 0x02d6 }
        L_0x0460:
            if (r4 == 0) goto L_0x0465
            m3219(r6, r5, r4)     // Catch:{ Throwable -> 0x02d6 }
        L_0x0465:
            if (r4 == 0) goto L_0x046e
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x02d6 }
            r2.set(r5, r4)     // Catch:{ Throwable -> 0x02d6 }
        L_0x046e:
            if (r4 == 0) goto L_0x0479
            java.lang.String r2 = "af_preinstall_name"
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ Throwable -> 0x02d6 }
            r14.put(r2, r4)     // Catch:{ Throwable -> 0x02d6 }
        L_0x0479:
            java.lang.String r2 = m3182(r6)     // Catch:{ Throwable -> 0x02d6 }
            if (r2 == 0) goto L_0x0488
            java.lang.String r4 = "af_currentstore"
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ Throwable -> 0x02d6 }
            r14.put(r4, r2)     // Catch:{ Throwable -> 0x02d6 }
        L_0x0488:
            java.lang.String r2 = "appsflyerKey"
            if (r17 == 0) goto L_0x0498
            int r4 = r17.length()     // Catch:{ Throwable -> 0x02d6 }
            if (r4 <= 0) goto L_0x0498
            r4 = r17
            r14.put(r2, r4)     // Catch:{ Throwable -> 0x02d6 }
            goto L_0x04ad
        L_0x0498:
            java.lang.String r4 = "AppsFlyerKey"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Throwable -> 0x02d6 }
            if (r4 == 0) goto L_0x0c11
            int r5 = r4.length()     // Catch:{ Throwable -> 0x02d6 }
            if (r5 <= 0) goto L_0x0c11
            r14.put(r2, r4)     // Catch:{ Throwable -> 0x02d6 }
        L_0x04ad:
            java.lang.String r4 = "AppUserId"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Throwable -> 0x02d6 }
            if (r4 == 0) goto L_0x04be
            java.lang.String r5 = "appUserId"
            r14.put(r5, r4)     // Catch:{ Throwable -> 0x02d6 }
        L_0x04be:
            java.lang.String r4 = "userEmails"
            java.lang.String r4 = r3.getString(r4)     // Catch:{ Throwable -> 0x02d6 }
            if (r4 == 0) goto L_0x04cc
            java.lang.String r5 = "user_emails"
            r14.put(r5, r4)     // Catch:{ Throwable -> 0x02d6 }
            goto L_0x04e1
        L_0x04cc:
            java.lang.String r4 = "userEmail"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Throwable -> 0x02d6 }
            if (r4 == 0) goto L_0x04e1
            java.lang.String r5 = "sha1_el"
            java.lang.String r4 = com.appsflyer.internal.C1346af.m3282(r4)     // Catch:{ Throwable -> 0x02d6 }
            r14.put(r5, r4)     // Catch:{ Throwable -> 0x02d6 }
        L_0x04e1:
            if (r1 == 0) goto L_0x04ef
            java.lang.String r4 = "eventName"
            r14.put(r4, r1)     // Catch:{ Throwable -> 0x02d6 }
            if (r10 == 0) goto L_0x04ef
            java.lang.String r4 = "eventValue"
            r14.put(r4, r10)     // Catch:{ Throwable -> 0x02d6 }
        L_0x04ef:
            java.lang.String r4 = "appid"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Throwable -> 0x02d6 }
            if (r4 == 0) goto L_0x050a
            java.lang.String r4 = "appid"
            java.lang.String r5 = "appid"
            com.appsflyer.AppsFlyerProperties r8 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r5 = r8.getString(r5)     // Catch:{ Throwable -> 0x02d6 }
            r14.put(r4, r5)     // Catch:{ Throwable -> 0x02d6 }
        L_0x050a:
            java.lang.String r4 = "currencyCode"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Throwable -> 0x02d6 }
            if (r4 == 0) goto L_0x0538
            int r5 = r4.length()     // Catch:{ Throwable -> 0x02d6 }
            r8 = 3
            if (r5 == r8) goto L_0x0533
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r8 = "WARNING: currency code should be 3 characters!!! '"
            r5.<init>(r8)     // Catch:{ Throwable -> 0x02d6 }
            r5.append(r4)     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r8 = "' is not a legal value."
            r5.append(r8)     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x02d6 }
            com.appsflyer.AFLogger.afWarnLog(r5)     // Catch:{ Throwable -> 0x02d6 }
        L_0x0533:
            java.lang.String r5 = "currency"
            r14.put(r5, r4)     // Catch:{ Throwable -> 0x02d6 }
        L_0x0538:
            java.lang.String r4 = "IS_UPDATE"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x02d6 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Throwable -> 0x02d6 }
            if (r4 == 0) goto L_0x0549
            java.lang.String r5 = "isUpdate"
            r14.put(r5, r4)     // Catch:{ Throwable -> 0x02d6 }
        L_0x0549:
            r4 = r28
            boolean r5 = r4.isPreInstalledApp(r6)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r8 = "af_preinstalled"
            java.lang.String r5 = java.lang.Boolean.toString(r5)     // Catch:{ Throwable -> 0x0c1f }
            r14.put(r8, r5)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r5 = "collectFacebookAttrId"
            r8 = 1
            boolean r5 = r3.getBoolean(r5, r8)     // Catch:{ Throwable -> 0x0c1f }
            if (r5 == 0) goto L_0x0586
            android.content.pm.PackageManager r5 = r6.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570 }
            java.lang.String r8 = "com.facebook.katana"
            r9 = 0
            r5.getApplicationInfo(r8, r9)     // Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570 }
            java.lang.String r5 = r4.getAttributionId(r6)     // Catch:{ NameNotFoundException -> 0x0579, Throwable -> 0x0570 }
            goto L_0x057f
        L_0x0570:
            r0 = move-exception
            r5 = r0
            java.lang.String r8 = "Exception while collecting facebook's attribution ID. "
            com.appsflyer.AFLogger.afErrorLog(r8, r5)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0577:
            r5 = 0
            goto L_0x057f
        L_0x0579:
            java.lang.String r5 = "Exception while collecting facebook's attribution ID. "
            com.appsflyer.AFLogger.afWarnLog(r5)     // Catch:{ Throwable -> 0x0c1f }
            goto L_0x0577
        L_0x057f:
            if (r5 == 0) goto L_0x0586
            java.lang.String r8 = "fb"
            r14.put(r8, r5)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0586:
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r8 = "deviceTrackingDisabled"
            r9 = 0
            boolean r8 = r5.getBoolean(r8, r9)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r9 = "true"
            if (r8 == 0) goto L_0x05a0
            java.lang.String r5 = "deviceTrackingDisabled"
            r14.put(r5, r9)     // Catch:{ Throwable -> 0x0c1f }
            r17 = r2
            r27 = r3
            goto L_0x071c
        L_0x05a0:
            android.content.Context r8 = r6.getApplicationContext()     // Catch:{ Throwable -> 0x0c1f }
            r10 = 0
            android.content.SharedPreferences r8 = r8.getSharedPreferences(r13, r10)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r10 = "collectIMEI"
            r11 = 1
            boolean r10 = r5.getBoolean(r10, r11)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r11 = "imeiCached"
            r12 = 0
            java.lang.String r11 = r8.getString(r11, r12)     // Catch:{ Throwable -> 0x0c1f }
            if (r10 == 0) goto L_0x063c
            java.lang.String r10 = r4.f3353     // Catch:{ Throwable -> 0x0c1f }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Throwable -> 0x0c1f }
            if (r10 == 0) goto L_0x063c
            boolean r10 = m3241(r6)     // Catch:{ Throwable -> 0x0c1f }
            if (r10 == 0) goto L_0x0637
            java.lang.String r10 = "phone"
            java.lang.Object r10 = r6.getSystemService(r10)     // Catch:{ InvocationTargetException -> 0x061c, Exception -> 0x05ff }
            android.telephony.TelephonyManager r10 = (android.telephony.TelephonyManager) r10     // Catch:{ InvocationTargetException -> 0x061c, Exception -> 0x05ff }
            java.lang.Class r12 = r10.getClass()     // Catch:{ InvocationTargetException -> 0x061c, Exception -> 0x05ff }
            java.lang.String r15 = "getDeviceId"
            r17 = r2
            r27 = r3
            r2 = 0
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ InvocationTargetException -> 0x05fd, Exception -> 0x05fb }
            java.lang.reflect.Method r3 = r12.getMethod(r15, r3)     // Catch:{ InvocationTargetException -> 0x05fd, Exception -> 0x05fb }
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch:{ InvocationTargetException -> 0x05fd, Exception -> 0x05fb }
            java.lang.Object r2 = r3.invoke(r10, r12)     // Catch:{ InvocationTargetException -> 0x05fd, Exception -> 0x05fb }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ InvocationTargetException -> 0x05fd, Exception -> 0x05fb }
            if (r2 == 0) goto L_0x05eb
            goto L_0x0646
        L_0x05eb:
            if (r11 == 0) goto L_0x0648
            java.lang.String r2 = "use cached IMEI: "
            java.lang.String r3 = java.lang.String.valueOf(r11)     // Catch:{ InvocationTargetException -> 0x05fd, Exception -> 0x05fb }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ InvocationTargetException -> 0x05fd, Exception -> 0x05fb }
            com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ InvocationTargetException -> 0x05fd, Exception -> 0x05fb }
            goto L_0x0649
        L_0x05fb:
            r0 = move-exception
            goto L_0x0604
        L_0x05fd:
            goto L_0x0620
        L_0x05ff:
            r0 = move-exception
            r17 = r2
            r27 = r3
        L_0x0604:
            r2 = r0
            if (r11 == 0) goto L_0x0615
            java.lang.String r3 = "use cached IMEI: "
            java.lang.String r10 = java.lang.String.valueOf(r11)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r3 = r3.concat(r10)     // Catch:{ Throwable -> 0x0c1f }
            com.appsflyer.AFLogger.afDebugLog(r3)     // Catch:{ Throwable -> 0x0c1f }
            goto L_0x0616
        L_0x0615:
            r11 = 0
        L_0x0616:
            java.lang.String r3 = "WARNING: other reason: "
            com.appsflyer.AFLogger.afErrorLog(r3, r2)     // Catch:{ Throwable -> 0x0c1f }
            goto L_0x0649
        L_0x061c:
            r17 = r2
            r27 = r3
        L_0x0620:
            if (r11 == 0) goto L_0x0630
            java.lang.String r2 = "use cached IMEI: "
            java.lang.String r3 = java.lang.String.valueOf(r11)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ Throwable -> 0x0c1f }
            com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ Throwable -> 0x0c1f }
            goto L_0x0631
        L_0x0630:
            r11 = 0
        L_0x0631:
            java.lang.String r2 = "WARNING: READ_PHONE_STATE is missing."
            com.appsflyer.AFLogger.afWarnLog(r2)     // Catch:{ Throwable -> 0x0c1f }
            goto L_0x0649
        L_0x0637:
            r17 = r2
            r27 = r3
            goto L_0x0648
        L_0x063c:
            r17 = r2
            r27 = r3
            java.lang.String r2 = r4.f3353     // Catch:{ Throwable -> 0x0c1f }
            if (r2 == 0) goto L_0x0648
            java.lang.String r2 = r4.f3353     // Catch:{ Throwable -> 0x0c1f }
        L_0x0646:
            r11 = r2
            goto L_0x0649
        L_0x0648:
            r11 = 0
        L_0x0649:
            if (r11 == 0) goto L_0x0656
            java.lang.String r2 = "imeiCached"
            m3219(r6, r2, r11)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "imei"
            r14.put(r2, r11)     // Catch:{ Throwable -> 0x0c1f }
            goto L_0x065b
        L_0x0656:
            java.lang.String r2 = "IMEI was not collected."
            com.appsflyer.AFLogger.afInfoLog(r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x065b:
            java.lang.String r2 = "collectAndroidId"
            r3 = 1
            boolean r2 = r5.getBoolean(r2, r3)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r3 = "androidIdCached"
            r10 = 0
            java.lang.String r3 = r8.getString(r3, r10)     // Catch:{ Throwable -> 0x0c1f }
            if (r2 == 0) goto L_0x06b4
            java.lang.String r2 = r4.f3357     // Catch:{ Throwable -> 0x0c1f }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x0c1f }
            if (r2 == 0) goto L_0x06b4
            boolean r2 = m3241(r6)     // Catch:{ Throwable -> 0x0c1f }
            if (r2 == 0) goto L_0x06bb
            android.content.ContentResolver r2 = r6.getContentResolver()     // Catch:{ Exception -> 0x0698 }
            java.lang.String r8 = "android_id"
            java.lang.String r2 = android.provider.Settings.Secure.getString(r2, r8)     // Catch:{ Exception -> 0x0698 }
            if (r2 == 0) goto L_0x0686
            goto L_0x06bc
        L_0x0686:
            if (r3 == 0) goto L_0x0696
            java.lang.String r2 = "use cached AndroidId: "
            java.lang.String r8 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0698 }
            java.lang.String r2 = r2.concat(r8)     // Catch:{ Exception -> 0x0698 }
            com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ Exception -> 0x0698 }
            goto L_0x06b2
        L_0x0696:
            r3 = 0
            goto L_0x06b2
        L_0x0698:
            r0 = move-exception
            r2 = r0
            if (r3 == 0) goto L_0x06aa
            java.lang.String r8 = "use cached AndroidId: "
            java.lang.String r10 = java.lang.String.valueOf(r3)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r8 = r8.concat(r10)     // Catch:{ Throwable -> 0x0c1f }
            com.appsflyer.AFLogger.afDebugLog(r8)     // Catch:{ Throwable -> 0x0c1f }
            goto L_0x06ab
        L_0x06aa:
            r3 = 0
        L_0x06ab:
            java.lang.String r8 = r2.getMessage()     // Catch:{ Throwable -> 0x0c1f }
            com.appsflyer.AFLogger.afErrorLog(r8, r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x06b2:
            r2 = r3
            goto L_0x06bc
        L_0x06b4:
            java.lang.String r2 = r4.f3357     // Catch:{ Throwable -> 0x0c1f }
            if (r2 == 0) goto L_0x06bb
            java.lang.String r2 = r4.f3357     // Catch:{ Throwable -> 0x0c1f }
            goto L_0x06bc
        L_0x06bb:
            r2 = 0
        L_0x06bc:
            if (r2 == 0) goto L_0x06c9
            java.lang.String r3 = "androidIdCached"
            m3219(r6, r3, r2)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r3 = "android_id"
            r14.put(r3, r2)     // Catch:{ Throwable -> 0x0c1f }
            goto L_0x06ce
        L_0x06c9:
            java.lang.String r2 = "Android ID was not collected."
            com.appsflyer.AFLogger.afInfoLog(r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x06ce:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Throwable -> 0x0c1f }
            r2.<init>()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r3 = r4.f3356     // Catch:{ Throwable -> 0x0c1f }
            if (r3 == 0) goto L_0x06d9
            r3 = 1
            goto L_0x06da
        L_0x06d9:
            r3 = 0
        L_0x06da:
            if (r3 == 0) goto L_0x06e0
            java.lang.String r5 = r4.f3356     // Catch:{ Throwable -> 0x0c1f }
            r8 = r5
            goto L_0x0707
        L_0x06e0:
            java.lang.String r8 = "collectOAID"
            r10 = 0
            boolean r5 = r5.getBoolean(r8, r10)     // Catch:{ Throwable -> 0x0c1f }
            if (r5 == 0) goto L_0x0706
            com.appsflyer.OaidClient$Info r5 = com.appsflyer.OaidClient.fetch(r6)     // Catch:{ Throwable -> 0x06ff }
            if (r5 == 0) goto L_0x0706
            java.lang.String r8 = r5.getId()     // Catch:{ Throwable -> 0x06ff }
            java.lang.Boolean r5 = r5.isLat()     // Catch:{ Throwable -> 0x0700 }
            if (r5 == 0) goto L_0x0707
            java.lang.String r10 = "isLat"
            r2.put(r10, r5)     // Catch:{ Throwable -> 0x0700 }
            goto L_0x0707
        L_0x06ff:
            r8 = 0
        L_0x0700:
            java.lang.String r5 = "No OAID library"
            com.appsflyer.AFLogger.afDebugLog(r5)     // Catch:{ Throwable -> 0x0c1f }
            goto L_0x0707
        L_0x0706:
            r8 = 0
        L_0x0707:
            if (r8 == 0) goto L_0x071c
            java.lang.String r5 = "isManual"
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Throwable -> 0x0c1f }
            r2.put(r5, r3)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r3 = "val"
            r2.put(r3, r8)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r3 = "oaid"
            r14.put(r3, r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x071c:
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x072d }
            r2.<init>(r6)     // Catch:{ Exception -> 0x072d }
            java.lang.String r2 = com.appsflyer.internal.C1347ag.m3284(r2)     // Catch:{ Exception -> 0x072d }
            if (r2 == 0) goto L_0x0744
            java.lang.String r3 = "uid"
            r14.put(r3, r2)     // Catch:{ Exception -> 0x072d }
            goto L_0x0744
        L_0x072d:
            r0 = move-exception
            r2 = r0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r5 = "ERROR: could not get uid "
            r3.<init>(r5)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r5 = r2.getMessage()     // Catch:{ Throwable -> 0x0c1f }
            r3.append(r5)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x0c1f }
            com.appsflyer.AFLogger.afErrorLog(r3, r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0744:
            java.lang.String r2 = "lang"
            java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0752 }
            java.lang.String r3 = r3.getDisplayLanguage()     // Catch:{ Exception -> 0x0752 }
            r14.put(r2, r3)     // Catch:{ Exception -> 0x0752 }
            goto L_0x0759
        L_0x0752:
            r0 = move-exception
            r2 = r0
            java.lang.String r3 = "Exception while collecting display language name. "
            com.appsflyer.AFLogger.afErrorLog(r3, r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0759:
            java.lang.String r2 = "lang_code"
            java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0767 }
            java.lang.String r3 = r3.getLanguage()     // Catch:{ Exception -> 0x0767 }
            r14.put(r2, r3)     // Catch:{ Exception -> 0x0767 }
            goto L_0x076e
        L_0x0767:
            r0 = move-exception
            r2 = r0
            java.lang.String r3 = "Exception while collecting display language code. "
            com.appsflyer.AFLogger.afErrorLog(r3, r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x076e:
            java.lang.String r2 = "country"
            java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x077c }
            java.lang.String r3 = r3.getCountry()     // Catch:{ Exception -> 0x077c }
            r14.put(r2, r3)     // Catch:{ Exception -> 0x077c }
            goto L_0x0783
        L_0x077c:
            r0 = move-exception
            r2 = r0
            java.lang.String r3 = "Exception while collecting country name. "
            com.appsflyer.AFLogger.afErrorLog(r3, r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0783:
            java.lang.String r2 = "platformextension"
            com.appsflyer.internal.ae r3 = r4.f3345     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r3 = r3.mo10797()     // Catch:{ Throwable -> 0x0c1f }
            r14.put(r2, r3)     // Catch:{ Throwable -> 0x0c1f }
            m3212(r6, r14)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "yyyy-MM-dd_HHmmssZ"
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ Throwable -> 0x0c1f }
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ Throwable -> 0x0c1f }
            r3.<init>(r2, r5)     // Catch:{ Throwable -> 0x0c1f }
            android.content.pm.PackageManager r2 = r6.getPackageManager()     // Catch:{ Exception -> 0x07c1 }
            java.lang.String r5 = r6.getPackageName()     // Catch:{ Exception -> 0x07c1 }
            r8 = 0
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r5, r8)     // Catch:{ Exception -> 0x07c1 }
            long r10 = r2.firstInstallTime     // Catch:{ Exception -> 0x07c1 }
            java.lang.String r2 = "installDate"
            java.lang.String r5 = "UTC"
            java.util.TimeZone r5 = java.util.TimeZone.getTimeZone(r5)     // Catch:{ Exception -> 0x07c1 }
            r3.setTimeZone(r5)     // Catch:{ Exception -> 0x07c1 }
            java.util.Date r5 = new java.util.Date     // Catch:{ Exception -> 0x07c1 }
            r5.<init>(r10)     // Catch:{ Exception -> 0x07c1 }
            java.lang.String r5 = r3.format(r5)     // Catch:{ Exception -> 0x07c1 }
            r14.put(r2, r5)     // Catch:{ Exception -> 0x07c1 }
            goto L_0x07c8
        L_0x07c1:
            r0 = move-exception
            r2 = r0
            java.lang.String r5 = "Exception while collecting install date. "
            com.appsflyer.AFLogger.afErrorLog(r5, r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x07c8:
            android.content.pm.PackageManager r2 = r6.getPackageManager()     // Catch:{ Throwable -> 0x084e }
            java.lang.String r5 = r6.getPackageName()     // Catch:{ Throwable -> 0x084e }
            r8 = 0
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r5, r8)     // Catch:{ Throwable -> 0x084e }
            java.lang.String r5 = "versionCode"
            r10 = r26
            int r5 = r10.getInt(r5, r8)     // Catch:{ Throwable -> 0x084a }
            int r8 = r2.versionCode     // Catch:{ Throwable -> 0x084a }
            if (r8 <= r5) goto L_0x07f8
            java.lang.String r5 = "versionCode"
            int r8 = r2.versionCode     // Catch:{ Throwable -> 0x084a }
            android.content.Context r11 = r6.getApplicationContext()     // Catch:{ Throwable -> 0x084a }
            r12 = 0
            android.content.SharedPreferences r11 = r11.getSharedPreferences(r13, r12)     // Catch:{ Throwable -> 0x084a }
            android.content.SharedPreferences$Editor r11 = r11.edit()     // Catch:{ Throwable -> 0x084a }
            r11.putInt(r5, r8)     // Catch:{ Throwable -> 0x084a }
            r11.apply()     // Catch:{ Throwable -> 0x084a }
        L_0x07f8:
            java.lang.String r5 = "app_version_code"
            int r8 = r2.versionCode     // Catch:{ Throwable -> 0x084a }
            java.lang.String r8 = java.lang.Integer.toString(r8)     // Catch:{ Throwable -> 0x084a }
            r14.put(r5, r8)     // Catch:{ Throwable -> 0x084a }
            java.lang.String r5 = "app_version_name"
            java.lang.String r8 = r2.versionName     // Catch:{ Throwable -> 0x084a }
            r14.put(r5, r8)     // Catch:{ Throwable -> 0x084a }
            long r11 = r2.firstInstallTime     // Catch:{ Throwable -> 0x084a }
            r20 = r1
            long r1 = r2.lastUpdateTime     // Catch:{ Throwable -> 0x0848 }
            java.lang.String r5 = "date1"
            java.lang.String r8 = "yyyy-MM-dd_HHmmssZ"
            java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat     // Catch:{ Throwable -> 0x0848 }
            java.util.Locale r15 = java.util.Locale.US     // Catch:{ Throwable -> 0x0848 }
            r13.<init>(r8, r15)     // Catch:{ Throwable -> 0x0848 }
            java.util.Date r8 = new java.util.Date     // Catch:{ Throwable -> 0x0848 }
            r8.<init>(r11)     // Catch:{ Throwable -> 0x0848 }
            java.lang.String r8 = r13.format(r8)     // Catch:{ Throwable -> 0x0848 }
            r14.put(r5, r8)     // Catch:{ Throwable -> 0x0848 }
            java.lang.String r5 = "date2"
            java.lang.String r8 = "yyyy-MM-dd_HHmmssZ"
            java.text.SimpleDateFormat r11 = new java.text.SimpleDateFormat     // Catch:{ Throwable -> 0x0848 }
            java.util.Locale r12 = java.util.Locale.US     // Catch:{ Throwable -> 0x0848 }
            r11.<init>(r8, r12)     // Catch:{ Throwable -> 0x0848 }
            java.util.Date r8 = new java.util.Date     // Catch:{ Throwable -> 0x0848 }
            r8.<init>(r1)     // Catch:{ Throwable -> 0x0848 }
            java.lang.String r1 = r11.format(r8)     // Catch:{ Throwable -> 0x0848 }
            r14.put(r5, r1)     // Catch:{ Throwable -> 0x0848 }
            java.lang.String r1 = m3201(r3, r6)     // Catch:{ Throwable -> 0x0848 }
            java.lang.String r2 = "firstLaunchDate"
            r14.put(r2, r1)     // Catch:{ Throwable -> 0x0848 }
            goto L_0x0859
        L_0x0848:
            r0 = move-exception
            goto L_0x0853
        L_0x084a:
            r0 = move-exception
            r20 = r1
            goto L_0x0853
        L_0x084e:
            r0 = move-exception
            r20 = r1
            r10 = r26
        L_0x0853:
            r1 = r0
            java.lang.String r2 = "Exception while collecting app version data "
            com.appsflyer.AFLogger.afErrorLog(r2, r1)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0859:
            boolean r1 = com.appsflyer.internal.C1376r.C13773.m3343(r6)     // Catch:{ Throwable -> 0x0c1f }
            r4.f3344 = r1     // Catch:{ Throwable -> 0x0c1f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "didConfigureTokenRefreshService="
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0c1f }
            boolean r2 = r4.f3344     // Catch:{ Throwable -> 0x0c1f }
            r1.append(r2)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0c1f }
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ Throwable -> 0x0c1f }
            boolean r1 = r4.f3344     // Catch:{ Throwable -> 0x0c1f }
            if (r1 != 0) goto L_0x087d
            java.lang.String r1 = "tokenRefreshConfigured"
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ Throwable -> 0x0c1f }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x087d:
            if (r24 == 0) goto L_0x08ab
            com.appsflyer.internal.f r1 = com.appsflyer.internal.C1366f.m3331()     // Catch:{ Throwable -> 0x0c1f }
            r2 = r18
            r1.mo10831(r2, r6, r14)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = r4.f3342     // Catch:{ Throwable -> 0x0c1f }
            if (r1 == 0) goto L_0x08a1
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = r4.f3342     // Catch:{ Throwable -> 0x0c1f }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "isPush"
            r1.put(r2, r9)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "af_deeplink"
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0c1f }
            r14.put(r2, r1)     // Catch:{ Throwable -> 0x0c1f }
        L_0x08a1:
            r1 = 0
            r4.f3342 = r1     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = "open_referrer"
            r2 = r16
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x08ab:
            java.lang.String r1 = "sensors"
            if (r24 != 0) goto L_0x08ef
            com.appsflyer.internal.w r2 = com.appsflyer.internal.C1388w.m3355(r6)     // Catch:{ Exception -> 0x08d8 }
            java.util.concurrent.ConcurrentHashMap r3 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x08d8 }
            r3.<init>()     // Catch:{ Exception -> 0x08d8 }
            java.util.List r2 = r2.mo10845()     // Catch:{ Exception -> 0x08d8 }
            boolean r5 = r2.isEmpty()     // Catch:{ Exception -> 0x08d8 }
            if (r5 != 0) goto L_0x08cf
            com.appsflyer.internal.g r5 = new com.appsflyer.internal.g     // Catch:{ Exception -> 0x08d8 }
            r5.<init>()     // Catch:{ Exception -> 0x08d8 }
            java.util.Map r2 = com.appsflyer.internal.C1368g.m3337(r2)     // Catch:{ Exception -> 0x08d8 }
            r3.put(r1, r2)     // Catch:{ Exception -> 0x08d8 }
            goto L_0x08d4
        L_0x08cf:
            java.lang.String r2 = "na"
            r3.put(r1, r2)     // Catch:{ Exception -> 0x08d8 }
        L_0x08d4:
            r14.putAll(r3)     // Catch:{ Exception -> 0x08d8 }
            goto L_0x08ef
        L_0x08d8:
            r0 = move-exception
            r2 = r0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r5 = "Unexpected exception from AFSensorManager: "
            r3.<init>(r5)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = r2.getMessage()     // Catch:{ Throwable -> 0x0c1f }
            r3.append(r2)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = r3.toString()     // Catch:{ Throwable -> 0x0c1f }
            com.appsflyer.AFLogger.afRDLog(r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x08ef:
            boolean r2 = r4.f3340     // Catch:{ Throwable -> 0x0c1f }
            if (r2 == 0) goto L_0x0909
            java.lang.String r2 = "testAppMode_retargeting"
            r14.put(r2, r9)     // Catch:{ Throwable -> 0x0c1f }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0c1f }
            r2.<init>(r14)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0c1f }
            m3218(r6, r2)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "Sent retargeting params to test app"
            com.appsflyer.AFLogger.afInfoLog(r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0909:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0c1f }
            long r11 = r4.f3339     // Catch:{ Throwable -> 0x0c1f }
            long r2 = r2 - r11
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r5 = r5.getReferrer(r6)     // Catch:{ Throwable -> 0x0c1f }
            r11 = 30000(0x7530, double:1.4822E-319)
            int r8 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r8 > 0) goto L_0x092a
            if (r5 == 0) goto L_0x092a
            java.lang.String r2 = "AppsFlyer_Test"
            boolean r2 = r5.contains(r2)     // Catch:{ Throwable -> 0x0c1f }
            if (r2 == 0) goto L_0x092a
            r2 = 1
            goto L_0x092b
        L_0x092a:
            r2 = 0
        L_0x092b:
            if (r2 == 0) goto L_0x094c
            java.lang.String r2 = "testAppMode"
            r14.put(r2, r9)     // Catch:{ Throwable -> 0x0c1f }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0c1f }
            r2.<init>(r14)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0c1f }
            m3218(r6, r2)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "Sent params to test app"
            com.appsflyer.AFLogger.afInfoLog(r2)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "Test mode ended!"
            com.appsflyer.AFLogger.afInfoLog(r2)     // Catch:{ Throwable -> 0x0c1f }
            r2 = 0
            r4.f3339 = r2     // Catch:{ Throwable -> 0x0c1f }
        L_0x094c:
            java.lang.String r2 = "advertiserId"
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = r3.getString(r2)     // Catch:{ Throwable -> 0x0c1f }
            if (r2 != 0) goto L_0x0974
            com.appsflyer.internal.C1336aa.m3270(r6, r14)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "advertiserId"
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = r3.getString(r2)     // Catch:{ Throwable -> 0x0c1f }
            if (r2 == 0) goto L_0x096d
            java.lang.String r2 = "GAID_retry"
            r14.put(r2, r9)     // Catch:{ Throwable -> 0x0c1f }
            goto L_0x0974
        L_0x096d:
            java.lang.String r2 = "GAID_retry"
            java.lang.String r3 = "false"
            r14.put(r2, r3)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0974:
            android.content.ContentResolver r2 = r6.getContentResolver()     // Catch:{ Throwable -> 0x0c1f }
            com.appsflyer.internal.x r2 = com.appsflyer.internal.C1336aa.m3269(r2)     // Catch:{ Throwable -> 0x0c1f }
            if (r2 == 0) goto L_0x0990
            java.lang.String r3 = "amazon_aid"
            java.lang.String r5 = r2.f3627     // Catch:{ Throwable -> 0x0c1f }
            r14.put(r3, r5)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r3 = "amazon_aid_limit"
            boolean r2 = r2.f3626     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x0c1f }
            r14.put(r3, r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0990:
            java.lang.String r2 = "sentRegisterRequestToAF"
            r3 = 0
            boolean r2 = r10.getBoolean(r2, r3)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r3 = "registeredUninstall"
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Throwable -> 0x0c1f }
            r14.put(r3, r2)     // Catch:{ Throwable -> 0x0c1f }
            r2 = r24
            int r3 = m3206(r10, r7, r2)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r5 = "counter"
            java.lang.String r7 = java.lang.Integer.toString(r3)     // Catch:{ Throwable -> 0x0c1f }
            r14.put(r5, r7)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r5 = "iaecounter"
            if (r20 == 0) goto L_0x09b5
            r7 = 1
            goto L_0x09b6
        L_0x09b5:
            r7 = 0
        L_0x09b6:
            java.lang.String r8 = "appsFlyerInAppEventCount"
            int r7 = m3206(r10, r8, r7)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ Throwable -> 0x0c1f }
            r14.put(r5, r7)     // Catch:{ Throwable -> 0x0c1f }
            if (r2 == 0) goto L_0x09e3
            r5 = 1
            if (r3 != r5) goto L_0x09e3
            r27.setFirstLaunchCalled()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r5 = "waitForCustomerId"
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0c1f }
            r8 = 0
            boolean r5 = r7.getBoolean(r5, r8)     // Catch:{ Throwable -> 0x0c1f }
            if (r5 == 0) goto L_0x09e3
            java.lang.String r5 = "wait_cid"
            r8 = 1
            java.lang.String r7 = java.lang.Boolean.toString(r8)     // Catch:{ Throwable -> 0x0c1f }
            r14.put(r5, r7)     // Catch:{ Throwable -> 0x0c1f }
            goto L_0x09e4
        L_0x09e3:
            r8 = 1
        L_0x09e4:
            java.lang.String r5 = "isFirstCall"
            java.lang.String r7 = "sentSuccessfully"
            r9 = 0
            java.lang.String r7 = r10.getString(r7, r9)     // Catch:{ Throwable -> 0x0c1f }
            boolean r7 = java.lang.Boolean.parseBoolean(r7)     // Catch:{ Throwable -> 0x0c1f }
            if (r7 != 0) goto L_0x09f4
            goto L_0x09f5
        L_0x09f4:
            r8 = 0
        L_0x09f5:
            java.lang.String r7 = java.lang.Boolean.toString(r8)     // Catch:{ Throwable -> 0x0c1f }
            r14.put(r5, r7)     // Catch:{ Throwable -> 0x0c1f }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Throwable -> 0x0c1f }
            r5.<init>()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r7 = "cpu_abi"
            java.lang.String r8 = "ro.product.cpu.abi"
            java.lang.String r8 = m3208(r8)     // Catch:{ Throwable -> 0x0c1f }
            r5.put(r7, r8)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r7 = "cpu_abi2"
            java.lang.String r8 = "ro.product.cpu.abi2"
            java.lang.String r8 = m3208(r8)     // Catch:{ Throwable -> 0x0c1f }
            r5.put(r7, r8)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r7 = "arch"
            java.lang.String r8 = "os.arch"
            java.lang.String r8 = m3208(r8)     // Catch:{ Throwable -> 0x0c1f }
            r5.put(r7, r8)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r7 = "build_display_id"
            java.lang.String r8 = "ro.build.display.id"
            java.lang.String r8 = m3208(r8)     // Catch:{ Throwable -> 0x0c1f }
            r5.put(r7, r8)     // Catch:{ Throwable -> 0x0c1f }
            if (r2 == 0) goto L_0x0ab9
            boolean r2 = r4.f3337     // Catch:{ Throwable -> 0x0c1f }
            if (r2 == 0) goto L_0x0a73
            com.appsflyer.internal.q r2 = com.appsflyer.internal.C1374q.C1375a.f3583     // Catch:{ Throwable -> 0x0c1f }
            android.location.Location r2 = com.appsflyer.internal.C1374q.m3340(r6)     // Catch:{ Throwable -> 0x0c1f }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Throwable -> 0x0c1f }
            r8 = 3
            r7.<init>(r8)     // Catch:{ Throwable -> 0x0c1f }
            if (r2 == 0) goto L_0x0a68
            java.lang.String r8 = "lat"
            double r11 = r2.getLatitude()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r9 = java.lang.String.valueOf(r11)     // Catch:{ Throwable -> 0x0c1f }
            r7.put(r8, r9)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r8 = "lon"
            double r11 = r2.getLongitude()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r9 = java.lang.String.valueOf(r11)     // Catch:{ Throwable -> 0x0c1f }
            r7.put(r8, r9)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r8 = "ts"
            long r11 = r2.getTime()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = java.lang.String.valueOf(r11)     // Catch:{ Throwable -> 0x0c1f }
            r7.put(r8, r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0a68:
            boolean r2 = r7.isEmpty()     // Catch:{ Throwable -> 0x0c1f }
            if (r2 != 0) goto L_0x0a73
            java.lang.String r2 = "loc"
            r5.put(r2, r7)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0a73:
            com.appsflyer.internal.b r2 = com.appsflyer.internal.C1360b.C1362d.f3518     // Catch:{ Throwable -> 0x0c1f }
            com.appsflyer.internal.b$a r2 = r2.mo10828(r6)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r7 = "btl"
            float r8 = r2.f3516     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r8 = java.lang.Float.toString(r8)     // Catch:{ Throwable -> 0x0c1f }
            r5.put(r7, r8)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r7 = r2.f3517     // Catch:{ Throwable -> 0x0c1f }
            if (r7 == 0) goto L_0x0a8f
            java.lang.String r7 = "btch"
            java.lang.String r2 = r2.f3517     // Catch:{ Throwable -> 0x0c1f }
            r5.put(r7, r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0a8f:
            r2 = 2
            if (r3 > r2) goto L_0x0ab9
            com.appsflyer.internal.w r2 = com.appsflyer.internal.C1388w.m3355(r6)     // Catch:{ Throwable -> 0x0c1f }
            java.util.concurrent.ConcurrentHashMap r3 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Throwable -> 0x0c1f }
            r3.<init>()     // Catch:{ Throwable -> 0x0c1f }
            java.util.List r7 = r2.mo10846()     // Catch:{ Throwable -> 0x0c1f }
            boolean r8 = r7.isEmpty()     // Catch:{ Throwable -> 0x0c1f }
            if (r8 != 0) goto L_0x0aa9
            r3.put(r1, r7)     // Catch:{ Throwable -> 0x0c1f }
            goto L_0x0ab6
        L_0x0aa9:
            java.util.List r2 = r2.mo10845()     // Catch:{ Throwable -> 0x0c1f }
            boolean r7 = r2.isEmpty()     // Catch:{ Throwable -> 0x0c1f }
            if (r7 != 0) goto L_0x0ab6
            r3.put(r1, r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0ab6:
            r5.putAll(r3)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0ab9:
            java.util.Map r1 = com.appsflyer.AFExecutor.C13175.m3163(r6)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "dim"
            r5.put(r2, r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = "deviceData"
            r14.put(r1, r5)     // Catch:{ Throwable -> 0x0c1f }
            com.appsflyer.internal.af r1 = new com.appsflyer.internal.af     // Catch:{ Throwable -> 0x0c1f }
            r1.<init>()     // Catch:{ Throwable -> 0x0c1f }
            r1 = r17
            java.lang.Object r2 = r14.get(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Throwable -> 0x0c1f }
            r3 = r25
            java.lang.Object r5 = r14.get(r3)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r7 = "uid"
            java.lang.Object r7 = r14.get(r7)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Throwable -> 0x0c1f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0c1f }
            r8.<init>()     // Catch:{ Throwable -> 0x0c1f }
            r9 = 7
            r11 = 0
            java.lang.String r2 = r2.substring(r11, r9)     // Catch:{ Throwable -> 0x0c1f }
            r8.append(r2)     // Catch:{ Throwable -> 0x0c1f }
            r2 = 7
            java.lang.String r2 = r7.substring(r11, r2)     // Catch:{ Throwable -> 0x0c1f }
            r8.append(r2)     // Catch:{ Throwable -> 0x0c1f }
            int r2 = r5.length()     // Catch:{ Throwable -> 0x0c1f }
            int r2 = r2 + -7
            java.lang.String r2 = r5.substring(r2)     // Catch:{ Throwable -> 0x0c1f }
            r8.append(r2)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = r8.toString()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = com.appsflyer.internal.C1346af.m3282(r2)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r5 = "af_v"
            r14.put(r5, r2)     // Catch:{ Throwable -> 0x0c1f }
            com.appsflyer.internal.af r2 = new com.appsflyer.internal.af     // Catch:{ Throwable -> 0x0c1f }
            r2.<init>()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.Object r1 = r14.get(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Throwable -> 0x0c1f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0c1f }
            r2.<init>()     // Catch:{ Throwable -> 0x0c1f }
            r2.append(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.Object r1 = r14.get(r3)     // Catch:{ Throwable -> 0x0c1f }
            r2.append(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = r2.toString()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0c1f }
            r2.<init>()     // Catch:{ Throwable -> 0x0c1f }
            r2.append(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = "uid"
            java.lang.Object r1 = r14.get(r1)     // Catch:{ Throwable -> 0x0c1f }
            r2.append(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = r2.toString()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0c1f }
            r2.<init>()     // Catch:{ Throwable -> 0x0c1f }
            r2.append(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = "installDate"
            java.lang.Object r1 = r14.get(r1)     // Catch:{ Throwable -> 0x0c1f }
            r2.append(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = r2.toString()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0c1f }
            r2.<init>()     // Catch:{ Throwable -> 0x0c1f }
            r2.append(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = "counter"
            java.lang.Object r1 = r14.get(r1)     // Catch:{ Throwable -> 0x0c1f }
            r2.append(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = r2.toString()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0c1f }
            r2.<init>()     // Catch:{ Throwable -> 0x0c1f }
            r2.append(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = "iaecounter"
            java.lang.Object r1 = r14.get(r1)     // Catch:{ Throwable -> 0x0c1f }
            r2.append(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = r2.toString()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = com.appsflyer.internal.C1346af.m3280(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = com.appsflyer.internal.C1346af.m3282(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "af_v2"
            r14.put(r2, r1)     // Catch:{ Throwable -> 0x0c1f }
            boolean r1 = m3198(r6)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "ivc"
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Throwable -> 0x0c1f }
            r14.put(r2, r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = "is_stop_tracking_used"
            boolean r1 = r10.contains(r1)     // Catch:{ Throwable -> 0x0c1f }
            if (r1 == 0) goto L_0x0bb8
            java.lang.String r1 = "istu"
            java.lang.String r2 = "is_stop_tracking_used"
            r3 = 0
            boolean r2 = r10.getBoolean(r2, r3)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x0c1f }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0bb8:
            java.lang.String r1 = "consumeAfDeepLink"
            r2 = r27
            java.lang.Object r1 = r2.getObject(r1)     // Catch:{ Throwable -> 0x0c1f }
            if (r1 == 0) goto L_0x0bd2
            java.lang.String r1 = "consumeAfDeepLink"
            r3 = 0
            boolean r1 = r2.getBoolean(r1, r3)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "is_dp_api"
            r14.put(r2, r1)     // Catch:{ Throwable -> 0x0c1f }
        L_0x0bd2:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Throwable -> 0x0c1f }
            r1.<init>()     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "mcc"
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ Throwable -> 0x0c1f }
            android.content.res.Configuration r3 = r3.getConfiguration()     // Catch:{ Throwable -> 0x0c1f }
            int r3 = r3.mcc     // Catch:{ Throwable -> 0x0c1f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Throwable -> 0x0c1f }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "mnc"
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ Throwable -> 0x0c1f }
            android.content.res.Configuration r3 = r3.getConfiguration()     // Catch:{ Throwable -> 0x0c1f }
            int r3 = r3.mnc     // Catch:{ Throwable -> 0x0c1f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Throwable -> 0x0c1f }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = "cell"
            r14.put(r2, r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = "sig"
            com.appsflyer.internal.EventDataCollector r2 = new com.appsflyer.internal.EventDataCollector     // Catch:{ Throwable -> 0x0c1f }
            r2.<init>(r6)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r2 = r2.signature()     // Catch:{ Throwable -> 0x0c1f }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x0c1f }
            goto L_0x0c2b
        L_0x0c11:
            r4 = r28
            java.lang.String r1 = "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. "
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ Throwable -> 0x0c1f }
            java.lang.String r1 = "AppsFlyer will not track this event."
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ Throwable -> 0x0c1f }
            r1 = 0
            return r1
        L_0x0c1f:
            r0 = move-exception
            goto L_0x0c23
        L_0x0c21:
            r0 = move-exception
            r4 = r1
        L_0x0c23:
            r1 = r0
            java.lang.String r2 = r1.getLocalizedMessage()
            com.appsflyer.AFLogger.afErrorLog(r2, r1)
        L_0x0c2b:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.mo10732(com.appsflyer.AFEvent):java.util.Map");
    }

    /* renamed from: ˎ */
    private static void m3212(Context context, Map<String, ? super String> map) {
        C1379s sVar = C1380d.f3585;
        C1381e r2 = C1379s.m3346(context);
        map.put("network", r2.f3587);
        if (r2.f3588 != null) {
            map.put("operator", r2.f3588);
        }
        if (r2.f3586 != null) {
            map.put("carrier", r2.f3586);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˋ */
    public static String m3199(Context context, String str) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
        String str2 = "CACHED_CHANNEL";
        if (sharedPreferences.contains(str2)) {
            return sharedPreferences.getString(str2, null);
        }
        m3219(context, str2, str);
        return str;
    }

    /* renamed from: ˋ */
    private static String m3201(SimpleDateFormat simpleDateFormat, Context context) {
        String str;
        String str2 = "appsflyer-data";
        String str3 = "appsFlyerFirstInstall";
        String string = context.getApplicationContext().getSharedPreferences(str2, 0).getString(str3, null);
        if (string == null) {
            if (!context.getApplicationContext().getSharedPreferences(str2, 0).contains("appsFlyerCount")) {
                AFLogger.afDebugLog("AppsFlyer: first launch detected");
                str = simpleDateFormat.format(new Date());
            } else {
                str = "";
            }
            string = str;
            m3219(context, str3, string);
        }
        AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string)));
        return string;
    }

    public String getAppsFlyerUID(Context context) {
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        String str = "public_api_call";
        C1356am.f3467.mo10812(str, "getAppsFlyerUID", new String[0]);
        return C1347ag.m3284(new WeakReference(context));
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x022d A[Catch:{ ab -> 0x020c, all -> 0x0231 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x023b  */
    /* renamed from: ॱॱ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3238(com.appsflyer.AFEvent r21) throws java.io.IOException {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            java.lang.String r2 = "is_first_launch"
            java.lang.String r3 = "appsflyerConversionDataCacheExpiration"
            java.lang.String r4 = "appsflyer-data"
            java.net.URL r5 = new java.net.URL
            java.lang.String r6 = r0.f3297
            r5.<init>(r6)
            byte[] r6 = r0.f3300
            java.lang.String r7 = r0.f3290
            java.lang.String r8 = r0.f3301
            boolean r9 = r0.f3294
            android.content.Context r10 = r0.f3291
            if (r10 == 0) goto L_0x0020
            android.content.Context r10 = r0.f3291
            goto L_0x002e
        L_0x0020:
            java.lang.ref.WeakReference<android.content.Context> r10 = r0.f3295
            if (r10 == 0) goto L_0x002d
            java.lang.ref.WeakReference<android.content.Context> r10 = r0.f3295
            java.lang.Object r10 = r10.get()
            android.content.Context r10 = (android.content.Context) r10
            goto L_0x002e
        L_0x002d:
            r10 = 0
        L_0x002e:
            com.appsflyer.AppsFlyerTrackingRequestListener r12 = r0.f3296
            if (r9 == 0) goto L_0x0038
            com.appsflyer.AppsFlyerConversionListener r15 = f3333
            if (r15 == 0) goto L_0x0038
            r15 = 1
            goto L_0x0039
        L_0x0038:
            r15 = 0
        L_0x0039:
            java.net.URLConnection r16 = r5.openConnection()     // Catch:{ all -> 0x0235 }
            r11 = r16
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ all -> 0x0235 }
            java.lang.String r14 = "POST"
            r11.setRequestMethod(r14)     // Catch:{ all -> 0x0233 }
            int r14 = r6.length     // Catch:{ all -> 0x0233 }
            java.lang.String r13 = "Content-Length"
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x0233 }
            r11.setRequestProperty(r13, r14)     // Catch:{ all -> 0x0233 }
            java.lang.String r13 = "Content-Type"
            boolean r0 = r21.isEncrypt()     // Catch:{ all -> 0x0233 }
            if (r0 == 0) goto L_0x005b
            java.lang.String r0 = "application/octet-stream"
            goto L_0x005d
        L_0x005b:
            java.lang.String r0 = "application/json"
        L_0x005d:
            r11.setRequestProperty(r13, r0)     // Catch:{ all -> 0x0233 }
            r0 = 10000(0x2710, float:1.4013E-41)
            r11.setConnectTimeout(r0)     // Catch:{ all -> 0x0233 }
            r0 = 1
            r11.setDoOutput(r0)     // Catch:{ all -> 0x0233 }
            java.io.DataOutputStream r13 = new java.io.DataOutputStream     // Catch:{ all -> 0x021f }
            java.io.OutputStream r0 = r11.getOutputStream()     // Catch:{ all -> 0x021f }
            r13.<init>(r0)     // Catch:{ all -> 0x021f }
            r13.write(r6)     // Catch:{ all -> 0x021a }
            r13.close()     // Catch:{ all -> 0x0233 }
            int r0 = r11.getResponseCode()     // Catch:{ all -> 0x0233 }
            java.lang.String r6 = m3215(r11)     // Catch:{ all -> 0x0233 }
            com.appsflyer.internal.am r13 = com.appsflyer.internal.C1356am.f3467     // Catch:{ all -> 0x0233 }
            if (r13 != 0) goto L_0x008b
            com.appsflyer.internal.am r13 = new com.appsflyer.internal.am     // Catch:{ all -> 0x0233 }
            r13.<init>()     // Catch:{ all -> 0x0233 }
            com.appsflyer.internal.C1356am.f3467 = r13     // Catch:{ all -> 0x0233 }
        L_0x008b:
            com.appsflyer.internal.am r13 = com.appsflyer.internal.C1356am.f3467     // Catch:{ all -> 0x0233 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0233 }
            java.lang.String r14 = "server_response"
            r18 = r11
            r11 = 2
            java.lang.String[] r11 = new java.lang.String[r11]     // Catch:{ all -> 0x0231 }
            java.lang.String r19 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0231 }
            r16 = 0
            r11[r16] = r19     // Catch:{ all -> 0x0231 }
            r17 = 1
            r11[r17] = r6     // Catch:{ all -> 0x0231 }
            r13.mo10812(r14, r5, r11)     // Catch:{ all -> 0x0231 }
            java.lang.String r5 = "response code: "
            java.lang.String r11 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0231 }
            java.lang.String r5 = r5.concat(r11)     // Catch:{ all -> 0x0231 }
            com.appsflyer.AFLogger.afInfoLog(r5)     // Catch:{ all -> 0x0231 }
            android.content.Context r5 = r10.getApplicationContext()     // Catch:{ all -> 0x0231 }
            r11 = 0
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r4, r11)     // Catch:{ all -> 0x0231 }
            r11 = 200(0xc8, float:2.8E-43)
            if (r0 != r11) goto L_0x0155
            if (r10 == 0) goto L_0x00cb
            if (r9 == 0) goto L_0x00cb
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0231 }
            r1.f3334 = r13     // Catch:{ all -> 0x0231 }
        L_0x00cb:
            if (r12 == 0) goto L_0x00d0
            r12.onTrackingRequestSuccess()     // Catch:{ all -> 0x0231 }
        L_0x00d0:
            if (r8 == 0) goto L_0x00d9
            com.appsflyer.internal.C1396z.m3366()     // Catch:{ all -> 0x0231 }
            com.appsflyer.internal.C1396z.m3368(r8, r10)     // Catch:{ all -> 0x0231 }
            goto L_0x010e
        L_0x00d9:
            java.lang.String r0 = "sentSuccessfully"
            java.lang.String r8 = "true"
            m3219(r10, r0, r8)     // Catch:{ all -> 0x0231 }
            boolean r0 = r1.f3358     // Catch:{ all -> 0x0231 }
            if (r0 != 0) goto L_0x010e
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0231 }
            long r11 = r1.f3351     // Catch:{ all -> 0x0231 }
            long r8 = r8 - r11
            r11 = 15000(0x3a98, double:7.411E-320)
            int r0 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r0 >= 0) goto L_0x00f2
            goto L_0x010e
        L_0x00f2:
            java.util.concurrent.ScheduledExecutorService r0 = r1.f3338     // Catch:{ all -> 0x0231 }
            if (r0 != 0) goto L_0x010e
            com.appsflyer.AFExecutor r0 = com.appsflyer.AFExecutor.getInstance()     // Catch:{ all -> 0x0231 }
            java.util.concurrent.ScheduledThreadPoolExecutor r0 = r0.mo10646()     // Catch:{ all -> 0x0231 }
            r1.f3338 = r0     // Catch:{ all -> 0x0231 }
            com.appsflyer.AppsFlyerLibCore$c r0 = new com.appsflyer.AppsFlyerLibCore$c     // Catch:{ all -> 0x0231 }
            r0.<init>(r10)     // Catch:{ all -> 0x0231 }
            java.util.concurrent.ScheduledExecutorService r8 = r1.f3338     // Catch:{ all -> 0x0231 }
            r11 = 1
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0231 }
            m3195(r8, r0, r11, r9)     // Catch:{ all -> 0x0231 }
        L_0x010e:
            java.lang.String r0 = "afUninstallToken"
            com.appsflyer.AppsFlyerProperties r8 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0231 }
            java.lang.String r0 = r8.getString(r0)     // Catch:{ all -> 0x0231 }
            if (r0 == 0) goto L_0x0140
            java.lang.String r8 = "Uninstall Token exists: "
            java.lang.String r9 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0231 }
            java.lang.String r8 = r8.concat(r9)     // Catch:{ all -> 0x0231 }
            com.appsflyer.AFLogger.afDebugLog(r8)     // Catch:{ all -> 0x0231 }
            java.lang.String r8 = "sentRegisterRequestToAF"
            r9 = 0
            boolean r8 = r5.getBoolean(r8, r9)     // Catch:{ all -> 0x0231 }
            if (r8 != 0) goto L_0x0140
            java.lang.String r8 = "Resending Uninstall token to AF servers: "
            java.lang.String r9 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0231 }
            java.lang.String r8 = r8.concat(r9)     // Catch:{ all -> 0x0231 }
            com.appsflyer.AFLogger.afDebugLog(r8)     // Catch:{ all -> 0x0231 }
            com.appsflyer.internal.C1376r.C13773.m3342(r10, r0)     // Catch:{ all -> 0x0231 }
        L_0x0140:
            android.net.Uri r0 = r1.latestDeepLink     // Catch:{ all -> 0x0231 }
            if (r0 == 0) goto L_0x0147
            r8 = 0
            r1.latestDeepLink = r8     // Catch:{ all -> 0x0231 }
        L_0x0147:
            org.json.JSONObject r0 = com.appsflyer.ServerConfigHandler.m3265(r6)     // Catch:{ all -> 0x0231 }
            java.lang.String r6 = "send_background"
            r8 = 0
            boolean r0 = r0.optBoolean(r6, r8)     // Catch:{ all -> 0x0231 }
            r1.f3360 = r0     // Catch:{ all -> 0x0231 }
            goto L_0x0164
        L_0x0155:
            if (r12 == 0) goto L_0x0164
            java.lang.String r6 = "Failure: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0231 }
            java.lang.String r0 = r6.concat(r0)     // Catch:{ all -> 0x0231 }
            r12.onTrackingRequestFailure(r0)     // Catch:{ all -> 0x0231 }
        L_0x0164:
            r8 = 0
            long r11 = r5.getLong(r3, r8)     // Catch:{ all -> 0x0231 }
            java.lang.String r0 = "attributionId"
            int r6 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x019b
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0231 }
            long r13 = r13 - r11
            r11 = 5184000000(0x134fd9000, double:2.561236308E-314)
            int r6 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r6 <= 0) goto L_0x019b
            java.lang.String r6 = "sixtyDayConversionData"
            android.content.Context r11 = r10.getApplicationContext()     // Catch:{ all -> 0x0231 }
            r12 = 0
            android.content.SharedPreferences r4 = r11.getSharedPreferences(r4, r12)     // Catch:{ all -> 0x0231 }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ all -> 0x0231 }
            r11 = 1
            r4.putBoolean(r6, r11)     // Catch:{ all -> 0x0231 }
            r4.apply()     // Catch:{ all -> 0x0231 }
            r4 = 0
            m3219(r10, r0, r4)     // Catch:{ all -> 0x0231 }
            m3191(r10, r3, r8)     // Catch:{ all -> 0x0231 }
        L_0x019b:
            r3 = 0
            java.lang.String r4 = r5.getString(r0, r3)     // Catch:{ all -> 0x0231 }
            if (r4 != 0) goto L_0x01bc
            if (r7 == 0) goto L_0x01bc
            if (r15 == 0) goto L_0x01bc
            com.appsflyer.AppsFlyerLibCore$a r0 = new com.appsflyer.AppsFlyerLibCore$a     // Catch:{ all -> 0x0231 }
            android.content.Context r2 = r10.getApplicationContext()     // Catch:{ all -> 0x0231 }
            android.app.Application r2 = (android.app.Application) r2     // Catch:{ all -> 0x0231 }
            r3 = 0
            r0.<init>(r1, r2, r7, r3)     // Catch:{ all -> 0x0231 }
            java.util.concurrent.ScheduledExecutorService r2 = r0.f3382     // Catch:{ all -> 0x0231 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0231 }
            r4 = 10
            m3195(r2, r0, r4, r3)     // Catch:{ all -> 0x0231 }
            goto L_0x0214
        L_0x01bc:
            if (r7 != 0) goto L_0x01c4
            java.lang.String r0 = "AppsFlyer dev key is missing."
            com.appsflyer.AFLogger.afWarnLog(r0)     // Catch:{ all -> 0x0231 }
            goto L_0x0214
        L_0x01c4:
            if (r15 == 0) goto L_0x0214
            r11 = 0
            java.lang.String r0 = r5.getString(r0, r11)     // Catch:{ all -> 0x0231 }
            if (r0 == 0) goto L_0x0214
            java.lang.String r0 = "appsFlyerCount"
            r3 = 0
            int r0 = m3206(r5, r0, r3)     // Catch:{ all -> 0x0231 }
            r3 = 1
            if (r0 <= r3) goto L_0x0214
            java.util.Map r0 = m3237(r10)     // Catch:{ ab -> 0x020c }
            if (r0 == 0) goto L_0x0214
            boolean r3 = r0.containsKey(r2)     // Catch:{ Throwable -> 0x0203 }
            if (r3 != 0) goto L_0x01e8
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ Throwable -> 0x0203 }
            r0.put(r2, r3)     // Catch:{ Throwable -> 0x0203 }
        L_0x01e8:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0203 }
            java.lang.String r3 = "Calling onConversionDataSuccess with:\n"
            r2.<init>(r3)     // Catch:{ Throwable -> 0x0203 }
            java.lang.String r3 = r0.toString()     // Catch:{ Throwable -> 0x0203 }
            r2.append(r3)     // Catch:{ Throwable -> 0x0203 }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0203 }
            com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ Throwable -> 0x0203 }
            com.appsflyer.AppsFlyerConversionListener r2 = f3333     // Catch:{ Throwable -> 0x0203 }
            r2.onConversionDataSuccess(r0)     // Catch:{ Throwable -> 0x0203 }
            goto L_0x0214
        L_0x0203:
            r0 = move-exception
            java.lang.String r2 = r0.getLocalizedMessage()     // Catch:{ ab -> 0x020c }
            com.appsflyer.AFLogger.afErrorLog(r2, r0)     // Catch:{ ab -> 0x020c }
            goto L_0x0214
        L_0x020c:
            r0 = move-exception
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x0231 }
            com.appsflyer.AFLogger.afErrorLog(r2, r0)     // Catch:{ all -> 0x0231 }
        L_0x0214:
            if (r18 == 0) goto L_0x0219
            r18.disconnect()
        L_0x0219:
            return
        L_0x021a:
            r0 = move-exception
            r18 = r11
            r11 = r13
            goto L_0x0223
        L_0x021f:
            r0 = move-exception
            r18 = r11
            r11 = 0
        L_0x0223:
            if (r11 != 0) goto L_0x022d
            if (r12 == 0) goto L_0x0230
            java.lang.String r2 = "No Connectivity"
            r12.onTrackingRequestFailure(r2)     // Catch:{ all -> 0x0231 }
            goto L_0x0230
        L_0x022d:
            r11.close()     // Catch:{ all -> 0x0231 }
        L_0x0230:
            throw r0     // Catch:{ all -> 0x0231 }
        L_0x0231:
            r0 = move-exception
            goto L_0x0239
        L_0x0233:
            r0 = move-exception
            goto L_0x0237
        L_0x0235:
            r0 = move-exception
            r11 = 0
        L_0x0237:
            r18 = r11
        L_0x0239:
            if (r18 == 0) goto L_0x023e
            r18.disconnect()
        L_0x023e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m3238(com.appsflyer.AFEvent):void");
    }

    public void validateAndTrackInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Context context2 = context;
        String str6 = str3;
        String str7 = str4;
        String str8 = str5;
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        C1356am amVar = C1356am.f3467;
        String[] strArr = new String[6];
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str6;
        strArr[3] = str7;
        strArr[4] = str8;
        strArr[5] = map == null ? "" : map.toString();
        amVar.mo10812("public_api_call", "validateAndTrackInAppPurchase", strArr);
        if (!isTrackingStopped()) {
            StringBuilder sb = new StringBuilder("Validate in app called with parameters: ");
            sb.append(str6);
            String str9 = " ";
            sb.append(str9);
            sb.append(str7);
            sb.append(str9);
            sb.append(str8);
            AFLogger.afInfoLog(sb.toString());
        }
        if (str == null || str7 == null || str2 == null || str8 == null || str6 == null) {
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = f3331;
            if (appsFlyerInAppPurchaseValidatorListener != null) {
                appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
                return;
            }
            return;
        }
        ScheduledThreadPoolExecutor r10 = AFExecutor.getInstance().mo10646();
        C1382u uVar = new C1382u(context.getApplicationContext(), AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY), str, str2, str3, str4, str5, map, context2 instanceof Activity ? ((Activity) context2).getIntent() : null);
        m3195(r10, uVar, 10, TimeUnit.MILLISECONDS);
    }

    public void setHost(String str, String str2) {
        if (str != null) {
            AppsFlyerProperties.getInstance().set("custom_host_prefix", str);
        }
        if (str2 == null || str2.isEmpty()) {
            AFLogger.afWarnLog("hostName cannot be null or empty");
        } else {
            AppsFlyerProperties.getInstance().set("custom_host", str2);
        }
    }

    public String getHostName() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host");
        return string != null ? string : ServerParameters.DEFAULT_HOST;
    }

    @Deprecated
    public void setHostName(String str) {
        AppsFlyerProperties.getInstance().set("custom_host", str);
    }

    public String getHostPrefix() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host_prefix");
        return string != null ? string : "";
    }

    /* renamed from: ˋ */
    static /* synthetic */ void m3204(AppsFlyerLibCore appsFlyerLibCore, Map map) {
        Map<String, Object> map2 = appsFlyerLibCore.f3359;
        if (map2 != null && map2.size() > 0) {
            appsFlyerLibCore.m3220(new NewGPReferrer(map).context(appsFlyerLibCore.f3348));
        }
    }

    /* renamed from: ˎ */
    static /* synthetic */ boolean m3213(AppsFlyerLibCore appsFlyerLibCore) {
        Map<String, Object> map = appsFlyerLibCore.f3359;
        return map != null && map.size() > 0;
    }

    /* renamed from: ˋ */
    static /* synthetic */ boolean m3205(AppsFlyerLibCore appsFlyerLibCore) {
        Map<String, Object> map = appsFlyerLibCore.f3352;
        return map != null && !map.isEmpty();
    }

    /* renamed from: ˏ */
    static /* synthetic */ void m3221(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent) throws IOException {
        String str;
        StringBuilder sb = new StringBuilder("url: ");
        sb.append(aFEvent.f3297);
        AFLogger.afInfoLog(sb.toString());
        if (aFEvent.f3301 != null) {
            str = Base64.encodeToString(aFEvent.f3300, 2);
            AFLogger.afInfoLog("cached data: ".concat(String.valueOf(str)));
        } else {
            str = new JSONObject(aFEvent.f3293).toString();
            C13194.m3166("data: ".concat(String.valueOf(str)));
        }
        if (C1356am.f3467 == null) {
            C1356am.f3467 = new C1356am();
        }
        C1356am.f3467.mo10812("server_request", aFEvent.f3297, str);
        try {
            appsFlyerLibCore.m3238(aFEvent);
        } catch (IOException e) {
            AFLogger.afErrorLog("Exception in sendRequestToServer. ", e);
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.USE_HTTP_FALLBACK, false)) {
                appsFlyerLibCore.m3238(aFEvent.urlString(aFEvent.f3297.replace("https:", "http:")));
                return;
            }
            StringBuilder sb2 = new StringBuilder("failed to send requeset to server. ");
            sb2.append(e.getLocalizedMessage());
            AFLogger.afInfoLog(sb2.toString());
            throw e;
        }
    }
}
