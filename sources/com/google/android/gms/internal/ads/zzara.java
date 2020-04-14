package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface zzara extends IInterface {
    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoaded() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException;

    void zza(zzarb zzarb) throws RemoteException;

    void zza(zzarj zzarj) throws RemoteException;

    void zza(zzarr zzarr) throws RemoteException;

    void zza(zztx zztx, zzari zzari) throws RemoteException;

    void zza(zzwm zzwm) throws RemoteException;

    void zzl(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzaqv zzpk() throws RemoteException;
}
