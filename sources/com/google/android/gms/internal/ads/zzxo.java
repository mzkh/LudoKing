package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzxo extends zzvc {
    final /* synthetic */ zzxm zzcff;

    private zzxo(zzxm zzxm) {
        this.zzcff = zzxm;
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    public final boolean isLoading() throws RemoteException {
        return false;
    }

    public final String zzju() throws RemoteException {
        return null;
    }

    public final void zzb(zztx zztx) throws RemoteException {
        zza(zztx, 1);
    }

    public final void zza(zztx zztx, int i) throws RemoteException {
        zzaxi.zzes("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzawy.zzzb.post(new zzxr(this));
    }
}
