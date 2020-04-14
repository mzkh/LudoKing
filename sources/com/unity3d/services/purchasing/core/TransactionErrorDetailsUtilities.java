package com.unity3d.services.purchasing.core;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.monetization.core.utilities.JSONUtilities;
import org.json.JSONObject;

public final class TransactionErrorDetailsUtilities {
    public static final String EXCEPTION_MESSAGE = "exceptionMessage";
    public static final String EXTRAS = "extras";
    public static final String STORE = "store";
    public static final String STORE_SPECIFIC_ERROR_CODE = "storeSpecificErrorCode";
    public static final String TRANSACTION_ERROR = "transactionError";

    public static JSONObject getJSONObjectForTransactionErrorDetails(TransactionErrorDetails transactionErrorDetails) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TRANSACTION_ERROR, transactionErrorDetails.getTransactionError().toString());
            jSONObject.put(EXCEPTION_MESSAGE, transactionErrorDetails.getExceptionMessage());
            jSONObject.put("store", transactionErrorDetails.getStore().toString());
            jSONObject.put(STORE_SPECIFIC_ERROR_CODE, transactionErrorDetails.getStoreSpecificErrorCode());
            jSONObject.put("extras", JSONUtilities.mapToJsonObject(transactionErrorDetails.getExtras()));
        } catch (Exception e) {
            DeviceLog.error("Could not generate JSON for Transaction Error Details: %s", e.getMessage());
        }
        return jSONObject;
    }
}
