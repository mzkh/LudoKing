package com.iab.omid.library.inmobi.adsession;

import com.facebook.share.internal.MessengerShareContentUtility;

public enum ErrorType {
    GENERIC(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE),
    VIDEO("video");
    
    private final String errorType;

    private ErrorType(String str) {
        this.errorType = str;
    }

    public final String toString() {
        return this.errorType;
    }
}
