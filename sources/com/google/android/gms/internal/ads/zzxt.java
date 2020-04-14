package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzxt implements Runnable {
    private final /* synthetic */ zzxq zzcfi;

    zzxt(zzxq zzxq) {
        this.zzcfi = zzxq;
    }

    public final void run() {
        if (this.zzcfi.zzblp != null) {
            try {
                this.zzcfi.zzblp.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaxi.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
