package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface zzwb extends IInterface {
    String getVersionString() throws RemoteException;

    void initialize() throws RemoteException;

    void setAppMuted(boolean z) throws RemoteException;

    void setAppVolume(float f) throws RemoteException;

    void zza(zzafu zzafu) throws RemoteException;

    void zza(zzajx zzajx) throws RemoteException;

    void zza(zzyd zzyd) throws RemoteException;

    void zzb(String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzby(String str) throws RemoteException;

    void zzbz(String str) throws RemoteException;

    void zzc(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    float zzos() throws RemoteException;

    boolean zzot() throws RemoteException;

    List<zzafr> zzou() throws RemoteException;
}
