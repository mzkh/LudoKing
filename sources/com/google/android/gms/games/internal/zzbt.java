package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.games.zzb;
import com.google.android.gms.internal.games.zzc;

public abstract class zzbt extends zzb implements zzbs {
    public zzbt() {
        super("com.google.android.gms.games.internal.IGamesClient");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1001) {
            return false;
        }
        zzbw zzas = zzas();
        parcel2.writeNoException();
        zzc.zzb(parcel2, zzas);
        return true;
    }
}
