package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzati extends zzfm implements zzatf {
    public zzati() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzatd zzatd;
        if (i != 1) {
            return false;
        }
        IObjectWrapper asInterface = Stub.asInterface(parcel.readStrongBinder());
        zzath zzath = (zzath) zzfp.zza(parcel, zzath.CREATOR);
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzatd = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
            if (queryLocalInterface instanceof zzatd) {
                zzatd = (zzatd) queryLocalInterface;
            } else {
                zzatd = new zzatg(readStrongBinder);
            }
        }
        zza(asInterface, zzath, zzatd);
        parcel2.writeNoException();
        return true;
    }
}
