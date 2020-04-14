package com.appsflyer.internal;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.ServerParameters;
import com.tapjoy.TapjoyConstants;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.am */
public final class C1356am {

    /* renamed from: ˋ */
    public static C1356am f3467;

    /* renamed from: ʻ */
    private final String f3468;

    /* renamed from: ʻॱ */
    private final String f3469;

    /* renamed from: ʼ */
    private final String f3470;

    /* renamed from: ʼॱ */
    private final String f3471;

    /* renamed from: ʽ */
    private final String f3472;

    /* renamed from: ʽॱ */
    private final String f3473;

    /* renamed from: ʾ */
    private final String f3474;

    /* renamed from: ʿ */
    private final String f3475;

    /* renamed from: ˈ */
    private final String f3476;

    /* renamed from: ˉ */
    private boolean f3477;

    /* renamed from: ˊ */
    public boolean f3478;

    /* renamed from: ˊˊ */
    private JSONObject f3479;

    /* renamed from: ˊˋ */
    private JSONArray f3480;

    /* renamed from: ˊॱ */
    private final String f3481;

    /* renamed from: ˊᐝ */
    private final String f3482;

    /* renamed from: ˋˊ */
    private final String f3483;

    /* renamed from: ˋˋ */
    private boolean f3484;

    /* renamed from: ˋॱ */
    private final String f3485;

    /* renamed from: ˌ */
    private String f3486;

    /* renamed from: ˍ */
    private int f3487;

    /* renamed from: ˎ */
    public boolean f3488;

    /* renamed from: ˏ */
    private final String f3489;

    /* renamed from: ˏॱ */
    private final String f3490;

    /* renamed from: ͺ */
    private final String f3491;

    /* renamed from: ॱ */
    private final String f3492;

    /* renamed from: ॱˊ */
    private final String f3493;

    /* renamed from: ॱˋ */
    private final String f3494;

    /* renamed from: ॱˎ */
    private final String f3495;

    /* renamed from: ॱॱ */
    private final String f3496;

    /* renamed from: ॱᐝ */
    private final String f3497;

    /* renamed from: ᐝ */
    private final String f3498;

    /* renamed from: ᐝॱ */
    private final String f3499;

    public C1356am() {
        this.f3489 = "brand";
        this.f3492 = "model";
        this.f3498 = TapjoyConstants.TJC_PLATFORM;
        this.f3496 = "platform_version";
        this.f3472 = ServerParameters.ADVERTISING_ID_PARAM;
        this.f3470 = "imei";
        this.f3468 = TapjoyConstants.TJC_ANDROID_ID;
        this.f3481 = "sdk_version";
        this.f3491 = "devkey";
        this.f3485 = "originalAppsFlyerId";
        this.f3493 = "uid";
        this.f3490 = "app_id";
        this.f3499 = TapjoyConstants.TJC_APP_VERSION_NAME;
        this.f3469 = AppsFlyerProperties.CHANNEL;
        this.f3494 = "preInstall";
        this.f3495 = "data";
        this.f3497 = "r_debugging_off";
        this.f3475 = "r_debugging_on";
        this.f3476 = "public_api_call";
        this.f3473 = "exception";
        this.f3471 = "server_request";
        this.f3474 = "server_response";
        this.f3482 = "yyyy-MM-dd HH:mm:ssZ";
        this.f3483 = "MM-dd HH:mm:ss.SSS";
        this.f3477 = true;
        this.f3487 = 0;
        this.f3486 = "-1";
        this.f3484 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
        this.f3488 = true ^ this.f3484;
        this.f3480 = new JSONArray();
        this.f3487 = 0;
        this.f3478 = false;
    }

    /* renamed from: ˎ */
    public final synchronized void mo10815(String str) {
        this.f3486 = str;
    }

