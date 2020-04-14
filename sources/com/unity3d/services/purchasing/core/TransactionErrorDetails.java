package com.unity3d.services.purchasing.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TransactionErrorDetails {
    private String exceptionMessage;
    private Map<String, Object> extras;
    private Store store;
    private String storeSpecificErrorCode;
    private TransactionError transactionError;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String exceptionMessage;
        /* access modifiers changed from: private */
        public Map<String, Object> extras;
        /* access modifiers changed from: private */
        public Store store;
        /* access modifiers changed from: private */
        public String storeSpecificErrorCode;
        /* access modifiers changed from: private */
        public TransactionError transactionError;

        private Builder() {
            this.extras = new HashMap();
        }

        public Builder withTransactionError(TransactionError transactionError2) {
            this.transactionError = transactionError2;
            return this;
        }

        public Builder withExceptionMessage(String str) {
            this.exceptionMessage = str;
            return this;
        }

        public Builder withStore(Store store2) {
            this.store = store2;
            return this;
        }

        public Builder withStoreSpecificErrorCode(String str) {
            this.storeSpecificErrorCode = str;
            return this;
        }

        public Builder putExtras(Map<String, Object> map) {
            for (Entry entry : map.entrySet()) {
                this.extras.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder putExtra(String str, Object obj) {
            this.extras.put(str, obj);
            return this;
        }

        public TransactionErrorDetails build() {
            return new TransactionErrorDetails(this);
        }
    }

    private TransactionErrorDetails(Builder builder) {
        this.transactionError = builder.transactionError;
        this.exceptionMessage = builder.exceptionMessage;
        this.store = builder.store;
        this.storeSpecificErrorCode = builder.storeSpecificErrorCode;
        this.extras = builder.extras;
    }

    public TransactionError getTransactionError() {
        return this.transactionError;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }

    public Store getStore() {
        return this.store;
    }

    public String getStoreSpecificErrorCode() {
        return this.storeSpecificErrorCode;
    }

    public Map<String, Object> getExtras() {
        return this.extras;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
