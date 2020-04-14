package com.applovin.mediation.adapter;

import com.applovin.impl.mediation.C0993e;

public class MaxAdapterError extends C0993e {
    public static final MaxAdapterError AD_EXPIRED = new MaxAdapterError(ERROR_CODE_AD_EXPIRED);
    public static final MaxAdapterError AD_FREQUENCY_CAPPED = new MaxAdapterError(ERROR_CODE_AD_FREQUENCY_CAPPED);
    public static final MaxAdapterError AD_NOT_READY = new MaxAdapterError(ERROR_CODE_AD_NOT_READY);
    public static final MaxAdapterError BAD_REQUEST = new MaxAdapterError(ERROR_CODE_BAD_REQUEST);
    public static final int ERROR_CODE_AD_EXPIRED = -5213;
    public static final int ERROR_CODE_AD_FREQUENCY_CAPPED = -5214;
    public static final int ERROR_CODE_AD_NOT_READY = -5205;
    public static final int ERROR_CODE_BAD_REQUEST = -5203;
    public static final int ERROR_CODE_INTERNAL_ERROR = -5209;
    public static final int ERROR_CODE_INVALID_CONFIGURATION = -5202;
    public static final int ERROR_CODE_INVALID_LOAD_STATE = -5201;
    public static final int ERROR_CODE_NOT_INITIALIZED = -5204;
    public static final int ERROR_CODE_NO_CONNECTION = -5207;
    public static final int ERROR_CODE_NO_FILL = 204;
    public static final int ERROR_CODE_REWARD_ERROR = -5302;
    public static final int ERROR_CODE_SERVER_ERROR = -5208;
    public static final int ERROR_CODE_SIGNAL_COLLECTION_NOT_SUPPORTED = -5211;
    public static final int ERROR_CODE_SIGNAL_COLLECTION_TIMEOUT = -5210;
    public static final int ERROR_CODE_TIMEOUT = -5206;
    public static final int ERROR_CODE_UNSPECIFIED = -5200;
    public static final int ERROR_CODE_WEBVIEW_ERROR = -5212;
    public static final MaxAdapterError INTERNAL_ERROR = new MaxAdapterError(ERROR_CODE_INTERNAL_ERROR);
    public static final MaxAdapterError INVALID_CONFIGURATION = new MaxAdapterError(ERROR_CODE_INVALID_CONFIGURATION);
    public static final MaxAdapterError INVALID_LOAD_STATE = new MaxAdapterError(-5201);
    public static final MaxAdapterError NOT_INITIALIZED = new MaxAdapterError(ERROR_CODE_NOT_INITIALIZED);
    public static final MaxAdapterError NO_CONNECTION = new MaxAdapterError(ERROR_CODE_NO_CONNECTION);
    public static final MaxAdapterError NO_FILL = new MaxAdapterError(204);
    public static final MaxAdapterError REWARD_ERROR = new MaxAdapterError(ERROR_CODE_REWARD_ERROR);
    public static final MaxAdapterError SERVER_ERROR = new MaxAdapterError(ERROR_CODE_SERVER_ERROR);
    public static final MaxAdapterError SIGNAL_COLLECTION_NOT_SUPPORTED = new MaxAdapterError(ERROR_CODE_SIGNAL_COLLECTION_NOT_SUPPORTED);
    public static final MaxAdapterError SIGNAL_COLLECTION_TIMEOUT = new MaxAdapterError(ERROR_CODE_SIGNAL_COLLECTION_TIMEOUT);
    public static final MaxAdapterError TIMEOUT = new MaxAdapterError(ERROR_CODE_TIMEOUT);
    public static final MaxAdapterError UNSPECIFIED = new MaxAdapterError(ERROR_CODE_UNSPECIFIED);
    public static final MaxAdapterError WEBVIEW_ERROR = new MaxAdapterError(ERROR_CODE_WEBVIEW_ERROR);
    private final int thirdPartySdkErrorCode;
    private final String thirdPartySdkErrorMessage;

    public MaxAdapterError(int i) {
        String str = "";
        this(i, str, 0, str);
    }

    public MaxAdapterError(int i, int i2) {
        String str = "";
        this(i, str, i2, str);
    }

    public MaxAdapterError(int i, String str) {
        this(i, str, 0, "");
    }

    public MaxAdapterError(int i, String str, int i2, String str2) {
        super(i, str);
        this.thirdPartySdkErrorCode = i2;
        this.thirdPartySdkErrorMessage = str2;
    }

    public int getThirdPartySdkErrorCode() {
        return this.thirdPartySdkErrorCode;
    }

    public String getThirdPartySdkErrorMessage() {
        return this.thirdPartySdkErrorMessage;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MaxAdapterError{errorCode=");
        sb.append(getErrorCode());
        sb.append(", errorMessage='");
        sb.append(getErrorMessage());
        sb.append('\'');
        sb.append(", thirdPartySdkErrorCode=");
        sb.append(this.thirdPartySdkErrorCode);
        sb.append(", thirdPartySdkErrorMessage='");
        sb.append(this.thirdPartySdkErrorMessage);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
