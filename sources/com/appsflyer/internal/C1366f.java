package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.appsflyer.AFExecutor;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.ServerConfigHandler;
import com.appsflyer.ServerParameters;
import com.appsflyer.share.Constants;
import com.tapjoy.TapjoyConstants;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.f */
public final class C1366f {

    /* renamed from: ʽ */
    private static C1366f f3545 = null;

    /* renamed from: ˊ */
    public static String[] f3546;

    /* renamed from: ˋ */
    static final int f3547 = ((int) TimeUnit.SECONDS.toMillis(2));

    /* renamed from: ˎ */
    static Uri f3548 = null;

    /* renamed from: ˏ */
    public static volatile boolean f3549;

    /* renamed from: ॱ */
    public static String[] f3550;

    /* renamed from: com.appsflyer.internal.f$5 */
    public class C13675 implements Runnable {

        /* renamed from: ˋ */
        private /* synthetic */ Uri f3551;

        /* renamed from: ˎ */
        private /* synthetic */ Context f3552;

        /* renamed from: ॱ */
        private /* synthetic */ Map f3554;

        C13675(Uri uri, Map map, Context context) {
            this.f3551 = uri;
            this.f3554 = map;
            this.f3552 = context;
        }

        public final void run() {
            long j;
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis();
            Uri uri = null;
            try {
                StringBuilder sb = new StringBuilder("ESP deeplink resolving is started: ");
                sb.append(this.f3551.toString());
                AFLogger.afDebugLog(sb.toString());
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f3551.toString()).openConnection();
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setReadTimeout(C1366f.f3547);
                httpURLConnection.setConnectTimeout(C1366f.f3547);
                httpURLConnection.setRequestProperty("User-agent", "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Nexus 5 Build/M4B30Z)");
                httpURLConnection.connect();
                AFLogger.afDebugLog("ESP deeplink resolving is finished");
                hashMap.put("status", String.valueOf(httpURLConnection.getResponseCode()));
                if (httpURLConnection.getResponseCode() >= 300 && httpURLConnection.getResponseCode() <= 305) {
                    uri = Uri.parse(httpURLConnection.getHeaderField(Constants.HTTP_REDIRECT_URL_HEADER_FIELD));
                }
                j = System.currentTimeMillis() - currentTimeMillis;
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                hashMap.put("error", th.getLocalizedMessage());
                hashMap.put("status", "-1");
                j = System.currentTimeMillis() - currentTimeMillis;
                AFLogger.afErrorLog(th.getMessage(), th);
            }
            hashMap.put("latency", Long.toString(j));
            if (uri != null) {
                hashMap.put("res", uri.toString());
            } else {
                hashMap.put("res", "");
            }
            synchronized (this.f3554) {
                this.f3554.put("af_deeplink_r", hashMap);
                this.f3554.put("af_deeplink", this.f3551.toString());
            }
            C1366f.f3549 = false;
            if (uri == null) {
                uri = this.f3551;
            }
            AppsFlyerLibCore.getInstance().handleDeepLinkCallback(this.f3552, this.f3554, uri);
        }

        C13675() {
        }

