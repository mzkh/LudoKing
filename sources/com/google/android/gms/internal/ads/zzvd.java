package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface zzvd extends IInterface {
    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoading() throws RemoteException;

    void zza(zztx zztx, int i) throws RemoteException;

    void zzb(zztx zztx) throws RemoteException;

    String zzju() throws RemoteException;
}
