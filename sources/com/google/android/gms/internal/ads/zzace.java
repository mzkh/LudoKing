package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface zzace extends IInterface {
    void destroy() throws RemoteException;

    List<String> getAvailableAssetNames() throws RemoteException;

    String getCustomTemplateId() throws RemoteException;

    zzwr getVideoController() throws RemoteException;

    void performClick(String str) throws RemoteException;

    void recordImpression() throws RemoteException;

    String zzco(String str) throws RemoteException;

    zzabi zzcp(String str) throws RemoteException;

    IObjectWrapper zzqm() throws RemoteException;

    IObjectWrapper zzqr() throws RemoteException;

    boolean zzqs() throws RemoteException;

    boolean zzqt() throws RemoteException;

    void zzqu() throws RemoteException;

    boolean zzu(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzv(IObjectWrapper iObjectWrapper) throws RemoteException;
}
