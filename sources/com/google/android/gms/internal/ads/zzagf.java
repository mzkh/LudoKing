package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface zzagf extends IInterface {
    void destroy() throws RemoteException;

    zzwr getVideoController() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzagh zzagh) throws RemoteException;
}
