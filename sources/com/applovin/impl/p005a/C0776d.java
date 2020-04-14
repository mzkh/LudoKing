package com.applovin.impl.p005a;

import com.google.android.gms.nearby.messages.Strategy;

/* renamed from: com.applovin.impl.a.d */
public enum C0776d {
    UNSPECIFIED(-1),
    XML_PARSING(100),
    GENERAL_WRAPPER_ERROR(Strategy.TTL_SECONDS_DEFAULT),
    TIMED_OUT(301),
    WRAPPER_LIMIT_REACHED(302),
    NO_WRAPPER_RESPONSE(303),
    GENERAL_LINEAR_ERROR(400),
    NO_MEDIA_FILE_PROVIDED(401),
    MEDIA_FILE_TIMEOUT(402),
    MEDIA_FILE_ERROR(405),
    GENERAL_COMPANION_AD_ERROR(600),
    UNABLE_TO_FETCH_COMPANION_AD_RESOURCE(603),
    CAN_NOT_FIND_COMPANION_AD_RESOURCE(604);
    

    /* renamed from: n */
    private final int f1276n;

    private C0776d(int i) {
        this.f1276n = i;
    }

    /* renamed from: a */
    public int mo8929a() {
        return this.f1276n;
    }
}
