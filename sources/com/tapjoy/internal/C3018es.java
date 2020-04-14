package com.tapjoy.internal;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build.VERSION;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJCurrency;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TJSetUserIDListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJVideoListener;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import com.tapjoy.TapjoyLog;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.tapjoy.internal.es */
class C3018es extends C3017er {

    /* renamed from: c */
    private boolean f6949c = false;

    /* renamed from: d */
    private String f6950d = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TJCurrency f6951e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TapjoyCache f6952f = null;

    /* renamed from: b */
    public final String mo30052b() {
        return "12.4.1";
    }

    C3018es() {
    }

    /* renamed from: a */
    public final void mo30047a(boolean z) {
        TapjoyLog.setDebugEnabled(z);
    }

    /* renamed from: a */
    public final boolean mo30048a(Context context, String str) {
        return mo30050a(context, str, (Hashtable) null, (TJConnectListener) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0094, code lost:
        return true;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo30050a(final android.content.Context r3, java.lang.String r4, java.util.Hashtable r5, final com.tapjoy.TJConnectListener r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r5 == 0) goto L_0x0018
            java.lang.String r0 = "TJC_OPTION_ENABLE_LOGGING"
            java.lang.Object r0 = r5.get(r0)     // Catch:{ all -> 0x00c5 }
            if (r0 == 0) goto L_0x0018
            java.lang.String r1 = "true"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c5 }
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyLog.setDebugEnabled(r0)     // Catch:{ all -> 0x00c5 }
        L_0x0018:
            java.lang.String r0 = "event"
            com.tapjoy.TapjoyConnectCore.setSDKType(r0)     // Catch:{ all -> 0x00c5 }
            r0 = 0
            if (r3 != 0) goto L_0x0035
            java.lang.String r3 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r4 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r5 = com.tapjoy.TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR     // Catch:{ all -> 0x00c5 }
            java.lang.String r1 = "The application context is NULL"
            r4.<init>(r5, r1)     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyLog.m6551e(r3, r4)     // Catch:{ all -> 0x00c5 }
            if (r6 == 0) goto L_0x0033
            r6.onConnectFailure()     // Catch:{ all -> 0x00c5 }
        L_0x0033:
            monitor-exit(r2)
            return r0
        L_0x0035:
            boolean r1 = com.tapjoy.internal.C1852jq.m3669c(r4)     // Catch:{ all -> 0x00c5 }
            if (r1 == 0) goto L_0x0050
            java.lang.String r3 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r4 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r5 = com.tapjoy.TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR     // Catch:{ all -> 0x00c5 }
            java.lang.String r1 = "The SDK key is NULL. A valid SDK key is required to connect successfully to Tapjoy"
            r4.<init>(r5, r1)     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyLog.m6551e(r3, r4)     // Catch:{ all -> 0x00c5 }
            if (r6 == 0) goto L_0x004e
            r6.onConnectFailure()     // Catch:{ all -> 0x00c5 }
        L_0x004e:
            monitor-exit(r2)
            return r0
        L_0x0050:
            com.tapjoy.FiveRocksIntegration.m6416a()     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyAppSettings.init(r3)     // Catch:{ TapjoyIntegrationException -> 0x00ad, TapjoyException -> 0x0095 }
            com.tapjoy.internal.es$1 r1 = new com.tapjoy.internal.es$1     // Catch:{ TapjoyIntegrationException -> 0x00ad, TapjoyException -> 0x0095 }
            r1.<init>(r3, r6)     // Catch:{ TapjoyIntegrationException -> 0x00ad, TapjoyException -> 0x0095 }
            com.tapjoy.TapjoyConnectCore.requestTapjoyConnect(r3, r4, r5, r1)     // Catch:{ TapjoyIntegrationException -> 0x00ad, TapjoyException -> 0x0095 }
            r4 = 1
            r2.f6949c = r4     // Catch:{ all -> 0x00c5 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00c5 }
            r1 = 14
            if (r6 >= r1) goto L_0x006f
            java.lang.String r3 = "TapjoyAPI"
            java.lang.String r5 = "Automatic session tracking is not available on this device."
            com.tapjoy.TapjoyLog.m6553i(r3, r5)     // Catch:{ all -> 0x00c5 }
            goto L_0x0093
        L_0x006f:
            if (r5 == 0) goto L_0x0086
            java.lang.String r6 = "TJC_OPTION_DISABLE_AUTOMATIC_SESSION_TRACKING"
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00c5 }
            if (r5 == 0) goto L_0x0086
            java.lang.String r6 = "true"
            boolean r5 = r5.equalsIgnoreCase(r6)     // Catch:{ all -> 0x00c5 }
            if (r5 == 0) goto L_0x0086
            r0 = 1
        L_0x0086:
            if (r0 != 0) goto L_0x008c
            com.tapjoy.internal.C3068fl.m7092a(r3)     // Catch:{ all -> 0x00c5 }
            goto L_0x0093
        L_0x008c:
            java.lang.String r3 = "TapjoyAPI"
            java.lang.String r5 = "Automatic session tracking is disabled."
            com.tapjoy.TapjoyLog.m6553i(r3, r5)     // Catch:{ all -> 0x00c5 }
        L_0x0093:
            monitor-exit(r2)
            return r4
        L_0x0095:
            r3 = move-exception
            java.lang.String r4 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r5 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r1 = com.tapjoy.TapjoyErrorMessage.ErrorType.SDK_ERROR     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x00c5 }
            r5.<init>(r1, r3)     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyLog.m6551e(r4, r5)     // Catch:{ all -> 0x00c5 }
            if (r6 == 0) goto L_0x00ab
            r6.onConnectFailure()     // Catch:{ all -> 0x00c5 }
        L_0x00ab:
            monitor-exit(r2)
            return r0
        L_0x00ad:
            r3 = move-exception
            java.lang.String r4 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r5 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r1 = com.tapjoy.TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x00c5 }
            r5.<init>(r1, r3)     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyLog.m6551e(r4, r5)     // Catch:{ all -> 0x00c5 }
            if (r6 == 0) goto L_0x00c3
            r6.onConnectFailure()     // Catch:{ all -> 0x00c5 }
        L_0x00c3:
            monitor-exit(r2)
            return r0
        L_0x00c5:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3018es.mo30050a(android.content.Context, java.lang.String, java.util.Hashtable, com.tapjoy.TJConnectListener):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean mo30049a(final android.content.Context r4, java.lang.String r5, final com.tapjoy.TJConnectListener r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "event"
            com.tapjoy.TapjoyConnectCore.setSDKType(r0)     // Catch:{ all -> 0x0074 }
            r0 = 0
            if (r4 != 0) goto L_0x001e
            java.lang.String r4 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r5 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r1 = com.tapjoy.TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "The application context is NULL"
            r5.<init>(r1, r2)     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyLog.m6551e(r4, r5)     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x001c
            r6.onConnectFailure()     // Catch:{ all -> 0x0074 }
        L_0x001c:
            monitor-exit(r3)
            return r0
        L_0x001e:
            boolean r1 = com.tapjoy.internal.C1852jq.m3669c(r5)     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x0039
            java.lang.String r4 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r5 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r1 = com.tapjoy.TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "The limited SDK key is NULL. A valid limited SDK key is required to connect successfully to Tapjoy"
            r5.<init>(r1, r2)     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyLog.m6551e(r4, r5)     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x0037
            r6.onConnectFailure()     // Catch:{ all -> 0x0074 }
        L_0x0037:
            monitor-exit(r3)
            return r0
        L_0x0039:
            com.tapjoy.internal.es$2 r1 = new com.tapjoy.internal.es$2     // Catch:{ TapjoyIntegrationException -> 0x005c, TapjoyException -> 0x0044 }
            r1.<init>(r4, r6)     // Catch:{ TapjoyIntegrationException -> 0x005c, TapjoyException -> 0x0044 }
            com.tapjoy.TapjoyConnectCore.requestLimitedTapjoyConnect(r4, r5, r1)     // Catch:{ TapjoyIntegrationException -> 0x005c, TapjoyException -> 0x0044 }
            r4 = 1
            monitor-exit(r3)
            return r4
        L_0x0044:
            r4 = move-exception
            java.lang.String r5 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r1 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r2 = com.tapjoy.TapjoyErrorMessage.ErrorType.SDK_ERROR     // Catch:{ all -> 0x0074 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0074 }
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyLog.m6551e(r5, r1)     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x005a
            r6.onConnectFailure()     // Catch:{ all -> 0x0074 }
        L_0x005a:
            monitor-exit(r3)
            return r0
        L_0x005c:
            r4 = move-exception
            java.lang.String r5 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r1 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r2 = com.tapjoy.TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR     // Catch:{ all -> 0x0074 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0074 }
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyLog.m6551e(r5, r1)     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x0072
            r6.onConnectFailure()     // Catch:{ all -> 0x0074 }
        L_0x0072:
            monitor-exit(r3)
            return r0
        L_0x0074:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3018es.mo30049a(android.content.Context, java.lang.String, com.tapjoy.TJConnectListener):boolean");
    }

    /* renamed from: a */
    public final TJPlacement mo30022a(String str, TJPlacementListener tJPlacementListener) {
        String str2 = "";
        return TJPlacementManager.m6495a(str, str2, str2, tJPlacementListener);
    }

    /* renamed from: b */
    public final TJPlacement mo30051b(String str, TJPlacementListener tJPlacementListener) {
        String str2 = "";
        return TJPlacementManager.m6496b(str, str2, str2, tJPlacementListener);
    }

    /* renamed from: a */
    public final void mo30028a(Activity activity) {
        if (activity != null) {
            C1809b.m3451a(activity);
            return;
        }
        TapjoyLog.m6551e("TapjoyAPI", new TapjoyErrorMessage(ErrorType.INTEGRATION_ERROR, "Cannot set activity to NULL"));
    }

    /* renamed from: a */
    public final void mo30023a(float f) {
        if (m6965l("setCurrencyMultiplier")) {
            TapjoyConnectCore.getInstance().setCurrencyMultiplier(f);
        }
    }

    /* renamed from: c */
    public final float mo30058c() {
        if (m6965l("getCurrencyMultiplier")) {
            return TapjoyConnectCore.getInstance().getCurrencyMultiplier();
        }
        return 1.0f;
    }

    /* renamed from: e */
    public final void mo30066e(String str) {
        if (m6964k("actionComplete")) {
            TapjoyConnectCore.getInstance().actionComplete(str);
        }
    }

    /* renamed from: a */
    public final void mo30032a(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        if (this.f6951e != null && m6964k("getCurrencyBalance")) {
            this.f6951e.getCurrencyBalance(tJGetCurrencyBalanceListener);
        }
    }

    /* renamed from: a */
    public final void mo30026a(int i, TJSpendCurrencyListener tJSpendCurrencyListener) {
        if (this.f6951e != null && m6964k("spendCurrency")) {
            this.f6951e.spendCurrency(i, tJSpendCurrencyListener);
        }
    }

    /* renamed from: a */
    public final void mo30025a(int i, TJAwardCurrencyListener tJAwardCurrencyListener) {
        if (this.f6951e != null && m6964k("awardCurrency")) {
            this.f6951e.awardCurrency(i, tJAwardCurrencyListener);
        }
    }

    /* renamed from: a */
    public final void mo30031a(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        if (this.f6951e != null && m6964k("setEarnedCurrencyListener")) {
            this.f6951e.setEarnedCurrencyListener(tJEarnedCurrencyListener);
        }
    }

    /* renamed from: a */
    public final void mo30033a(TJVideoListener tJVideoListener) {
        if (m6965l("setVideoListener")) {
            TJAdUnit.f3707a = tJVideoListener;
        }
    }

    /* renamed from: a */
    public final void mo30040a(String str, String str2, String str3, String str4) {
        C3110gn.m7178a(str, str2, str3, str4);
    }

    /* renamed from: a */
    public final void mo30037a(String str, String str2) {
        C3110gn.m7178a(str, null, null, str2);
    }

    /* renamed from: a */
    public final void mo30034a(String str) {
        C3110gn.m7179a(null, str, null, null, 0);
    }

    /* renamed from: a */
    public final void mo30035a(String str, long j) {
        C3110gn.m7179a(null, str, null, null, j);
    }

    /* renamed from: a */
    public final void mo30039a(String str, String str2, long j) {
        C3110gn.m7179a(str, str2, null, null, j);
    }

    /* renamed from: b */
    public final void mo30056b(String str, String str2, String str3, String str4) {
        C3110gn.m7179a(str, str2, str3, str4, 0);
    }

    /* renamed from: a */
    public final void mo30041a(String str, String str2, String str3, String str4, long j) {
        C3110gn.m7179a(str, str2, str3, str4, j);
    }

    /* renamed from: a */
    public final void mo30042a(String str, String str2, String str3, String str4, String str5, long j) {
        C3110gn.m7180a(str, str2, str3, str4, str5, j, null, 0, null, 0);
    }

    /* renamed from: a */
    public final void mo30043a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2) {
        C3110gn.m7180a(str, str2, str3, str4, str5, j, str6, j2, null, 0);
    }

    /* renamed from: a */
    public final void mo30044a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, String str7, long j3) {
        C3110gn.m7180a(str, str2, str3, str4, str5, j, str6, j2, str7, j3);
    }

    /* renamed from: d */
    public final void mo30062d() {
        if (m6965l("startSession")) {
            if (VERSION.SDK_INT >= 14) {
                C3068fl.m7091a();
            }
            TapjoyConnectCore.getInstance().appResume();
            C3110gn.m7176a();
        }
    }

    /* renamed from: e */
    public final void mo30065e() {
        if (m6965l("endSession")) {
            if (VERSION.SDK_INT >= 14) {
                C3068fl.m7091a();
            }
            C1831gz.m3554a().f3830n = false;
            TapjoyConnectCore.getInstance().appPause();
            C3110gn.m7181b();
        }
    }

    /* renamed from: b */
    public final void mo30054b(Activity activity) {
        if (VERSION.SDK_INT >= 14) {
            C3068fl.m7091a();
        }
        C1831gz.m3554a().f3830n = true;
        C3110gn.m7177a(activity);
    }

    /* renamed from: c */
    public final void mo30059c(Activity activity) {
        if (VERSION.SDK_INT >= 14) {
            C3068fl.m7091a();
        }
        C3110gn.m7182b(activity);
    }

    /* renamed from: a */
    public final void mo30036a(String str, TJSetUserIDListener tJSetUserIDListener) {
        if (m6965l("setUserID")) {
            TapjoyConnectCore.setUserID(str, tJSetUserIDListener);
            C1831gz a = C1831gz.m3554a();
            if (a.mo18132d("setUserId")) {
                a.f3822f.mo18165b(C3119gu.m7204a(str));
            }
            return;
        }
        if (tJSetUserIDListener != null) {
            tJSetUserIDListener.onSetUserIDFailure(this.f6950d);
        }
    }

    /* renamed from: j */
    public final void mo30075j(String str) {
        TapjoyConnectCore.setCustomParameter(str);
    }

    /* renamed from: l */
    public final String mo30078l() {
        return TapjoyConnectCore.getCustomParameter();
    }

    /* renamed from: f */
    public final Set mo30067f() {
        return C1831gz.m3554a().mo18129c();
    }

    /* renamed from: a */
    public final void mo30046a(Set set) {
        C1831gz.m3554a().mo18124a(set);
    }

    /* renamed from: g */
    public final void mo30070g() {
        C1831gz.m3554a().mo18124a((Set) null);
    }

    /* renamed from: c */
    public final void mo30060c(String str) {
        if (!C1852jq.m3669c(str)) {
            C1831gz a = C1831gz.m3554a();
            Set c = a.mo18129c();
            if (c.add(str)) {
                a.mo18124a(c);
            }
        }
    }

    /* renamed from: d */
    public final void mo30063d(String str) {
        if (!C1852jq.m3669c(str)) {
            C1831gz a = C1831gz.m3554a();
            Set c = a.mo18129c();
            if (c.remove(str)) {
                a.mo18124a(c);
            }
        }
    }

    /* renamed from: h */
    public final boolean mo30072h() {
        C1831gz a = C1831gz.m3554a();
        if (!a.mo18132d("isPushNotificationDisabled")) {
            return false;
        }
        boolean f = a.f3822f.mo18170f();
        C3124gw.m7218a("isPushNotificationDisabled = {}", Boolean.valueOf(f));
        return f;
    }

    /* renamed from: b */
    public final void mo30057b(boolean z) {
        Object obj;
        Object[] objArr;
        String str;
        C1831gz a = C1831gz.m3554a();
        if (a.mo18132d("setPushNotificationDisabled")) {
            boolean a2 = a.f3822f.mo18162a(z);
            char c = 1;
            String str2 = "setPushNotificationDisabled({}) called, but it is already {}";
            if (a2) {
                Object[] objArr2 = new Object[1];
                obj = Boolean.valueOf(z);
                str2 = "setPushNotificationDisabled({}) called";
                objArr = objArr2;
                c = 0;
            } else {
                objArr = new Object[2];
                objArr[0] = Boolean.valueOf(z);
                obj = z ? "disabled" : String.ENABLED;
            }
            objArr[c] = obj;
            C3124gw.m7218a(str2, objArr);
            if (a2 && a.f3827k && !C1852jq.m3669c(a.f3820d)) {
                if (a.f3831o != null) {
                    str = null;
                } else {
                    C1833hb b = C1833hb.m3584b(a.f3821e);
                    str = C1852jq.m3668b(b.f3910b.mo18148b(b.f3909a));
                }
                a.mo18120a(str);
            }
        }
    }

    /* renamed from: i */
    public final boolean mo30074i() {
        return this.f6947a;
    }

    /* renamed from: j */
    public final boolean mo30076j() {
        return this.f6948b;
    }

    /* renamed from: g */
    public final String mo30069g(String str) {
        if (m6964k("getSupportURL")) {
            return TapjoyConnectCore.getSupportURL(str);
        }
        return null;
    }

    /* renamed from: k */
    public final String mo30077k() {
        return TapjoyConnectCore.getUserToken();
    }

    /* renamed from: i */
    public final void mo30073i(String str) {
        C1831gz.m3554a().mo18120a(str);
    }

    /* renamed from: a */
    public final void mo30029a(Context context, Map map) {
        C1831gz a = C1831gz.m3554a();
        if (a.f3821e == null) {
            a.mo18127b(context);
        }
        C1833hb.m3584b(a.f3821e);
        Context context2 = a.f3821e;
        boolean z = true;
        new Object[1][0] = map;
        String str = (String) map.get("fiverocks");
        if (str != null) {
            if (C1835hc.m3607a(context2).mo18170f()) {
                C1831gz.m3555a(context2).mo18128b(str);
                return;
            }
            String str2 = (String) map.get("title");
            String str3 = (String) map.get("message");
            if (str3 != null) {
                String str4 = (String) map.get("rich");
                String str5 = (String) map.get("sound");
                String str6 = (String) map.get(MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
                String str7 = (String) map.get("always");
                String str8 = "true";
                boolean z2 = str8.equals(str7) || Boolean.TRUE.equals(str7);
                String str9 = (String) map.get("repeatable");
                if (!str8.equals(str9) && !Boolean.TRUE.equals(str9)) {
                    z = false;
                }
                String str10 = (String) map.get("placement");
                int b = C1833hb.m3583b(map.get("nid"));
                String str11 = (String) map.get("channel_id");
                if (z2 || !C1831gz.m3555a(context2).mo18131d()) {
                    Notification a2 = C1833hb.m3580a(context2, str, C1852jq.m3667a(str2), str3, C1833hb.m3582a((Object) str4), C1833hb.m3582a((Object) str5), str6, str10, b, str11);
                    if (C1831gz.m3555a(context2).mo18125a(context2, str, z)) {
                        C1833hb.m3581a(context2, b, a2);
                    }
                }
            }
        }
    }

    /* renamed from: k */
    private boolean m6964k(String str) {
        if (this.f6947a) {
            return true;
        }
        StringBuilder sb = new StringBuilder("Can not call ");
        sb.append(str);
        sb.append(" because Tapjoy SDK has not successfully connected.");
        TapjoyLog.m6555w("TapjoyAPI", sb.toString());
        return false;
    }

    /* renamed from: l */
    private boolean m6965l(String str) {
        if (this.f6949c) {
            return true;
        }
        StringBuilder sb = new StringBuilder("Can not call ");
        sb.append(str);
        sb.append(" because Tapjoy SDK is not initialized.");
        this.f6950d = sb.toString();
        TapjoyLog.m6551e("TapjoyAPI", new TapjoyErrorMessage(ErrorType.INTEGRATION_ERROR, this.f6950d));
        return false;
    }

    /* renamed from: c */
    public final void mo30061c(boolean z) {
        C3104ge a = C3104ge.m7159a();
        a.f7325a = Boolean.valueOf(z);
        if (!a.mo30182b()) {
            a.f7328d = true;
        }
    }

    /* renamed from: h */
    public final void mo30071h(String str) {
        C3104ge a = C3104ge.m7159a();
        if (!C2874al.m6573a(str)) {
            a.f7326b = str;
            if (!a.mo30183c()) {
                a.f7328d = true;
            }
        }
    }

    /* renamed from: d */
    public final void mo30064d(boolean z) {
        C3104ge a = C3104ge.m7159a();
        a.f7327c = Boolean.valueOf(z);
        if (!a.mo30184d()) {
            a.f7328d = true;
        }
    }

    /* renamed from: a */
    public final void mo30038a(String str, String str2, double d, String str3) {
        C1831gz a = C1831gz.m3554a();
        String str4 = "trackPurchase";
        if (a.mo18130c(str4)) {
            String str5 = str;
            String a2 = C3119gu.m7205a(str, str4, "productId");
            if (a2 != null) {
                String str6 = AppsFlyerProperties.CURRENCY_CODE;
                String str7 = str2;
                String a3 = C3119gu.m7205a(str2, str4, str6);
                if (a3 != null) {
                    if (a3.length() != 3) {
                        C3124gw.m7217a(str4, str6, "invalid currency code");
                        return;
                    }
                    a.f3823g.mo18115a(a2, a3.toUpperCase(Locale.US), d, (String) null, (String) null, C3119gu.m7206b(str3));
                    C3124gw.m7216a("trackPurchase called");
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo30045a(String str, String str2, String str3, String str4, Map map) {
        C1831gz a = C1831gz.m3554a();
        String str5 = "trackEvent";
        if (a.mo18130c(str5) && !C1852jq.m3669c(str2)) {
            LinkedHashMap b = C3231ju.m7504b();
            if (map != null && map.size() > 0) {
                Iterator it = map.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Entry entry = (Entry) it.next();
                    Object key = entry.getKey();
                    String str6 = "key in values map";
                    if (key == null) {
                        if (C3124gw.f7370a) {
                            C1861x.m3699a("Tapjoy", "{}: {} must not be null", str5, str6);
                        }
                        return;
                    } else if (key instanceof String) {
                        String a2 = C3119gu.m7205a((String) key, str5, str6);
                        if (a2 == null) {
                            break;
                        }
                        Object value = entry.getValue();
                        if (value instanceof Number) {
                            b.put(a2, Long.valueOf(((Number) value).longValue()));
                        } else {
                            C3124gw.m7217a(str5, "value in values map", "must be a long");
                            return;
                        }
                    }
                }
            }
            a.f3823g.mo18117a(str, str2, str3, str4, b);
            C3124gw.m7218a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", str, str2, str3, str4, b);
        }
    }

    /* renamed from: a */
    public final void mo30024a(int i) {
        C1831gz a = C1831gz.m3554a();
        if (a.mo18132d("setUserLevel")) {
            C3124gw.m7218a("setUserLevel({}) called", Integer.valueOf(i));
            a.f3822f.mo18159a(i >= 0 ? Integer.valueOf(i) : null);
        }
    }

    /* renamed from: b */
    public final void mo30053b(int i) {
        C1831gz a = C1831gz.m3554a();
        if (a.mo18132d("setUserFriendCount")) {
            C3124gw.m7218a("setUserFriendCount({}) called", Integer.valueOf(i));
            a.f3822f.mo18164b(i >= 0 ? Integer.valueOf(i) : null);
        }
    }

    /* renamed from: b */
    public final void mo30055b(String str) {
        C1831gz a = C1831gz.m3554a();
        if (a.mo18132d("setAppDataVersion")) {
            a.f3822f.mo18160a(C3119gu.m7204a(str));
        }
    }

    /* renamed from: a */
    public final void mo30027a(int i, String str) {
        C1831gz a = C1831gz.m3554a();
        if (a.mo18132d("setUserCohortVariable")) {
            boolean z = i > 0 && i <= 5;
            if (C3124gw.f7370a && !z) {
                C3124gw.m7221b("setCohortVariable: variableIndex is out of range");
            }
            if (z) {
                C3124gw.m7218a("setUserCohortVariable({}, {}) called", Integer.valueOf(i), str);
                a.f3822f.mo18158a(i, C3119gu.m7204a(str));
            }
        }
    }

    /* renamed from: f */
    public final void mo30068f(String str) {
        C1831gz a = C1831gz.m3554a();
        C3124gw.m7218a("setGcmSender({}) called", str);
        a.f3820d = C1852jq.m3667a(str);
        a.mo18126b();
    }

    /* renamed from: a */
    public final void mo30030a(GLSurfaceView gLSurfaceView) {
        C1831gz.m3554a();
        C1831gz.m3557a(gLSurfaceView);
    }
}
