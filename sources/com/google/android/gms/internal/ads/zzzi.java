package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzzi extends zzfn implements zzzg {
    zzzi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.consent.IConsentSdkUtil");
    }

    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(2, obtainAndWriteInterfaceToken);
    }

    public final void zza(Bundle bundle, zzzf zzzf) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) bundle);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzzf);
        zza(3, obtainAndWriteInterfaceToken);
    }
}
