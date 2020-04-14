package com.unity3d.services.store;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.unity.purchasing.googleplay.IabHelper;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.store.core.StoreException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StoreBilling {
    public static Object asInterface(Context context, IBinder iBinder) {
        new Object[1][0] = iBinder;
        try {
            try {
                try {
                    return Class.forName("com.android.vending.billing.IInAppBillingService$Stub").getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{iBinder});
                } catch (IllegalAccessException e) {
                    DeviceLog.exception("Illegal access exception while invoking asInterface", e);
                    return null;
                } catch (InvocationTargetException e2) {
                    DeviceLog.exception("Invocation target exception while invoking asInterface", e2);
                    return null;
                }
            } catch (NoSuchMethodException e3) {
                DeviceLog.exception("asInterface method not found", e3);
                return null;
            }
        } catch (ClassNotFoundException e4) {
            DeviceLog.exception("Billing service stub not found", e4);
            return null;
        }
    }

    public static int isBillingSupported(Context context, Object obj, String str) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, StoreException {
        Object invoke = Class.forName("com.android.vending.billing.IInAppBillingService").getMethod("isBillingSupported", new Class[]{Integer.TYPE, String.class, String.class}).invoke(obj, new Object[]{Integer.valueOf(3), ClientProperties.getAppName(), str});
        if (invoke != null) {
            return ((Integer) invoke).intValue();
        }
        throw new StoreException();
    }

    public static JSONObject getPurchases(Context context, Object obj, String str) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, JSONException, StoreException {
        Method method = Class.forName("com.android.vending.billing.IInAppBillingService").getMethod("getPurchases", new Class[]{Integer.TYPE, String.class, String.class, String.class});
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        String str2 = null;
        do {
            Object invoke = method.invoke(obj, new Object[]{Integer.valueOf(3), ClientProperties.getAppName(), str, str2});
            if (invoke instanceof Bundle) {
                Bundle bundle = (Bundle) invoke;
                int i = bundle.getInt("RESPONSE_CODE");
                StringBuilder sb = new StringBuilder();
                sb.append("getPurchases responds with code ");
                sb.append(i);
                DeviceLog.debug(sb.toString());
                if (i == 0) {
                    Iterator it = bundle.getStringArrayList(IabHelper.RESPONSE_INAPP_PURCHASE_DATA_LIST).iterator();
                    while (it.hasNext()) {
                        jSONArray.put(new JSONObject((String) it.next()));
                    }
                    Iterator it2 = bundle.getStringArrayList(IabHelper.RESPONSE_INAPP_SIGNATURE_LIST).iterator();
                    while (it2.hasNext()) {
                        jSONArray2.put((String) it2.next());
                    }
                    Iterator it3 = bundle.getStringArrayList(IabHelper.RESPONSE_INAPP_ITEM_LIST).iterator();
                    while (it3.hasNext()) {
                        jSONArray3.put((String) it3.next());
                    }
                    str2 = bundle.getString(IabHelper.INAPP_CONTINUATION_TOKEN);
                } else {
                    throw new StoreException(i);
                }
            } else {
                throw new StoreException();
            }
        } while (str2 != null);
        jSONObject.put("purchaseDataList", jSONArray);
        jSONObject.put("signatureList", jSONArray2);
        jSONObject.put("purchaseItemList", jSONArray3);
        return jSONObject;
    }

    public static JSONObject getPurchaseHistory(Context context, Object obj, String str, int i) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, JSONException, StoreException {
        int i2 = i;
        int i3 = 5;
        char c = 0;
        Method method = Class.forName("com.android.vending.billing.IInAppBillingService").getMethod("getPurchaseHistory", new Class[]{Integer.TYPE, String.class, String.class, String.class, Bundle.class});
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        Object obj2 = null;
        int i4 = 0;
        while (true) {
            Object[] objArr = new Object[i3];
            objArr[c] = Integer.valueOf(6);
            objArr[1] = ClientProperties.getAppName();
            objArr[2] = str;
            objArr[3] = obj2;
            objArr[4] = new Bundle();
            Object invoke = method.invoke(obj, objArr);
            if (invoke instanceof Bundle) {
                Bundle bundle = (Bundle) invoke;
                int i5 = bundle.getInt("RESPONSE_CODE");
                if (i5 == 0) {
                    Iterator it = bundle.getStringArrayList(IabHelper.RESPONSE_INAPP_PURCHASE_DATA_LIST).iterator();
                    while (it.hasNext()) {
                        jSONArray.put(new JSONObject((String) it.next()));
                        i4++;
                    }
                    Iterator it2 = bundle.getStringArrayList(IabHelper.RESPONSE_INAPP_SIGNATURE_LIST).iterator();
                    while (it2.hasNext()) {
                        jSONArray2.put((String) it2.next());
                    }
                    Iterator it3 = bundle.getStringArrayList(IabHelper.RESPONSE_INAPP_ITEM_LIST).iterator();
                    while (it3.hasNext()) {
                        jSONArray3.put((String) it3.next());
                    }
                    String string = bundle.getString(IabHelper.INAPP_CONTINUATION_TOKEN);
                    if (string == null || (i2 != 0 && i4 >= i2)) {
                        jSONObject.put("purchaseDataList", jSONArray);
                        jSONObject.put("signatureList", jSONArray2);
                        jSONObject.put("purchaseItemList", jSONArray3);
                    } else {
                        obj2 = string;
                        i3 = 5;
                        c = 0;
                    }
                } else {
                    throw new StoreException(i5);
                }
            } else {
                throw new StoreException();
            }
        }
        jSONObject.put("purchaseDataList", jSONArray);
        jSONObject.put("signatureList", jSONArray2);
        jSONObject.put("purchaseItemList", jSONArray3);
        return jSONObject;
    }

    public static JSONArray getSkuDetails(Context context, Object obj, String str, ArrayList<String> arrayList) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, StoreException, JSONException {
        Method method = Class.forName("com.android.vending.billing.IInAppBillingService").getMethod("getSkuDetails", new Class[]{Integer.TYPE, String.class, String.class, Bundle.class});
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(IabHelper.GET_SKU_DETAILS_ITEM_LIST, arrayList);
        Object invoke = method.invoke(obj, new Object[]{Integer.valueOf(3), ClientProperties.getAppName(), str, bundle});
        JSONArray jSONArray = new JSONArray();
        if (invoke instanceof Bundle) {
            Bundle bundle2 = (Bundle) invoke;
            int i = bundle2.getInt("RESPONSE_CODE");
            if (i == 0) {
                Iterator it = bundle2.getStringArrayList(IabHelper.RESPONSE_GET_SKU_DETAILS_LIST).iterator();
                while (it.hasNext()) {
                    jSONArray.put(new JSONObject((String) it.next()));
                }
                return jSONArray;
            }
            throw new StoreException(i);
        }
        throw new StoreException();
    }
}
