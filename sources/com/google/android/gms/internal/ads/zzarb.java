package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface zzarb extends IInterface {
    void onRewardedAdClosed() throws RemoteException;

    void onRewardedAdFailedToShow(int i) throws RemoteException;

    void onRewardedAdOpened() throws RemoteException;

    void zza(zzaqv zzaqv) throws RemoteException;
}
