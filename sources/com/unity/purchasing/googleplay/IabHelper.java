package com.unity.purchasing.googleplay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.appsflyer.share.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class IabHelper {
    public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
    public static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR = 5;
    public static final int BILLING_RESPONSE_RESULT_ERROR = 6;
    public static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED = 7;
    public static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;
    public static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;
    public static final int BILLING_RESPONSE_RESULT_OK = 0;
    public static final int BILLING_RESPONSE_RESULT_SERVICE_UNAVAILABLE = 2;
    public static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
    public static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
    public static final String GET_SKU_DETAILS_ITEM_TYPE_LIST = "ITEM_TYPE_LIST";
    public static final int IABHELPER_BAD_RESPONSE = -1002;
    public static final int IABHELPER_ERROR_BASE = -1000;
    public static final int IABHELPER_INVALID_CONSUMPTION = -1010;
    public static final int IABHELPER_MISSING_TOKEN = -1007;
    public static final int IABHELPER_REMOTE_EXCEPTION = -1001;
    public static final int IABHELPER_SEND_INTENT_FAILED = -1004;
    public static final int IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE = -1009;
    public static final int IABHELPER_UNKNOWN_ERROR = -1008;
    public static final int IABHELPER_UNKNOWN_PURCHASE_RESPONSE = -1006;
    public static final int IABHELPER_USER_CANCELLED = -1005;
    public static final int IABHELPER_VERIFICATION_FAILED = -1003;
    public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    private static final int IN_APP_BILLING_API_VERSION_3 = 3;
    private static final int IN_APP_BILLING_API_VERSION_5 = 5;
    private static final int IN_APP_BILLING_API_VERSION_6 = 6;
    private static final int IN_APP_BILLING_API_VERSION_7 = 7;
    public static final String ITEM_TYPE_INAPP = "inapp";
    public static final String ITEM_TYPE_SUBS = "subs";
    public static final String RESPONSE_BUY_INTENT = "BUY_INTENT";
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    public static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
    public static final String RESPONSE_INAPP_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
    public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    public static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
    public static final String RESPONSE_INAPP_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
    public static HashMap<Integer, String> billingResponseCodeNames = new HashMap<>();
    /* access modifiers changed from: private */
    public Inventory inv;
    /* access modifiers changed from: private */
    public IActivityLauncher launcher;
    String mAsyncOperation = "";
    Context mContext;
    /* access modifiers changed from: private */
    public boolean mDaydreamApiAvailable = false;
    boolean mDebugLog = false;
    String mDebugTag = "IabHelper";
    volatile boolean mDisposed = false;
    OnIabPurchaseFinishedListener mPurchaseListener;
    String mPurchasingItemType;
    int mRequestCode;
    volatile boolean mSetupDone = false;
    boolean mSubscriptionPurchaseHistorySupported = false;
    boolean mSubscriptionUpgradeDowngradeSupported = false;
    boolean mSubscriptionsSupported = false;
    /* access modifiers changed from: private */
    public boolean mUnityVrEnabled = false;
    /* access modifiers changed from: private */
    public boolean mVrSupported = false;
    private IBillingServiceManager serviceManager;

    public interface OnConsumeFinishedListener {
        void onConsumeFinished(Purchase purchase, IabResult iabResult) throws JSONException;
    }

    public interface OnConsumeMultiFinishedListener {
        void onConsumeMultiFinished(List<Purchase> list, List<IabResult> list2);
    }

    public interface OnIabPurchaseFinishedListener {
        void onIabPurchaseFinished(IabResult iabResult, Purchase purchase);
    }

    public interface OnIabSetupFinishedListener {
        void onIabSetupFinished(IabResult iabResult);
    }

    public interface QueryInventoryFinishedListener {
        void onQueryInventoryFinished(IabResult iabResult, Inventory inventory) throws Exception;
    }

    static {
        billingResponseCodeNames.put(Integer.valueOf(0), "BILLING_RESPONSE_RESULT_OK");
        billingResponseCodeNames.put(Integer.valueOf(1), "BILLING_RESPONSE_RESULT_USER_CANCELED");
        billingResponseCodeNames.put(Integer.valueOf(2), "BILLING_RESPONSE_RESULT_SERVICE_UNAVAILABLE");
        billingResponseCodeNames.put(Integer.valueOf(3), "BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE");
        billingResponseCodeNames.put(Integer.valueOf(4), "BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE");
        billingResponseCodeNames.put(Integer.valueOf(5), "BILLING_RESPONSE_RESULT_DEVELOPER_ERROR");
        billingResponseCodeNames.put(Integer.valueOf(6), "BILLING_RESPONSE_RESULT_ERROR");
        billingResponseCodeNames.put(Integer.valueOf(7), "BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED");
        billingResponseCodeNames.put(Integer.valueOf(8), "BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED");
        billingResponseCodeNames.put(Integer.valueOf(-1000), "IABHELPER_ERROR_BASE");
        billingResponseCodeNames.put(Integer.valueOf(IABHELPER_REMOTE_EXCEPTION), "IABHELPER_REMOTE_EXCEPTION");
        billingResponseCodeNames.put(Integer.valueOf(IABHELPER_BAD_RESPONSE), "IABHELPER_BAD_RESPONSE");
        billingResponseCodeNames.put(Integer.valueOf(IABHELPER_VERIFICATION_FAILED), "IABHELPER_VERIFICATION_FAILED");
        billingResponseCodeNames.put(Integer.valueOf(IABHELPER_SEND_INTENT_FAILED), "IABHELPER_SEND_INTENT_FAILED");
        billingResponseCodeNames.put(Integer.valueOf(IABHELPER_USER_CANCELLED), "IABHELPER_USER_CANCELLED");
        billingResponseCodeNames.put(Integer.valueOf(IABHELPER_UNKNOWN_PURCHASE_RESPONSE), "IABHELPER_UNKNOWN_PURCHASE_RESPONSE");
        billingResponseCodeNames.put(Integer.valueOf(IABHELPER_MISSING_TOKEN), "IABHELPER_MISSING_TOKEN");
        billingResponseCodeNames.put(Integer.valueOf(IABHELPER_UNKNOWN_ERROR), "IABHELPER_UNKNOWN_ERROR");
        billingResponseCodeNames.put(Integer.valueOf(IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE), "IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE");
        billingResponseCodeNames.put(Integer.valueOf(IABHELPER_INVALID_CONSUMPTION), "IABHELPER_INVALID_CONSUMPTION");
    }

    public IabHelper(Context context, IBillingServiceManager iBillingServiceManager, IActivityLauncher iActivityLauncher) {
        this.mContext = context.getApplicationContext();
        this.serviceManager = iBillingServiceManager;
        this.launcher = iActivityLauncher;
        this.inv = new Inventory();
        logDebug("IAB helper created.");
    }

    public void enableDebugLogging(boolean z, String str) {
        this.mDebugLog = z;
        this.mDebugTag = str;
    }

    public void enableDebugLogging(boolean z) {
        this.mDebugLog = z;
    }

    public void enableUnityVr(boolean z) {
        this.mUnityVrEnabled = z;
    }

    public void enableDaydreamApi(boolean z) {
        this.mDaydreamApiAvailable = z;
    }

    public void startSetup(final OnIabSetupFinishedListener onIabSetupFinishedListener) {
        if (!this.mSetupDone) {
            logDebug("Starting in-app billing setup.");
            this.serviceManager.workWith(new BillingServiceProcessor() {
                public void workWith(IInAppBillingService iInAppBillingService) {
                    IabHelper.this.finishSetup(onIabSetupFinishedListener, iInAppBillingService);
                }
            });
            return;
        }
        throw new IllegalStateException("IAB helper is already set up.");
    }

    /* access modifiers changed from: private */
    public void finishSetup(OnIabSetupFinishedListener onIabSetupFinishedListener, IInAppBillingService iInAppBillingService) {
        String str = "subs";
        String str2 = "inapp";
        String packageName = this.mContext.getPackageName();
        try {
            logDebug("Checking for in-app billing 3 support.");
            int isBillingSupported = iInAppBillingService.isBillingSupported(3, packageName, str2);
            if (isBillingSupported != 0) {
                onIabSetupFinishedListener.onIabSetupFinished(new IabResult(isBillingSupported, "Billing V3 not supported."));
                this.mSubscriptionsSupported = false;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("In-app billing version 3 supported for ");
            sb.append(packageName);
            logDebug(sb.toString());
            int isBillingSupported2 = iInAppBillingService.isBillingSupported(3, packageName, str);
            if (isBillingSupported2 == 0) {
                logDebug("Subscriptions AVAILABLE.");
                this.mSubscriptionsSupported = true;
                if (iInAppBillingService.isBillingSupported(5, packageName, str) == 0) {
                    this.mSubscriptionUpgradeDowngradeSupported = true;
                    logDebug("Subscription upgrade and downgrade are AVAILABLE.");
                } else {
                    logDebug("Subscription upgrade and downgrade are NOT AVAILABLE.");
                }
                if (iInAppBillingService.isBillingSupported(6, packageName, str) == 0) {
                    this.mSubscriptionPurchaseHistorySupported = true;
                    logDebug("Subscriptions information parse AVAILABLE.");
                } else {
                    logDebug("Subscriptions information parse NOT AVAILABLE.");
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Subscriptions NOT AVAILABLE. Response: ");
                sb2.append(isBillingSupported2);
                logDebug(sb2.toString());
            }
            if (iInAppBillingService.isBillingSupported(7, packageName, str2) == 0) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("vr", true);
                int isBillingSupportedExtraParams = iInAppBillingService.isBillingSupportedExtraParams(7, this.mContext.getPackageName(), str2, bundle);
                if (isBillingSupportedExtraParams == 0) {
                    logDebug("VR supported.");
                    this.mVrSupported = true;
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("VR purchases  NOT AVAILABLE. Response: ");
                    sb3.append(isBillingSupportedExtraParams);
                    logDebug(sb3.toString());
                }
            } else {
                logDebug("In app billing version 7 is not supported");
            }
            this.mSetupDone = true;
            onIabSetupFinishedListener.onIabSetupFinished(new IabResult(0, "Setup successful."));
        } catch (RemoteException unused) {
            onIabSetupFinishedListener.onIabSetupFinished(new IabResult(IABHELPER_REMOTE_EXCEPTION, "RemoteException while setting up in-app billing."));
        }
    }

    public void dispose() {
        logDebug("Disposing.");
        this.mSetupDone = false;
        this.serviceManager.dispose();
        this.mDisposed = true;
    }

    public boolean subscriptionsSupported() {
        return this.mSubscriptionsSupported;
    }

    public boolean subscriptionPurchaseHistorySupported() {
        return this.mSubscriptionPurchaseHistorySupported;
    }

    public boolean subscriptionUpgradeDowngradeSupported() {
        return this.mSubscriptionUpgradeDowngradeSupported;
    }

    public void launchPurchaseFlow(Activity activity, String str, int i, OnIabPurchaseFinishedListener onIabPurchaseFinishedListener) {
        launchPurchaseFlow(activity, str, i, onIabPurchaseFinishedListener, "");
    }

    public void launchPurchaseFlow(Activity activity, String str, int i, OnIabPurchaseFinishedListener onIabPurchaseFinishedListener, String str2) {
        launchPurchaseFlow(activity, str, "inapp", i, onIabPurchaseFinishedListener, str2);
    }

    public void launchSubscriptionPurchaseFlow(Activity activity, String str, int i, OnIabPurchaseFinishedListener onIabPurchaseFinishedListener) {
        launchSubscriptionPurchaseFlow(activity, str, i, onIabPurchaseFinishedListener, "");
    }

    public void launchSubscriptionPurchaseFlow(Activity activity, String str, int i, OnIabPurchaseFinishedListener onIabPurchaseFinishedListener, String str2) {
        launchPurchaseFlow(activity, str, "subs", i, onIabPurchaseFinishedListener, str2);
    }

    public void launchSubscriptionUpdateFlow(Activity activity, String str, List<String> list, int i, OnIabPurchaseFinishedListener onIabPurchaseFinishedListener, String str2) {
        OnIabPurchaseFinishedListener onIabPurchaseFinishedListener2 = onIabPurchaseFinishedListener;
        checkSetupDone("launchSubscriptionUpdateFlow");
        if (!this.mSubscriptionsSupported || !this.mSubscriptionUpgradeDowngradeSupported) {
            IabResult iabResult = new IabResult(IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE, "Subscription upgrade/downgrade is not available.");
            if (onIabPurchaseFinishedListener2 != null) {
                onIabPurchaseFinishedListener2.onIabPurchaseFinished(iabResult, null);
            }
            return;
        }
        IBillingServiceManager iBillingServiceManager = this.serviceManager;
        final String str3 = str;
        final String str4 = str2;
        final List<String> list2 = list;
        final Activity activity2 = activity;
        final OnIabPurchaseFinishedListener onIabPurchaseFinishedListener3 = onIabPurchaseFinishedListener;
        final int i2 = i;
        C32792 r0 = new BillingServiceProcessor() {
            /* JADX WARNING: Removed duplicated region for block: B:23:0x010e A[Catch:{ JSONException -> 0x0114 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void workWith(com.android.vending.billing.IInAppBillingService r12) {
                /*
                    r11 = this;
                    java.lang.String r0 = "subs"
                    r1 = 0
                    com.unity.purchasing.googleplay.IabHelper r2 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r3.<init>()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r4 = "Constructing buy intent for "
                    r3.append(r4)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r4 = r2     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r3.append(r4)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r4 = ", item type: "
                    r3.append(r4)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r3.append(r0)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r3 = r3.toString()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r2.logDebug(r3)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    com.unity.purchasing.googleplay.IabHelper r2 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r3 = r3     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r2 = r2.getAccountId(r3)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    com.unity.purchasing.googleplay.IabHelper r3 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    boolean r3 = r3.mVrSupported     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    if (r3 == 0) goto L_0x0090
                    android.os.Bundle r10 = new android.os.Bundle     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r10.<init>()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    com.unity.purchasing.googleplay.IabHelper r3 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    boolean r3 = r3.mUnityVrEnabled     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r4 = 1
                    if (r3 == 0) goto L_0x004d
                    java.lang.String r3 = "vr"
                    r10.putBoolean(r3, r4)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    com.unity.purchasing.googleplay.IabHelper r3 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r5 = "Initiating VR purchase intent"
                    r3.logDebug(r5)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                L_0x004d:
                    if (r2 == 0) goto L_0x006a
                    java.lang.String r3 = "accountId"
                    r10.putString(r3, r2)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    com.unity.purchasing.googleplay.IabHelper r3 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r5.<init>()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r6 = "pass accountId to GooglePlay for fraud detection "
                    r5.append(r6)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r5.append(r2)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r2 = r5.toString()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r3.logDebug(r2)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                L_0x006a:
                    java.lang.String r2 = "skusToReplace"
                    java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.util.List r5 = r4     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r3.<init>(r5)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r10.putStringArrayList(r2, r3)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r2 = "replaceSkusProration"
                    r10.putBoolean(r2, r4)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r5 = 7
                    com.unity.purchasing.googleplay.IabHelper r2 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    android.content.Context r2 = r2.mContext     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r6 = r2.getPackageName()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r7 = r2     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r8 = "subs"
                    java.lang.String r9 = r3     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r4 = r12
                    android.os.Bundle r12 = r4.getBuyIntentExtraParams(r5, r6, r7, r8, r9, r10)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    goto L_0x00a6
                L_0x0090:
                    r3 = 5
                    com.unity.purchasing.googleplay.IabHelper r2 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    android.content.Context r2 = r2.mContext     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r4 = r2.getPackageName()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.util.List r5 = r4     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r6 = r2     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r7 = "subs"
                    java.lang.String r8 = r3     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r2 = r12
                    android.os.Bundle r12 = r2.getBuyIntentToReplaceSkus(r3, r4, r5, r6, r7, r8)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                L_0x00a6:
                    com.unity.purchasing.googleplay.IabHelper r2 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    int r2 = r2.getResponseCodeFromBundle(r12)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    if (r2 == 0) goto L_0x0119
                    com.unity.purchasing.googleplay.IabHelper r12 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r3.<init>()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r4 = "Unable to update subscription, Error response: "
                    r3.append(r4)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r4 = com.unity.purchasing.googleplay.IabHelper.getResponseDesc(r2)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r3.append(r4)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r3 = r3.toString()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r12.logError(r3)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    com.unity.purchasing.googleplay.IabResult r12 = new com.unity.purchasing.googleplay.IabResult     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r3 = "Unable to update subscription item"
                    r12.<init>(r2, r3)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    com.unity.purchasing.common.SaneJSONObject r3 = new com.unity.purchasing.common.SaneJSONObject     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r3.<init>()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r4 = "productId"
                    java.lang.String r5 = r2     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r3.put(r4, r5)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r4 = 7
                    if (r2 != r4) goto L_0x00f9
                    com.unity.purchasing.googleplay.IabHelper r2 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ JSONException -> 0x0114 }
                    com.unity.purchasing.googleplay.Inventory r2 = r2.inv     // Catch:{ JSONException -> 0x0114 }
                    java.lang.String r4 = r2     // Catch:{ JSONException -> 0x0114 }
                    boolean r2 = r2.hasPurchase(r4)     // Catch:{ JSONException -> 0x0114 }
                    if (r2 == 0) goto L_0x00f9
                    com.unity.purchasing.googleplay.IabHelper r0 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ JSONException -> 0x0114 }
                    com.unity.purchasing.googleplay.Inventory r0 = r0.inv     // Catch:{ JSONException -> 0x0114 }
                    java.lang.String r2 = r2     // Catch:{ JSONException -> 0x0114 }
                    com.unity.purchasing.googleplay.Purchase r0 = r0.getPurchase(r2)     // Catch:{ JSONException -> 0x0114 }
                    goto L_0x0105
                L_0x00f9:
                    com.unity.purchasing.googleplay.Purchase r2 = new com.unity.purchasing.googleplay.Purchase     // Catch:{ JSONException -> 0x0114 }
                    java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0114 }
                    java.lang.String r4 = ""
                    r2.<init>(r0, r3, r4)     // Catch:{ JSONException -> 0x0114 }
                    r0 = r2
                L_0x0105:
                    android.app.Activity r2 = r5     // Catch:{ JSONException -> 0x0114 }
                    r2.finish()     // Catch:{ JSONException -> 0x0114 }
                    com.unity.purchasing.googleplay.IabHelper$OnIabPurchaseFinishedListener r2 = r6     // Catch:{ JSONException -> 0x0114 }
                    if (r2 == 0) goto L_0x0113
                    com.unity.purchasing.googleplay.IabHelper$OnIabPurchaseFinishedListener r2 = r6     // Catch:{ JSONException -> 0x0114 }
                    r2.onIabPurchaseFinished(r12, r0)     // Catch:{ JSONException -> 0x0114 }
                L_0x0113:
                    return
                L_0x0114:
                    r12 = move-exception
                    r12.printStackTrace()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    return
                L_0x0119:
                    java.lang.String r2 = "BUY_INTENT"
                    android.os.Parcelable r12 = r12.getParcelable(r2)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r4 = r12
                    android.app.PendingIntent r4 = (android.app.PendingIntent) r4     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    com.unity.purchasing.googleplay.IabHelper r12 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r2.<init>()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r3 = "Launching buy intent for "
                    r2.append(r3)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r3 = r2     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r2.append(r3)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r3 = ". Request code: "
                    r2.append(r3)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    int r3 = r7     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r2.append(r3)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r2 = r2.toString()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r12.logDebug(r2)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    com.unity.purchasing.googleplay.IabHelper r12 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    int r2 = r7     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r12.mRequestCode = r2     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    com.unity.purchasing.googleplay.IabHelper r12 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    com.unity.purchasing.googleplay.IabHelper$OnIabPurchaseFinishedListener r2 = r6     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r12.mPurchaseListener = r2     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    com.unity.purchasing.googleplay.IabHelper r12 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r12.mPurchasingItemType = r0     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    com.unity.purchasing.googleplay.IabHelper r12 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    boolean r12 = r12.mVrSupported     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    if (r12 == 0) goto L_0x017e
                    com.unity.purchasing.googleplay.IabHelper r12 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    boolean r12 = r12.mUnityVrEnabled     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    if (r12 == 0) goto L_0x017e
                    com.unity.purchasing.googleplay.IabHelper r12 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    boolean r12 = r12.mDaydreamApiAvailable     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    if (r12 == 0) goto L_0x017e
                    com.unity.purchasing.googleplay.IabHelper$2$1 r12 = new com.unity.purchasing.googleplay.IabHelper$2$1     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r12.<init>(r4)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    android.os.Handler r0 = new android.os.Handler     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r0.<init>(r2)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r0.post(r12)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    goto L_0x01ef
                L_0x017e:
                    r4.getIntentSender()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    com.unity.purchasing.googleplay.IabHelper r12 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    com.unity.purchasing.googleplay.IActivityLauncher r2 = r12.launcher     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    android.app.Activity r3 = r5     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    int r5 = r7     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    android.content.Intent r6 = new android.content.Intent     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r6.<init>()     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    java.lang.String r7 = r2     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    r2.startIntentSenderForResult(r3, r4, r5, r6, r7)     // Catch:{ SendIntentException -> 0x01c3, RemoteException -> 0x0196 }
                    goto L_0x01ef
                L_0x0196:
                    r12 = move-exception
                    com.unity.purchasing.googleplay.IabHelper r0 = com.unity.purchasing.googleplay.IabHelper.this
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "RemoteException while launching purchase flow for sku "
                    r2.append(r3)
                    java.lang.String r3 = r2
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    r0.logError(r2)
                    r12.printStackTrace()
                    com.unity.purchasing.googleplay.IabResult r12 = new com.unity.purchasing.googleplay.IabResult
                    r0 = -1001(0xfffffffffffffc17, float:NaN)
                    java.lang.String r2 = "Remote exception while starting purchase flow"
                    r12.<init>(r0, r2)
                    com.unity.purchasing.googleplay.IabHelper$OnIabPurchaseFinishedListener r0 = r6
                    if (r0 == 0) goto L_0x01ef
                    r0.onIabPurchaseFinished(r12, r1)
                    goto L_0x01ef
                L_0x01c3:
                    r12 = move-exception
                    com.unity.purchasing.googleplay.IabHelper r0 = com.unity.purchasing.googleplay.IabHelper.this
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "SendIntentException while launching purchase flow for sku "
                    r2.append(r3)
                    java.lang.String r3 = r2
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    r0.logError(r2)
                    r12.printStackTrace()
                    com.unity.purchasing.googleplay.IabResult r12 = new com.unity.purchasing.googleplay.IabResult
                    r0 = -1004(0xfffffffffffffc14, float:NaN)
                    java.lang.String r2 = "Failed to send intent."
                    r12.<init>(r0, r2)
                    com.unity.purchasing.googleplay.IabHelper$OnIabPurchaseFinishedListener r0 = r6
                    if (r0 == 0) goto L_0x01ef
                    r0.onIabPurchaseFinished(r12, r1)
                L_0x01ef:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.unity.purchasing.googleplay.IabHelper.C32792.workWith(com.android.vending.billing.IInAppBillingService):void");
            }
        };
        iBillingServiceManager.workWith(r0);
    }

    public void launchPurchaseFlow(Activity activity, String str, String str2, int i, OnIabPurchaseFinishedListener onIabPurchaseFinishedListener, String str3) {
        OnIabPurchaseFinishedListener onIabPurchaseFinishedListener2 = onIabPurchaseFinishedListener;
        checkSetupDone("launchPurchaseFlow");
        String str4 = str2;
        if (!str2.equals("subs") || this.mSubscriptionsSupported) {
            IBillingServiceManager iBillingServiceManager = this.serviceManager;
            final String str5 = str;
            final String str6 = str2;
            final String str7 = str3;
            final Activity activity2 = activity;
            final OnIabPurchaseFinishedListener onIabPurchaseFinishedListener3 = onIabPurchaseFinishedListener;
            final int i2 = i;
            C32813 r0 = new BillingServiceProcessor() {
                /* JADX WARNING: Removed duplicated region for block: B:23:0x00fc A[Catch:{ JSONException -> 0x0102 }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void workWith(com.android.vending.billing.IInAppBillingService r11) {
                    /*
                        r10 = this;
                        r0 = 0
                        com.unity.purchasing.googleplay.IabHelper r1 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r2.<init>()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r3 = "Constructing buy intent for "
                        r2.append(r3)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r3 = r2     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r2.append(r3)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r3 = ", item type: "
                        r2.append(r3)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r3 = r3     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r2.append(r3)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r2 = r2.toString()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r1.logDebug(r2)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        com.unity.purchasing.googleplay.IabHelper r1 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r2 = r4     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r1 = r1.getAccountId(r2)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        com.unity.purchasing.googleplay.IabHelper r2 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        boolean r2 = r2.mVrSupported     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        if (r2 == 0) goto L_0x007f
                        android.os.Bundle r9 = new android.os.Bundle     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r9.<init>()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        com.unity.purchasing.googleplay.IabHelper r2 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        boolean r2 = r2.mUnityVrEnabled     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        if (r2 == 0) goto L_0x004d
                        java.lang.String r2 = "vr"
                        r3 = 1
                        r9.putBoolean(r2, r3)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        com.unity.purchasing.googleplay.IabHelper r2 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r3 = "Initiating VR purchase intent"
                        r2.logDebug(r3)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                    L_0x004d:
                        if (r1 == 0) goto L_0x006a
                        java.lang.String r2 = "accountId"
                        r9.putString(r2, r1)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        com.unity.purchasing.googleplay.IabHelper r2 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r3.<init>()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r4 = "pass accountId to GooglePlay for fraud detection, and accountId is: "
                        r3.append(r4)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r3.append(r1)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r1 = r3.toString()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r2.logDebug(r1)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                    L_0x006a:
                        r4 = 7
                        com.unity.purchasing.googleplay.IabHelper r1 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        android.content.Context r1 = r1.mContext     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r5 = r1.getPackageName()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r6 = r2     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r7 = r3     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r8 = r4     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r3 = r11
                        android.os.Bundle r11 = r3.getBuyIntentExtraParams(r4, r5, r6, r7, r8, r9)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        goto L_0x0093
                    L_0x007f:
                        r2 = 3
                        com.unity.purchasing.googleplay.IabHelper r1 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        android.content.Context r1 = r1.mContext     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r3 = r1.getPackageName()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r4 = r2     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r5 = r3     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r6 = r4     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r1 = r11
                        android.os.Bundle r11 = r1.getBuyIntent(r2, r3, r4, r5, r6)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                    L_0x0093:
                        com.unity.purchasing.googleplay.IabHelper r1 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        int r1 = r1.getResponseCodeFromBundle(r11)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        if (r1 == 0) goto L_0x0107
                        com.unity.purchasing.googleplay.IabHelper r11 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r2.<init>()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r3 = "Unable to buy item, Error response: "
                        r2.append(r3)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r3 = com.unity.purchasing.googleplay.IabHelper.getResponseDesc(r1)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r2.append(r3)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r2 = r2.toString()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r11.logError(r2)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        com.unity.purchasing.googleplay.IabResult r11 = new com.unity.purchasing.googleplay.IabResult     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r2 = "Unable to buy item"
                        r11.<init>(r1, r2)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        com.unity.purchasing.common.SaneJSONObject r2 = new com.unity.purchasing.common.SaneJSONObject     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r2.<init>()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r3 = "productId"
                        java.lang.String r4 = r2     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r2.put(r3, r4)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r3 = 7
                        if (r1 != r3) goto L_0x00e6
                        com.unity.purchasing.googleplay.IabHelper r1 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ JSONException -> 0x0102 }
                        com.unity.purchasing.googleplay.Inventory r1 = r1.inv     // Catch:{ JSONException -> 0x0102 }
                        java.lang.String r3 = r2     // Catch:{ JSONException -> 0x0102 }
                        boolean r1 = r1.hasPurchase(r3)     // Catch:{ JSONException -> 0x0102 }
                        if (r1 == 0) goto L_0x00e6
                        com.unity.purchasing.googleplay.IabHelper r1 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ JSONException -> 0x0102 }
                        com.unity.purchasing.googleplay.Inventory r1 = r1.inv     // Catch:{ JSONException -> 0x0102 }
                        java.lang.String r2 = r2     // Catch:{ JSONException -> 0x0102 }
                        com.unity.purchasing.googleplay.Purchase r1 = r1.getPurchase(r2)     // Catch:{ JSONException -> 0x0102 }
                        goto L_0x00f3
                    L_0x00e6:
                        com.unity.purchasing.googleplay.Purchase r1 = new com.unity.purchasing.googleplay.Purchase     // Catch:{ JSONException -> 0x0102 }
                        java.lang.String r3 = r3     // Catch:{ JSONException -> 0x0102 }
                        java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0102 }
                        java.lang.String r4 = ""
                        r1.<init>(r3, r2, r4)     // Catch:{ JSONException -> 0x0102 }
                    L_0x00f3:
                        android.app.Activity r2 = r5     // Catch:{ JSONException -> 0x0102 }
                        r2.finish()     // Catch:{ JSONException -> 0x0102 }
                        com.unity.purchasing.googleplay.IabHelper$OnIabPurchaseFinishedListener r2 = r6     // Catch:{ JSONException -> 0x0102 }
                        if (r2 == 0) goto L_0x0101
                        com.unity.purchasing.googleplay.IabHelper$OnIabPurchaseFinishedListener r2 = r6     // Catch:{ JSONException -> 0x0102 }
                        r2.onIabPurchaseFinished(r11, r1)     // Catch:{ JSONException -> 0x0102 }
                    L_0x0101:
                        return
                    L_0x0102:
                        r11 = move-exception
                        r11.printStackTrace()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        return
                    L_0x0107:
                        java.lang.String r1 = "BUY_INTENT"
                        android.os.Parcelable r11 = r11.getParcelable(r1)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r3 = r11
                        android.app.PendingIntent r3 = (android.app.PendingIntent) r3     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        com.unity.purchasing.googleplay.IabHelper r11 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r1.<init>()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r2 = "Launching buy intent for "
                        r1.append(r2)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r2 = r2     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r1.append(r2)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r2 = ". Request code: "
                        r1.append(r2)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        int r2 = r7     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r1.append(r2)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r1 = r1.toString()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r11.logDebug(r1)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        com.unity.purchasing.googleplay.IabHelper r11 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        int r1 = r7     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r11.mRequestCode = r1     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        com.unity.purchasing.googleplay.IabHelper r11 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        com.unity.purchasing.googleplay.IabHelper$OnIabPurchaseFinishedListener r1 = r6     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r11.mPurchaseListener = r1     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        com.unity.purchasing.googleplay.IabHelper r11 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r1 = r3     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r11.mPurchasingItemType = r1     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        com.unity.purchasing.googleplay.IabHelper r11 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        boolean r11 = r11.mVrSupported     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        if (r11 == 0) goto L_0x016e
                        com.unity.purchasing.googleplay.IabHelper r11 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        boolean r11 = r11.mUnityVrEnabled     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        if (r11 == 0) goto L_0x016e
                        com.unity.purchasing.googleplay.IabHelper r11 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        boolean r11 = r11.mDaydreamApiAvailable     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        if (r11 == 0) goto L_0x016e
                        com.unity.purchasing.googleplay.IabHelper$3$1 r11 = new com.unity.purchasing.googleplay.IabHelper$3$1     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r11.<init>(r3)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        android.os.Handler r1 = new android.os.Handler     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r1.<init>(r2)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r1.post(r11)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        goto L_0x01df
                    L_0x016e:
                        r3.getIntentSender()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        com.unity.purchasing.googleplay.IabHelper r11 = com.unity.purchasing.googleplay.IabHelper.this     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        com.unity.purchasing.googleplay.IActivityLauncher r1 = r11.launcher     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        android.app.Activity r2 = r5     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        int r4 = r7     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        android.content.Intent r5 = new android.content.Intent     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r5.<init>()     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        java.lang.String r6 = r2     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        r1.startIntentSenderForResult(r2, r3, r4, r5, r6)     // Catch:{ SendIntentException -> 0x01b3, RemoteException -> 0x0186 }
                        goto L_0x01df
                    L_0x0186:
                        r11 = move-exception
                        com.unity.purchasing.googleplay.IabHelper r1 = com.unity.purchasing.googleplay.IabHelper.this
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "RemoteException while launching purchase flow for sku "
                        r2.append(r3)
                        java.lang.String r3 = r2
                        r2.append(r3)
                        java.lang.String r2 = r2.toString()
                        r1.logError(r2)
                        r11.printStackTrace()
                        com.unity.purchasing.googleplay.IabResult r11 = new com.unity.purchasing.googleplay.IabResult
                        r1 = -1001(0xfffffffffffffc17, float:NaN)
                        java.lang.String r2 = "Remote exception while starting purchase flow"
                        r11.<init>(r1, r2)
                        com.unity.purchasing.googleplay.IabHelper$OnIabPurchaseFinishedListener r1 = r6
                        if (r1 == 0) goto L_0x01df
                        r1.onIabPurchaseFinished(r11, r0)
                        goto L_0x01df
                    L_0x01b3:
                        r11 = move-exception
                        com.unity.purchasing.googleplay.IabHelper r1 = com.unity.purchasing.googleplay.IabHelper.this
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "SendIntentException while launching purchase flow for sku "
                        r2.append(r3)
                        java.lang.String r3 = r2
                        r2.append(r3)
                        java.lang.String r2 = r2.toString()
                        r1.logError(r2)
                        r11.printStackTrace()
                        com.unity.purchasing.googleplay.IabResult r11 = new com.unity.purchasing.googleplay.IabResult
                        r1 = -1004(0xfffffffffffffc14, float:NaN)
                        java.lang.String r2 = "Failed to send intent."
                        r11.<init>(r1, r2)
                        com.unity.purchasing.googleplay.IabHelper$OnIabPurchaseFinishedListener r1 = r6
                        if (r1 == 0) goto L_0x01df
                        r1.onIabPurchaseFinished(r11, r0)
                    L_0x01df:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity.purchasing.googleplay.IabHelper.C32813.workWith(com.android.vending.billing.IInAppBillingService):void");
                }
            };
            iBillingServiceManager.workWith(r0);
            return;
        }
        IabResult iabResult = new IabResult(IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE, "Subscriptions are not available.");
        if (onIabPurchaseFinishedListener2 != null) {
            onIabPurchaseFinishedListener2.onIabPurchaseFinished(iabResult, null);
        }
    }

    public boolean handleActivityResult(int i, int i2, Intent intent) {
        if (i != this.mRequestCode) {
            return false;
        }
        checkSetupDone("handleActivityResult");
        if (intent == null) {
            logError("Null data in IAB activity result.");
            IabResult iabResult = new IabResult(IABHELPER_BAD_RESPONSE, "Null data in IAB result");
            OnIabPurchaseFinishedListener onIabPurchaseFinishedListener = this.mPurchaseListener;
            if (onIabPurchaseFinishedListener != null) {
                onIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult, null);
            }
            return true;
        }
        int responseCodeFromIntent = getResponseCodeFromIntent(intent);
        String stringExtra = intent.getStringExtra(RESPONSE_INAPP_PURCHASE_DATA);
        String stringExtra2 = intent.getStringExtra(RESPONSE_INAPP_SIGNATURE);
        StringBuilder sb = new StringBuilder();
        String str = "Purchase data: ";
        sb.append(str);
        sb.append(stringExtra);
        logDebug(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        String str2 = "Data signature: ";
        sb2.append(str2);
        sb2.append(stringExtra2);
        logDebug(sb2.toString());
        if (i2 == -1 && responseCodeFromIntent == 0) {
            logDebug("Successful resultcode from purchase activity.");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(stringExtra);
            logDebug(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str2);
            sb4.append(stringExtra2);
            logDebug(sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            String str3 = "Extras: ";
            sb5.append(str3);
            sb5.append(intent.getExtras());
            logDebug(sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Expected item type: ");
            sb6.append(this.mPurchasingItemType);
            logDebug(sb6.toString());
            if (stringExtra == null || stringExtra2 == null) {
                logError("BUG: either purchaseData or dataSignature is null.");
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str3);
                sb7.append(intent.getExtras().toString());
                logDebug(sb7.toString());
                IabResult iabResult2 = new IabResult(IABHELPER_UNKNOWN_ERROR, "IAB returned null purchaseData or dataSignature");
                OnIabPurchaseFinishedListener onIabPurchaseFinishedListener2 = this.mPurchaseListener;
                if (onIabPurchaseFinishedListener2 != null) {
                    onIabPurchaseFinishedListener2.onIabPurchaseFinished(iabResult2, null);
                }
                return true;
            }
            try {
                Purchase purchase = new Purchase(this.mPurchasingItemType, stringExtra, stringExtra2);
                purchase.getSku();
                OnIabPurchaseFinishedListener onIabPurchaseFinishedListener3 = this.mPurchaseListener;
                if (onIabPurchaseFinishedListener3 != null) {
                    onIabPurchaseFinishedListener3.onIabPurchaseFinished(new IabResult(0, "Success"), purchase);
                }
            } catch (JSONException e) {
                String str4 = "Failed to parse purchase data.";
                logError(str4);
                e.printStackTrace();
                IabResult iabResult3 = new IabResult(IABHELPER_BAD_RESPONSE, str4);
                OnIabPurchaseFinishedListener onIabPurchaseFinishedListener4 = this.mPurchaseListener;
                if (onIabPurchaseFinishedListener4 != null) {
                    onIabPurchaseFinishedListener4.onIabPurchaseFinished(iabResult3, null);
                }
                return true;
            }
        } else if (i2 == -1) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Result code was OK but in-app billing response was not OK: ");
            sb8.append(getResponseDesc(responseCodeFromIntent));
            logDebug(sb8.toString());
            if (this.mPurchaseListener != null) {
                this.mPurchaseListener.onIabPurchaseFinished(new IabResult(responseCodeFromIntent, "Problem purchasing item."), null);
            }
        } else if (i2 == 0) {
            StringBuilder sb9 = new StringBuilder();
            sb9.append("Purchase canceled - Response: ");
            sb9.append(getResponseDesc(responseCodeFromIntent));
            logDebug(sb9.toString());
            IabResult iabResult4 = new IabResult(responseCodeFromIntent, getResponseDesc(responseCodeFromIntent));
            OnIabPurchaseFinishedListener onIabPurchaseFinishedListener5 = this.mPurchaseListener;
            if (onIabPurchaseFinishedListener5 != null) {
                onIabPurchaseFinishedListener5.onIabPurchaseFinished(iabResult4, null);
            }
        } else {
            StringBuilder sb10 = new StringBuilder();
            sb10.append("Purchase failed. Result code: ");
            sb10.append(Integer.toString(i2));
            sb10.append(". Response: ");
            sb10.append(getResponseDesc(responseCodeFromIntent));
            logError(sb10.toString());
            IabResult iabResult5 = new IabResult(IABHELPER_UNKNOWN_PURCHASE_RESPONSE, "Unknown purchase response.");
            OnIabPurchaseFinishedListener onIabPurchaseFinishedListener6 = this.mPurchaseListener;
            if (onIabPurchaseFinishedListener6 != null) {
                onIabPurchaseFinishedListener6.onIabPurchaseFinished(iabResult5, null);
            }
        }
        return true;
    }

    public Inventory queryInventory(boolean z, List<String> list, IInAppBillingService iInAppBillingService) throws IabException {
        return queryInventory(z, list, null, iInAppBillingService);
    }

    public Inventory queryInventory(boolean z, List<String> list, List<String> list2, IInAppBillingService iInAppBillingService) throws IabException {
        String str = "inapp";
        checkSetupDone("queryInventory");
        try {
            int queryPurchases = queryPurchases(this.inv, str, iInAppBillingService);
            if (queryPurchases == 0) {
                if (z) {
                    int querySkuDetails = querySkuDetails(str, this.inv, list, iInAppBillingService);
                    if (querySkuDetails != 0) {
                        throw new IabException(querySkuDetails, "Error refreshing inventory (querying prices of items).");
                    }
                }
                String str2 = "subs";
                if (this.mSubscriptionsSupported) {
                    int queryPurchases2 = queryPurchases(this.inv, str2, iInAppBillingService);
                    if (queryPurchases2 != 0) {
                        throw new IabException(queryPurchases2, "Error refreshing inventory (querying owned subscriptions).");
                    } else if (z) {
                        int querySkuDetails2 = querySkuDetails(str2, this.inv, list, iInAppBillingService);
                        if (querySkuDetails2 != 0) {
                            throw new IabException(querySkuDetails2, "Error refreshing inventory (querying prices of subscriptions).");
                        }
                    }
                }
                if (this.mSubscriptionPurchaseHistorySupported) {
                    queryPurchaseHistory(this.inv, str2, iInAppBillingService);
                    int queryPurchaseHistory = queryPurchaseHistory(this.inv, str, iInAppBillingService);
                    if (queryPurchaseHistory != 0) {
                        throw new IabException(queryPurchaseHistory, "Error query Purchase History");
                    }
                }
                return this.inv;
            }
            throw new IabException(queryPurchases, "Error refreshing inventory (querying owned items).");
        } catch (RemoteException e) {
            throw new IabException(IABHELPER_REMOTE_EXCEPTION, "Remote exception while refreshing inventory.", e);
        } catch (JSONException e2) {
            throw new IabException(IABHELPER_BAD_RESPONSE, "Error parsing JSON response while refreshing inventory.", e2);
        } catch (SecurityException e3) {
            throw new IabException(IABHELPER_UNKNOWN_ERROR, "SecurityException querying inventory, update Google Play - https://github.com/googlesamples/android-play-billing/issues/26", e3);
        }
    }

    public void queryInventoryAsync(boolean z, List<String> list, QueryInventoryFinishedListener queryInventoryFinishedListener, long j) {
        checkSetupDone("queryInventory");
        IBillingServiceManager iBillingServiceManager = this.serviceManager;
        final long j2 = j;
        final boolean z2 = z;
        final List<String> list2 = list;
        final QueryInventoryFinishedListener queryInventoryFinishedListener2 = queryInventoryFinishedListener;
        C32834 r1 = new BillingServiceProcessor() {
            public void workWith(IInAppBillingService iInAppBillingService) {
                try {
                    Thread.sleep(j2);
                } catch (InterruptedException unused) {
                }
                IabResult iabResult = new IabResult(0, "Inventory refresh successful.");
                Inventory inventory = null;
                try {
                    inventory = IabHelper.this.queryInventory(z2, list2, iInAppBillingService);
                } catch (IabException e) {
                    iabResult = e.getResult();
                }
                if (!IabHelper.this.mDisposed) {
                    QueryInventoryFinishedListener queryInventoryFinishedListener = queryInventoryFinishedListener2;
                    if (queryInventoryFinishedListener != null) {
                        try {
                            queryInventoryFinishedListener.onQueryInventoryFinished(iabResult, inventory);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        };
        iBillingServiceManager.workWith(r1);
    }

    public void queryInventoryAsync(QueryInventoryFinishedListener queryInventoryFinishedListener) {
        queryInventoryAsync(true, null, queryInventoryFinishedListener, 0);
    }

    public void queryInventoryAsync(boolean z, QueryInventoryFinishedListener queryInventoryFinishedListener) {
        queryInventoryAsync(z, null, queryInventoryFinishedListener, 0);
    }

    /* access modifiers changed from: 0000 */
    public void consume(Purchase purchase, IInAppBillingService iInAppBillingService) throws IabException {
        if (purchase.mItemType.equals("inapp")) {
            try {
                String token = purchase.getToken();
                String sku = purchase.getSku();
                if (token == null || token.equals("")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Can't consume ");
                    sb.append(sku);
                    sb.append(". No token.");
                    logError(sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("PurchaseInfo is missing token for sku: ");
                    sb2.append(sku);
                    sb2.append(" ");
                    sb2.append(purchase);
                    throw new IabException((int) IABHELPER_MISSING_TOKEN, sb2.toString());
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Consuming sku: ");
                sb3.append(sku);
                sb3.append(", token: ");
                sb3.append(token);
                logDebug(sb3.toString());
                int consumePurchase = iInAppBillingService.consumePurchase(3, this.mContext.getPackageName(), token);
                if (consumePurchase == 0) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Successfully consumed sku: ");
                    sb4.append(sku);
                    logDebug(sb4.toString());
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Error consuming consuming sku ");
                sb5.append(sku);
                sb5.append(". ");
                sb5.append(getResponseDesc(consumePurchase));
                logDebug(sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Error consuming sku ");
                sb6.append(sku);
                throw new IabException(consumePurchase, sb6.toString());
            } catch (RemoteException e) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Remote exception while consuming. PurchaseInfo: ");
                sb7.append(purchase);
                throw new IabException(IABHELPER_REMOTE_EXCEPTION, sb7.toString(), e);
            }
        } else {
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Items of type '");
            sb8.append(purchase.mItemType);
            sb8.append("' can't be consumed.");
            throw new IabException((int) IABHELPER_INVALID_CONSUMPTION, sb8.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void consumeSilently(Purchase purchase, IInAppBillingService iInAppBillingService) throws IabException {
        if (purchase.mItemType.equals("inapp")) {
            try {
                String token = purchase.getToken();
                purchase.getSku();
                if (token != null) {
                    if (!token.equals("")) {
                        iInAppBillingService.consumePurchase(3, this.mContext.getPackageName(), token);
                    }
                }
            } catch (RemoteException unused) {
            }
        }
    }

    public void consumeAsync(Purchase purchase, OnConsumeFinishedListener onConsumeFinishedListener, boolean z) {
        checkSetupDone("consume");
        ArrayList arrayList = new ArrayList();
        arrayList.add(purchase);
        consumeAsyncInternal(arrayList, onConsumeFinishedListener, null, z);
    }

    public void consumeAsync(List<Purchase> list, OnConsumeMultiFinishedListener onConsumeMultiFinishedListener, boolean z) {
        checkSetupDone("consume");
        consumeAsyncInternal(list, null, onConsumeMultiFinishedListener, z);
    }

    public static String getResponseDesc(int i) {
        String str = Constants.URL_PATH_DELIMITER;
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split(str);
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split(str);
        if (i <= -1000) {
            int i2 = -1000 - i;
            if (i2 >= 0 && i2 < split2.length) {
                return split2[i2];
            }
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(i));
            sb.append(":Unknown IAB Helper Error");
            return sb.toString();
        } else if (i >= 0 && i < split.length) {
            return split[i];
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.valueOf(i));
            sb2.append(":Unknown");
            return sb2.toString();
        }
    }

    /* access modifiers changed from: 0000 */
    public void checkSetupDone(String str) {
        if (!this.mSetupDone) {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal state for operation (");
            sb.append(str);
            sb.append("): IAB helper is not set up.");
            logError(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("IAB helper is not set up. Can't perform operation: ");
            sb2.append(str);
            throw new IllegalStateException(sb2.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public int getResponseCodeFromBundle(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            logDebug("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            logError("Unexpected type for bundle response code.");
            logError(obj.getClass().getName());
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected type for bundle response code: ");
            sb.append(obj.getClass().getName());
            throw new RuntimeException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public int getResponseCodeFromIntent(Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            logError("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            logError("Unexpected type for intent response code.");
            logError(obj.getClass().getName());
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected type for intent response code: ");
            sb.append(obj.getClass().getName());
            throw new RuntimeException(sb.toString());
        }
    }

    public int queryPurchaseHistory(Inventory inventory, String str, IInAppBillingService iInAppBillingService) throws JSONException, RemoteException {
        if (this.mDisposed) {
            logDebug("queryPurchase History - Biller disposed. Returning...");
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Querying owned items' purchase history, item type: ");
        sb.append(str);
        logDebug(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Package name: ");
        sb2.append(this.mContext.getPackageName());
        logDebug(sb2.toString());
        String str2 = null;
        do {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Calling getPurchaseHistory with continuation token: ");
            sb3.append(str2);
            logDebug(sb3.toString());
            Bundle purchaseHistory = iInAppBillingService.getPurchaseHistory(6, this.mContext.getPackageName(), str, str2, new Bundle());
            if (purchaseHistory == null) {
                return 0;
            }
            int responseCodeFromBundle = getResponseCodeFromBundle(purchaseHistory);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Purchase history response: ");
            sb4.append(String.valueOf(responseCodeFromBundle));
            logDebug(sb4.toString());
            if (responseCodeFromBundle != 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getPurchaseHistory() failed: ");
                sb5.append(getResponseDesc(responseCodeFromBundle));
                logDebug(sb5.toString());
                return responseCodeFromBundle;
            }
            String str3 = RESPONSE_INAPP_ITEM_LIST;
            if (purchaseHistory.containsKey(str3)) {
                String str4 = RESPONSE_INAPP_PURCHASE_DATA_LIST;
                if (purchaseHistory.containsKey(str4)) {
                    String str5 = RESPONSE_INAPP_SIGNATURE_LIST;
                    if (purchaseHistory.containsKey(str5)) {
                        ArrayList stringArrayList = purchaseHistory.getStringArrayList(str3);
                        if (str.equals("inapp")) {
                            ArrayList stringArrayList2 = purchaseHistory.getStringArrayList(str4);
                            ArrayList stringArrayList3 = purchaseHistory.getStringArrayList(str5);
                            for (int i = 0; i < stringArrayList2.size(); i++) {
                                String str6 = (String) stringArrayList2.get(i);
                                String str7 = (String) stringArrayList.get(i);
                                Purchase purchase = new Purchase(str, str6, (String) stringArrayList3.get(i));
                                if (TextUtils.isEmpty(purchase.getToken())) {
                                    logWarn("BUG: empty/null token!");
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("Purchase data: ");
                                    sb6.append(str6);
                                    logDebug(sb6.toString());
                                }
                                inventory.addPurchaseToConsumablePurchaseHistory(str7, purchase);
                            }
                        }
                        if (str.equals("subs")) {
                            for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
                                inventory.addPurchaseToSubscriptionPurchaseHistory((String) stringArrayList.get(i2));
                            }
                        }
                        str2 = purchaseHistory.getString(INAPP_CONTINUATION_TOKEN);
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("Continuation token: ");
                        sb7.append(str2);
                        logDebug(sb7.toString());
                    }
                }
            }
            logError("Bundle returned from getPurchaseHistory() doesn't contain required fields.");
            return IABHELPER_BAD_RESPONSE;
        } while (!TextUtils.isEmpty(str2));
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public int queryPurchases(Inventory inventory, String str, IInAppBillingService iInAppBillingService) throws JSONException, RemoteException {
        if (this.mDisposed) {
            logDebug("queryPurchases - Biller disposed. Returning...");
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Querying owned items, item type: ");
        sb.append(str);
        logDebug(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Package name: ");
        sb2.append(this.mContext.getPackageName());
        logDebug(sb2.toString());
        String str2 = null;
        do {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Calling getPurchases with continuation token: ");
            sb3.append(str2);
            logDebug(sb3.toString());
            Bundle purchases = iInAppBillingService.getPurchases(3, this.mContext.getPackageName(), str, str2);
            int responseCodeFromBundle = getResponseCodeFromBundle(purchases);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Owned items response: ");
            sb4.append(String.valueOf(responseCodeFromBundle));
            logDebug(sb4.toString());
            if (responseCodeFromBundle != 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getPurchases() failed: ");
                sb5.append(getResponseDesc(responseCodeFromBundle));
                logDebug(sb5.toString());
                return responseCodeFromBundle;
            }
            String str3 = RESPONSE_INAPP_ITEM_LIST;
            if (purchases.containsKey(str3)) {
                String str4 = RESPONSE_INAPP_PURCHASE_DATA_LIST;
                if (purchases.containsKey(str4)) {
                    String str5 = RESPONSE_INAPP_SIGNATURE_LIST;
                    if (purchases.containsKey(str5)) {
                        ArrayList stringArrayList = purchases.getStringArrayList(str3);
                        ArrayList stringArrayList2 = purchases.getStringArrayList(str4);
                        ArrayList stringArrayList3 = purchases.getStringArrayList(str5);
                        for (int i = 0; i < stringArrayList2.size(); i++) {
                            String str6 = (String) stringArrayList2.get(i);
                            String str7 = (String) stringArrayList3.get(i);
                            String str8 = (String) stringArrayList.get(i);
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("Sku is owned: ");
                            sb6.append(str8);
                            logDebug(sb6.toString());
                            Purchase purchase = new Purchase(str, str6, str7);
                            if (TextUtils.isEmpty(purchase.getToken())) {
                                logWarn("BUG: empty/null token!");
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("Purchase data: ");
                                sb7.append(str6);
                                logDebug(sb7.toString());
                            }
                            inventory.addPurchase(purchase);
                        }
                        str2 = purchases.getString(INAPP_CONTINUATION_TOKEN);
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("Continuation token: ");
                        sb8.append(str2);
                        logDebug(sb8.toString());
                    }
                }
            }
            logError("Bundle returned from getPurchases() doesn't contain required fields.");
            return IABHELPER_BAD_RESPONSE;
        } while (!TextUtils.isEmpty(str2));
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public int querySkuDetails(String str, Inventory inventory, List<String> list, IInAppBillingService iInAppBillingService) throws RemoteException, JSONException {
        logDebug("Querying SKU details.");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(inventory.getAllOwnedSkus(str));
        if (list != null) {
            arrayList.addAll(list);
        }
        if (arrayList.size() == 0) {
            logDebug("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        }
        while (arrayList.size() > 0) {
            int min = Math.min(20, arrayList.size());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < min; i++) {
                arrayList2.add(arrayList.get(i));
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(GET_SKU_DETAILS_ITEM_LIST, arrayList2);
            Bundle skuDetails = iInAppBillingService.getSkuDetails(3, this.mContext.getPackageName(), str, bundle);
            arrayList.removeAll(arrayList2);
            String str2 = RESPONSE_GET_SKU_DETAILS_LIST;
            if (!skuDetails.containsKey(str2)) {
                int responseCodeFromBundle = getResponseCodeFromBundle(skuDetails);
                if (responseCodeFromBundle != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("getSkuDetails() failed: ");
                    sb.append(getResponseDesc(responseCodeFromBundle));
                    logDebug(sb.toString());
                    return responseCodeFromBundle;
                }
                logError("getSkuDetails() returned a bundle with neither an error nor a detail list.");
                return IABHELPER_BAD_RESPONSE;
            }
            Iterator it = skuDetails.getStringArrayList(str2).iterator();
            while (it.hasNext()) {
                inventory.addSkuDetails(new SkuDetails(str, (String) it.next()));
            }
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public void consumeAsyncInternal(List<Purchase> list, OnConsumeFinishedListener onConsumeFinishedListener, OnConsumeMultiFinishedListener onConsumeMultiFinishedListener, boolean z) {
        IBillingServiceManager iBillingServiceManager = this.serviceManager;
        final List<Purchase> list2 = list;
        final boolean z2 = z;
        final OnConsumeFinishedListener onConsumeFinishedListener2 = onConsumeFinishedListener;
        final OnConsumeMultiFinishedListener onConsumeMultiFinishedListener2 = onConsumeMultiFinishedListener;
        C32845 r1 = new BillingServiceProcessor() {
            public void workWith(IInAppBillingService iInAppBillingService) {
                ArrayList arrayList = new ArrayList();
                for (Purchase purchase : list2) {
                    try {
                        if (z2) {
                            IabHelper.this.consumeSilently(purchase, iInAppBillingService);
                        } else {
                            IabHelper.this.consume(purchase, iInAppBillingService);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Successful consume of sku ");
                        sb.append(purchase.getSku());
                        arrayList.add(new IabResult(0, sb.toString()));
                    } catch (IabException e) {
                        arrayList.add(e.getResult());
                    }
                }
                if (!IabHelper.this.mDisposed) {
                    OnConsumeFinishedListener onConsumeFinishedListener = onConsumeFinishedListener2;
                    if (onConsumeFinishedListener != null) {
                        try {
                            onConsumeFinishedListener.onConsumeFinished((Purchase) list2.get(0), (IabResult) arrayList.get(0));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (!IabHelper.this.mDisposed) {
                    OnConsumeMultiFinishedListener onConsumeMultiFinishedListener = onConsumeMultiFinishedListener2;
                    if (onConsumeMultiFinishedListener != null) {
                        onConsumeMultiFinishedListener.onConsumeMultiFinished(list2, arrayList);
                    }
                }
            }
        };
        iBillingServiceManager.workWith(r1);
    }

    public static String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(String.format("%02x", new Object[]{Integer.valueOf(b & 255)}));
        }
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public void logDebug(String str) {
        Log.i("UnityIAP", str);
    }

    /* access modifiers changed from: 0000 */
    public void logError(String str) {
        String str2 = this.mDebugTag;
        StringBuilder sb = new StringBuilder();
        sb.append("In-app billing error: ");
        sb.append(str);
        Log.e(str2, sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void logWarn(String str) {
        String str2 = this.mDebugTag;
        StringBuilder sb = new StringBuilder();
        sb.append("In-app billing warning: ");
        sb.append(str);
        Log.w(str2, sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public String getAccountId(String str) {
        String str2 = "accountId";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(str2) || jSONObject.getString(str2) == null || jSONObject.getString(str2).isEmpty()) {
                return null;
            }
            String string = jSONObject.getString(str2);
            StringBuilder sb = new StringBuilder();
            sb.append("accountId is: ");
            sb.append(string);
            logDebug(sb.toString());
            return string;
        } catch (JSONException unused) {
            return null;
        }
    }
}
