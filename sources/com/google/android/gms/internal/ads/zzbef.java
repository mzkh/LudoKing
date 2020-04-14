package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzbef extends zzfn implements zzbed {
    zzbef(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.measurement.IMeasurementManager");
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzbeb zzbeb) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzbeb);
        zza(2, obtainAndWriteInterfaceToken);
    }
}
