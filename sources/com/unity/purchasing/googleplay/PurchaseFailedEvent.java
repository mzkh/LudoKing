package com.unity.purchasing.googleplay;

import com.unity.purchasing.common.PurchaseFailureReason;
import com.unity.purchasing.common.SaneJSONObject;

public class PurchaseFailedEvent {
    public static String jsonEncodePurchaseFailure(String str, PurchaseFailureReason purchaseFailureReason, String str2) {
        SaneJSONObject saneJSONObject = new SaneJSONObject();
        saneJSONObject.put("productId", (Object) str);
        saneJSONObject.put("reason", (Object) purchaseFailureReason);
        saneJSONObject.put("message", (Object) str2);
        return saneJSONObject.toString();
    }
}
