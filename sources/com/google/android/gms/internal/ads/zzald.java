package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzald implements Runnable {
    private final /* synthetic */ zzala zzden;

    zzald(zzala zzala) {
        this.zzden = zzala;
    }

    public final void run() {
        try {
            this.zzden.zzdea.onAdClicked();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }
}
