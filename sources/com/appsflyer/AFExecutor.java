package com.appsflyer;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.TrafficStats;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.appsflyer.share.Constants;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AFExecutor {

    /* renamed from: ॱ */
    private static AFExecutor f3303;

    /* renamed from: ˊ */
    public ScheduledExecutorService f3304;

    /* renamed from: ˋ */
    public final ThreadFactory f3305 = new C13175();

    /* renamed from: ˎ */
    public Executor f3306;

    /* renamed from: ˏ */
    public ScheduledExecutorService f3307;

    /* renamed from: com.appsflyer.AFExecutor$5 */
    class C13175 implements ThreadFactory {

        /* renamed from: com.appsflyer.AFExecutor$5$3 */
        public class C13183 implements Runnable {

            /* renamed from: ॱ */
            private /* synthetic */ Runnable f3310;

            C13183(Runnable runnable) {
                this.f3310 = runnable;
            }

            public final void run() {
                TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
                this.f3310.run();
            }

            C13183() {
            }

            /* renamed from: ॱ */
            public static boolean m3165(Context context, String str) {
                int checkSelfPermission = ContextCompat.checkSelfPermission(context, str);
                StringBuilder sb = new StringBuilder("is Permission Available: ");
                sb.append(str);
                sb.append("; res: ");
                sb.append(checkSelfPermission);
                AFLogger.afRDLog(sb.toString());
                return checkSelfPermission == 0;
            }

            /* renamed from: ˏ */
            static Map<String, String> m3164(Context context, Map<String, String> map, Uri uri) {
                boolean z;
                String str;
                String str2 = "install_time";
                String str3 = "media_source";
                if (uri.getQuery() != null) {
                    String[] split = uri.getQuery().split("&");
                    int length = split.length;
                    z = false;
                    for (int i = 0; i < length; i++) {
                        String str4 = split[i];
                        int indexOf = str4.indexOf("=");
                        String substring = indexOf > 0 ? str4.substring(0, indexOf) : str4;
                        if (!map.containsKey(substring)) {
                            if (substring.equals(Constants.URL_CAMPAIGN)) {
                                substring = Param.CAMPAIGN;
                            } else if (substring.equals(Constants.URL_MEDIA_SOURCE)) {
                                substring = str3;
                            } else if (substring.equals("af_prt")) {
                                z = true;
                                substring = "agency";
                            }
                            map.put(substring, "");
                        }
                        if (indexOf > 0) {
                            int i2 = indexOf + 1;
                            if (str4.length() > i2) {
                                str = str4.substring(i2);
                                map.put(substring, str);
                            }
                        }
                        str = null;
                        map.put(substring, str);
                    }
                } else {
                    z = false;
                }
                try {
                    if (!map.containsKey(str2)) {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                        long j = packageInfo.firstInstallTime;
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                        map.put(str2, simpleDateFormat.format(new Date(j)));
                    }
                } catch (Exception e) {
                    AFLogger.afErrorLog("Could not fetch install time. ", e);
                }
                if (uri.getQueryParameter("af_deeplink") != null) {
                    String str5 = "af_status";
                    if (!map.containsKey(str5)) {
                        map.put(str5, "Non-organic");
                    }
                }
                if (z) {
                    map.remove(str3);
                }
                String path = uri.getPath();
                if (path != null) {
                    map.put("path", path);
                }
                String scheme = uri.getScheme();
                if (scheme != null) {
                    map.put("scheme", scheme);
                }
                String host = uri.getHost();
                if (host != null) {
                    map.put("host", host);
                }
                return map;
            }
        }

        C13175() {
        }

        public final Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new C13183(runnable));
        }

        C13175() {
        }

        /* renamed from: ˊ */
        static Map<String, String> m3163(@NonNull Context context) {
            HashMap hashMap = new HashMap();
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                int i = context.getResources().getConfiguration().screenLayout & 15;
                hashMap.put("x_px", String.valueOf(displayMetrics.widthPixels));
                hashMap.put("y_px", String.valueOf(displayMetrics.heightPixels));
                hashMap.put("d_dpi", String.valueOf(displayMetrics.densityDpi));
                hashMap.put("size", String.valueOf(i));
                hashMap.put("xdp", String.valueOf(displayMetrics.xdpi));
                hashMap.put("ydp", String.valueOf(displayMetrics.ydpi));
            } catch (Throwable th) {
                AFLogger.afErrorLog("Couldn't aggregate screen stats: ", th);
            }
            return hashMap;
        }
    }

    private AFExecutor() {
    }

    public static AFExecutor getInstance() {
        if (f3303 == null) {
            f3303 = new AFExecutor();
        }
        return f3303;
    }

    public Executor getThreadPoolExecutor() {
        Executor executor = this.f3306;
        if (executor == null || ((executor instanceof ThreadPoolExecutor) && (((ThreadPoolExecutor) executor).isShutdown() || ((ThreadPoolExecutor) this.f3306).isTerminated() || ((ThreadPoolExecutor) this.f3306).isTerminating()))) {
            this.f3306 = Executors.newFixedThreadPool(2, this.f3305);
        }
        return this.f3306;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ */
    public final ScheduledThreadPoolExecutor mo10646() {
        ScheduledExecutorService scheduledExecutorService = this.f3304;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown() || this.f3304.isTerminated()) {
            this.f3304 = Executors.newScheduledThreadPool(2, this.f3305);
        }
        return (ScheduledThreadPoolExecutor) this.f3304;
    }

    /* renamed from: ˎ */
    public static void m3161(ExecutorService executorService) {
        String str = "killing non-finished tasks";
        try {
            AFLogger.afRDLog("shut downing executor ...");
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog(str);
            }
            executorService.shutdownNow();
        } catch (InterruptedException unused) {
            AFLogger.afRDLog("InterruptedException!!!");
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog(str);
            }
            executorService.shutdownNow();
        } catch (Throwable th) {
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog(str);
            }
            executorService.shutdownNow();
            throw th;
        }
    }
}
