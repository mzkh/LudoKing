package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tapjoy.internal.C3017er;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public final class Tapjoy {
    public static final String INTENT_EXTRA_PUSH_PAYLOAD = "com.tapjoy.PUSH_PAYLOAD";

    public static String getVersion() {
        return C3017er.m6904a().mo30052b();
    }

    public static void setDebugEnabled(boolean z) {
        C3017er.m6904a().mo30047a(z);
    }

    public static boolean connect(Context context, String str) {
        return C3017er.m6904a().mo30048a(context, str);
    }

    public static boolean connect(Context context, String str, Hashtable hashtable) {
        return C3017er.m6904a().mo30050a(context, str, hashtable, (TJConnectListener) null);
    }

    public static synchronized boolean connect(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener) {
        boolean a;
        synchronized (Tapjoy.class) {
            a = C3017er.m6904a().mo30050a(context, str, hashtable, tJConnectListener);
        }
        return a;
    }

    public static TJPlacement getPlacement(String str, TJPlacementListener tJPlacementListener) {
        return C3017er.m6904a().mo30022a(str, tJPlacementListener);
    }

    public static void setActivity(Activity activity) {
        C3017er.m6904a().mo30028a(activity);
    }

    public static void getCurrencyBalance(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        C3017er.m6904a().mo30032a(tJGetCurrencyBalanceListener);
    }

    public static void spendCurrency(int i, TJSpendCurrencyListener tJSpendCurrencyListener) {
        C3017er.m6904a().mo30026a(i, tJSpendCurrencyListener);
    }

    public static void awardCurrency(int i, TJAwardCurrencyListener tJAwardCurrencyListener) {
        C3017er.m6904a().mo30025a(i, tJAwardCurrencyListener);
    }

    public static void setEarnedCurrencyListener(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        C3017er.m6904a().mo30031a(tJEarnedCurrencyListener);
    }

    @Deprecated
    public static void setCurrencyMultiplier(float f) {
        C3017er.m6904a().mo30023a(f);
    }

    @Deprecated
    public static float getCurrencyMultiplier() {
        return C3017er.m6904a().mo30058c();
    }

    public static void trackPurchase(String str, String str2, double d, String str3) {
        C3017er.m6904a().mo30038a(str, str2, d, str3);
    }

    public static void trackPurchase(String str, String str2, String str3, String str4) {
        C3017er.m6904a().mo30040a(str, str2, str3, str4);
    }

    @Deprecated
    public static void trackPurchase(String str, String str2) {
        C3017er.m6904a().mo30037a(str, str2);
    }

    public static void trackEvent(String str) {
        C3017er.m6904a().mo30034a(str);
    }

    public static void trackEvent(String str, long j) {
        C3017er.m6904a().mo30035a(str, j);
    }

    public static void trackEvent(String str, String str2, long j) {
        C3017er.m6904a().mo30039a(str, str2, j);
    }

    public static void trackEvent(String str, String str2, String str3, String str4) {
        C3017er.m6904a().mo30056b(str, str2, str3, str4);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, long j) {
        C3017er.m6904a().mo30041a(str, str2, str3, str4, j);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, String str5, long j) {
        C3017er.m6904a().mo30042a(str, str2, str3, str4, str5, j);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2) {
        C3017er.m6904a().mo30043a(str, str2, str3, str4, str5, j, str6, j2);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, String str7, long j3) {
        C3017er.m6904a().mo30044a(str, str2, str3, str4, str5, j, str6, j2, str7, j3);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, Map map) {
        C3017er.m6904a().mo30045a(str, str2, str3, str4, map);
    }

    public static void startSession() {
        C3017er.m6904a().mo30062d();
    }

    public static void endSession() {
        C3017er.m6904a().mo30065e();
    }

    public static void onActivityStart(Activity activity) {
        C3017er.m6904a().mo30054b(activity);
    }

    public static void onActivityStop(Activity activity) {
        C3017er.m6904a().mo30059c(activity);
    }

    public static void setUserID(String str) {
        setUserID(str, null);
    }

    public static void setUserID(String str, TJSetUserIDListener tJSetUserIDListener) {
        C3017er.m6904a().mo30036a(str, tJSetUserIDListener);
    }

    public static void setUserLevel(int i) {
        C3017er.m6904a().mo30024a(i);
    }

    public static void setUserFriendCount(int i) {
        C3017er.m6904a().mo30053b(i);
    }

    public static void setAppDataVersion(String str) {
        C3017er.m6904a().mo30055b(str);
    }

    public static void setUserCohortVariable(int i, String str) {
        C3017er.m6904a().mo30027a(i, str);
    }

    public static Set getUserTags() {
        return C3017er.m6904a().mo30067f();
    }

    public static void setUserTags(Set set) {
        C3017er.m6904a().mo30046a(set);
    }

    public static void clearUserTags() {
        C3017er.m6904a().mo30070g();
    }

    public static void addUserTag(String str) {
        C3017er.m6904a().mo30060c(str);
    }

    public static void removeUserTag(String str) {
        C3017er.m6904a().mo30063d(str);
    }

    public static void setVideoListener(TJVideoListener tJVideoListener) {
        C3017er.m6904a().mo30033a(tJVideoListener);
    }

    public static void actionComplete(String str) {
        C3017er.m6904a().mo30066e(str);
    }

    public static void setGcmSender(String str) {
        C3017er.m6904a().mo30068f(str);
    }

    public static void setDeviceToken(String str) {
        C3017er.m6904a().mo30073i(str);
    }

    public static void setReceiveRemoteNotification(Context context, Map map) {
        C3017er.m6904a().mo30029a(context, map);
    }

    public static boolean isPushNotificationDisabled() {
        return C3017er.m6904a().mo30072h();
    }

    public static void setPushNotificationDisabled(boolean z) {
        C3017er.m6904a().mo30057b(z);
    }

    public static void loadSharedLibrary() {
        try {
            System.loadLibrary("tapjoy");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static void setGLSurfaceView(GLSurfaceView gLSurfaceView) {
        C3017er.m6904a().mo30030a(gLSurfaceView);
    }

    public static String getSupportURL() {
        return C3017er.m6904a().mo30069g(null);
    }

    public static String getSupportURL(String str) {
        return C3017er.m6904a().mo30069g(str);
    }

    public static String getUserToken() {
        return C3017er.m6904a().mo30077k();
    }

    public static boolean isConnected() {
        return C3017er.m6904a().mo30074i();
    }

    public static void subjectToGDPR(boolean z) {
        C3017er.m6904a().mo30061c(z);
    }

    public static void setUserConsent(String str) {
        C3017er.m6904a().mo30071h(str);
    }

    public static void belowConsentAge(boolean z) {
        C3017er.m6904a().mo30064d(z);
    }

    public static synchronized boolean limitedConnect(Context context, String str, TJConnectListener tJConnectListener) {
        boolean a;
        synchronized (Tapjoy.class) {
            a = C3017er.m6904a().mo30049a(context, str, tJConnectListener);
        }
        return a;
    }

    public static boolean isLimitedConnected() {
        return C3017er.m6904a().mo30076j();
    }

    public static TJPlacement getLimitedPlacement(String str, TJPlacementListener tJPlacementListener) {
        return C3017er.m6904a().mo30051b(str, tJPlacementListener);
    }

    public static void setCustomParameter(String str) {
        C3017er.m6904a().mo30075j(str);
    }

    public static String getCustomParameter() {
        return C3017er.m6904a().mo30078l();
    }
}
