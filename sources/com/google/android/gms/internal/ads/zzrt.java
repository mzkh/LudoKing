package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzrt extends zzfn implements zzru {
    zzrt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final zzro zza(zzrp zzrp) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzrp);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzro zzro = (zzro) zzfp.zza(transactAndReadException, zzro.CREATOR);
        transactAndReadException.recycle();
        return zzro;
    }
}
