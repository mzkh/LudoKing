package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzamf extends zzfn implements zzamd {
    zzamf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzua zzua, zzame zzame) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        obtainAndWriteInterfaceToken.writeString(str);
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) bundle);
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) bundle2);
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzua);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzame);
        zza(1, obtainAndWriteInterfaceToken);
    }

    public final zzamr zzsg() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        zzamr zzamr = (zzamr) zzfp.zza(transactAndReadException, zzamr.CREATOR);
        transactAndReadException.recycle();
        return zzamr;
    }

    public final zzamr zzsh() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
        zzamr zzamr = (zzamr) zzfp.zza(transactAndReadException, zzamr.CREATOR);
        transactAndReadException.recycle();
        return zzamr;
    }

    public final zzwr getVideoController() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
        zzwr zzi = zzwq.zzi(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzi;
    }

    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(10, obtainAndWriteInterfaceToken);
    }

    public final void zza(String[] strArr, Bundle[] bundleArr) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeStringArray(strArr);
        obtainAndWriteInterfaceToken.writeTypedArray(bundleArr, 0);
        zza(11, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, String str2, zztx zztx, IObjectWrapper iObjectWrapper, zzalr zzalr, zzakd zzakd, zzua zzua) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zztx);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzalr);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzakd);
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzua);
        zza(13, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, String str2, zztx zztx, IObjectWrapper iObjectWrapper, zzals zzals, zzakd zzakd) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zztx);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzals);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzakd);
        zza(14, obtainAndWriteInterfaceToken);
    }

    public final boolean zzac(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(15, obtainAndWriteInterfaceToken);
        boolean zza = zzfp.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }

    public final void zza(String str, String str2, zztx zztx, IObjectWrapper iObjectWrapper, zzaly zzaly, zzakd zzakd) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zztx);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzaly);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzakd);
        zza(16, obtainAndWriteInterfaceToken);
    }

    public final boolean zzad(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(17, obtainAndWriteInterfaceToken);
        boolean zza = zzfp.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }

    public final void zza(String str, String str2, zztx zztx, IObjectWrapper iObjectWrapper, zzalx zzalx, zzakd zzakd) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zztx);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzalx);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzakd);
        zza(18, obtainAndWriteInterfaceToken);
    }

    public final void zzdh(String str) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zza(19, obtainAndWriteInterfaceToken);
    }
}