        /* renamed from: ॱ */
        public static void m3335(Context context) {
            Context applicationContext = context.getApplicationContext();
            AFLogger.afInfoLog("onBecameBackground");
            AppsFlyerLibCore.getInstance().f3335 = System.currentTimeMillis();
            AFLogger.afInfoLog("callStatsBackground background call");
            WeakReference weakReference = new WeakReference(applicationContext);
            AppsFlyerLibCore instance = AppsFlyerLibCore.getInstance();
            if (weakReference.get() != null) {
                AFLogger.afInfoLog("app went to background");
                SharedPreferences r2 = AppsFlyerLibCore.m3225((Context) weakReference.get());
                AppsFlyerProperties.getInstance().saveProperties(r2);
                long j = instance.f3335 - instance.f3362;
                HashMap hashMap = new HashMap();
                String r8 = AppsFlyerLibCore.m3200(AppsFlyerProperties.AF_KEY);
                if (r8 == null) {
                    AFLogger.afWarnLog("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
                } else {
                    String r9 = AppsFlyerLibCore.m3200("KSAppsFlyerId");
                    AppsFlyerProperties instance2 = AppsFlyerProperties.getInstance();
                    String str = AppsFlyerProperties.DEVICE_TRACKING_DISABLED;
                    if (instance2.getBoolean(str, false)) {
                        hashMap.put(str, "true");
                    }
                    C1393x r10 = C1336aa.m3269(((Context) weakReference.get()).getContentResolver());
                    if (r10 != null) {
                        hashMap.put("amazon_aid", r10.f3627);
                        hashMap.put("amazon_aid_limit", String.valueOf(r10.f3626));
                    }
                    AppsFlyerProperties instance3 = AppsFlyerProperties.getInstance();
                    String str2 = ServerParameters.ADVERTISING_ID_PARAM;
                    String string = instance3.getString(str2);
                    if (string != null) {
                        hashMap.put(str2, string);
                    }
                    hashMap.put("app_id", ((Context) weakReference.get()).getPackageName());
                    hashMap.put("devkey", r8);
                    hashMap.put("uid", C1347ag.m3284(weakReference));
                    hashMap.put("time_in_app", String.valueOf(j / 1000));
                    hashMap.put("statType", "user_closed_app");
                    hashMap.put(TapjoyConstants.TJC_PLATFORM, "Android");
                    hashMap.put("launch_counter", Integer.toString(AppsFlyerLibCore.m3206(r2, "appsFlyerCount", false)));
                    hashMap.put(AppsFlyerProperties.CHANNEL, AppsFlyerLibCore.m3227(weakReference));
                    if (r9 == null) {
                        r9 = "";
                    }
                    hashMap.put("originalAppsflyerId", r9);
                    if (instance.f3360) {
                        try {
                            C1339ac acVar = new C1339ac(null, instance.isTrackingStopped());
                            acVar.f3422 = new JSONObject(hashMap).toString();
                            AFLogger.afDebugLog("Running callStats task");
                            new Thread(new Runnable(ServerConfigHandler.getUrl("https://%sstats.%s/stats")) {

                                /* renamed from: ॱ */
                                private /* synthetic */ String f3428;

                                {
                                    this.f3428 = r2;
                                }

                                public final void run() {
                                    C1339ac.this.mo10792(this.f3428);
                                }
                            }).start();
                        } catch (Throwable th) {
                            AFLogger.afErrorLog("Could not send callStats request", th);
                        }
                    } else {
                        AFLogger.afDebugLog("Stats call is disabled, ignore ...");
                    }
                }
            }
            if (C1356am.f3467 == null) {
                C1356am.f3467 = new C1356am();
            }
            C1356am amVar = C1356am.f3467;
            if (amVar.f3478) {
                amVar.mo10813();
                if (applicationContext != null) {
                    String packageName = applicationContext.getPackageName();
                    PackageManager packageManager = applicationContext.getPackageManager();
                    try {
                        if (C1356am.f3467 == null) {
                            C1356am.f3467 = new C1356am();
                        }
                        C1356am.f3467.mo10818(packageName, packageManager);
                        if (C1356am.f3467 == null) {
                            C1356am.f3467 = new C1356am();
                        }
                        String r13 = C1356am.f3467.mo10811();
                        C1339ac acVar2 = new C1339ac(null, AppsFlyerLib.getInstance().isTrackingStopped());
                        acVar2.f3422 = r13;
                        acVar2.f3424 = false;
                        StringBuilder sb = new StringBuilder();
                        sb.append(ServerConfigHandler.getUrl("https://%smonitorsdk.%s/remote-debug?app_id="));
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
                    } catch (Throwable unused) {
                    }
                }
                amVar.mo10814();
            } else {
                AFLogger.afDebugLog("RD status is OFF");
            }
            AFExecutor instance4 = AFExecutor.getInstance();
            try {
                AFExecutor.m3161(instance4.f3304);
                if (instance4.f3306 instanceof ThreadPoolExecutor) {
                    AFExecutor.m3161((ThreadPoolExecutor) instance4.f3306);
                }
            } catch (Throwable th2) {
                AFLogger.afErrorLog("failed to stop Executors", th2);
            }
        }
    }

