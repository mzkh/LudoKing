package com.tapjoy;

public class TapjoyErrorMessage {

    /* renamed from: a */
    private ErrorType f6582a;

    /* renamed from: b */
    private String f6583b;

    public enum ErrorType {
        INTERNAL_ERROR,
        SDK_ERROR,
        SERVER_ERROR,
        INTEGRATION_ERROR,
        NETWORK_ERROR
    }

    public TapjoyErrorMessage(ErrorType errorType, String str) {
        this.f6582a = errorType;
        this.f6583b = str;
    }

    public ErrorType getType() {
        return this.f6582a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("Type=");
        sb2.append(this.f6582a.toString());
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder(";Message=");
        sb3.append(this.f6583b);
        sb.append(sb3.toString());
        return sb.toString();
    }
}
