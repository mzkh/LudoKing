package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface zzzf extends IInterface {
    void onFailure(int i) throws RemoteException;

    void onSuccess(String str) throws RemoteException;
}
