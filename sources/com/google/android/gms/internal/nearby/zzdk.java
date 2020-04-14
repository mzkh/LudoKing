package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzdk extends zzb implements zzdj {
    public zzdk() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zza((zzeh) zzc.zza(parcel, zzeh.CREATOR));
        } else if (i == 3) {
            zza((zzen) zzc.zza(parcel, zzen.CREATOR));
        } else if (i == 4) {
            zza((zzep) zzc.zza(parcel, zzep.CREATOR));
        } else if (i != 5) {
            return false;
        } else {
            zza((zzef) zzc.zza(parcel, zzef.CREATOR));
        }
        return true;
    }
}
