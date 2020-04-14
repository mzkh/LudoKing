package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaki extends zzfn implements zzakg {
    zzaki(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    public final String getHeadline() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    public final List getImages() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
        ArrayList zzb = zzfp.zzb(transactAndReadException);
        transactAndReadException.recycle();
        return zzb;
    }

    public final String getBody() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    public final zzabi zzqn() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
        zzabi zzm = zzabl.zzm(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzm;
    }

    public final String getCallToAction() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    public final double getStarRating() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken());
        double readDouble = transactAndReadException.readDouble();
        transactAndReadException.recycle();
        return readDouble;
    }

    public final String getStore() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    public final String getPrice() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    public final void recordImpression() throws RemoteException {
        zza(10, obtainAndWriteInterfaceToken());
    }

    public final void zzy(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(11, obtainAndWriteInterfaceToken);
    }

    public final void zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(12, obtainAndWriteInterfaceToken);
    }

    public final boolean getOverrideImpressionRecording() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(13, obtainAndWriteInterfaceToken());
        boolean zza = zzfp.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }

    public final boolean getOverrideClickHandling() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(14, obtainAndWriteInterfaceToken());
        boolean zza = zzfp.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }

    public final Bundle getExtras() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(15, obtainAndWriteInterfaceToken());
        Bundle bundle = (Bundle) zzfp.zza(transactAndReadException, Bundle.CREATOR);
        transactAndReadException.recycle();
        return bundle;
    }

    public final void zzaa(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(16, obtainAndWriteInterfaceToken);
    }

    public final zzwr getVideoController() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(17, obtainAndWriteInterfaceToken());
        zzwr zzi = zzwq.zzi(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzi;
    }

    public final IObjectWrapper zzry() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(18, obtainAndWriteInterfaceToken());
        IObjectWrapper asInterface = Stub.asInterface(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return asInterface;
    }

    public final zzaba zzqo() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(19, obtainAndWriteInterfaceToken());
        zzaba zzl = zzabd.zzl(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzl;
    }

    public final IObjectWrapper zzrz() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(20, obtainAndWriteInterfaceToken());
        IObjectWrapper asInterface = Stub.asInterface(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzqp() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(21, obtainAndWriteInterfaceToken());
        IObjectWrapper asInterface = Stub.asInterface(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return asInterface;
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper2);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper3);
        zza(22, obtainAndWriteInterfaceToken);
    }
}
