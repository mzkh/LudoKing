package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzds extends zzb implements zzdr {
    public zzds() {
        super("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zza((zzer) zzc.zza(parcel, zzer.CREATOR));
        } else if (i == 3) {
            zza((zzet) zzc.zza(parcel, zzet.CREATOR));
        } else if (i != 4) {
            return false;
        } else {
            zza((zzfd) zzc.zza(parcel, zzfd.CREATOR));
        }
        return true;
    }
}
