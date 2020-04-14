package com.unity.purchasing.common;

import org.json.JSONObject;

public class PurchaseFailedEvent {
    public static String jsonEncodePurchaseFailure(String str, PurchaseFailureReason purchaseFailureReason, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("productId", str);
            jSONObject.put("reason", purchaseFailureReason);
            jSONObject.put("message", str2);
            return jSONObject.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
