package com.unity3d.services.purchasing.core;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.monetization.core.utilities.JSONUtilities;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class TransactionDetailsUtilities {
    public static final String CURRENCY = "currency";
    public static final String EXTRAS = "extras";
    public static final String PRICE = "price";
    public static final String PRODUCT_ID = "productId";
    public static final String RECEIPT = "receipt";
    public static final String TRANSACTION_ID = "transactionId";

    public static JSONObject getJSONObjectForTransactionDetails(TransactionDetails transactionDetails) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TRANSACTION_ID, transactionDetails.getTransactionId());
            jSONObject.put("productId", transactionDetails.getProductId());
            jSONObject.put("price", transactionDetails.getPrice());
            jSONObject.put("currency", transactionDetails.getCurrency());
            jSONObject.put(RECEIPT, transactionDetails.getReceipt());
            jSONObject.put("extras", JSONUtilities.mapToJsonObject(transactionDetails.getExtras()));
        } catch (Exception e) {
            DeviceLog.error("Could not generate JSON for transaction details: %s", e.getMessage());
        }
        return jSONObject;
    }

    public static Map<String, Object> getEventDataForTransactionDetails(TransactionDetails transactionDetails) {
        HashMap hashMap = new HashMap();
        hashMap.put(TRANSACTION_ID, transactionDetails.getTransactionId());
        hashMap.put("productId", transactionDetails.getProductId());
        hashMap.put("price", transactionDetails.getPrice());
        hashMap.put("currency", transactionDetails.getCurrency());
        hashMap.put(RECEIPT, transactionDetails.getReceipt());
        hashMap.put("extras", transactionDetails.getExtras());
        return hashMap;
    }
}
