package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzajw extends zzfm implements zzajx {
    public zzajw() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzajx zzaa(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzajx) {
            return (zzajx) queryLocalInterface;
        }
        return new zzajz(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzajy zzcz = zzcz(parcel.readString());
            parcel2.writeNoException();
            zzfp.zza(parcel2, (IInterface) zzcz);
        } else if (i == 2) {
            boolean zzda = zzda(parcel.readString());
            parcel2.writeNoException();
            zzfp.writeBoolean(parcel2, zzda);
        } else if (i != 3) {
            return false;
        } else {
            zzamd zzdd = zzdd(parcel.readString());
            parcel2.writeNoException();
            zzfp.zza(parcel2, (IInterface) zzdd);
        }
        return true;
    }
}