    /* renamed from: ॱ */
    public final synchronized void mo10817() {
        this.f3478 = true;
        mo10812("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
    }

    /* renamed from: ˋ */
    public final synchronized void mo10813() {
        mo10812("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        this.f3478 = false;
        this.f3477 = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ */
    public final synchronized void mo10814() {
        this.f3479 = null;
        this.f3480 = null;
        f3467 = null;
    }

    /* renamed from: ॱ */
    private synchronized void m3300(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            this.f3479.put("brand", str);
            this.f3479.put("model", str2);
            this.f3479.put(TapjoyConstants.TJC_PLATFORM, "Android");
            this.f3479.put("platform_version", str3);
            if (str4 != null && str4.length() > 0) {
                this.f3479.put(ServerParameters.ADVERTISING_ID_PARAM, str4);
            }
            if (str5 != null && str5.length() > 0) {
                this.f3479.put("imei", str5);
            }
            if (str6 != null && str6.length() > 0) {
                this.f3479.put(TapjoyConstants.TJC_ANDROID_ID, str6);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ˋ */
    private synchronized void m3298(String str, String str2, String str3, String str4) {
        try {
            this.f3479.put("sdk_version", str);
            if (str2 != null && str2.length() > 0) {
                this.f3479.put("devkey", str2);
            }
            if (str3 != null && str3.length() > 0) {
                this.f3479.put("originalAppsFlyerId", str3);
            }
            if (str4 != null && str4.length() > 0) {
                this.f3479.put("uid", str4);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ˏ */
    private synchronized void m3299(String str, String str2, String str3, String str4) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    this.f3479.put("app_id", str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (str2 != null && str2.length() > 0) {
            this.f3479.put(TapjoyConstants.TJC_APP_VERSION_NAME, str2);
        }
        if (str3 != null && str3.length() > 0) {
            this.f3479.put(AppsFlyerProperties.CHANNEL, str3);
        }
        if (str4 != null && str4.length() > 0) {
            this.f3479.put("preInstall", str4);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ */
    public final synchronized String mo10811() {
        String str;
        str = null;
        try {
            this.f3479.put("data", this.f3480);
            str = this.f3479.toString();
            m3301();
        } catch (JSONException unused) {
        }
        return str;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x007e */
    /* renamed from: ॱ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo10818(java.lang.String r11, android.content.pm.PackageManager r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x008f }
            com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.getInstance()     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "remote_debug_static_data"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0019
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Throwable -> 0x007e }
            r11.<init>(r2)     // Catch:{ Throwable -> 0x007e }
            r10.f3479 = r11     // Catch:{ Throwable -> 0x007e }
            goto L_0x007e
        L_0x0019:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x008f }
            r2.<init>()     // Catch:{ all -> 0x008f }
            r10.f3479 = r2     // Catch:{ all -> 0x008f }
            java.lang.String r4 = android.os.Build.BRAND     // Catch:{ all -> 0x008f }
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ all -> 0x008f }
            java.lang.String r6 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "advertiserId"
            java.lang.String r7 = r0.getString(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r8 = r1.f3353     // Catch:{ all -> 0x008f }
            java.lang.String r9 = r1.f3357     // Catch:{ all -> 0x008f }
            r3 = r10
            r3.m3300(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "5.1.1."
            r1.<init>(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r2 = com.appsflyer.AppsFlyerLibCore.f3329     // Catch:{ all -> 0x008f }
            r1.append(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "AppsFlyerKey"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r3 = "KSAppsFlyerId"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x008f }
            java.lang.String r4 = "uid"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x008f }
            r10.m3298(r1, r2, r3, r4)     // Catch:{ all -> 0x008f }
            r1 = 0
            android.content.pm.PackageInfo r12 = r12.getPackageInfo(r11, r1)     // Catch:{ Throwable -> 0x0073 }
            int r12 = r12.versionCode     // Catch:{ Throwable -> 0x0073 }
            java.lang.String r1 = "channel"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Throwable -> 0x0073 }
            java.lang.String r2 = "preInstallName"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Throwable -> 0x0073 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Throwable -> 0x0073 }
            r10.m3299(r11, r12, r1, r2)     // Catch:{ Throwable -> 0x0073 }
        L_0x0073:
            java.lang.String r11 = "remote_debug_static_data"
            org.json.JSONObject r12 = r10.f3479     // Catch:{ all -> 0x008f }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x008f }
            r0.set(r11, r12)     // Catch:{ all -> 0x008f }
        L_0x007e:
            org.json.JSONObject r11 = r10.f3479     // Catch:{ JSONException -> 0x0089 }
            java.lang.String r12 = "launch_counter"
            java.lang.String r0 = r10.f3486     // Catch:{ JSONException -> 0x0089 }
            r11.put(r12, r0)     // Catch:{ JSONException -> 0x0089 }
            monitor-exit(r10)
            return
        L_0x0089:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ all -> 0x008f }
            monitor-exit(r10)
            return
        L_0x008f:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1356am.mo10818(java.lang.String, android.content.pm.PackageManager):void");
    }

    /* renamed from: ᐝ */
    private synchronized void m3301() {
        this.f3480 = null;
        this.f3480 = new JSONArray();
        this.f3487 = 0;
    }

    /* renamed from: ˏ */
    public final synchronized void mo10816() {
        this.f3477 = false;
        m3301();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b4, code lost:
        return;
     */
    /* renamed from: ˊ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo10812(java.lang.String r12, java.lang.String r13, java.lang.String... r14) {
        /*
            r11 = this;
            monitor-enter(r11)
            boolean r0 = r11.f3488     // Catch:{ all -> 0x00b5 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0011
            boolean r0 = r11.f3477     // Catch:{ all -> 0x00b5 }
            if (r0 != 0) goto L_0x000f
            boolean r0 = r11.f3478     // Catch:{ all -> 0x00b5 }
            if (r0 == 0) goto L_0x0011
        L_0x000f:
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 == 0) goto L_0x00b3
            int r0 = r11.f3487     // Catch:{ all -> 0x00b5 }
            r3 = 98304(0x18000, float:1.37753E-40)
            if (r0 < r3) goto L_0x001d
            goto L_0x00b3
        L_0x001d:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r0 = ""
            int r5 = r14.length     // Catch:{ Throwable -> 0x00b1 }
            if (r5 <= 0) goto L_0x0045
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00b1 }
            r0.<init>()     // Catch:{ Throwable -> 0x00b1 }
            int r5 = r14.length     // Catch:{ Throwable -> 0x00b1 }
            int r5 = r5 - r1
        L_0x002d:
            if (r5 <= 0) goto L_0x003c
            r6 = r14[r5]     // Catch:{ Throwable -> 0x00b1 }
            r0.append(r6)     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r6 = ", "
            r0.append(r6)     // Catch:{ Throwable -> 0x00b1 }
            int r5 = r5 + -1
            goto L_0x002d
        L_0x003c:
            r14 = r14[r2]     // Catch:{ Throwable -> 0x00b1 }
            r0.append(r14)     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00b1 }
        L_0x0045:
            java.text.SimpleDateFormat r14 = new java.text.SimpleDateFormat     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r5 = "MM-dd HH:mm:ss.SSS"
            java.util.Locale r6 = java.util.Locale.ENGLISH     // Catch:{ Throwable -> 0x00b1 }
            r14.<init>(r5, r6)     // Catch:{ Throwable -> 0x00b1 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r14 = r14.format(r3)     // Catch:{ Throwable -> 0x00b1 }
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 5
            if (r12 == 0) goto L_0x0080
            java.lang.String r7 = "%18s %5s _/%s [%s] %s %s"
            r8 = 6
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x00b1 }
            r8[r2] = r14     // Catch:{ Throwable -> 0x00b1 }
            java.lang.Thread r14 = java.lang.Thread.currentThread()     // Catch:{ Throwable -> 0x00b1 }
            long r9 = r14.getId()     // Catch:{ Throwable -> 0x00b1 }
            java.lang.Long r14 = java.lang.Long.valueOf(r9)     // Catch:{ Throwable -> 0x00b1 }
            r8[r1] = r14     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r14 = "AppsFlyer_5.1.1"
            r8[r5] = r14     // Catch:{ Throwable -> 0x00b1 }
            r8[r4] = r12     // Catch:{ Throwable -> 0x00b1 }
            r8[r3] = r13     // Catch:{ Throwable -> 0x00b1 }
            r8[r6] = r0     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r12 = java.lang.String.format(r7, r8)     // Catch:{ Throwable -> 0x00b1 }
            goto L_0x00a0
        L_0x0080:
            java.lang.String r12 = "%18s %5s %s/%s %s"
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Throwable -> 0x00b1 }
            r6[r2] = r14     // Catch:{ Throwable -> 0x00b1 }
            java.lang.Thread r14 = java.lang.Thread.currentThread()     // Catch:{ Throwable -> 0x00b1 }
            long r7 = r14.getId()     // Catch:{ Throwable -> 0x00b1 }
            java.lang.Long r14 = java.lang.Long.valueOf(r7)     // Catch:{ Throwable -> 0x00b1 }
            r6[r1] = r14     // Catch:{ Throwable -> 0x00b1 }
            r6[r5] = r13     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r13 = "AppsFlyer_5.1.1"
            r6[r4] = r13     // Catch:{ Throwable -> 0x00b1 }
            r6[r3] = r0     // Catch:{ Throwable -> 0x00b1 }
            java.lang.String r12 = java.lang.String.format(r12, r6)     // Catch:{ Throwable -> 0x00b1 }
        L_0x00a0:
            org.json.JSONArray r13 = r11.f3480     // Catch:{ Throwable -> 0x00b1 }
            r13.put(r12)     // Catch:{ Throwable -> 0x00b1 }
            int r13 = r11.f3487     // Catch:{ Throwable -> 0x00b1 }
            byte[] r12 = r12.getBytes()     // Catch:{ Throwable -> 0x00b1 }
            int r12 = r12.length     // Catch:{ Throwable -> 0x00b1 }
            int r13 = r13 + r12
            r11.f3487 = r13     // Catch:{ Throwable -> 0x00b1 }
            monitor-exit(r11)
            return
        L_0x00b1:
            monitor-exit(r11)
            return
        L_0x00b3:
            monitor-exit(r11)
            return
        L_0x00b5:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1356am.mo10812(java.lang.String, java.lang.String, java.lang.String[]):void");
    }
}
