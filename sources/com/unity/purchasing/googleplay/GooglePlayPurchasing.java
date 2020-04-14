package com.unity.purchasing.googleplay;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Base64;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.google.vr.ndk.base.DaydreamApi;
import com.unity.purchasing.common.IStoreCallback;
import com.unity.purchasing.common.IUnityCallback;
import com.unity.purchasing.common.InitializationFailureReason;
import com.unity.purchasing.common.ProductDefinition;
import com.unity.purchasing.common.ProductDescription;
import com.unity.purchasing.common.ProductMetadata;
import com.unity.purchasing.common.ProductType;
import com.unity.purchasing.common.PurchaseFailureDescription;
import com.unity.purchasing.common.PurchaseFailureReason;
import com.unity.purchasing.common.StoreDeserializer;
import com.unity.purchasing.common.UnityPurchasing;
import com.unity.purchasing.googleplay.IabHelper.OnConsumeFinishedListener;
import com.unity.purchasing.googleplay.IabHelper.OnIabPurchaseFinishedListener;
import com.unity.purchasing.googleplay.IabHelper.OnIabSetupFinishedListener;
import com.unity.purchasing.googleplay.IabHelper.QueryInventoryFinishedListener;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public class GooglePlayPurchasing extends StoreDeserializer {
    public static final int ACTIVITY_REQUEST_CODE = 999;
    protected static final String TAG = "UnityIAP";
    private static GooglePlayPurchasing instance;
    private static final boolean isDaydreamApiAvailable;
    public OnIabPurchaseFinishedListener PurchaseListener = new OnIabPurchaseFinishedListener() {
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00ae  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00b9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onIabPurchaseFinished(com.unity.purchasing.googleplay.IabResult r6, com.unity.purchasing.googleplay.Purchase r7) {
            /*
                r5 = this;
                com.unity.purchasing.googleplay.GooglePlayPurchasing r0 = com.unity.purchasing.googleplay.GooglePlayPurchasing.this
                boolean r0 = r0.purchaseInProgress
                if (r0 != 0) goto L_0x0009
                return
            L_0x0009:
                boolean r0 = r6.isSuccess()
                java.lang.String r0 = java.lang.Boolean.toString(r0)
                java.lang.String r1 = "onIabPurchaseFinished: %s"
                com.unity.purchasing.googleplay.GooglePlayPurchasing.log(r1, r0)
                java.lang.String r0 = r6.mMessage
                com.unity.purchasing.googleplay.GooglePlayPurchasing.log(r0)
                com.unity.purchasing.googleplay.GooglePlayPurchasing r0 = com.unity.purchasing.googleplay.GooglePlayPurchasing.this
                r1 = 0
                r0.purchaseInProgress = r1
                boolean r0 = r6.isSuccess()
                if (r0 == 0) goto L_0x0033
                java.lang.String r6 = "Product purchased successfully!"
                com.unity.purchasing.googleplay.GooglePlayPurchasing.log(r6)
                com.unity.purchasing.googleplay.GooglePlayPurchasing r6 = com.unity.purchasing.googleplay.GooglePlayPurchasing.this
                r6.NotifyUnityOfPurchase(r7)
                goto L_0x00c2
            L_0x0033:
                int r7 = r6.getResponse()
                java.lang.String r0 = java.lang.Integer.toString(r7)
                java.lang.String r1 = "Purchase response code:%s"
                com.unity.purchasing.googleplay.GooglePlayPurchasing.log(r1, r0)
                com.unity.purchasing.common.PurchaseFailureReason r0 = com.unity.purchasing.common.PurchaseFailureReason.Unknown
                com.unity.purchasing.googleplay.GooglePlayPurchasing r1 = com.unity.purchasing.googleplay.GooglePlayPurchasing.this
                java.util.HashSet r1 = r1.suspectFailedConsumableSkus
                com.unity.purchasing.googleplay.GooglePlayPurchasing r2 = com.unity.purchasing.googleplay.GooglePlayPurchasing.this
                com.unity.purchasing.common.ProductDefinition r2 = r2.productUnderPurchase
                java.lang.String r2 = r2.storeSpecificId
                r1.add(r2)
                r1 = -1005(0xfffffffffffffc13, float:NaN)
                if (r7 == r1) goto L_0x0078
                r1 = 7
                if (r7 == r1) goto L_0x006d
                r1 = 1
                if (r7 == r1) goto L_0x0078
                r1 = 2
                if (r7 == r1) goto L_0x006a
                r1 = 3
                if (r7 == r1) goto L_0x006a
                r1 = 4
                if (r7 == r1) goto L_0x0067
                goto L_0x007a
            L_0x0067:
                com.unity.purchasing.common.PurchaseFailureReason r0 = com.unity.purchasing.common.PurchaseFailureReason.ItemUnavailable
                goto L_0x007a
            L_0x006a:
                com.unity.purchasing.common.PurchaseFailureReason r0 = com.unity.purchasing.common.PurchaseFailureReason.BillingUnavailable
                goto L_0x007a
            L_0x006d:
                com.unity.purchasing.googleplay.GooglePlayPurchasing r1 = com.unity.purchasing.googleplay.GooglePlayPurchasing.this
                com.unity.purchasing.googleplay.GooglePlayPurchasing$Features r1 = r1.features
                boolean r1 = r1.supportsPurchaseFailureReasonDuplicateTransaction
                if (r1 == 0) goto L_0x007a
                com.unity.purchasing.common.PurchaseFailureReason r0 = com.unity.purchasing.common.PurchaseFailureReason.DuplicateTransaction
                goto L_0x007a
            L_0x0078:
                com.unity.purchasing.common.PurchaseFailureReason r0 = com.unity.purchasing.common.PurchaseFailureReason.UserCancelled
            L_0x007a:
                com.unity.purchasing.common.PurchaseFailureDescription r1 = new com.unity.purchasing.common.PurchaseFailureDescription
                com.unity.purchasing.googleplay.GooglePlayPurchasing r2 = com.unity.purchasing.googleplay.GooglePlayPurchasing.this
                com.unity.purchasing.common.ProductDefinition r2 = r2.productUnderPurchase
                java.lang.String r2 = r2.storeSpecificId
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "GOOGLEPLAY_"
                r3.append(r4)
                java.lang.String r4 = r6.mMessage
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                java.util.HashMap<java.lang.Integer, java.lang.String> r4 = com.unity.purchasing.googleplay.IabHelper.billingResponseCodeNames
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                java.lang.Object r7 = r4.get(r7)
                java.lang.String r7 = (java.lang.String) r7
                r1.<init>(r2, r0, r3, r7)
                int r6 = r6.getResponse()
                r7 = -1002(0xfffffffffffffc16, float:NaN)
                if (r6 != r7) goto L_0x00b9
                java.lang.String r6 = "Received bad response, polling for successful purchases to investigate failure more deeply"
                com.unity.purchasing.googleplay.GooglePlayPurchasing.log(r6)
                com.unity.purchasing.googleplay.GooglePlayPurchasing r6 = com.unity.purchasing.googleplay.GooglePlayPurchasing.this
                r6.reconcileFailedPurchaseWithInventory(r1)
                goto L_0x00c2
            L_0x00b9:
                com.unity.purchasing.googleplay.GooglePlayPurchasing r6 = com.unity.purchasing.googleplay.GooglePlayPurchasing.this
                com.unity.purchasing.common.IStoreCallback r6 = r6.unityPurchasing
                r6.OnPurchaseFailed(r1)
            L_0x00c2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity.purchasing.googleplay.GooglePlayPurchasing.C32703.onIabPurchaseFinished(com.unity.purchasing.googleplay.IabResult, com.unity.purchasing.googleplay.Purchase):void");
        }
    };
    public boolean activityPending;
    /* access modifiers changed from: private */
    public Context context;
    Features features = new Features();
    public IabHelper helper;
    /* access modifiers changed from: private */
    public Inventory inventory;
    private boolean isUnityVrEnabled;
    private IActivityLauncher launcher;
    private IBillingServiceManager manager;
    /* access modifiers changed from: private */
    public int offlineBackOffTime = 5000;
    public String productJSON;
    /* access modifiers changed from: private */
    public ProductDefinition productUnderPurchase;
    /* access modifiers changed from: private */
    public volatile boolean purchaseInProgress = false;
    private BroadcastReceiver purchasesUpdatedReceiver = null;
    private volatile boolean subscriptionUpdateInProgress = false;
    /* access modifiers changed from: private */
    public HashSet<String> suspectFailedConsumableSkus = new HashSet<>();
    /* access modifiers changed from: private */
    public IStoreCallback unityPurchasing;

    class Features {
        public boolean supportsPurchaseFailureReasonDuplicateTransaction;

        Features() {
        }
    }

    static {
        boolean z;
        try {
            Class.forName("com.google.vr.ndk.base.DaydreamApi");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        isDaydreamApiAvailable = z;
    }

    public static GooglePlayPurchasing instance(IUnityCallback iUnityCallback) {
        if (instance == null) {
            BillingServiceManager billingServiceManager = new BillingServiceManager(UnityPlayer.currentActivity);
            GooglePlayPurchasing googlePlayPurchasing = new GooglePlayPurchasing(new UnityPurchasing(iUnityCallback), new IabHelper(UnityPlayer.currentActivity, billingServiceManager, new ActivityLauncher()), billingServiceManager, UnityPlayer.currentActivity, new ActivityLauncher());
            instance = googlePlayPurchasing;
        }
        return instance;
    }

    public static boolean ContinuePurchase(Activity activity, String str, String str2) {
        GooglePlayPurchasing googlePlayPurchasing = instance;
        if (googlePlayPurchasing == null) {
            return false;
        }
        googlePlayPurchasing.StartPurchase(activity, str, str2);
        return true;
    }

    public static boolean ContinueSubscriptionUpdate(Activity activity, String str, String str2) {
        GooglePlayPurchasing googlePlayPurchasing = instance;
        if (googlePlayPurchasing == null) {
            return false;
        }
        googlePlayPurchasing.StartSubscriptionUpdate(activity, str, str2);
        return true;
    }

    public static void ProcessActivityResult(int i, int i2, Intent intent) {
        GooglePlayPurchasing googlePlayPurchasing = instance;
        if (googlePlayPurchasing != null) {
            googlePlayPurchasing.onActivityResult(i, i2, intent);
        }
    }

    public GooglePlayPurchasing(IStoreCallback iStoreCallback, IabHelper iabHelper, IBillingServiceManager iBillingServiceManager, Context context2, IActivityLauncher iActivityLauncher) {
        this.unityPurchasing = iStoreCallback;
        this.helper = iabHelper;
        this.helper.enableDaydreamApi(isDaydreamApiAvailable);
        this.manager = iBillingServiceManager;
        this.context = context2;
        this.launcher = iActivityLauncher;
        instance = this;
        registerPurchasesUpdatedReceiver();
    }

    public void SetUnityVrEnabled(boolean z) {
        this.isUnityVrEnabled = z;
        log("isUnityVrEnabled = %s", String.valueOf(this.isUnityVrEnabled));
    }

    public void RestoreTransactions(final IGooglePlayStoreCallback iGooglePlayStoreCallback) {
        this.helper.queryInventoryAsync(true, new ArrayList(), new QueryInventoryFinishedListener() {
            public void onQueryInventoryFinished(IabResult iabResult, Inventory inventory) throws Exception {
                GooglePlayPurchasing.log("RestoreInventoryFinished: %s", Boolean.toString(iabResult.isSuccess()));
                GooglePlayPurchasing.log(iabResult.mMessage);
                if (iabResult.isFailure()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to Restore inventory. UnityIAP will automatically retry in ");
                    sb.append(GooglePlayPurchasing.this.offlineBackOffTime);
                    sb.append("ms");
                    GooglePlayPurchasing.log(sb.toString());
                    iGooglePlayStoreCallback.OnTransactionsRestored(false);
                    return;
                }
                GooglePlayPurchasing.this.inventory = inventory;
                GooglePlayPurchasing.this.NotifyUnityOfProducts(inventory);
                iGooglePlayStoreCallback.OnTransactionsRestored(true);
            }
        }, 0);
    }

    public void UpgradeDowngradeSubscription(String str, String str2) {
        if (this.subscriptionUpdateInProgress) {
            log("Subscription update is in progress");
        } else if (!this.helper.subscriptionUpgradeDowngradeSupported()) {
            log("UpgradeDowngradeSubscription is not supported, this service needs v5 and higher android in app billing api");
        } else if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            log("Cannot update subscription. Subscription product identifiers(SKUs) must not be empty");
        } else {
            boolean z = (this.context instanceof UnityPlayerActivity) && this.isUnityVrEnabled && isDaydreamApiAvailable;
            final Intent createPurchaseIntent = createPurchaseIntent(z);
            createPurchaseIntent.putExtra("oldSkuMetadata", str);
            createPurchaseIntent.putExtra("newSku", str2);
            createPurchaseIntent.putExtra("type", "subscription_update");
            this.subscriptionUpdateInProgress = true;
            this.purchaseInProgress = true;
            this.activityPending = true;
            if (z) {
                new Handler(this.context.getMainLooper()).post(new Runnable() {
                    public void run() {
                        createPurchaseIntent.putExtra("vr", true);
                        DaydreamApi create = DaydreamApi.create(GooglePlayPurchasing.this.context);
                        create.launchInVr(createPurchaseIntent);
                        create.close();
                    }
                });
            } else {
                this.launcher.startActivity(this.context, createPurchaseIntent);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void StartSubscriptionUpdate(android.app.Activity r12, java.lang.String r13, java.lang.String r14) {
        /*
            r11 = this;
            java.lang.String r0 = "productId"
            r1 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0013 }
            r2.<init>(r13)     // Catch:{ JSONException -> 0x0013 }
            boolean r3 = r2.has(r0)     // Catch:{ JSONException -> 0x0013 }
            if (r3 == 0) goto L_0x0017
            java.lang.String r0 = r2.getString(r0)     // Catch:{ JSONException -> 0x0013 }
            goto L_0x0018
        L_0x0013:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0017:
            r0 = r1
        L_0x0018:
            if (r0 != 0) goto L_0x0020
            java.lang.String r12 = "Error: the product that is going to be updated does not have a valid product id"
            log(r12)
            return
        L_0x0020:
            com.unity.purchasing.googleplay.Inventory r2 = r11.inventory
            boolean r2 = r2.hasDetails(r0)
            if (r2 != 0) goto L_0x002e
            java.lang.String r12 = "Error: the product that is going to be updated is not in the current inventory"
            log(r12)
            return
        L_0x002e:
            com.unity.purchasing.googleplay.Inventory r2 = r11.inventory
            boolean r2 = r2.hasPurchase(r0)
            if (r2 != 0) goto L_0x003c
            java.lang.String r12 = "Error: the product that is going to be updated has not been purchased yet."
            log(r12)
            return
        L_0x003c:
            com.unity.purchasing.googleplay.Inventory r2 = r11.inventory
            boolean r2 = r2.hasDetails(r14)
            if (r2 != 0) goto L_0x004a
            java.lang.String r12 = "Error: the product that is going to be updated to is not in the current inventory"
            log(r12)
            return
        L_0x004a:
            com.unity.purchasing.common.ProductDefinition r2 = new com.unity.purchasing.common.ProductDefinition
            com.unity.purchasing.common.ProductType r3 = com.unity.purchasing.common.ProductType.Subscription
            r2.<init>(r14, r14, r3)
            r11.productUnderPurchase = r2
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r7.add(r0)
            java.lang.String r10 = r11.addFreeTrialAndIntroPriceFlagToDeveloperPayload(r1, r14, r13)
            com.unity.purchasing.googleplay.IabHelper r4 = r11.helper
            r8 = 999(0x3e7, float:1.4E-42)
            com.unity.purchasing.googleplay.IabHelper$OnIabPurchaseFinishedListener r9 = r11.PurchaseListener
            r5 = r12
            r6 = r14
            r4.launchSubscriptionUpdateFlow(r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity.purchasing.googleplay.GooglePlayPurchasing.StartSubscriptionUpdate(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    public void StartPurchase(Activity activity, String str, String str2) {
        this.helper.enableUnityVr(this.isUnityVrEnabled);
        String addFreeTrialAndIntroPriceFlagToDeveloperPayload = addFreeTrialAndIntroPriceFlagToDeveloperPayload(str2, str, null);
        if (this.inventory.getSkuDetails(str).mItemType == "inapp") {
            this.helper.launchPurchaseFlow(activity, str, ACTIVITY_REQUEST_CODE, this.PurchaseListener, addFreeTrialAndIntroPriceFlagToDeveloperPayload);
            return;
        }
        this.helper.launchSubscriptionPurchaseFlow(activity, str, ACTIVITY_REQUEST_CODE, this.PurchaseListener, addFreeTrialAndIntroPriceFlagToDeveloperPayload);
    }

    private String addFreeTrialAndIntroPriceFlagToDeveloperPayload(String str, String str2, String str3) {
        boolean z;
        boolean z2;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        String str7 = null;
        SkuDetails skuDetails = this.inventory.hasDetails(str5) ? this.inventory.getSkuDetails(str5) : null;
        JSONObject jSONObject = new JSONObject();
        String str8 = new String();
        String str9 = "accountId";
        if (str4 == null) {
            str4 = "";
        } else {
            try {
                str8 = new JSONObject(str4).getString(str9);
            } catch (JSONException unused) {
            }
        }
        String encodeToString = Base64.encodeToString(str4.getBytes(), 0);
        String str10 = "update_subscription_metadata";
        String str11 = "is_updated";
        String str12 = "has_introductory_price_trial";
        String str13 = "is_free_trial";
        String str14 = "developerPayload";
        if (skuDetails == null) {
            try {
                jSONObject.put(str14, encodeToString);
                jSONObject.put(str13, false);
                jSONObject.put(str12, false);
                jSONObject.put(str11, false);
                jSONObject.put(str10, null);
                jSONObject.put(str9, str8);
            } catch (JSONException unused2) {
            }
            return jSONObject.toString();
        }
        if (str6 != null) {
            log("oldSkuMetadata is NOT null");
            str7 = getUpdateMetadata(str6, skuDetails);
            z = true;
        } else {
            log("oldSkuMetadata is null");
            z = false;
        }
        String type = skuDetails.getType();
        String introductoryPricePeriod = skuDetails.getIntroductoryPricePeriod();
        String freeTrialPeriod = skuDetails.getFreeTrialPeriod();
        boolean hasPurchaseHistory = this.inventory.hasPurchaseHistory(str5);
        String str15 = str8;
        Iterator it = this.inventory.getAllSkus("subs").iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            String str16 = (String) it.next();
            Iterator it2 = it;
            if (!this.inventory.getSkuDetails(str16).getFreeTrialPeriod().isEmpty() && this.inventory.hasPurchaseHistory(str16)) {
                z2 = true;
                break;
            }
            it = it2;
        }
        String str17 = "inapp";
        boolean z3 = !type.equals(str17) && !freeTrialPeriod.isEmpty() && !hasPurchaseHistory && !z2;
        boolean z4 = !type.equals(str17) && !introductoryPricePeriod.isEmpty() && !hasPurchaseHistory;
        try {
            jSONObject.put(str14, encodeToString);
            jSONObject.put(str13, z3);
            jSONObject.put(str12, z4);
            jSONObject.put(str11, z);
            jSONObject.put(str10, str7);
            jSONObject.put(str9, str15);
        } catch (JSONException unused3) {
        }
        return jSONObject.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getUpdateMetadata(java.lang.String r11, com.unity.purchasing.googleplay.SkuDetails r12) {
        /*
            r10 = this;
            long r0 = r12.getPriceInMicros()
            r2 = 0
            r3 = 0
            r4 = 0
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x002b }
            r6.<init>(r11)     // Catch:{ JSONException -> 0x002b }
            java.lang.String r11 = "productId"
            java.lang.String r11 = r6.getString(r11)     // Catch:{ JSONException -> 0x002b }
            java.lang.String r7 = "is_free_trial"
            boolean r7 = r6.getBoolean(r7)     // Catch:{ JSONException -> 0x0029 }
            java.lang.String r8 = "is_introductory_price_period"
            boolean r2 = r6.getBoolean(r8)     // Catch:{ JSONException -> 0x0027 }
            java.lang.String r8 = "remaining_time_in_seconds"
            double r8 = r6.getDouble(r8)     // Catch:{ JSONException -> 0x0027 }
            long r8 = (long) r8
            goto L_0x0032
        L_0x0027:
            r6 = move-exception
            goto L_0x002e
        L_0x0029:
            r6 = move-exception
            goto L_0x002d
        L_0x002b:
            r6 = move-exception
            r11 = r3
        L_0x002d:
            r7 = 0
        L_0x002e:
            r6.printStackTrace()
            r8 = r4
        L_0x0032:
            if (r11 == 0) goto L_0x0084
            com.unity.purchasing.googleplay.Inventory r6 = r10.inventory
            boolean r6 = r6.hasDetails(r11)
            if (r6 != 0) goto L_0x003d
            goto L_0x0084
        L_0x003d:
            com.unity.purchasing.googleplay.Inventory r3 = r10.inventory
            com.unity.purchasing.googleplay.SkuDetails r11 = r3.getSkuDetails(r11)
            if (r7 == 0) goto L_0x0046
            r8 = r4
        L_0x0046:
            if (r2 == 0) goto L_0x0059
            long r2 = r12.getPriceInMicros()
            int r12 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0059
            long r2 = r11.getIntroductoryPriceInMicros()
            java.lang.String r11 = r11.getIntroductoryPricePeriod()
            goto L_0x0061
        L_0x0059:
            long r2 = r11.getPriceInMicros()
            java.lang.String r11 = r11.getSubscriptionPeriod()
        L_0x0061:
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            java.lang.String r4 = "old_sku_remaining_seconds"
            r12.put(r4, r8)     // Catch:{ JSONException -> 0x007b }
            java.lang.String r4 = "old_sku_price_in_micros"
            r12.put(r4, r2)     // Catch:{ JSONException -> 0x007b }
            java.lang.String r2 = "old_sku_period_string"
            r12.put(r2, r11)     // Catch:{ JSONException -> 0x007b }
            java.lang.String r11 = "new_sku_price_in_micros"
            r12.put(r11, r0)     // Catch:{ JSONException -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r11 = move-exception
            r11.printStackTrace()
        L_0x007f:
            java.lang.String r11 = r12.toString()
            return r11
        L_0x0084:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity.purchasing.googleplay.GooglePlayPurchasing.getUpdateMetadata(java.lang.String, com.unity.purchasing.googleplay.SkuDetails):java.lang.String");
    }

    /* access modifiers changed from: private */
    public void pollForNewPurchases() {
        reconcileFailedPurchaseWithInventory(null);
    }

    /* access modifiers changed from: private */
    public void reconcileFailedPurchaseWithInventory(final PurchaseFailureDescription purchaseFailureDescription) {
        this.manager.workWith(new BillingServiceProcessor() {
            public void workWith(IInAppBillingService iInAppBillingService) {
                boolean z = false;
                try {
                    boolean hasPurchase = purchaseFailureDescription != null ? GooglePlayPurchasing.this.inventory.hasPurchase(purchaseFailureDescription.productId) : false;
                    if (GooglePlayPurchasing.this.helper.queryPurchases(GooglePlayPurchasing.this.inventory, "inapp", iInAppBillingService) != 0) {
                        GooglePlayPurchasing.log("Received bad response from queryPurchases");
                    }
                    boolean hasPurchase2 = purchaseFailureDescription != null ? GooglePlayPurchasing.this.inventory.hasPurchase(purchaseFailureDescription.productId) : false;
                    if (purchaseFailureDescription != null) {
                        if ((!hasPurchase && !hasPurchase2) || (hasPurchase && hasPurchase2)) {
                            GooglePlayPurchasing.this.unityPurchasing.OnPurchaseFailed(purchaseFailureDescription);
                        } else if (!hasPurchase && hasPurchase2) {
                            Purchase purchase = GooglePlayPurchasing.this.inventory.getPurchase(purchaseFailureDescription.productId);
                            GooglePlayPurchasing.this.unityPurchasing.OnPurchaseSucceeded(purchase.getSku(), GooglePlayPurchasing.this.encodeReceipt(purchase, GooglePlayPurchasing.this.inventory.getSkuDetails(purchaseFailureDescription.productId)), purchase.getOrderIdOrPurchaseToken());
                        }
                        z = true;
                    }
                    if (!z) {
                        GooglePlayPurchasing.this.NotifyUnityOfProducts(GooglePlayPurchasing.this.inventory);
                    }
                } catch (RemoteException | JSONException e) {
                    Log.e(GooglePlayPurchasing.TAG, "exception", e);
                    if (purchaseFailureDescription != null && 0 == 0) {
                        GooglePlayPurchasing.this.unityPurchasing.OnPurchaseFailed(purchaseFailureDescription);
                    }
                }
            }
        });
    }

    private void registerPurchasesUpdatedReceiver() {
        if (this.purchasesUpdatedReceiver == null) {
            this.purchasesUpdatedReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    GooglePlayPurchasing.this.pollForNewPurchases();
                }
            };
            this.context.registerReceiver(this.purchasesUpdatedReceiver, new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED"));
        }
    }

    /* access modifiers changed from: private */
    public void QueryInventory(final List<String> list, long j) {
        log("QueryInventory: %s", Integer.toString(list.size()));
        this.helper.queryInventoryAsync(true, list, new QueryInventoryFinishedListener() {
            public void onQueryInventoryFinished(IabResult iabResult, Inventory inventory) throws Exception {
                GooglePlayPurchasing.log("onQueryInventoryFinished: %s", Boolean.toString(iabResult.isSuccess()));
                GooglePlayPurchasing.log(iabResult.mMessage);
                if (iabResult.isFailure()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to Query inventory. UnityIAP will automatically retry in ");
                    sb.append(GooglePlayPurchasing.this.offlineBackOffTime);
                    sb.append("ms");
                    GooglePlayPurchasing.log(sb.toString());
                    GooglePlayPurchasing googlePlayPurchasing = GooglePlayPurchasing.this;
                    googlePlayPurchasing.QueryInventory(list, (long) googlePlayPurchasing.offlineBackOffTime);
                    GooglePlayPurchasing googlePlayPurchasing2 = GooglePlayPurchasing.this;
                    googlePlayPurchasing2.offlineBackOffTime = Math.min(300000, googlePlayPurchasing2.offlineBackOffTime * 2);
                    return;
                }
                GooglePlayPurchasing.this.inventory = inventory;
                for (String str : list) {
                    if (GooglePlayPurchasing.this.inventory.hasConsumablePurchaseHistory(str) && !GooglePlayPurchasing.this.inventory.hasPurchase(str)) {
                        GooglePlayPurchasing.this.helper.consumeAsync(GooglePlayPurchasing.this.inventory.getHistoryPurchase(str), (OnConsumeFinishedListener) null, true);
                    }
                }
                GooglePlayPurchasing.this.NotifyUnityOfProducts(inventory);
            }
        }, j);
    }

    /* access modifiers changed from: private */
    public void NotifyUnityOfProducts(Inventory inventory2) {
        String str;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : inventory2.mSkuMap.entrySet()) {
            SkuDetails skuDetails = (SkuDetails) entry.getValue();
            try {
                jSONObject.put((String) entry.getKey(), skuDetails.getOriginalJSON());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ProductMetadata productMetadata = new ProductMetadata(skuDetails.getPrice(), skuDetails.getTitle(), skuDetails.getDescription(), skuDetails.getISOCurrencyCode(), new BigDecimal(skuDetails.getPriceInMicros()).divide(new BigDecimal(1000000)));
            String str2 = (String) entry.getKey();
            String str3 = null;
            if (inventory2.hasPurchase(str2)) {
                Purchase purchase = inventory2.getPurchase(str2);
                str3 = encodeReceipt(purchase, inventory2.getSkuDetails(str2));
                str = purchase.getOrderIdOrPurchaseToken();
            } else {
                str = null;
            }
            arrayList.add(new ProductDescription(str2, productMetadata, str3, str));
        }
        this.productJSON = jSONObject.toString();
        this.unityPurchasing.OnProductsRetrieved(arrayList);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.helper != null) {
            log("onActivityResult");
            this.helper.handleActivityResult(i, i2, intent);
            this.purchaseInProgress = false;
            this.subscriptionUpdateInProgress = false;
        }
    }

    private Purchase findPurchaseByOrderId(String str) {
        for (Purchase purchase : this.inventory.getAllPurchases()) {
            if (purchase.getOrderIdOrPurchaseToken().equals(str)) {
                return purchase;
            }
        }
        log("No consumable with order %s", str);
        return null;
    }

    /* access modifiers changed from: private */
    public void NotifyUnityOfPurchase(Purchase purchase) {
        log("NotifyUnityOfPurchase");
        this.inventory.addPurchase(purchase);
        SkuDetails skuDetails = this.inventory.getSkuDetails(purchase.getSku());
        if (purchase.getItemType().equals("subs")) {
            this.inventory.addPurchaseToSubscriptionPurchaseHistory(purchase.getSku());
        }
        this.unityPurchasing.OnPurchaseSucceeded(purchase.getSku(), encodeReceipt(purchase, skuDetails), purchase.getOrderIdOrPurchaseToken());
    }

    /* access modifiers changed from: private */
    public String encodeReceipt(Purchase purchase, SkuDetails skuDetails) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("json", purchase.getOriginalJson());
            jSONObject.put(InAppPurchaseMetaData.KEY_SIGNATURE, purchase.getSignature());
            jSONObject.put("skuDetails", skuDetails.getOriginalJSON());
            jSONObject.put("isPurchaseHistorySupported", this.helper.subscriptionPurchaseHistorySupported());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* access modifiers changed from: private */
    public static void log(String str) {
        Log.i(TAG, str);
    }

    /* access modifiers changed from: private */
    public static void log(String str, String str2) {
        log(String.format(str, new Object[]{str2}));
    }

    public void RetrieveProducts(List<ProductDefinition> list) {
        final ArrayList arrayList = new ArrayList();
        for (ProductDefinition productDefinition : list) {
            arrayList.add(productDefinition.storeSpecificId);
        }
        C32747 r4 = new OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult iabResult) {
                GooglePlayPurchasing.log("onIabSetupFinished: %s", Integer.toString(iabResult.mResponse));
                if (iabResult.isFailure()) {
                    GooglePlayPurchasing.log("Failed to setup IAB. Notifying Unity...");
                    GooglePlayPurchasing.this.unityPurchasing.OnSetupFailed(InitializationFailureReason.PurchasingUnavailable);
                    return;
                }
                GooglePlayPurchasing.log("Requesting %s products", Integer.toString(arrayList.size()));
                GooglePlayPurchasing.this.QueryInventory(arrayList, 0);
            }
        };
        if (!this.helper.mSetupDone) {
            try {
                this.manager.initialise();
                this.helper.startSetup(r4);
            } catch (GooglePlayBillingUnAvailableException unused) {
                this.unityPurchasing.OnSetupFailed(InitializationFailureReason.PurchasingUnavailable);
            }
        } else {
            log("Requesting %s products", Integer.toString(arrayList.size()));
            QueryInventory(arrayList, 0);
        }
    }

    private void consumeSuspectFailedPurchase(final ProductDefinition productDefinition, final String str) {
        final String str2 = productDefinition.storeSpecificId;
        this.suspectFailedConsumableSkus.remove(str2);
        this.helper.queryInventoryAsync(false, this.inventory.getAllSkus("inapp"), new QueryInventoryFinishedListener() {
            public void onQueryInventoryFinished(IabResult iabResult, Inventory inventory) throws Exception {
                if (iabResult.isFailure()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to Query inventory. UnityIAP will automatically retry in ");
                    sb.append(GooglePlayPurchasing.this.offlineBackOffTime);
                    sb.append("ms");
                    GooglePlayPurchasing.log(sb.toString());
                    GooglePlayPurchasing googlePlayPurchasing = GooglePlayPurchasing.this;
                    googlePlayPurchasing.QueryInventory(googlePlayPurchasing.inventory.getAllSkus("inapp"), (long) GooglePlayPurchasing.this.offlineBackOffTime);
                    GooglePlayPurchasing googlePlayPurchasing2 = GooglePlayPurchasing.this;
                    googlePlayPurchasing2.offlineBackOffTime = Math.min(300000, googlePlayPurchasing2.offlineBackOffTime * 2);
                    return;
                }
                GooglePlayPurchasing.this.inventory = inventory;
                if (GooglePlayPurchasing.this.inventory.hasConsumablePurchaseHistory(str2)) {
                    GooglePlayPurchasing.this.helper.consumeAsync(GooglePlayPurchasing.this.inventory.getHistoryPurchase(str2), (OnConsumeFinishedListener) new OnConsumeFinishedListener() {
                        public void onConsumeFinished(Purchase purchase, IabResult iabResult) throws JSONException {
                            GooglePlayPurchasing.this.Purchase(productDefinition, str);
                        }
                    }, true);
                } else {
                    GooglePlayPurchasing.this.Purchase(productDefinition, str);
                }
            }
        }, 0);
    }

    public void Purchase(ProductDefinition productDefinition) {
        Purchase(productDefinition, null);
    }

    public void Purchase(ProductDefinition productDefinition, String str) {
        if (this.purchaseInProgress) {
            this.unityPurchasing.OnPurchaseFailed(new PurchaseFailureDescription(productDefinition.storeSpecificId, PurchaseFailureReason.ExistingPurchasePending));
        } else if (productDefinition.type != ProductType.Consumable || !this.suspectFailedConsumableSkus.contains(productDefinition.storeSpecificId) || this.inventory.hasPurchase(productDefinition.storeSpecificId)) {
            String str2 = productDefinition.storeSpecificId;
            this.productUnderPurchase = productDefinition;
            log("onPurchaseProduct: %s", str2);
            SkuDetails skuDetails = this.inventory.getSkuDetails(str2);
            log("ITEM TYPE:%s", skuDetails.getType());
            boolean z = (this.context instanceof UnityPlayerActivity) && this.isUnityVrEnabled && isDaydreamApiAvailable;
            final Intent createPurchaseIntent = createPurchaseIntent(z);
            createPurchaseIntent.putExtra("productId", str2);
            createPurchaseIntent.putExtra("itemType", skuDetails.getType());
            createPurchaseIntent.putExtra("developerPayload", str);
            this.purchaseInProgress = true;
            this.activityPending = true;
            if (z) {
                new Handler(this.context.getMainLooper()).post(new Runnable() {
                    public void run() {
                        createPurchaseIntent.putExtra("vr", true);
                        DaydreamApi create = DaydreamApi.create(GooglePlayPurchasing.this.context);
                        create.launchInVr(createPurchaseIntent);
                        create.close();
                    }
                });
            } else {
                this.launcher.startActivity(this.context, createPurchaseIntent);
            }
        } else {
            consumeSuspectFailedPurchase(productDefinition, str);
        }
    }

    /* access modifiers changed from: protected */
    public Intent createPurchaseIntent(boolean z) {
        return new Intent(this.context, z ? VRPurchaseActivity.class : PurchaseActivity.class);
    }

    public void FinishTransaction(ProductDefinition productDefinition, String str) {
        log("Finish transaction:%s", str);
        if (productDefinition == null) {
            log("Received FinishTransaction for unknown product with transaction %s. Not consuming.", str);
            return;
        }
        if (productDefinition.type == ProductType.Consumable) {
            Purchase findPurchaseByOrderId = findPurchaseByOrderId(str);
            if (findPurchaseByOrderId != null) {
                log("Consuming %s", findPurchaseByOrderId.getSku());
                this.inventory.erasePurchase(findPurchaseByOrderId.getSku());
                this.helper.consumeAsync(findPurchaseByOrderId, (OnConsumeFinishedListener) new OnConsumeFinishedListener() {
                    public void onConsumeFinished(Purchase purchase, IabResult iabResult) throws JSONException {
                        GooglePlayPurchasing.log("onConsumeFinished:%s", Boolean.toString(iabResult.isSuccess()));
                        GooglePlayPurchasing.log(iabResult.mMessage);
                        GooglePlayPurchasing.log(String.valueOf(iabResult.getResponse()));
                    }
                }, false);
            }
        }
    }

    public void FinishAdditionalTransaction(String str, String str2) {
        log("Finish transaction:%s", str2);
        Purchase findPurchaseByOrderId = findPurchaseByOrderId(str2);
        if (findPurchaseByOrderId != null) {
            log("Consuming %s", findPurchaseByOrderId.getSku());
            this.inventory.erasePurchase(findPurchaseByOrderId.getSku());
            this.helper.consumeAsync(findPurchaseByOrderId, (OnConsumeFinishedListener) new OnConsumeFinishedListener() {
                public void onConsumeFinished(Purchase purchase, IabResult iabResult) throws JSONException {
                    GooglePlayPurchasing.log("onConsumeFinished:%s", Boolean.toString(iabResult.isSuccess()));
                    GooglePlayPurchasing.log(iabResult.mMessage);
                    GooglePlayPurchasing.log(String.valueOf(iabResult.getResponse()));
                }
            }, false);
        }
    }

    public void SetFeatures(String str) {
        for (String equals : str.split(",")) {
            if (equals.equals("supportsPurchaseFailureReasonDuplicateTransaction")) {
                this.features.supportsPurchaseFailureReasonDuplicateTransaction = true;
            }
        }
    }
}
