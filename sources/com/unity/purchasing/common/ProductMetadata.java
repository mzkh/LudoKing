package com.unity.purchasing.common;

import java.math.BigDecimal;

public class ProductMetadata {
    public final String isoCurrencyCode;
    public final String localizedDescription;
    public final BigDecimal localizedPrice;
    public final String localizedPriceString;
    public final String localizedTitle;

    public ProductMetadata(String str, String str2, String str3, String str4, BigDecimal bigDecimal) {
        if (str == null) {
            str = "";
        }
        this.localizedPriceString = str;
        this.localizedTitle = str2;
        this.localizedDescription = str3;
        this.isoCurrencyCode = str4;
        this.localizedPrice = bigDecimal;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ProductMetadata: localizedPriceString = ");
        sb.append(this.localizedPriceString);
        sb.append(", localizedTitle = ");
        sb.append(this.localizedTitle);
        sb.append(", localizedDescription = ");
        sb.append(this.localizedDescription);
        sb.append(", isoCurrencyCode = ");
        sb.append(this.isoCurrencyCode);
        sb.append(", localizedPrice = ");
        sb.append(this.localizedPrice);
        sb.append(", }");
        return sb.toString();
    }
}
