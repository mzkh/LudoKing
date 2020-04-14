package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzxy extends zzaqe {
    /* access modifiers changed from: private */
    public zzaqi zzcfk;

    public final void destroy() throws RemoteException {
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    public final void pause() throws RemoteException {
    }

    public final void resume() throws RemoteException {
    }

    public final void setAppPackageName(String str) {
    }

    public final void setCustomData(String str) throws RemoteException {
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    public final void setUserId(String str) throws RemoteException {
    }

    public final void show() throws RemoteException {
    }

    public final void zza(zzapz zzapz) throws RemoteException {
    }

    public final void zza(zzvo zzvo) throws RemoteException {
    }

    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final boolean zzpl() {
        return false;
    }

    public final void zza(zzaqo zzaqo) throws RemoteException {
        zzaxi.zzes("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzawy.zzzb.post(new zzyb(this));
    }

    public final void zza(zzaqi zzaqi) throws RemoteException {
        this.zzcfk = zzaqi;
    }

    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }
}
