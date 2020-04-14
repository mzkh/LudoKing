package com.tapjoy.internal;

import com.tapjoy.TJSpendCurrencyListener;

public class TJSpendCurrencyListenerNative implements TJSpendCurrencyListener {

    /* renamed from: a */
    private final long f6608a;

    private static native void onSpendCurrencyResponseFailureNative(long j, String str);

    private static native void onSpendCurrencyResponseNative(long j, String str, int i);

    private TJSpendCurrencyListenerNative(long j) {
        if (j != 0) {
            this.f6608a = j;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void onSpendCurrencyResponse(String str, int i) {
        onSpendCurrencyResponseNative(this.f6608a, str, i);
    }

    public void onSpendCurrencyResponseFailure(String str) {
        onSpendCurrencyResponseFailureNative(this.f6608a, str);
    }

    @C1821ft
    static Object create(long j) {
        return new TJSpendCurrencyListenerNative(j);
    }
}
