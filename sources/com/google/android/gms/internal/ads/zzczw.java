package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
public final class zzczw extends zzfn implements zzczx {
    zzczw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzczv zza(zzczt zzczt) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzczt);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzczv zzczv = (zzczv) zzfp.zza(transactAndReadException, zzczv.CREATOR);
        transactAndReadException.recycle();
        return zzczv;
    }

    public final void zza(zzczo zzczo) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzczo);
        zza(2, obtainAndWriteInterfaceToken);
    }
}
