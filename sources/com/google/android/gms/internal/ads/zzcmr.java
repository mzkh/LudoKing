package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcmr implements zzbnb {
    private final zzcmi zzgdb;
    private final zzagj zzgdc;

    zzcmr(zzcmi zzcmi, zzagj zzagj) {
        this.zzgdb = zzcmi;
        this.zzgdc = zzagj;
    }

    public final void onAdFailedToLoad(int i) {
        zzcmi zzcmi = this.zzgdb;
        zzagj zzagj = this.zzgdc;
        zzcmi.onAdFailedToLoad(i);
        if (zzagj != null) {
            try {
                zzagj.zzck(i);
            } catch (RemoteException e) {
                zzaxi.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
