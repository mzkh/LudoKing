package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzlm implements Runnable {
    private final /* synthetic */ zzli zzazs;
    private final /* synthetic */ IOException zzbay;

    zzlm(zzli zzli, IOException iOException) {
        this.zzazs = zzli;
        this.zzbay = iOException;
    }

    public final void run() {
        this.zzazs.zzazu.zzb(this.zzbay);
    }
}