    private C1366f() {
    }

    /* renamed from: ˋ */
    public static C1366f m3331() {
        if (f3545 == null) {
            f3545 = new C1366f();
        }
        return f3545;
    }

    /* renamed from: ˋ */
    private void m3332(Context context, Map<String, Object> map, Uri uri) {
        String obj = uri.toString();
        boolean z = false;
        if (f3550 != null && !obj.contains("af_tranid=")) {
            StringBuilder sb = new StringBuilder("Validate ESP URLs :");
            sb.append(Arrays.asList(f3550));
            AFLogger.afRDLog(sb.toString());
            String[] strArr = f3550;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str = strArr[i];
                if (obj.contains("://".concat(String.valueOf(str)))) {
                    AFLogger.afRDLog("Deeplink matches ESP domain: ".concat(String.valueOf(str)));
                    z = true;
                    break;
                }
                i++;
            }
        }
        if (z) {
            f3549 = true;
            AFExecutor instance = AFExecutor.getInstance();
            if (instance.f3307 == null) {
                instance.f3307 = Executors.newSingleThreadScheduledExecutor(instance.f3305);
            }
            instance.f3307.execute(new C13675(uri, map, context));
        } else {
            AppsFlyerLibCore.getInstance().handleDeepLinkCallback(context, map, uri);
        }
        f3548 = null;
    }

    @Nullable
    /* renamed from: ॱ */
    static Uri m3333(Intent intent) {
        if (intent != null) {
            if ("android.intent.action.VIEW".equals(intent.getAction())) {
                return intent.getData();
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0016  */
    /* renamed from: ˏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo10831(android.content.Intent r5, android.content.Context r6, java.util.Map<java.lang.String, java.lang.Object> r7) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0013
            java.lang.String r0 = r5.getAction()
            java.lang.String r1 = "android.intent.action.VIEW"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0013
            android.net.Uri r0 = r5.getData()
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x0044
            java.lang.String r1 = "af_consumed"
            boolean r2 = r5.hasExtra(r1)
            if (r2 != 0) goto L_0x0029
            long r2 = java.lang.System.currentTimeMillis()
            r5.putExtra(r1, r2)
            r4.m3332(r6, r7, r0)
            return
        L_0x0029:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "skipping re-use of previously consumed deep link: "
            r5.<init>(r6)
            java.lang.String r6 = r0.toString()
            r5.append(r6)
            java.lang.String r6 = " w/af_consumed"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.appsflyer.AFLogger.afInfoLog(r5)
            return
        L_0x0044:
            android.net.Uri r5 = f3548
            if (r5 == 0) goto L_0x005f
            r4.m3332(r6, r7, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "using trampoline Intent fallback with URI: "
            r5.<init>(r6)
            android.net.Uri r6 = f3548
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.appsflyer.AFLogger.afInfoLog(r5)
            return
        L_0x005f:
            com.appsflyer.AppsFlyerLibCore r5 = com.appsflyer.AppsFlyerLibCore.getInstance()
            android.net.Uri r5 = r5.latestDeepLink
            if (r5 == 0) goto L_0x008c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "using Unity/plugin Intent fallback with URI: "
            r5.<init>(r0)
            com.appsflyer.AppsFlyerLibCore r0 = com.appsflyer.AppsFlyerLibCore.getInstance()
            android.net.Uri r0 = r0.latestDeepLink
            java.lang.String r0 = r0.toString()
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            com.appsflyer.AFLogger.afInfoLog(r5)
            com.appsflyer.AppsFlyerLibCore r5 = com.appsflyer.AppsFlyerLibCore.getInstance()
            android.net.Uri r5 = r5.latestDeepLink
            r4.m3332(r6, r7, r5)
            return
        L_0x008c:
            java.lang.String r5 = "No deep link detected"
            com.appsflyer.AFLogger.afDebugLog(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1366f.mo10831(android.content.Intent, android.content.Context, java.util.Map):void");
    }
}
