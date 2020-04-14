package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzxr implements Runnable {
    private final /* synthetic */ zzxo zzcfg;

    zzxr(zzxo zzxo) {
        this.zzcfg = zzxo;
    }

    public final void run() {
        if (this.zzcfg.zzcff.zzblp != null) {
            try {
                this.zzcfg.zzcff.zzblp.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaxi.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
