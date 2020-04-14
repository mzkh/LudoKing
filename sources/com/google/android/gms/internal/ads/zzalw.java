package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzalw extends zzfm implements zzalx {
    public zzalw() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza(zzakp.zzac(parcel.readStrongBinder()));
        } else if (i != 2) {
            return false;
        } else {
            zzdg(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
