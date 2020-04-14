package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzahb implements Runnable {
    private final String zzczh;

    zzahb(String str) {
        this.zzczh = str;
    }

    public final void run() {
        zzq.zzkn().zzub().zzcm(this.zzczh.substring(1));
    }
}
