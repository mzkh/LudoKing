package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final /* synthetic */ class zzxz implements Runnable {
    private final zzari zzcfl;

    zzxz(zzari zzari) {
        this.zzcfl = zzari;
    }

    public final void run() {
        zzari zzari = this.zzcfl;
        if (zzari != null) {
            try {
                zzari.onRewardedAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaxi.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
