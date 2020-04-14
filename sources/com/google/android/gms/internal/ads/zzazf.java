package com.google.android.gms.internal.ads;

import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzazf implements Runnable {
    zzazf(zzazg zzazg) {
    }

    public final void run() {
        Looper.myLooper().quit();
    }
}
