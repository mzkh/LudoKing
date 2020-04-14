package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzxw extends zzaqz {
    public final String getMediationAdapterClassName() throws RemoteException {
        return "";
    }

    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    public final void zza(IObjectWrapper iObjectWrapper, boolean z) {
    }

    public final void zza(zzarb zzarb) throws RemoteException {
    }

    public final void zza(zzarj zzarj) throws RemoteException {
    }

    public final void zza(zzarr zzarr) {
    }

    public final void zza(zzwm zzwm) throws RemoteException {
    }

    public final void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Nullable
    public final zzaqv zzpk() {
        return null;
    }

    public final void zza(zztx zztx, zzari zzari) throws RemoteException {
        zzaxi.zzes("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzawy.zzzb.post(new zzxz(zzari));
    }

    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }
}
