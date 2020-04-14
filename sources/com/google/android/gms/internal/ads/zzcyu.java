package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface zzcyu extends IInterface {
    String getVersion() throws RemoteException;

    IObjectWrapper zza(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5) throws RemoteException;

    void zzae(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzaf(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzau(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzd(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    void zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;
}
