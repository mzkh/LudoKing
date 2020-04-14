package com.unity.purchasing.common;

public class PurchaseFailureDescription {
    public String message;
    public String productId;
    public PurchaseFailureReason reason;
    public String storeSpecificErrorCode;

    public PurchaseFailureDescription(String str, PurchaseFailureReason purchaseFailureReason, String str2, String str3) {
        this.productId = str;
        this.reason = purchaseFailureReason;
        this.message = str2;
        this.storeSpecificErrorCode = str3;
    }

    public PurchaseFailureDescription(String str, PurchaseFailureReason purchaseFailureReason) {
        String str2 = "";
        this(str, purchaseFailureReason, str2, str2);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PurchaseFailureDescription)) {
            return false;
        }
        return equalsAllFields((PurchaseFailureDescription) obj);
    }

    public boolean equalsAllFields(PurchaseFailureDescription purchaseFailureDescription) {
        return this.productId.equals(purchaseFailureDescription.productId) && this.reason == purchaseFailureDescription.reason && this.message.equals(purchaseFailureDescription.message) && this.storeSpecificErrorCode.equals(purchaseFailureDescription.storeSpecificErrorCode);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("productId: \"");
        sb.append(this.productId);
        sb.append("\" reason: ");
        sb.append(this.reason);
        sb.append(" message: \"");
        sb.append(this.message);
        sb.append("\" storeSpecificErrorCode: ");
        sb.append(this.storeSpecificErrorCode);
        return sb.toString();
    }
}
