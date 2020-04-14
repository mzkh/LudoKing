package com.unity.purchasing.common;

public class ProductDescription {
    public final ProductMetadata metadata;
    public final String receipt;
    public final String storeSpecificId;
    public final String transactionId;

    public ProductDescription(String str, ProductMetadata productMetadata, String str2, String str3) {
        this.storeSpecificId = str;
        this.metadata = productMetadata;
        this.receipt = str2;
        this.transactionId = str3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ProductDescription: storeSpecificId = ");
        sb.append(this.storeSpecificId);
        sb.append(", metadata = ");
        sb.append(this.metadata);
        sb.append(", receipt = ");
        sb.append(this.receipt);
        sb.append(", transactionId = ");
        sb.append(this.transactionId);
        sb.append(", }");
        return sb.toString();
    }
}
