package com.tapjoy.internal;

import com.tapjoy.TJConnectListener;

public class TJConnectListenerNative implements TJConnectListener {

    /* renamed from: a */
    private final long f6604a;

    private static native void onConnectFailureNative(long j);

    private static native void onConnectSuccessNative(long j);

    private TJConnectListenerNative(long j) {
        if (j != 0) {
            this.f6604a = j;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void onConnectSuccess() {
        onConnectSuccessNative(this.f6604a);
    }

    public void onConnectFailure() {
        onConnectFailureNative(this.f6604a);
    }

    @C1821ft
    static Object create(long j) {
        return new TJConnectListenerNative(j);
    }
}
