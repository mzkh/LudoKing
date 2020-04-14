package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzdx extends zzb implements zzdw {
    public zzdx() {
        super("com.google.android.gms.nearby.internal.connection.IPayloadListener");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zza((zzev) zzc.zza(parcel, zzev.CREATOR));
        } else if (i != 3) {
            return false;
        } else {
            zza((zzex) zzc.zza(parcel, zzex.CREATOR));
        }
        return true;
    }
}
