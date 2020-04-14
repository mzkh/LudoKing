package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzvg extends zzfn implements zzve {
    zzvg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    public final zzvd zzor() throws RemoteException {
        zzvd zzvd;
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzvd = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            if (queryLocalInterface instanceof zzvd) {
                zzvd = (zzvd) queryLocalInterface;
            } else {
                zzvd = new zzvf(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzvd;
    }

    public final void zzb(zzuy zzuy) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzuy);
        zza(2, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzaci zzaci) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzaci);
        zza(3, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzacn zzacn) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzacn);
        zza(4, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, zzact zzact, zzaco zzaco) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzact);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzaco);
        zza(5, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzaay zzaay) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzaay);
        zza(6, obtainAndWriteInterfaceToken);
    }

    public final void zzb(zzvz zzvz) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzvz);
        zza(7, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzacu zzacu, zzua zzua) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzacu);
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzua);
        zza(8, obtainAndWriteInterfaceToken);
    }

    public final void zza(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) publisherAdViewOptions);
        zza(9, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzacz zzacz) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzacz);
        zza(10, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzagd zzagd) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzagd);
        zza(13, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzagj zzagj) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzagj);
        zza(14, obtainAndWriteInterfaceToken);
    }
}
