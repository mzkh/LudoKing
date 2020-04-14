package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbbx implements Runnable {
    private final String zzczh;

    zzbbx(String str) {
        this.zzczh = str;
    }

    public final void run() {
        zzq.zzkn().zzub().zzcm(this.zzczh.substring(1));
    }
}
