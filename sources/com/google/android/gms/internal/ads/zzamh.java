package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzamh extends zzfm implements zzame {
    public zzamh() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzdi(parcel.readString());
        } else if (i != 2) {
            return false;
        } else {
            onFailure(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
