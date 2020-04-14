package com.tapjoy.internal;

import com.tapjoy.TJAwardCurrencyListener;

public class TJAwardCurrencyListenerNative implements TJAwardCurrencyListener {

    /* renamed from: a */
    private final long f6603a;

    private static native void onAwardCurrencyResponseFailureNative(long j, String str);

    private static native void onAwardCurrencyResponseNative(long j, String str, int i);

    private TJAwardCurrencyListenerNative(long j) {
        if (j != 0) {
            this.f6603a = j;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void onAwardCurrencyResponse(String str, int i) {
        onAwardCurrencyResponseNative(this.f6603a, str, i);
    }

    public void onAwardCurrencyResponseFailure(String str) {
        onAwardCurrencyResponseFailureNative(this.f6603a, str);
    }

    @C1821ft
    static Object create(long j) {
        return new TJAwardCurrencyListenerNative(j);
    }
}
