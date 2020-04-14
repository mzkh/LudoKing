package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzafx extends zzfm implements zzafu {
    public zzafx() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzafu zzy(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        if (queryLocalInterface instanceof zzafu) {
            return (zzafu) queryLocalInterface;
        }
        return new zzafw(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzc(parcel.createTypedArrayList(zzafr.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
