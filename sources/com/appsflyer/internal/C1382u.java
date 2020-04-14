package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.ServerConfigHandler;
import com.appsflyer.ServerParameters;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.u */
public final class C1382u implements Runnable {

    /* renamed from: ʻ */
    private String f3589;

    /* renamed from: ʽ */
    private String f3590;

    /* renamed from: ˊ */
    private final Intent f3591;

    /* renamed from: ˋ */
    private String f3592;

    /* renamed from: ˎ */
    private String f3593;

    /* renamed from: ˏ */
    Map<String, String> f3594;

    /* renamed from: ॱ */
    WeakReference<Context> f3595;

    /* renamed from: ॱॱ */
    private String f3596;

    /* renamed from: ᐝ */
    private String f3597;

    public C1382u(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, @Nullable Intent intent) {
        this.f3595 = new WeakReference<>(context);
        this.f3593 = str;
        this.f3592 = str2;
        this.f3589 = str4;
        this.f3597 = str5;
        this.f3590 = str6;
        this.f3594 = map;
        this.f3596 = str3;
        this.f3591 = intent;
    }

    public final void run() {
        String str = "result";
        String str2 = ServerParameters.ADVERTISING_ID_PARAM;
        String str3 = this.f3593;
        if (str3 != null && str3.length() != 0 && !AppsFlyerLib.getInstance().isTrackingStopped()) {
            HttpURLConnection httpURLConnection = null;
            try {
                Context context = (Context) this.f3595.get();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("public-key", this.f3592);
                    hashMap.put("sig-data", this.f3589);
                    hashMap.put(InAppPurchaseMetaData.KEY_SIGNATURE, this.f3596);
                    final HashMap hashMap2 = new HashMap();
                    hashMap2.putAll(hashMap);
                    Executors.newSingleThreadScheduledExecutor().schedule(new Runnable() {
                        public final void run() {
                            C1382u uVar = C1382u.this;
                            C1382u.m3348(uVar, hashMap2, uVar.f3594, C1382u.this.f3595);
                        }
                    }, 5, TimeUnit.MILLISECONDS);
                    hashMap.put("dev_key", this.f3593);
                    hashMap.put("app_id", context.getPackageName());
                    hashMap.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
                    hashMap.put(str2, AppsFlyerProperties.getInstance().getString(str2));
                    String jSONObject = new JSONObject(hashMap).toString();
                    String url = ServerConfigHandler.getUrl("https://%ssdk-services.%s/validate-android-signature");
                    if (C1356am.f3467 == null) {
                        C1356am.f3467 = new C1356am();
                    }
                    C1356am.f3467.mo10812("server_request", url, jSONObject);
                    HttpURLConnection r2 = m3347(jSONObject, url);
                    int i = -1;
                    if (r2 != null) {
                        i = r2.getResponseCode();
                    }
                    AppsFlyerLibCore.getInstance();
                    String r5 = AppsFlyerLibCore.m3215(r2);
                    if (C1356am.f3467 == null) {
                        C1356am.f3467 = new C1356am();
                    }
                    C1356am.f3467.mo10812("server_response", url, String.valueOf(i), r5);
                    JSONObject jSONObject2 = new JSONObject(r5);
                    jSONObject2.put("code", i);
                    if (i == 200) {
                        StringBuilder sb = new StringBuilder("Validate response 200 ok: ");
                        sb.append(jSONObject2.toString());
                        AFLogger.afInfoLog(sb.toString());
                        m3349(jSONObject2.optBoolean(str) ? jSONObject2.getBoolean(str) : false, this.f3589, this.f3597, this.f3590, jSONObject2.toString());
                    } else {
                        AFLogger.afInfoLog("Failed Validate request");
                        m3349(false, this.f3589, this.f3597, this.f3590, jSONObject2.toString());
                    }
                    if (r2 != null) {
                        r2.disconnect();
                    }
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }

    /* renamed from: ˊ */
    private static HttpURLConnection m3347(String str, String str2) throws IOException {
        try {
            C1339ac acVar = new C1339ac(null, AppsFlyerLib.getInstance().isTrackingStopped());
            acVar.f3422 = str;
            acVar.f3423 = false;
            AFLogger.afDebugLog("Calling ".concat(String.valueOf(str2)));
            return acVar.mo10792(str2);
        } catch (Throwable th) {
            AFLogger.afErrorLog("Could not send callStats request", th);
            return null;
        }
    }

    /* renamed from: ˏ */
    private static void m3349(boolean z, String str, String str2, String str3, String str4) {
        if (AppsFlyerLibCore.f3331 != null) {
            StringBuilder sb = new StringBuilder("Validate callback parameters: ");
            sb.append(str);
            String str5 = " ";
            sb.append(str5);
            sb.append(str2);
            sb.append(str5);
            sb.append(str3);
            AFLogger.afDebugLog(sb.toString());
            if (z) {
                AFLogger.afDebugLog("Validate in app purchase success: ".concat(String.valueOf(str4)));
                AppsFlyerLibCore.f3331.onValidateInApp();
                return;
            }
            AFLogger.afDebugLog("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AppsFlyerLibCore.f3331;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.net.HttpURLConnection, java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0, types: [java.net.HttpURLConnection, java.lang.String]
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
      uses: [java.lang.String, ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.net.HttpURLConnection]
      mth insns count: 133
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
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: ˋ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m3348(com.appsflyer.internal.C1382u r6, java.util.Map r7, java.util.Map r8, java.lang.ref.WeakReference r9) {
        /*
            java.lang.Object r0 = r9.get()
            if (r0 == 0) goto L_0x017d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "https://%svalidate.%s/api/v4.11/androidevent?buildnumber=5.1.1&app_id="
            java.lang.String r1 = com.appsflyer.ServerConfigHandler.getUrl(r1)
            r0.append(r1)
            java.lang.Object r1 = r9.get()
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r1 = r1.getPackageName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object r1 = r9.get()
            android.content.Context r1 = (android.content.Context) r1
            android.content.SharedPreferences r1 = com.appsflyer.AppsFlyerLibCore.m3225(r1)
            r2 = 0
            java.lang.String r3 = "referrer"
            java.lang.String r1 = r1.getString(r3, r2)
            if (r1 != 0) goto L_0x003a
            java.lang.String r1 = ""
        L_0x003a:
            com.appsflyer.AppsFlyerLibCore r3 = com.appsflyer.AppsFlyerLibCore.getInstance()
            com.appsflyer.internal.model.event.Validate r4 = new com.appsflyer.internal.model.event.Validate
            r4.<init>()
            java.lang.Object r9 = r9.get()
            android.content.Context r9 = (android.content.Context) r9
            com.appsflyer.AFEvent r9 = r4.context(r9)
            java.lang.String r4 = r6.f3593
            r9.f3290 = r4
            java.lang.String r4 = "af_purchase"
            r9.f3302 = r4
            r9.f3298 = r1
            android.content.Intent r1 = r6.f3591
            r9.f3299 = r1
            java.util.Map r9 = r3.mo10732(r9)
            java.lang.String r1 = r6.f3597
            java.lang.String r3 = "price"
            r9.put(r3, r1)
            java.lang.String r6 = r6.f3590
            java.lang.String r1 = "currency"
            r9.put(r1, r6)
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>(r9)
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            java.util.Set r7 = r7.entrySet()     // Catch:{ JSONException -> 0x009f }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ JSONException -> 0x009f }
        L_0x007f:
            boolean r1 = r7.hasNext()     // Catch:{ JSONException -> 0x009f }
            if (r1 == 0) goto L_0x0099
            java.lang.Object r1 = r7.next()     // Catch:{ JSONException -> 0x009f }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ JSONException -> 0x009f }
            java.lang.Object r3 = r1.getKey()     // Catch:{ JSONException -> 0x009f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x009f }
            java.lang.Object r1 = r1.getValue()     // Catch:{ JSONException -> 0x009f }
            r9.put(r3, r1)     // Catch:{ JSONException -> 0x009f }
            goto L_0x007f
        L_0x0099:
            java.lang.String r7 = "receipt_data"
            r6.put(r7, r9)     // Catch:{ JSONException -> 0x009f }
            goto L_0x00a5
        L_0x009f:
            r7 = move-exception
            java.lang.String r9 = "Failed to build 'receipt_data'"
            com.appsflyer.AFLogger.afErrorLog(r9, r7)
        L_0x00a5:
            if (r8 == 0) goto L_0x00da
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.util.Set r8 = r8.entrySet()     // Catch:{ JSONException -> 0x00d4 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ JSONException -> 0x00d4 }
        L_0x00b4:
            boolean r9 = r8.hasNext()     // Catch:{ JSONException -> 0x00d4 }
            if (r9 == 0) goto L_0x00ce
            java.lang.Object r9 = r8.next()     // Catch:{ JSONException -> 0x00d4 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ JSONException -> 0x00d4 }
            java.lang.Object r1 = r9.getKey()     // Catch:{ JSONException -> 0x00d4 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x00d4 }
            java.lang.Object r9 = r9.getValue()     // Catch:{ JSONException -> 0x00d4 }
            r7.put(r1, r9)     // Catch:{ JSONException -> 0x00d4 }
            goto L_0x00b4
        L_0x00ce:
            java.lang.String r8 = "extra_prms"
            r6.put(r8, r7)     // Catch:{ JSONException -> 0x00d4 }
            goto L_0x00da
        L_0x00d4:
            r7 = move-exception
            java.lang.String r8 = "Failed to build 'extra_prms'"
            com.appsflyer.AFLogger.afErrorLog(r8, r7)
        L_0x00da:
            java.lang.String r6 = r6.toString()
            com.appsflyer.internal.am r7 = com.appsflyer.internal.C1356am.f3467
            if (r7 != 0) goto L_0x00e9
            com.appsflyer.internal.am r7 = new com.appsflyer.internal.am
            r7.<init>()
            com.appsflyer.internal.C1356am.f3467 = r7
        L_0x00e9:
            com.appsflyer.internal.am r7 = com.appsflyer.internal.C1356am.f3467
            r8 = 1
            java.lang.String[] r9 = new java.lang.String[r8]
            r1 = 0
            r9[r1] = r6
            java.lang.String r3 = "server_request"
            r7.mo10812(r3, r0, r9)
            java.net.HttpURLConnection r2 = m3347(r6, r0)     // Catch:{ Throwable -> 0x0169 }
            r6 = -1
            if (r2 == 0) goto L_0x0101
            int r6 = r2.getResponseCode()     // Catch:{ Throwable -> 0x0169 }
        L_0x0101:
            com.appsflyer.AppsFlyerLibCore.getInstance()     // Catch:{ Throwable -> 0x0169 }
            java.lang.String r7 = com.appsflyer.AppsFlyerLibCore.m3215(r2)     // Catch:{ Throwable -> 0x0169 }
            com.appsflyer.internal.am r9 = com.appsflyer.internal.C1356am.f3467     // Catch:{ Throwable -> 0x0169 }
            if (r9 != 0) goto L_0x0113
            com.appsflyer.internal.am r9 = new com.appsflyer.internal.am     // Catch:{ Throwable -> 0x0169 }
            r9.<init>()     // Catch:{ Throwable -> 0x0169 }
            com.appsflyer.internal.C1356am.f3467 = r9     // Catch:{ Throwable -> 0x0169 }
        L_0x0113:
            com.appsflyer.internal.am r9 = com.appsflyer.internal.C1356am.f3467     // Catch:{ Throwable -> 0x0169 }
            java.lang.String r3 = "server_response"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ Throwable -> 0x0169 }
            java.lang.String r5 = java.lang.String.valueOf(r6)     // Catch:{ Throwable -> 0x0169 }
            r4[r1] = r5     // Catch:{ Throwable -> 0x0169 }
            r4[r8] = r7     // Catch:{ Throwable -> 0x0169 }
            r9.mo10812(r3, r0, r4)     // Catch:{ Throwable -> 0x0169 }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0169 }
            r8.<init>(r7)     // Catch:{ Throwable -> 0x0169 }
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 != r7) goto L_0x0144
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0169 }
            java.lang.String r7 = "Validate-WH response - 200: "
            r6.<init>(r7)     // Catch:{ Throwable -> 0x0169 }
            java.lang.String r7 = r8.toString()     // Catch:{ Throwable -> 0x0169 }
            r6.append(r7)     // Catch:{ Throwable -> 0x0169 }
            java.lang.String r6 = r6.toString()     // Catch:{ Throwable -> 0x0169 }
            com.appsflyer.AFLogger.afInfoLog(r6)     // Catch:{ Throwable -> 0x0169 }
            goto L_0x0161
        L_0x0144:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0169 }
            java.lang.String r9 = "Validate-WH response failed - "
            r7.<init>(r9)     // Catch:{ Throwable -> 0x0169 }
            r7.append(r6)     // Catch:{ Throwable -> 0x0169 }
            java.lang.String r6 = ": "
            r7.append(r6)     // Catch:{ Throwable -> 0x0169 }
            java.lang.String r6 = r8.toString()     // Catch:{ Throwable -> 0x0169 }
            r7.append(r6)     // Catch:{ Throwable -> 0x0169 }
            java.lang.String r6 = r7.toString()     // Catch:{ Throwable -> 0x0169 }
            com.appsflyer.AFLogger.afWarnLog(r6)     // Catch:{ Throwable -> 0x0169 }
        L_0x0161:
            if (r2 == 0) goto L_0x017d
            r2.disconnect()
            return
        L_0x0167:
            r6 = move-exception
            goto L_0x0177
        L_0x0169:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()     // Catch:{ all -> 0x0167 }
            com.appsflyer.AFLogger.afErrorLog(r7, r6)     // Catch:{ all -> 0x0167 }
            if (r2 == 0) goto L_0x017d
            r2.disconnect()
            return
        L_0x0177:
            if (r2 == 0) goto L_0x017c
            r2.disconnect()
        L_0x017c:
            throw r6
        L_0x017d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1382u.m3348(com.appsflyer.internal.u, java.util.Map, java.util.Map, java.lang.ref.WeakReference):void");
    }
}
