package com.unity.purchasing.googleplay;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.Stub;
import com.facebook.appevents.AppEventsConstants;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BillingServiceManager implements IBillingServiceManager {
    /* access modifiers changed from: private */
    public final ConcurrentLinkedQueue<BillingServiceProcessor> callbacks = new ConcurrentLinkedQueue<>();
    private Context context;
    /* access modifiers changed from: private */
    public ExecutorService executor = Executors.newSingleThreadExecutor();
    private Intent googlePlayBillingServiceIntent;
    /* access modifiers changed from: private */
    public boolean mIsBound = false;
    /* access modifiers changed from: private */
    public volatile IInAppBillingService mService;
    /* access modifiers changed from: private */
    public volatile ServiceConnection mServiceConn;

    public boolean billingAvailable() {
        return false;
    }

    public BillingServiceManager(final Context context2) {
        this.context = context2;
        if (context2 == null) {
            logDebug("Unable to create BillingService Instance, invalid context");
        }
        this.mServiceConn = new ServiceConnection() {
            public void onServiceDisconnected(ComponentName componentName) {
                BillingServiceManager.this.logDebug("Billing service disconnected.");
                BillingServiceManager.this.executor.execute(new Runnable() {
                    public void run() {
                        if (context2 != null && BillingServiceManager.this.mIsBound) {
                            context2.unbindService(BillingServiceManager.this.mServiceConn);
                            BillingServiceManager.this.mIsBound = false;
                        }
                        BillingServiceManager.this.mService = null;
                        if (BillingServiceManager.this.callbacks.size() == 0) {
                            BillingServiceManager.this.logDebug("Releasing billing service.");
                            return;
                        }
                        BillingServiceManager.this.logDebug("Rebinding billing service.");
                        BillingServiceManager.this.bindToGooglePlayService();
                    }
                });
            }

            public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
                BillingServiceManager.this.logDebug("Billing service connected.");
                BillingServiceManager.this.mIsBound = true;
                BillingServiceManager.this.executor.execute(new Runnable() {
                    public void run() {
                        BillingServiceManager.this.mService = Stub.asInterface(iBinder);
                        BillingServiceManager.this.tryPumpCallbacks();
                    }
                });
            }
        };
    }

    public void initialise() throws GooglePlayBillingUnAvailableException {
        if (this.googlePlayBillingServiceIntent == null) {
            this.googlePlayBillingServiceIntent = getGooglePlayServiceIntent();
        }
    }

    private Intent getGooglePlayServiceIntent() throws GooglePlayBillingUnAvailableException {
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List queryIntentServices = this.context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && queryIntentServices.size() == 1) {
            return intent;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to find a single Google Play billing service but found ");
        sb.append(queryIntentServices == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : Integer.valueOf(queryIntentServices.size()));
        String sb2 = sb.toString();
        logDebug(sb2);
        throw new GooglePlayBillingUnAvailableException(sb2);
    }

    /* access modifiers changed from: 0000 */
    public void bindToGooglePlayService() {
        this.context.bindService(this.googlePlayBillingServiceIntent, this.mServiceConn, 1);
    }

    public void workWith(BillingServiceProcessor billingServiceProcessor) {
        this.callbacks.add(billingServiceProcessor);
        tryPumpCallbacks();
    }

    public void dispose() {
        Context context2 = this.context;
        if (context2 != null && this.mIsBound) {
            context2.unbindService(this.mServiceConn);
            this.mIsBound = false;
        }
    }

    /* access modifiers changed from: private */
    public void tryPumpCallbacks() {
        this.executor.execute(new Runnable() {
            public void run() {
                if (BillingServiceManager.this.mService != null) {
                    while (BillingServiceManager.this.callbacks.size() > 0) {
                        BillingServiceManager.this.logDebug("invoking callback");
                        ((BillingServiceProcessor) BillingServiceManager.this.callbacks.remove()).workWith(BillingServiceManager.this.mService);
                    }
                    return;
                }
                BillingServiceManager.this.bindToGooglePlayService();
            }
        });
    }

    /* access modifiers changed from: private */
    public void logDebug(String str) {
        Log.i("UnityIAP", str);
    }
}
