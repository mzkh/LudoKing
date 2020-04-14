package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbov implements Runnable {
    private final WeakReference<zzbou> zzfhf;

    private zzbov(zzbou zzbou) {
        this.zzfhf = new WeakReference<>(zzbou);
    }

    public final void run() {
        zzbou zzbou = (zzbou) this.zzfhf.get();
        if (zzbou != null) {
            zzbou.zzagb();
        }
    }
}
