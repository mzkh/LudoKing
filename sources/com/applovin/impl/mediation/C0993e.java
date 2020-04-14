package com.applovin.impl.mediation;

/* renamed from: com.applovin.impl.mediation.e */
public class C0993e {
    public static final C0993e EMPTY = new C0993e(0);
    private final int errorCode;
    private final String errorMessage;

    public C0993e(int i) {
        this(i, "");
    }

    public C0993e(int i, String str) {
        this.errorCode = i;
        this.errorMessage = str;
    }

    public C0993e(String str) {
        this(-1, str);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MaxError{errorCode=");
        sb.append(getErrorCode());
        sb.append(", errorMessage='");
        sb.append(getErrorMessage());
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
