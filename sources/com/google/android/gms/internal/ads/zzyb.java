package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzyb implements Runnable {
    private final /* synthetic */ zzxy zzcfn;

    zzyb(zzxy zzxy) {
        this.zzcfn = zzxy;
    }

    public final void run() {
        if (this.zzcfn.zzcfk != null) {
            try {
                this.zzcfn.zzcfk.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaxi.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
