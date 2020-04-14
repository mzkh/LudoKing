package com.google.android.gms.internal.ads;

import android.os.Trace;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzog {
    public static void beginSection(String str) {
        if (zzof.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (zzof.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
