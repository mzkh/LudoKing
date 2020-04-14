package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface zzaqb extends IInterface {
    void destroy() throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoaded() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setAppPackageName(String str) throws RemoteException;

    void setCustomData(String str) throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void show() throws RemoteException;

    void zza(zzapz zzapz) throws RemoteException;

    void zza(zzaqi zzaqi) throws RemoteException;

    void zza(zzaqo zzaqo) throws RemoteException;

    void zza(zzvo zzvo) throws RemoteException;

    void zzm(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzn(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzo(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzp(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzpl() throws RemoteException;
}
