package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaot extends zzfn implements zzaor {
    zzaot(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final zzaon zza(zzaol zzaol) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzaol);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzaon zzaon = (zzaon) zzfp.zza(transactAndReadException, zzaon.CREATOR);
        transactAndReadException.recycle();
        return zzaon;
    }

    public final void zza(zzaol zzaol, zzaow zzaow) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzaol);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzaow);
        zza(2, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzape zzape, zzaoy zzaoy) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzape);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzaoy);
        zza(4, obtainAndWriteInterfaceToken);
    }

    public final void zzb(zzape zzape, zzaoy zzaoy) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzape);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzaoy);
        zza(5, obtainAndWriteInterfaceToken);
    }
}
