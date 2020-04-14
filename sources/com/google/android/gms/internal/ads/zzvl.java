package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface zzvl extends IInterface {
    void destroy() throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getAdUnitId() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzwr getVideoController() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setManualImpressionsEnabled(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    void zza(zzaah zzaah) throws RemoteException;

    void zza(zzant zzant) throws RemoteException;

    void zza(zzanz zzanz, String str) throws RemoteException;

    void zza(zzaqi zzaqi) throws RemoteException;

    void zza(zzqx zzqx) throws RemoteException;

    void zza(zzua zzua) throws RemoteException;

    void zza(zzuf zzuf) throws RemoteException;

    void zza(zzux zzux) throws RemoteException;

    void zza(zzuy zzuy) throws RemoteException;

    void zza(zzvo zzvo) throws RemoteException;

    void zza(zzvt zzvt) throws RemoteException;

    void zza(zzvz zzvz) throws RemoteException;

    void zza(zzwx zzwx) throws RemoteException;

    void zza(zzyj zzyj) throws RemoteException;

    boolean zza(zztx zztx) throws RemoteException;

    void zzbm(String str) throws RemoteException;

    IObjectWrapper zzjr() throws RemoteException;

    void zzjs() throws RemoteException;

    zzua zzjt() throws RemoteException;

    String zzju() throws RemoteException;

    zzvt zzjv() throws RemoteException;

    zzuy zzjw() throws RemoteException;
}
