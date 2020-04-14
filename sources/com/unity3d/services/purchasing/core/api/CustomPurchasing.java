package com.unity3d.services.purchasing.core.api;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;
import com.unity3d.services.monetization.core.utilities.JSONUtilities;
import com.unity3d.services.purchasing.core.IPurchasingAdapter;
import com.unity3d.services.purchasing.core.IRetrieveProductsListener;
import com.unity3d.services.purchasing.core.ITransactionListener;
import com.unity3d.services.purchasing.core.Product;
import com.unity3d.services.purchasing.core.PurchasingError;
import com.unity3d.services.purchasing.core.PurchasingEvent;
import com.unity3d.services.purchasing.core.TransactionDetails;
import com.unity3d.services.purchasing.core.TransactionDetailsUtilities;
import com.unity3d.services.purchasing.core.TransactionErrorDetails;
import com.unity3d.services.purchasing.core.TransactionErrorDetailsUtilities;
import com.unity3d.services.purchasing.core.properties.ClientProperties;
import com.unity3d.services.purchasing.core.webview.WebViewEventCategory;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomPurchasing {
    /* access modifiers changed from: private */
    public static IRetrieveProductsListener retrieveProductsListener = new IRetrieveProductsListener() {
        public void onProductsRetrieved(List<Product> list) {
            WebViewApp currentApp = WebViewApp.getCurrentApp();
            if (currentApp != null) {
                currentApp.sendEvent(WebViewEventCategory.CUSTOM_PURCHASING, PurchasingEvent.PRODUCTS_RETRIEVED, CustomPurchasing.getJSONArrayFromProductList(list));
            }
        }
    };
    /* access modifiers changed from: private */
    public static ITransactionListener transactionListener = new ITransactionListener() {
        public void onTransactionComplete(TransactionDetails transactionDetails) {
            WebViewApp currentApp = WebViewApp.getCurrentApp();
            if (currentApp != null) {
                currentApp.sendEvent(WebViewEventCategory.CUSTOM_PURCHASING, PurchasingEvent.TRANSACTION_COMPLETE, TransactionDetailsUtilities.getJSONObjectForTransactionDetails(transactionDetails));
            }
        }

        public void onTransactionError(TransactionErrorDetails transactionErrorDetails) {
            WebViewApp currentApp = WebViewApp.getCurrentApp();
            if (currentApp != null) {
                currentApp.sendEvent(WebViewEventCategory.CUSTOM_PURCHASING, PurchasingEvent.TRANSACTION_ERROR, TransactionErrorDetailsUtilities.getJSONObjectForTransactionErrorDetails(transactionErrorDetails));
            }
        }
    };

    static JSONArray getJSONArrayFromProductList(List<Product> list) {
        JSONArray jSONArray = new JSONArray();
        for (Product jSONObjectForProduct : list) {
            try {
                jSONArray.put(getJSONObjectForProduct(jSONObjectForProduct));
            } catch (JSONException e) {
                DeviceLog.error("Could not generate JSON for product: %s", e.getMessage());
            }
        }
        return jSONArray;
    }

    private static JSONObject getJSONObjectForProduct(Product product) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("productId", product.getProductId());
        jSONObject.put("localizedPriceString", product.getLocalizedPriceString());
        jSONObject.put("localizedTitle", product.getLocalizedTitle());
        jSONObject.put("isoCurrencyCode", product.getIsoCurrencyCode());
        jSONObject.put("localizedPrice", product.getLocalizedPrice());
        jSONObject.put("localizedDescription", product.getLocalizedDescription());
        jSONObject.put("productType", product.getProductType());
        return jSONObject;
    }

    @WebViewExposed
    public static void available(WebViewCallback webViewCallback) {
        boolean z = true;
        Object[] objArr = new Object[1];
        if (ClientProperties.getAdapter() == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        webViewCallback.invoke(objArr);
    }

    @WebViewExposed
    public static void refreshCatalog(WebViewCallback webViewCallback) {
        final IPurchasingAdapter adapter = ClientProperties.getAdapter();
        if (adapter != null) {
            try {
                Utilities.runOnUiThread(new Runnable() {
                    public void run() {
                        adapter.retrieveProducts(CustomPurchasing.retrieveProductsListener);
                    }
                });
                webViewCallback.invoke(new Object[0]);
            } catch (Exception e) {
                webViewCallback.error(PurchasingError.RETRIEVE_PRODUCTS_ERROR, e);
            }
        } else {
            webViewCallback.error(PurchasingError.PURCHASING_ADAPTER_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void purchaseItem(final String str, final JSONObject jSONObject, WebViewCallback webViewCallback) {
        final IPurchasingAdapter adapter = ClientProperties.getAdapter();
        if (adapter != null) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    adapter.onPurchase(str, CustomPurchasing.transactionListener, JSONUtilities.jsonObjectToMap(jSONObject));
                }
            });
            webViewCallback.invoke(new Object[0]);
            return;
        }
        webViewCallback.error(PurchasingError.PURCHASING_ADAPTER_NULL, new Object[0]);
    }
}
