package com.unity3d.services.store;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.store.core.StoreException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
public class StoreMonitor {
    /* access modifiers changed from: private */
    public static Object _billingService;
    private static StoreLifecycleListener _lifecycleListener;

    public static void initialize(String str, String str2) {
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        ClientProperties.getApplicationContext().bindService(intent, new ServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                StoreMonitor._billingService = StoreBilling.asInterface(ClientProperties.getApplicationContext(), iBinder);
                if (StoreMonitor._billingService != null) {
                    WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.INITIALIZED, new Object[0]);
                } else {
                    WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.INITIALIZATION_FAILED, new Object[0]);
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                StoreMonitor._billingService = null;
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.DISCONNECTED, new Object[0]);
            }
        }, 1);
    }

    public static boolean isInitialized() {
        return _billingService != null;
    }

    public static int isBillingSupported(String str) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, StoreException, InvocationTargetException {
        return StoreBilling.isBillingSupported(ClientProperties.getApplicationContext(), _billingService, str);
    }

    public static JSONObject getPurchases(String str) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, JSONException, IllegalAccessException, StoreException {
        return StoreBilling.getPurchases(ClientProperties.getApplicationContext(), _billingService, str);
    }

    public static JSONObject getPurchaseHistory(String str, int i) throws NoSuchMethodException, StoreException, IllegalAccessException, JSONException, InvocationTargetException, ClassNotFoundException {
        return StoreBilling.getPurchaseHistory(ClientProperties.getApplicationContext(), _billingService, str, i);
    }

    public static JSONArray getSkuDetails(String str, ArrayList<String> arrayList) throws NoSuchMethodException, StoreException, IllegalAccessException, JSONException, InvocationTargetException, ClassNotFoundException {
        return StoreBilling.getSkuDetails(ClientProperties.getApplicationContext(), _billingService, str, arrayList);
    }

    public static void startPurchaseTracking(boolean z, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (_lifecycleListener != null) {
            stopPurchaseTracking();
        }
        _lifecycleListener = new StoreLifecycleListener(z, arrayList, arrayList2);
        ClientProperties.getApplication().registerActivityLifecycleCallbacks(_lifecycleListener);
    }

    public static void stopPurchaseTracking() {
        if (_lifecycleListener != null) {
            ClientProperties.getApplication().unregisterActivityLifecycleCallbacks(_lifecycleListener);
            _lifecycleListener = null;
        }
    }

    public static void sendPurchaseStatusOnResume(String str, ArrayList<String> arrayList) {
        String str2 = "subs";
        String str3 = "inapp";
        if (!isInitialized()) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME_ERROR, StoreError.NOT_INITIALIZED, str, "StoreMonitor not initialized");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (arrayList.contains(str3)) {
                jSONObject.put(str3, getPurchases(str3));
            }
            if (arrayList.contains(str2)) {
                jSONObject.put(str2, getPurchases(str2));
            }
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME, str, jSONObject);
        } catch (ClassNotFoundException e) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME_ERROR, StoreError.CLASS_NOT_FOUND, str, e.getMessage());
        } catch (NoSuchMethodException e2) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME_ERROR, StoreError.NO_SUCH_METHOD, str, e2.getMessage());
        } catch (InvocationTargetException e3) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME_ERROR, StoreError.INVOCATION_TARGET, str, e3.getMessage());
        } catch (JSONException e4) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME_ERROR, StoreError.JSON_ERROR, str, e4.getMessage());
        } catch (IllegalAccessException e5) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME_ERROR, StoreError.ILLEGAL_ACCESS, str, e5.getMessage());
        } catch (StoreException e6) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME_ERROR, StoreError.STORE_ERROR, str, e6.getMessage(), Integer.valueOf(e6.getResultCode()));
        }
    }

    public static void sendPurchaseStatusOnStop(String str, ArrayList<String> arrayList) {
        String str2 = "subs";
        String str3 = "inapp";
        if (!isInitialized()) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP_ERROR, StoreError.NOT_INITIALIZED, str, "StoreMonitor not initialized");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (arrayList.contains(str3)) {
                jSONObject.put(str3, getPurchases(str3));
            }
            if (arrayList.contains(str2)) {
                jSONObject.put(str2, getPurchases(str2));
            }
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP, str, jSONObject);
        } catch (ClassNotFoundException e) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP_ERROR, StoreError.CLASS_NOT_FOUND, str, e.getMessage());
        } catch (NoSuchMethodException e2) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP_ERROR, StoreError.NO_SUCH_METHOD, str, e2.getMessage());
        } catch (InvocationTargetException e3) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP_ERROR, StoreError.INVOCATION_TARGET, str, e3.getMessage());
        } catch (JSONException e4) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP_ERROR, StoreError.JSON_ERROR, str, e4.getMessage());
        } catch (IllegalAccessException e5) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP_ERROR, StoreError.ILLEGAL_ACCESS, str, e5.getMessage());
        } catch (StoreException e6) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP_ERROR, StoreError.STORE_ERROR, str, e6.getMessage(), Integer.valueOf(e6.getResultCode()));
        }
    }
}
