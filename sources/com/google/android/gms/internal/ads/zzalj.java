package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzalj implements Runnable {
    private final /* synthetic */ zzala zzden;

    zzalj(zzala zzala) {
        this.zzden = zzala;
    }

    public final void run() {
        try {
            this.zzden.zzdea.onAdOpened();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }
}
