package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface zzabm extends IInterface {
    void destroy() throws RemoteException;

    void zza(zzabh zzabh) throws RemoteException;

    void zzc(IObjectWrapper iObjectWrapper, int i) throws RemoteException;

    void zzc(String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzcj(String str) throws RemoteException;

    void zze(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzk(IObjectWrapper iObjectWrapper) throws RemoteException;
}
