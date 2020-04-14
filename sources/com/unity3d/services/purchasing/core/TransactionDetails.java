package com.unity3d.services.purchasing.core;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TransactionDetails {
    private String currency;
    private Map<String, Object> extras;
    private BigDecimal price;
    private String productId;
    private String receipt;
    private String transactionId;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String currency;
        /* access modifiers changed from: private */
        public Map<String, Object> extras;
        /* access modifiers changed from: private */
        public BigDecimal price;
        /* access modifiers changed from: private */
        public String productId;
        /* access modifiers changed from: private */
        public String receipt;
        /* access modifiers changed from: private */
        public String transactionId;

        private Builder() {
            this.extras = new HashMap();
        }

        public Builder withProductId(String str) {
            this.productId = str;
            return this;
        }

        public Builder withTransactionId(String str) {
            this.transactionId = str;
            return this;
        }

        public Builder withReceipt(String str) {
            this.receipt = str;
            return this;
        }

        public Builder withPrice(BigDecimal bigDecimal) {
            this.price = bigDecimal;
            return this;
        }

        public Builder withPrice(double d) {
            this.price = new BigDecimal(d);
            return this;
        }

        public Builder withCurrency(String str) {
            this.currency = str;
            return this;
        }

        public Builder putExtra(String str, Object obj) {
            this.extras.put(str, obj);
            return this;
        }

        public TransactionDetails build() {
            return new TransactionDetails(this);
        }
    }

    private TransactionDetails(Builder builder) {
        this.productId = builder.productId;
        this.transactionId = builder.transactionId;
        this.receipt = builder.receipt;
        this.extras = builder.extras;
        this.price = builder.price;
        this.currency = builder.currency;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public String getReceipt() {
        return this.receipt;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getCurrency() {
        return this.currency;
    }

    public Map<String, Object> getExtras() {
        return this.extras;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
